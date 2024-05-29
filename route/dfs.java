package route;

import java.util.*;

public class dfs {
    int start,end;
    HashMap <Integer,City>city=new HashMap<>();
    LinkedList<Integer>[]adjList;
    StringBuilder routes=new StringBuilder();
    int totalDistance=0;
    
    public dfs( ){
        initialize();
        adjList=new LinkedList[city.size()];
        addAdjList();
    }
    
    public void findRoute(String s,String e){
        this.start=getIndex(s);
        this.end=getIndex(e);
        HashMap<Integer,Integer>parentMap=new HashMap<>();
        Stack<Integer>stack=new Stack<>();
        boolean[]visited=new boolean[city.size()];
        
        visited[start]=true;
        stack.push(start);
        while(!stack.isEmpty()){
            int current=stack.pop();
            for(int i:adjList[current]){
                if(!visited[i]){
                    stack.push(i);
                    visited[i]=true;
                    parentMap.put(i, current);
                }
            }
        }
        ArrayList<Integer>route=new ArrayList<>();
        route.add(end);
        while(end!=start){
            int temp=parentMap.get(end);
            end=temp;
            route.add(temp);
        }
        Collections.reverse(route);
        
        for(int i=0;i<route.size();i++){
            if(i!=route.size()-1)routes.append(city.get(route.get(i)).name+" ("+city.get(route.get(i)).team+")"+"-> ");
            else routes.append(city.get(route.get(i)).name+" ("+city.get(route.get(i)).team+")");
        }
        
        int sum=0;
        cityDigitalModel dm=new cityDigitalModel();
        for(int i=0;i<route.size()-1;i++){
            City c1=city.get(route.get(i));
            City c2=city.get(route.get(i+1));
            sum+=dm.getDistance(c1.name, c2.name);
        }
        this.totalDistance=sum;
    }
    
    public String getRoute(){
        return routes.toString();
    }
    public int getDistance(){
        return totalDistance;
    }
    
    public void addAdjList(){
        for(int i=0;i<city.size();i++){
            adjList[i]=new LinkedList<>();
            ArrayList<Edge>list=city.get(i).getConnection();
            for(Edge e:list){
                adjList[i].add(getIndex(e.city.name));
            }
        }
        
    }
    
     public void initialize(){
        cityDigitalModel dm=new cityDigitalModel();
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
    

    public int getIndex(String name){
        for(int i:city.keySet()){
            if(city.get(i).name.equals(name))return i;
        }
        return -1;
    }
}