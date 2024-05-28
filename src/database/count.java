/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author user
 */
import java.util.HashMap;
import java.io.*;
import java.sql.*;


public class Count {
    
     private static void addGameColumn() {
        Connection con = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/java_user_database", "root", "");
            st = con.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        String file ="PlayerStats.csv";
        HashMap<Integer,Integer> map = new HashMap<>();
        Connection con = null;

//    addGameColumn();

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            String [] read;
            
            br.readLine();
            
            while((s=br.readLine())!=null){
                read=s.split(",");
                
                int id=Integer.parseInt(read[20].substring(1, read[20].length()-1));
                if(map.containsKey(id)){
                    map.put(id, map.get(id)+1);
                }else{
                    map.put(id, 1);
                }
              
                
            }
            
           Class.forName("com.mysql.cj.jdbc.Driver");
              con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/java_user_database","root","");
          Statement st = con.createStatement();
            for(int i : map.keySet()){
                
                String sql_insert= "UPDATE agentmarket SET game = "+map.get(i)+" WHERE Player_ID = "+i;
                System.out.println(sql_insert);
                st.executeUpdate(sql_insert);
            }
                                 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
