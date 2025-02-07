package es.studium.Controlador;

import es.studium.Vista.VistaEliminarArticulos;
import es.studium.Modelo.ModeloArticulos;
import es.studium.Modelo.Articulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorBajaArticulos {
    private VistaEliminarArticulos vista;
    private ModeloArticulos modelo;

    public ControladorBajaArticulos(VistaEliminarArticulos vista, ModeloArticulos modelo) {
        this.vista = vista;
        this.modelo = modelo;

        // Cargar artículos en el choice
        cargarArticulos();

        // Action listener para el botón "Eliminar"
        vista.getBttnEliminarArticulo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el artículo seleccionado en el Choice
                String selectedItem = vista.getChoice().getSelectedItem();
                
                // Separar el ID y la descripción utilizando el guion
                String[] parts = selectedItem.split(" - ");
                
                // Convertir la parte del ID a entero
                int idArticulo = Integer.parseInt(parts[0]);  // Usamos el primer elemento del array, que es el ID
                
                // Eliminar artículo
                if (modelo.eliminarArticulo(idArticulo)) {
                    System.out.println("Artículo eliminado correctamente");
                    vista.dispose(); // Cerrar la ventana después de eliminar el artículo
                } else {
                    System.out.println("Error al eliminar el artículo");
                }
            }
        }); // Este es el cierre del primer ActionListener para "Eliminar"

        // Action listener para el botón "Cancelar"
        vista.getBttnCancelarEliminarArticulo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Operación de eliminación cancelada");
                vista.dispose(); // Cerrar la ventana si se cancela
            }
        });
    }

    // Método para cargar los artículos en el Choice de la vista
    private void cargarArticulos() {
        List<Articulo> articulos = modelo.obtenerArticulos();
        for (Articulo articulo : articulos) {
            vista.getChoice().add(articulo.getIdArticulo() + " - " + articulo.getDescripcion());
        }
    }
}
