/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Team;

/**
 *
 * @author user
 */
import database.PLayer;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ranking {

    /**
     * @param args the command line arguments
     */
    // Define your database URL, username, and password
//        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/java_user_database";
//        final String USER = "root";
//        final String PASS = "";
//    
//    public static void main(String[] args) {
//        // Initialize player list
//        List<Player> players = new ArrayList<>();
//
//        // Fetch player data from the database
//        fetchPlayersFromDatabase(players);
//
//        // Calculate composite performance score for each player
//        calculateCompositeScores(players);
//
//        // Sort players based on composite score in descending order
//        players.sort(Comparator.comparingDouble(Player::getCompositeScore).reversed());
//
//        // Display player performance ranking
//        System.out.println("-- Player Performance Ranking --");
//        int rank = 1;
//        for (Player player : players) {
//            System.out.println("Player: " + player.getName());
//            System.out.println("Composite Score: " + player.getCompositeScore());
//            System.out.println("Rank: " + rank);
//            System.out.println();
//            rank++;
//        }
//    }
    
    Connection connection;
    //LocalDate startDate,endDate;
    ArrayList<Integer>ranking=new ArrayList<>();
    String userId;


    public void initialise(Connection con,String id){
        this.connection=con;
        this.userId=id;
        
        try {
            String sql="SELECT Player_ID FROM teamplayer WHERE User_ID="+userId;
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()){
                int playerId=rs.getInt("Player_ID");
                ranking.add(playerId);
            }
           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    // Function to fetch player data from the database
    public static ArrayList<PLayer> fetchPlayersFromDatabase(ArrayList<Integer>ranking) {
        final String DB_URL = "jdbc:mysql://localhost:3306/nba?useSSL=false";
        final String USER = "root";
        final String PASS = "";
        ArrayList<PLayer>players=new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement()) {
             StringBuilder sql = new StringBuilder ("SELECT Player_ID,Position,Points,TotalRebounts,Assists,Steals,Blocks,game FROM agentmarket WHERE  id IN (");
            
            for (int i = 0; i < ranking.size(); i++) {
                sql.append(ranking.get(i));
                if (i < ranking.size() - 1) {
                    sql.append(",");
                }
            }
            sql.append(")");
            ResultSet rs = stmt.executeQuery(sql.toString());
            while (rs.next()) {
                int id=rs.getInt("Player_ID");
                String position=rs.getString("Position");
                int points = rs.getInt("Points");
                int rebounds = rs.getInt("TotalRebounts");
                int assists = rs.getInt("Assists");
                int steals = rs.getInt("Steals");
                int blocks = rs.getInt("Blocks");
                int game = rs.getInt("game");

                players.add(new PLayer(id,position,points, rebounds, assists, steals, blocks,game));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    // Function to calculate composite performance score for each player
    public double calculateCompositeScores(PLayer player) {
        
        double compositeScore = 0.0;
        // Weighted criteria based on player's position
        if (player.getPosition().equals("C")) {
             compositeScore += player.getRebounds() * 1.5 + player.getBlocks() * 2.0;
        } else if (player.getPosition().equals("G")) {
                compositeScore += player.getAssists() * 1.5 + player.getSteals() * 2.0;
        }
        compositeScore += player.getPoints() / player.getGame() + player.getAssists() + player.getRebounds() + player.getSteals() + player.getBlocks();
        return compositeScore;
        
    }
    
        public void updateCompositeScoresInDatabase(List<PLayer> players, Connection connection) {
            HashMap<Integer,Double>scoreMap=new HashMap<>();
            for(PLayer p:players){
                int id=p.getPlayer_id();
                double score=calculateCompositeScores(p);
                scoreMap.put(id, score);
            }

            String updateSQL = "UPDATE teamplayer SET Composite_Score = ? WHERE Player_ID = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
                for(int i:scoreMap.keySet()){
                    pstmt.setDouble(1, scoreMap.get(i));
                    pstmt.setInt(2, i);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
