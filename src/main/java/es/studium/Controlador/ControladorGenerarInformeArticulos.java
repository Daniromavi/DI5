package es.studium.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.studium.Modelo.ModeloArticulos;
import es.studium.Vista.VistaGenerarInformeArticulos;

public class ControladorGenerarInformeArticulos implements ActionListener {

    private VistaGenerarInformeArticulos vista;
    private ModeloArticulos modelo;

    public ControladorGenerarInformeArticulos(VistaGenerarInformeArticulos vista, ModeloArticulos modelo) {
        this.vista = vista;
        this.modelo = modelo;

        // Asigna el listener al botón de generar informe
        this.vista.getBtnGenerarInforme().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        modelo.generarInformeArticulos(); // Llamar al método para generar el informe
    }
}
