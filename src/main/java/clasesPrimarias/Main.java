package clasesPrimarias;


import clasesInterfaz.abrirVentanaModProductos;
import clasesInterfaz.abrirVentanaNewVentas;
import clasesInterfaz.abrirVentanaModCliente;
import clasesInterfaz.abrirVentanaNewClient;
import clasesInterfaz.abrirVentanaBuscarProductos;



@SuppressWarnings("serial")
public class Main extends javax.swing.JFrame {

    
        
    
    
    public Main() {
        initComponents();
        this.setResizable(false);
        
    }

    private void initComponents() {

        botonSalir = new javax.swing.JButton();
        Titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botonNewCliente = new javax.swing.JButton();
        botonNewVenta = new javax.swing.JButton();
        botonModCliente = new javax.swing.JButton();
        botonModProduct = new javax.swing.JButton();
        botonFindProduct = new javax.swing.JButton();
        botonSalir1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        botonSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        botonSalir.setText("←");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Titulo.setFont(new java.awt.Font("Calibri", 0, 48)); 
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("GESTION DE VENTAS");

        botonNewCliente.setText("Añadir Cliente");
        botonNewCliente.setMaximumSize(new java.awt.Dimension(111, 23));
        botonNewCliente.setMinimumSize(new java.awt.Dimension(111, 23));
        botonNewCliente.setPreferredSize(new java.awt.Dimension(111, 23));
        botonNewCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNewClienteActionPerformed(evt);
            }
        });

        botonNewVenta.setText("Nueva Venta");
        botonNewVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNewVentaActionPerformed(evt);
            }
        });

        botonModCliente.setText("Modificar Cliente");
        botonModCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModClienteActionPerformed(evt);
            }
        });

        botonModProduct.setText("Modificar Productos");
        botonModProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModProductActionPerformed(evt);
            }
        });

        botonFindProduct.setText("Buscar Ventas");
        botonFindProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFindProductActionPerformed(evt);
            }
        });

        botonSalir1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        botonSalir1.setText("←");
        botonSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalir1ActionPerformed(evt);
            }
        });

        jLabel1.setText("SALIR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 303, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(botonSalir1))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botonFindProduct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonModProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonNewCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonModCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(botonNewVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(40, Short.MAX_VALUE))))
            .addComponent(Titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalir1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonNewCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonModCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonModProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                    .addComponent(botonNewVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonFindProduct)
                .addGap(19, 19, 19))
        );

        pack();
    }

    private void botonNewClienteActionPerformed(java.awt.event.ActionEvent evt) {
       new abrirVentanaNewClient();
       this.setVisible(false);        
    }

    private void botonNewVentaActionPerformed(java.awt.event.ActionEvent evt) {
        new abrirVentanaNewVentas();
        this.setVisible(false);
    }

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new Main().setVisible(true);
    }

    private void botonSalir1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private void botonModClienteActionPerformed(java.awt.event.ActionEvent evt) {
        new abrirVentanaModCliente();
        this.setVisible(false);
    }

    private void botonModProductActionPerformed(java.awt.event.ActionEvent evt) {
        new abrirVentanaModProductos();
        this.setVisible(false);
    }

    private void botonFindProductActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	new abrirVentanaBuscarProductos();
    	this.setVisible(false);
        
    }

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });

    }

    private javax.swing.JLabel Titulo;
    private javax.swing.JButton botonFindProduct;
    private javax.swing.JButton botonModCliente;
    private javax.swing.JButton botonModProduct;
    private javax.swing.JButton botonNewCliente;
    private javax.swing.JButton botonNewVenta;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonSalir1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
}
