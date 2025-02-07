package es.studium.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.studium.Modelo.ModeloArticulos;
import es.studium.Modelo.ModeloTickets;
import es.studium.Vista.*;

public class ControladorMenuPrincipal implements ActionListener {

	private VistaMenuPrincipal vistaMenuPrincipal;

	public ControladorMenuPrincipal(VistaMenuPrincipal vistaMenuPrincipal) {
		this.vistaMenuPrincipal = vistaMenuPrincipal;
		this.vistaMenuPrincipal.getMntmAltaArticulos().addActionListener(this);
		this.vistaMenuPrincipal.getMntmBajaArticulos().addActionListener(this);
		this.vistaMenuPrincipal.getMntmListadoArticulos().addActionListener(this);
		this.vistaMenuPrincipal.getMntmModificarArticulos().addActionListener(this);
		this.vistaMenuPrincipal.getMntmAltaTickets().addActionListener(this);
		this.vistaMenuPrincipal.getMntmListadoTickets().addActionListener(this);
		this.vistaMenuPrincipal.getMntmGenerarInformeTickets().addActionListener(this);
		this.vistaMenuPrincipal.getMntmGenerarInformeArticulos().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		switch (comando) {
		case "AltaArticulos":
			// Abre la ventana de alta de artículos
			VistaAltaArticulos vistaAltaArticulos = new VistaAltaArticulos();
			vistaAltaArticulos.setVisible(true);

			// Crear el controlador para manejar los eventos de la vista
			ModeloArticulos modeloArticulosAlta = new ModeloArticulos();
			ControladorAltaArticulos controladorAltaArticulos = new ControladorAltaArticulos(vistaAltaArticulos,
					modeloArticulosAlta);
			break;

		case "BajaArticulos":
			// Abre la ventana de eliminación de artículos
			VistaEliminarArticulos vistaEliminarArticulos = new VistaEliminarArticulos();
			ModeloArticulos modeloArticulosBaja = new ModeloArticulos();
			ControladorBajaArticulos controladorBajaArticulos = new ControladorBajaArticulos(vistaEliminarArticulos,
					modeloArticulosBaja);
			vistaEliminarArticulos.setVisible(true);
			break;

		case "ListadoArticulos":
			// Abre la ventana de listado de artículos
			VistaListadoArticulos vistaListadoArticulos = new VistaListadoArticulos();
			ModeloArticulos modeloArticulosListado = new ModeloArticulos();
			ControladorListadoArticulos controladorListadoArticulos = new ControladorListadoArticulos(
					vistaListadoArticulos, modeloArticulosListado);
			vistaListadoArticulos.setVisible(true);
			break;

		case "ModificarArticulos":
			// Abre la ventana de modificación de artículos
			VistaModificarArticulos vistaModificarArticulos = new VistaModificarArticulos();
			vistaModificarArticulos.setVisible(true);
			break;

		case "AltaTickets":
			// Abre la ventana de alta de tickets
			VistaAltaTickets vistaAltaTickets = new VistaAltaTickets();
			vistaAltaTickets.setVisible(true);
			break;

		case "ListadoTickets":
			// Abre la ventana de listado de tickets
			VistaListadoTickets vistaListadoTickets = new VistaListadoTickets();
			vistaListadoTickets.setVisible(true);
			break;

		case "GenerarInformeTickets":
			// Abre la ventana para generar el informe de tickets
			VistaGenerarInformeTickets vistaGenerarInformeTickets = new VistaGenerarInformeTickets();
			vistaGenerarInformeTickets.setVisible(true);

			// Crear el controlador para manejar los eventos de la vista
			ModeloTickets modeloTickets = new ModeloTickets();
			ControladorGenerarInformeTickets controladorGenerarInformeTickets = new ControladorGenerarInformeTickets(
					vistaGenerarInformeTickets, modeloTickets);
			break;
		case "GenerarInformeArticulos":
			// Abre la ventana para generar el informe de artículos
			VistaGenerarInformeArticulos vistaGenerarInformeArticulos = new VistaGenerarInformeArticulos();
			vistaGenerarInformeArticulos.setVisible(true);

			// Crear el controlador para manejar los eventos de la vista
			ModeloArticulos modeloArticulosInforme = new ModeloArticulos();
			ControladorGenerarInformeArticulos controladorGenerarInformeArticulos = new ControladorGenerarInformeArticulos(
					vistaGenerarInformeArticulos, modeloArticulosInforme);
			break;

		default:
			break;
		}
	}
}
