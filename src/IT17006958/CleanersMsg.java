/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT17006958;

/**
 *
 * @author USER
 */
public class CleanersMsg extends javax.swing.JFrame {

    /**
     * Creates new form CleanersMsg
     */
    public CleanersMsg() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        msgBox = new javax.swing.JTextField();
        cnBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ceBox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cidBox = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(50, 50, 83));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cleaners' email:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Message:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, -1, -1));

        msgBox.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        msgBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msgBoxActionPerformed(evt);
            }
        });
        jPanel2.add(msgBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 250, 120, -1));

        cnBox.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        cnBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnBoxActionPerformed(evt);
            }
        });
        jPanel2.add(cnBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, 120, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cleaners name:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, -1, -1));

        ceBox.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        ceBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceBoxActionPerformed(evt);
            }
        });
        jPanel2.add(ceBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 200, 120, -1));

        jButton1.setBackground(new java.awt.Color(100, 255, 218));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 350, -1, 38));

        jButton2.setBackground(new java.awt.Color(100, 255, 218));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, -1, 38));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cleaners ID:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, -1, -1));

        cidBox.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        cidBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidBoxActionPerformed(evt);
            }
        });
        jPanel2.add(cidBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msgBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msgBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msgBoxActionPerformed

    private void cnBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnBoxActionPerformed

    private void ceBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ceBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        
        cnBox.setText("");
        cidBox.setText("");
        ceBox.setText("");
        msgBox.setText("");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cidBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidBoxActionPerformed

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
            java.util.logging.Logger.getLogger(CleanersMsg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CleanersMsg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CleanersMsg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CleanersMsg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CleanersMsg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ceBox;
    private javax.swing.JTextField cidBox;
    private javax.swing.JTextField cnBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField msgBox;
    // End of variables declaration//GEN-END:variables
}
