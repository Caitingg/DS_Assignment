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