package es.studium.Controlador;

import es.studium.Modelo.ModeloTickets;
import es.studium.Vista.VistaGenerarInformeTickets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class ControladorGenerarInformeTickets {
    private VistaGenerarInformeTickets vistaGenerarInformeTickets;
    private ModeloTickets modeloTickets;

    public ControladorGenerarInformeTickets(VistaGenerarInformeTickets vistaGenerarInformeTickets, ModeloTickets modeloTickets) {
        this.vistaGenerarInformeTickets = vistaGenerarInformeTickets;
        this.modeloTickets = modeloTickets;

        vistaGenerarInformeTickets.getAceptarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(getClass().getClassLoader().getResource("informe.jasper"));

                String fechaDesde = vistaGenerarInformeTickets.getFechaDesde();
                String fechaHasta = vistaGenerarInformeTickets.getFechaHasta();

                // Verificar que las fechas no estén vacías
                if (!fechaDesde.isEmpty() && !fechaHasta.isEmpty()) {
                    try {
                        // Definir el formato de la fecha
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // Cambia el formato según necesites

                        // Convertir las cadenas de fecha a objetos Date
                        Date fechaDesdeDate = sdf.parse(fechaDesde);
                        Date fechaHastaDate = sdf.parse(fechaHasta);

                        // Llamar al método de generación de informe con las fechas convertidas
                        modeloTickets.generarInformeTickets(fechaDesdeDate, fechaHastaDate);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(vistaGenerarInformeTickets, "Error en el formato de la fecha.");
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(vistaGenerarInformeTickets, "Por favor, ingresa ambas fechas.");
                }
            }
        });
    }
}
