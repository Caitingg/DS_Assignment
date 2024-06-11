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


public class performRanking {
    Connection connection;
    //ArrayList<Integer> ranking = new ArrayList<>();
    public ArrayList<player> players = new ArrayList<>();
    String userId;

    

    // Function to fetch player data from the database
    public performRanking(Connection connection,String id) {
        this.connection=connection;
        this.userId=id;
        
        try {
            // Fetch data from teamplayer table
            
            String sql="SELECT Player_ID,Player_Name,Position,Composite_Score ,Image FROM teamplayer WHERE User_ID='"+id+"'";
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                int playerid=rs.getInt("Player_ID");
                String name=rs.getString("Player_Name");
                String position=rs.getString("Position");
                double score=rs.getDouble("Composite_Score");
                String image=rs.getString("Image");
                players.add(new player(image,playerid, name, position,  score));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get sorted player list
    public ArrayList<player> getPlayerList() {
        return this.players;
    }
    
    public static class player implements Comparable<player> {
        int playerID, points, rebounds, assists, steals, blocks, games;
        String position, name;
        double compositeScore;
        String image;

        public player(String image,int playerID, String name, String position ,  double compositeScore) {
            this.playerID = playerID;
            this.name = name;
            this.position = position;
            this.compositeScore = compositeScore;
            this.image=image;

            try {
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nba?useSSL=false","root","");
                String sql="SELECT Points,TotalRebounts,Assists,Steals,Blocks,game FROM agentmarket WHERE Player_ID="+this.playerID;
                Statement st=connection.createStatement();
                ResultSet rs=st.executeQuery(sql);
                while(rs.next()){
                    this.points=rs.getInt("Points");
                    this.rebounds=rs.getInt("TotalRebounts");
                    this.assists=rs.getInt("Assists");
                    this.steals=rs.getInt("Steals");
                    this.blocks=rs.getInt("Blocks");
                    this.games=rs.getInt("game");
                }

            } catch (SQLException e) {
                
                e.printStackTrace();
            }
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
        public String getImage(){
            return this.image;
        }

        @Override
        public int compareTo(player o) {
            return Double.compare(this.compositeScore, o.compositeScore);
        }
    }

    
}
