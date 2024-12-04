import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JList;

import java.io.InputStream;

public class Conexion {

	private static final String URL = "jdbc:mysql://localhost:3306/tiendecitaDRA";
	private static final String USER = "root";
	private static final String PASSWORD = "Studium2024;"; 

	// Método para establecer la conexión
	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public static String ListadoArticulos() {
		String query = "SELECT * FROM articulos;";
		StringBuilder resultado = new StringBuilder();
		
        try (Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(query);
        		 ResultSet rs = stmt.executeQuery()) {
        	while (rs.next()) {
        		 int id = rs.getInt("idArticulo");
        		 String descripcion = rs.getString("descripcion");
                 double precio = rs.getDouble("precioArticulo");
                 int cantidad = rs.getInt("cantidadstock");
                 
                 resultado
                 .
                 append(id)
                 .
                 append(": Descripcion: ")
                 .
                 append(descripcion)
                 .
                 append(", Precio: ")
                 .
                 append(precio)
                 .
                 append(", Cantidad en Stock: ")
                 .
                 append(cantidad)
                 .
                 append("\n");
                 
        	}	
        }
        catch (SQLException e) {
        	e.printStackTrace();
        	return "Error al obtener el listado de articulos.";
        }
		
		return resultado.length() > 0 ? resultado.toString() : "No hay articulos disponibles";
	}
	
	public void CrearArticulo(String DescripcionArticulo, double PrecioArticulo, int CantidadArticulo) {
	    String query = "INSERT INTO articulos (descripcion, precioarticulo, cantidadstock) VALUES (?, ?, ?)";

	    try (Connection con = getConnection();
	         PreparedStatement pstmt = con.prepareStatement(query)) {
	        
	        // Estableciendo los valores de los parámetros
	        pstmt.setString(1, DescripcionArticulo);
	        pstmt.setDouble(2, PrecioArticulo);
	        pstmt.setInt(3, CantidadArticulo);

	        // Ejecutando la consulta de inserción
	        pstmt.executeUpdate();
	        
	        System.out.println("Articulo creado exitosamente.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error al crear el articulo.");
	    }
	}
	
	// Método que asume que tienes una lista de artículos en tu interfaz de usuario
	public int obtenerIdArticuloSeleccionado(JList<String> listaArticulos) {
	    int selectedIndex = listaArticulos.getSelectedIndex();
	    if (selectedIndex != -1) {
	        // Suponiendo que el formato de cada elemento en la lista es "idarticulo - Descripcion"
	        String articuloSeleccionado = listaArticulos.getModel().getElementAt(selectedIndex);
	        // Extraer el idarticulo del texto (asumiendo que está antes de un guión)
	        int idArticulo = Integer.parseInt(articuloSeleccionado.split(" - ")[0]);
	        return idArticulo;
	    } else {
	        System.out.println("No se ha seleccionado ningún artículo.");
	        return -1; // Indica que no se ha seleccionado un artículo
	    }
	}

	
	public void EliminarArticulo(int idArticulo) {
	    String query = "DELETE FROM articulos WHERE idarticulo = ?";

	    try (Connection con = getConnection();
	         PreparedStatement pstmt = con.prepareStatement(query)) {
	        
	        // Estableciendo el valor del parámetro
	        pstmt.setInt(1, idArticulo);

	        // Ejecutando la consulta de eliminación
	        int rowsAffected = pstmt.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            System.out.println("Articulo eliminado exitosamente.");
	        } else {
	            System.out.println("No se encontró un articulo con el ID proporcionado.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error al eliminar el articulo.");
	    }
	}

