/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT17006958;

import static IT17006958.Database.setData;
import java.awt.HeadlessException;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author USER
 */
public class Workshift extends javax.swing.JFrame {
    
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement pst = null;
    private ResultSet resultset = null;
    private final String url = "jdbc:mysql://localhost:3306/hotelsystem";
    private final String user = "root";
    private final String password = "";
    private final String driver = "com.mysql.jdbc.Driver";
   
   
    
    public Workshift() {
        initComponents();
        setExtendedState(Main.MAXIMIZED_BOTH);        

        tableLoad();
        tableLoad1();
    }
    
    
     public void tableLoad(){
       
        int rows = 0;
      //  String contents[][] =new String[0][5];
        
        try 
        {
        Class.forName(driver);
        }
        catch (ClassNotFoundException e) 
        {
        e.printStackTrace();
        }
       
         
           try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem","root","");
            String sql = "SELECT attendance.StaffID,attendance.Name,attendance.AttnType,staff.department"
                    + "FROM attendance,staff "
                    + "WHERE attendance.StaffID = staff.id"
                    + "AND staff.department='HouseKeeping'";
                    
                  
            pst = connection.prepareStatement(sql);
            resultset = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(resultset));
           
             int i=0;
            
            while(resultset.next())
            {
                String contents[][] = null;
                contents[i][0]=String.valueOf(resultset.getInt("StaffID"));
                //contents[i][1]=String.valueOf(resultset.getTime("ArrTime"));
                contents[i][1]=resultset.getString("Name");
               // contents[i][3]=String.valueOf(resultset.getDate("Date"));
                //contents[i][4]=String.valueOf(resultset.getTime("Lvtime"));
                contents[i][2]=resultset.getString("AttnType");
                contents[i][3]= resultset.getString("department");
               
                i = i + 1;
            }
        }
          catch (Exception e) {
      //  e.printStackTrace();
          }
     }
          

        
       public void tableLoad1(){
       
    //    int rows = 0;
      //  String contents[][] =new String[0][5];
        
        try 
        {
        Class.forName(driver);
        }
        catch (ClassNotFoundException e) 
        {
        e.printStackTrace();
        }
       
         
           try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem","root","");
            String sql = "SELECT shift.StaffID,shift.Name,shift.wTime,shift.roomNo "
                    + "FROM shift ";
                    
                  
            pst = connection.prepareStatement(sql);
            resultset = pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(resultset));
           
             int i=0;
            
            while(resultset.next())
            {
                String contents[][] = null;
                contents[i][0]=String.valueOf(resultset.getInt("StaffID"));
                //contents[i][1]=String.valueOf(resultset.getTime("ArrTime"));
                contents[i][1]=resultset.getString("Name");
               // contents[i][3]=String.valueOf(resultset.getDate("Date"));
                contents[i][2]=String.valueOf(resultset.getTime("wTime"));
               // contents[i][3]=resultset.getString("type");
                contents[i][3]= resultset.getString("roomNo");
               
                i = i + 1;
            }
        }
          catch (Exception e) {
      //  e.printStackTrace();
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
        jButton2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        sidbox = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        wtbox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        rnbox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        namebox = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        searchbox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(50, 50, 86));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Room Number:");

        jButton2.setBackground(new java.awt.Color(100, 255, 218));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jButton2.setText("RESET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("WORKSHIFT");

        button1.setBackground(new java.awt.Color(100, 255, 218));
        button1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        button1.setForeground(new java.awt.Color(50, 50, 86));
        button1.setLabel("Back");
        button1.setMinimumSize(new java.awt.Dimension(52, 55));
        button1.setName(""); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name:");

        sidbox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sidbox.setPreferredSize(new java.awt.Dimension(6, 37));
        sidbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidboxActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(100, 255, 218));
        jButton3.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(100, 255, 218));
        jButton4.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jButton4.setText("UPDATE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Work Time:");

        wtbox1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        wtbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0\t", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " ", " " }));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "StaffID", "Room number", "Name", "Work time"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        rnbox.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        rnbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--ROOMS--", "101", "102", "103", "104", "105", "201", "202", "203", "204", "205", "301", "302", "303", "304", "305", "401", "402", "403", "404", "405", "" }));
        rnbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rnboxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Staff ID:");

        namebox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        namebox.setPreferredSize(new java.awt.Dimension(6, 37));
        namebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameboxActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "StaffID", "Name", "AttnType", "Department"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CLEANERS ATTENDANCE TABLE");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("SHIFT TABLE");

        jButton5.setBackground(new java.awt.Color(100, 255, 218));
        jButton5.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jButton5.setText("SUBMIT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        searchbox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        searchbox.setPreferredSize(new java.awt.Dimension(6, 37));
        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SEARCH:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(189, 189, 189)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rnbox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namebox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(wtbox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(189, 189, 189)
                                .addComponent(sidbox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton5)
                                .addGap(30, 30, 30)
                                .addComponent(jButton3)
                                .addGap(30, 30, 30)
                                .addComponent(jButton4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(108, 108, 108))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1084, 1084, 1084)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(sidbox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(rnbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(namebox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wtbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel12)))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        rnbox.setSelectedItem(null);
        wtbox1.setSelectedItem(null);
       // wtbox2.setSelectedItem(null);
     // ltbox1.setSelectedItem(null);
     // ltbox2.setSelectedItem(null);
      // datepick.setDate(null);
        sidbox.setText("");
      namebox.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

        Main m1 = new Main();
        m1.setVisible(true);
     //   this.dispose();
    }//GEN-LAST:event_button1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        
        /*
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        try {

            int row = jTable2.getSelectedRow();
            if (row != -1) {
              // setData("insert into remove shift(StaffId,roomNo,Name,wTime,) values('Delete','" + jTable2.getValueAt(row, 0).toString() + "','" + "','null')");
                //BalloonTips.viewToolTip(jPanel3,"Deleted Row Affected");
               Database.setData("delete from shift where StaffID ='" + jTable2.getValueAt(row, 0).toString() + "' ");

                JOptionPane.showMessageDialog(null, "Deleted");
                dtm.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(null, "Please First Select Row From a Table");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
                                           
       */
        
     
        String q="DELETE FROM shift WHERE StaffID=?";
        try{
               int row = jTable2.getSelectedRow();
            pst=connection.prepareStatement(q);
            
            pst.setString(1,sidbox.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null,"Deleted Successfully");
            
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(null,e);
        }
        tableLoad1();
     
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void sidboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sidboxActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       /*
            try 
        {
        Class.forName(driver);
        }
        catch (ClassNotFoundException e) 
        {
             e.printStackTrace();
        }
     
        */
            try{
                
                String value1=sidbox.getText();
                String value2=(String) rnbox.getSelectedItem();
             //   Date value3=datepick.getDate();
                String value3=namebox.getText();
               String value4=(String) wtbox1.getSelectedItem();
             //   String value6=wstypebox.getText();
                
                String sql="UPDATE shift set StaffID='"+value1+"',roomNo='"+value2+"',Name='"+value3+"',wTime='"+value4+"' where StaffID='"+value1+"'";
                pst=connection.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Updated Successfully");
            }
            catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
            }
           tableLoad1();
    
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void nameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameboxActionPerformed

    private void rnboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rnboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rnboxActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        
        String url = "jdbc:mysql://localhost:3306/hotelsystem";
        String user = "root";
        String password = "";
        //   String contents[][]=new String[10][2];

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
        ResultSet resultset = null;
        PreparedStatement pst = null;

        int sid = Integer.valueOf(sidbox.getText());
        String roomNo = String.valueOf(rnbox.getSelectedItem());
        String name = namebox.getText();
        int wTime = Integer.valueOf(wtbox1.getSelectedItem().toString());
         
     //  if(wtbox2.getSelectedItem().toString().equalsIgnoreCase("pm")){
       //    wTime = wTime+ 12;
       // }
        String q = "INSERT INTO shift(StaffID,Name,wTime,roomNo) VALUES('"+sid+"','"+name+"','"+wTime+"','"+roomNo+"')";
        
            try {
               connection = DriverManager.getConnection(url,user,password);
               statement = connection.createStatement();
               pst = connection.prepareStatement(q);
               pst.executeUpdate();
               JOptionPane.showMessageDialog(null,"inserted successfully");
 
               
            } catch (SQLException ex) {
               
            }
        tableLoad1();
        
        
      
        
        
        
        /*
        try{

        }

        catch (Exception e)
        {
            e.printStackTrace();
        }java.sql.Date ss = new java.sql.Date(Date);
        

        
        try
        {
            connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();
            pst = connection.prepareStatement(q);
            pst.setInt(1,Integer.valueOf(rnbox.getText()));
            pst.setString(2,reqbox.getSelectedItem());
            pst.setString(3,qtybox.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"inserted successfully");

        }

        catch (SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,e);
        }

        */

    }//GEN-LAST:event_jButton5ActionPerformed
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int r= jTable1.getSelectedRow();
        String sid=jTable1.getValueAt(r, 0).toString();
        String name=jTable1.getValueAt(r, 1).toString();
        
        sidbox.setText(sid);
        namebox.setText(name);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        
        int r= jTable2.getSelectedRow();
        String sid=jTable2.getValueAt(r, 0).toString();
        String roomNo=jTable2.getValueAt(r, 3).toString();
        String name=jTable2.getValueAt(r, 1).toString();
        String wTime1=jTable2.getValueAt(r, 2).toString();
        
        sidbox.setText(sid);
        rnbox.setSelectedItem(roomNo);
        namebox.setText(name);
        wtbox1.setSelectedItem(wTime1);
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed

        DefaultTableModel table = (DefaultTableModel)jTable1.getModel();
        String Search = searchbox.getText();
        TableRowSorter<DefaultTableModel>tr = new TableRowSorter<DefaultTableModel>(table);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(Search));
        
    }//GEN-LAST:event_searchboxActionPerformed
        
        
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
            java.util.logging.Logger.getLogger(Workshift.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Workshift.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Workshift.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Workshift.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Workshift().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField namebox;
    private javax.swing.JComboBox<String> rnbox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTextField sidbox;
    private javax.swing.JComboBox<String> wtbox1;
    // End of variables declaration//GEN-END:variables

    private void jTable2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
