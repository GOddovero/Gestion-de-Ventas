package clasesInterfaz;

import clasesPrimarias.iNewCliente;


@SuppressWarnings("serial")
public class abrirVentanaNewClient extends javax.swing.JFrame {
    public abrirVentanaNewClient(){
        
        new iNewCliente().setVisible(true);
    }
}
