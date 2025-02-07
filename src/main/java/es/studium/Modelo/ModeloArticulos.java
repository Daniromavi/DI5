package es.studium.Modelo;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ModeloArticulos {

	// Conexión a la base de datos
	private static final String URL = "jdbc:mysql://localhost:3306/tiendecitaDRA";
	private static final String USER = "root";
	private static final String PASSWORD = "Studium2024!";
	private Connection connection;

	// Constructor para establecer la conexión
	public ModeloArticulos() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Método para crear un nuevo artículo
	public boolean crearArticulo(String descripcion, double precioArticulo, int cantidadStock) {
		String query = "INSERT INTO articulos (descripcion, precioarticulo, cantidadstock) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, descripcion);
			stmt.setDouble(2, precioArticulo);
			stmt.setInt(3, cantidadStock);
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Método para obtener todos los artículos
	public List<Articulo> obtenerArticulos() {
		List<Articulo> articulos = new ArrayList<>();
		String query = "SELECT * FROM articulos";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				int idArticulo = rs.getInt("idarticulo");
				String descripcion = rs.getString("descripcion");
				double precioArticulo = rs.getDouble("precioarticulo");
				int cantidadStock = rs.getInt("cantidadstock");
				articulos.add(new Articulo(idArticulo, descripcion, precioArticulo, cantidadStock));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articulos;
	}

	// Método para actualizar un artículo
	public boolean actualizarArticulo(int idArticulo, String descripcion, double precioArticulo, int cantidadStock) {
		String query = "UPDATE articulos SET descripcion = ?, precioarticulo = ?, cantidadstock = ? WHERE idarticulo = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, descripcion);
			stmt.setDouble(2, precioArticulo);
			stmt.setInt(3, cantidadStock);
			stmt.setInt(4, idArticulo);
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Método para eliminar un artículo
	public boolean eliminarArticulo(int idArticulo) {
		String query = "DELETE FROM articulos WHERE idarticulo = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, idArticulo);
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Connection getConexion() {
		return connection;
	}

	public void generarInformeArticulos() {
	    try {
	        // Compilar el informe generando fichero .jasper

	        // Objeto para guardar parámetros necesarios para el informe
	        HashMap<String, Object> parametros = new HashMap<>();

	        // Cargar el informe compilado
	        JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("./src/main/resources/Articulos.jasper");

	        // Conectar a la base de datos para extraer la información
	        Class.forName("com.mysql.cj.jdbc.Driver"); // Se actualizó el driver
	        String servidor = "jdbc:mysql://localhost:3306/tiendecitaDRA?useSSL=false&serverTimezone=UTC";
	        String usuarioDB = "root";
	        String passwordDB = "Studium2024!";

	        try (Connection conexion = DriverManager.getConnection(servidor, usuarioDB, passwordDB)) {
	            // Completar el informe con los datos de la base de datos
	            JasperPrint print = JasperFillManager.fillReport(report, parametros, conexion);

	            // Mostrar el informe en JasperViewer
	            JasperViewer.viewReport(print, false);

	            // Exportar a PDF
	            String pdfPath = "./src/main/resources/Articulos.pdf";
	            JasperExportManager.exportReportToPdfFile(print, pdfPath);

	            // Abrir el fichero PDF generado
	            File path = new File(pdfPath);
	            Desktop.getDesktop().open(path);
	        }
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

}
