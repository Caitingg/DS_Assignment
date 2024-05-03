/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ONG KAI YIN
 */
public class database {
     public static Connection mycon(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root",""); // connection to database
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        return con;
    }
}
