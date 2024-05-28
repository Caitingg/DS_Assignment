package route;

import java.util.*;
import route.City;

public class bfs {
    HashMap<Integer, City> city = new HashMap<>();
    String start, end;
    int s, e;
    LinkedList<Integer>[] adjList;
    StringBuilder routes = new StringBuilder();
    int totalDistance = 0;

    public bfs() {
        initialize();
        adjList = new LinkedList[city.size()];
    }

    public void findRoute(String st, String en) {
        this.start = st;
        this.end = en;
        this.s = getIndex(start);
        this.e = getIndex(end);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[city.size()];
        HashMap<Integer, Integer> parentMap = new HashMap<>();
        addAdjList();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i : adjList[current]) {
                if (!visited[i]) {
                    queue.add(i);
                    parentMap.put(i, current);
                    visited[i] = true;
                }
            }
        }
        ArrayList<Integer> route = new ArrayList<>();
        int endCity = e;
        route.add(endCity);
        while (endCity != s) {
            int temp = parentMap.get(endCity);
            endCity = temp;
            route.add(temp);
        }
        Collections.reverse(route);

        // Constructing the route string
        for (int i = 0; i < route.size(); i++) {
            if (i != route.size() - 1) routes.append(city.get(route.get(i)).name + " (" + city.get(route.get(i)).team + ")" + "-> ");
            else routes.append(city.get(route.get(i)).name + " (" + city.get(route.get(i)).team + ")");
        }

        // Calculating total distance
        int sum = 0;
        cityDigitalModel dm = new cityDigitalModel();
        for (int i = 0; i < route.size() - 1; i++) {
            City c1 = city.get(route.get(i));
            City c2 = city.get(route.get(i + 1));
            sum += dm.getDistance(c1.name, c2.name);
        }
        this.totalDistance = sum;
    }

    public void addAdjList() {
        for (int i = 0; i < city.size(); i++) {
            adjList[i] = new LinkedList<>();
            ArrayList<Edge> list = city.get(i).getConnection();
            for (Edge e : list) {
                adjList[i].add(getIndex(e.city.name));
            }
        }
    }

    public void initialize() {
        cityDigitalModel dm = new cityDigitalModel();
        city.put(0, dm.getCity("San Antonio"));
        city.put(1, dm.getCity("Golden State"));
        city.put(2, dm.getCity("Boston"));
        city.put(3, dm.getCity("Miami"));
        city.put(4, dm.getCity("Los Angeles"));
        city.put(5, dm.getCity("Phoenix"));
        city.put(6, dm.getCity("Orlando"));
        city.put(7, dm.getCity("Denver"));
        city.put(8, dm.getCity("Oklahoma City"));
        city.put(9, dm.getCity("Houston"));
    }

    public int getIndex(String name) {
        for (int i : city.keySet()) {
            if (city.get(i).name.equals(name)) return i;
        }
        return -1;
    }

    public String getPath() {
        return routes.toString();
    }

    public int getDistance() {
        return totalDistance;
    }
}
