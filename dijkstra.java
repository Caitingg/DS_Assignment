/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds_assignment;

import java.util.*;

/**
 *
 * @author User
 */
public class dijkstra {
    int start,end;
    HashMap <Integer,City>city=new HashMap<>();
    LinkedList<Integer>[]adjList;
    HashMap <Integer,Integer>distanceMap=new HashMap<>();
    StringBuilder routes=new StringBuilder();
    int totalDistance=0;
    
    dijkstra(){
        initialize();
        adjList=new LinkedList[city.size()];
        addAdjList();
    }
    
    public void findRoute(String st,String en){
        this.start=getIndex(st);
        this.end=getIndex(en);      
        
        HashMap<Integer,Integer>parentMap=new HashMap<>();
        ArrayList<Integer>settled=new ArrayList<>();
        Queue<Integer>unsettled=new LinkedList<>();
        initializeDistance();
        cityDigitalModel dm=new cityDigitalModel();
        
        distanceMap.put(start, 0);
        unsettled.add(start);
        
        while(!unsettled.isEmpty()){
            int current=unsettled.poll();
            int sourceD=distanceMap.get(current);
            for(int i:adjList[current]){
                if(!settled.contains(i)){
                    int edgeW=dm.getDistance(city.get(current).name, city.get(i).name);
                    if(sourceD+edgeW<distanceMap.get(i)){
                        distanceMap.put(i,sourceD+edgeW );
                        parentMap.put(i, current);
                        
                }
                if(!unsettled.contains(i))unsettled.add(i);
            }
            }
            settled.add(current);
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
        for(int i=0;i<route.size()-1;i++){
            City c1=city.get(route.get(i));
            City c2=city.get(route.get(i+1));
            sum+=dm.getDistance(c1.name, c2.name);
        }
        this.totalDistance=sum;
        
        
    }
    
    public String getRoute(){
        return this.routes.toString();
    }
    public int getDistance(){
        return this.totalDistance;
    }
    
//    public void minimumDistance(int sourceD,int edgeW,int edgeIndex){
//        if(sourceD+edgeW<distanceMap.get(edgeIndex)){
//            distanceMap.put(edgeIndex,sourceD+edgeW );
//        }
//    }
    
    public void initializeDistance(){
        distanceMap.put(0, Integer.MAX_VALUE);
        distanceMap.put(1, Integer.MAX_VALUE);
        distanceMap.put(2, Integer.MAX_VALUE);
        distanceMap.put(3, Integer.MAX_VALUE);
        distanceMap.put(4, Integer.MAX_VALUE);
        distanceMap.put(5, Integer.MAX_VALUE);
        distanceMap.put(6, Integer.MAX_VALUE);
        distanceMap.put(7, Integer.MAX_VALUE);
        distanceMap.put(8, Integer.MAX_VALUE);
        distanceMap.put(9, Integer.MAX_VALUE);
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
