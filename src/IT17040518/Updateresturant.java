/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT17040518;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Harish
 */
public class Updateresturant extends javax.swing.JFrame {

      Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null; 
        
    /**
     * Creates new form Updateresturant
     */
    public Updateresturant() {
        initComponents();
        
    }
    
    public void tableload()
    {
        //meals table
        String url = "jdbc:mysql://localhost:3306/hotelsystem";
        String user = "root";
        String password = "";
        String contents[][]=new String[10][2];

        String driver = "com.mysql.jdbc.Driver";
        try
        {
            
            Class.forName(driver);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            connection = DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();

            int i = 0;
        String sql = "SELECT mtype,foodName FROM meals";
       pst = connection.prepareStatement(sql);
      
      rs = resultSet = statement.executeQuery(sql);
            while(resultSet.next())
            {

              contents[i][0]=resultSet.getString("mtype");
              contents[i][1]=resultSet.getString("foodName");

            }
            MealTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e) {
            
        }
        tableload();
        
    //---------------------------------------------------------------------------------------------
    
   //drinks table
 
        try
        {
            connection = DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();

            int i = 0;
        String sql = "SELECT Dtype,dName FROM drinks";
       pst = connection.prepareStatement(sql);
      
       resultSet = statement.executeQuery(sql);
            while(resultSet.next())
            {

              contents[i][0]=resultSet.getString("Dtype");
              contents[i][1]=resultSet.getString("dName");

            }
            DrinksTable.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e) {
            
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
        MTypeText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DNText = new javax.swing.JTextField();
        UpdateMBtn = new javax.swing.JButton();
        DeleteMBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        FNText = new javax.swing.JTextField();
        DTypeText = new javax.swing.JTextField();
        UpdateDBtn = new javax.swing.JButton();
        DeleteDBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DrinksTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        MealTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        AddMBtn = new javax.swing.JButton();
        AddDBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(50, 50, 86));

        MTypeText.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        MTypeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MTypeTextActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Meal Type");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Food Name");

