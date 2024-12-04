import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorListadoTickets implements ActionListener {

	private VistaListadoTickets vista;
	private Conexion conexion;
	
	public ControladorListadoTickets(VistaListadoTickets vista) {
		this.vista = vista;
		this.conexion = new Conexion();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("VolverListado")) {
			VistaMenuprincipal vistaMenu = new VistaMenuprincipal();
        	vistaMenu.setVisible(true);
        	vista.setVisible(false);
		}
		if (e.getActionCommand().equals("PDF")) {
			
		}
	}
}

