/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Team;

/**
 *
 * @author user
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ranking {

    /**
     * @param args the command line arguments
     */
    // Define your database URL, username, and password
    static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "your_username";
    static final String PASS = "your_password"; 
    
    public static void main(String[] args) {
        // Initialize player list
        List<Player> players = new ArrayList<>();

        // Fetch player data from the database
        fetchPlayersFromDatabase(players);

        // Calculate composite performance score for each player
        calculateCompositeScores(players);

        // Sort players based on composite score in descending order
        players.sort(Comparator.comparingDouble(Player::getCompositeScore).reversed());

        // Display player performance ranking
        System.out.println("-- Player Performance Ranking --");
        int rank = 1;
        for (Player player : players) {
            System.out.println("Player: " + player.getName());
            System.out.println("Composite Score: " + player.getCompositeScore());
            System.out.println("Rank: " + rank);
            System.out.println();
            rank++;
        }
    }

    // Function to fetch player data from the database
    public static void fetchPlayersFromDatabase(List<Player> players) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM players";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double points = rs.getDouble("points");
                double rebounds = rs.getDouble("rebounds");
                double assists = rs.getDouble("assists");
                double steals = rs.getDouble("steals");
                double blocks = rs.getDouble("blocks");
                String position = rs.getString("position");
                int gamePlayed = rs.getInt("gamePlayed");

                players.add(new Player(name, age, points, rebounds, assists, steals, blocks, position,gamePlayed));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Function to calculate composite performance score for each player
    public static void calculateCompositeScores(List<Player> players) {
        for (Player player : players) {
            double compositeScore = 0.0;
            // Weighted criteria based on player's position
            if (player.getPosition().equals("C")) {
                compositeScore += player.getRebounds() * 1.5 + player.getBlocks() * 2.0;
            } else if (player.getPosition().equals("G")) {
                compositeScore += player.getAssists() * 1.5 + player.getSteals() * 2.0;
            }
            compositeScore += player.getPoints() / player.getAverageGamePlayed() + player.getAssists() + player.getRebounds() + player.getSteals() + player.getBlocks();
            player.setCompositeScore(compositeScore);
        }
    }
    

class Player {
    private String name;
    private int age;
    private double points;
    private double rebounds;
    private double assists;
    private double steals;
    private double blocks;
    private String position;
    private double compositeScore;
    private int gamePlayed;

    public Player(String name, int age, double points, double rebounds, double assists, double steals, double blocks, String position,int gamePlayed) {
        this.name = name;
        this.age = age;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.position = position;
        this.gamePlayed = gamePlayed;
    }

    public String getName() {
        return name;
    }

    public double getCompositeScore() {
        return compositeScore;
    }

    public String getPosition() {
        return position;
    }

    public double getPoints() {
        return points;
    }

    public double getRebounds() {
        return rebounds;
    }

    public double getAssists() {
        return assists;
    }

    public double getSteals() {
        return steals;
    }

        public int getGamePlayed() {
            return gamePlayed;
        }

    public double getBlocks() {
        return blocks;
    }

    public void setCompositeScore(double compositeScore) {
        this.compositeScore = compositeScore;
    }
}

