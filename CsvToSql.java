/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author ONG KAI YIN
 */

import java.sql.*;
import java.io.*;

public class CsvToSql {
    public static void main(String[] args) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst =null;
        String filepath="C:\\Users\\ONG KAI YIN\\Downloads\\Player.csv";
        
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nba","root","");
            
            // sql queries
            String sql="INSERT INTO TeamPlayer (Player_ID , Player_Name , Weight , Height , Position , Salary , Points , TotalRebounts , Assists , Steals , Blocks) values(?,?,?,?,?,?,?,?,?,?,?) ";
            pst=con.prepareStatement(sql);
            
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            
            String line;
            String [] data;
            
            int count=0;
            int batchSize=20;
            
            br.readLine();
            while((line=br.readLine())!=null){
               data=line.split(",");
               
               // the data get from csv is in "___" format need to extract it
              pst.setInt(1,Integer.parseInt(data[0].substring(1, data[0].length()-1)));
              pst.setString(2,data[1].substring(1, data[1].length()-1));
               pst.setDouble(3,Double.parseDouble(data[2].substring(1, data[2].length()-1)) );
               pst.setDouble(4, Double.parseDouble(data[3].substring(1, data[3].length()-1)));
              pst.setString(5, data[4].substring(1, data[4].length()-1));
               pst.setInt(6, Integer.parseInt(data[5].substring(1, data[5].length()-1)));
               pst.setInt(7, Integer.parseInt(data[6].substring(1, data[6].length()-1)));
               pst.setInt(8, Integer.parseInt(data[7].substring(1, data[7].length()-1)));
               pst.setInt(9, Integer.parseInt(data[8].substring(1, data[8].length()-1)));
              pst.setInt(10, Integer.parseInt(data[9].substring(1, data[9].length()-1)));
              pst.setInt(11, Integer.parseInt(data[10].substring(1, data[10].length()-1)));
              pst.addBatch();
              
             count++;
              if(count%batchSize==0)
                  pst.executeBatch();
           
            }
            
            br.close();
            pst.close();
            con.close();
            
            
            System.out.println("Data has been successfully inserted !!!");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
