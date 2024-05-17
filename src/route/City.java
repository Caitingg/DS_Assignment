/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package route;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class City {
    String name,team;
    ArrayList<Edge>connection=new ArrayList<>();
    
    public City(String name,String team){
        this.name=name;
        this.team=team;
    }
    public String getTeam(){
        return this.team;
    }
    public void addConnection(City c,int d){
        connection.add(new Edge(c,d));
    }
    public ArrayList<Edge> getConnection(){
        ArrayList<Edge>list=new ArrayList<>();
        for(Edge e:connection){
            list.add(e);
        }
        return list;
    }
    public String getName(){
        return this.name;
    }
}



class Edge{
    int distance;
    City city;
    
    Edge(City c,int d){
        this.city=c;
        this.distance=d;
    }
    public City getEdgeCity(){
        return this.city;
    }
}
