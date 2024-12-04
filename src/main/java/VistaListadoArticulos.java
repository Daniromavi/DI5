import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaListadoArticulos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public VistaListadoArticulos() {
    	ControladorListadoArticulos Controlador = new ControladorListadoArticulos(this);
        setTitle("Listado Articulos");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 491, 361);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 68, 68, 90, 68, 68, 0 };
        gbl_contentPane.rowHeights = new int[] { 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0 };
        gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);

        // Lista para mostrar los artículos
        java.awt.List list = new java.awt.List();
        GridBagConstraints gbc_list = new GridBagConstraints();
        gbc_list.gridwidth = 3;
        gbc_list.fill = GridBagConstraints.BOTH;
        gbc_list.gridheight = 10;
        gbc_list.insets = new Insets(0, 0, 5, 5);
        gbc_list.gridx = 1;
        gbc_list.gridy = 0;
        contentPane.add(list, gbc_list);

        // Cargar los artículos al iniciar el frame
        cargarArticulos(list);

        Button bttnVolverMenuPrincipal = new Button("Volver");
        bttnVolverMenuPrincipal.addActionListener(Controlador);
        bttnVolverMenuPrincipal.setActionCommand("VolverListado");
        GridBagConstraints gbc_bttnVolverMenuPrincipal = new GridBagConstraints();
        gbc_bttnVolverMenuPrincipal.fill = GridBagConstraints.HORIZONTAL;
        gbc_bttnVolverMenuPrincipal.insets = new Insets(0, 0, 0, 5);
        gbc_bttnVolverMenuPrincipal.gridx = 1;
        gbc_bttnVolverMenuPrincipal.gridy = 10;
        contentPane.add(bttnVolverMenuPrincipal, gbc_bttnVolverMenuPrincipal);

        Button bttnPDF = new Button("PDF");
        bttnPDF.setActionCommand("PDF");
        bttnPDF.addActionListener(Controlador);
        GridBagConstraints gbc_bttnPDF = new GridBagConstraints();
        gbc_bttnPDF.fill = GridBagConstraints.HORIZONTAL;
        gbc_bttnPDF.insets = new Insets(0, 0, 0, 5);
        gbc_bttnPDF.gridx = 3;
        gbc_bttnPDF.gridy = 10;
        contentPane.add(bttnPDF, gbc_bttnPDF);
    }

    /**
     * Método para cargar los artículos en la lista.
     */
    private void cargarArticulos(java.awt.List list) {
        String articulos = Conexion.ListadoArticulos();

        // Dividir el resultado en líneas y añadirlas a la lista
        if (articulos != null && !articulos.isEmpty()) {
            String[] lineas = articulos.split("\n");
            for (String linea : lineas) {
                list.add(linea);
            }
        } else {
            list.add("No hay artículos disponibles.");
        }
    }
}
