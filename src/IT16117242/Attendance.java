package IT16117242;

import IT16117242.DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WARUNI
 */
public class Attendance extends javax.swing.JInternalFrame {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form Attendance
     */
    public Attendance() {
        initComponents();
        
        con= DBConnection.connect();
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
        jPanel2 = new javax.swing.JPanel();
        Eid = new javax.swing.JTextField();
        Ename = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ArrType = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        SubmitLeavebtn = new javax.swing.JButton();
        SubmitAttendancebtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        AmPm2 = new javax.swing.JComboBox<>();
        AmPm1 = new javax.swing.JComboBox<>();
        Atime = new javax.swing.JComboBox<>();
        Ltime = new javax.swing.JComboBox<>();
        overtimelabel = new javax.swing.JLabel();
        overTime = new javax.swing.JTextField();
        Showbtn = new javax.swing.JButton();
        min1 = new javax.swing.JTextField();
        min2 = new javax.swing.JTextField();
        OKserachbtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Attendance");
        setPreferredSize(new java.awt.Dimension(950, 650));

        jPanel1.setBackground(new java.awt.Color(52, 52, 86));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 86), 3));
        jPanel1.setPreferredSize(new java.awt.Dimension(950, 640));

        jPanel2.setBackground(new java.awt.Color(159, 159, 159));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 600));
        jPanel2.setRequestFocusEnabled(false);

        Eid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        Ename.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Ename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee ID        :");
        jLabel2.setPreferredSize(new java.awt.Dimension(190, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee Name   :");
        jLabel3.setPreferredSize(new java.awt.Dimension(190, 30));

        jPanel3.setBackground(new java.awt.Color(50, 50, 100));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date                   :");
        jLabel4.setPreferredSize(new java.awt.Dimension(190, 30));

        date.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Arrival Type         :");

        ArrType.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        ArrType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one", "Day", "Night" }));
        ArrType.setPreferredSize(new java.awt.Dimension(220, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ArrType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(ArrType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(50, 50, 100));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Leave Time          :");
        jLabel6.setPreferredSize(new java.awt.Dimension(190, 30));

        SubmitLeavebtn.setBackground(new java.awt.Color(52, 52, 86));
        SubmitLeavebtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        SubmitLeavebtn.setForeground(new java.awt.Color(255, 255, 255));
        SubmitLeavebtn.setText("Submit Leave");
        SubmitLeavebtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan));
        SubmitLeavebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitLeavebtnActionPerformed(evt);
            }
        });

        SubmitAttendancebtn.setBackground(new java.awt.Color(52, 52, 86));
        SubmitAttendancebtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        SubmitAttendancebtn.setForeground(new java.awt.Color(255, 255, 255));
        SubmitAttendancebtn.setText("Submit Attendence");
        SubmitAttendancebtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan));
        SubmitAttendancebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitAttendancebtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Arrival Time         :");
        jLabel5.setPreferredSize(new java.awt.Dimension(190, 30));

        AmPm2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        AmPm2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "am", "pm" }));
        AmPm2.setPreferredSize(new java.awt.Dimension(100, 30));

        AmPm1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        AmPm1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "am", "pm" }));
        AmPm1.setPreferredSize(new java.awt.Dimension(100, 30));

        Atime.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Atime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        Ltime.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Ltime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        Ltime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LtimeActionPerformed(evt);
            }
        });

        overtimelabel.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        overtimelabel.setForeground(new java.awt.Color(255, 255, 255));
        overtimelabel.setText("Overtime perDay   :   ");
        overtimelabel.setPreferredSize(new java.awt.Dimension(190, 30));

        overTime.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        overTime.setPreferredSize(new java.awt.Dimension(220, 30));

        Showbtn.setBackground(new java.awt.Color(52, 52, 86));
        Showbtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Showbtn.setForeground(new java.awt.Color(255, 255, 255));
        Showbtn.setText("Show");
        Showbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan));
        Showbtn.setPreferredSize(new java.awt.Dimension(90, 30));
        Showbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(overtimelabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(Atime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(min1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AmPm1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(Ltime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(min2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AmPm2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SubmitAttendancebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SubmitLeavebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(overTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addComponent(Showbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(min1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Atime, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AmPm1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10)
                .addComponent(SubmitAttendancebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AmPm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ltime, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(min2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(SubmitLeavebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(overtimelabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(overTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Showbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        OKserachbtn.setBackground(new java.awt.Color(52, 52, 86));
        OKserachbtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        OKserachbtn.setForeground(new java.awt.Color(255, 255, 255));
        OKserachbtn.setText("OK");
        OKserachbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan));
        OKserachbtn.setPreferredSize(new java.awt.Dimension(30, 30));
        OKserachbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKserachbtnActionPerformed(evt);
            }
        });

        ResetBtn.setBackground(new java.awt.Color(52, 52, 86));
        ResetBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        ResetBtn.setForeground(new java.awt.Color(255, 255, 255));
        ResetBtn.setText("Reset");
        ResetBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan));
        ResetBtn.setPreferredSize(new java.awt.Dimension(190, 30));
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ename, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Eid, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(OKserachbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Eid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OKserachbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ename, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, 934, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, 619, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnameActionPerformed

    private void SubmitAttendancebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitAttendancebtnActionPerformed
        
    
        String eid = Eid.getText();
        String ename = Ename.getText();
        String atype = ArrType.getSelectedItem().toString();
        
        int atime = Integer.valueOf(Atime.getSelectedItem().toString());
        int ltime = Integer.valueOf(Ltime.getSelectedItem().toString());
        
        if(AmPm1.getSelectedItem().toString().equalsIgnoreCase("pm"))
        {
            atime = atime + 12;
        }
       
        if(AmPm2.getSelectedItem().toString().equalsIgnoreCase("pm"))
        {
            ltime = ltime +  12;
        }
        
         try{
             
            LocalDate today = LocalDate.now();
            int month= today.getMonthValue();
            int year=today.getYear();
            LocalDate date1=LocalDate.now();
           
            
            
            String sqlq="SELECT Date from attendance WHERE StaffID='"+eid+"'";
                pst = con.prepareStatement(sqlq);
                rs = pst.executeQuery();
                
                while(rs.next())
                {
              
                    String olddate = rs.getString("Date");
                    String dat=String.valueOf(date1);
                    
        if( dat.equals(olddate))
        {    
            Alerts A = new Alerts("Employee already exists");
            A.setVisible(true);
            A.setLocationRelativeTo(this);
            return; 
        }
                }
        
        
        String qry1 = "INSERT INTO attendance(StaffID,ArrTime,Name,Date,Month,Year,AttnType) values('"+eid+"','"+atime+"','"+ename+"','"+date1+"','"+month+"','"+year+"','"+atype+"')";
        
        pst = con.prepareStatement(qry1);
        pst.execute();
        System.out.println("Data added sucessfully");
        
        Confirmation C =new Confirmation("Details successfully added");
        C.setVisible(true);
        C.setLocationRelativeTo(this);
                }
       catch(SQLException e)
       {
           System.out.println("There is an exception"+e);
           
       }
            
       
        
    }                                         
/*
    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {          
    }//GEN-LAST:event_SubmitAttendancebtnActionPerformed
*/
    private void SubmitLeavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitLeavebtnActionPerformed
 
        int Id = Integer.valueOf(Eid.getText());
        String dat = date.getText();
        
        int atime = Integer.valueOf(Atime.getSelectedItem().toString());
        int ltime = Integer.valueOf(Ltime.getSelectedItem().toString());
        
        if(AmPm2.getSelectedItem().toString().equalsIgnoreCase("pm"))
        {
            ltime = ltime +  12;
        }
       
            try
            {   //add leave time time mean update the same tupple
                String sql2= "UPDATE attendance set Lvtime="+ltime+" WHERE StaffID="+Id+" AND Date='"+dat+"'";
        
                pst = con.prepareStatement(sql2);
                pst.execute();
                
                
                Confirmation C =new Confirmation("Details successfully added");
                C.setVisible(true);
                C.setLocationRelativeTo(this);
           
              
                
         
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }
            
        
         
        
    }//GEN-LAST:event_SubmitLeavebtnActionPerformed

    private void OKserachbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKserachbtnActionPerformed
       
        String Id = Eid.getText();
        
       try
       {
        String sqlA ="SELECT id,name FROM staff WHERE id='"+Id+"'";
        pst = con.prepareStatement(sqlA);
        rs = pst.executeQuery();
       
        Eid.setText("");
        Ename.setText("");
        Atime.setSelectedItem("");
        date.setText("");
        Ltime.setSelectedItem("");
        ArrType.setSelectedItem(null);
        
       
            LocalDate date1=LocalDate.now();
            
            
        while(rs.next())
        {
            Eid.setText(rs.getString("id"));
            Ename.setText(rs.getString("name"));
            date.setText(String.valueOf(date1));

        }
        
        System.out.println("Data took sucessfully");
        
       
        
        }
       catch(SQLException e)
       {
            System.out.println(e);
       }
        
         
        
    }//GEN-LAST:event_OKserachbtnActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        
        Eid.setText("");
        Ename.setText("");
        date.setText("");
        Atime.setSelectedItem("");
        Ltime.setSelectedItem("");
        ArrType.setSelectedItem(null);
        overTime.setText("");
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void LtimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LtimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LtimeActionPerformed

    private void ShowbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowbtnActionPerformed
       
        int Id = Integer.valueOf(Eid.getText());
        String dat = date.getText();
        
        
        try
        {
             overTime.setText("");
        
                String sqlL="SELECT ArrTime,Lvtime,Date FROM attendance WHERE StaffID="+Id+" AND Date='"+dat+"'";
                pst= con.prepareStatement(sqlL);
                rs = pst.executeQuery();
                
                while(rs.next()){
                int arrivetime=rs.getInt("ArrTime");
                int leavetime=rs.getInt("Lvtime");
                int worktime = leavetime-arrivetime;
                int overtime = worktime-9;
                 
        
                
                if(worktime>9)
                {
                String sql3 = "UPDATE attendance set Overtime ='"+overtime+"' WHERE StaffID="+Id+" AND Date='"+dat+"'";
                pst= con.prepareStatement(sql3);
                pst.execute();
                overTime.setText(String.valueOf(overtime));
                
                }
                else
                {
                  overTime.setText("0"); 
                }
                
                }
        }
        
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_ShowbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AmPm1;
    private javax.swing.JComboBox<String> AmPm2;
    private javax.swing.JComboBox<String> ArrType;
    private javax.swing.JComboBox<String> Atime;
    private javax.swing.JTextField Eid;
    private javax.swing.JTextField Ename;
    private javax.swing.JComboBox<String> Ltime;
    private javax.swing.JButton OKserachbtn;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JButton Showbtn;
    private javax.swing.JButton SubmitAttendancebtn;
    private javax.swing.JButton SubmitLeavebtn;
    private javax.swing.JTextField date;
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
    private javax.swing.JTextField min1;
    private javax.swing.JTextField min2;
    private javax.swing.JTextField overTime;
    private javax.swing.JLabel overtimelabel;
    // End of variables declaration//GEN-END:variables
}