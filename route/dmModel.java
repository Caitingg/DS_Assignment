package route;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;

public class dmModel extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ArrayList<String> cities = new ArrayList<>(
                Arrays.asList("Los Angeles", "Golden State", "Oklahoma City", "Phoenix", "Denver",
                        "Houston", "San Antonio", "Boston", "Orlando", "Miami", "Seattle", "San Francisco")
        );

        City[] vertices = {
                new City("Los Angeles", 100, 300),
                new City("Golden State", 150, 100),
                new City("Oklahoma City", 400, 350),
                new City("Phoenix", 250, 300),
                new City("Denver", 450, 200),
                new City("Houston", 600, 400),
                new City("San Antonio", 350, 500),
                new City("Boston", 850, 100),
                new City("Orlando", 700, 500),
                new City("Miami", 850, 600),
                new City("Seattle", 600, 150),
                new City("San Francisco", 400, 100)
        };

        int[][] edges = {
                // Los Angeles
                {0, 1, 554}, {0, 2, 1901}, {0, 5, 577}, {0, 10, 1137}, {0, 11, 382},
                // Golden State
                {1, 4, 1507}, {1, 2, 2214}, {1, 10, 807}, {1, 11, 348},
                // Oklahoma City
                {2, 4, 942}, {2, 6, 678}, {2, 5, 778},
                // Phoenix
                {3, 6, 500}, {3, 0, 357},
                // Denver
                {4, 7, 2845}, {4, 10, 1326},
                // Houston
                {5, 7, 2584}, {5, 8, 458}, {5, 6, 983},
                // San Antonio
                {6, 8, 1137}, {6, 9, 1370},
                // Boston
                {7, 9, 3045}, {7, 8, 1254},
                // Orlando
                {8, 9, 268}, {8, 11, 2436},
                // Miami
                {9, 10, 2731},
                // Seattle
                {10, 11, 807}, {10, 4, 1326}, {10, 0, 1137},
                // San Francisco
                {11, 0, 382}, {11, 1, 348}, {11, 8, 2436}
        };

        WeightedGraph<City> graph = new WeightedGraph<>(vertices, edges);

        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        Label status = new Label();
        pane.getChildren().add(status);

        GraphView graphView = new GraphView(graph);
        pane.getChildren().add(graphView);

        HBox settings = new HBox(5);
        settings.setAlignment(Pos.CENTER);

        settings.getChildren().add(new Label("Starting City: "));
        ComboBox<String> startCityComboBox = new ComboBox<>();
        startCityComboBox.getItems().addAll(cities);
        startCityComboBox.setPrefWidth(150);
        settings.getChildren().add(startCityComboBox);

        settings.getChildren().add(new Label("Ending City: "));
        ComboBox<String> endCityComboBox = new ComboBox<>();
        endCityComboBox.getItems().addAll(cities);
        endCityComboBox.setPrefWidth(150);
        settings.getChildren().add(endCityComboBox);

        Button displayShortestPath = new Button("Display Shortest Path");
        settings.getChildren().add(displayShortestPath);
        pane.getChildren().add(settings);

        displayShortestPath.setOnAction(e -> {
            status.setText("");
            String startCity = startCityComboBox.getValue();
            String endCity = endCityComboBox.getValue();

            if (startCity == null || endCity == null) {
                status.setText("Please select both starting and ending cities.");
                return;
            }

            int index1 = cities.indexOf(startCity);
            int index2 = cities.indexOf(endCity);

            if (index1 == -1) {
                status.setText("City " + startCity + " does not exist.");
                return;
            }

            if (index2 == -1) {
                status.setText("City " + endCity + " does not exist.");
                return;
            }

            // For demonstration, printing the selected cities
            System.out.println("Start City: " + startCity);
            System.out.println("End City: " + endCity);

            // Placeholder for calling the method to display the shortest path
            try {
                graphView.displayShortestPath(index1, index2);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Scene scene = new Scene(pane, 750, 500);
        primaryStage.setTitle("Shortest Path Visualization");
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




// import javafx.application.Application;
// import javafx.geometry.Pos;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.ComboBox;
// import javafx.scene.control.Label;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;
// import java.util.List;

// public class dmModel extends Application {
//     @Override
//     public void start(Stage primaryStage) {
//         City[] vertices = {
//                 new City("Los Angeles", 75, 50),
//                 new City("Golden State", 50, 210),
//                 new City("Oklahoma City", 75, 275),
//                 new City("Phoenix", 275, 175),
//                 new City("Denver", 400, 245),
//                 new City("Houston", 450, 100),
//                 new City("San Antonio", 700, 80),
//                 new City("Boston", 675, 120),
//                 new City("Orlando", 575, 295),
//                 new City("Miami", 600, 400)
//         };

//         int[][] edges = {
//                 // Los Angeles
//                 {0, 1, 554}, {0, 2, 1901}, {0, 5, 577},
//                 // Golden State
//                 {1, 4, 1507}, {1, 2, 2214},
//                 // Oklahoma City
//                 {2, 4, 942}, {2, 6, 678}, {2, 5, 778},
//                 // Phoenix
//                 {3, 6, 500},
//                 // Denver
//                 {4, 7, 2845},
//                 // Houston
//                 {5, 7, 2584}, {5, 8, 458}, {5, 6, 983},
//                 // San Antonio
//                 {6, 8, 1137},
//                 // Boston
//                 {7, 9, 3045},
//                 // Orlando
//                 {8, 9, 268}
//         };


//         VBox pane = new VBox(5);
//         pane.setAlignment(Pos.CENTER);

//         Label status = new Label();
//         pane.getChildren().add(status);

//         Graph<City> graph = new UnweightedGraph<>(vertices, edges);
//         GraphView graphView = new GraphView(graph);
//         pane.getChildren().add(graphView);

//         HBox settings = new HBox(5);
//         Label startVertex = new Label("Start Vertex: ");

//         // Replace TextField with ComboBox for start vertex
//         ComboBox<String> startVertexComboBox = new ComboBox<>();
//         startVertexComboBox.getItems().addAll(
//                 "Los Angeles", "Golden State", "Oklahoma City",
//                 "Phoenix", "Denver", "Houston",
//                 "San Antonio", "Boston", "Orlando", "Miami"
//         );
//         startVertexComboBox.setPrefWidth(150); // Set width as needed

//         Label destVertex = new Label("Destination Vertex: ");

//         // Replace TextField with ComboBox for destination vertex
//         ComboBox<String> destVertexComboBox = new ComboBox<>();
//         destVertexComboBox.getItems().addAll(
//                 "Los Angeles", "Golden State", "Oklahoma City",
//                 "Phoenix", "Denver", "Houston",
//                 "San Antonio", "Boston", "Orlando", "Miami"
//         );
//         destVertexComboBox.setPrefWidth(150); // Set width as needed

//         Button dfs = new Button("DFS");
//         Button bfs = new Button("BFS");
//         Button dijkstra = new Button("Dijkstra");

//         settings.getChildren().addAll(startVertex, startVertexComboBox, destVertex, destVertexComboBox, dfs, bfs, dijkstra);
//         settings.setAlignment(Pos.CENTER);
//         pane.getChildren().add(settings);

//         dfs.setOnAction(e -> {
//             status.setText("");
//             String startVertex_ = startVertexComboBox.getValue();
//             int index = -1;
//             List<City> cities = graph.getVertices();
//             for (int i = 0; i < cities.size(); i++) {
//                 if (cities.get(i).getName().equals(startVertex_)) {
//                     index = i;
//                     break;
//                 }
//             }

//             if (index == -1) {
//                 status.setText("Vertex " + startVertex_ + " does not exist on the graph");
//                 return;
//             }
//             graphView.dfs(index);
//         });

//         bfs.setOnAction(e -> {
//             status.setText("");
//             String startVertex_ = startVertexComboBox.getValue();
//             int index = -1;
//             List<City> cities = graph.getVertices();
//             for (int i = 0; i < cities.size(); i++) {
//                 if (cities.get(i).getName().equals(startVertex_)) {
//                     index = i;
//                     break;
//                 }
//             }

//             if (index == -1) {
//                 status.setText("Vertex " + startVertex_ + " does not exist on the graph");
//                 return;
//             }
//             graphView.bfs(index);
//         });

//         dijkstra.setOnAction(e -> {
//             status.setText("");
//             String startVertex_ = startVertexComboBox.getValue();
//             String destVertex_ = destVertexComboBox.getValue(); // Get selected item from ComboBox
//             int startIndex = -1;
//             int destIndex = -1;
//             List<City> cities = graph.getVertices();
//             for (int i = 0; i < cities.size(); i++) {
//                 if (cities.get(i).getName().equals(startVertex_)) {
//                     startIndex = i;
//                 }
//                 if (cities.get(i).getName().equals(destVertex_)) {
//                     destIndex = i;
//                 }
//             }

//             if (startIndex == -1) {
//                 status.setText("Start Vertex " + startVertex_ + " does not exist on the graph");
//                 return;
//             }
//             if (destIndex == -1) {
//                 status.setText("Destination Vertex " + destVertex_ + " does not exist on the graph");
//                 return;
//             }

//             // Your Dijkstra's algorithm logic here
//         });

//         Scene scene = new Scene(pane, 750, 500);
//         primaryStage.setTitle("City Digital Model");
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     static class City implements Displayable {
//         private double x, y;
//         private String name;

//         City(String name, double x, double y) {
//             this.name = name;
//             this.x = x;
//             this.y = y;
//         }

//         @Override
//         public double getX() {
//             return x;
//         }

//         @Override
//         public double getY() {
//             return y;
//         }

//         @Override
//         public String getName() {
//             return name;
//         }
//     }
// }