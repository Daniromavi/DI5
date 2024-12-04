
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAltaArticulos implements ActionListener {
	private VistaAltaArticulos vistaAltaArticulos;
	Conexion Conexion = new Conexion();

	public ControladorAltaArticulos(VistaAltaArticulos vistaAltaArticulo) {
		this.vistaAltaArticulos = vistaAltaArticulo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getActionCommand().equals("CrearArticulo")) {
	        String descripcion = vistaAltaArticulos.getDescripcion();
	        double precio = vistaAltaArticulos.getPrecio();
	        int cantidad = vistaAltaArticulos.gettxtCantidad();
	        Conexion.CrearArticulo(descripcion, precio, cantidad);
	        javax.swing.JOptionPane.showMessageDialog(
	                vistaAltaArticulos,
	                "Se ha creado un nuevo artículo:\n" +
	                "Descripción: " + descripcion + "\n" +
	                "Precio: " + precio + "\n" +
	                "Cantidad: " + cantidad,
	                "Artículo Creado",
	                javax.swing.JOptionPane.INFORMATION_MESSAGE		
	            );
	        }  
	    
	
		if (e.getActionCommand().equals("VolverAltaArticulo")) {
            vistaAltaArticulos.setVisible(false);
            ControladorMenuPrincipal.vistaMenu.setVisible(true);
		}
	}

}
