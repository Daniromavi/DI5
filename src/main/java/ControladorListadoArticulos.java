import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorListadoArticulos implements ActionListener {
	
	private VistaListadoArticulos vista;
	private Conexion conexion;

	public ControladorListadoArticulos(VistaListadoArticulos vista) {
		this.vista = vista;
		this.conexion = new Conexion();
	}
	 @Override
	    public void actionPerformed(ActionEvent e) {
		 if (e.getActionCommand().equals("VolverListado")){
			 VistaMenuprincipal vistaMenu = new VistaMenuprincipal();
			 vistaMenu.setVisible(true);
			 vista.setVisible(false);
		 }
	 }
}
