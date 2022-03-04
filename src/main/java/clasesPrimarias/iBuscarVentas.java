package clasesPrimarias;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class iBuscarVentas extends javax.swing.JFrame {

    /**
     * Creates new form iBuscarProductos
     */
    Connection con;
	Connection con2;
	Statement stmt;
	ResultSet rs;
	ResultSet rs2;
	PreparedStatement pst;
	int q;
	public void actualizarTabla(){
		
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/clientesllaves","root","");
			stmt = con.createStatement();
            pst = con.prepareStatement("SELECT * FROM ventas WHERE Pago = 'No' ORDER BY fechaVenta DESC;");
			rs = pst.executeQuery();
                        
                        ResultSetMetaData stData = rs.getMetaData();
                        q = stData.getColumnCount();
                        
                        DefaultTableModel modelo = (DefaultTableModel)listaVentas.getModel();
                            modelo.setRowCount(0);
			while(rs.next()) {
				@SuppressWarnings("rawtypes")
				Vector<Comparable> datoColumna = new Vector<Comparable>();
                            for(int i = 1;i <= q; i++){
                            datoColumna.add(rs.getString("codigoUnico"));
                            datoColumna.add(rs.getString("nombre"));
                            datoColumna.add(rs.getString("apellido"));
                            datoColumna.add(rs.getString("Total"));
                            datoColumna.add(rs.getString("fechaVenta"));
                            
			 }
              modelo.addRow(datoColumna);
            }
			listaVentas.setModel(modelo);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
    public iBuscarVentas() {
        initComponents();
        actualizarTabla();
        try{		
            con = DriverManager.getConnection("jdbc:mysql://localhost/clientesllaves","root","");
            stmt = con.createStatement();
            pst = con.prepareStatement("SELECT * FROM ventas WHERE Total > 0 ORDER BY fechaVenta ASC;");
			rs = pst.executeQuery();
                        
                        ResultSetMetaData stData = rs.getMetaData();
                        q = stData.getColumnCount();
                        listaClientes.removeAll();
			while(rs.next()) {
				String codigoUnico = rs.getString("codigoUnico");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
							
				listaClientes.addItem(codigoUnico +", "+ nombre +" "+ apellido);
			 }
                     		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
    }
    private void initComponents() {
    	this.setResizable(false);
    	
        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        botonSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        listaClientes = new javax.swing.JComboBox<>();
        buscarCliente = new javax.swing.JTextField();
        botonBuscarCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaVentas = new javax.swing.JTable();
        infoVentas = new javax.swing.JButton();
        botonSinAbonar = new javax.swing.JRadioButton();
        botonAbonado = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botonActualizarTabla = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); 
        jLabel1.setText("MODIFICAR CLIENTES");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        botonSalir.setText("←");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 36));  
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BUSCAR VENTAS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, -1));

        listaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaClientesActionPerformed(evt);
            }
        });
        getContentPane().add(listaClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 206, 30));

        buscarCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscarCliente.setText("Ingresa CodigoUnico");
        buscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarClienteMouseClicked(evt);
            }
        });
        buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(buscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 130, 30));

        botonBuscarCliente.setText("Buscar");
        botonBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(botonBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 80, 30));

        listaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo Unico", "Nombre", "Apellido", "Total", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listaVentas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 540, 190));

        infoVentas.setText("Informacion Venta");
        infoVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoVentasActionPerformed(evt);
            }
        });
        getContentPane().add(infoVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        buttonGroup1.add(botonSinAbonar);
        botonSinAbonar.setText("Ventas Sin Abonar");
        botonSinAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSinAbonarActionPerformed(evt);
            }
        });
        getContentPane().add(botonSinAbonar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, -1, -1));

        buttonGroup1.add(botonAbonado);
        botonAbonado.setSelected(true);
        botonAbonado.setText("Ventas Abonadas");
        botonAbonado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbonadoActionPerformed(evt);
            }
        });
        getContentPane().add(botonAbonado, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, -1, -1));

        jLabel3.setText("Seleccionar Lista");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 140, 90));

        botonActualizarTabla.setText("Actualizar");
        botonActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarTablaActionPerformed(evt);
            }
        });
        getContentPane().add(botonActualizarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 100, 30));

        pack();
    }

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        
    	this.setVisible(false);
        new Main().setVisible(true);
    }

    private void listaClientesActionPerformed(java.awt.event.ActionEvent evt) {
         }

    private void buscarClienteMouseClicked(java.awt.event.MouseEvent evt) {
            buscarCliente.setText("");
    }

    private void botonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String codigoUnico = buscarCliente.getText();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM ventas WHERE codigoUnico = '"+codigoUnico+"'");
            while(rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String clienteBuscado = (codigoUnico +", "+ nombre +" "+ apellido);
                listaClientes.setSelectedItem(clienteBuscado);
                
                stmt = con.createStatement();
                pst = con.prepareStatement("SELECT * FROM ventas WHERE codigoUnico = '"+codigoUnico+"';");
    			rs = pst.executeQuery();
                            
                            ResultSetMetaData stData = rs.getMetaData();
                            q = stData.getColumnCount();
                            
                            DefaultTableModel modelo = (DefaultTableModel)listaVentas.getModel();
                                modelo.setRowCount(0);
    			while(rs.next()) {
    				@SuppressWarnings("rawtypes")
    				Vector<Comparable> datoColumna = new Vector<Comparable>();
                                for(int i = 1;i <= q; i++){
                                datoColumna.add(rs.getString("codigoUnico"));
                                datoColumna.add(rs.getString("nombre"));
                                datoColumna.add(rs.getString("apellido"));
                                datoColumna.add(rs.getString("Total"));
                                datoColumna.add(rs.getString("fechaVenta"));
                                
    			 }
                  modelo.addRow(datoColumna);
                }
    			listaVentas.setModel(modelo);    
            }
        } catch (SQLException e) {

        }        
    }

    private void buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {
       
    }
    
    private void botonSinAbonarActionPerformed(java.awt.event.ActionEvent evt) {                                               
          actualizarTabla();
    }                                            

    private void botonAbonadoActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {
			
			stmt = con.createStatement();
            pst = con.prepareStatement("SELECT * FROM ventas WHERE Pago = 'Si' ORDER BY fechaVenta ASC;");
			rs = pst.executeQuery();
                        
                        ResultSetMetaData stData = rs.getMetaData();
                        q = stData.getColumnCount();
                        
                        DefaultTableModel modelo = (DefaultTableModel)listaVentas.getModel();
                            modelo.setRowCount(0);
			while(rs.next()) {
				@SuppressWarnings("rawtypes")
				Vector<Comparable> datoColumna = new Vector<Comparable>();
                            for(int i = 1;i <= q; i++){
                            datoColumna.add(rs.getString("codigoUnico"));
                            datoColumna.add(rs.getString("nombre"));
                            datoColumna.add(rs.getString("apellido"));
                            datoColumna.add(rs.getString("Total"));
                            datoColumna.add(rs.getString("fechaVenta"));
                            
			 }
              modelo.addRow(datoColumna);
            }
			listaVentas.setModel(modelo);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }                                              

    private void infoVentasActionPerformed(java.awt.event.ActionEvent evt) {
        int fila = listaVentas.getSelectedRow();
        if(fila >= 0) {
        	JOptionPane.showMessageDialog(null, "Fila Seleccionada");

        	String dato=String.valueOf(listaVentas.getValueAt(listaVentas.getSelectedRow(),0));
        	System.out.println(dato);
        }else {
        	JOptionPane.showMessageDialog(null, "Fila NO Seleccionada");
        }
    }

    private void botonActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {
               actualizarTabla();
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
            java.util.logging.Logger.getLogger(iBuscarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(iBuscarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(iBuscarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(iBuscarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new iBuscarVentas().setVisible(true);
            }
        });
    }
    private javax.swing.JRadioButton botonAbonado;
    private javax.swing.JButton botonActualizarTabla;
    private javax.swing.JButton botonBuscarCliente;
    private javax.swing.JButton botonSalir;
    private javax.swing.JRadioButton botonSinAbonar;
    private javax.swing.JTextField buscarCliente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton infoVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> listaClientes;
    private javax.swing.JTable listaVentas;
    // End of variables declaration//GEN-END:variables
}
