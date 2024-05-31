package gui_ds;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;


public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        emailAddress = new javax.swing.JTextField();
        passWord = new javax.swing.JPasswordField();
        btnSignUp = new javax.swing.JButton();
        btnLoginPage = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(630, 370));

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0,80));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SIGN UP");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username: ");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email: ");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password: ");

        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });

        emailAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailAddressActionPerformed(evt);
            }
        });

        btnSignUp.setBackground(new java.awt.Color(0, 0, 0));
        btnSignUp.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(255, 255, 255));
        btnSignUp.setText("Sign Up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        btnLoginPage.setBackground(new java.awt.Color(0, 0, 0));
        btnLoginPage.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        btnLoginPage.setForeground(new java.awt.Color(255, 255, 255));
        btnLoginPage.setText("Login");
        btnLoginPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginPageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSignUp)
                                    .addComponent(passWord, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLoginPage))))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(passWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSignUp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoginPage)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(330, 40, 240, 280);

        jLabel6.setFont(new java.awt.Font("Forte", 0, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ShineBright");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 80, 250, 70);

        jLabel7.setFont(new java.awt.Font("Forte", 0, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Basketball Player ");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 120, 340, 70);

        jLabel8.setFont(new java.awt.Font("Forte", 0, 28)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Management System");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(50, 160, 260, 70);

        jLabel9.setFont(new java.awt.Font("Forte", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 255));
        jLabel9.setText("- Shine Bright Team -");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(50, 240, 190, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/basketball.jpg"))); // NOI18N
        //jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 630, 351);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void emailAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailAddressActionPerformed

    // private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
    //     //System.out.println("Sign up button clicked");
    //     String username, email, Password, query;
    //     String SUrl, SUser, SPass;
    //     SUrl = "jdbc:mysql://localhost:3306/nba?useSSL=false";
    //     SUser = "root";
    //     SPass = "";
    //     try{
    //         Class.forName("com.mysql.cj.jdbc.Driver");
    //         Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
    //         Statement st = con.createStatement();
    //         if("".equals(userName.getText())){
    //             JOptionPane.showMessageDialog(new JFrame(),"Username is required.","Error", JOptionPane.ERROR_MESSAGE);
    //         }else if("".equals(emailAddress.getText())){
    //             JOptionPane.showMessageDialog(new JFrame(),"Email is required.","Error", JOptionPane.ERROR_MESSAGE);
    //         }else if("".equals(passWord.getText())){
    //             JOptionPane.showMessageDialog(new JFrame(),"Password is required.","Error", JOptionPane.ERROR_MESSAGE);
    //         }else {
    //             username = userName.getText();
    //             email = emailAddress.getText();
    //             Password = passWord.getText();
    //             System.out.println(Password);
                
    //             query = "INSERT INTO user(user_name, email, password)" + "VALUES('"+username+"', '"+email+"', '"+Password+"')";
                
    //             st.execute(query);
    //             userName.setText("");
    //             emailAddress.setText("");
    //             passWord.setText("");
    //             showMessageDialog(null,"Account has been crested successfullty!");
    //         }
    //     }catch(Exception e){
    //         System.out.println("Error!" + e.getMessage());
    //     }
    //     // TODO add your handling code here:
    // }//GEN-LAST:event_btnSignUpActionPerformed

     // Register.java
    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {
        String username, email, password, hashedPassword, query;
        String SUrl = "jdbc:mysql://127.0.0.1:3306/nba";
        String SUser = "root";
        String SPass = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);

            if (userName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(new JFrame(), "Username is required.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (emailAddress.getText().isEmpty()) {
                JOptionPane.showMessageDialog(new JFrame(), "Email is required.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!isValidEmail(emailAddress.getText())) {
                JOptionPane.showMessageDialog(new JFrame(), "Invalid email format.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (new String(passWord.getPassword()).isEmpty()) {
                JOptionPane.showMessageDialog(new JFrame(), "Password is required.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!strongpassword(new String(passWord.getPassword()))) {
                JOptionPane.showMessageDialog(new JFrame(),
                        "Password weak!\n" +
                                "It must contain at least one lowercase English character.\n" +
                                "It must contain at least one uppercase English character.\n" +
                                "It must contain at least one special character.\n" +
                                "The special characters are: !@#$%^&*()-+\n" +
                                "Its length must be at least 8 characters.\n" +
                                "It must contain at least one digit.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

            } else {
                username = userName.getText();
                email = emailAddress.getText();
                password = new String(passWord.getPassword());

                hashedPassword = hashPassword(password);

                if (hashedPassword == null) {
                    throw new RuntimeException("Password hashing failed");
                }

                query = "INSERT INTO user(user_name, email, password) VALUES(?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, username);
                pstmt.setString(2, email);
                pstmt.setString(3, hashedPassword);

                pstmt.executeUpdate();
                userName.setText("");
                emailAddress.setText("");
                passWord.setText("");
                JOptionPane.showMessageDialog(null, "Account has been created successfully!");
            }
        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
        }
    }



    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] byteData = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : byteData) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();
    }

    public static boolean isValidEmail(String email) {
        // Regular expression for basic email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean strongpassword(String password) {
        int length = password.length();
        boolean lowercase = false;
        boolean uppercase = false;
        boolean specialCharacter = false;
        boolean digit = false;

        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lowercase = true;
            } else if (ch >= 'A' && ch <= 'Z') {
                uppercase = true;
            } else if (hasSpecialCharacter(ch)) {
                specialCharacter = true;
            } else if (ch >= '0' && ch <= '9') {
                digit = true;
            }
        }

        if (length >= 8 && lowercase && uppercase && specialCharacter && digit) {
            return true;
        } else if (length >= 6 && lowercase && uppercase && specialCharacter) {
            return true; // Moderate passwords are also accepted
        } else {
            return false;
        }
    }

    private static boolean hasSpecialCharacter(char ch) {
        switch (ch) {
            case '!':
            case '@':
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '(':
            case ')':
            case '-':
            case '+':
                return true;
            default:
                return false;
        }
    }


    private void btnLoginPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginPageActionPerformed
        // TODO add your handling code here:
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnLoginPageActionPerformed

    /**
     * @param args the command line arguments
     */
    // public static void main(String args[]) {
    //     /* Set the Nimbus look and feel */
    //     //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    //     /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
    //      * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
    //      */
    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the form */
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new Register().setVisible(true);
    //         }
    //     });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginPage;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JTextField emailAddress;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPasswordField passWord;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
