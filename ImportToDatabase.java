import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Random;

public class ImportToDatabase {
    public static void main(String[] args) {
        fetchAndDisplayPlayerStats();
    }

    private static void fetchAndDisplayPlayerStats() {
        PlayerStatsList playerStatsList = new PlayerStatsList();
        ArrayList<PlayerStats> playerStats = playerStatsList.getPlayerStatsList();

        for (PlayerStats stats : playerStats) {
            System.out.println("Player: " + stats.player.first_name + " " + stats.player.last_name);
            System.out.println("Points: " + stats.pts);
            System.out.println("Assists: " + stats.ast);
            System.out.println("Rebounds: " + stats.reb);
            System.out.println("Steals: " + stats.stl);
            System.out.println("Blocks: " + stats.blk);
            System.out.println("----------------------------------");
        }

        // Database connection parameters
        String jdbcURL = "jdbc:mysql://localhost:3308/test";
        String username = "root";
        String password = "";

        // Import player statistics into database
        importPlayerStatsToDatabase(playerStats, jdbcURL, username, password);
    }

    private static void importPlayerStatsToDatabase(ArrayList<PlayerStats> playerStats, String jdbcURL, String username, String password) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            createTableIfNotExists(connection, "Players");

            String insertQuery = "INSERT INTO Players (player_id, name, height, weight, position, salary, points, rebounds, assists, steals, blocks) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            for (PlayerStats stats : playerStats) {
                try {
                    // Convert height from feet to centimeters
                    double heightInCm = 0.0; // Default value
                    if (stats.player.height != null) {
                        String[] heightParts = stats.player.height.split("-");
                        int feet = Integer.parseInt(heightParts[0]);
                        int inches = Integer.parseInt(heightParts[1]);
                        heightInCm = (feet * 30.48) + (inches * 2.54); // Convert feet to cm and add inches in cm
                    }

                    // Convert weight from pounds to kilograms
                    double weightInKg = 0.0; // Default value
                    if (stats.player.weight != null) {
                        weightInKg = Double.parseDouble(stats.player.weight) * 0.453592; // Convert pounds to kilograms
                    }

                    // Calculate salary based on points
                    int salary;
                    Random r = new Random();
                    if (stats.pts > 20) {
                        salary = r.nextInt(4500 - 3000 + 1) + 3000;
                    } else {
                        salary = r.nextInt(2500-1000+1) + 1000;
                    }

                    preparedStatement.setInt(1, stats.player_id);
                    preparedStatement.setString(2, stats.player.first_name + " " + stats.player.last_name);
                    preparedStatement.setString(3, String.format("%.2f", heightInCm)); // Format height to two decimal places in cm
                    preparedStatement.setString(4, String.format("%.2f", weightInKg)); // Format weight to two decimal places in kg
                    preparedStatement.setString(5, stats.player.position);
                    preparedStatement.setInt(6, salary);
                    preparedStatement.setInt(7, stats.pts);
                    preparedStatement.setInt(8, stats.reb);
                    preparedStatement.setInt(9, stats.ast);
                    preparedStatement.setInt(10, stats.stl);
                    preparedStatement.setInt(11, stats.blk);
                    preparedStatement.addBatch();
                } catch (BatchUpdateException e) {
                    if (isDuplicateEntryException(e)) {
                        // Log the error or handle it as needed
                        System.out.println("Duplicate entry found. Skipping...");
                        continue; // Skip to the next record
                    } else {
                        // Rethrow other BatchUpdateException
                        throw e;
                    }
                }
            }

            int[] affectedRows = preparedStatement.executeBatch();
            System.out.println("Rows inserted: " + affectedRows.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void createTableIfNotExists(Connection connection, String tableName) {
        try (Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                    + "id INT(11) AUTO_INCREMENT PRIMARY KEY,"
                    + "player_id INT(11) DEFAULT 0," // Change the default value as needed
                    + "name VARCHAR(255) DEFAULT 'Unknown',"
                    + "height VARCHAR(10),"
                    + "weight INT(11),"
                    + "position VARCHAR(10),"
                    + "salary DECIMAL(10,0),"
                    + "points INT(11),"
                    + "rebounds INT(11),"
                    + "assists INT(11),"
                    + "steals INT(11),"
                    + "blocks INT(11)"
                    + ")";

            statement.executeUpdate(createTableQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isDuplicateEntryException(BatchUpdateException e) {
        // Check if the exception message indicates a duplicate entry error
        return e.getMessage().contains("Duplicate entry");
    }
}
