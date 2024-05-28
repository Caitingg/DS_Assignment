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

public class CsvToSql {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pst = null;
        String filepath = "Player.csv";
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/java_user_database","root","");
            
            // SQL query
            String sql = "INSERT INTO agentmarket (Player_ID, Player_Name, Weight, Height, Position, Salary, Points, TotalRebounts, Assists, Steals, Blocks,game) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            pst = con.prepareStatement(sql);
            
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String line;
            String[] data;
            int count = 0;
            int batchSize = 20;

            // Skip header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                data = line.split(",");

                int playerId = Integer.parseInt(data[0]);

                // Insert only players with IDs 115, 236, and 405
                if (playerId == 115 || playerId == 236 || playerId == 405) {
                    pst.setInt(1, playerId);
                    pst.setString(2, data[1]);
                    pst.setDouble(3, Double.parseDouble(data[2]));
                    pst.setDouble(4, Double.parseDouble(data[3]));
                    pst.setString(5, data[4]);
                    pst.setDouble(6, Double.parseDouble(data[5]));
                    pst.setDouble(7, Double.parseDouble(data[6]));
                    pst.setDouble(8, Double.parseDouble(data[7]));
                    pst.setDouble(9, Double.parseDouble(data[8]));
                    pst.setDouble(10, Double.parseDouble(data[9]));
                    pst.setDouble(11, Double.parseDouble(data[10]));
                    pst.setInt(12, 0);
                    pst.addBatch();

                    count++;

                    if (count % batchSize == 0) {
                        pst.executeBatch();
                    }
                }
            }

            // Execute the remaining batch
            pst.executeBatch();

            br.close();
            pst.close();
            con.close();
            
            System.out.println("Data has been successfully inserted!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

