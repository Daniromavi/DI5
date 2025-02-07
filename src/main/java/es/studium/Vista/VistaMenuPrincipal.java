package es.studium.Vista;

import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

public class VistaMenuPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    // Elementos del menú
    private JMenuItem mntmAltaArticulos;
    private JMenuItem mntmBajaArticulos;
    private JMenuItem mntmListadoArticulos;
    private JMenuItem mntmModificarArticulos;
    private JMenuItem mntmAltaTickets;
    private JMenuItem mntmListadoTickets;
    private JMenuItem mntmGenerarInformeTickets; // Añadir este item para generar informe
    private JMenuItem mntmGenerarInformeArticulos;

    public VistaMenuPrincipal() {
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

        mntmAltaArticulos = new JMenuItem("Alta");
        mnNewMenu.add(mntmAltaArticulos);
        mntmAltaArticulos.setActionCommand("AltaArticulos");

        mntmBajaArticulos = new JMenuItem("Baja");
        mnNewMenu.add(mntmBajaArticulos);
        mntmBajaArticulos.setActionCommand("BajaArticulos");

        mntmListadoArticulos = new JMenuItem("Listado");
        mnNewMenu.add(mntmListadoArticulos);
        mntmListadoArticulos.setActionCommand("ListadoArticulos");

        mntmModificarArticulos = new JMenuItem("Modificar");
        mnNewMenu.add(mntmModificarArticulos);
        mntmModificarArticulos.setActionCommand("ModificarArticulos");
        
        mntmGenerarInformeArticulos = new JMenuItem("Generar Informe");
        mnNewMenu.add(mntmGenerarInformeArticulos);
        mntmGenerarInformeArticulos.setActionCommand("GenerarInformeArticulos");

        JMenu mnNewMenu_1 = new JMenu("Tickets");
        menuBar.add(mnNewMenu_1);

        mntmAltaTickets = new JMenuItem("Alta");
        mnNewMenu_1.add(mntmAltaTickets);
        mntmAltaTickets.setActionCommand("AltaTickets");

        mntmListadoTickets = new JMenuItem("Listado");
        mnNewMenu_1.add(mntmListadoTickets);
        mntmListadoTickets.setActionCommand("ListadoTickets");

        // Añadir la opción para generar informe
        mntmGenerarInformeTickets = new JMenuItem("Generar Informe");
        mnNewMenu_1.add(mntmGenerarInformeTickets);
        mntmGenerarInformeTickets.setActionCommand("GenerarInformeTickets");

        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    }

    // Métodos getter para los JMenuItem
    public JMenuItem getMntmAltaArticulos() {
        return mntmAltaArticulos;
    }

    public JMenuItem getMntmBajaArticulos() {
        return mntmBajaArticulos;
    }

    public JMenuItem getMntmListadoArticulos() {
        return mntmListadoArticulos;
    }

    public JMenuItem getMntmModificarArticulos() {
        return mntmModificarArticulos;
    }

    public JMenuItem getMntmAltaTickets() {
        return mntmAltaTickets;
    }

    public JMenuItem getMntmListadoTickets() {
        return mntmListadoTickets;
    }

    public JMenuItem getMntmGenerarInformeTickets() {
        return mntmGenerarInformeTickets;
    }
    
    public JMenuItem getMntmGenerarInformeArticulos() {
        return mntmGenerarInformeArticulos;
    }

}
