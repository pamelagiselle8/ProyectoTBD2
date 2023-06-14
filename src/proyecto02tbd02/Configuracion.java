package proyecto02tbd02;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Configuracion extends javax.swing.JFrame {
    Connection connPostgreSQL = null;
    Connection connOracle = null;

    
    public Configuracion() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pass1 = new javax.swing.JTextField();
        nomInst1 = new javax.swing.JTextField();
        nomBD1 = new javax.swing.JTextField();
        puerto1 = new javax.swing.JTextField();
        user1 = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnProbar2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pass2 = new javax.swing.JTextField();
        user2 = new javax.swing.JTextField();
        puerto2 = new javax.swing.JTextField();
        nomBD2 = new javax.swing.JTextField();
        nomInst2 = new javax.swing.JTextField();
        btnProbar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel3.setText("Base de Datos Origen");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel4.setText("Nombre instancia");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 150, 20));

        jLabel5.setText("Nombre Base de Datos");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, 20));

        jLabel6.setText("Puerto");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, 20));

        jLabel7.setText("Nombre usuario");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        jLabel8.setText("Password");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));
        getContentPane().add(pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 180, -1));
        getContentPane().add(nomInst1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 180, -1));
        getContentPane().add(nomBD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 180, -1));
        getContentPane().add(puerto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 180, -1));
        getContentPane().add(user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 180, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 723, 140, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Configuración de Bases de Datos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        btnProbar2.setText("Probar conexion");
        btnProbar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProbar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnProbar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 650, 180, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setText("Base de Datos Destino");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, -1, -1));

        jLabel9.setText("Nombre instancia");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 150, 20));

        jLabel10.setText("Nombre Base de Datos");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, -1, 20));

        jLabel11.setText("Puerto");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, -1, 20));

        jLabel12.setText("Nombre usuario");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, -1, -1));

        jLabel13.setText("Password");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 610, -1, -1));
        jPanel1.add(pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 610, 180, -1));
        jPanel1.add(user2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 570, 180, -1));
        jPanel1.add(puerto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, 180, -1));
        jPanel1.add(nomBD2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 180, -1));
        jPanel1.add(nomInst2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 180, -1));

        btnProbar1.setText("Probar conexion");
        btnProbar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProbar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnProbar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 810));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProbar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProbar1ActionPerformed
        Connection connPostgreSQL = null;
        String nomBD = nomBD1.getText();
        String url = "jdbc:postgresql://localhost:5432/" + nomBD;
        String user = user1.getText();
        String pass = pass1.getText();

        try {
            Class.forName("org.postgresql.Driver");
            connPostgreSQL = DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(this, "Conexion exitosa\n");
            connPostgreSQL.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al conectar\n" + e);
        }
        
    }//GEN-LAST:event_btnProbar1ActionPerformed

    private void btnProbar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProbar2ActionPerformed
        
    }//GEN-LAST:event_btnProbar2ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    
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
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnProbar1;
    private javax.swing.JButton btnProbar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nomBD1;
    private javax.swing.JTextField nomBD2;
    private javax.swing.JTextField nomInst1;
    private javax.swing.JTextField nomInst2;
    private javax.swing.JTextField pass1;
    private javax.swing.JTextField pass2;
    private javax.swing.JTextField puerto1;
    private javax.swing.JTextField puerto2;
    private javax.swing.JTextField user1;
    private javax.swing.JTextField user2;
    // End of variables declaration//GEN-END:variables
}
