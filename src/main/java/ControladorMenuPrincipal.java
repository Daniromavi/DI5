
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorMenuPrincipal implements ActionListener {
    public static VistaMenuprincipal vistaMenu;

    public ControladorMenuPrincipal(VistaMenuprincipal vistaMenu) {
        ControladorMenuPrincipal.vistaMenu = vistaMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Acciones específicas para los botones
    	if (e.getActionCommand().equals("AltaArticulos")) {
    		VistaAltaArticulos vistaArticulo = new VistaAltaArticulos();
    		vistaArticulo.setVisible(true);
    		vistaMenu.setVisible(false);
    	}
    	if (e.getActionCommand().equals("BajaArticulos")) {
    		VistaEliminarArticulos vistaBaja = new VistaEliminarArticulos();
    		vistaBaja.setVisible(true);
    		vistaMenu.setVisible(false);
    	}
        if (e.getActionCommand().equals("ListadoArticulos")) {
            VistaListadoArticulos vistaListadoA = new VistaListadoArticulos();
            vistaListadoA.setVisible(true);
            vistaMenu.setVisible(false);
        }
        if (e.getActionCommand().equals("ModificarArticulos")) {
            VistaModificarArticulos vistaModificar = new VistaModificarArticulos();
            vistaModificar.setVisible(true);
            vistaMenu.setVisible(false);
        }  
     	if (e.getActionCommand().equals("AltaTickets")) {
    		VistaAltaTickets vistaTickets = new VistaAltaTickets();
    		vistaTickets.setVisible(true);
    		vistaMenu.setVisible(false);
    	}
        if (e.getActionCommand().equals("ListadoTickets")) {
            VistaListadoTickets vistaListadoT = new VistaListadoTickets();
            vistaListadoT.setVisible(true);
            vistaMenu.setVisible(false);
        }
    }
}


