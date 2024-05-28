/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import Team.*;
import component.Member_Profile;
import java.sql.*;
import java.util.*;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import model.Model_MemberProfile;
import swing.ScrollBar;

/**
 *
 * 
 * Temporary set userName to Ali hahahaha
 * 
 * 
 * 
 */
public class Form_2 extends javax.swing.JPanel {
    String userName="Ali";
    InjuryReserve reserve;
    
    public Form_2() {
        initComponents();
        init();
    }

    private void init(){
        Connection connection = null;
        sp2.setVerticalScrollBar(new ScrollBar());
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nba?useSSL=false","root","");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        sp2.setVerticalScrollBar(new ScrollBar());
        //Clear existing components
       //panelProfile.removeAll();
        
       contract c=new contract();
        c.initialise(connection,userName);
        ArrayList<TeamPlayer>list=c.getTeamList();
        List<Model_MemberProfile>memberList=new ArrayList<>();
        for(TeamPlayer p:list){
            TeamPlayer tempPlayer=p;
            memberList.add(new Model_MemberProfile(tempPlayer.getPlayer_id(),tempPlayer.getPlayer_Name(),tempPlayer.getPosition(),tempPlayer.getStatus(),tempPlayer.getCompositeScore(),tempPlayer.getStartDate(),tempPlayer.getEndDate()));
        }
        
       
       panelBorder2.setLayout(new BoxLayout(panelBorder2, BoxLayout.Y_AXIS));
       // Iterate over the list and add each profile to the panel
        for (Model_MemberProfile modal : memberList) {
            Member_Profile profile=new Member_Profile(modal);
            
            panelBorder2.add(profile);
            
        }
        reserve=new InjuryReserve(userName);
        listArea.setText(reserve.toString());

        
        
         // Refresh the panel to show the newly added components
        // panelMemberP.revalidate();
        // panelMemberP.repaint();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        panelMemberP = new javax.swing.JPanel();
        sp2 = new javax.swing.JScrollPane();
        panelBorder2 = new swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        reasonField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        recoverButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listArea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        idField2 = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        panelBorder1.setLayout(null);

        panelMemberP.setBackground(new java.awt.Color(0, 0, 0,80));

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        sp2.setViewportView(panelBorder2);

        jLabel2.setFont(new java.awt.Font("Castellar", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("View Team Info");

        javax.swing.GroupLayout panelMemberPLayout = new javax.swing.GroupLayout(panelMemberP);
        panelMemberP.setLayout(panelMemberPLayout);
        panelMemberPLayout.setHorizontalGroup(
            panelMemberPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMemberPLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelMemberPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        panelMemberPLayout.setVerticalGroup(
            panelMemberPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMemberPLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sp2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelBorder1.add(panelMemberP);
        //panelMemberP.add(panelBorder1);
        panelMemberP.setBounds(30, 20, 690, 600);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,80));

        jLabel3.setFont(new java.awt.Font("Castellar", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Manage Injury");

        jLabel6.setText("Reason");

        

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Player ID");

        

        recoverButton.setText("Recovered");
        recoverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recoverButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Castellar", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("view injury list");

        listArea.setColumns(20);
        listArea.setRows(5);
        jScrollPane1.setViewportView(listArea);

        jLabel8.setText("Player ID");

        

        updateButton.setText("Update");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reasonField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idField2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(recoverButton)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(updateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(reasonField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(idField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(recoverButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        panelBorder1.add(jPanel1);
        jPanel1.setBounds(730, 20, 250, 600);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/court.jpg"))); // NOI18N
        panelBorder1.add(jLabel1);
        jLabel1.setBounds(0, 0, 990, 640);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(idField.getText()==null||reasonField.getText()==null){
            JOptionPane.showMessageDialog(null, "Please enter valid id and valid reason", "Try Again" ,JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id=Integer.parseInt(idField.getText());
        String reason=reasonField.getText();

        
        if(reserve.addToInjuryReserve(id, reason)){
            listArea.setText(reserve.toString());
        }
        else{
            JOptionPane.showMessageDialog(null, "The player id entered is invalid or the player already in injury list", "Try again" ,JOptionPane.ERROR_MESSAGE);
        }
        idField.setText("");
        reasonField.setText("");
    }

    private void recoverButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
        
        
        if(reserve.removeFromInjuryReserve()){
            listArea.setText(reserve.toString());
        }
        else{
            JOptionPane.showMessageDialog(null, "The injury list is empty!", "Try again" ,JOptionPane.ERROR_MESSAGE);
        }
        
    }

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton updateButton;
    private javax.swing.JButton recoverButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea listArea;
    private javax.swing.JTextField reasonField;
    private javax.swing.JTextField idField;
    private javax.swing.JTextField idField2;
    private swing.PanelBorder panelBorder1;
    private swing.PanelBorder panelBorder2;
    private javax.swing.JPanel panelMemberP;
    private javax.swing.JScrollPane sp2;
    // End of variables declaration//GEN-END:variables
}
