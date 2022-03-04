package clasesInterfaz;

import clasesPrimarias.iBuscarVentas;


@SuppressWarnings("serial")

public class abrirVentanaBuscarProductos extends javax.swing.JFrame {
        public abrirVentanaBuscarProductos(){
            new iBuscarVentas().setVisible(true);
    }
}
