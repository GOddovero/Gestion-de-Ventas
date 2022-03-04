package clasesPrimarias;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import clasesInterfaz.abrirVentanaNewVentas;



@SuppressWarnings("serial")
public class iNewVenta extends javax.swing.JFrame {

    public int CantidadDP = 0;
    public int CantidadYale = 0;
    public int CantidadAuto = 0;
    public int PrecioDP = 0;
    public int PrecioYale = 0;
    public int PrecioAuto = 0;
    
    
    public int PrecioFinal; 
    
	Connection con;
	Connection con2;
	Statement stmt;
	ResultSet rs;
	ResultSet rs2;
	PreparedStatement pst;
	int q;
	String vacio = "";

    
    public iNewVenta() {
        initComponents();
        this.setResizable(false);
        try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/clientesllaves","root","");
			stmt = con.createStatement();
            pst = con.prepareStatement("SELECT * FROM clientes");
			rs = pst.executeQuery();
                        ResultSetMetaData stData = rs.getMetaData();
                        q = stData.getColumnCount();
                        listaClientes.removeAll();
			while(rs.next()) {
				String DNI = rs.getString("DNI");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				listaClientes.addItem(DNI +", "+ nombre +" "+ apellido);
			 }
                     		
		} catch (SQLException e) {

			e.printStackTrace();
		}
        try {
			
			con2 = DriverManager.getConnection("jdbc:mysql://localhost/preciollaves","root","");
			stmt = con2.createStatement();
            pst = con2.prepareStatement("SELECT * FROM precio");
			rs = pst.executeQuery();
			while(rs.next()) {
				PrecioDP = rs.getInt("doblepaleta");
				PrecioYale = rs.getInt("yale");
				PrecioAuto = rs.getInt("auto");
							
				
			 }
                     		
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        restaDP = new javax.swing.JButton();
        contadorDP = new java.awt.Label();
        sumaDP = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        restaAuto = new javax.swing.JButton();
        contadorAuto = new java.awt.Label();
        sumaAuto = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        restaYale = new javax.swing.JButton();
        contadorYale = new java.awt.Label();
        sumaYale = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        valorTotal = new javax.swing.JLabel();
        finalizarVenta = new javax.swing.JButton();
        listaClientes = new javax.swing.JComboBox<>();
        buscarCliente = new javax.swing.JTextField();
        botonBuscarCliente = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NUEVA VENTA");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        restaDP.setFont(new java.awt.Font("Segoe UI", 1, 10));  
        restaDP.setText("-");
        restaDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaDPActionPerformed(evt);
            }
        });

        contadorDP.setFont(new java.awt.Font("Dialog", 1, 18));  
        contadorDP.setText("0");

        sumaDP.setFont(new java.awt.Font("Segoe UI", 1, 10));  
        sumaDP.setText("+");
        sumaDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumaDPActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18));  
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DOBLE");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18));  
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PALETA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(restaDP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contadorDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(sumaDP)
                .addContainerGap())
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(restaDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contadorDP, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sumaDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 18));  
        botonSalir.setText("←");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        restaAuto.setFont(new java.awt.Font("Segoe UI", 1, 10));  
        restaAuto.setText("-");
        restaAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaAutoActionPerformed(evt);
            }
        });

        contadorAuto.setFont(new java.awt.Font("Dialog", 1, 18));  
        contadorAuto.setText("0");

        sumaAuto.setFont(new java.awt.Font("Segoe UI", 1, 10));  
        sumaAuto.setText("+");
        sumaAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumaAutoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18));  
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AUTOMOVIL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(restaAuto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contadorAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sumaAuto)
                .addContainerGap())
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(restaAuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contadorAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sumaAuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        restaYale.setFont(new java.awt.Font("Segoe UI", 1, 10));  
        restaYale.setText("-");
        restaYale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaYaleActionPerformed(evt);
            }
        });

        contadorYale.setFont(new java.awt.Font("Dialog", 1, 18));  
        contadorYale.setText("0");

        sumaYale.setFont(new java.awt.Font("Segoe UI", 1, 10));  
        sumaYale.setText("+");
        sumaYale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumaYaleActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18));  
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("YALE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(restaYale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contadorYale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sumaYale)
                .addContainerGap())
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(restaYale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contadorYale, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sumaYale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        jLabel3.setText("Seleccionar Cliente");

        Total.setText("TOTAL: ");

        valorTotal.setFont(new java.awt.Font("Segoe UI", 1, 18));  
        valorTotal.setText("$000");
        valorTotal.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        finalizarVenta.setText("Finalizar\nVenta");
        finalizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarVentaActionPerformed(evt);
            }
        });

        listaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaClientesActionPerformed(evt);
            }
        });

        buscarCliente.setText("Ingresa DNI");
        buscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarClienteMouseClicked(evt);
            }
        });

        botonBuscarCliente.setText("Buscar");
        botonBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174)
                .addComponent(finalizarVenta)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscarCliente)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(botonSalir))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(listaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBuscarCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(finalizarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Total))
                .addContainerGap())
        );

        pack();
    }
    private void finalizarVentaActionPerformed(java.awt.event.ActionEvent evt) {	
    	String datoCULlave = "";
    	if((CantidadDP > CantidadYale) && (CantidadDP > CantidadAuto)){
    		datoCULlave = CantidadDP + "P";
    		System.out.println(datoCULlave);
     	}else if((CantidadYale > CantidadAuto) && (CantidadYale > CantidadDP)){
    		datoCULlave = CantidadYale + "Y";
    		System.out.println(datoCULlave);
    	}else if ((CantidadAuto > CantidadYale) && (CantidadAuto > CantidadDP)){
    		datoCULlave = CantidadAuto + "A";
    		System.out.println(datoCULlave);
    	}else if ((CantidadDP == CantidadYale) || (CantidadDP == CantidadAuto)){
    		datoCULlave = CantidadDP +"P";
			System.out.println(datoCULlave);
    	}else if (CantidadYale == CantidadAuto) {
    		datoCULlave = CantidadDP +"Y";
			System.out.println(datoCULlave);
    	}
    	PrecioFinal = (PrecioDP * CantidadDP) + (PrecioYale * CantidadYale) + (PrecioAuto * CantidadAuto);
    	try {
        	String datosCU = listaClientes.getSelectedItem().toString();
    		int cantidad1 = datosCU.length();
    		int cantidad2 = cantidad1 - 8;
    		String DNI = datosCU.substring(0, cantidad1 - cantidad2);

    		
    		stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM clientes WHERE DNI = "+DNI+"");
			while(rs.next()) {
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			
			char nombreCU = Character.toUpperCase(nombre.charAt(0));
			char apellidoCU = Character.toUpperCase(apellido.charAt(0));
			String codigoUnico = vacio + nombreCU + apellidoCU + datoCULlave;

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDateTime diaVenta = LocalDateTime.now();

			stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO ventas VALUES('"+codigoUnico+"','"+nombre+"', '"+apellido+"', '"+CantidadDP+"', '"+CantidadYale+"', '"+CantidadAuto+"', '"+PrecioFinal+"', '"+dtf.format(diaVenta)+"', 'No')");
            JOptionPane.showMessageDialog(null, "Venta Generada Correctamente");
            this.setVisible(false);
            new abrirVentanaNewVentas();
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {
    	this.setVisible(false);
        new Main().setVisible(true);
    }

    private void sumaDPActionPerformed(java.awt.event.ActionEvent evt) {
        CantidadDP++;
        
        contadorDP.setText(String.valueOf(CantidadDP));
        
        PrecioFinal = (PrecioDP * CantidadDP) + (PrecioYale * CantidadYale) + (PrecioAuto * CantidadAuto);
        
        valorTotal.setText("$" + String.valueOf(PrecioFinal));
      
    }

    private void restaDPActionPerformed(java.awt.event.ActionEvent evt) {
    	CantidadDP--;
        contadorDP.setText(String.valueOf(CantidadDP));
        if (CantidadDP == -1){
            CantidadDP=0;
            contadorDP.setText(String.valueOf(CantidadDP));
        }
        
        PrecioFinal = (PrecioDP * CantidadDP) - (PrecioYale * CantidadYale) - (PrecioAuto * CantidadAuto);        
        valorTotal.setText("$" + String.valueOf(Math.abs(PrecioFinal)));
    }
    private void restaYaleActionPerformed(java.awt.event.ActionEvent evt) {
        CantidadYale--;
        contadorYale.setText(String.valueOf(CantidadYale));
        if (CantidadYale == -1){
            CantidadYale=0;
            contadorYale.setText(String.valueOf(CantidadYale));
        }
        
        PrecioFinal = (PrecioDP * CantidadDP) - (PrecioYale * CantidadYale) - (PrecioAuto * CantidadAuto);
        
        valorTotal.setText("$" + String.valueOf(Math.abs(PrecioFinal)));
    }
    private void sumaYaleActionPerformed(java.awt.event.ActionEvent evt) {
    	CantidadYale++;
    	contadorYale.setText(String.valueOf(CantidadYale));
        
        PrecioFinal = PrecioDP * CantidadDP + PrecioYale * CantidadYale + PrecioAuto * CantidadAuto;
        valorTotal.setText("$" + String.valueOf(PrecioFinal));
    }
    private void restaAutoActionPerformed(java.awt.event.ActionEvent evt) {
    	CantidadAuto--;
        contadorAuto.setText(String.valueOf(CantidadAuto));
        if (CantidadAuto == -1){
            CantidadAuto=0;
            contadorAuto.setText(String.valueOf(CantidadAuto));
        }
        
        PrecioFinal = (PrecioDP * CantidadDP) - (PrecioYale * CantidadYale) - (PrecioAuto * CantidadAuto);        
        valorTotal.setText("$" + String.valueOf(Math.abs(PrecioFinal)));
    }
    private void sumaAutoActionPerformed(java.awt.event.ActionEvent evt) {
    	CantidadAuto++;
       contadorAuto.setText(String.valueOf(CantidadAuto));
        
        PrecioFinal = PrecioDP * CantidadDP + PrecioYale * CantidadYale + PrecioAuto * CantidadAuto;
        valorTotal.setText("$" + String.valueOf(PrecioFinal));
    }
    private void listaClientesActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void botonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
        	String dni = buscarCliente.getText();
        	stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM clientes WHERE DNI = "+dni+"");
			while(rs.next()) {
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			String clienteBuscado = dni +", "+ nombre +" "+ apellido;
			listaClientes.setSelectedItem(clienteBuscado);
			}
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null,"DNI invalido");
			
		}
    }

    private void buscarClienteMouseClicked(java.awt.event.MouseEvent evt) {
    	buscarCliente.setText("");
    }

    private void formMouseMoved(java.awt.event.MouseEvent evt) {
    	if(PrecioFinal > 0) {
        valorTotal.setText("$" + String.valueOf(Math.abs(PrecioFinal)));
    	}else {
    		valorTotal.setText("$000");
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
            java.util.logging.Logger.getLogger(iNewVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(iNewVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(iNewVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(iNewVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new iNewVenta().setVisible(true);
            }
        });
    }
    private javax.swing.JLabel Total;
    private javax.swing.JButton botonBuscarCliente;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField buscarCliente;
    private java.awt.Label contadorAuto;
    private java.awt.Label contadorDP;
    private java.awt.Label contadorYale;
    private javax.swing.JButton finalizarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> listaClientes;
    private javax.swing.JButton restaAuto;
    private javax.swing.JButton restaDP;
    private javax.swing.JButton restaYale;
    private javax.swing.JButton sumaAuto;
    private javax.swing.JButton sumaDP;
    private javax.swing.JButton sumaYale;
    private javax.swing.JLabel valorTotal;
}
