package form;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import route.*;

public class Form_3 implements ActionListener {
    JButton submit;
    JButton explanationButton; // Moved declaration here
    JTextArea bfsArea;
    JTextArea dfsArea;
    JTextArea dArea;
    JComboBox<String> dep;
    JComboBox<String> des;
    private JPanel jPanel2;
    private JLabel backPhoto;

    public Form_3() {

        Font font = new Font("Montserrat", Font.BOLD, 16);
        bfsArea = new JTextArea();
        bfsArea.append("Breadth-First Search:\n");
        bfsArea.setEditable(false);
        bfsArea.setOpaque(false);
        bfsArea.setFont(font);
        bfsArea.setLineWrap(true);
        bfsArea.setWrapStyleWord(true);

        dfsArea = new JTextArea();
        dfsArea.append("Depth-First Search:\n");
        dfsArea.setEditable(false);
        dfsArea.setOpaque(false);
        dfsArea.setFont(font);
        dfsArea.setLineWrap(true);
        dfsArea.setWrapStyleWord(true);

        dArea = new JTextArea();
        dArea.append("Dijkstra:\n");
        dArea.setEditable(false);
        dArea.setOpaque(false);
        dArea.setFont(font);
        dArea.setLineWrap(true);
        dArea.setWrapStyleWord(true);

        JScrollPane dfsPane = new JScrollPane(dfsArea);
        JScrollPane bfsPane = new JScrollPane(bfsArea);
        JScrollPane dPane = new JScrollPane(dArea);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(1, 3));
        textPanel.add(bfsPane);
        textPanel.add(dfsPane);
        textPanel.add(dPane);
        textPanel.setBounds(69, 460, 850, 130);

        submit = new JButton("Find");
        submit.setBounds(420, 425, 150, 20);
        submit.addActionListener(this);
        submit.setFocusable(false);

        JLabel departure = new JLabel("Departure Point: ");
        departure.setFont(new Font("Montserrat", Font.BOLD, 24));
        departure.setForeground(Color.white);

        String[] city = {"San Antonio (Spurs)", "Golden State (Warriors)", "Boston (Celtics)", "Miami (Heat)", "Los Angeles (Lakers)", "Phoenix (Suns)", "Orlando (Magic)", "Denver (Nuggets)", "Oklahoma City (Thunder)", "Houston (Rockets)"};
        dep = new JComboBox<>(city);

        JLabel destination = new JLabel("Destination: ");
        destination.setFont(new Font("Montserrat", Font.BOLD, 24));
        destination.setForeground(Color.white);

        des = new JComboBox<>(city);

        JPanel desOption = new JPanel();
        desOption.setLayout(new GridLayout(1, 2));
        desOption.add(destination);
        desOption.add(des);
        desOption.setOpaque(false);
        desOption.setBounds(560, 390, 350, 25);

        JPanel depOption = new JPanel();
        depOption.setLayout(new GridLayout(1, 2));
        depOption.add(departure);
        depOption.add(dep);
        depOption.setBounds(70, 390, 400, 25);
        depOption.setOpaque(false);

        JLabel map = new JLabel();
        ImageIcon mapImage = new ImageIcon("C:\\Users\\Huawei\\IdeaProjects\\DS\\src\\form\\map.png");
        Image mImage = mapImage.getImage();
        Image mTemp = mImage.getScaledInstance(650, 500, Image.SCALE_SMOOTH);
        mapImage = new ImageIcon(mTemp);
        map.setIcon(mapImage);
        map.setHorizontalAlignment(JLabel.CENTER);
        map.setBounds(185, -100, 650, 500);

        jPanel2 = new JPanel();
        jPanel2.add(map);
        jPanel2.setBackground(new Color(0, 0, 0, 125));
        jPanel2.setBounds(20, -100, 949, 600);

