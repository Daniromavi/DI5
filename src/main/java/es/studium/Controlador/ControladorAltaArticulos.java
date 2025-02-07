package es.studium.Controlador;

import es.studium.Vista.VistaAltaArticulos;
import es.studium.Modelo.ModeloArticulos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAltaArticulos {
    private VistaAltaArticulos vista;
    private ModeloArticulos modelo;

    public ControladorAltaArticulos(VistaAltaArticulos vista, ModeloArticulos modelo) {
        this.vista = vista;
        this.modelo = modelo;

        // Action listeners
        vista.getBttnCancelarAltaArticulos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("holaa");
                vista.dispose(); // Esto cierra la ventana y libera los recursos
            }
        });

        vista.getBttnCrearAltaArticulos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = vista.getTxtDescripcion().getText();
                double precio = Double.parseDouble(vista.getTxtPrecio().getText());
                int cantidad = Integer.parseInt(vista.getTxtCantidad().getText());

                // Llamamos al método del modelo para insertar el artículo
                if (modelo.crearArticulo(descripcion, precio, cantidad)) {
                    System.out.println("Artículo creado correctamente");
                    vista.setVisible(false); // Cierra la ventana al crear el artículo
                } else {
                    System.out.println("Error al crear el artículo");
                }
            }
        });
    }
}
