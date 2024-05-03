/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author ONG KAI YIN
 */

import java.io.*;


public class test {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ONG KAI YIN\\Downloads\\Player.csv"));
            br.readLine();
            String s ;
            String [] data;
            
            while((s=br.readLine())!=null){
               data=s.split(",");
                System.out.println(Integer.parseInt(data[0].substring(1, data[0].length()-1)));
                break;
            }
            
        }catch(IOException e){
           e.printStackTrace();
        }
    }
}