        ImageIcon background = new ImageIcon("C:\\Users\\Huawei\\IdeaProjects\\DS\\src\\form\\background5.jpeg");
        Image image = background.getImage();
        Image temp = image.getScaledInstance(989, 646, Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        backPhoto = new JLabel();
        backPhoto.setIcon(background);
        backPhoto.setHorizontalAlignment(JLabel.CENTER);
        backPhoto.setLayout(null);
        backPhoto.add(map);
        backPhoto.add(depOption);
        backPhoto.add(desOption);
        backPhoto.add(submit);
        backPhoto.add(textPanel);
        backPhoto.add(jPanel2);

        explanationButton = new JButton("Explanation");
        explanationButton.addActionListener(e -> {
            String explanation = getExplanation();
            JOptionPane.showMessageDialog(null, explanation, "Explanation", JOptionPane.INFORMATION_MESSAGE);
        });
        explanationButton.setBounds(580, 425, 150, 20); // Adjusted position here
        backPhoto.add(explanationButton);

        backPhoto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showCityDigitalModelGUI();
            }
        });

        JFrame frame = new JFrame();
        frame.add(backPhoto);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(989, 646);
        frame.setTitle("Find Your Route");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    private void showCityDigitalModelGUI() {
        SwingUtilities.invokeLater(() -> {
            cityDigitalModel model = new cityDigitalModel();

            JFrame frame = new JFrame("NBA Cities Map");
            CityDigitalModelGUI panel = new CityDigitalModelGUI(model);
            panel.setPreferredSize(new Dimension(1000, 700));
            frame.add(panel);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
        });
    }
    private String getExplanation() {
        // Calculate total distances
        dijkstra dij = new dijkstra();
        dij.findRoute(correctCityName((String) dep.getSelectedItem()), correctCityName((String) des.getSelectedItem()));
        int dijkstraDistance = dij.getDistance();

        bfs breath = new bfs();
        breath.findRoute(correctCityName((String) dep.getSelectedItem()), correctCityName((String) des.getSelectedItem()));
        int bfsDistance = breath.getDistance();

        dfs depth = new dfs();
        depth.findRoute(correctCityName((String) dep.getSelectedItem()), correctCityName((String) des.getSelectedItem()));
        int dfsDistance = depth.getDistance();

        // Determine shortest distance algorithms
        ArrayList<String> shortestAlgorithms = new ArrayList<>();
        int shortestDistance = Math.min(Math.min(dijkstraDistance, bfsDistance), dfsDistance);

        if (dijkstraDistance == shortestDistance) {
            shortestAlgorithms.add("Dijkstra");
        }
        if (bfsDistance == shortestDistance) {
            shortestAlgorithms.add("BFS");
        }
        if (dfsDistance == shortestDistance) {
            shortestAlgorithms.add("DFS");
        }

        // Construct explanation
        StringBuilder explanationBuilder = new StringBuilder();
        explanationBuilder.append("The ");

        if (shortestAlgorithms.size() == 1) {
            explanationBuilder.append(shortestAlgorithms.get(0)).append(" algorithm yields the shortest distance of ").append(shortestDistance).append(" km. ");
        } else {
            explanationBuilder.append("models ").append(String.join(" and ", shortestAlgorithms)).append(" yield the shortest distance of ").append(shortestDistance).append(" km. ");
        }

        // Explain why the chosen travel plans are the best
        explanationBuilder.append("Model are chosen because:\n");

        if (shortestAlgorithms.contains("Dijkstra")) {
            explanationBuilder.append("- ").append("It ensure the shortest overall distance, ensuring the most efficient route for the journey.\n");
        }
        if (shortestAlgorithms.contains("BFS")) {
            explanationBuilder.append("- ").append("It explore all possible paths in a breadth-first manner, which may result in finding optimal routes, especially in scenarios with uniform edge weights.\n");
        }
        if (shortestAlgorithms.contains("DFS")) {
            explanationBuilder.append("- ").append("It explore paths deeply, which can be advantageous in scenarios with complex topologies or when the goal is to exhaustively search for solutions.\n");
        }

        return explanationBuilder.toString();
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            bfsArea.setText("Breadth-First Search:\n");
            dfsArea.setText("Depth-First Search:\n");
            dArea.setText("Dijkstra: \n");

            String depCity = correctCityName((String) dep.getSelectedItem());
            String desCity = correctCityName((String) des.getSelectedItem());

            // Finding routes and updating text areas
            bfs breath = new bfs();
            breath.findRoute(depCity, desCity);
            bfsArea.append(breath.getPath() + "\nTotal distance: " + breath.getDistance() + " km");

            dfs depth = new dfs();
            depth.findRoute(depCity, desCity);
            dfsArea.append(depth.getPath() + "\nTotal distance: " + depth.getDistance() + " km");

            dijkstra dij = new dijkstra();
            dij.findRoute(depCity, desCity);
            dArea.append(dij.getPath() + "\nTotal distance: " + dij.getDistance() + " km");
        }
    }

    private String correctCityName(String cityName) {
        // Extracting the city name without the team name
        int index = cityName.indexOf("(");
        if (index != -1) {
            return cityName.substring(0, index).trim();
        } else {
            return cityName.trim();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Form_3 form = new Form_3();
        });
    }
}
