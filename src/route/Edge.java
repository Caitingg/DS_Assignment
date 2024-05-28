package route;

public class Edge {
    public City city;
    private int distance;
    int u;
    int v;
    private double weight;

    public Edge(int u, int v, int distance) {
        this.u = u;
        this.v = v;
        this.distance = distance;
    }

    // Getter for the v field
    public int getV() {
        return v;
    }

    // Constructor for edges with cities and distances
    public Edge(City city, int distance) {
        this.city = city;
        this.distance = distance;
    }

    // Constructor for edges with vertex indices and weight
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

