/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import route.bfs;
import route.dfs;
import route.dijkstra;


/**
 *
 * @author user
 */
public class Form_3 implements ActionListener{
    JButton submit;
    JTextArea bfsArea;
    JTextArea dfsArea;
    JTextArea dArea;
    JComboBox dep;
    JComboBox des;
    private JPanel jPanel2;
    
    public Form_3(){
        
        
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
        textPanel.setBounds(69,460,850,130);
        
        submit=new JButton("Find");
        submit.setBounds(420,425,150,20);
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
        desOption.setBounds(560,390,350,25);
        
        JPanel depOption=new JPanel();
        depOption.setLayout(new GridLayout(1,2));
        depOption.add(departure);
        depOption.add(dep);
        depOption.setBounds(70,390,400,25);
        depOption.setOpaque(false);
        
        JLabel map=new JLabel();
        ImageIcon mapImage=new ImageIcon("map.png");
        Image mImage=mapImage.getImage();
        Image mTemp=mImage.getScaledInstance(650, 500, Image.SCALE_SMOOTH);
        mapImage=new ImageIcon(mTemp);
        map.setIcon(mapImage);
        map.setHorizontalAlignment(JLabel.CENTER);
        //map.setVerticalAlignment(JLabel.TOP);
        map.setBounds(185,-100,650,500);
        
        jPanel2=new JPanel();
        jPanel2.add(map);
        jPanel2.setBackground(new Color(0, 0, 0,125));
        jPanel2.setBounds(20,-100,949,600);
        //jPanel2.setLayout(null);
        
        
//        JLabel title=new JLabel("Find Your Route");
//        title.setFont(new Font("Montserrat",Font.BOLD,50));
//        title.setForeground(Color.white);
//        title.setBounds(200,0,600,100);
        
        ImageIcon background=new ImageIcon("background5.jpeg");
        Image image=background.getImage();
        Image temp=image.getScaledInstance(989,646, Image.SCALE_SMOOTH);
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
        backPhoto.add(jPanel2);
        
        
        JFrame frame=new JFrame();
        frame.add(backPhoto);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(989,646);
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
