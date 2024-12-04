import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEliminarArticulos implements ActionListener {

    private VistaEliminarArticulos vista;
    private Conexion conexion;

    // Constructor para inicializar la vista y la conexión
    public ControladorEliminarArticulos(VistaEliminarArticulos vista) {
        this.vista = vista;
        this.conexion = new Conexion(); // Crea una instancia de la clase Conexion
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Verifica si el botón presionado es el de "Eliminar"
        if (e.getActionCommand().equals("Eliminar")) {
            // Obtiene el artículo seleccionado en la vista
            String articuloSeleccionado = vista.getChoice().getSelectedItem();
            if (articuloSeleccionado != null) {
                // Extrae el ID del artículo (asumiendo que el formato es "idarticulo - descripcion")
                int idArticulo = Integer.parseInt(articuloSeleccionado.split(" - ")[0]);
                
                // Llama al método de Conexion para eliminar el artículo
                conexion.EliminarArticulo(idArticulo);

                // Recarga los artículos en la vista después de la eliminación
                vista.cargarArticulos();
            } else {
                System.out.println("Por favor, seleccione un artículo para eliminar.");
            }
        }
        if (e.getActionCommand().equals("Cancelar")){
        	VistaMenuprincipal vistaMenu = new VistaMenuprincipal();
        	vistaMenu.setVisible(true);
        	vista.setVisible(false);
        }
    }
}
