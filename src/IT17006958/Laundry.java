/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT17006958;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sharaf
 */
public class Laundry extends javax.swing.JFrame {

     
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement pst = null;
    private ResultSet resultset = null;
    private final String url = "jdbc:mysql://localhost:3306/hotelsystem";
    private final String user = "root";
    private final String password = "";
    private final String driver = "com.mysql.jdbc.Driver";
   
   
    /**
     * Creates new form Laundry
     */
    public Laundry() {
        initComponents();
        
        setExtendedState(Main.MAXIMIZED_BOTH);  
        tableLoad();
    
        Calendar c= datebox.getMonthView().getCalendar();
        c.setTime(new Date());
        datebox.getMonthView().setLowerBound(c.getTime());
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
            String sql = "SELECT id,date,item,noOfItems,Ltype FROM Laundry";
                    
                  
            pst = connection.prepareStatement(sql);
            resultset = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(resultset));
           
             int i=0;
            
            while(resultset.next())
            {
                String contents[][] = null;
                contents[i][0]=String.valueOf(resultset.getInt("id"));
                contents[i][1]=String.valueOf(resultset.getString("item"));
                contents[i][2]=String.valueOf(resultset.getDate("Date"));
                contents[i][3]=resultset.getString("noOfItems");
                //contents[i][3]=String.valueOf(resultset.getDate("Date"));
                //contents[i][4]=String.valueOf(resultset.getTime("Lvtime"));
                contents[i][4]=resultset.getString("Ltype");
            //    contents[i][5]= resultset.getString("roomNo");
               
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

        jPanel2 = new javax.swing.JPanel();
        qtybox = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        button1 = new java.awt.Button();
        jLabel5 = new javax.swing.JLabel();
        ltypebox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        datebox = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        itembox = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(50, 50, 86));

        qtybox.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        qtybox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyboxActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Laundry");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Item name:");

        jButton1.setBackground(new java.awt.Color(100, 255, 218));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jButton1.setText("INSERT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Laundry Type:");

        ltypebox.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        ltypebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select Type---", "IRONING", "DRY CLEANING", "WASHING AND IRONING" }));
        ltypebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ltypeboxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date:");

        datebox.setBackground(new java.awt.Color(255, 255, 255));
        datebox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        datebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateboxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity:");

        itembox.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        itembox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select Item---", "DENIM", "SUIT", "SHIRTS", "JACKETS", "SKIRTS", "FROCKS", "OTHERS" }));
        itembox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemboxActionPerformed(evt);
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "date", "item", "noOfitems", "Ltype"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(190, 190, 190)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datebox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(qtybox, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(itembox, 0, 196, Short.MAX_VALUE)))
                                .addGap(120, 120, 120)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ltypebox, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jButton1)))
                .addContainerGap(479, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel20)))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(datebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(itembox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(qtybox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2)))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ltypebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(89, 89, 89)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(244, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void qtyboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

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

        String item = String.valueOf(itembox.getSelectedItem());
        String Ltype = String.valueOf(ltypebox.getSelectedItem());
        int noOfItems = Integer.valueOf(qtybox.getText());
        Date date = datebox.getDate();
   
        String q = "INSERT INTO laundry(date,item,noOfItems,Ltype) VALUES('"+item+"','"+Ltype+"','"+noOfItems+"','"+date+"')";
        
        
        Date d =  datebox.getDate();
       // java.sql.Date date = new java.sql.Date(d.getTime());
        int rows = 0;
                   try {
               connection = DriverManager.getConnection(url,user,password);
               statement = connection.createStatement();
               pst = connection.prepareStatement(q);
               
                pst.setDate(1,(java.sql.Date)(Date)datebox.getDate());
                pst.setString(2, (String)itembox.getSelectedItem());
               pst.setInt(3,Integer.valueOf(qtybox.getText()));
               pst.setString(4, (String)ltypebox.getSelectedItem());
            
             
               pst.executeUpdate();
               JOptionPane.showMessageDialog(null,"inserted successfully");
 
               
             }
         
             catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
             }
         
            //tableLoad();]
            qtybox.setText("");
            itembox.setSelectedItem(null);
            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

        Main h2 = new Main();
        h2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button1ActionPerformed

    private void ltypeboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ltypeboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ltypeboxActionPerformed

    private void dateboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateboxActionPerformed

        /*
            String url = "jdbc:mysql://localhost:3306/hotelsystem";
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
      
        
        Date d =  datebox.getDate();
        java.sql.Date date = new java.sql.Date(d.getTime());
        int rows = 0;
        try
           {
            connection = DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();



            String q ="SELECT date FROMlau ";
            resultset = statement.executeQuery(q);
            while(resultset.next())
            {
                rows=resultset.getInt("shift");
            }
        }
        catch (Exception e) 
            {
            e.printStackTrace();
            }
        
        /*
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String []
            {
                "ID", "Guest Name", "Amount Due", "Room Type", "Start Date", "End Date"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });

        ID.setText("");
        Date d =  datebox.getDate();
        java.sql.Date date = new java.sql.Date(d.getTime());

        int rows = 0;
        try
        {
            String sql ="SELECT COUNT(number) FROM room";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next())
            {
                rows=resultSet.getInt("COUNT(number)");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        String contents[][] = new String[rows][6];

        try{

            String sql ="SELECT bookings.id,guest.name,bookings.amount,bookings.type,bookings.startDate,bookings.endDate "
            + "FROM bookings,guest "
            + "WHERE bookings.guestID=guest.ID "
            + "AND '"+date+"' BETWEEN startDate AND endDate";
            resultSet = statement.executeQuery(sql);
            int i=0;
            while(resultSet.next())
            {
                contents[i][0]=String.valueOf(resultSet.getInt("id"));
                contents[i][1]=resultSet.getString("name");
                contents[i][2]=String.valueOf(resultSet.getDouble("amount"));
                contents[i][3]=resultSet.getString("type");
                contents[i][4]=resultSet.getString("startDate");
                contents[i][5]=resultSet.getString("endDate");
                i = i + 1;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            contents,
            new String [] {
                "ID", "Guest Name", "Amount Due", "Room Type", "Start Date", "End Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
*/
    }//GEN-LAST:event_dateboxActionPerformed

    private void itemboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemboxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

       // rnbox.setSelectedItem(null);
     //   wtbox1.setSelectedItem(null);
        // wtbox2.setSelectedItem(null);
        // ltbox1.setSelectedItem(null);
        // ltbox2.setSelectedItem(null);
        // datepick.setDate(null);
        //sidbox.setText("");
       // namebox.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Laundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laundry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laundry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private org.jdesktop.swingx.JXDatePicker datebox;
    private javax.swing.JComboBox<String> itembox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> ltypebox;
    private javax.swing.JTextField qtybox;
    // End of variables declaration//GEN-END:variables
}
