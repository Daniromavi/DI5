import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ControladorModificacionArticulo implements ActionListener {

    private VistaModificacionArticulo vistaModificacion;
    private Conexion conexion;

    public ControladorModificacionArticulo(VistaModificacionArticulo vistaModificacion) {
        this.vistaModificacion = vistaModificacion;
        this.conexion = new Conexion(); // Crea una instancia de la clase Conexion
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ModificacionArticulo")) {
            // Obtener el ID del artículo y los valores de los campos de la vista
            String idArticuloStr = vistaModificacion.getIdArticulo();
            String descripcion = vistaModificacion.getTxtDescripcion();
            String precioStr = vistaModificacion.getTxtPrecio();
            String cantidadStr = vistaModificacion.getTxtCantidad();

            System.out.println("ID artículo obtenido: " + idArticuloStr);
            System.out.println("Precio obtenido: " + precioStr);
            System.out.println("Cantidad obtenida: " + cantidadStr);

            try {
                // Validar y convertir los valores de los campos
                int idArticulo = Integer.parseInt(idArticuloStr);
                double precio = Double.parseDouble(precioStr);
                int cantidad = Integer.parseInt(cantidadStr);

                // Llamar al método de la clase Conexion para modificar el artículo
                conexion.modificarArticulo(idArticulo, descripcion, precio, cantidad);

                // Mostrar un mensaje de éxito o realizar acciones adicionales
                System.out.println("El artículo ha sido modificado.");

            } catch (NumberFormatException ex) {
                System.err.println("Error en el formato de los datos: " + ex.getMessage());
            } catch (SQLException ex) {
                System.err.println("Error al modificar el artículo: " + ex.getMessage());
            }
        }

        if (e.getActionCommand().equals("VolverModificar")) {
            // Volver a la ventana de menú principal o realizar otra acción
            VistaMenuprincipal vistaMenu = new VistaMenuprincipal();
            vistaMenu.setVisible(true);
            vistaModificacion.setVisible(false);
        }
    }
}

