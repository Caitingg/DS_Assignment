/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

/**
 *
 * @author user
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author user
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Model_PlayerProfile;

public class dynamicTest {

    /**
     * @param args the command line arguments
     */
    // Define your database URL, username, and password
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/java_user_database";
    static final String USER = "root";
    static final String PASS = "";
    static List<Model_PlayerProfile> profile = new ArrayList<>();
    

    public dynamicTest(String attributes) {
        // Initialize player list

        /*
        // Get user input for search conditions
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the search conditions:");
        System.out.print("Find attributes: ");
        String attributes = scanner.nextLine();
         */
        
        List<Player> playerrr = new ArrayList<>();
        
        // Perform dynamic search based on user input
        playerrr = dynamicSearch(attributes);
//        createPlayerProfiles(playerrr);
        // Display search result
        if (!playerrr.isEmpty()) {

            for (Player player : playerrr) {
            profile.add(new Model_PlayerProfile(
                    new ImageIcon(getClass().getResource("/icon/player1.png")), 
                    player.getName(), 
                    player.getWeight(), 
                    player.getHeight(), 
                    player.getPosition(), 
                    player.getSalary()));
            }
            
            System.out.println("Found Players:");
            for (Player player : playerrr) {
                System.out.println(player);
            }
        } else {
            System.out.println("No players found matching the criteria.");
        }
        
    }

    public List<Player> dynamicSearch(String attributes) {
        String[] searchCriteria = attributes.split(",");

        if (searchCriteria.length % 3 != 0) {
            throw new IllegalArgumentException("Invalid search criteria format. Each condition should have 3 parts: attribute, condition, value.");
        }

        StringBuilder sql = new StringBuilder("SELECT * FROM agentmarket WHERE 1=1");
        ArrayList<Object> parameters = new ArrayList<>();

        for (int i = 0; i < searchCriteria.length; i += 3) {
            String attribute = searchCriteria[i].trim();
            String condition = searchCriteria[i + 1].trim();
            String value = searchCriteria[i + 2].trim();

            sql.append(" AND ").append(attribute).append(" ").append(condition).append(" ?");
            parameters.add(value);
        }

        List<Player> resultPlayers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setString(i + 1, parameters.get(i).toString());
            }

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Player_Name");
                int playerId = rs.getInt("PLayer_ID");
                double height = rs.getDouble("Height");
                double weight = rs.getDouble("Weight");
                String position = rs.getString("Position");
                double salary = rs.getDouble("Salary");
                double points = rs.getDouble("Points");
                double rebounds = rs.getDouble("TotalRebounts");
                double assists = rs.getDouble("Assists");
                double steals = rs.getDouble("Steals");
                double blocks = rs.getDouble("Blocks");
                String status=rs.getString("Status");
                resultPlayers.add(new Player(name, playerId, height, weight, position, salary, points, rebounds, assists, steals, blocks,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultPlayers;
    }
    
//    public void createPlayerProfiles(List<Player>playerrr) {
//        for (Player player : playerrr) {
//            profile.add(new Model_PlayerProfile(
//                    new ImageIcon(getClass().getResource("/icon/player1.png")), 
//                    player.getName(), 
//                    player.getWeight(), 
//                    player.getHeight(), 
//                    player.getPosition(), 
//                    player.getSalary()));
//        }
//    }

   
//    // Function for dynamic searching based on user-entered attributes
//    public static Player dynamicSearch(ArrayList<Player> players, String attributes) {
//        String[] searchCriteria = attributes.split(",");
//        String attribute = "", condition = "";
//        String value;
//        for (int i = 0; i < searchCriteria.length; i++) {
//            if (i % 3 == 0) {
//                attribute = searchCriteria[i];
//            } else if (i % 3 == 1) {
//                condition = searchCriteria[i];
//            } else if (i % 3 == 2) {
//                value = searchCriteria[i];
//                // Connect to the database and fetch player data based on search criteria
//                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//                     Statement stmt = conn.createStatement()) {
//                    String sql = "SELECT * FROM agentmarket WHERE PLayer_ID = ? AND Height = ? AND Height >= ? AND Height <= ? AND Weight = ? AND Position = ?" + attribute + " " + condition + " " + value;
//                    ResultSet rs = stmt.executeQuery(sql);
//                    while (rs.next()) {
//                        String name = rs.getString("Player_Name");
//                        int playerId=rs.getInt("PLayer_ID");
//                        double height = rs.getDouble("Height");
//                        double weight = rs.getDouble("Weight");
//                        String position = rs.getString("Position");
//                        double salary = rs.getDouble("Salary");
//                        double points = rs.getDouble("Points");
//                        double rebounds = rs.getDouble("TotalRebounts");
//                        double assists = rs.getDouble("Assists");
//                        double steals = rs.getDouble("Steals");
//                        double blocks = rs.getDouble("Blocks");
//                        return new Player(name,playerId,height, weight, position, salary, points, rebounds, assists, steals, blocks);
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return null;
//    }
    /*
    public static void search(String name, String condHeight, String height,String condWeight ,String weight,String position){
        
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<String> conditions = new ArrayList<>();
        
        
        if (name != null && !name.isEmpty()) {
            conditions.add("name = '" + name + "'");
        }
        if (!condHeight.equalsIgnoreCase("Select") && height.equals(null)) {
            conditions.add("height " + condHeight + " " + height);
        }
        if (!condWeight.equalsIgnoreCase("Select") && weight.equals(null)) {
            conditions.add("weight " + condWeight + " " + weight);
        }
        if (!position.equalsIgnoreCase("Select")) {
            conditions.add("position " + position);
        }
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                     Statement stmt = conn.createStatement()) {
                    String sql = "SELECT * FROM players WHERE " + attribute + " " + condition + " " + value;
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        String name = rs.getString("name");
                        int age = rs.getInt("age");
                        double height = rs.getDouble("height");
                        double weight = rs.getDouble("weight");
                        String position = rs.getString("position");
                        double salary = rs.getDouble("salary");
                        double points = rs.getDouble("points");
                        double rebounds = rs.getDouble("rebounds");
                        double assists = rs.getDouble("assists");
                        double steals = rs.getDouble("steals");
                        double blocks = rs.getDouble("blocks");
                        return new Player(name, age, height, weight, position, salary, points, rebounds, assists, steals, blocks);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
}*/
}

class Player {

    private String name;
    private int player_id;
    private double height;
    private double weight;
    private String position;
    private double salary;
    private double points;
    private double rebounds;
    private double assists;
    private double steals;
    private double blocks;
    private String status;

    public Player(String name, int player_id, double height, double weight, String position, double salary,
            double points, double rebounds, double assists, double steals, double blocks,String status) {
        this.name = name;
        this.player_id = player_id;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.salary = salary;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.status=status;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public double getRebounds() {
        return rebounds;
    }

    public void setRebounds(double rebounds) {
        this.rebounds = rebounds;
    }

    public double getAssists() {
        return assists;
    }

    public void setAssists(double assists) {
        this.assists = assists;
    }

    public double getSteals() {
        return steals;
    }

    public void setSteals(double steals) {
        this.steals = steals;
    }

    public double getBlocks() {
        return blocks;
    }

    public void setBlocks(double blocks) {
        this.blocks = blocks;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " | Player id: " + player_id + " | Height: " + height + " | Weight: " + weight + " | Position: " + position;
    }
}
