package es.studium.Vista;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Choice;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaEliminarArticulos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Choice choice;
    private Button bttnEliminarArticulo;
    private Button bttnCancelarEliminarArticulo;

    public VistaEliminarArticulos() {
        setTitle("Eliminar Articulos");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 386, 137);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 68, 90, 68, 0, 0};
        gbl_contentPane.rowHeights = new int[]{25, 25, 25, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);
        
        JLabel lblSeleccionarArticulos = new JLabel("Seleccionar Articulos");
        GridBagConstraints gbc_lblSeleccionarArticulos = new GridBagConstraints();
        gbc_lblSeleccionarArticulos.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccionarArticulos.gridx = 2;
        gbc_lblSeleccionarArticulos.gridy = 0;
        contentPane.add(lblSeleccionarArticulos, gbc_lblSeleccionarArticulos);
        
        choice = new Choice();
        GridBagConstraints gbc_choice = new GridBagConstraints();
        gbc_choice.fill = GridBagConstraints.BOTH;
        gbc_choice.insets = new Insets(0, 0, 5, 5);
        gbc_choice.gridx = 2;
        gbc_choice.gridy = 1;
        contentPane.add(choice, gbc_choice);

        bttnCancelarEliminarArticulo = new Button("Cancelar");
        GridBagConstraints gbc_bttnCancelarEliminarArticulo = new GridBagConstraints();
        gbc_bttnCancelarEliminarArticulo.fill = GridBagConstraints.HORIZONTAL;
        gbc_bttnCancelarEliminarArticulo.insets = new Insets(0, 0, 0, 5);
        gbc_bttnCancelarEliminarArticulo.gridx = 1;
        gbc_bttnCancelarEliminarArticulo.gridy = 2;
        contentPane.add(bttnCancelarEliminarArticulo, gbc_bttnCancelarEliminarArticulo);
        
        bttnEliminarArticulo = new Button("Eliminar");
        bttnEliminarArticulo.setActionCommand("Eliminar");
        GridBagConstraints gbc_bttnEliminarArticulo = new GridBagConstraints();
        gbc_bttnEliminarArticulo.insets = new Insets(0, 0, 0, 5);
        gbc_bttnEliminarArticulo.fill = GridBagConstraints.HORIZONTAL;
        gbc_bttnEliminarArticulo.gridx = 3;
        gbc_bttnEliminarArticulo.gridy = 2;
        contentPane.add(bttnEliminarArticulo, gbc_bttnEliminarArticulo);
    }

    // Métodos getter para el Choice y el botón Eliminar
    public Choice getChoice() {
        return choice;
    }

    public Button getBttnEliminarArticulo() {
        return bttnEliminarArticulo; // El botón "Eliminar"
    }
    public Button getBttnCancelarEliminarArticulo() {
        return bttnCancelarEliminarArticulo; // El botón "Eliminar"
    }
}
