/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class Model_MemberProfile {
    
    int playerID;
    String name;

    public Model_MemberProfile(int playerID, String name,String position,String status, LocalDate start,LocalDate end) {
        this.playerID = playerID;
        this.name = name;
        this.position = position;
        this.status = status;
        this.start = start;
        this.end = end;
        
        try {
            Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_user_database","root","");
            String sql="SELECT Weight,Height,Salary,Points,TotalRebounts,Assists,Blocks FROM agentmarket WHERE Player_ID="+this.playerID;
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()){
                this.salary=rs.getInt("Salary");
                this.points=rs.getInt("Points");
                this.height=rs.getDouble("Height");
                this.weight=rs.getDouble("Weight");
                this.rebounds=rs.getInt("TotalRebounts");
                this.steals=rs.getInt("Steals");
                this.blocks=rs.getInt("Blocks");
                this.assists=rs.getInt("Assists");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    double weight,height;
    String position;
    int salary,points,rebounds,steals,blocks,assists;
    String status;
    LocalDate start,end;

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

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
