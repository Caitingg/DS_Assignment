/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import Team.Team;
import component.PlayerProfile;
import javax.swing.ImageIcon;
import model.Model_PlayerProfile;
import swing.ScrollBar;
import swing.WrapLayout;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Form_1 extends javax.swing.JPanel {

    /**
     * Creates new form Form_1
     */
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String name, weight, height;
    String position;
    String condWeight, condHeight;
    Team team = new Team();
    int playerId;
    
    public Form_1() {
        initComponents();
        init();
    }
    
    private void init() {
        panelProfile.setLayout(new WrapLayout(WrapLayout.CENTER));
        sp2.setVerticalScrollBar(new ScrollBar());
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        panelProfile.add(new PlayerProfile(new Model_PlayerProfile(new ImageIcon(getClass().getResource("/icon/player1.png")), "Venus", "60", "160", "Forward", "3000")));
        
        panelProfile.revalidate();
        panelProfile.repaint();
    }
    
    public void reset() {
        textName.setText("");
        textWeight.setText("");
        textHeight.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        sp2 = new javax.swing.JScrollPane();
        panelProfile = new swing.PanelBorder();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        condW = new javax.swing.JComboBox<>();
        condH = new javax.swing.JComboBox<>();
        pos = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        textWeight = new javax.swing.JTextField();
        textHeight = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        noPlayer = new javax.swing.JTextField();
        salary = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PreviewList = new javax.swing.JTextArea();
        btnAddTeam1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        ID = new javax.swing.JTextField();
        IDrem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,100));

        jLabel2.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BUILD Team");

        panelProfile.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelProfileLayout = new javax.swing.GroupLayout(panelProfile);
        panelProfile.setLayout(panelProfileLayout);
        panelProfileLayout.setHorizontalGroup(
            panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
        );
        panelProfileLayout.setVerticalGroup(
            panelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        sp2.setViewportView(panelProfile);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(sp2, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(sp2, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
        );

        add(jPanel1);
        jPanel1.setBounds(10, 10, 720, 620);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0,100));

        jLabel3.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Weight (kg)");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Height (cm)");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Position");

        textName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textName.setForeground(new java.awt.Color(0, 0, 0));
        textName.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        textName.setBorder(null);
        textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNameActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 153, 0));
        btnSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        condW.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        condW.setForeground(new java.awt.Color(0, 0, 0));
        condW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", ">=", "<=" }));
        condW.setBorder(null);
        condW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                condWActionPerformed(evt);
            }
        });

        condH.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        condH.setForeground(new java.awt.Color(0, 0, 0));
        condH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", ">=", "<=" }));
        condH.setBorder(null);
        condH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                condHActionPerformed(evt);
            }
        });

        pos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        pos.setForeground(new java.awt.Color(0, 0, 0));
        pos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "F", "G", "C" }));
        pos.setBorder(null);
        pos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 153, 0));
        btnReset.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        textWeight.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textWeight.setForeground(new java.awt.Color(0, 0, 0));
        textWeight.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textWeight.setBorder(null);
        textWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textWeightActionPerformed(evt);
            }
        });

        textHeight.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textHeight.setForeground(new java.awt.Color(0, 0, 0));
        textHeight.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textHeight.setBorder(null);
        textHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHeightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(51, 51, 51)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(condW, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(condH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(68, 68, 68))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(condW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(condH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnReset))
                .addGap(101, 101, 101))
        );

        add(jPanel2);
        jPanel2.setBounds(750, 10, 230, 190);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0,100));

        jLabel7.setFont(new java.awt.Font("Castellar", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Add player");

        remove.setBackground(new java.awt.Color(255, 153, 0));
        remove.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        noPlayer.setEditable(false);
        noPlayer.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        noPlayer.setForeground(new java.awt.Color(0, 0, 0));
        noPlayer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        noPlayer.setText("0");
        noPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noPlayerActionPerformed(evt);
            }
        });

        salary.setEditable(false);
        salary.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        salary.setForeground(new java.awt.Color(0, 0, 0));
        salary.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salary.setText("0");
        salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total Salary");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total Player");

        PreviewList.setColumns(20);
        PreviewList.setRows(5);
        jScrollPane1.setViewportView(PreviewList);

        btnAddTeam1.setBackground(new java.awt.Color(255, 153, 0));
        btnAddTeam1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAddTeam1.setForeground(new java.awt.Color(255, 255, 255));
        btnAddTeam1.setText("Add Team");
        btnAddTeam1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTeam1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Castellar", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("View Team");

        btnAdd.setBackground(new java.awt.Color(255, 153, 0));
        btnAdd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        ID.setText("Player ID");
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        IDrem.setText("Player ID");
        IDrem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDremActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(noPlayer)
                            .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(IDrem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddTeam1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addGap(36, 36, 36))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(noPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remove)
                    .addComponent(IDrem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(btnAddTeam1)
                .addContainerGap())
        );

        add(jPanel3);
        jPanel3.setBounds(750, 210, 230, 410);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/court.jpg"))); // NOI18N
        add(jLabel10);
        jLabel10.setBounds(0, 0, 990, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameActionPerformed
        String name = textName.getText();
    }//GEN-LAST:event_textNameActionPerformed

    private void condHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_condHActionPerformed
        condHeight = (String) condH.getSelectedItem();
    }//GEN-LAST:event_condHActionPerformed

    private void posActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posActionPerformed
        
    }//GEN-LAST:event_posActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        int id = Integer.parseInt(textName.getText());
        condWeight = (String) condW.getSelectedItem();
        condHeight = (String) condH.getSelectedItem();
        height = textHeight.getText();
        weight = textWeight.getText();
        position = (String) pos.getSelectedItem();
        StringBuilder a = new StringBuilder();
        a.append("Height,");
        a.append(condHeight + ",");
        a.append(height);
        a.append(",");
        a.append("Weight,");
        a.append(condWeight + ",");
        a.append(weight);
        a.append(",Position,=,");
        a.append(position);
        String attribute = a.toString();
        
        dynamicTest test = new dynamicTest(attribute);
        

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void textWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textWeightActionPerformed
        
    }//GEN-LAST:event_textWeightActionPerformed

    private void textHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHeightActionPerformed
       
    }//GEN-LAST:event_textHeightActionPerformed
    int row;
    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        int row=Integer.parseInt(IDrem.getText());
        team.formTeam(2, row);
        PreviewList.setText(team.toString());
        salary.setText(Integer.toString(team.getSalary()));
        noPlayer.setText(Integer.toString(team.getSize()));

    }//GEN-LAST:event_removeActionPerformed

    private void salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryActionPerformed
        //salary.setText(Integer.toString(team.getSalary()));
        
    }//GEN-LAST:event_salaryActionPerformed

    private void condWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_condWActionPerformed
        
    }//GEN-LAST:event_condWActionPerformed

    private void noPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noPlayerActionPerformed
        //salary.setText(Integer.toString(team.getSize()));
        
    }//GEN-LAST:event_noPlayerActionPerformed

    private void btnAddTeam1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTeam1ActionPerformed
        if (team.isValidTeam()) {
            //save to database
            String message = "You successfully build the team";
            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAddTeam1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        playerId=Integer.parseInt(ID.getText());
        System.out.println(playerId);
        team.formTeam(1,playerId);
        team.toString();
        PreviewList.setText(team.toString());
        salary.setText(Integer.toString(team.getSalary()));
        noPlayer.setText(Integer.toString(team.getSize()));
    }//GEN-LAST:event_btnAddActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        
        
    }//GEN-LAST:event_IDActionPerformed

    private void IDremActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDremActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDremActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField IDrem;
    private javax.swing.JTextArea PreviewList;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddTeam1;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> condH;
    private javax.swing.JComboBox<String> condW;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField noPlayer;
    private swing.PanelBorder panelProfile;
    private javax.swing.JComboBox<String> pos;
    private javax.swing.JButton remove;
    private javax.swing.JTextField salary;
    private javax.swing.JScrollPane sp2;
    private javax.swing.JTextField textHeight;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textWeight;
    // End of variables declaration//GEN-END:variables
}
