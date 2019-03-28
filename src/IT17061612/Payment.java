/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT17061612;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getString;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Chanuka Balagalla
 */
public class Payment extends javax.swing.JInternalFrame {

    /**
     * Creates new form Payment
     */
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;
    private final String url = "jdbc:mysql://localhost:3306/hotelsystem";
    private final String user = "root";
    private final String password = "";
    private final String driver = "com.mysql.jdbc.Driver";
    private int bookingID;
    private int reservationID;
    private int paymentID;
    private volatile double ID = 0;
    private volatile int i = 0;
    
    public Payment() {
        initComponents();
        
  //      checkDelete T = new checkDelete();
  //      T.start();
 
           tableLoad1();
    }
    
    public void tableLoad1(){
     ResultSet resultSet2 = null;
     ResultSet resultSet3 = null;
     ResultSet resultSet4 = null;
     
        String contents[][] = new String[10][5];
        try {
                String sql = "SELECT Message FROM messages WHERE Message LIKE '%Delete Booking: Booking ID%' AND Received=0";
                connection = DriverManager.getConnection(url,user,password);
                preparedStatement=connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                
           int i=0;
           
           
            while(resultSet.next())
            {
                bookingID = Integer.parseInt(resultSet.getString("Message").replaceAll("\\D+",""));
                String sql8 = "SELECT paymentID FROM bookings WHERE id="+bookingID;
                connection = DriverManager.getConnection(url,user,password);
                preparedStatement=connection.prepareStatement(sql8);
                resultSet2 = preparedStatement.executeQuery();
                
                int j = 0;
                while(resultSet2.next())
                {
                    paymentID = resultSet2.getInt("paymentID");
                    j = j+1;
                }
                contents[i][0]=String.valueOf(paymentID);
                i=i+1;
            }

            
            
            String sql2 = "SELECT Message FROM messages Where Message LIKE '%Delete Hall Reservation: Reservation ID%' AND Received=0";
                connection = DriverManager.getConnection(url,user,password);
                preparedStatement=connection.prepareStatement(sql2);
                resultSet = preparedStatement.executeQuery();
                
            while(resultSet.next())
            {
               reservationID = Integer.parseInt(resultSet.getString("Message").replaceAll("\\D+",""));
               
            
            
            String sql3 = "SELECT payment.id FROM reservation,guest,payment WHERE reservation.guestId=guest.ID AND payment.GuestID=reservation.guestId AND reservation.id="+reservationID+" "
                    + "AND  payment.type LIKE '%Hall%'";
                connection = DriverManager.getConnection(url,user,password);
                preparedStatement=connection.prepareStatement(sql3);
                resultSet4 = preparedStatement.executeQuery();
                
            while(resultSet4.next())
            {
                contents[i][0]=String.valueOf(resultSet4.getInt("id"));
                i = i + 1;
            }
            }   
                payment.setModel(DbUtils.resultSetToTableModel(resultSet));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        payment.setModel(new javax.swing.table.DefaultTableModel( contents,new String [] {"Payment ID"}) {boolean[] canEdit = new boolean [] {false};
        public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
            }
        });
}
 
 /*
 public void tableLoad2(){
        String contents[][] = new String[10][5];
        try {
                String sql = "SELECT Message FROM messages Where Message LIKE '%Delete Reservation: Reservation ID%' AND Received=0";
                connection = DriverManager.getConnection(url,user,password);
                preparedStatement=connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                
            int i=0;
            while(resultSet.next())
            {
               reservationID = Integer.parseInt(resultSet.getString("Message").replaceAll("\\D+",""));
                contents[i][0]=String.valueOf(reservationID);
                i = i + 1;
            }
                
                reservation.setModel(DbUtils.resultSetToTableModel(resultSet));
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        reservation.setModel(new javax.swing.table.DefaultTableModel( contents,new String [] {"Reservation ID"}) {boolean[] canEdit = new boolean [] {false};
        public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
            }
        });
}   
    
*/    
    
    
    
