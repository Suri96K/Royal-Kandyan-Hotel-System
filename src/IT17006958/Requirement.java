/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT17006958;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class Requirement extends javax.swing.JFrame {
        
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement pst = null;
    private ResultSet resultset = null;
    private final String url = "jdbc:mysql://localhost:3306/hotelsystem";
    private final String user = "root";
    private final String password = "";
    private final String driver = "com.mysql.jdbc.Driver";
   
    
    
    /**
     * Creates new form Requirements
     */
    public Requirement() {
        initComponents();
        setExtendedState(Main.MAXIMIZED_BOTH);        

        
    }
    
    /*
        public void table(){
        
        String url = "jdbc:mysql://localhost:3306/hotelmanagementsystem";
        String user = "root";
        String password = "";
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
        
        int rows = 0;
        String contents[][] = new String[6][5];
        
        try{
            connection = DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();
            String sql ="SELECT * FROM requested ";
            resultSet = statement.executeQuery(sql);
            int i=0;
            while(resultSet.next())
            {
                contents[i][0]=resultSet.getString("room number");
                contents[i][1]=String.valueOf(resultSet.getInt(""));
                contents[i][2]=resultSet.getString("");
                contents[i][3]=resultSet.getString("");
                contents[i][4]=String.valueOf(resultSet.getDouble(""));
                i = i + 1;
            }
        }
        catch (Exception e) {
        e.printStackTrace();
        }
        table.setModel(new javax.swing.table.DefaultTableModel(contents, new String [] {"", "", "", "","" }) 
        { 
           
        boolean[] canEdit = new boolean [] {false, false, false, false, false,true};

        public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }
    });
    
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        reqbox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        RoomType = new javax.swing.JTextField();
        qtybox = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        roomNum = new javax.swing.JComboBox<>();
        stockbox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(50, 50, 83));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Room Type:");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Requirement");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quantity:");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        reqbox.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        reqbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select Item---", "Pillows", "Bed sheet", "Towels", "Water Bottles", "Bath Mat", "Vase", "Air Freshner", "Broom", " " }));
        reqbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqboxActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("REQUIRMENT");

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

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Room number:");

        RoomType.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        RoomType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomTypeActionPerformed(evt);
            }
        });

        qtybox.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        qtybox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyboxActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(100, 255, 218));
        jButton5.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jButton5.setText("SUBMIT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(100, 255, 218));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jButton2.setText("RESET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        roomNum.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        roomNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Rooms---", "101", "102", "103", "104", "105", "201", "202", "203", "204", "205", "301", "302", "303", "304", "305", "401", "402", "403", "404", "405", " " }));
        roomNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumActionPerformed(evt);
            }
        });

        stockbox.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        stockbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockboxActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Stock Quantity:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(219, 219, 219)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(reqbox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(stockbox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(roomNum, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtybox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(jButton5)))
                .addGap(0, 889, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(968, 968, 968)
                                .addComponent(jLabel20)))))
                .addContainerGap(540, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(221, 464, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel11)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel12)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel14)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel15)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(roomNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(RoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reqbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(stockbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(qtybox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1860, 950));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

        Main h2 = new Main();
        h2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button1ActionPerformed

    private void RoomTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomTypeActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_RoomTypeActionPerformed

    private void reqboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqboxActionPerformed
  
        String name=String.valueOf(reqbox.getSelectedItem());
        String sql = "SELECT qty FROM items WHERE name='"+name+"'";

        try
        {
            Class.forName(driver);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        try
        {
            connection = DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();
            resultset = statement.executeQuery(sql);

            stockbox.setText("");
            while(resultset.next())
            {
                stockbox.setText(resultset.getString("qty"));

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
      
    }//GEN-LAST:event_reqboxActionPerformed

    private void qtyboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyboxActionPerformed
        
        
    }//GEN-LAST:event_qtyboxActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        
        
          
        String IDPattern = "[A-Za-z-0-9]+";
        String NamePattern = "[A-Za-z ]+";
        
        if(!qtybox.getText().matches(IDPattern))
        {
            IT17006958.Alerts A =new IT17006958.Alerts("check Quantity ");
                        A.setVisible(true);
                        A.setDefaultCloseOperation(0);
                        A.setVisible(true);
                        A.setLocationRelativeTo(this);
                        
        
        }
        /*
        String Item = (String)reqbox.getSelectedItem();
        String Quan = qtybox.getText();
        

    Object[] row = { Item, Quan};

    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    model.addRow(row);
*/
       
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
        
        
     //   String roomNo = String.valueOf(roomNum.getSelectedItem());
        String requirements = String.valueOf(reqbox.getSelectedItem());
        int quantity = Integer.valueOf(qtybox.getText());
    //    String roomtype = String.valueOf(RoomType.getText());
        
         
        String q = "INSERT INTO requested(`itemName`,`qty`,`category`,UOM) VALUE(?,?,'HouseKeeping','others')";
             
                

        
            try
           {
               
             connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();
            pst = connection.prepareStatement(q);
       //     pst.setInt(1,Integer.valueOf(rnbox.getText()));
            pst.setString(1, (String)reqbox.getSelectedItem());
            pst.setString(2,qtybox.getText());
            
             
            int stockQuantity = Integer.valueOf(stockbox.getText());
             int qty = Integer.valueOf(qtybox.getText());

                if (stockQuantity < qty)
                {
                    
                    IT17006958.Alerts A =new IT17006958.Alerts("Quantity should be less than Stock Quantity ");
                        A.setVisible(true);
                        A.setDefaultCloseOperation(0);
                        A.setVisible(true);
                        A.setLocationRelativeTo(this);
                        qtybox.setText("");
                        return;

                }
                else{

                    
                }
                
              pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"inserted successfully");
            
           
            
                     
             String sql = "INSERT INTO requirementsreport(`itemName`,`qty`) VALUE(?,?)";
             
                
/*
        
            try
           {
               
             connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();
            */
            pst = connection.prepareStatement(sql);
       //     pst.setInt(1,Integer.valueOf(rnbox.getText()));
            pst.setString(1, (String)reqbox.getSelectedItem());
            pst.setString(2,qtybox.getText());
            
                         
              pst.executeUpdate();
             JOptionPane.showMessageDialog(null,"inserted successfully");
            
           
        
          }
         
             catch (SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,e);
             }
            
             
     
        
        
        
        
     
            /*
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[](reqbox.getSelectedItem(),qtybox.getText()));
            */
       
          
       // roomNum.setSelectedItem(null);
        reqbox.setSelectedItem("---Select Item---");
        stockbox.setText("");
        qtybox.setText("");
      //  RoomType.setText("");
      
     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        
         roomNum.setSelectedItem(null);
        reqbox.setSelectedItem(null);
        qtybox.setText("");
        RoomType.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void roomNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumActionPerformed

        String number =String.valueOf(roomNum.getSelectedItem());
        String sql = "SELECT type FROM room WHERE number="+number;

        try
        {
            Class.forName(driver);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        try
        {
            connection = DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();
            resultset = statement.executeQuery(sql);

            RoomType.setText("");
            while(resultset.next())
            {
                RoomType.setText(resultset.getString("type"));

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
       
        
    }//GEN-LAST:event_roomNumActionPerformed

    private void stockboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockboxActionPerformed

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
            java.util.logging.Logger.getLogger(Requirement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Requirement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Requirement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Requirement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Requirement().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField RoomType;
    private java.awt.Button button1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField qtybox;
    private javax.swing.JComboBox<String> reqbox;
    private javax.swing.JComboBox<String> roomNum;
    private javax.swing.JTextField stockbox;
    // End of variables declaration//GEN-END:variables
}