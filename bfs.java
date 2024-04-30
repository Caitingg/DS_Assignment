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
public class bfs {
    HashMap<Integer,City>city=new HashMap<>();
    String start,end;
    int s,e;
    LinkedList<Integer>[]adjList;
    
    bfs(){
        initialize();
        adjList=new LinkedList[city.size()];
        
    }
    
    public int findRoute(String st,String en){
        this.start=st;
        this.end=en;
        this.s=getIndex(start);
        this.e=getIndex(end);
        Queue<Integer>queue=new LinkedList<>();
        boolean[]visited=new boolean[city.size()];
        HashMap<Integer,Integer> parentMap=new HashMap<>();
        addAdjList();
        
        visited[s]=true;
        queue.add(s);
        
        while(!queue.isEmpty()){
            int current=queue.poll();
            for(int i:adjList[current]){
                if(!visited[i]){
                    queue.add(i);
                    parentMap.put(i, current);
                    visited[i]=true;
                }
            }
        }
        ArrayList<Integer>route=new ArrayList<>();
        int endCity=e;
        route.add(endCity);
        while(endCity!=s){
            int temp=parentMap.get(endCity);
            endCity=temp;
            route.add(temp);
        }
        Collections.reverse(route);
//        for(int i:route){
//            System.out.print(city.get(i).name+", ");
//        } 
        for(int i=0;i<route.size();i++){
            if(i!=route.size()-1)System.out.print(city.get(route.get(i)).name+" ("+city.get(route.get(i)).team+")"+"-> ");
            else System.out.println(city.get(route.get(i)).name+" ("+city.get(route.get(i)).team+")");
        }
        
        int sum=0;
        cityDigitalModel dm=new cityDigitalModel();
        for(int i=0;i<route.size()-1;i++){
            City c1=city.get(route.get(i));
            City c2=city.get(route.get(i+1));
            sum+=dm.getDistance(c1.name, c2.name);
        }
        return sum;
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
