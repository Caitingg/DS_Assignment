package route;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class dmModel extends Application {
    @Override
    public void start(Stage primaryStage) {
        City[] vertices = {
                new City("Los Angeles", 75, 50),
                new City("Golden State", 50, 210),
                new City("Oklahoma City", 75, 275),
                new City("Phoenix", 275, 175),
                new City("Denver", 400, 245),
                new City("Houston", 450, 100),
                new City("San Antonio", 700, 80),
                new City("Boston", 675, 120),
                new City("Orlando", 575, 295),
                new City("Miami", 600, 400)
        };

        int[][] edges = {
                // Los Angeles
                {0, 1, 554}, {0, 2, 1901}, {0, 5, 577},
                // Golden State
                {1, 4, 1507}, {1, 2, 2214},
                // Oklahoma City
                {2, 4, 942}, {2, 6, 678}, {2, 5, 778},
                // Phoenix
                {3, 6, 500},
                // Denver
                {4, 7, 2845},
                // Houston
                {5, 7, 2584}, {5, 8, 458}, {5, 6, 983},
                // San Antonio
                {6, 8, 1137},
                // Boston
                {7, 9, 3045},
                // Orlando
                {8, 9, 268}
        };


        VBox pane = new VBox(5);
        pane.setAlignment(Pos.CENTER);

        Label status = new Label();
        pane.getChildren().add(status);

        Graph<City> graph = new UnweightedGraph<>(vertices, edges);
        GraphView graphView = new GraphView(graph);
        pane.getChildren().add(graphView);

        HBox settings = new HBox(5);
        Label startVertex = new Label("Start Vertex: ");
        TextField startVertexField = new TextField(); // TextField for start vertex
        startVertexField.setPrefColumnCount(12);
        Label destVertex = new Label("Destination Vertex: "); // Label for destination vertex
        TextField destVertexField = new TextField(); // TextField for destination vertex
        destVertexField.setPrefColumnCount(12);
        Button dfs = new Button("DFS");
        Button bfs = new Button("BFS");
        Button dijkstra = new Button("Dijkstra");

        settings.getChildren().addAll(startVertex, startVertexField, destVertex, destVertexField, dfs, bfs, dijkstra); // Include destination vertex fields
        settings.setAlignment(Pos.CENTER);
        pane.getChildren().add(settings);

        dfs.setOnAction(e -> {
            status.setText("");
            String startVertex_ = startVertexField.getText().trim();
            int index = -1;
            List<City> cities = graph.getVertices();
            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i).getName().equals(startVertex_)) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                status.setText("Vertex " + startVertex_ + " does not exist on the graph");
                return;
            }
            graphView.dfs(index);
        });

        bfs.setOnAction(e -> {
            status.setText("");
            String startVertex_ = startVertexField.getText().trim();
            int index = -1;
            List<City> cities = graph.getVertices();
            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i).getName().equals(startVertex_)) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                status.setText("Vertex " + startVertex_ + " does not exist on the graph");
                return;
            }
            graphView.bfs(index);
        });

        dijkstra.setOnAction(e -> {
            status.setText("");
            String startVertex_ = startVertexField.getText().trim();
            String destVertex_ = destVertexField.getText().trim(); // Get the destination vertex
            int startIndex = -1;
            int destIndex = -1;
            List<City> cities = graph.getVertices();
            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i).getName().equals(startVertex_)) {
                    startIndex = i;
                }
                if (cities.get(i).getName().equals(destVertex_)) { // Check for destination vertex index
                    destIndex = i;
                }
            }

            if (startIndex == -1) {
                status.setText("Start Vertex " + startVertex_ + " does not exist on the graph");
                return;
            }
            if (destIndex == -1) {
                status.setText("Destination Vertex " + destVertex_ + " does not exist on the graph");
                return;
            }


        });

        Scene scene = new Scene(pane, 750, 500);
        primaryStage.setTitle("City Digital Model");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HashMap<String, route.City> cityMap = new HashMap<>();
    private final int LOGO_WIDTH = 250; // Define the desired width for the logos
    private final int LOGO_HEIGHT = 300; // Define the desired height for the logos

    public dmModel() {
        initializeCities();
        createConnections();
    }

    private void initializeCities() {
        try {
            cityMap.put("San Antonio", new route.City("San Antonio", "Spurs", 150, 500, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Spurs.png")), LOGO_WIDTH, LOGO_HEIGHT)));
            cityMap.put("Golden State", new route.City("Golden State", "Warriors", 100, 50, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Golden State Warriors.png")), LOGO_WIDTH, LOGO_HEIGHT)));
            cityMap.put("Boston", new route.City("Boston", "Celtics", 850, 50, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Boston Celtics.png")), LOGO_WIDTH, LOGO_HEIGHT)));
            cityMap.put("Miami", new route.City("Miami", "Heat", 850, 600, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Miami Heat.png")), LOGO_WIDTH, LOGO_HEIGHT)));
            cityMap.put("Los Angeles", new route.City("Los Angeles", "Lakers", 100, 200, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Los Angeles Lakers.png")), LOGO_WIDTH, LOGO_HEIGHT)));
            cityMap.put("Phoenix", new route.City("Phoenix", "Suns", 300, 300, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Phoenix Suns.png")), LOGO_WIDTH, LOGO_HEIGHT)));
            cityMap.put("Orlando", new route.City("Orlando", "Magic", 700, 600, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Orlando Magic.png")), LOGO_WIDTH, LOGO_HEIGHT)));
            cityMap.put("Denver", new route.City("Denver", "Nuggets", 450, 150, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Denver Nuggets.png")), LOGO_WIDTH, LOGO_HEIGHT)));
            cityMap.put("Oklahoma City", new route.City("Oklahoma City", "Thunder", 450, 300, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Oklahoma City Thunder.png")), LOGO_WIDTH, LOGO_HEIGHT)));
            cityMap.put("Houston", new route.City("Houston", "Rockets", 600, 450, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Houston Rockets.jpg")), LOGO_WIDTH, LOGO_HEIGHT)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Image resizeImage(Image originalImage, int width, int height) {
        return originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    private void createConnections() {
        addConnection("Los Angeles", "Golden State", 554);
        addConnection("Los Angeles", "Oklahoma City", 1901);
        addConnection("Los Angeles", "Phoenix", 577);
        addConnection("Golden State", "Denver", 1507);
        addConnection("Golden State", "Oklahoma City", 2214);
        addConnection("Oklahoma City", "Denver", 942);
        addConnection("Oklahoma City", "San Antonio", 678);
        addConnection("Oklahoma City", "Houston", 778);
        addConnection("Phoenix", "San Antonio", 500);
        addConnection("Denver", "Boston", 2845);
        addConnection("Houston", "Boston", 2584);
        addConnection("Houston", "Orlando", 458);
        addConnection("Houston", "San Antonio", 983);
        addConnection("San Antonio", "Orlando", 1137);
        addConnection("Boston", "Miami", 3045);
        addConnection("Orlando", "Miami", 268);
    }

    private void addConnection(String city1Name, String city2Name, int distance) {
        route.City city1 = cityMap.get(city1Name);
        route.City city2 = cityMap.get(city2Name);
        if (city1 != null && city2 != null) {
            city1.addConnection(city2, distance);
            city2.addConnection(city1, distance);
        }
    }

    public int getDistance(String city1Name, String city2Name) {
        route.City city1 = cityMap.get(city1Name);
        route.City city2 = cityMap.get(city2Name);
        if (city1 != null && city2 != null) {
            for (Edge e : city1.getConnection()) {
                if (e.getCity().equals(city2)) {
                    return e.getDistance();
                }
            }
        }
        return -1;
    }

    static class City implements Displayable {
        private double x, y;
        private String name;

        City(String name, double x, double y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public double getX() {
            return x;
        }

        @Override
        public double getY() {
            return y;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}

