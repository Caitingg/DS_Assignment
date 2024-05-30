/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Model_playerRanking {
    int playerID,rank,games;
    String name,position,image;
    double compositeScore,steals,blocks,rebounds,assits;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Model_playerRanking(String image,int playerID, int rank, int games, String name, String position, double compositeScore, double steals, double blocks, double rebounds, double assits) {
        this.playerID = playerID;
        this.rank = rank;
        this.games = games;
        this.name = name;
        this.position = position;
        this.compositeScore = compositeScore;
        this.steals = steals;
        this.blocks = blocks;
        this.rebounds = rebounds;
        this.assits = assits;
        this.image=image;
    }

    // public String getPosition(){
    //     return this.position;
    // }

    public int getPlayerID() {
        return playerID;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public double getCompositeScore() {
        return compositeScore;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompositeScore(double compositeScore) {
        this.compositeScore = compositeScore;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }
    public String getImage(){
        return this.image;
    }

    public double getSteals() {
        return steals;
    }

    public void setSteals(double steals) {
        this.steals = steals;
    }

    public double getBlocks() {
        return blocks;
    }

    public void setBlocks(double blocks) {
        this.blocks = blocks;
    }

    public double getRebounds() {
        return rebounds;
    }

    public void setRebounds(double rebounds) {
        this.rebounds = rebounds;
    }

    public double getAssits() {
        return assits;
    }

    public void setAssits(double assits) {
        this.assits = assits;
    }
    
}  

