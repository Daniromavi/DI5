package es.studium.Vista;

import com.toedter.calendar.JDateChooser; // Importar JDateChooser
import javax.swing.*;
import java.awt.*;

public class VistaGenerarInformeTickets extends JFrame {
    private JDateChooser fechaDesdeChooser; // JDateChooser para la fecha desde
    private JDateChooser fechaHastaChooser; // JDateChooser para la fecha hasta
    private JButton aceptarButton;

    public VistaGenerarInformeTickets() {
        setTitle("Generar Informe de Tickets");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Configuración de JDateChooser
        fechaDesdeChooser = new JDateChooser();
        fechaHastaChooser = new JDateChooser();

        panel.add(new JLabel("Fecha Desde:"));
        panel.add(fechaDesdeChooser);

        panel.add(new JLabel("Fecha Hasta:"));
        panel.add(fechaHastaChooser);

        aceptarButton = new JButton("Aceptar");
        panel.add(aceptarButton);

        add(panel);

        setLocationRelativeTo(null); // Centrar la ventana
    }

    // Getters
    public String getFechaDesde() {
        // Convierte la fecha seleccionada a formato string (YYYY-MM-DD)
        if (fechaDesdeChooser.getDate() != null) {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(fechaDesdeChooser.getDate());
        }
        return null; // Si no se seleccionó una fecha
    }

    public String getFechaHasta() {
        if (fechaHastaChooser.getDate() != null) {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(fechaHastaChooser.getDate());
        }
        return null; // Si no se seleccionó una fecha
    }

    public JButton getAceptarButton() {
        return aceptarButton;
    }
}
