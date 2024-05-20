/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.util.Date;

/**
 *
 * @author user
 */
public class team_player {
    int Player_id, User_ID;
    String Player_Name, status, position, injury_reserve;
    Date Start_Date, End_Date;
    
    public team_player(int Player_id, String Player_Name, Date Start_Date, Date End_Date, String status, int User_ID, String injury_reserve, String position) {
        this.Player_id = Player_id;
        this.Player_Name = Player_Name;
        this.Start_Date = Start_Date;
        this.End_Date = End_Date;
        this.status = status;
        this.User_ID = User_ID;
        this.injury_reserve = injury_reserve;
        this.position = position;
    }

    public int getPlayer_id() {
        return Player_id;
    }

    public void setPlayer_id(int Player_id) {
        this.Player_id = Player_id;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int User_ID) {
        this.User_ID = User_ID;
    }

    public String getPlayer_Name() {
        return Player_Name;
    }

    public void setPlayer_Name(String Player_Name) {
        this.Player_Name = Player_Name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getinjury_reserve() {
        return injury_reserve;
    }

    public void setinjury_reserve(String injury_reserve) {
        this.injury_reserve = injury_reserve;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(Date Start_Date) {
        this.Start_Date = Start_Date;
    }

    public Date getEnd_Date() {
        return End_Date;
    }

    public void setEnd_Date(Date End_Date) {
        this.End_Date = End_Date;
    }

}
