package clasesPrimarias;

import java.sql.*;
import java.util.logging.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class iNewCliente extends javax.swing.JFrame {

	Connection con;
	Integer DNI;
	String nombre = "";
	String apellido = "";
	String telefono = "";
	String direccion = "";
    public iNewCliente() {
        initComponents();
        
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(iNewCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void initComponents() {
    	this.setResizable(false);
    	
    	
    	
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ingresaDNI = new javax.swing.JTextField();
        ingresaNombre = new javax.swing.JTextField();
        ingresaApellido = new javax.swing.JTextField();
        ingresaTelefono = new javax.swing.JTextField();
        ingresaDireccion = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36));  
        jLabel1.setText("AÑADIR CLIENTES");

        jLabel6.setText("Ingresa dirección:");

        ingresaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresaNombreActionPerformed(evt);
            }
        });

        ingresaApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresaApellidoActionPerformed(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("Tahoma", 0, 36));  
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingresa documento:");

        jLabel3.setText("Ingresa nombre:");

        jLabel4.setText("Ingresa apellido:");

        jLabel5.setText("Ingresa telefono:");

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 18));  
        botonSalir.setText("←");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(113, 113, 113))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ingresaTelefono)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ingresaDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                        .addGap(224, 224, 224))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ingresaDNI, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ingresaNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ingresaApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ingresaDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonSalir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ingresaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(ingresaApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ingresaTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ingresaDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96))
        );

        pack();
    }
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new Main().setVisible(true);

    }

    private void ingresaNombreActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void ingresaApellidoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/clientesllaves","root","");
            DNI = (Integer.parseInt(ingresaDNI.getText()));
            if((DNI < 100000000) && (DNI > 10000000)) {
            	String datoDNI = "" + DNI;
          	   	Statement stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO clientes VALUES('"+datoDNI +"','"+ingresaNombre.getText()+"', '"+ingresaApellido.getText()+"', '"+ingresaDireccion.getText()+"', '"+ingresaTelefono.getText()+"')");
             
            }
            else if ((DNI < 10000000) && (DNI > 1000000)) {
        	   String datoDNI = "0"+ DNI;
        	   Statement stmt = con.createStatement();
               stmt.executeUpdate("INSERT INTO clientes VALUES('"+datoDNI +"','"+ingresaNombre.getText()+"', '"+ingresaApellido.getText()+"', '"+ingresaDireccion.getText()+"', '"+ingresaTelefono.getText()+"')");
           
           }else if ((DNI < 1000000) && (DNI > 100000)) {
        	   String datoDNI = "00"+ DNI;
        	   Statement stmt = con.createStatement();
               stmt.executeUpdate("INSERT INTO clientes VALUES('"+datoDNI +"','"+ingresaNombre.getText()+"', '"+ingresaApellido.getText()+"', '"+ingresaDireccion.getText()+"', '"+ingresaTelefono.getText()+"')");
           
           }else if ((DNI < 100000) && (DNI > 10000)) {
        	   String datoDNI = "000"+ DNI;
        	   Statement stmt = con.createStatement();
               stmt.executeUpdate("INSERT INTO clientes VALUES('"+datoDNI +"','"+ingresaNombre.getText()+"', '"+ingresaApellido.getText()+"', '"+ingresaDireccion.getText()+"', '"+ingresaTelefono.getText()+"')");
           
           }else if ((DNI < 10000) && (DNI > 1000)) {
        	   String datoDNI = "0000"+ DNI;
        	   Statement stmt = con.createStatement();
               stmt.executeUpdate("INSERT INTO clientes VALUES('"+datoDNI +"','"+ingresaNombre.getText()+"', '"+ingresaApellido.getText()+"', '"+ingresaDireccion.getText()+"', '"+ingresaTelefono.getText()+"')");
           
           }else if ((DNI < 1000) && (DNI > 100)) {
        	   String datoDNI = "00000"+ DNI;
        	   Statement stmt = con.createStatement();
               stmt.executeUpdate("INSERT INTO clientes VALUES('"+datoDNI +"','"+ingresaNombre.getText()+"', '"+ingresaApellido.getText()+"', '"+ingresaDireccion.getText()+"', '"+ingresaTelefono.getText()+"')");
           
           }else if ((DNI < 100) && (DNI > 10)) {
        	   String datoDNI = "000000"+ DNI;
        	   Statement stmt = con.createStatement();
               stmt.executeUpdate("INSERT INTO clientes VALUES('"+datoDNI +"','"+ingresaNombre.getText()+"', '"+ingresaApellido.getText()+"', '"+ingresaDireccion.getText()+"', '"+ingresaTelefono.getText()+"')");
           
           }else if ((DNI < 10) && (DNI > 1)) {
        	   String datoDNI = "0000000"+ DNI;
        	   System.out.println(datoDNI);
        	   Statement stmt = con.createStatement();
               stmt.executeUpdate("INSERT INTO clientes VALUES('"+datoDNI +"','"+ingresaNombre.getText()+"', '"+ingresaApellido.getText()+"', '"+ingresaDireccion.getText()+"', '"+ingresaTelefono.getText()+"')");
           
           }
            
            JOptionPane.showMessageDialog(null, "Se guardo con exito");
            ingresaDNI.setText("");
            ingresaNombre.setText("");
            ingresaApellido.setText("");
            ingresaTelefono.setText("");
            ingresaDireccion.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(iNewCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No anda MySQL");
        }
    }

    public static void main(String args[]) {
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(iNewCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(iNewCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(iNewCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(iNewCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new iNewCliente().setVisible(true);
            }
        });
    }
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField ingresaApellido;
    private javax.swing.JTextField ingresaDNI;
    private javax.swing.JTextField ingresaDireccion;
    private javax.swing.JTextField ingresaNombre;
    private javax.swing.JTextField ingresaTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;

}
