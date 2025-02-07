package es.studium.Controlador;

import es.studium.Modelo.Articulo;
import es.studium.Modelo.ModeloArticulos;
import es.studium.Vista.VistaModificarArticulos;
import es.studium.Vista.VistaModificacionArticulo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

public class ControladorModificarArticulos {

    private VistaModificarArticulos vistaModificarArticulos;
    private ModeloArticulos modeloArticulos;

    public ControladorModificarArticulos(VistaModificarArticulos vistaModificarArticulos, ModeloArticulos modeloArticulos) {
        this.vistaModificarArticulos = vistaModificarArticulos;
        this.modeloArticulos = modeloArticulos;

        // Cargar los artículos en la lista de la vista
        cargarArticulos();

        // Acción para el botón de modificar
        vistaModificarArticulos.getBttnModificarArticulo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedArticulo = vistaModificarArticulos.getList().getSelectedValue();
                if (selectedArticulo != null) {
                    // Extraer el ID del artículo seleccionado (suponemos que es de la forma "id - descripción")
                    String[] parts = selectedArticulo.split(" - ");
                    int idArticulo = Integer.parseInt(parts[0]);

                    // Abrir la vista de modificación de artículo con el ID seleccionado
                    new VistaModificacionArticulo(idArticulo, modeloArticulos, vistaModificarArticulos).iniciarVista();
                    vistaModificarArticulos.setVisible(false);  // Cerrar la vista actual
                }
            }
        });

        // Acción para el botón de cancelar
        vistaModificarArticulos.getBttnCancelarModificarArticulo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaModificarArticulos.setVisible(false); // Cerrar la ventana de modificación
            }
        });
    }

    // Método para cargar los artículos en la lista
    public void cargarArticulos() {
        DefaultListModel<String> listModel = (DefaultListModel<String>) vistaModificarArticulos.getList().getModel();
        listModel.clear();
        
        for (Articulo articulo : modeloArticulos.obtenerArticulos()) {
            // Añadir a la lista en formato "id - descripción"
            listModel.addElement(articulo.getIdArticulo() + " - " + articulo.getDescripcion());
        }
    }
}
