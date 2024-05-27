/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class performRanking {
    Connection connection;
    ArrayList<Integer> ranking = new ArrayList<>();
    public ArrayList<player> players = new ArrayList<>();
    String userId;

    public void initialise(Connection con, String id) {
        this.connection = con;
        this.userId = id;

        try {
            String sql = "SELECT Player_ID FROM teamplayer WHERE User_ID=" + userId;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int playerId = rs.getInt("Player_ID");
                ranking.add(playerId);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    // Function to fetch player data from the database
    public void fetchPlayers() {
        final String DB_URL = "jdbc:mysql://localhost:3308/java_user_database";
        final String USER = "root";
        final String PASS = "";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Fetch data from teamplayer table
            StringBuilder sql = new StringBuilder("SELECT PLayer_ID,Player_Name, Position, Points, TotalRebounts, Assists, Steals, Blocks, game FROM teamplayer WHERE Player_ID IN (");

            for (int i = 0; i < ranking.size(); i++) {
                sql.append(ranking.get(i));
                if (i < ranking.size() - 1) {
                    sql.append(",");
                }
            }
            sql.append(")");
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery(sql.toString());
            
            while (rs1.next()) {
                int id = rs1.getInt("PLayer_ID");
                String name = rs1.getString("Player_Name");
                String position = rs1.getString("Position");
                int points = rs1.getInt("Points");
                int rebounds = rs1.getInt("TotalRebounts");
                int assists = rs1.getInt("Assists");
                int steals = rs1.getInt("Steals");
                int blocks = rs1.getInt("Blocks");
                int game = rs1.getInt("game");

                players.add(new player(id, name, position, points, rebounds, assists, steals, blocks, game, 0.0)); // CompositeScore is set to 0 initially
            }

            // Fetch composite scores from playerscore table
            StringBuilder sql2 = new StringBuilder("SELECT Player_ID, Composite_Score FROM playerscore WHERE Player_ID IN (");

            for (int i = 0; i < ranking.size(); i++) {
                sql2.append(ranking.get(i));
                if (i < ranking.size() - 1) {
                    sql2.append(",");
                }
            }
            sql2.append(")");
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sql2.toString());

            // Update composite scores in the player list
            while (rs2.next()) {
                int playerId = rs2.getInt("Player_ID");
                double compositeScore = rs2.getDouble("Composite_Score");

                for (player player : players) {
                    if (player.getPlayerID() == playerId) {
                        player.setCompositeScore(compositeScore);
                        break;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get sorted player list
    public ArrayList<player> getPlayerList() {
        Collections.sort(players, new java.util.Comparator<player>() {
            public int compare(player p1, player p2) {
                return Double.compare(p2.getCompositeScore(), p1.getCompositeScore()); // Sort in descending order
            }
        });
        return players;
    }
    
    public static class player {
        int playerID, points, rebounds, assists, steals, blocks, games;
        String position, name;
        double compositeScore;

        public player(int playerID, String name, String position, int points, int rebounds, int assists, int steals, int blocks, int games, double compositeScore) {
            this.playerID = playerID;
            this.name = name;
            this.position = position;
            this.points = points;
            this.rebounds = rebounds;
            this.assists = assists;
            this.steals = steals;
            this.blocks = blocks;
            this.games = games;
            this.compositeScore = compositeScore;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        // Getters and setters
        public int getPlayerID() {
            return playerID;
        }

        public void setPlayerID(int playerID) {
            this.playerID = playerID;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public int getRebounds() {
            return rebounds;
        }

        public void setRebounds(int rebounds) {
            this.rebounds = rebounds;
        }

        public int getAssists() {
            return assists;
        }

        public void setAssists(int assists) {
            this.assists = assists;
        }

        public int getSteals() {
            return steals;
        }

        public void setSteals(int steals) {
            this.steals = steals;
        }

        public int getBlocks() {
            return blocks;
        }

        public void setBlocks(int blocks) {
            this.blocks = blocks;
        }

        public int getGames() {
            return games;
        }

        public void setGames(int games) {
            this.games = games;
        }

        public double getCompositeScore() {
            return compositeScore;
        }

        public void setCompositeScore(double compositeScore) {
            this.compositeScore = compositeScore;
        }
    }

    private static class Comparator<T> {

        public Comparator() {
        }
    }
}
