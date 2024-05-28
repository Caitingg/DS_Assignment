
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Model_Card;
import model.StatusType;
import swing.ScrollBar;
import java.sql.*;
import Team.Team;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Form_Home extends javax.swing.JPanel {

    /**
     * Creates new form Form_Home
     */
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst =null;
    
    
        String DB_URL = "jdbc:mysql://127.0.0.1:3306/nba";
        String DB_USER = "root";
        String DB_PASSWORD = "";
        
        public String find(String status) {
        int count = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT COUNT(*) AS count FROM agentmarket WHERE Status = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, status);
            rs = pst.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return Integer.toString(count);
    }
    
    public  void generate(){
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/available.png")), "Available", find("available") ));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/bond.png")), "Bond",  find("Bond")));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/icon/expired.png")), "Expired", find("Expired")));
        
      
        spTable.setVerticalScrollBar(new ScrollBar());
        sp1.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nba","root","");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * from agentmarket")) {

            while (resultSet.next()) {
                int playerId = resultSet.getInt("PLayer_ID");
                String playerName = resultSet.getString("Player_Name");
                double playerWeight = resultSet.getDouble("Weight");
                double playerHeight = resultSet.getDouble("Height");
                String playerPosition = resultSet.getString("Position");
                int playerPoints = resultSet.getInt("Points");
                int playerSalary = resultSet.getInt("Salary");
                int playerRebounds = resultSet.getInt("TotalRebounts");
                int playerAssists = resultSet.getInt("Assists");
                int playerSteals = resultSet.getInt("Steals");
                int playerBlocks = resultSet.getInt("Blocks");
                String playerStatus = resultSet.getString("status");
                if(playerStatus.equalsIgnoreCase("bond")){
                    table.addRow(new Object[]{Integer.toString(playerId),playerName,Double.toString(playerWeight),Double.toString(playerHeight),playerPosition,Integer.toString(playerSalary),Integer.toString(playerPoints),Integer.toString(playerRebounds),Integer.toString(playerAssists),Integer.toString(playerSteals),Integer.toString(playerBlocks),StatusType.BOND});
                } else if(playerStatus.equalsIgnoreCase("available")){
                    table.addRow(new Object[]{Integer.toString(playerId),playerName,Double.toString(playerWeight),Double.toString(playerHeight),playerPosition,Integer.toString(playerSalary),Integer.toString(playerPoints),Integer.toString(playerRebounds),Integer.toString(playerAssists),Integer.toString(playerSteals),Integer.toString(playerBlocks),StatusType.AVAILABLE});
                } else if(playerStatus.equalsIgnoreCase("expired")){
                    table.addRow(new Object[]{Integer.toString(playerId),playerName,Double.toString(playerWeight),Double.toString(playerHeight),playerPosition,Integer.toString(playerSalary),Integer.toString(playerPoints),Integer.toString(playerRebounds),Integer.toString(playerAssists),Integer.toString(playerSteals),Integer.toString(playerBlocks),StatusType.EXPIRED});
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        
     
    }
    public Form_Home() {
        initComponents();
        generate();
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header2 = new component.Header();
        panel = new javax.swing.JPanel();
        card1 = new component.Card();
        card2 = new component.Card();
        card3 = new component.Card();
        jPanel1 = new javax.swing.JPanel();
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new swing.Table();
        sp1 = new javax.swing.JScrollPane();
        panelBorder3 = new swing.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        playerID = new javax.swing.JTextField();
        weightT = new javax.swing.JTextField();
        heightT = new javax.swing.JTextField();
        positionT = new javax.swing.JComboBox<>();
        salaryT = new javax.swing.JSpinner();
        pointsT = new javax.swing.JSpinner();
        reboundsT = new javax.swing.JSpinner();
        assistsT = new javax.swing.JSpinner();
        stealsT = new javax.swing.JSpinner();
        blocksT = new javax.swing.JSpinner();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        scrollBar1 = new swing.ScrollBar();
        scrollBar2 = new swing.ScrollBar();
        playerName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        panel.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        card1.setColor1(new java.awt.Color(186, 73, 0));
        card1.setColor2(new java.awt.Color(255, 143, 68));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(78, 47, 17));
        card2.setColor2(new java.awt.Color(156, 85, 50));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(0, 0, 79));
        card3.setColor2(new java.awt.Color(33, 33, 165));
        panel.add(card3);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Player Info");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Weight (kg)", "Height (cm)", "Position", "Salary", "Points", "Total Rebounds", "Assists", "Steals", "Blocks", "Status"
            }
        ));
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sp1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Add Player");

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Player ID");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Weight (kg)");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Height (cm)");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Position");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Salary");

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Points");

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Total Rebounds");

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Assists");

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Steals");

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Blocks");

        playerID.setBackground(new java.awt.Color(255, 255, 255));
        playerID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        playerID.setForeground(new java.awt.Color(0, 0, 0));
        playerID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        playerID.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        playerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerIDActionPerformed(evt);
            }
        });

        weightT.setBackground(new java.awt.Color(255, 255, 255));
        weightT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        weightT.setForeground(new java.awt.Color(0, 0, 0));
        weightT.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        weightT.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        weightT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightTActionPerformed(evt);
            }
        });

        heightT.setBackground(new java.awt.Color(255, 255, 255));
        heightT.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        heightT.setForeground(new java.awt.Color(0, 0, 0));
        heightT.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        heightT.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        heightT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heightTActionPerformed(evt);
            }
        });

        positionT.setBackground(new java.awt.Color(255, 255, 255));
        positionT.setForeground(new java.awt.Color(0, 0, 0));
        positionT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "F", "C", "G", "F-G", "F-C", "G-F", "C-F" }));
        positionT.setBorder(null);
        positionT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionTActionPerformed(evt);
            }
        });

        salaryT.setBorder(null);

        pointsT.setBorder(null);

        reboundsT.setBorder(null);

        assistsT.setBorder(null);

        stealsT.setBorder(null);

        blocksT.setBorder(null);

        add.setBackground(new java.awt.Color(255, 153, 51));
        add.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        add.setForeground(new java.awt.Color(0, 0, 0));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 153, 51));
        delete.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(0, 0, 0));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(255, 153, 51));
        update.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        update.setForeground(new java.awt.Color(0, 0, 0));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(255, 153, 51));
        clear.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        clear.setForeground(new java.awt.Color(0, 0, 0));
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        playerName.setBackground(new java.awt.Color(255, 255, 255));
        playerName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        playerName.setForeground(new java.awt.Color(0, 0, 0));
        playerName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        playerName.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        playerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerNameActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Full name");

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder3Layout.createSequentialGroup()
                                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weightT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(salaryT, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pointsT)
                            .addComponent(positionT, javax.swing.GroupLayout.Alignment.TRAILING, 0, 100, Short.MAX_VALUE)))
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stealsT)
                            .addComponent(assistsT)
                            .addComponent(reboundsT)
                            .addComponent(blocksT)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(heightT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder3Layout.createSequentialGroup()
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(13, 13, 13)
                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelBorder3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {heightT, weightT});

        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addComponent(scrollBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(panelBorder3Layout.createSequentialGroup()
                        .addComponent(playerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weightT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(heightT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(positionT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(salaryT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pointsT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(reboundsT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(assistsT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(stealsT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(blocksT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(delete))
                .addGap(18, 18, 18)
                .addGroup(panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update)
                    .addComponent(clear))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        sp1.setViewportView(panelBorder3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sp1)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        reset();
    }//GEN-LAST:event_clearActionPerformed

    
    public void reset(){
        playerID.setText("");
        playerName.setText("");
        weightT.setText("");
        heightT.setText("");
        positionT.setSelectedIndex(0);
        salaryT.setValue(0);
        pointsT.setValue(0);
        reboundsT.setValue(0);
        assistsT.setValue(0);
        stealsT.setValue(0);
        blocksT.setValue(0);
        
        
    }
    
   public void delete(String cond, String val) {
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "DELETE FROM agentmarket WHERE " + cond + " = ? AND Status = 'available'";
            pst = con.prepareStatement(sql);
            pst.setString(1, val);
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted == 0) {
                String message = "Please enter correct player id and only available players can be deleted";
            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
            
            } else{
                 String message = "Player Successfully deleleted";
            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException e) {
            System.err.println("Error deleting player(s): " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
   
   
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
         int player_id = Integer.parseInt(playerID.getText());
        String name = playerName.getText();
        double weight = Double.parseDouble(weightT.getText());
        double height = Double.parseDouble(heightT.getText());
        String position = (String)positionT.getSelectedItem();
        int salary = (Integer)salaryT.getValue();
        int points = (Integer)pointsT.getValue();
        int rebounds = (Integer)reboundsT.getValue();
        int blocks = (Integer)blocksT.getValue();
        int assists = (Integer)assistsT.getValue();
        int steals = (Integer)stealsT.getValue();
        
         try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
        String sql = "UPDATE agentmarket SET Weight=?, Height=?, Position=?, Salary=?, Points=?, TotalRebounts=?, Assists=?, Steals=?, Blocks=?, game=game+1 WHERE Player_ID=? AND Player_Name=?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setDouble(1, weight);
            st.setDouble(2, height);
            st.setString(3, position);
            st.setInt(4, salary);
            st.setInt(5, points);
            st.setInt(6, rebounds);
            st.setInt(7, assists);
            st.setInt(8, steals);
            st.setInt(9, blocks);
            st.setInt(10, player_id);
            st.setString(11, name);
            
            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                String message = "Player information updated successfully.";
                JOptionPane.showMessageDialog(null, message);
            } else {
                String message = "No player found with ID: " + player_id + " and Name: " + name;
                JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        generate();
        
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String name=playerName.getText();
        String id=playerID.getText();
        if(name.equals("")&&id.equals("")){
            
        String message = "Please enter player name or id to delete player";
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
        }else if(id.equals("")){
            delete("Player_Name",name);
        }else{
            delete("Player_ID",id);
        }
        
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        generate();
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
        int player_id = Integer.parseInt(playerID.getText());
        String name = playerName.getText();
        double weight = Double.parseDouble(weightT.getText());
        double height = Double.parseDouble(heightT.getText());
        String position = (String)positionT.getSelectedItem();
        int salary = (Integer)salaryT.getValue();
        int points = (Integer)pointsT.getValue();
        int rebounds = (Integer)reboundsT.getValue();
        int blocks = (Integer)blocksT.getValue();
        int assists = (Integer)assistsT.getValue();
        int steals = (Integer)stealsT.getValue();
        String status="Available";
        
        Team team=new Team();
        team.savePlayerToInfo(player_id, name, height, weight, position, salary, points, rebounds, assists, steals, blocks,status);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        generate();
        
    }//GEN-LAST:event_addActionPerformed

    private void positionTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionTActionPerformed

    private void heightTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heightTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_heightTActionPerformed

    private void weightTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_weightTActionPerformed

    private void playerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerIDActionPerformed

    private void playerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JSpinner assistsT;
    private javax.swing.JSpinner blocksT;
    private component.Card card1;
    private component.Card card2;
    private component.Card card3;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private component.Header header2;
    private javax.swing.JTextField heightT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel;
    private swing.PanelBorder panelBorder1;
    private swing.PanelBorder panelBorder3;
    private javax.swing.JTextField playerID;
    private javax.swing.JTextField playerName;
    private javax.swing.JSpinner pointsT;
    private javax.swing.JComboBox<String> positionT;
    private javax.swing.JSpinner reboundsT;
    private javax.swing.JSpinner salaryT;
    private swing.ScrollBar scrollBar1;
    private swing.ScrollBar scrollBar2;
    private javax.swing.JScrollPane sp1;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JSpinner stealsT;
    private swing.Table table;
    private javax.swing.JButton update;
    private javax.swing.JTextField weightT;
    // End of variables declaration//GEN-END:variables
}