        DNText.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        UpdateMBtn.setBackground(new java.awt.Color(100, 255, 218));
        UpdateMBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        UpdateMBtn.setText("Update Meal");
        UpdateMBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateMBtnActionPerformed(evt);
            }
        });

        DeleteMBtn.setBackground(new java.awt.Color(100, 255, 218));
        DeleteMBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        DeleteMBtn.setText("Delete Meal");
        DeleteMBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Drink Type");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Drink Name");

        FNText.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        DTypeText.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        DTypeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DTypeTextActionPerformed(evt);
            }
        });

        UpdateDBtn.setBackground(new java.awt.Color(100, 255, 218));
        UpdateDBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        UpdateDBtn.setText("Update Drinks");
        UpdateDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateDBtnActionPerformed(evt);
            }
        });

        DeleteDBtn.setBackground(new java.awt.Color(100, 255, 218));
        DeleteDBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        DeleteDBtn.setText("Delete Drinks");
        DeleteDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteDBtnActionPerformed(evt);
            }
        });

        DrinksTable.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        DrinksTable.setForeground(new java.awt.Color(50, 50, 86));
        DrinksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Drink Type", "Drink Name"
            }
        ));
        jScrollPane1.setViewportView(DrinksTable);

        MealTable.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        MealTable.setForeground(new java.awt.Color(50, 50, 86));
        MealTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Meal Type", "Food Name"
            }
        ));
        jScrollPane2.setViewportView(MealTable);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Update Meals");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Update Drinks");

        jLabel12.setBackground(new java.awt.Color(97, 212, 195));
        jLabel12.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("Menu Update");

        jButton1.setBackground(new java.awt.Color(100, 255, 218));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(100, 255, 218));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        AddMBtn.setBackground(new java.awt.Color(100, 255, 218));
        AddMBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        AddMBtn.setText("Add Meal");
        AddMBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMBtnActionPerformed(evt);
            }
        });

        AddDBtn.setBackground(new java.awt.Color(100, 255, 218));
        AddDBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        AddDBtn.setText("Add Drinks");
        AddDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(UpdateMBtn)
                                .addGap(27, 27, 27)
                                .addComponent(AddMBtn)
                                .addGap(35, 35, 35)
                                .addComponent(DeleteMBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(44, 44, 44)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(MTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FNText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(165, 165, 165)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(100, 100, 100)
                                    .addComponent(UpdateDBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                    .addComponent(AddDBtn)
                                    .addGap(18, 18, 18)
                                    .addComponent(DeleteDBtn))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jButton2)
                                    .addGap(36, 36, 36))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6)
                                    .addGap(166, 166, 166)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(31, 31, 31)
                                        .addComponent(DNText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(119, 119, 119))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(DTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(85, 85, 85))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(FNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UpdateMBtn)
                            .addComponent(DeleteMBtn)
                            .addComponent(AddMBtn)
                            .addComponent(UpdateDBtn)
                            .addComponent(AddDBtn)
                            .addComponent(DeleteDBtn))))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MTypeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MTypeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MTypeTextActionPerformed

    private void DeleteMBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteMBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteMBtnActionPerformed

    private void UpdateMBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateMBtnActionPerformed
    String url = "jdbc:mysql://localhost:3306/hotelsystem";
        String user = "root";
        String password = "";
        String contents[][]=new String[10][2];

        String driver = "com.mysql.jdbc.Driver";
        try
        {
            Class.forName(driver);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            connection = DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();

            int i = 0;
         int x = JOptionPane.showConfirmDialog(null,"Do you really want to update Meals");
        
        if(x==0)
        {
            
            String mtype = MTypeText.getText();
            String Fname = FNText.getText();
            
            String sql = "UPDATE meals SET mtype = '"+mtype+"','"+Fname+" ";
              pst = connection.prepareStatement(sql);
            pst.executeUpdate(sql);
        }
            
        }
         catch (Exception e)
        {
            e.printStackTrace();
          
        }
        //table is loading
      tableload();
   
       

        
    }//GEN-LAST:event_UpdateMBtnActionPerformed

    private void DTypeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DTypeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DTypeTextActionPerformed

    private void UpdateDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateDBtnActionPerformed
        
         String url = "jdbc:mysql://localhost:3306/hotelsystem";
        String user = "root";
        String password = "";
        String contents[][]=new String[10][2];

        String driver = "com.mysql.jdbc.Driver";
        try
        {
            Class.forName(driver);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            connection = DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();

            int i = 0;
         int x = JOptionPane.showConfirmDialog(null,"Do you really want to update Drinks");
        
        if(x==0)
        {
            
            String dtype = DTypeText.getText();
            String Dname = DNText.getText();
            
            String sql = "UPDATE drinks SET Dtype = '"+dtype+"',dname = '"+Dname+" WHERE =  ";
              pst = connection.prepareStatement(sql);
            pst.executeUpdate(sql);
        }
            
        }
         catch (Exception e)
        {
            e.printStackTrace();
          
        }
        //table is loading
      tableload();
        
        
    }//GEN-LAST:event_UpdateDBtnActionPerformed

    private void DeleteDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteDBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteDBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MTypeText.setText("");
        FNText.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      DTypeText.setText("");
      DNText.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void AddMBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMBtnActionPerformed
     
        String url = "jdbc:mysql://localhost:3306/hotelsystem";
        String user = "root";
        String password = "";
        String contents[][]=new String[10][2];

        String driver = "com.mysql.jdbc.Driver";
        try
        {
            Class.forName(driver);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            connection = DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();

            int i = 0;
        String mtype = MTypeText.getText();
        String FName = FNText.getText();
        
        String q = "INSERT INTO meals (mtype,foodName) values ('"+mtype+"','"+FName+"')";
        pst = connection.prepareStatement(q);
            pst.executeUpdate(q);
      
            JOptionPane.showMessageDialog(null, "Meal Added successfully");
            
        }
         catch (Exception e)
        {
            e.printStackTrace();
          
        }
        //table is loading
      tableload();
    }//GEN-LAST:event_AddMBtnActionPerformed

    private void AddDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDBtnActionPerformed
       String url = "jdbc:mysql://localhost:3306/hotelsystem";
        String user = "root";
        String password = "";
        String contents[][]=new String[10][2];

        String driver = "com.mysql.jdbc.Driver";
        try
        {
            Class.forName(driver);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            connection = DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();

            int i = 0;
        String dtype = DTypeText.getText();
        String dName = DNText.getText();
        
        String q = "INSERT INTO drinks (Dtype,dName) values ('"+dtype+"','"+dName+"')";
        pst = connection.prepareStatement(q);
            pst.executeUpdate(q);
      //table is loading
      tableload();
            JOptionPane.showMessageDialog(null, "drinks Added successfully");
            
        }
         catch (Exception e)
        {
            e.printStackTrace();
          
        }
    }//GEN-LAST:event_AddDBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Updateresturant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Updateresturant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Updateresturant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Updateresturant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Updateresturant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddDBtn;
    private javax.swing.JButton AddMBtn;
    private javax.swing.JTextField DNText;
    private javax.swing.JTextField DTypeText;
    private javax.swing.JButton DeleteDBtn;
    private javax.swing.JButton DeleteMBtn;
    private javax.swing.JTable DrinksTable;
    private javax.swing.JTextField FNText;
    private javax.swing.JTextField MTypeText;
    private javax.swing.JTable MealTable;
    private javax.swing.JButton UpdateDBtn;
    private javax.swing.JButton UpdateMBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
