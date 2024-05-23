/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model_PlayerStatusProfile {
    
    int playerID;
    String name;
    double compositeScore;
    String status;
    LocalDate start,end;

    public Model_PlayerStatusProfile(int playerID, String name,double compositeScore, LocalDate start,LocalDate end, String status) {
        this.playerID = playerID;
        this.name = name;
        this.status = status;
        this.start = start;
        this.end = end;
        this.compositeScore = compositeScore;
        
        try {
            Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_user_database","root","");
            String sql="SELECT Player_ID,Player_Name, Start_Date,End_Date,Status,Composite_Score FROM teamplayer WHERE Player_ID="+this.playerID;
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()){
                this.playerID=rs.getInt("Player_ID");
                this.name=rs.getString("Player_Name");
                this.compositeScore=rs.getDouble("Composite_Score");
                this.start=rs.getDate("Start_Date").toLocalDate();
                this.end=rs.getDate("End_Date").toLocalDate();
                this.status=rs.getString("Status");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCompositeScore() {
        return compositeScore;
    }

    public void setCompositeScore(double compositeScore) {
        this.compositeScore = compositeScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
    
}  
