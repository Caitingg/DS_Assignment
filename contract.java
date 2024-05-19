/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contract;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;


/**
 *
 * @author User
 */
public class contract {
    Connection connection;
    //LocalDate startDate,endDate;
    ArrayList<TeamPlayer>team=new ArrayList<>();
    int userId;
    
    
    public void initialise(Connection con,int id){
        this.connection=con;
        this.userId=id;
        
        try {
            String sql="SELECT Player_ID,Player_Name,Start_Date,End_Date,Status,Position,Injury_Reserved FROM teamplayer WHERE User_ID="+userId;
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()){
                int playerID=rs.getInt("Player_ID");
                String playerName=rs.getString("Player_Name");
                LocalDate sd=rs.getDate("Start_Date").toLocalDate();
                LocalDate ed=rs.getDate("End_Date").toLocalDate();
                long tl=timeLeft(ed);
                String status=rs.getString("Status");
                String position=rs.getString("Position");
                boolean injury=rs.getBoolean("Injury_Reserved");
                team.add(new TeamPlayer(playerID,playerName,sd,ed,tl,status,position,injury,id));
            }  
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }
    
    public void extend(int index,int option){
        TeamPlayer temp=team.get(index);
        LocalDate update=temp.endDate;
        switch(option){
            case 1:
                update=temp.endDate.plusYears(5);
                break;
            case 2:
                update=temp.endDate.plusYears(3);
                break;
            case 3:
                update=temp.endDate.plusYears(2);
                break;
            case 4:
                update=temp.endDate.plusYears(1);
                break;
            case 5:
                update=temp.endDate.plusMonths(6);
                break;
            default:
                break;
        }
        int id=temp.getPlayer_id();
        String sql="UPDATE teamplayer SET End_Date = '" + java.sql.Date.valueOf(update) + "' WHERE User_ID=" + this.userId+" AND Player_ID="+id;
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void remove(int index){
        TeamPlayer temp=team.get(index);
        int id=temp.getPlayer_id();
        String sql = "DELETE FROM teamplayer WHERE Player_ID= " + id+" AND User_ID="+this.userId;
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
    public ArrayList<TeamPlayer>getTeamList(){
        return this.team;
    }
    
    
}
