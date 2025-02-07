package es.studium.Vista;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaListadoArticulos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private java.awt.List list; // Esta es la variable miembro de la clase
    private Button bttnVolverMenuPrincipal;

    /**
     * Create the frame.
     */
    public VistaListadoArticulos() {
        setTitle("Listado Artículos");
        setResizable(true); // Permite redimensionar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350); // Ajustar el tamaño de la ventana
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10)); // Añadir más espacio alrededor
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0};
        gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        contentPane.setLayout(gbl_contentPane);

        // Configuración de la lista
        list = new java.awt.List();
        GridBagConstraints gbc_list = new GridBagConstraints();
        gbc_list.fill = GridBagConstraints.BOTH; // Asegura que la lista ocupe todo el espacio disponible
        gbc_list.gridwidth = 5; // Ocupa 3 columnas
        gbc_list.gridheight = 6; // Menos altura para que el botón tenga espacio
        gbc_list.insets = new Insets(10, 10, 5, 10); // Márgenes para que no toque los bordes
        gbc_list.gridx = 0; // Posición horizontal
        gbc_list.gridy = 0; // Fila superior
        contentPane.add(list, gbc_list);
                
                        // Configuración del botón
                        bttnVolverMenuPrincipal = new Button("Volver");
                        bttnVolverMenuPrincipal.setActionCommand("VolverListado");
                        GridBagConstraints gbc_bttnVolverMenuPrincipal = new GridBagConstraints();
                        gbc_bttnVolverMenuPrincipal.gridwidth = 2;
                        gbc_bttnVolverMenuPrincipal.insets = new Insets(10, 0, 10, 5); // Espacios alrededor del botón
                        gbc_bttnVolverMenuPrincipal.gridx = 0; // Centrado horizontalmente
                        gbc_bttnVolverMenuPrincipal.gridy = 6; // Fila de abajo
                        contentPane.add(bttnVolverMenuPrincipal, gbc_bttnVolverMenuPrincipal);
    }

    // Método para acceder a la lista
    public java.awt.List getList() {
        return list;
    }

    // Método para acceder al botón
    public Button getbttnVolverMenuPrincipal() {
        return bttnVolverMenuPrincipal;
    }
}
