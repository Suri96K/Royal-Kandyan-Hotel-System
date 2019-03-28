/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT17026376;




import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ACHINTHA-PC
 */
public class Payment extends javax.swing.JInternalFrame {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private final String url = "jdbc:mysql://localhost:3306/hotelsystem";
    private final String user = "root";
    private final String password = "";
    private final String driver = "com.mysql.jdbc.Driver";
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private volatile double discount = 0;
    private int TableNumber;
    private double amount = 0;
    
    
    /**
     * Creates new form Calculation
     */
    public Payment() {
        initComponents();
        
        jLabel6.setVisible(false);
        jLabel8.setVisible(false);
        cashbox.setVisible(false);
        balancebox.setVisible(false);
        
        checkTable T = new checkTable();
        T.start();
        
    }
    
    class checkTable extends Thread
    {
        
        @Override
        public void run()
        { 
            try
            {
                Class.forName(driver);
                connection = DriverManager.getConnection(url,user,password);
                statement=connection.createStatement();

                    String sql ="SELECT Message FROM messages Where Message LIKE '%Table Number%'";
                    resultSet = statement.executeQuery(sql);
                    while(resultSet.next())
                    {
                        jLabel1.setText(jLabel1.getText()+"\n"+resultSet.getString("Message"));
                        TableNumber = Integer.parseInt(resultSet.getString("Message").replaceAll("\\D+",""));
                                
                    }
                    
                    String sql2 ="SELECT Message FROM messages Where Message LIKE '%Set Discount: Discount Rate%'";
                    resultSet = statement.executeQuery(sql2);
                    while(resultSet.next())
                    {
                        discount = Double.parseDouble(resultSet.getString("Message").replaceAll("\\D+",""));
                        discountBox.setText(discount+"%");
                    }

                    Thread.sleep(1000);     //1 second
                
            }
            catch (Exception e) {
            e.printStackTrace();
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Message = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        amountbox = new javax.swing.JTextField();
        discountBox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tablebox = new javax.swing.JTextField();
        Creditcheckbox = new javax.swing.JCheckBox();
        cashcheckbox = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cashbox = new javax.swing.JTextField();
        balancebox = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();

        Message.setBackground(new java.awt.Color(50, 50, 86));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Discount: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Amount: ");

        amountbox.setEditable(false);
        amountbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountboxActionPerformed(evt);
            }
        });

        discountBox.setEditable(false);

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Take Payment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Table Number: ");

        tablebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableboxActionPerformed(evt);
            }
        });

        Creditcheckbox.setBackground(new java.awt.Color(50, 50, 86));
        Creditcheckbox.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        Creditcheckbox.setForeground(new java.awt.Color(255, 255, 255));
        Creditcheckbox.setText("Credit Card");
        Creditcheckbox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Creditcheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreditcheckboxActionPerformed(evt);
            }
        });

        cashcheckbox.setBackground(new java.awt.Color(50, 50, 86));
        cashcheckbox.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        cashcheckbox.setForeground(new java.awt.Color(255, 255, 255));
        cashcheckbox.setText("Cash");
        cashcheckbox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cashcheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashcheckboxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cash: ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Balance: ");

        cashbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashboxActionPerformed(evt);
            }
        });

        balancebox.setEditable(false);
        balancebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceboxActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 153, 153));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton5.setText("Generate receipt");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Message box");

        area.setEditable(false);
        area.setColumns(20);
        area.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        area.setRows(5);
        jScrollPane2.setViewportView(area);

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jButton3.setText("Receipt Print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MessageLayout = new javax.swing.GroupLayout(Message);
        Message.setLayout(MessageLayout);
        MessageLayout.setHorizontalGroup(
            MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessageLayout.createSequentialGroup()
                .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MessageLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jButton1))
                    .addGroup(MessageLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(79, 79, 79)
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tablebox, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amountbox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(discountBox, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(MessageLayout.createSequentialGroup()
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MessageLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cashcheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MessageLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))))
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MessageLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(balancebox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(cashbox, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(MessageLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Creditcheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MessageLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(82, 82, 82)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(303, 303, 303))
            .addGroup(MessageLayout.createSequentialGroup()
                .addGap(557, 557, 557)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MessageLayout.setVerticalGroup(
            MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessageLayout.createSequentialGroup()
                .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MessageLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tablebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(discountBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(amountbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Creditcheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cashcheckbox))
                        .addGap(44, 44, 44)
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(cashbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(balancebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addComponent(jButton1))
                    .addGroup(MessageLayout.createSequentialGroup()
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MessageLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MessageLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(MessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton5)
                            .addComponent(jButton2))))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Message, javax.swing.GroupLayout.PREFERRED_SIZE, 1143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(729, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
     
        
    
    
    private void amountboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       
        try{
            String sql =  "INSERT INTO payment "
                    + "(amount, discount, type )"
                    +" values( ?, ?, 'Resturant')";
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem","root","");
            String user = "root";
            String password = "";
            String driver = "com.mysql.jdbc.Driver";
            pst = con.prepareStatement(sql);
            pst.setDouble(1,amount);
            pst.setDouble(2,discount);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserted successfullly");

        }     
               catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,e);
            
        }
        
         try{
            String sql =  "UPDATE tables SET price = 0 WHERE tid="+TableNumber ;
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem","root","");
            String user = "root";
            String password = "";
            String driver = "com.mysql.jdbc.Driver";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();

        }     
               catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,e);
            
        }
         
         jLabel1.setText(jLabel1.getText().replaceAll("Table Number: "+TableNumber,""));
         
         try{
            String sql =  "DELETE FROM messages WHERE Message LIKE '%"+TableNumber+"%'" ;
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/hotelsystem","root","");
            String user = "root";
            String password = "";
            String driver = "com.mysql.jdbc.Driver";
            pst = con.prepareStatement(sql);
            pst.executeUpdate();

        }     
               catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,e);
            
        }
         
   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CreditcheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreditcheckboxActionPerformed
        // TODO add your handling code here:
        cashcheckbox.setSelected(false);
        
        jLabel6.setVisible(false);
            jLabel8.setVisible(false);
            cashbox.setVisible(false);
            balancebox.setVisible(false);
    }//GEN-LAST:event_CreditcheckboxActionPerformed

    private void cashcheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashcheckboxActionPerformed
        // TODO add your handling code here:
        Creditcheckbox.setSelected(false);
        
        if(cashcheckbox.isSelected()==true)
        {
            jLabel6.setVisible(true);
            jLabel8.setVisible(true);
            cashbox.setVisible(true);
            balancebox.setVisible(true);
        }
        else
        {
            jLabel6.setVisible(false);
            jLabel8.setVisible(false);
            cashbox.setVisible(false);
            balancebox.setVisible(false);
        }
    }//GEN-LAST:event_cashcheckboxActionPerformed

    private void cashboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashboxActionPerformed
        // TODO add your handling code here:
        
        double balance = Double.parseDouble(cashbox.getText());
        
        if(balance < amount){
            JOptionPane.showMessageDialog(null, "Invalid value");
        }
        else{
        balance = balance - amount;
        balancebox.setText(String.valueOf(balance));
        }
        
        
    }//GEN-LAST:event_cashboxActionPerformed

    private void balanceboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balanceboxActionPerformed

    private void tableboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableboxActionPerformed

        try
        {
            String sql ="SELECT price FROM tables Where tid ="+TableNumber;
                    resultSet = statement.executeQuery(sql);
                    while(resultSet.next())
                    {
                        amount = resultSet.getDouble("price");
                        amount = amount - (amount * (discount/100));
                        amountbox.setText(String.valueOf(amount));
                    }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_tableboxActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        area.setText("*********************\n");
        area.setText(area.getText()+"*    Royal Kandian    *\n");
        area.setText(area.getText()+"*********************\n");

       // Date obj = new Date();

        //String date = obj.toString();

      //  area.setText(area.getText()+"\n"+date+);
        area.setText(area.getText()+"Table number: "+tablebox.getText()+"\n\n");
        

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Do you want to print the receipt");
        if(x == 0){
            try{
                area.print();
            }
            catch(Exception e){

            }

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
         area.setText("");
  
    }//GEN-LAST:event_jButton2ActionPerformed
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Creditcheckbox;
    private javax.swing.JPanel Message;
    private javax.swing.JTextField amountbox;
    private javax.swing.JTextArea area;
    private javax.swing.JTextField balancebox;
    private javax.swing.JTextField cashbox;
    private javax.swing.JCheckBox cashcheckbox;
    private javax.swing.JTextField discountBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tablebox;
    // End of variables declaration//GEN-END:variables
}