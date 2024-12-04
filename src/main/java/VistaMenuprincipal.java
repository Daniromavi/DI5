import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.FlowLayout;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class VistaMenuprincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public VistaMenuprincipal() {
        ControladorMenuPrincipal Controlador = new ControladorMenuPrincipal(this);
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setResizable(true);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnNewMenu = new JMenu("Articulos");
        menuBar.add(mnNewMenu);
        mnNewMenu.addActionListener(Controlador);
        
        JMenuItem mntmAltaArticulos = new JMenuItem("Alta");
        mnNewMenu.add(mntmAltaArticulos);
        mntmAltaArticulos.setActionCommand("AltaArticulos");
        mntmAltaArticulos.addActionListener(Controlador);
        
        JMenuItem mntmBajaArticulos = new JMenuItem("Baja");
        mnNewMenu.add(mntmBajaArticulos);
        mntmBajaArticulos.setActionCommand("BajaArticulos");
        mntmBajaArticulos.addActionListener(Controlador);
        
        JMenuItem mntmListadoArticulos = new JMenuItem("Listado");
        mnNewMenu.add(mntmListadoArticulos);
        mntmListadoArticulos.setActionCommand("ListadoArticulos");
        mntmListadoArticulos.addActionListener(Controlador);
      
        JMenuItem mntmModificarArticulos = new JMenuItem("Modificar");
        mnNewMenu.add(mntmModificarArticulos);
        mntmModificarArticulos.setActionCommand("ModificarArticulos");
        mntmModificarArticulos.addActionListener(Controlador);
       
        JMenu mnNewMenu_1 = new JMenu("Tickets");
        menuBar.add(mnNewMenu_1);
        
        JMenuItem mntmAltaTickets = new JMenuItem("Alta");
        mnNewMenu_1.add(mntmAltaTickets);
        mntmAltaTickets.setActionCommand("AltaTickets");
        mntmAltaTickets.addActionListener(Controlador);

        JMenuItem mntmListadoTickets = new JMenuItem("Listado");
        mnNewMenu_1.add(mntmListadoTickets);
        mntmListadoTickets.setActionCommand("ListadoTickets");
        mntmListadoTickets.addActionListener(Controlador);
     
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));        
    }
}
