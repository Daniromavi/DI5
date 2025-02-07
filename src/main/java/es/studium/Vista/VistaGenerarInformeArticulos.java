package es.studium.Vista;

import javax.swing.*;
import java.awt.*;

public class VistaGenerarInformeArticulos extends JFrame {
    private static final long serialVersionUID = 1L;
    private JButton btnGenerarInforme;
    private JButton btnCancelar;

    public VistaGenerarInformeArticulos() {
        setTitle("Generar Informe de Artículos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Generar Informe de Artículos", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        btnGenerarInforme = new JButton("Generar Informe");
        btnCancelar = new JButton("Cancelar");

        panelBotones.add(btnGenerarInforme);
        panelBotones.add(btnCancelar);

        add(panelBotones, BorderLayout.CENTER);
    }

    public JButton getBtnGenerarInforme() {
        return btnGenerarInforme;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
