package route;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class CityDigitalModelGUI extends JPanel {
    private cityDigitalModel model;
    private Map<City, Point> cityPositions;
    private City selectedCity;
    private Point offset;

    public CityDigitalModelGUI(cityDigitalModel model) {
        this.model = model;
        this.cityPositions = new HashMap<>();

        for (City city : model.getArray()) {
            cityPositions.put(city, new Point(city.getX(), city.getY()));
        }

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (City city : model.getArray()) {
                    Point p = cityPositions.get(city);
                    if (e.getPoint().distance(p) < 20) {
                        selectedCity = city;
                        offset = new Point(e.getX() - p.x, e.getY() - p.y);
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedCity = null;
                offset = null;
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedCity != null) {
                    int newX = e.getX() - offset.x;
                    int newY = e.getY() - offset.y;
                    selectedCity.setX(newX);
                    selectedCity.setY(newY);
                    cityPositions.put(selectedCity, new Point(newX, newY));
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Huawei\\IdeaProjects\\DS\\src\\icon\\background5.jpeg");
        Image image = backgroundImage.getImage();

        // Draw the background image
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

        Graphics2D g2d = (Graphics2D) g;

        // Set stroke for drawing lines (bold)
        Stroke oldStroke = g2d.getStroke();
        g2d.setStroke(new BasicStroke(4)); // Adjust thickness as needed

        // Set font for drawing text
        Font oldFont = g2d.getFont();
        Font font = new Font("Arial", Font.BOLD, 15); // Adjust font and size as needed
        g2d.setFont(font);

        // Set color to white for lines and distance text
        g2d.setColor(Color.WHITE);

        for (City city : model.getArray()) {
            Point p = cityPositions.get(city);

            // Draw connections and distances
            for (Edge edge : city.getConnection()) {
                City connectedCity = edge.getCity();
                Point connectedPoint = cityPositions.get(connectedCity);

                // Draw bold line
                g2d.drawLine(p.x, p.y, connectedPoint.x, connectedPoint.y);

                // Calculate the midpoint for placing the distance
                int midX = (p.x + connectedPoint.x) / 2;
                int midY = (p.y + connectedPoint.y) / 2;

                // Draw distance with white font
                g2d.drawString(edge.getDistance() + " km", midX, midY);
            }
        }

        // Restore original stroke and font
        g2d.setStroke(oldStroke);
        g2d.setFont(oldFont);

        for (City city : model.getArray()) {
            Point p = cityPositions.get(city);

            // Draw city logo
            Image logo = city.getLogo();
            int logoWidth = logo.getWidth(this); // Get the actual width of the logo
            int logoHeight = logo.getHeight(this); // Get the actual height of the logo

            // Define a scaling factor to adjust the size of the logo
            double scaleFactor = 0.5; // Adjust this value as needed

            // Calculate the scaled width and height of the logo
            int scaledLogoWidth = (int) (logoWidth * scaleFactor);
            int scaledLogoHeight = (int) (logoHeight * scaleFactor);

            // Draw the scaled logo centered at the city's position
            g.drawImage(logo, p.x - (scaledLogoWidth / 2), p.y - (scaledLogoHeight / 2), scaledLogoWidth, scaledLogoHeight, this);

            // Draw city name
            g.drawString(city.getName(), p.x + 20, p.y + 5);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            cityDigitalModel model = new cityDigitalModel();

            JFrame frame = new JFrame("NBA Cities Map");
            CityDigitalModelGUI panel = new CityDigitalModelGUI(model);
            panel.setPreferredSize(new Dimension(1000, 700));
            frame.add(panel);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

