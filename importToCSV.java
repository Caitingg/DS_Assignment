import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class importToCSV {
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

        try {
            writePlayerStatsToCSV(playerStats, "PlayerStats.csv");
        } catch (IOException ex) {
            Logger.getLogger(importToCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void writePlayerStatsToCSV(ArrayList<PlayerStats> playerStats, String fileName) throws IOException {
        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter(fileName));
            // Define the header
            String[] header = {"Player ID", "Player Name", "Weight (kg)", "Height (cm)", "Position", "Salary", "Points", "Total Rebounds", "Assists", "Steals", "Blocks"};

            writer.writeNext(header);

            // Write player statistics
            for (PlayerStats stats : playerStats) {
                // Convert weight from pounds to kilograms
                double weightInKg = 0.0; // Default value
                if (stats.player.weight != null) {
                    weightInKg = Double.parseDouble(stats.player.weight) * 0.453592; // 1 pound = 0.453592 kilograms
                }

                // Convert height from feet to centimeters
                double heightInCm = 0.0; // Default value
                if (stats.player.height != null) {
                    String[] heightParts = stats.player.height.split("-");
                    int feet = Integer.parseInt(heightParts[0]);
                    int inches = Integer.parseInt(heightParts[1]);
                    heightInCm = (feet * 12 + inches) * 2.54; // 1 foot = 30.48 centimeters
                }

                // Calculate salary based on points
                int salary;
                Random r = new Random();
                if (stats.pts > 20) {
                    salary = r.nextInt(4500 - 3000 + 1) + 3000;
                } else {
                    salary = r.nextInt(2500-1000+1) + 1000;
                }

                String[] data = {
                        String.valueOf(stats.player.id),
                        stats.player.first_name + " " + stats.player.last_name,
                        String.format("%.2f", weightInKg), // Format weight to two decimal places
                        String.format("%.2f", heightInCm), // Format height to two decimal places
                        stats.player.position,
                        String.valueOf(salary),
                        String.valueOf(stats.pts),
                        String.valueOf(stats.reb),
                        String.valueOf(stats.ast),
                        String.valueOf(stats.stl),
                        String.valueOf(stats.blk)
                };
                writer.writeNext(data);
            }
        } finally {
            if (writer != null) {
                writer.close(); // Close the writer in a finally block to ensure it's always closed
            }
        }
    }


}
