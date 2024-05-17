/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author user
 */
import java.sql.*;
import java.io.*;

/*
   put csv data into mysql
*/

public class CsvToSql {
    public static void main(String[] args) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst =null;
        String filepath="C:\\Users\\user\\Downloads\\Player.csv";
        
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_user_database","root","");
            
            // sql queries
            String sql="INSERT INTO agentmarket (Player_ID , Player_Name , Weight , Height , Position , Salary , Points , TotalRebounts , Assists , Steals , Blocks) values(?,?,?,?,?,?,?,?,?,?,?) ";
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
              pst.setInt(1,Integer.parseInt(data[0]));
              pst.setString(2,data[1]);
              pst.setDouble(3,Double.parseDouble(data[2]) );
              pst.setDouble(4, Double.parseDouble(data[3]));
              pst.setString(5, data[4]);
              pst.setInt(6, Integer.parseInt(data[5]));
              pst.setInt(7, Integer.parseInt(data[6]));
              pst.setInt(8, Integer.parseInt(data[7]));
              pst.setInt(9, Integer.parseInt(data[8]));
              pst.setInt(10, Integer.parseInt(data[9]));
              pst.setInt(11, Integer.parseInt(data[10]));
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
