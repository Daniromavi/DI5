import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VistaModificarArticulos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList<String> list;
    private String selectedArticuloId;

    public VistaModificarArticulos() {
        ControladorModificarArticulo controlador = new ControladorModificarArticulo(this);
        setTitle("Modificar Articulos");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 331, 165);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 68, 90, 68, 0, 0};
        gbl_contentPane.rowHeights = new int[]{25, 0, 0, 0, 25, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JLabel lblSeleccionarArticulos = new JLabel("Seleccionar Articulos");
        GridBagConstraints gbc_lblSeleccionarArticulos = new GridBagConstraints();
        gbc_lblSeleccionarArticulos.insets = new Insets(0, 0, 5, 5);
        gbc_lblSeleccionarArticulos.gridx = 2;
        gbc_lblSeleccionarArticulos.gridy = 0;
        contentPane.add(lblSeleccionarArticulos, gbc_lblSeleccionarArticulos);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedValue = list.getSelectedValue();
                    if (selectedValue != null) {
                        selectedArticuloId = extractIdFromArticulo(selectedValue);
                    }
                }
            }
        });

        GridBagConstraints gbc_list = new GridBagConstraints();
        gbc_list.gridheight = 3;
        gbc_list.fill = GridBagConstraints.BOTH;
        gbc_list.gridwidth = 3;
        gbc_list.insets = new Insets(0, 0, 5, 5);
        gbc_list.gridx = 1;
        gbc_list.gridy = 1;
        contentPane.add(list, gbc_list);

        cargarArticulos(listModel);

        Button bttnCancelarModificarArticulo = new Button("Cancelar");
        bttnCancelarModificarArticulo.addActionListener(controlador);
        bttnCancelarModificarArticulo.setActionCommand("VolverModificarArticulos");

        GridBagConstraints gbc_bttnCancelarModificarArticulo = new GridBagConstraints();
        gbc_bttnCancelarModificarArticulo.fill = GridBagConstraints.HORIZONTAL;
        gbc_bttnCancelarModificarArticulo.insets = new Insets(0, 0, 0, 5);
        gbc_bttnCancelarModificarArticulo.gridx = 1;
        gbc_bttnCancelarModificarArticulo.gridy = 4;
        contentPane.add(bttnCancelarModificarArticulo, gbc_bttnCancelarModificarArticulo);

        Button bttnModificarArticulo = new Button("Modificar");
        bttnModificarArticulo.addActionListener(controlador);
        bttnModificarArticulo.setActionCommand("ModificarArticulo");

        GridBagConstraints gbc_bttnModificarArticulo = new GridBagConstraints();
        gbc_bttnModificarArticulo.insets = new Insets(0, 0, 0, 5);
        gbc_bttnModificarArticulo.fill = GridBagConstraints.HORIZONTAL;
        gbc_bttnModificarArticulo.gridx = 3;
        gbc_bttnModificarArticulo.gridy = 4;
        contentPane.add(bttnModificarArticulo, gbc_bttnModificarArticulo);
    }

    private void cargarArticulos(DefaultListModel<String> listModel) {
        String articulos = Conexion.ListadoArticulos();

        if (articulos != null && !articulos.isEmpty()) {
            String[] lineas = articulos.split("\n");
            for (String linea : lineas) {
                listModel.addElement(linea);
            }
        } else {
            listModel.addElement("No hay artículos disponibles.");
        }
    }

    private String extractIdFromArticulo(String articulo) {
        String[] partes = articulo.split(" - ");
        if (partes.length > 0) {
            return partes[0].trim();
        }
        return null;
    }

    public String getSelectedArticuloId() {
        // Extrae solo el número al inicio de la cadena, asumiendo que es un formato conocido
        String[] parts = selectedArticuloId.split(":");
        return parts[0].trim(); // Devuelve solo el número antes del primer ':'
    }

}
