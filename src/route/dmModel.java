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

