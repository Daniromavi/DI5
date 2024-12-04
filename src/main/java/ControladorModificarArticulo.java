import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ControladorModificarArticulo implements ActionListener {

    private VistaModificarArticulos vistaModificarArticulos;
    private Conexion conexion;

    // Constructor que recibe la vista de modificación de artículos
    public ControladorModificarArticulo(VistaModificarArticulos vistaModificarArticulos) {
        this.vistaModificarArticulos = vistaModificarArticulos;
        this.conexion = new Conexion(); // Crea una instancia de la clase Conexion
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ModificarArticulo")) {
            // Obtener la instancia de VistaModificarArticulos y el ID seleccionado
            String idArticulo = vistaModificarArticulos.getSelectedArticuloId();
            System.out.println(idArticulo);
            
            if (idArticulo != null) {
                // Crear y mostrar una nueva instancia de VistaModificacionArticulo
                VistaModificacionArticulo vistaModificacion = new VistaModificacionArticulo(idArticulo);
                vistaModificacion.setVisible(true);
            } else {
                System.out.println("No se ha seleccionado un artículo.");
            }
        }

        if (e.getActionCommand().equals("VolverModificar")) {
            // Volver a la ventana de menú principal
            VistaMenuprincipal vistaMenu = new VistaMenuprincipal();
            vistaMenu.setVisible(true);
            vistaModificarArticulos.setVisible(false);
        }
    }
}


