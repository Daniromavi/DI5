package es.studium.Modelo;

public class Articulo {
	private int idArticulo;
	private String descripcion;
	private double precioArticulo;
	private int cantidadStock;

	// Constructor
	public Articulo(int idArticulo, String descripcion, double precioArticulo, int cantidadStock) {
		this.idArticulo = idArticulo;
		this.descripcion = descripcion;
		this.precioArticulo = precioArticulo;
		this.cantidadStock = cantidadStock;
	}

	// Getters y Setters
	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioArticulo() {
		return precioArticulo;
	}

	public void setPrecioArticulo(double precioArticulo) {
		this.precioArticulo = precioArticulo;
	}

	public int getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}
}
