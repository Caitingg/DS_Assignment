package ds_assignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class route_gui implements ActionListener{
    JButton submit;
    JTextArea bfsArea;
    JTextArea dfsArea;
    JTextArea dArea;
    JComboBox dep;
    JComboBox des;
    
    route_gui(){
        
        
        Font font=new Font("Montserrat", Font.BOLD, 16);
        bfsArea=new JTextArea();
        bfsArea.append("Breadth-First Search:\n");
        bfsArea.setEditable(false);
        bfsArea.setOpaque(false);
        bfsArea.setFont(font);
        bfsArea.setLineWrap(true); 
        bfsArea.setWrapStyleWord(true);
        
        dfsArea=new JTextArea();
        dfsArea.append("Depth-First Search:\n");
        dfsArea.setEditable(false);
        dfsArea.setOpaque(false);
        dfsArea.setFont(font);
        dfsArea.setLineWrap(true); 
        dfsArea.setWrapStyleWord(true);
        
        dArea=new JTextArea();
        dArea.append("Dijkstra:\n");
        dArea.setEditable(false);
        dArea.setOpaque(false);
        dArea.setFont(font);
        dArea.setLineWrap(true); 
        dArea.setWrapStyleWord(true);
        
        JScrollPane dfsPane=new JScrollPane(dfsArea);
        JScrollPane bfsPane=new JScrollPane(bfsArea);
        JScrollPane dPane=new JScrollPane(dArea);
        
        JPanel textPanel=new JPanel();
        textPanel.setLayout(new GridLayout(1,3));
        textPanel.add(bfsPane);
        textPanel.add(dfsPane);
        textPanel.add(dPane);
        textPanel.setBounds(25,435,850,120);
        
        submit=new JButton("Find");
        submit.setBounds(400,405,100,20);
        submit.addActionListener(this);
        submit.setFocusable(false);
        
        JLabel departure=new JLabel("Departure Point: ");
        departure.setFont(new Font("Montserrat", Font.BOLD, 24));
        //departure.setOpaque(false);
        departure.setForeground(Color.white);
        
        String[]city={"San Antonio (Spurs)","Golden State (Warriors)","Boston (Celtics)","Miami (Heat)","Los Angeles (Lakers)","Phoenix (Suns)","Orlando (Magic)","Denver (Nuggets)","Oklahoma City (Thunder)","Houston (Rockets)"};
        dep=new JComboBox(city);
        
        JLabel destination=new JLabel("Destination: ");
        destination.setFont(new Font("Montserrat", Font.BOLD, 24));
        destination.setForeground(Color.white);
        
        des=new JComboBox(city);
        
        JPanel desOption=new JPanel();
        desOption.setLayout(new GridLayout(1,2));
        desOption.add(destination);
        desOption.add(des);
        desOption.setOpaque(false);
        desOption.setBounds(500,375,350,25);
        
        JPanel depOption=new JPanel();
        depOption.setLayout(new GridLayout(1,2));
        depOption.add(departure);
        depOption.add(dep);
        depOption.setBounds(25,375,400,25);
        depOption.setOpaque(false);
        
        JLabel map=new JLabel();
        ImageIcon mapImage=new ImageIcon("nba city map.png");
        Image mImage=mapImage.getImage();
        Image mTemp=mImage.getScaledInstance(650, 350, Image.SCALE_SMOOTH);
        mapImage=new ImageIcon(mTemp);
        map.setIcon(mapImage);
        map.setHorizontalAlignment(JLabel.CENTER);
        map.setBounds(125,20,650,350);
        
        
//        JLabel title=new JLabel("Find Your Route");
//        title.setFont(new Font("Montserrat",Font.BOLD,50));
//        title.setForeground(Color.white);
//        title.setBounds(200,0,600,100);
        
        ImageIcon background=new ImageIcon("leaderboardBackground.png");
        Image image=background.getImage();
        Image temp=image.getScaledInstance(900,600, Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel backPhoto = new JLabel(); 
        backPhoto.setIcon(background);
        backPhoto.setHorizontalAlignment(JLabel.CENTER);
        backPhoto.setLayout(null);
//        backPhoto.add(title);
        backPhoto.add(map);
        backPhoto.add(depOption);
        backPhoto.add(desOption);
        backPhoto.add(submit);
        backPhoto.add(textPanel);
        
        JFrame frame=new JFrame();
        frame.add(backPhoto);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,600);
        frame.setTitle("Find Your Route");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            bfsArea.setText("Breadth-First Search:\n");
            dfsArea.setText("Depth-First Search:\n");
            dArea.setText("Dijkstra: \n");
            
            String depCity=correctCityName((String)dep.getSelectedItem());
            String desCity=correctCityName((String)des.getSelectedItem());
            
            bfs breath=new bfs();
            breath.findRoute(depCity, desCity);
            dfs depth=new dfs();
            depth.findRoute(depCity,desCity);
            dijkstra dij=new dijkstra();
            dij.findRoute(depCity,desCity);
            
            bfsArea.append(breath.getRoute()+"\n");
            bfsArea.append("Distance: "+breath.getDistance()+" km");
            dfsArea.append(depth.getRoute()+"\n");
            dfsArea.append("Distance: "+depth.getDistance()+" km");
            dArea.append(dij.getRoute()+"\n");
            dArea.append("Distance: "+dij.getDistance()+" km");
        }
    }
    
    public String correctCityName(String s){
        
        int index=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                index=i;
                break;
            }
        }
        return s.substring(0,(index-1));
    }
}
