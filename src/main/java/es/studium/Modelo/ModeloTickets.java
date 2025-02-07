package es.studium.Modelo;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ModeloTickets {

	
    public void generarInformeTickets(Date fechaDesdeDate, Date fechaHastaDate) {
        try {
        
        	System.out.println("Fichero EjemploJaspersoft_Parametros.jasper generado CORRECTAMENTE!");
        	// Formatear las fechas a "yyyy-MM-dd"
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	String fechaDesdeFormatted = sdf.format(fechaDesdeDate);
        	String fechaHastaFormatted = sdf.format(fechaHastaDate);

        	// Añadir comillas a las fechas
        	String fechaDesdeConComillas = '"' + fechaDesdeFormatted + '"';
        	String fechaHastaConComillas = '"' + fechaHastaFormatted + '"';

        	// Imprimir las fechas con comillas
        	System.out.println("fechaHasta con comillas: " + fechaHastaFormatted);
        	System.out.println("fechaDesde con comillas: " + fechaDesdeFormatted);

        	// Pasar las fechas formateadas a los parámetros del reporte
        	HashMap<String, Object> parametros = new HashMap<String, Object>();
        	parametros.put("fechaDesde", fechaDesdeFormatted);
        	parametros.put("fechaHasta", fechaHastaFormatted);


            // Cargar el informe compilado
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile("./src/main/resources/Tickets.jasper");

            // Conectar a la base de datos para extraer la información
            String servidor = "jdbc:mysql://localhost:3306/tiendecitaDRA?useSSL=false&serverTimezone=UTC";
            String usuarioDB = "root";
            String passwordDB = "Studium2024!";
            Connection conexion =
            		DriverManager.getConnection(servidor, usuarioDB, passwordDB);

            JasperPrint print = JasperFillManager.fillReport(jasperReport, parametros, conexion);
            JasperViewer.viewReport(print, false);
            JasperExportManager.exportReportToPdfFile(print, "./src/main/resources/Tickets.pdf");
            String pdfPath="./src/main/resources/Tickets.pdf";
            File path = new File(pdfPath);
            if (path.exists()) {
                Desktop.getDesktop().open(path);
            } else {
                JOptionPane.showMessageDialog(null, "El informe no se pudo generar correctamente.");
            }
            
            // Conexión con la base de datos
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar el informe: " + e.getMessage());
        }
    }
}
