/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

/**
 *
 * @author ONG KAI YIN
 */
public class Player {
    
   private int Player_id;
   private String Player_Name;
   private Double Weight,Height;
   private String Position;
   private int Salary,Points,Rebounds,assists,steals,Blocks;

    public Player(int Player_id, String Player_Name, Double Weight, Double Height, String Position, int Salary, int Points, int Rebounds, int assists, int steals, int Blocks) {
        this.Player_id = Player_id;
        this.Player_Name = Player_Name;
        this.Weight = Weight;
        this.Height = Height;
        this.Position = Position;
        this.Salary = Salary;
        this.Points = Points;
        this.Rebounds = Rebounds;
        this.assists = assists;
        this.steals = steals;
        this.Blocks = Blocks;
    }

    public int getPlayer_id() {
        return Player_id;
    }

    public void setPlayer_id(int Player_id) {
        this.Player_id = Player_id;
    }

    public String getPlayer_Name() {
        return Player_Name;
    }

    public void setPlayer_Name(String Player_Name) {
        this.Player_Name = Player_Name;
    }

    public Double getWeight() {
        return Weight;
    }

    public void setWeight(Double Weight) {
        this.Weight = Weight;
    }

    public Double getHeight() {
        return Height;
    }

    public void setHeight(Double Height) {
        this.Height = Height;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int Points) {
        this.Points = Points;
    }

    public int getRebounds() {
        return Rebounds;
    }

    public void setRebounds(int Rebounds) {
        this.Rebounds = Rebounds;
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
        return Blocks;
    }

    public void setBlocks(int Blocks) {
        this.Blocks = Blocks;
    }

   
   
    
   
    
}
