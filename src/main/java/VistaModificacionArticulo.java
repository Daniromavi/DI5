import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaModificacionArticulo extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private TextField txtDescripcion;
    private TextField txtPrecio;
    private TextField txtCantidad;
    private String idArticulo; // Variable para almacenar el ID

    // Constructor con el ID del artículo
    public VistaModificacionArticulo(String idArticulo) {
        this.idArticulo = idArticulo; // Asignar el ID al atributo de la clase

        ControladorModificacionArticulo controlador = new ControladorModificacionArticulo(this);
        setTitle("Modificar Articulos");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 424, 218);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{68, 68, 90, 68, 68, 0};
        gbl_contentPane.rowHeights = new int[]{25, 0, 0, 25, 25, 25, 25, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        Button bttnCancelarCrearTicket = new Button("Cancelar");
        bttnCancelarCrearTicket.addActionListener(controlador);
        bttnCancelarCrearTicket.setActionCommand("VolverModificar");

        JLabel lblModificarArticulo = new JLabel("Modificar Articulo");
        GridBagConstraints gbc_lblModificarArticulo = new GridBagConstraints();
        gbc_lblModificarArticulo.insets = new Insets(0, 0, 5, 5);
        gbc_lblModificarArticulo.gridx = 2;
        gbc_lblModificarArticulo.gridy = 1;
        contentPane.add(lblModificarArticulo, gbc_lblModificarArticulo);

        JLabel lblDescripcion = new JLabel("Descripcion");
        GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
        gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescripcion.gridx = 1;
        gbc_lblDescripcion.gridy = 2;
        contentPane.add(lblDescripcion, gbc_lblDescripcion);

        txtDescripcion = new TextField();
        GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
        gbc_txtDescripcion.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
        gbc_txtDescripcion.gridx = 2;
        gbc_txtDescripcion.gridy = 2;
        contentPane.add(txtDescripcion, gbc_txtDescripcion);

        JLabel lblPrecio = new JLabel("Precio");
        GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
        gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
        gbc_lblPrecio.gridx = 1;
        gbc_lblPrecio.gridy = 3;
        contentPane.add(lblPrecio, gbc_lblPrecio);

        txtPrecio = new TextField();
        GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
        gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
        gbc_txtPrecio.gridx = 2;
        gbc_txtPrecio.gridy = 3;
        contentPane.add(txtPrecio, gbc_txtPrecio);

        JLabel lblCantidad = new JLabel("Cantidad");
        GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
        gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
        gbc_lblCantidad.gridx = 1;
        gbc_lblCantidad.gridy = 4;
        contentPane.add(lblCantidad, gbc_lblCantidad);

        txtCantidad = new TextField();
        GridBagConstraints gbc_txtCantidad = new GridBagConstraints();
        gbc_txtCantidad.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCantidad.insets = new Insets(0, 0, 5, 5);
        gbc_txtCantidad.gridx = 2;
        gbc_txtCantidad.gridy = 4;
        contentPane.add(txtCantidad, gbc_txtCantidad);

        GridBagConstraints gbc_bttnCancelarCrearTicket = new GridBagConstraints();
        gbc_bttnCancelarCrearTicket.fill = GridBagConstraints.HORIZONTAL;
        gbc_bttnCancelarCrearTicket.insets = new Insets(0, 0, 0, 5);
        gbc_bttnCancelarCrearTicket.gridx = 1;
        gbc_bttnCancelarCrearTicket.gridy = 6;
        contentPane.add(bttnCancelarCrearTicket, gbc_bttnCancelarCrearTicket);

        Button bttnModificarArticulo = new Button("Modificar");
        bttnModificarArticulo.addActionListener(controlador);
        bttnModificarArticulo.setActionCommand("ModificacionArticulo");

        GridBagConstraints gbc_bttnModificarArticulo = new GridBagConstraints();
        gbc_bttnModificarArticulo.fill = GridBagConstraints.HORIZONTAL;
        gbc_bttnModificarArticulo.insets = new Insets(0, 0, 0, 5);
        gbc_bttnModificarArticulo.gridx = 3;
        gbc_bttnModificarArticulo.gridy = 6;
        contentPane.add(bttnModificarArticulo, gbc_bttnModificarArticulo);
    }

    // Métodos para obtener los valores de los campos
    public String getTxtDescripcion() {
        return txtDescripcion.getText();
    }

    public String getTxtPrecio() {
        return txtPrecio.getText();
    }

    public String getTxtCantidad() {
        return txtCantidad.getText();
    }

    // Método para obtener el ID del artículo
    public String getIdArticulo() {
        return idArticulo;
    }
}
