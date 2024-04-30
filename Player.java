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
    
   private String name;
    int age ;
    double height,weight;
    String position;
    int salary;
    double points,rebounds,assists,steals,blocks;

    public Player(String name, int age, double height, double weight, String position, int salary, double points, double rebounds, double assists, double steals, double blocks) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.salary = salary;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
    }

   
    
    public String toString (){
       return String.format("%s,%d,%.2f,%.2f,%s,%d,%.1f,%.1f,%.1f,%.1f,%.1f\n",name,age,height,weight,position,salary,points,rebounds,assists,steals,blocks);
    }
    
    public String printPlayer(){
       return String.format("| %-15s | %-5d | %7.2f  | %7.2f  |%10s |%7d  | %7.2f   | %7.2f    | %7.2f    | %7.2f    | %7.2f    |\n",name,age,height,weight,position,salary,points,rebounds,assists,steals,blocks);
    }
    
    
}
