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
import javax.swing.ImageIcon;
import model.Model_PlayerProfile;

public class dynamicTest {

    // Define your database URL, username, and password
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/java_user_database";
    static final String USER = "root";
    static final String PASS = "";
    static List<Model_PlayerProfile> profile = new ArrayList<>();

    public dynamicTest(String attributes) {
        List<Player> players = new ArrayList<>();
        players = dynamicSearch(attributes);
        
        if (!players.isEmpty()) {
            for (Player player : players) {
                profile.add(new Model_PlayerProfile(
                        new ImageIcon(getClass().getResource("/icon/player1.png")), 
                        player.getName(), 
                        player.getWeight(), 
                        player.getHeight(), 
                        player.getPosition(), 
                        player.getSalary()));
            }
            
            System.out.println("Found Players:");
            for (Player player : players) {
                System.out.println(player);
            }
        } else {
            System.out.println("No players found matching the criteria.");
        }
    }

    public List<Player> dynamicSearch(String attributes) {
        String[] searchCriteria = attributes.split(",");

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
                String status = rs.getString("status");
                resultPlayers.add(new Player(name, playerId, height, weight, position, salary, points, rebounds, assists, steals, blocks, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultPlayers;
    }

class Player {

    private String name;
    private int playerId;
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

    public Player(String name, int playerId, double height, double weight, String position, double salary,
                  double points, double rebounds, double assists, double steals, double blocks, String status) {
        this.name = name;
        this.playerId = playerId;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.salary = salary;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getPlayerId() {
        return playerId;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " | Player id: " + playerId + " | Height: " + height + " | Weight: " + weight + " | Position: " + position;
    }
}
}
