/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Team;

import java.time.LocalDate;


/**
 *
 * @author User
 */
public class TeamPlayer implements Comparable<TeamPlayer>{
    int Player_id;
   String Player_Name;
   LocalDate startDate,endDate;
   long timeLeft;
   String status;
   double compositeScore;
   String position;
   String user_id;
   boolean injuryReserved;

    public TeamPlayer(int Player_id, String Player_Name,LocalDate sd,LocalDate ed,long t,String status,double score,String position,boolean ir,String id) {
        this.Player_id = Player_id;
        this.Player_Name = Player_Name;
        this.startDate=sd;
        this.endDate=ed;
        this.timeLeft=t;
        this.status=status;
        this.compositeScore=score;
        this.position=position;
        this.user_id=id;
        this.injuryReserved=ir;
        
        
    }

    public TeamPlayer() {
          }

    public int getPlayer_id() {
        return Player_id;
    }
    public String getPlayer_Name() {
        return Player_Name;
    }
    public LocalDate getStartDate(){
        return this.startDate;
    }
    public LocalDate getEndDate(){
        return this.endDate;
    }
    public String getStatus(){
        return this.status;
    }
    public double getCompositeScore(){
        return this.compositeScore;
    }
    public String getUserId(){
        return this.user_id;
    }
    public boolean getInjuryReserved(){
        return this.injuryReserved;
    }
    public void setInjuryReserved(boolean b){
        this.injuryReserved=b;
    }
    public String getPosition(){
        return this.position;
    }

   

   
    public String toString() {
        StringBuilder a=new StringBuilder();
        a.append("Name: "+this.Player_Name+"\n");
        a.append("Player Id: "+this.Player_id+"\n");
        a.append("Start Date: "+this.startDate+"\n");
        a.append("End Date: "+this.endDate+"\n");
        a.append("Time Left: "+this.timeLeft+"days\n");
        a.append("Status: "+this.status+"\n");
        a.append("Composite Score: "+this.compositeScore+"\n");
        a.append("Position: "+this.position+"\n");
        a.append("User Id: "+this.user_id+"\n");
        a.append("Injury Reserved: "+this.injuryReserved+"\n");
        
        return a.toString();
    }

    @Override
    public int compareTo(TeamPlayer o) {
        return Double.compare(this.compositeScore, o.compositeScore);
    }
    
}
