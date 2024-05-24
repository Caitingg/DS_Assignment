/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author user
 */
public class PLayer {
    
    int Player_id;
    String Player_Name;
    Double Weight,Height;
    String Position, Status;
    int Salary,Points,Rebounds,assists,steals,Blocks,game;


    public PLayer(int Player_id, String Player_Name, Double Weight, Double Height, String Position, int Salary, int Points, int Rebounds, int assists, int steals, int Blocks, String Status) {
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
        this.Status = Status;
    }
    // public PLayer(int Player_id, String Player_Name, Double Weight, Double Height, String Position, int Salary, int Points, int Rebounds, int assists, int steals, int Blocks, String Status,int game) {
    //     this.Player_id = Player_id;
    //     this.Player_Name = Player_Name;
    //     this.Weight = Weight;
    //     this.Height = Height;
    //     this.Position = Position;
    //     this.Salary = Salary;
    //     this.Points = Points;
    //     this.Rebounds = Rebounds;
    //     this.assists = assists;
    //     this.steals = steals;
    //     this.Blocks = Blocks;
    //     this.Status = Status;
    //     this.game=game;
    // }
    
    public PLayer(int id,String position,int points,int rebounds,int assists,int steals,int blocks,int game){
        this.Player_id=id;
        this.Position=position;
        this.Points=points;
        this.Rebounds=rebounds;
        this.assists=assists;
        this.Blocks=blocks;
        this.steals=steals;
        this.game=game;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public PLayer() {
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
    public int getGame(){
        return this.game;
    }
    public void setGame(int g){
        this.game=g;

    }

   
    public String toString() {
        StringBuilder a=new StringBuilder();
        a.append("Name: "+this.Player_Name+"\n");
        a.append("Player Id: "+this.Player_id+"\n");
        a.append("Weight: "+this.Weight+"\n");
        a.append("Height: "+this.Height+"\n");
        a.append("Position: "+this.Position+"\n");
        a.append("Points: "+this.Points+"\n");
        a.append("Rebound: "+this.Rebounds+"\n");
        a.append("Assists: "+this.assists+"\n");
        a.append("Steals: "+this.steals+"\n");
        a.append("Blocks: "+this.Blocks+"\n");
        return a.toString();
    }
   
    
}
