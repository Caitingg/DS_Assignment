package route;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class City {
    String name,team;
    private int x;
    private int y;
    private Image logo;

    ArrayList<Edge>connection=new ArrayList<>();
    private ArrayList<Edge> connections;
    
    City(String name,String team){
        this.name=name;
        this.team=team;
    }

    public City(String name, String team, int x, int y, Image logo) {
        this.name = name;
        this.team = team;
        this.x = x;
        this.y = y;
        this.logo = logo;
        this.connections = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }
    
    public String getTeam(){
        return this.team;
    }
    public void addConnection(City c,int d){
        connection.add(new Edge(c,d));
    }
    public void addConnections(City c, int d) {
        connections.add(new Edge(c, d));
    }
    public ArrayList<Edge> getConnection(){
        ArrayList<Edge>list=new ArrayList<>();
        for(Edge e:connection){
            list.add(e);
        }
        return list;
    }
    public ArrayList<Edge> getConnections(){
        ArrayList<Edge>list=new ArrayList<>();
        for(Edge e:connections){
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
    int u;
    int v;
    private double weight;
    
    public Edge(int u, int v, int distance) {
        this.u = u;
        this.v = v;
        this.distance = distance;
    }
    public Edge(int u, int v, double weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }
    public City getCity() {
        return city;
    }

    public int getDistance() {
        return distance;
    }

    public double getWeight() {
        return weight;
    }
    
    public int getV() {
        return v;
    }
    Edge(City c,int d){
        this.city=c;
        this.distance=d;
    }
    public City getEdgeCity(){
        return this.city;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        return u == edge.u && v == edge.v;
    }

    @Override
    public int hashCode() {
        int result = u;
        result = 31 * result + v;
        return result;
    }
}
