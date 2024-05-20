/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Team;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author User
 */
public class contract {
    Connection connection;
    //LocalDate startDate,endDate;
    ArrayList<TeamPlayer>team=new ArrayList<>();
    PriorityQueue<TeamPlayer>queue=new PriorityQueue<>(Comparator.reverseOrder());
    String userId;
    
    
    public void initialise(Connection con,String id){
        this.connection=con;
        this.userId=id;
        
        try {
            String sql="SELECT Player_ID,Player_Name,Start_Date,End_Date,Status,Composite_Score,Position,Injury_Reserved FROM teamplayer WHERE User_ID="+userId;
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()){
                int playerID=rs.getInt("Player_ID");
                String playerName=rs.getString("Player_Name");
                LocalDate sd=rs.getDate("Start_Date").toLocalDate();
                LocalDate ed=rs.getDate("End_Date").toLocalDate();
                long tl=timeLeft(ed);
                String status=rs.getString("Status");
                Double score=rs.getDouble("Composite_Score");
                String position=rs.getString("Position");
                boolean injury=rs.getBoolean("Injury_Reserved");
                team.add(new TeamPlayer(playerID,playerName,sd,ed,tl,status,score,position,injury,id));
            }  
            for(TeamPlayer p:team){
                
                if(p.timeLeft==0){
                    queue.add(p);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }
    
    public void extend(){
        TeamPlayer temp=queue.peek();
        LocalDate update=temp.getEndDate();
        update=update.plusYears(1);
        int id=temp.getPlayer_id();
        
        String sql="UPDATE teamplayer SET End_Date = '" + java.sql.Date.valueOf(update) + "' WHERE Player_ID="+id;
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void remove(){
        TeamPlayer temp=queue.poll();
        int id=temp.getPlayer_id();
        String sql = "DELETE FROM teamplayer WHERE Player_ID= " + id;
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public long timeLeft(LocalDate endDate){
        LocalDate current=LocalDate.now();
        long daysLeft=ChronoUnit.DAYS.between(current,endDate);
        return daysLeft;
        
    }
    public PriorityQueue<TeamPlayer>getTeamQueue(){
        return this.queue;
    }
    public ArrayList<TeamPlayer>getTeamList(){
        return this.team;
    }
}
   
    
    
