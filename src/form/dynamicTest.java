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
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class dynamicTest {

    /**
     * @param args the command line arguments
     */
    // Define your database URL, username, and password
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/java_user_database";
    static final String USER = "root";
    static final String PASS = "";

    public dynamicTest(String attributes) {
        // Initialize player list
        ArrayList<Player> players = new ArrayList<>();
        
        
/*
        // Get user input for search conditions
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the search conditions:");
        System.out.print("Find attributes: ");
        String attributes = scanner.nextLine();
*/


        // Perform dynamic search based on user input
        Player matchedPlayer = dynamicSearch(players, attributes);

        // Display search result
        if (matchedPlayer != null) {
            System.out.println("\nMatched Player:");
            System.out.println(matchedPlayer.toString());
        } else {
//            System.out.println("\nNo players found matching the search criteria.");
            String message = "\nNo players found matching the search criteria.";
            JOptionPane.showMessageDialog(new JFrame(), message,"Dialog",JOptionPane.ERROR_MESSAGE);
        }
    }

    // Function for dynamic searching based on user-entered attributes
    public static Player dynamicSearch(ArrayList<Player> players, String attributes) {
        String[] searchCriteria = attributes.split(",");
        String attribute = "", condition = "";
        String value;
        for (int i = 0; i < searchCriteria.length; i++) {
            if (i % 3 == 0) {
                attribute = searchCriteria[i];
            } else if (i % 3 == 1) {
                condition = searchCriteria[i];
            } else if (i % 3 == 2) {
                value = searchCriteria[i];
                // Connect to the database and fetch player data based on search criteria
                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                     Statement stmt = conn.createStatement()) {
                    String sql = "SELECT * FROM agentmarket WHERE " + attribute + " " + condition + " " + value;
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        String name = rs.getString("Player_Name");
                        int playerId=rs.getInt("PLayer_ID");
                        double height = rs.getDouble("Height");
                        double weight = rs.getDouble("Weight");
                        String position = rs.getString("Position");
                        double salary = rs.getDouble("Salary");
                        double points = rs.getDouble("Points");
                        double rebounds = rs.getDouble("TotalRebounts");
                        double assists = rs.getDouble("Assists");
                        double steals = rs.getDouble("Steals");
                        double blocks = rs.getDouble("Blocks");
                        return new Player(name,playerId,height, weight, position, salary, points, rebounds, assists, steals, blocks);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    
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

    public Player(String name, int player_id,double height, double weight, String position, double salary,
                  double points, double rebounds, double assists, double steals, double blocks) {
        this.name = name;
        this.player_id=player_id;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.salary = salary;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
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

    @Override
    public String toString() {
        return name + " | Player id: " + player_id + " | Height: " + height + " | Weight: " + weight + " | Position: " + position;
    }
}

