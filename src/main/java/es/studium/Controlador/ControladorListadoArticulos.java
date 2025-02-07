package es.studium.Controlador;

import es.studium.Vista.VistaListadoArticulos;
import es.studium.Modelo.ModeloArticulos;
import es.studium.Modelo.Articulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorListadoArticulos {
    private VistaListadoArticulos vista;
    private ModeloArticulos modelo;

    public ControladorListadoArticulos(VistaListadoArticulos vista, ModeloArticulos modelo) {
        this.vista = vista;
        this.modelo = modelo;

        // Cargar artículos en la vista
        cargarArticulos();

        // Action listener para el botón "Volver"
        vista.getbttnVolverMenuPrincipal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para volver al menú principal
                System.out.println("Volviendo al menú principal");
                vista.dispose(); // Cierra la ventana actual
            }
        });
    }

    // Método para cargar los artículos en la lista de la vista
    private void cargarArticulos() {
        List<Articulo> articulos = modelo.obtenerArticulos();
        for (Articulo articulo : articulos) {
            vista.getList().add(articulo.getIdArticulo() + " - " + articulo.getDescripcion());
        }
    }
}
