package route;

import java.util.ArrayList;

/**
 *
 * @author user
 */
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class City {
    public String name;
    public String team;
    private int x;
    private int y;
    private Image logo;
    public ArrayList<Edge> connections;

    public City(String name, String team, int x, int y, Image logo) {
        this.name = name;
        this.team = team;
        this.x = x;
        this.y = y;
        this.logo = logo;
        this.connections = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getTeamName() {
        return team;
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

    public ArrayList<Edge> getConnection(){
        ArrayList<Edge>list=new ArrayList<>();
        for(Edge e:connections){
            list.add(e);
        }
        return list;
    }

    public void addConnection(City city, int distance) {
        connections.add(new Edge(city, distance));
    }
}



