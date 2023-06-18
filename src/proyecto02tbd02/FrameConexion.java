package proyecto02tbd02;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class FrameConexion extends javax.swing.JFrame {
    Connection connPostgreSQL = null;
    Connection connOracle = null;
    String nomBDOrigen = "", nomBDDestino = "",
            portOrigen = "", portDestino = "",
            userOrigen = "", userDestino = "",
            passOrigen = "", passDestino = "";
    boolean conexion1 = false, conexion2 = true;
    int idBitacora = 0;
    DefaultListModel modelDisp = new DefaultListModel(),
                    modelRep = new DefaultListModel();
    
    public FrameConexion() {
        initComponents();
        this.setLocationRelativeTo(null);
        FrameReplicacion.setLocationRelativeTo(this);
        FrameReplicacion.setSize(670, 520);
    }
    
    // Actualizar la lista de tablas disponibles para replicacion
    public void cargarListas() {
        if (conexion1 && conexion2) {
            modelDisp = new DefaultListModel();
            modelRep = new DefaultListModel();

            // Consulta para obtener los nombres de las tablas origen
            String query = "SELECT table_name " +
                        "FROM information_schema.tables " +
                        "WHERE table_type = 'BASE TABLE' AND table_schema = 'public'";
            try {
                // Ejecutar la consulta
                PreparedStatement statement = connPostgreSQL.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();

                // Agregar los nombres de las tablas a la lista de tablas disponibles para replicacion
                while (resultSet.next()) {
                    String tableName = resultSet.getString("table_name");
                    modelDisp.addElement(tableName);
                }

            } catch (SQLException ex) {
                Logger.getLogger(FrameConexion.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Actualizar las listas
            jlistDisp.setModel(modelDisp);
            jlistRep.setModel(modelRep);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FrameReplicacion = new javax.swing.JFrame();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlistDisp = new javax.swing.JList<>();
        btnRep = new javax.swing.JButton();
        btnNoRep = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnGuardarRep = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlistRep = new javax.swing.JList<>();
        btnRegresar = new javax.swing.JButton();
        btnCancelarRep = new javax.swing.JButton();
        jFrame1 = new javax.swing.JFrame();
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

        FrameReplicacion.setResizable(false);
        FrameReplicacion.setSize(new java.awt.Dimension(670, 520));
        FrameReplicacion.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel14.setText("Tablas BD Origen");
        FrameReplicacion.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel15.setText("Sin replicar");
        FrameReplicacion.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 80, -1));

        jlistDisp.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlistDisp);

        FrameReplicacion.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 160, -1));

        btnRep.setText("->");
        btnRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepActionPerformed(evt);
            }
        });
        FrameReplicacion.getContentPane().add(btnRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 70, -1));

        btnNoRep.setText("<-");
        btnNoRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoRepActionPerformed(evt);
            }
        });
        FrameReplicacion.getContentPane().add(btnNoRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 70, -1));

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel16.setText("Replicando");
        FrameReplicacion.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, -1, -1));

        btnGuardarRep.setText("Guardar");
        btnGuardarRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRepActionPerformed(evt);
            }
        });
        FrameReplicacion.getContentPane().add(btnGuardarRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlistRep.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jlistRep);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 160, -1));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, -1, -1));

        btnCancelarRep.setText("Cancelar");
        btnCancelarRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRepActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelarRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, -1, -1));

        FrameReplicacion.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 520));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
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
        connPostgreSQL = null;
        String nomBD = nomBD1.getText();
        String puerto = (puerto1.getText().isEmpty() ? "5432" : puerto1.getText());
        String url = "jdbc:postgresql://localhost:" + puerto + "/" + nomBD;
        String user = (user1.getText().isEmpty() ? "postgres" : user1.getText());
        String pass = pass1.getText();

        try {
            Class.forName("org.postgresql.Driver");
            connPostgreSQL = DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(this, "Conexion exitosa");
            conexion1 = true;
        }
        catch (ClassNotFoundException e) { e.printStackTrace(); }
        catch (SQLException e) { e.printStackTrace(); }
    }//GEN-LAST:event_btnProbar1ActionPerformed

    private void btnProbar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProbar2ActionPerformed
        connOracle = null;
        String nomBD = nomBD2.getText();
        String puerto = (puerto1.getText().isEmpty() ? "1521" : puerto1.getText());
        String url = "jdbc:oracle:thin:@localhost:" + puerto + ":xe";
        String user = (user2.getText().isEmpty() ? "SYSTEM" : user2.getText());
        String pass = pass2.getText();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connOracle = DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(this, "Conexion exitosa");
            conexion2 = true;
        }
        catch (ClassNotFoundException e) { e.printStackTrace(); }
        catch (SQLException e) { e.printStackTrace(); }
    }//GEN-LAST:event_btnProbar2ActionPerformed
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (conexion1 && conexion2) {
            // Crear log table en la BD origen
            String queryLogTable =  "DROP TABLE IF EXISTS bitacora; " +
                                    "CREATE TABLE bitacora (" +
                                    "id serial PRIMARY KEY, " +
                                    "fecha timestamp, " +
                                    "accion varchar(2000), " +
                                    "deshacer varchar(2000));";
            // Cargar la lista de tablas disponibles para replicacion
            cargarListas();
            FrameReplicacion.setVisible(true);
            this.setVisible(false);
        }
        else {
            JOptionPane.showMessageDialog(this, "Las conexiones a las bases de datos deben ser exitosas para continuar.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrameReplicacion.setVisible(false);
        this.setVisible(true);
        try {
            conexion1 = false;
            conexion2 = false;
//            connOracle.close();
            connPostgreSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(FrameConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepActionPerformed
        if (jlistDisp.getSelectedIndex() >= 0) {
            // Agregar una tabla de la BD origen a la lista de tablas a replicar
            modelRep.addElement(modelDisp.elementAt(jlistDisp.getSelectedIndex()));
            modelDisp.remove(jlistDisp.getSelectedIndex());
        }
        else { JOptionPane.showMessageDialog(this, "Debe seleccionar una tabla."); }
    }//GEN-LAST:event_btnRepActionPerformed

    private void btnNoRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoRepActionPerformed
        if (jlistRep.getSelectedIndex() >= 0) {
            // Quitar una tabla de la lista de tablas a replicar
            modelDisp.addElement(modelRep.elementAt(jlistRep.getSelectedIndex()));
            modelRep.remove(jlistRep.getSelectedIndex());
        }
        else { JOptionPane.showMessageDialog(this, "Debe seleccionar una tabla."); }
    }//GEN-LAST:event_btnNoRepActionPerformed

    private void btnGuardarRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRepActionPerformed
        // Ejecutar el job de replicacion en la BD destino
        
    }//GEN-LAST:event_btnGuardarRepActionPerformed

    private void btnCancelarRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRepActionPerformed
        // Descartar cambios
        cargarListas();
    }//GEN-LAST:event_btnCancelarRepActionPerformed

    
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
            java.util.logging.Logger.getLogger(FrameConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameConexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FrameReplicacion;
    private javax.swing.JButton btnCancelarRep;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarRep;
    private javax.swing.JButton btnNoRep;
    private javax.swing.JButton btnProbar1;
    private javax.swing.JButton btnProbar2;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRep;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jlistDisp;
    private javax.swing.JList<String> jlistRep;
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
