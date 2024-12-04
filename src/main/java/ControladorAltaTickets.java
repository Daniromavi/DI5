import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorAltaTickets implements ActionListener {

	private VistaAltaTickets vista;
	private Conexion conexion;

	public ControladorAltaTickets(VistaAltaTickets vista) {
		this.vista = vista;
		this.conexion = new Conexion();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("VolverAltaTickets")) {
			VistaMenuprincipal vistaMenu = new VistaMenuprincipal();
			vistaMenu.setVisible(true);
			vista.setVisible(false);
		}
		if (e.getActionCommand().equals("CrearTicket")) {
			List<Integer> idsSeleccionados = vista.getIdsSeleccionados(); // Obtiene los IDs seleccionados de la lista
			String fecha = vista.getFecha(); // Obtiene la fecha del ticket

			if (idsSeleccionados.isEmpty()) {
				System.out.println("No se ha seleccionado ningún artículo.");
				return;
			}

			if (fecha == null || fecha.trim().isEmpty()) {
				System.out.println("La descripción del ticket no puede estar vacía.");
				return;
			}

			try {
				Conexion.CrearTicket(idsSeleccionados, fecha); // Llama al método que inserta el ticket en la base de
																// datos
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("Error al crear el ticket.");
			}
		}
	}
}
