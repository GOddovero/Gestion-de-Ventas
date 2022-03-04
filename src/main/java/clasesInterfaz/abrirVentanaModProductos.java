package clasesInterfaz;

import clasesPrimarias.iModProductos;


@SuppressWarnings("serial")
public class abrirVentanaModProductos extends javax.swing.JFrame {
        public abrirVentanaModProductos(){
            new iModProductos().setVisible(true);
    }
}