   /* 
    
    class checkDelete extends Thread
    {
        
        @Override
        public void run()
        { 
            try
            {
                Class.forName(driver);
                connection = DriverManager.getConnection(url,user,password);
                statement=connection.createStatement();

                    String sql ="SELECT Message FROM messages Where Message LIKE '%Delete Booking%'";
                    resultSet = statement.executeQuery(sql);
                    while(resultSet.next())
                    {
                //        jLabel1.setText(jLabel1.getText()+"\n"+resultSet.getString("Message"));
                        paymentID = Integer.parseInt(resultSet.getString("Message").replaceAll("\\D+",""));
                                
                    }
                    
                    String sql2 ="SELECT Message FROM messages Where Message LIKE '%Set Discount: Discount Rate%'";
                    resultSet = statement.executeQuery(sql2);
                    while(resultSet.next())
                    {
                        ID = Double.parseDouble(resultSet.getString("Message").replaceAll("\\D+",""));
        //                discountBox.setText(ID);
                    }

                    Thread.sleep(1000);     //1 second
                
            }
            catch (Exception e) {
            e.printStackTrace();
            }
        }
    }
    
    
 */
    
    
    
    
    
    
 /*   private volatile int i = 0;
    class checkDelete extends Thread
    {
        
        @Override
        public void run()
        { 
            
            try
            {
                Class.forName(driver);
                connection = DriverManager.getConnection(url,user,password);
                statement=connection.createStatement();
                
                while(i==0)
                {
                    String sql ="SELECT Message FROM messages Where Message LIKE '%Delete Booking%'"
                            + " AND Receiver='Accounting' AND Reply=0 AND Received=0";
                    resultSet = statement.executeQuery(sql);
                    while(resultSet.next())
                    {
                        Msg.setText(Msg.getText()+"\n"+resultSet.getString("Message"));
                        
                        
                     String sq2l = "UPDATE Messages set Received=1 WHERE Message='"+resultSet.getString("Message")+"'";
                         
                        try{

                            connection = DriverManager.getConnection(url, user, password);
                            statement = connection.createStatement();
                         preparedStatement = connection.prepareStatement(sq2l);
                            preparedStatement.executeUpdate();
                        }
                        catch(SQLException e){
                        e.printStackTrace();
                        }
                        
                    }

                    Thread.sleep(1000);     //1 second
                }
             }
            catch (Exception e) {
            e.printStackTrace();
            }
        }
    }
    
*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        CancelP = new javax.swing.JButton();
        pAmount = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pid_lable = new javax.swing.JLabel();
        pID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        refund = new javax.swing.JTextField();
        income = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        Reset = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        payment = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1073, 715));

        jPanel2.setBackground(new java.awt.Color(131, 131, 131));
        jPanel2.setPreferredSize(new java.awt.Dimension(390, 640));

        jPanel3.setBackground(new java.awt.Color(29, 29, 66));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.cyan, java.awt.Color.cyan));
        jPanel3.setPreferredSize(new java.awt.Dimension(226, 36));

        jLabel4.setBackground(new java.awt.Color(50, 50, 86));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 255));
        jLabel4.setText("Payment Cancellation");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addGap(54, 54, 54))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(50, 50, 86));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray));
        jPanel1.setPreferredSize(new java.awt.Dimension(517, 254));

        CancelP.setBackground(new java.awt.Color(76, 76, 112));
        CancelP.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        CancelP.setForeground(new java.awt.Color(255, 255, 255));
        CancelP.setText("Cancel Payment");
        CancelP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan));
        CancelP.setMaximumSize(new java.awt.Dimension(97, 24));
        CancelP.setMinimumSize(new java.awt.Dimension(97, 24));
        CancelP.setPreferredSize(new java.awt.Dimension(97, 24));
        CancelP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelPActionPerformed(evt);
            }
        });

        pAmount.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        pAmount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan));
        pAmount.setPreferredSize(new java.awt.Dimension(14, 29));
        pAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pAmountActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(68, 68, 114));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(115, 115, 168)));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Press Enter to see the Payment Amount");

        pid_lable.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        pid_lable.setForeground(new java.awt.Color(255, 255, 255));
        pid_lable.setText("Payment ID               :");
        pid_lable.setMaximumSize(new java.awt.Dimension(149, 21));
        pid_lable.setMinimumSize(new java.awt.Dimension(149, 21));
        pid_lable.setPreferredSize(new java.awt.Dimension(149, 21));

        pID.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        pID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan));
        pID.setPreferredSize(new java.awt.Dimension(14, 29));
        pID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(pid_lable, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pID, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pid_lable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Payment Amount      :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(CancelP, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(CancelP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel4.setBackground(new java.awt.Color(50, 50, 86));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Refunded Amount          :");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Income                             :");

        refund.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        refund.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan));

        income.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        income.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refund, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(income, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(refund, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(income, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(50, 50, 86));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray));

        Reset.setBackground(new java.awt.Color(76, 76, 112));
        Reset.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        Reset.setForeground(new java.awt.Color(255, 255, 255));
        Reset.setText("Reset");
        Reset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan));
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel7.setBackground(new java.awt.Color(50, 50, 86));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray));

        jPanel8.setBackground(new java.awt.Color(68, 68, 114));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(115, 115, 168)));

        payment.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan));
        payment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "ID"
            }
        ));
        payment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(payment);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Select a Payment ID to cancel");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(53, 53, 53))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(59, 59, 59)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1071, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pIDActionPerformed

         String pricePattern = "[0-9.]+";
        
        if(!pID.getText().matches(pricePattern))
        {
            IT17061612.Alert A = new IT17061612.Alert("Please Check the Price");
            A.setDefaultCloseOperation(0);
            A.setVisible(true);
            A.setLocationRelativeTo(this);
            return;
        }
        
        int ID = Integer.valueOf(pID.getText());
        String sql = "SELECT amount FROM payment WHERE id="+ID;
        
        try 
        {
        Class.forName(driver);
        }
        catch (ClassNotFoundException e) 
        {
        e.printStackTrace();
        }
        
        try{
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            pAmount.setText("");
            
            while(resultSet.next()){
                pAmount.setText(resultSet.getString("amount"));
            }
        }
        catch(Exception e){
        e.printStackTrace();
        }
    }//GEN-LAST:event_pIDActionPerformed

    
    
    private void CancelPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelPActionPerformed

        ResultSet resultSet2 = null;
        ResultSet resultSet3 = null;
        double Amount = Double.valueOf(pAmount.getText());
        double Refund = Amount*(75/100.00);
        double Income = Amount*(25/100.00);
        int id = Integer.valueOf(pID.getText());
        int x = JOptionPane.showConfirmDialog(null, "Do you want to Delete this ?");
 //      checkDelete T = new checkDelete();
 //         T.start();
        
        
      if(x==0){

               try{
                            
//                String sql = "UPDATE payment SET amount="+Income+",discount=0 WHERE id='"+id+"'";
                String sql = "UPDATE payment SET amount="+Income+" WHERE id='"+id+"'";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();
                connection = DriverManager.getConnection(url, user, password);
                statement = connection.createStatement();
                preparedStatement.executeUpdate();
                 }
                 catch(SQLException e)
                 {
                     e.printStackTrace();
                 }

                try
                {

                String sql1 ="SELECT ID,Message FROM messages Where Message LIKE '%Delete Booking%'"
                + " AND Receiver='Accounting' AND Received=0";
                connection = DriverManager.getConnection(url,user,password);
                preparedStatement = connection.prepareStatement(sql1);
                resultSet = preparedStatement.executeQuery();
                    
                while(resultSet.next())
                {
                  String msg = resultSet.getString("Message");
                  bookingID = Integer.parseInt(resultSet.getString("Message").replaceAll("\\D+",""));
                  
                  String sql6 = "SELECT guestID,paymentID FROM bookings WHERE id="+bookingID;
                  try{
                        connection = DriverManager.getConnection(url,user,password);
                        preparedStatement=connection.prepareStatement(sql6);
                        resultSet2 = preparedStatement.executeQuery();
                            
                        while(resultSet2.next())
                        {
                            int gID = resultSet2.getInt("guestID");
                            int payID = resultSet2.getInt("paymentID");
                            
                            if(id == payID)
                            {
                                
                                 try{
                                connection = DriverManager.getConnection(url, user, password);
                                statement = connection.createStatement();
                                
                                String sq2l = "UPDATE messages set Received=1,Reply='Done' WHERE Message='"+resultSet.getString("Message")+"'";
                                PreparedStatement ps2 = connection.prepareStatement(sq2l);
                                ps2.executeUpdate();
                                
                                String sql3 = "UPDATE room SET GuestID=null, Booked=0, BookingID=null WHERE BookingID="+bookingID;
                                PreparedStatement ps3 = connection.prepareStatement(sql3);
                                ps3.executeUpdate();
                                
                                String sql5 = "UPDATE payment SET type = 'Booked' WHERE id="+id;
                            PreparedStatement pst5 = connection.prepareStatement(sql5);                        
                            pst5.executeUpdate();
                                }
                                catch(SQLException e){
                                e.printStackTrace();
                                }
                            
                             }
                            
                            
                        }
                      }
                  catch(SQLException e){
                       e.printStackTrace();
                      }
                        
                    }
            }
            catch (Exception e) {
            e.printStackTrace();
            }
                        
           
          
          try{
                String sql0 = "SELECT Message FROM messages Where Message LIKE '%Delete Hall Reservation: Reservation ID%' AND Received=0";
                connection = DriverManager.getConnection(url,user,password);
                preparedStatement=connection.prepareStatement(sql0);
                resultSet = preparedStatement.executeQuery();
                
            while(resultSet.next())
            {
               reservationID = Integer.parseInt(resultSet.getString("Message").replaceAll("\\D+",""));
               
               String sql6 = "SELECT payment.id FROM reservation,payment WHERE reservation.guestId=payment.GuestID AND reservation.id="+reservationID;
               try{
                        connection = DriverManager.getConnection(url,user,password);
                        preparedStatement=connection.prepareStatement(sql6);
                        resultSet3 = preparedStatement.executeQuery();
                        
                        
                while(resultSet3.next())
                {
                    int gID = resultSet3.getInt("id");
                    
                    if(id == gID){
                    
                        String sql4 = "UPDATE messages set Received=1,Reply='Done' WHERE Message='"+resultSet.getString("Message")+"'";
                           PreparedStatement pst4 = connection.prepareStatement(sql4);                        
                           pst4.executeUpdate(); 
                        
                        String sql3 = "UPDATE halls SET halls.ReservationID=null, halls.GuestID=null, halls.Booked=0 WHERE halls.GuestID=payment.GuestID AND payment.id="+id;
                           PreparedStatement pst3 = connection.prepareStatement(sql3);                        
                           pst3.executeUpdate();
                           
                           
                           
                           
                           
                    }
                           
                }        
        //                   String sql2 = "DELETE FROM reservation "
        //                                + "WHERE reservation.guestId=payment.GuestID AND payment.id="+id;
        //                    PreparedStatement pst2 = connection.prepareStatement(sql2);                        
        //                    pst2.executeUpdate();
                           
         //               String sql5 = "UPDATE payment SET type = 'Reserved' WHERE id="+id;
         //                   PreparedStatement pst5 = connection.prepareStatement(sql5);                        
          //                  pst5.executeUpdate();
                //        resultSet = statement.executeQuery(sql);
                        }
                        catch(SQLException e){
                        e.printStackTrace();
                        }         
                }
          }
          catch(Exception e){
        e.printStackTrace();
        }
          
           
            refund.setText(String.valueOf(Refund));
            income.setText(String.valueOf(Income));
                
        }
      
      tableLoad1();
        
 //       String message = Msg.getText();
 //       Msg.setText(message.replaceFirst("Delete Booking: Payment ID = "+pID.getText(), ""));
        

        IT17061612.Alert A =new IT17061612.Alert("Refunded Sucessfully.");
        A.setVisible(true);
        A.setDefaultCloseOperation(0);
        A.setVisible(true);
        A.setLocationRelativeTo(this);
     
        

    }//GEN-LAST:event_CancelPActionPerformed

    private void pAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pAmountActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
    
        pID.setText("");
        pAmount.setText("");
        refund.setText("");
        income.setText("");
        
    }//GEN-LAST:event_ResetActionPerformed

    private void paymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentMouseClicked
        
        int row = payment.getSelectedRow();
        String Id = payment.getValueAt(row, 0).toString();
        pID.setText(Id);
    }//GEN-LAST:event_paymentMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelP;
    private javax.swing.JButton Reset;
    private javax.swing.JTextField income;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField pAmount;
    private javax.swing.JTextField pID;
    private javax.swing.JTable payment;
    private javax.swing.JLabel pid_lable;
    private javax.swing.JTextField refund;
    // End of variables declaration//GEN-END:variables
}
