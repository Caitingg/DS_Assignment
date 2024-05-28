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

import java.util.ArrayList;
import java.util.Arrays;


public class dmModel extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {



        ArrayList<String> cities = new ArrayList<>
                (
                        Arrays.asList("Seattle", "San Francisco", "Los Angeles", "Denver", "Kansas City",
                                "Chicago", "Boston", "New York", "Atlanta", "Miami", "Dallas", "Houston")
                );
        City[] vertices =
                {
                        new City("Seattle", 75, 50),
                        new City("San Francisco", 50, 210),
                        new City("Los Angeles", 75, 275), new City("Denver", 275, 175),
                        new City("Kansas City", 400, 245),
                        new City("Chicago", 450, 100), new City("Boston", 700, 80),
                        new City("New York", 675, 120), new City("Atlanta", 575, 295),
                        new City("Miami", 600, 400), new City("Dallas", 408, 325),
                        new City("Houston", 450, 360)
                };

        int[][] edges =
                {
                        {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
                        {1, 0, 807}, {1, 2, 381}, {1, 3, 1267},
                        {2, 1, 381}, {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
                        {3, 0, 1331}, {3, 1, 1267}, {3, 2, 1015}, {3, 4, 599},
                        {3, 5, 1003},
                        {4, 2, 1663}, {4, 3, 599}, {4, 5, 533}, {4, 7, 1260},
                        {4, 8, 864}, {4, 10, 496},
                        {5, 0, 2097}, {5, 3, 1003}, {5, 4, 533},
                        {5, 6, 983}, {5, 7, 787},
                        {6, 5, 983}, {6, 7, 214},
                        {7, 4, 1260}, {7, 5, 787}, {7, 6, 214}, {7, 8, 888},
                        {8, 4, 864}, {8, 7, 888}, {8, 9, 661},
                        {8, 10, 781}, {8, 11, 810},
                        {9, 8, 661}, {9, 11, 1187},
                        {10, 2, 1435}, {10, 4, 496}, {10, 8, 781}, {10, 11, 239},
                        {11, 8, 810}, {11, 9, 1187}, {11, 10, 239}
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
        TextField startingCity = new TextField();
        startingCity.setPrefColumnCount(12);
        settings.getChildren().add(startingCity);

        settings.getChildren().add(new Label("Ending City: "));
        TextField endingCity = new TextField();
        endingCity.setPrefColumnCount(12);
        settings.getChildren().add(endingCity);

        Button displayShortestPath = new Button("Display Shortest Path");
        settings.getChildren().add(displayShortestPath);
        pane.getChildren().add(settings);

        displayShortestPath.setOnAction(e ->
        {
            status.setText("");
            int index1 = cities.indexOf(startingCity.getText().trim());
            int index2 = cities.indexOf(endingCity.getText().trim());

            if (index1 == -1)
            {
                status.setText("City " + startingCity.getText() + " is not exist");
                return;
            }

            if (index2 == -1)
            {
                status.setText("City " + endingCity.getText() + " is not exist");
                return;
            }

            try
            {
                graphView.displayShortestPath(index1,  index2);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        });



        Scene scene = new Scene(pane, 750, 500);
        primaryStage.setTitle("City Digital Model");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    static class City implements Displayable
    {
        private double x, y;
        private String name;

        City(String name, double x, double y)
        {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public double getX()
        {
            return x;
        }

        @Override
        public double getY()
        {
            return y;
        }


        @Override
        public String getName()
        {
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
