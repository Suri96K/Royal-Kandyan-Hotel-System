/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT17006958;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author USER
 */
public class CustomersMsg extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet resultset = null;
    /**
     * Creates new form Messages
     */
    public CustomersMsg() {
        initComponents();
    }
    
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
        ResultSet resultset = null;
        
        int rows = 0;
        String contents[][] = new String[6][6];
        
        
        
        try{
            connection = DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();
            String sql ="SELECT * FROM messages ";
            resultset = pst.executeQuery(sql);
            int i=0;
            while(resultset.next())
            {
                contents[i][0]=String.valueOf(resultset.getInt("ID"));
                contents[i][1]=resultset.getString("Sender");
                contents[i][2]=resultset.getString("Message");
                contents[i][3]=resultset.getString("Reciever");
                contents[i][4]=resultset.getString("Reply");
                contents[i][5]=String.valueOf(resultset.getInt("Received"));
               
                i = i + 1;
            }
        }
        catch (Exception e) {
        e.printStackTrace();
        }
        
        
        
        
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(contents, new String [] {"ID", "Sender", "Message","Reciever" ,"Reply","Received"}) 
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
        idBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        senderBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        receiverBox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        msgTextArea = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        button1 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(50, 50, 83));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reply:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, -1, -1));

        idBox.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        idBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idBoxActionPerformed(evt);
            }
        });
        jPanel2.add(idBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 120, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reciever:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, -1, -1));

        senderBox.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        senderBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senderBoxActionPerformed(evt);
            }
        });
        jPanel2.add(senderBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 230, 120, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sender:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, -1, -1));

        receiverBox.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        receiverBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiverBoxActionPerformed(evt);
            }
        });
        jPanel2.add(receiverBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, 120, -1));

        jButton1.setBackground(new java.awt.Color(100, 255, 218));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 510, -1, 38));

        jButton2.setBackground(new java.awt.Color(100, 255, 218));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, -1, 38));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Sender", "Message	", "Receiver", "Reply", "Received"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 580, 140));

        msgTextArea.setColumns(20);
        msgTextArea.setRows(5);
        jScrollPane2.setViewportView(msgTextArea);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 280, 270, 150));

        jLabel20.setFont(new java.awt.Font("Segoe UI Historic", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Customers' Message");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 1040, 14));

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
        jPanel2.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 82, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1257, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 392, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idBoxActionPerformed

    private void senderBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senderBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senderBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
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
        ResultSet resultset = null;
        
        int rows = 0;
        String contents[][] = new String[4][4];
        
        
        
        try{
            connection = DriverManager.getConnection(url,user,password);
            statement=connection.createStatement();
            String sql ="SELECT * FROM messages ";
            resultset = pst.executeQuery(sql);
            int i=0;
            while(resultset.next())
            {
                contents[i][0]=String.valueOf(resultset.getInt("ID"));
                contents[i][1]=resultset.getString("Sender");
                contents[i][2]=resultset.getString("Message");
                contents[i][3]=resultset.getString("Reciever");
              
               
                i = i + 1;
            }
        }
        catch (Exception e) {
        e.printStackTrace();
        }
        
        
        
        
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(contents, new String [] {"ID", "Sender", "Message","Reciever" }) 
        { 
           
        boolean[] canEdit = new boolean [] {false, false, false, false, false,true};

        public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];   
    }
    });    
   

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        idBox.setText("");
        senderBox.setText("");
        msgTextArea.setText("");
        receiverBox.setText("");
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

        Main h2 = new Main();
        h2.setVisible(true);
    }//GEN-LAST:event_button1ActionPerformed

    private void receiverBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiverBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receiverBoxActionPerformed

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
            java.util.logging.Logger.getLogger(CustomersMsg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomersMsg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomersMsg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomersMsg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomersMsg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JTextField idBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea msgTextArea;
    private javax.swing.JTextField receiverBox;
    private javax.swing.JTextField senderBox;
    // End of variables declaration//GEN-END:variables
}
