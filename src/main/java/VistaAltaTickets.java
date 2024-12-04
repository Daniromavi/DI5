import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaAltaTickets extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private java.awt.List list;
	private TextField txtFecha;



	/**
	 * Create the frame.
	 */
	public VistaAltaTickets() {
	    ControladorAltaTickets Controlador = new ControladorAltaTickets(this);
	    setTitle("Crear Tickets");
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 423, 230);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	    setContentPane(contentPane);
	    GridBagLayout gbl_contentPane = new GridBagLayout();
	    gbl_contentPane.columnWidths = new int[]{0, 68, 90, 68, 0, 0};
	    gbl_contentPane.rowHeights = new int[]{0, 0, 25, 0, 25, 25, 25, 0};
	    gbl_contentPane.columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
	    gbl_contentPane.rowWeights = new double[] {0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
	    contentPane.setLayout(gbl_contentPane);
	    
	    Button bttnCancelarCrearTicket = new Button("Cancelar");
	    bttnCancelarCrearTicket.addActionListener(Controlador);
	    bttnCancelarCrearTicket.setActionCommand("VolverAltaTickets");
	    
	    // Aquí usamos el atributo de clase, no creamos una nueva instancia local
	    list = new java.awt.List();
	    list.setMultipleMode(true);
	    GridBagConstraints gbc_list = new GridBagConstraints();
	    gbc_list.gridheight = 5;
	    gbc_list.fill = GridBagConstraints.BOTH; // Permitir que se expanda en ambas direcciones
	    gbc_list.insets = new Insets(0, 0, 5, 5);
	    gbc_list.gridx = 2; // Columna donde se coloca
	    gbc_list.gridy = 0; // Fila inicial
	    gbc_list.weightx = 1.0; // Habilitar expansión horizontal
	    gbc_list.weighty = 1.0; // Habilitar expansión vertical
	    contentPane.add(list, gbc_list);
	    
	    JLabel lblSeleccionarArticulos = new JLabel("Elegir Articulos");
	    GridBagConstraints gbc_lblSeleccionarArticulos = new GridBagConstraints();
	    gbc_lblSeleccionarArticulos.insets = new Insets(0, 0, 5, 5);
	    gbc_lblSeleccionarArticulos.gridx = 1;
	    gbc_lblSeleccionarArticulos.gridy = 2;
	    contentPane.add(lblSeleccionarArticulos, gbc_lblSeleccionarArticulos);
	    
	    JLabel lblFechaTicket = new JLabel("Fecha");
	    GridBagConstraints gbc_lblFechaTicket = new GridBagConstraints();
	    gbc_lblFechaTicket.insets = new Insets(0, 0, 5, 5);
	    gbc_lblFechaTicket.gridx = 1;
	    gbc_lblFechaTicket.gridy = 5;
	    contentPane.add(lblFechaTicket, gbc_lblFechaTicket);
	    
	    txtFecha = new TextField();
	    GridBagConstraints gbc_txtfFecha = new GridBagConstraints();
	    gbc_txtfFecha.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtfFecha.insets = new Insets(0, 0, 5, 5);
	    gbc_txtfFecha.gridx = 2;
	    gbc_txtfFecha.gridy = 5;
	    contentPane.add(txtFecha, gbc_txtfFecha);
	    GridBagConstraints gbc_bttnCancelarCrearTicket = new GridBagConstraints();
	    gbc_bttnCancelarCrearTicket.fill = GridBagConstraints.HORIZONTAL;
	    gbc_bttnCancelarCrearTicket.insets = new Insets(0, 0, 0, 5);
	    gbc_bttnCancelarCrearTicket.gridx = 1;
	    gbc_bttnCancelarCrearTicket.gridy = 6;
	    contentPane.add(bttnCancelarCrearTicket, gbc_bttnCancelarCrearTicket);
	    
	    Button bttnCrearTicket = new Button("Crear");
	    bttnCrearTicket.addActionListener(Controlador);
	    bttnCrearTicket.setActionCommand("CrearTicket");
	    
	    GridBagConstraints gbc_bttnCrearTicket = new GridBagConstraints();
	    gbc_bttnCrearTicket.insets = new Insets(0, 0, 0, 5);
	    gbc_bttnCrearTicket.fill = GridBagConstraints.HORIZONTAL;
	    gbc_bttnCrearTicket.gridx = 3;
	    gbc_bttnCrearTicket.gridy = 6;
	    contentPane.add(bttnCrearTicket, gbc_bttnCrearTicket);
	    
	    cargarArticulos(list); // Llamada para cargar artículos en la lista
	}

	/**
	 * Método público para obtener los elementos seleccionados de la lista.
	 * 
	 * @return Un array de Strings con los elementos seleccionados, o un array vacío si no hay selección.
	 */

	public List<Integer> getIdsSeleccionados() {
	    List<Integer> ids = new ArrayList<>();
	    for (String item : list.getSelectedItems()) {
	        // Dividir por ":" para obtener el ID antes de la descripción
	        String[] partes = item.split(":");
	        if (partes.length > 0) {
	            try {
	                // Convertir el ID a entero y agregarlo a la lista
	                ids.add(Integer.parseInt(partes[0].trim()));
	            } catch (NumberFormatException e) {
	                System.err.println("Error al convertir ID: " + partes[0]);
	            }
	        }
	    }
	    return ids;
	}

	public String getFecha() {
		return txtFecha.getText();
	}
	
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