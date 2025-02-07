package es.studium.Vista;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class VistaModificarArticulos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList<String> list;
    private Button bttnCancelarModificarArticulo;
    private Button bttnModificarArticulo;

    public VistaModificarArticulos() {
        setTitle("Modificar Artículos");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 250); // Ajustar tamaño de la ventana

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10)); // Añadir más espacio alrededor
        setContentPane(contentPane);

        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 80, 80, 80, 0}; // Ajustar las columnas
        gbl_contentPane.rowHeights = new int[]{25, 0, 0, 0, 35, 0}; // Ajustar las filas
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE}; // Hacer la lista más ancha
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        // Título
        JLabel lblSeleccionarArticulos = new JLabel("Seleccionar Artículos");
        GridBagConstraints gbc_lblSeleccionarArticulos = new GridBagConstraints();
        gbc_lblSeleccionarArticulos.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccionarArticulos.gridx = 2;
        gbc_lblSeleccionarArticulos.gridy = 0;
        contentPane.add(lblSeleccionarArticulos, gbc_lblSeleccionarArticulos);

        // Lista de artículos
        DefaultListModel<String> listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        GridBagConstraints gbc_list = new GridBagConstraints();
        gbc_list.gridheight = 3;
        gbc_list.fill = GridBagConstraints.BOTH;
        gbc_list.gridwidth = 3;
        gbc_list.insets = new Insets(0, 0, 5, 5);
        gbc_list.gridx = 1;
        gbc_list.gridy = 1;
        contentPane.add(list, gbc_list);

        // Botón Cancelar
        bttnCancelarModificarArticulo = new Button("Cancelar");
        GridBagConstraints gbc_bttnCancelarModificarArticulo = new GridBagConstraints();
        gbc_bttnCancelarModificarArticulo.fill = GridBagConstraints.HORIZONTAL;
        gbc_bttnCancelarModificarArticulo.insets = new Insets(0, 0, 0, 5);
        gbc_bttnCancelarModificarArticulo.gridx = 1;
        gbc_bttnCancelarModificarArticulo.gridy = 4;
        contentPane.add(bttnCancelarModificarArticulo, gbc_bttnCancelarModificarArticulo);

        // Botón Modificar
        bttnModificarArticulo = new Button("Modificar");
        GridBagConstraints gbc_bttnModificarArticulo = new GridBagConstraints();
        gbc_bttnModificarArticulo.insets = new Insets(0, 0, 0, 5);
        gbc_bttnModificarArticulo.fill = GridBagConstraints.HORIZONTAL;
        gbc_bttnModificarArticulo.gridx = 2;
        gbc_bttnModificarArticulo.gridy = 4;
        contentPane.add(bttnModificarArticulo, gbc_bttnModificarArticulo);
    }

    // Método para obtener la lista de artículos
    public JList<String> getList() {
        return list;
    }

    // Método para obtener el botón de cancelar
    public Button getBttnCancelarModificarArticulo() {
        return bttnCancelarModificarArticulo;
    }

    // Método para obtener el botón de modificar
    public Button getBttnModificarArticulo() {
        return bttnModificarArticulo;
    }
}
