package route;

import java.awt.Image;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class cityDigitalModel {
    HashMap<String,City>city=new HashMap<>();
    public cityDigitalModel(){
        initialiseCity();
        createConnection();
    }
    
    public void initialiseCity(){
        city.put("San Antonio", new City("San Antonio","Spurs"));
        city.put("Golden State", new City("Golden State","Warriors"));
        city.put("Boston", new City("Boston","Celtics"));
        city.put("Miami", new City("Miami","Heat"));
        city.put("Los Angeles", new City("Los Angeles","Lakers"));
        city.put("Phoenix", new City("Phoenix","Suns"));
        city.put("Orlando", new City("Orlando","Magic"));
        city.put("Denver", new City("Denver","Nuggets"));
        city.put("Oklahoma City", new City("Oklahoma City","Thunder"));
        city.put("Houston", new City("Houston","Rockets"));
        
    }
    private Image resizeImage(Image originalImage, int width, int height) {
        return originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
    public void createConnection(){
        connection("Los Angeles","Golden State",554);
        connection("Los Angeles","Oklahoma City",1901);
        connection("Los Angeles","Phoenix",577);
        connection("Golden State","Denver",1507);
        connection("Golden State","Oklahoma City",2214);
        connection("Oklahoma City","Denver",942);
        connection("Oklahoma City","San Antonio",678);
        connection("Oklahoma City","Houston",778);
        connection("Phoenix","San Antonio",500);
        connection("Denver","Boston",2845);
        connection("Houston","Boston",2584);
        connection("Houston","Orlando",458);
        connection("Houston","San Antonio",983);
        connection("San Antonio","Orlando",1137);
        connection("Boston","Miami",3045);
        connection("Orlando","Miami",268);
    }
    
    
    public void connection(String c1,String c2,int d){
        City city1=city.get(c1);
        City city2=city.get(c2);
        city1.addConnection(city2, d);
        city2.addConnection(city1, d);
    }
    
    public int getDistance(String c1,String c2){
        City city1=city.get(c1);
        City city2=city.get(c2);
        for(Edge e:city1.connection){
            if(e.city==city2){
                return e.distance;
            }
        }
        return -1;
    }
    public City getCity(String name){
        return city.get(name);
    }
    
    public City[]getArray(){
        return (City[]) city.values().toArray(new City[0]);
    }
}

// package route;

// import java.awt.Image;
// import java.io.File;
// import java.io.IOException;
// import java.util.HashMap;
// import javax.imageio.ImageIO;

// public class cityDigitalModel {
//     private HashMap<String, City> cityMap = new HashMap<>();
//     private final int LOGO_WIDTH = 250; // Define the desired width for the logos
//     private final int LOGO_HEIGHT = 300; // Define the desired height for the logos

//     public cityDigitalModel() {
//         initializeCities();
//         createConnections();
//     }

//     private void initializeCities() {
//         try {
//             cityMap.put("San Antonio", new City("San Antonio", "Spurs", 150, 500, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Spurs.png")), LOGO_WIDTH, LOGO_HEIGHT)));
//             cityMap.put("Golden State", new City("Golden State", "Warriors", 100, 50, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Golden State Warriors.png")), LOGO_WIDTH, LOGO_HEIGHT)));
//             cityMap.put("Boston", new City("Boston", "Celtics", 850, 50, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Boston Celtics.png")), LOGO_WIDTH, LOGO_HEIGHT)));
//             cityMap.put("Miami", new City("Miami", "Heat", 850, 600, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Miami Heat.png")), LOGO_WIDTH, LOGO_HEIGHT)));
//             cityMap.put("Los Angeles", new City("Los Angeles", "Lakers", 100, 200, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Los Angeles Lakers.png")), LOGO_WIDTH, LOGO_HEIGHT)));
//             cityMap.put("Phoenix", new City("Phoenix", "Suns", 300, 300, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Phoenix Suns.png")), LOGO_WIDTH, LOGO_HEIGHT)));
//             cityMap.put("Orlando", new City("Orlando", "Magic", 700, 600, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Orlando Magic.png")), LOGO_WIDTH, LOGO_HEIGHT)));
//             cityMap.put("Denver", new City("Denver", "Nuggets", 450, 150, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Denver Nuggets.png")), LOGO_WIDTH, LOGO_HEIGHT)));
//             cityMap.put("Oklahoma City", new City("Oklahoma City", "Thunder", 450, 300, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Oklahoma City Thunder.png")), LOGO_WIDTH, LOGO_HEIGHT)));
//             cityMap.put("Houston", new City("Houston", "Rockets", 600, 450, resizeImage(ImageIO.read(new File("C:\\Users\\Huawei\\IdeaProjects\\DigitalModel\\src\\Houston Rockets.jpg")), LOGO_WIDTH, LOGO_HEIGHT)));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private Image resizeImage(Image originalImage, int width, int height) {
//         return originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
//     }

//     private void createConnections() {
//         addConnection("Los Angeles", "Golden State", 554);
//         addConnection("Los Angeles", "Oklahoma City", 1901);
//         addConnection("Los Angeles", "Phoenix", 577);
//         addConnection("Golden State", "Denver", 1507);
//         addConnection("Golden State", "Oklahoma City", 2214);
//         addConnection("Oklahoma City", "Denver", 942);
//         addConnection("Oklahoma City", "San Antonio", 678);
//         addConnection("Oklahoma City", "Houston", 778);
//         addConnection("Phoenix", "San Antonio", 500);
//         addConnection("Denver", "Boston", 2845);
//         addConnection("Houston", "Boston", 2584);
//         addConnection("Houston", "Orlando", 458);
//         addConnection("Houston", "San Antonio", 983);
//         addConnection("San Antonio", "Orlando", 1137);
//         addConnection("Boston", "Miami", 3045);
//         addConnection("Orlando", "Miami", 268);
//     }

//     private void addConnection(String city1Name, String city2Name, int distance) {
//         City city1 = cityMap.get(city1Name);
//         City city2 = cityMap.get(city2Name);
//         if (city1 != null && city2 != null) {
//             city1.addConnection(city2, distance);
//             city2.addConnection(city1, distance);
//         }
//     }

//     public int getDistance(String city1Name, String city2Name) {
//         City city1 = cityMap.get(city1Name);
//         City city2 = cityMap.get(city2Name);
//         if (city1 != null && city2 != null) {
//             for (Edge e : city1.getConnection()) {
//                 if (e.getCity().equals(city2)) {
//                     return e.getDistance();
//                 }
//             }
//         }
//         return -1;
//     }

//     public City getCity(String name) {
//         return cityMap.get(name);
//     }

//     public City[] getArray() {
//         return cityMap.values().toArray(new City[0]);
//     }
// }

