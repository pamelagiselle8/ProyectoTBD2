package proyecto02tbd02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
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
    boolean conexion1 = false, conexion2 = false;
    int idBitacora = 0;
    DefaultListModel modelDisp = new DefaultListModel(),
                    modelRep = new DefaultListModel();
    
    public FrameConexion() {
        initComponents();
        this.setLocationRelativeTo(null);
        FrameReplicacion.setLocationRelativeTo(this);
//        FrameReplicacion.setSize(622, 483);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        FrameReplicacion.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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
                Statement stmt = connPostgreSQL.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                
                // Agregar los nombres de las tablas a la lista de tablas disponibles para replicacion
                while (rs.next()) {
                    String tableName = rs.getString("table_name");
                    // Validar que no se incluya la tabla de bitacora
                    if (!tableName.equalsIgnoreCase("bitacoraOrigen"))
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
    
    public boolean borrarTrigger(String tabla, String trigger) {
        try {
            Statement stmt = connPostgreSQL.createStatement();
            String sqlBorrar = "DROP TRIGGER IF EXISTS "+ trigger +" ON "+ tabla +";";
            stmt.execute(sqlBorrar);
            System.out.println("trigger borrado " + trigger);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FrameConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlistRep = new javax.swing.JList<>();
        btnRegresar = new javax.swing.JButton();
        btnCancelarRep = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        btnGuardarRep = new javax.swing.JButton();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnProbarConnOracle = new javax.swing.JButton();
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
        btnProbarConnPostgres = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

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
        jPanel2.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, -1, -1));

        btnCancelarRep.setText("Cancelar");
        btnCancelarRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRepActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelarRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, -1, -1));

        jLabel17.setText("Última replicación:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 180, -1));

        btnGuardarRep.setText("Guardar");
        btnGuardarRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRepActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardarRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, -1, -1));

        FrameReplicacion.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 560));

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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Configuración de Bases de Datos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        btnProbarConnOracle.setText("Probar conexion");
        btnProbarConnOracle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProbarConnOracleActionPerformed(evt);
            }
        });
        jPanel1.add(btnProbarConnOracle, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 650, 180, -1));

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

        btnProbarConnPostgres.setText("Probar conexion");
        btnProbarConnPostgres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProbarConnPostgresActionPerformed(evt);
            }
        });
        jPanel1.add(btnProbarConnPostgres, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 180, -1));

        btnSalir.setText("Desconectar y salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 810, -1, 40));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 720, 140, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 880));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProbarConnPostgresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProbarConnPostgresActionPerformed
        connPostgreSQL = null;
        String dbServer = "postgresql-132239-0.cloudclusters.net"; // change it to your database server name 
        int dbPort = (puerto1.getText().isEmpty() ? 10114 : Integer.parseInt(puerto1.getText()));
        String dbName = (nomInst1.getText().isEmpty() ? "DBOrigen" : nomInst1.getText());
        String userName = (user1.getText().isEmpty() ? "admin" : user1.getText());
        String password = (pass1.getText().isEmpty() ? "Vacasvoladoras1" : pass1.getText());
        String url = String.format("jdbc:postgresql://172.106.0.58:"+dbPort+"/"+dbName+"?user="+userName+"&password="+password, 
                                        dbServer, dbPort, dbName, userName, password);
        try {
            connPostgreSQL = DriverManager.getConnection(url);
            
            // Boolean que guarda para verificar que la conexion a PostgreSQL este abierta y no sea nula
            conexion1 = ((connPostgreSQL != null) && (!connPostgreSQL.isClosed()));
            if (conexion1)
                JOptionPane.showMessageDialog(this, "Conexion a PostgreSQL exitosa");
            
        } catch (SQLException e) {
            System.out.println("PostgreSQL connection had an exception");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnProbarConnPostgresActionPerformed

    private void btnProbarConnOracleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProbarConnOracleActionPerformed
        connOracle = null;
        String dbServer = "oracle-132230-0.cloudclusters.net"; // change it to your database server name 
        int dbPort = (puerto1.getText().isEmpty() ? 19324 : Integer.parseInt(puerto1.getText()));
        String userName = (user2.getText().isEmpty() ? "admin" : user2.getText());
        String password = (pass2.getText().isEmpty() ? "Vacasvoladoras1" : pass2.getText());
        String url = String.format("jdbc:oracle:thin:@172.106.0.56:"+dbPort+":xe", dbServer, dbPort);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            connOracle = DriverManager.getConnection(url, userName, password);
            
            // Boolean que guarda para verificar que la conexion a Oracle este abierta y no sea nula
            conexion2 = ((connOracle != null) && (!connOracle.isClosed()));
            if (conexion2)
                JOptionPane.showMessageDialog(this, "Conexion a Oracle exitosa");
            
        } catch (SQLException e) {
            System.out.println("Oracle Server connection had an exception");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnProbarConnOracleActionPerformed
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (conexion1 && conexion2) {
            // Crear log table en la BD origen
            try {
                Statement stmt = connPostgreSQL.createStatement();
                String queryLogTable =  "CREATE TABLE IF NOT EXISTS bitacoraOrigen (" +
                                        "id SERIAL PRIMARY KEY, " +
                                        "operacion TEXT, " +
                                        "tabla TEXT, " +
                                        "columna TEXT, " +
                                        "nuevo_valor TEXT, " +
                                        "fecha_hora TIMESTAMP, " +
                                        "replicado BOOLEAN);";

                 stmt.executeUpdate(queryLogTable);

                stmt = connOracle.createStatement();
                queryLogTable = "BEGIN " +
                                "BEGIN " +
                                "EXECUTE IMMEDIATE 'DROP TABLE BITACORADESTINO'; " +
                                "EXCEPTION WHEN OTHERS THEN NULL; " +
                                "END; " +
                                "BEGIN " +
                                "EXECUTE IMMEDIATE 'CREATE TABLE BITACORADESTINO (" +
                                "operacion VARCHAR2(10), " +
                                "tabla VARCHAR2(100), " +
                                "columna VARCHAR2(100), " +
                                "nuevo_valor VARCHAR2(100), " +
                                "fecha_hora TIMESTAMP)'; " +
                                "EXCEPTION WHEN OTHERS THEN NULL; " +
                                "END; " +
                                "END;";
                stmt.executeUpdate(queryLogTable);

            } catch (SQLException ex) {
                Logger.getLogger(FrameConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            connOracle.close();
            connPostgreSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(FrameConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepActionPerformed
        // Agregar una tabla de la BD origen a la lista de tablas a replicar
        if (jlistDisp.getSelectedIndex() >= 0) {
//            try {
                String tablaReplicar = modelDisp.elementAt(jlistDisp.getSelectedIndex()).toString();
                // Cambios en el GUI
                modelRep.addElement(tablaReplicar);
                modelDisp.remove(jlistDisp.getSelectedIndex());

                // Crear trigger de insert
                crearTriggerInsert(tablaReplicar);
                // Crear trigger de update
                crearTriggerUpdate(tablaReplicar);
                // Crear trigger de delete
                crearTriggerDelete(tablaReplicar);

                
                // Todavia en proceso:
                // Copiar version actual de la tabla en la BD destino
//                Statement stmtPostgres = connPostgreSQL.createStatement();
//                ResultSet rsDataPostgres = stmtPostgres.executeQuery("SELECT * FROM nombre_tabla_postgres");
//                
//                String insertQuery = "INSERT INTO nombre_tabla_oracle VALUES (";
//                ResultSetMetaData rsmd = rsDataPostgres.getMetaData();
//                int columnCount = rsmd.getColumnCount();
//
//                while (rsDataPostgres.next()) {
//                    for (int i = 1; i <= columnCount; i++) {
//                        if (i > 1) {
//                            insertQuery += ",";
//                        }
//                        // Obtener el tipo de datos de la columna
//                        int columnType = rsmd.getColumnType(i);
//                        // Si es un valor de tipo string, agregar comillas simples alrededor del valor
//                        if (columnType == Types.VARCHAR || columnType == Types.CHAR || columnType == Types.NVARCHAR || columnType == Types.NCHAR) {
//                            insertQuery += "'" + rsDataPostgres.getString(i) + "'";
//                        } else {
//                            insertQuery += rsDataPostgres.getString(i);
//                        }
//                    }
//                    insertQuery += ")";
//
//                    Statement stmtOracleInsert = connOracle.createStatement();
//                    stmtOracleInsert.executeUpdate(insertQuery);
//                }

//            }
//            catch (SQLException ex) {
//                Logger.getLogger(FrameConexion.class.getName()).log(Level.SEVERE, null, ex);
//            }
            

        }
        else { JOptionPane.showMessageDialog(this, "Debe seleccionar una tabla."); }
    }//GEN-LAST:event_btnRepActionPerformed

    private void btnNoRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoRepActionPerformed
        if (jlistRep.getSelectedIndex() >= 0) {
            // Quitar una tabla de la lista de tablas a replicar
            String tablaReplicar = modelRep.elementAt(jlistRep.getSelectedIndex()).toString();
            // Cambios en el GUI
            modelDisp.addElement(modelRep.elementAt(jlistRep.getSelectedIndex()));
            modelRep.remove(jlistRep.getSelectedIndex());
            
            // Borrar triggers
            borrarTrigger(tablaReplicar, "InsertTriggerBitacora");
            borrarTrigger(tablaReplicar, "UpdateTriggerBitacora");
            borrarTrigger(tablaReplicar, "DeleteTriggerBitacora");
        }
        else { JOptionPane.showMessageDialog(this, "Debe seleccionar una tabla."); }
    }//GEN-LAST:event_btnNoRepActionPerformed

    private void btnGuardarRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRepActionPerformed
        // Ejecutar el job de replicacion en la BD destino
        
    }//GEN-LAST:event_btnGuardarRepActionPerformed

    private void btnCancelarRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRepActionPerformed
        if (modelRep.getSize() > 0) {
            for (int i = 0; i < modelRep.getSize(); i++) {
                try {
                    // Borrar triggers para dejar de registrar cambios en la tabla
                    String tablaCancelada = modelRep.get(i).toString();
                    borrarTrigger(tablaCancelada, "InsertTriggerBitacora");
                    borrarTrigger(tablaCancelada, "UpdateTriggerBitacora");
                    borrarTrigger(tablaCancelada, "DeleteTriggerBitacora");
                    
                    // Establecer todos los 'boolean replicado = true' en la bitacoraOrigen
                    // 'where tabla = tablaCancelada' para descartar la replicacion de los cambios
                    Statement stmt = connPostgreSQL.createStatement();
                    String query = "UPDATE bitacoraOrigen " +
                                    "SET replicado = true" +
                                    "WHERE tabla = '" + tablaCancelada + "';";
                    stmt.executeUpdate(query);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(FrameConexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            // Descartar cambios en GUI
            cargarListas();
            
        }
    }//GEN-LAST:event_btnCancelarRepActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        try {
            // Cerrar las conexión a Oracle
            if (connOracle != null)
                if (!connOracle.isClosed())
                    connOracle.close();
            // Cerrar las conexión a PostgreSQL
            if (connPostgreSQL != null)
                if (!connPostgreSQL.isClosed())
                    connPostgreSQL.close();
            // Cerrar el programa
            System.exit(0);
        } catch (SQLException ex) {
            Logger.getLogger(FrameConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    
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
    
    public void crearTriggerInsert(String tablaReplicar) {
        try {
            Statement stmt = connPostgreSQL.createStatement();
            // Obtener los nombres de las columnas de la tabla y guardarlas en un ArrayList
            String queryColumnas = "SELECT column_name FROM information_schema.columns WHERE table_name = '" + tablaReplicar + "' ORDER BY ordinal_position";
            ResultSet columnResultSet = stmt.executeQuery(queryColumnas);
            ArrayList<String> columnas = new ArrayList();

            while (columnResultSet.next()) {
                columnas.add(columnResultSet.getString("column_name"));
            }

            stmt = connPostgreSQL.createStatement();

            // Delimitar los nombres de las columnas con comas
            String columnasDelim = "(" + String.join(", ", columnas) + ")";

            // Inserción del nuevo registro en la tabla bitacoraOrigen
            String insertTriggerQuery = "CREATE OR REPLACE FUNCTION insertar_bitacora() RETURNS TRIGGER AS $$ " +
                    "DECLARE " +
                    "valores TEXT; " +
                    "BEGIN " +
                    "valores := '(' || ";

            // Obtener los valores de la inserción más reciente en la tabla
            for (int i = 0; i < columnas.size()-1; i++) {
                insertTriggerQuery += "NEW." + columnas.get(i) + "::text || ', ' || ";
            }
            insertTriggerQuery += "NEW." + columnas.get(columnas.size()-1) + "::text || ')'; " +
                    // Agregar registro
                    "INSERT INTO bitacoraOrigen (operacion, tabla, columna, nuevo_valor, fecha_hora, replicado) " +
                    "VALUES ( " +
                    "'INSERT INTO ', " +
                    "'" + tablaReplicar + "', " +
                    "'" + columnasDelim + "', " +
                    "valores, " +
                    "CURRENT_TIMESTAMP, " +
                    "FALSE); " +
                    "RETURN NEW; " +
                    "END; " +
                    "$$ LANGUAGE plpgsql;";
            stmt.execute(insertTriggerQuery);

            connPostgreSQL.createStatement();
            
            // Borrar el trigger si es que ya existe para evitar un exception
            borrarTrigger(tablaReplicar, "InsertTriggerBitacora");
            
            // Crear el trigger de insert
            String createTriggerQuery = "CREATE TRIGGER InsertTriggerBitacora " +
                    "AFTER INSERT ON " + tablaReplicar + " " +
                    "FOR EACH ROW " +
                    "EXECUTE FUNCTION insertar_bitacora();";
            stmt.execute(createTriggerQuery);
            System.out.println("trigger insert creado");
            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(FrameConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearTriggerUpdate(String tablaReplicar) {
        try {
            Statement stmt = connPostgreSQL.createStatement();
            // Obtener los nombres de las columnas de la tabla y guardarlas en un ArrayList
            String queryColumnas = "SELECT column_name FROM information_schema.columns WHERE table_name = '" + tablaReplicar + "' ORDER BY ordinal_position";
            ResultSet columnResultSet = stmt.executeQuery(queryColumnas);
            ArrayList<String> columnas = new ArrayList();

            while (columnResultSet.next()) {
                columnas.add(columnResultSet.getString("column_name"));
            }

            stmt = connPostgreSQL.createStatement();

            // Delimitar los nombres de las columnas con comas
            String columnasDelim = "(" + String.join(", ", columnas) + ")";
                
            // Inserción del nuevo registro en la tabla bitacoraOrigen
            String updateTriggerQuery = "CREATE OR REPLACE FUNCTION actualizar_bitacora() RETURNS TRIGGER AS $$ " +
                    "DECLARE " +
                    "valores TEXT; " +
                    "BEGIN " +
                    "valores := '(' || ";

            // Obtener los valores de la última actualización en la tabla
            for (int i = 0; i < columnas.size() - 1; i++) {
                updateTriggerQuery += "NEW." + columnas.get(i) + "::text || ', ' || ";
            }
            updateTriggerQuery += "NEW." + columnas.get(columnas.size() - 1) + "::text || ')'; " +
                    // Agregar registro
                    "INSERT INTO bitacoraOrigen (operacion, tabla, columna, nuevo_valor, fecha_hora, replicado) " +
                    "VALUES (" +
                    "'UPDATE ', " +
                    "'" + tablaReplicar + "', " +
                    "'" + columnasDelim + "', " +
                    "valores, " +
                    "CURRENT_TIMESTAMP, " +
                    "FALSE); " +
                    "RETURN NEW; " +
                    "END; " +
                    "$$ LANGUAGE plpgsql;";
            stmt.execute(updateTriggerQuery);

            connPostgreSQL.createStatement();

            // Borrar el trigger si es que ya existe para evitar un exception
            borrarTrigger(tablaReplicar, "");
            
            // Crear el trigger de update
            String createTriggerQuery = "CREATE TRIGGER UpdateTriggerBitacora " +
                    "AFTER UPDATE ON " + tablaReplicar + " " +
                    "FOR EACH ROW " +
                    "EXECUTE FUNCTION actualizar_bitacora();";
            stmt.execute(createTriggerQuery);
            System.out.println("trigger update creado");
            
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(FrameConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearTriggerDelete(String tablaReplicar) {
        Statement stmt;
        try {
            stmt = connPostgreSQL.createStatement();

            // Crear el query para el trigger de delete
            String deleteTriggerQuery = "CREATE OR REPLACE FUNCTION borrar_bitacora() RETURNS TRIGGER AS $$ " +
                    "BEGIN " +
                    "INSERT INTO bitacoraOrigen (operacion, tabla, columna, nuevo_valor, fecha_hora, replicado) " +
                    "VALUES ( " +
                    "'DELETE FROM ', " +
                    "'" + tablaReplicar + "', " +
                    "'', " +
                    "'', " +
                    "CURRENT_TIMESTAMP, " +
                    "FALSE); " +
                    "RETURN OLD; " +
                    "END; " +
                    "$$ LANGUAGE plpgsql;";

            stmt.execute(deleteTriggerQuery);

            // Borrar el trigger si es que ya existe para evitar un exception
            borrarTrigger(tablaReplicar, "DeleteTriggerBitacora");
            
            // Crear el trigger de delete para la tabla
            String createTriggerQuery = "CREATE TRIGGER DeleteTriggerBitacora " +
                    "AFTER DELETE ON " + tablaReplicar + " " +
                    "FOR EACH ROW " +
                    "EXECUTE FUNCTION borrar_bitacora();";
            stmt.execute(createTriggerQuery);
            System.out.println("trigger delete creado");

            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(FrameConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FrameReplicacion;
    private javax.swing.JButton btnCancelarRep;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarRep;
    private javax.swing.JButton btnNoRep;
    private javax.swing.JButton btnProbarConnOracle;
    private javax.swing.JButton btnProbarConnPostgres;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRep;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
