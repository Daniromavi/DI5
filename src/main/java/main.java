
import es.studium.Vista.VistaMenuPrincipal;
import es.studium.Controlador.ControladorMenuPrincipal;

public class main {
    public static void main(String[] args) {
        VistaMenuPrincipal vista = new VistaMenuPrincipal();
        ControladorMenuPrincipal controlador = new ControladorMenuPrincipal(vista);
        
        // Hacer visible la vista
        vista.setVisible(true);
    }
}
