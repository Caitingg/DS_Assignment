/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import model.Model_MemberProfile;

/**
 *
 * @author user
 */
public class Member_Profile extends javax.swing.JPanel {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst =null;
    private final Model_MemberProfile data;
    
    public Member_Profile(Model_MemberProfile data) {
        initComponents();
        this.data = data;
        setOpaque(false);
        playerID.setText(Integer.toString(data.getPlayerID()));
        nameText.setText(data.getName());
        weightT.setText(Double.toString(data.getWeight()));
        heightT.setText(Double.toString(data.getHeight()));
        positionT.setText(data.getPosition());
        pointT.setText(Integer.toString(data.getPoints()));
        reboundsT.setText(Integer.toString(data.getRebounds()));
        stealsT.setText(Integer.toString(data.getSteals()));
        blockT.setText(Integer.toString(data.getBlocks()));
        assistT.setText(Integer.toString(data.getAssists()));
        startD.setText(String.valueOf(data.getStart()));
        expiredD.setText(String.valueOf(data.getEnd()));
        statusT.setText(data.getStatus());
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        playerID = new javax.swing.JLabel();
        nameText = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        statusT = new javax.swing.JLabel();
        weightT = new javax.swing.JLabel();
        heightT = new javax.swing.JLabel();
        positionT = new javax.swing.JLabel();
        salaryT = new javax.swing.JLabel();
        pointT = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        stealsT = new javax.swing.JLabel();
        blockT = new javax.swing.JLabel();
        assistT = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        reboundsT = new javax.swing.JLabel();
        startD = new javax.swing.JLabel();
        expiredD = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/player1.png"))); // NOI18N

        playerID.setForeground(new java.awt.Color(0, 0, 0));
        playerID.setText("23004979");

        nameText.setForeground(new java.awt.Color(0, 0, 0));
        nameText.setText("Poh Jing Min");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Weight (kg)");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Height  (cm)");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Position");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Salary");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Point");

        statusT.setForeground(new java.awt.Color(0, 0, 0));
        statusT.setText("AVAILABLE");

        weightT.setForeground(new java.awt.Color(0, 0, 0));
        weightT.setText("50");

        heightT.setForeground(new java.awt.Color(0, 0, 0));
        heightT.setText("170");

        positionT.setForeground(new java.awt.Color(0, 0, 0));
        positionT.setText("F");

        salaryT.setForeground(new java.awt.Color(0, 0, 0));
        salaryT.setText("8000");

        pointT.setForeground(new java.awt.Color(0, 0, 0));
        pointT.setText("12");

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Total Rebounds");

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Steals");

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Blocks");

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Assists");

        stealsT.setForeground(new java.awt.Color(0, 0, 0));
        stealsT.setText("5");

        blockT.setForeground(new java.awt.Color(0, 0, 0));
        blockT.setText("5");

        assistT.setForeground(new java.awt.Color(0, 0, 0));
        assistT.setText("5");

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Joined");

        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Expired");

        reboundsT.setForeground(new java.awt.Color(0, 0, 0));
        reboundsT.setText("20");

        startD.setForeground(new java.awt.Color(0, 0, 0));
        startD.setText("20 March 2024");

        expiredD.setForeground(new java.awt.Color(0, 0, 0));
        expiredD.setText("20 March 2025");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameText)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(43, 43, 43)
                                .addComponent(weightT))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel15))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pointT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(salaryT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(positionT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(heightT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reboundsT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(assistT)
                                            .addComponent(blockT)
                                            .addComponent(stealsT)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(startD))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(statusT, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(expiredD)))))
                    .addComponent(playerID))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(playerID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(weightT))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(heightT))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(positionT)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(stealsT))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(blockT))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(assistT))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(salaryT))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(pointT))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(reboundsT)
                                    .addComponent(jLabel15)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(startD))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(expiredD)
                                    .addComponent(jLabel20))
                                .addGap(18, 18, 18)
                                .addComponent(statusT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assistT;
    private javax.swing.JLabel blockT;
    private javax.swing.JLabel expiredD;
    private javax.swing.JLabel heightT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel nameText;
    private javax.swing.JLabel playerID;
    private javax.swing.JLabel pointT;
    private javax.swing.JLabel positionT;
    private javax.swing.JLabel reboundsT;
    private javax.swing.JLabel salaryT;
    private javax.swing.JLabel startD;
    private javax.swing.JLabel statusT;
    private javax.swing.JLabel stealsT;
    private javax.swing.JLabel weightT;
    // End of variables declaration//GEN-END:variables
}