	public static List<String> obtenerArticulos() {
	    // Método para obtener la lista de artículos
	    List<String> articulos = new ArrayList<>();
	    try (Connection con = getConnection();
	         PreparedStatement pstmt = con.prepareStatement("SELECT idarticulo, descripcion FROM articulos");
	         ResultSet rs = pstmt.executeQuery()) {

	        while (rs.next()) {
	            int idArticulo = rs.getInt("idarticulo");
	            String descripcion = rs.getString("descripcion");
	            articulos.add(idArticulo + " - " + descripcion);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return articulos;
	}

	public static void CrearTicket(List<Integer> idsArticulos, String descripcion) {
	    String insertarTicketSQL = "INSERT INTO tickets (totalTicket, fechatTicket) VALUES (?, NOW())";
	    String insertarRelacionSQL = "INSERT INTO ticket_articulo (id_ticket, id_articulo) VALUES (?, ?)";

	    try (Connection con = getConnection()) {
	        // Iniciar transacción
	        con.setAutoCommit(false);

	        // Calcular el total del ticket
	        double totalTicket = calcularTotalArticulos(idsArticulos);

	        // Insertar ticket
	        try (PreparedStatement pstmtTicket = con.prepareStatement(insertarTicketSQL, Statement.RETURN_GENERATED_KEYS)) {
	            pstmtTicket.setDouble(1, totalTicket); // Pasar el total del ticket
	            pstmtTicket.executeUpdate();

	            // Obtener el ID generado
	            int idTicket;
	            try (ResultSet generatedKeys = pstmtTicket.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    idTicket = generatedKeys.getInt(1);
	                } else {
	                    throw new SQLException("No se pudo obtener el ID del ticket.");
	                }
	            }

	            // Insertar relación entre ticket y artículos
	            try (PreparedStatement pstmtRelacion = con.prepareStatement(insertarRelacionSQL)) {
	                for (int idArticulo : idsArticulos) {
	                    pstmtRelacion.setInt(1, idTicket);
	                    pstmtRelacion.setInt(2, idArticulo);
	                    pstmtRelacion.addBatch(); // Agregar a batch para ejecutar en bloque
	                }
	                pstmtRelacion.executeBatch(); // Ejecutar todos los inserts de relación
	            }

	            // Confirmar transacción
	            con.commit();
	            System.out.println("Ticket creado correctamente con ID: " + idTicket);
	        } catch (SQLException e) {
	            con.rollback(); // Revertir cambios en caso de error
	            throw e;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	// Método para calcular el total de los artículos seleccionados
	private static double calcularTotalArticulos(List<Integer> idsArticulos) {
	    double total = 0.0;
	    // Aquí deberías tener una consulta para obtener el precio de cada artículo
	    try (Connection con = getConnection()) {
	        String consultaPrecioSQL = "SELECT precioarticulo FROM articulos WHERE idarticulo = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(consultaPrecioSQL)) {
	            for (int idArticulo : idsArticulos) {
	                pstmt.setInt(1, idArticulo);
	                try (ResultSet rs = pstmt.executeQuery()) {
	                    if (rs.next()) {
	                        total += rs.getDouble("precioarticulo");
	                    }
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return total;
	}


	public static String ListadoTickets() {
	    String query = "SELECT * FROM tickets;";
	    StringBuilder resultad = new StringBuilder(); // Se inicializa vacío
	    
	    try (Connection con = getConnection();
	         PreparedStatement stmt = con.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {
	        
	        while (rs.next()) {
	            int idTicket = rs.getInt("idticket");
	            double totalTicket = rs.getDouble("totalTicket");
	            java.sql.Date fechaTicket = rs.getDate("fechatTicket");
	            
	            resultad
	                .append("ID Ticket: ")
	                .append(idTicket)
	                .append(", Total: ")
	                .append(totalTicket)
	                .append(", Fecha: ")
	                .append(fechaTicket)
	                .append("\n");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return resultad.toString(); // Se devuelve la cadena concatenada
	}



	public void modificarArticulo(int idArticulo, String descripcion, double precio, int cantidad) throws SQLException {
        String sqlUpdate = "UPDATE articulos SET descripcion = ?, precioArticulo = ?, cantidadstock = ? WHERE idArticulo = ?";
        
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(sqlUpdate)) {
            
            pstmt.setString(1, descripcion);
            pstmt.setDouble(2, precio);
            pstmt.setInt(3, cantidad);
            pstmt.setInt(4, idArticulo);
            
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Artículo modificado correctamente.");
            } else {
                System.out.println("No se encontró el artículo con el ID especificado.");
            }
        }
	}
}
