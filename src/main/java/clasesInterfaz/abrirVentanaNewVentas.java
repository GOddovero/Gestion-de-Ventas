
package clasesInterfaz;

import clasesPrimarias.iNewVenta;


@SuppressWarnings("serial")
public class abrirVentanaNewVentas extends javax.swing.JFrame {
    public abrirVentanaNewVentas(){
        
        new iNewVenta().setVisible(true);
    }
}
