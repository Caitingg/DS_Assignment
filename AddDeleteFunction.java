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


public class AddDeleteFunction {
    
    
    /*
    add player function
    */
    public static void addPlayer(String name){
        
        // file store agents markets players at agent market
         String File="C:\\Users\\ONG KAI YIN\\Desktop\\Players.txt";
         
         // file store teams player
         String TeamFile="C:\\Users\\ONG KAI YIN\\Desktop\\team.txt";
         
       
         try {
             BufferedReader br = new BufferedReader(new FileReader(File));
             String r;
             String [] read;
             
             // check whether got player added
             boolean check=false;
             
             // use fo rewrite data
             int count=0;
             
             while((r=br.readLine())!=null){
                 read=r.split(",");
                 Player player = new Player(read[0],Integer.parseInt(read[1]),Double.parseDouble(read[2]),Double.parseDouble(read[3]),read[4],Integer.parseInt(read[5]),Double.parseDouble(read[6]),Double.parseDouble(read[7]),Double.parseDouble(read[8]),Double.parseDouble(read[9]),Double.parseDouble(read[10]));
                 
                 // if found the name on market then just put it on team file
                 if(read[0].equals(name)){
                     AppendData(player.toString(),TeamFile);
                     
                     // means the player added succesfully
                     check=true;
                 }else{
                     
                     // rewrite player at agent market file
                    if(count==0){
                       RewriteData(player.toString(),File);
                       count++;
                    }else{
                        
                        // append player at agent market file
                        AppendData(player.toString(),File);
                    }
                 }
             }
             
            if(check){
                System.out.println(name+" successfully added to team");
            }else{
                System.out.println(name+" is not found ");
            }
             printTeam();
             br.close();
             
         }catch(IOException e){
            e.printStackTrace();
         }
         
         
    }
    
   
    
    /*
    delete player function
    */
    public static void deletePlayer(String name){
        
        // file store agent markets players at agent market
         String File="C:\\Users\\ONG KAI YIN\\Desktop\\Players.txt";
         
         // file store teams player
         String TeamFile="C:\\Users\\ONG KAI YIN\\Desktop\\team.txt";
        
         try{
             BufferedReader br = new BufferedReader(new FileReader(TeamFile));
             String r;
             String read[];
             
             // use for rewrite data
             int count=0;
             
             // check whether player is delete
             boolean check=false;
             
             while((r=br.readLine())!=null){
               read=r.split(",");
               Player player = new Player(read[0],Integer.parseInt(read[1]),Double.parseDouble(read[2]),Double.parseDouble(read[3]),read[4],Integer.parseInt(read[5]),Double.parseDouble(read[6]),Double.parseDouble(read[7]),Double.parseDouble(read[8]),Double.parseDouble(read[9]),Double.parseDouble(read[10]));
               
               // if the player name is not equal that we wan to delete just put rewrite into the teamfile
               if(!read[0].equalsIgnoreCase(name)){
                   
                   // rewrite data in team file
                   if(count==0){
                       RewriteData(player.toString(),TeamFile);
                       count++;
                   }else{
                       
                       // append data in team file
                       AppendData(player.toString(),TeamFile);
                       
                   }
                   
               }else{
                   
                   // Put back agent market file
                   // player is delete
                  AppendData(player.toString(),File);
                  check=true;
               }
             }
             
             if(check){
                 System.out.println(name+" is successfully removed form team ");
             }else{
                 System.out.println(name+" is not found in your team");
             }
             printTeam();
             br.close();
             
         }catch(IOException e){
            e.printStackTrace();
         }
    }
    
    /*
    rewrite data in text file
    */
    public static void RewriteData(String data, String file){
        try{
        PrintWriter pw = new PrintWriter(new FileOutputStream(file));
        pw.write(data);
        pw.close();
        
        }catch(FileNotFoundException e){
           e.printStackTrace();
        }
    }
    
    /*
     after rewrite function use append 
     append data 
    */
      public static void AppendData(String data,String file){  
        try{
        PrintWriter pw = new PrintWriter(new FileOutputStream(file,true));
        pw.write(data);
        pw.close();
        
        }catch(FileNotFoundException e){
           e.printStackTrace();
        }
    }
    
    /*
      print team members in table form
      */
        public static void printTeam(){
            String file="C:\\Users\\ONG KAI YIN\\Desktop\\team.txt";
            String s;
            String read[];
            System.out.println("The team member :");
            System.out.println("-".repeat(135));
            System.out.printf("|%10s       |%5s  |%8s  |%8s  |%10s |%7s  | %7s   |%10s  |%10s  |%10s  |%10s  |\n","Name","Age","Height","Weight","Position","Salary","Points","Rebounds","Assists","Steals","Blocks");
            System.out.print("-".repeat(135));
            System.out.println("");

            try{
                BufferedReader br = new BufferedReader(new FileReader(file));
                while((s=br.readLine())!=null){
                    read=s.split(",");
                Player player = new Player(read[0],Integer.parseInt(read[1]),Double.parseDouble(read[2]),Double.parseDouble(read[3]),read[4],Integer.parseInt(read[5]),Double.parseDouble(read[6]),Double.parseDouble(read[7]),Double.parseDouble(read[8]),Double.parseDouble(read[9]),Double.parseDouble(read[10]));
                    System.out.print(player.printPlayer());
                    System.out.println("-".repeat(135));
                }
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            
        }
    
    public static void main(String[] args) {
        //deletePlayer("Curry");
        //addPlayer("Curry");
    }
}
