package clasesPrimarias;

import java.sql.*;
import java.util.Vector;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class iModCliente extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	Connection con;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pst;
	int q;
	int i;

        
	public void actualizarTabla(){
			
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/clientesllaves","root","");
			stmt = con.createStatement();
            pst = con.prepareStatement("SELECT * FROM clientes ORDER BY DNI ASC");
			rs = pst.executeQuery();
                        
                        ResultSetMetaData stData = rs.getMetaData();
                        q = stData.getColumnCount();
                        
                        DefaultTableModel modelo = (DefaultTableModel)tablaClientes.getModel();
                            modelo.setRowCount(0);
			while(rs.next()) {
				@SuppressWarnings("rawtypes")
				Vector<Comparable> datoColumna = new Vector<Comparable>();
                            for(i = 1;i <= q; i++){
                            datoColumna.add(rs.getString("DNI"));
                            datoColumna.add(rs.getString("nombre"));
                            datoColumna.add(rs.getString("apellido"));
                            datoColumna.add(rs.getString("direccion"));
                            datoColumna.add(rs.getString("telefono"));
			 }
              modelo.addRow(datoColumna);
            }
			tablaClientes.setModel(modelo);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	};
	public void borrarTabla() {
		DefaultTableModel modelo = (DefaultTableModel)tablaClientes.getModel();
		for( int i = modelo.getRowCount() - 1; i >= 0; i-- )
		{
		    modelo.removeRow(i);
		}
	}


    public iModCliente() {
    	this.setResizable(false);
    	initComponents();
    	
    	try{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (ClassNotFoundException ex) {
    		Logger.getLogger(iModCliente.class.getName()).log(Level.SEVERE, null, ex);
    		
    	}
    	actualizarTabla();
    	   	
    }
    @SuppressWarnings({ "unchecked", "serial", })
    
    private void initComponents() {

        botonSalir = new javax.swing.JButton();
        botonGuardarC = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonBorrarC = new javax.swing.JButton();
        botonBuscarC = new java.awt.Button();
        ingresaDNI = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        textTelefono = new javax.swing.JTextField();
        textDireccion = new javax.swing.JTextField();
        textApellido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        botonActualizarT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 18));
        botonSalir.setText("←");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 58, -1, -1));

        botonGuardarC.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        botonGuardarC.setText("Guardar");
        botonGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarCActionPerformed(evt);
            }
        });
        getContentPane().add(botonGuardarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 174, -1));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setText("MODIFICAR CLIENTES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 7, -1, -1));

        botonBorrarC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonBorrarC.setText("Borrar Cliente");
        botonBorrarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarCActionPerformed(evt);
            }
        });

        getContentPane().add(botonBorrarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 96, 174, -1));

        botonBuscarC.setLabel("Buscar Cliente");
        botonBuscarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarCActionPerformed(evt);
            }
        });
        getContentPane().add(botonBuscarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 65, 129, -1));

        ingresaDNI.setText("Ingresa DNI");
        ingresaDNI.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ingresaDNI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresaDNIMouseClicked(evt);
            }
        });
        getContentPane().add(ingresaDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 63, 171, -1));
        getContentPane().add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 96, 174, -1));
        getContentPane().add(textTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 216, 174, -1));
        getContentPane().add(textDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 176, 174, -1));

        textApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textApellidoActionPerformed(evt);
            }
        });
        getContentPane().add(textApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 136, 174, -1));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombres", "Apellido", "Direccion", "Telefono"
            }
        ) {
            
			@SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            @SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        botonActualizarT.setText("Actualizar");
        botonActualizarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarTActionPerformed(evt);
            }
        });
        getContentPane().add(botonActualizarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, -1));

        pack();
    }

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new Main().setVisible(true);
    }

    private void botonBorrarCActionPerformed(java.awt.event.ActionEvent evt) {
    	try{
    		stmt = con.createStatement();
    		stmt.executeUpdate("DELETE FROM clientes WHERE DNI = '"+ ingresaDNI.getText()+"'");

    		JOptionPane.showMessageDialog(null,"Se borro con exito");
    		borrarTabla();
    		actualizarTabla();

    	}catch(SQLException e){
    		JOptionPane.showMessageDialog(null,"No se elimino");
    	}
    }

    public void botonBuscarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarCActionPerformed
    	
    		int seleccion = tablaClientes.getSelectedRow();
            if(seleccion >= 0) {
            	

            	String dato=String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(),0));
            	System.out.println(dato);
            	try {
            		DefaultTableModel modelo = (DefaultTableModel)tablaClientes.getModel();
            		stmt = con.createStatement();
            		rs = stmt.executeQuery("SELECT * FROM clientes WHERE DNI = "+dato+"");
            		while(rs.next()) {
            			String[] fila = {rs.getString("DNI"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono")};
    				
            			modelo.addRow(fila);
            			ingresaDNI.setText(fila[0]);
            			textNombre.setText(fila[1]);
            			textApellido.setText(fila[2]);
            			textDireccion.setText(fila[3]);
            			textTelefono.setText(fila[4]);

    			}

    			tablaClientes.setModel(modelo);
    			actualizarTabla();
    			
            } catch (SQLException e) {
    			// 
            	JOptionPane.showMessageDialog(null,"DNI invalido");
    			e.printStackTrace();
    		}
            }else {
            	try {
            		DefaultTableModel modelo = (DefaultTableModel)tablaClientes.getModel();
            		stmt = con.createStatement();
            		rs = stmt.executeQuery("SELECT * FROM clientes WHERE DNI = "+ingresaDNI.getText()+"");
            		while(rs.next()) {
            			String[] fila = {rs.getString("DNI"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono")};
    				
            			modelo.addRow(fila);
            			textNombre.setText(fila[1]);
            			textApellido.setText(fila[2]);
            			textDireccion.setText(fila[3]);
            			textTelefono.setText(fila[4]);

    			}

    			tablaClientes.setModel(modelo);
    			actualizarTabla();
    			
            } catch (SQLException e) {
    			// 
            	JOptionPane.showMessageDialog(null,"DNI invalido");
    			e.printStackTrace();
    		}
            
        }
            }
    		

    private void formFocusGained(java.awt.event.FocusEvent evt) {
        
    }

    private void textApellidoActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    private void ingresaDNIMouseClicked(java.awt.event.MouseEvent evt) {
        ingresaDNI.setText("");
    }

    private void botonActualizarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarTActionPerformed
        borrarTabla();
    	actualizarTabla();
    }//GEN-LAST:event_botonActualizarTActionPerformed

    @SuppressWarnings("unused")
	private void botonGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarCActionPerformed

    	try {
    		String DNISeleccionado = ingresaDNI.getText();
    		String cambiarNombre = "UPDATE clientes SET nombre = '"+textNombre.getText()+"' WHERE DNI = '"+DNISeleccionado+"'";
    		stmt = con.prepareStatement(cambiarNombre);
    		
			int rs = stmt.executeUpdate(cambiarNombre);
    		
    		String cambiarApellido = "UPDATE clientes SET apellido = '"+textApellido.getText()+"' WHERE DNI = '"+DNISeleccionado+"'";
    		stmt = con.prepareStatement(cambiarApellido);
    		int rs1 = stmt.executeUpdate(cambiarApellido);
    		
    		String cambiarDireccion = "UPDATE clientes SET direccion = '"+textDireccion.getText()+"' WHERE DNI = '"+DNISeleccionado+"'";
    		stmt = con.prepareStatement(cambiarDireccion);
    		int rs2 = stmt.executeUpdate(cambiarDireccion);
    		
    		String cambiarTelefono = "UPDATE clientes SET telefono = '"+textTelefono.getText()+"' WHERE DNI = '"+DNISeleccionado+"'";
    		stmt = con.prepareStatement(cambiarTelefono);
    		int rs3 = stmt.executeUpdate(cambiarTelefono);
    		
    		actualizarTabla();
    		ingresaDNI.setText("");
    		textNombre.setText("");
    		textApellido.setText("");
    		textDireccion.setText("");
    		textTelefono.setText("");
        } catch (SQLException e) {
			
        	JOptionPane.showMessageDialog(null,"DNI invalido");
			e.printStackTrace();

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
            java.util.logging.Logger.getLogger(iModCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(iModCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(iModCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(iModCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new iModCliente().setVisible(true);
            }
        });
    }
    
    private javax.swing.JButton botonActualizarT;
    private javax.swing.JButton botonBorrarC;
    private java.awt.Button botonBuscarC;
    private javax.swing.JButton botonGuardarC;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField ingresaDNI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTelefono;
    

}
