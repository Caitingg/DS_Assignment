/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import java.sql.*;
import Team.performRanking;
import java.util.ArrayList;

import javax.swing.BoxLayout;

import model.Model_playerRanking;
import Team.performRanking.player;
import component.playerRank;
import swing.ScrollBar;


/**
 *
 * @author user
 */
public class Form_7 extends javax.swing.JPanel {


    String userName;
    /**
     * Creates new form Form_7
     */
    public Form_7(String name) {
    this.userName=name;
    initComponents();
    sp.setVerticalScrollBar(new ScrollBar());
    sp.setHorizontalScrollBar(new ScrollBar());
    
    
    
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nba?useSSL=false", "root", "")) {
        performRanking pr=new performRanking(conn,userName);
        ArrayList<performRanking.player> sortedPlayers = pr.getPlayerList();
        int rank = 1;
        panelBorder1.setLayout(new BoxLayout(panelBorder1, BoxLayout.Y_AXIS));;
        
        for (performRanking.player p : sortedPlayers) {
            Model_playerRanking modelPlayer = new Model_playerRanking(p.getImage(),p.getPlayerID(), rank++, p.getGames(), p.getName(), p.getPosition(), p.getCompositeScore(), p.getSteals(), p.getBlocks(), p.getRebounds(), p.getAssists());
            panelBorder1.add(new playerRank(modelPlayer));
            
            // Add modelPlayer to panelBorder1
            
        }
        
    } catch (SQLException ex) {
        System.out.println(ex);
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        panelBorder1 = new swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,80));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("-- Player Performance Ranking --");

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new java.awt.GridLayout(15, 1, 10, 10));
        sp.setViewportView(panelBorder1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(244, 244, 244))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        add(jPanel1);
        jPanel1.setBounds(30, 40, 930, 580);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/background1.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(-140, -60, 1190, 760);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
