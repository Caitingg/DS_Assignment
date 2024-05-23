/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import com.sun.jdi.connect.spi.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Model_PlayerStatusProfile;

/**
 *
 * @author user
 */
public class PlayerStatusProfile extends javax.swing.JPanel {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst =null;
    
    public PlayerStatusProfile(Model_PlayerStatusProfile data) {
        initComponents();
        setOpaque(false);
//        lbIcon.setIcon(data.getIcon());
        playerID.setText(Integer.toString(data.getPlayerID()));
        nameText.setText(data.getName());
        cScoreT.setText(Double.toString(data.getCompositeScore()));
        startD.setText(data.getStart().toString());
//      rankT.setText(data.getRank());
        expiredD.setText(data.getEnd().toString());
        statusT.setText(data.getStatus());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        playerID = new javax.swing.JLabel();
        nameText = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        statusT = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        startD = new javax.swing.JLabel();
        expiredD = new javax.swing.JLabel();
        cScoreT = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        rankT = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        lbIcon.setBackground(new java.awt.Color(255, 255, 255));
        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/player1.png"))); // NOI18N

        playerID.setForeground(new java.awt.Color(0, 0, 0));
        playerID.setText("23004979");

        nameText.setForeground(new java.awt.Color(0, 0, 0));
        nameText.setText("Poh Jing Min");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Composite Score");

        statusT.setForeground(new java.awt.Color(0, 0, 0));
        statusT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusT.setText("AVAILABLE");

        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Expired");

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Joined");

        startD.setForeground(new java.awt.Color(0, 0, 0));
        startD.setText("20 March 2024");

        expiredD.setForeground(new java.awt.Color(0, 0, 0));
        expiredD.setText("20 March 2025");

        cScoreT.setForeground(new java.awt.Color(0, 0, 0));
        cScoreT.setText("95.5");

        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Rank");

        rankT.setForeground(new java.awt.Color(0, 0, 0));
        rankT.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameText)
                    .addComponent(playerID)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel3))
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expiredD, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rankT)
                            .addComponent(cScoreT)
                            .addComponent(startD))
                        .addGap(62, 62, 62)
                        .addComponent(statusT, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rankT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cScoreT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(startD)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(expiredD))
                                    .addComponent(statusT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(playerID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cScoreT;
    private javax.swing.JLabel expiredD;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel nameText;
    private javax.swing.JLabel playerID;
    private javax.swing.JLabel rankT;
    private javax.swing.JLabel startD;
    private javax.swing.JLabel statusT;
    // End of variables declaration//GEN-END:variables
}
