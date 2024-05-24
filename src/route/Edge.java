package route;

public class Edge {
    City city;
    private int distance;

    public Edge(City city, int distance) {
        this.city = city;
        this.distance = distance;
    }

    public City getCity() {
        return city;
    }

    public int getDistance() {
        return distance;
    }
}