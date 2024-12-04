import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Button;
import java.awt.TextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class VistaAltaArticulos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private TextField txtDescripcion;
	private TextField txtPrecio;
	private TextField txtCantidad;
	
	public VistaAltaArticulos() {
	    ControladorAltaArticulos Controlador = new ControladorAltaArticulos(this);
	    setTitle("Crear Articulos");
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 313, 207);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	    setContentPane(contentPane);
	    GridBagLayout gbl_contentPane = new GridBagLayout();
	    gbl_contentPane.columnWidths = new int[]{0, 68, 90, 68, 0, 0};
	    gbl_contentPane.rowHeights = new int[]{25, 25, 25, 25, 25, 0, 0};
	    gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    contentPane.setLayout(gbl_contentPane);

	    JLabel lblCrearArticulo = new JLabel("Crear Articulo");
	    GridBagConstraints gbc_lblCrearArticulo = new GridBagConstraints();
	    gbc_lblCrearArticulo.insets = new Insets(0, 0, 5, 5);
	    gbc_lblCrearArticulo.gridx = 2;
	    gbc_lblCrearArticulo.gridy = 0;
	    contentPane.add(lblCrearArticulo, gbc_lblCrearArticulo);

	    JLabel lblDescripcion = new JLabel("Descripcion");
	    GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
	    gbc_lblDescripcion.anchor = GridBagConstraints.WEST;
	    gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
	    gbc_lblDescripcion.gridx = 1;
	    gbc_lblDescripcion.gridy = 1;
	    contentPane.add(lblDescripcion, gbc_lblDescripcion);

	    txtDescripcion = new TextField(); // Usa la variable de clase
	    txtDescripcion.setColumns(10);
	    GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
	    gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
	    gbc_txtDescripcion.gridx = 2;
	    gbc_txtDescripcion.gridy = 1;
	    contentPane.add(txtDescripcion, gbc_txtDescripcion);

	    JLabel lblPrecio = new JLabel("Precio");
	    GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
	    gbc_lblPrecio.anchor = GridBagConstraints.WEST;
	    gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
	    gbc_lblPrecio.gridx = 1;
	    gbc_lblPrecio.gridy = 2;
	    contentPane.add(lblPrecio, gbc_lblPrecio);

	    txtPrecio = new TextField(); // Usa la variable de clase
	    txtPrecio.setColumns(10);
	    GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
	    gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
	    gbc_txtPrecio.gridx = 2;
	    gbc_txtPrecio.gridy = 2;
	    contentPane.add(txtPrecio, gbc_txtPrecio);

	    JLabel lblCantidad = new JLabel("Cantidad");
	    GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
	    gbc_lblCantidad.anchor = GridBagConstraints.WEST;
	    gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
	    gbc_lblCantidad.gridx = 1;
	    gbc_lblCantidad.gridy = 3;
	    contentPane.add(lblCantidad, gbc_lblCantidad);

	    txtCantidad = new TextField(); // Usa la variable de clase
	    txtCantidad.setColumns(10);
	    GridBagConstraints gbc_txtCantidad = new GridBagConstraints();
	    gbc_txtCantidad.insets = new Insets(0, 0, 5, 5);
	    gbc_txtCantidad.gridx = 2;
	    gbc_txtCantidad.gridy = 3;
	    contentPane.add(txtCantidad, gbc_txtCantidad);

	    Button bttnCancelarAltaArticulos = new Button("Cancelar");
	    bttnCancelarAltaArticulos.addActionListener(Controlador);
	    bttnCancelarAltaArticulos.setActionCommand("VolverAltaArticulo");
	    GridBagConstraints gbc_bttnCancelarAltaArticulos = new GridBagConstraints();
	    gbc_bttnCancelarAltaArticulos.fill = GridBagConstraints.BOTH;
	    gbc_bttnCancelarAltaArticulos.insets = new Insets(0, 0, 0, 5);
	    gbc_bttnCancelarAltaArticulos.gridx = 1;
	    gbc_bttnCancelarAltaArticulos.gridy = 5;
	    contentPane.add(bttnCancelarAltaArticulos, gbc_bttnCancelarAltaArticulos);

	    Button bttnCrearAltaArticulos = new Button("Crear");
	    bttnCrearAltaArticulos.addActionListener(Controlador);
	    bttnCrearAltaArticulos.setActionCommand("CrearArticulo"); 
	    GridBagConstraints gbc_CrearAltaArticulos = new GridBagConstraints();
	    gbc_CrearAltaArticulos.insets = new Insets(0, 0, 0, 5);
	    gbc_CrearAltaArticulos.fill = GridBagConstraints.BOTH;
	    gbc_CrearAltaArticulos.gridx = 3;
	    gbc_CrearAltaArticulos.gridy = 5;
	    contentPane.add(bttnCrearAltaArticulos, gbc_CrearAltaArticulos);
	}

	public String getDescripcion() {
		return txtDescripcion.getText();
	}
	public double getPrecio() throws NumberFormatException {
	    try {
	        return Double.parseDouble(txtPrecio.getText()); // Convierte el texto a double
	    } catch (NumberFormatException e) {
	        throw new NumberFormatException("El precio debe ser un número decimal.");
	    }
	}
	public int gettxtCantidad() {
	    try {
	        return Integer.parseInt(txtCantidad.getText()); // Convierte el texto a int
	    } catch (NumberFormatException e) {
	        throw new NumberFormatException("La cantidad debe ser un número entero.");
	    }
	}
}