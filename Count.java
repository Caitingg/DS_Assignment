/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculate;

/**
 *
 * @author ONG KAI YIN
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
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_user_database", "root", "");
            st = con.createStatement();
            String alterTableQuery = "ALTER TABLE agentmarket ADD COLUMN game INT DEFAULT 1";
            st.executeUpdate(alterTableQuery);
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
        String file ="C:\\Users\\ONG KAI YIN\\Downloads\\PlayerStats.csv";
        HashMap<String ,Integer> map = new HashMap<>();
        Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst =null;

    addGameColumn();

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            String [] read;
            
            br.readLine();
            
            while((s=br.readLine())!=null){
                read=s.split(",");
                String name =read[21]+" "+read[22];
                if(map.containsKey(name)){
                    map.put(name, map.get(name)+1);
                }else{
                    map.put(name, 1);
                }
              
                
            }
            
           Class.forName("com.mysql.cj.jdbc.Driver");
              con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_user_database","root","");
          Statement st = con.createStatement();
            for(String i : map.keySet()){
                String sql_insert= "UPDATE agentmarket SET game = '"+map.get(i)+"' WHERE Player_Name =\""+i+"\"";
                st.executeUpdate(sql_insert);
            }
                                 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
