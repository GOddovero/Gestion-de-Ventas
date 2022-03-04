package clasesInterfaz;

import clasesPrimarias.iModCliente;


@SuppressWarnings("serial")
public class abrirVentanaModCliente extends javax.swing.JFrame {
    public abrirVentanaModCliente(){
        
        new iModCliente().setVisible(true);
    }
}
