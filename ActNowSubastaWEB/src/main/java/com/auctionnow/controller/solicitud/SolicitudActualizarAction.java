package com.auctionnow.controller.solicitud;

import java.util.Date;
import java.util.List;
import com.auctionnow.common.Constantes;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroSolicitud;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.Servicio;
import com.auctionnow.model.Solicitud;
import com.auctionnow.model.Subasta;
import com.auctionnow.model.UsuarioWeb;

public class SolicitudActualizarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Solicitud solicitud;
	protected Subasta subasta;
	protected String activarSolicitud;
	protected String codigoSolicitud;

	public String showActualizaSolicitudes() {
		Cliente cliente = (Cliente) ((UsuarioWeb) getSession().get("usuarioWeb")).getUsuario();
		List<Direccion> direcciones = cliente.getDirecciones();

		FiltroSolicitud filtroSolicitud = new FiltroSolicitud();
		filtroSolicitud.setCodigoCliente(cliente.getCodigoCliente());
		List<Solicitud> solicitudes = getSolicitudEjbRemote().getSolicitudes(filtroSolicitud);

		getRequest().put("solicitudes", solicitudes);
		getRequest().put("direcciones", direcciones);

		return Constantes.SUCCESS;
	}

	public String showDetalleActualizaSolicitud() {

		Cliente cliente = (Cliente) ((UsuarioWeb) getSession().get("usuarioWeb")).getUsuario();
		
		FiltroSolicitud filtroSolicitud = new FiltroSolicitud();
		filtroSolicitud.setCodigoSolicitud(codigoSolicitud);
		filtroSolicitud.setCodigoCliente(cliente.getCodigoCliente());
		Solicitud solicitud = getSolicitudEjbRemote().getSolicitud(filtroSolicitud);

		getRequest().put("solicitud", solicitud);
		getRequest().put("cliente", cliente);
		
		return Constantes.SUCCESS;
	}

	public String actualizaSolicitud() {
		// TODO
		// VALIDAR CAMPOS

		/// PRUEBA
		setActivarSolicitud("S");

		solicitud = new Solicitud();
		solicitud.setCodigoSolicitud("SOL0002");
		solicitud.setDescripcion("Servicio de Peluqueria a Domicilio");
		solicitud.setFechaCreacion(new Date());
		solicitud.setFechaVencimiento(new Date());
		solicitud.setPrecioEsperado(new Long("9000"));
		solicitud.setPrioridad(5);

		Servicio servicio = new Servicio();
		servicio.setCodigoServicio("SER006");
		solicitud.setServicio(servicio);

		Direccion direccion = new Direccion();
		direccion.setCodigoDireccion("34");
		solicitud.setDireccion(direccion);
		//////////

		if ("N".equalsIgnoreCase(getActivarSolicitud())) {
			solicitud.setEstadoSolicitud("C");
		} else {
			solicitud.setEstadoSolicitud("A");
		}

		Cliente cliente = (Cliente) ((UsuarioWeb) getSession().get("usuarioWeb")).getUsuario();
		solicitud.setCliente(cliente);
		
		FiltroSolicitud filtroSolicitud = new FiltroSolicitud();
		filtroSolicitud.setCodigoSolicitud(solicitud.getCodigoSolicitud());
		Solicitud solicitudExiste = getSolicitudEjbRemote().getSolicitud(filtroSolicitud);
		
		Integer updSolicitud = getSolicitudEjbRemote().actualizaSolicitud(solicitud);
		
		if ((solicitudExiste != null && "C".equals(solicitudExiste.getEstadoSolicitud())) 
				&& "S".equalsIgnoreCase(getActivarSolicitud()) && updSolicitud != null && updSolicitud > 0) {

			/////// PRUEBA
			subasta = new Subasta();
			subasta.setDuracion("2");
			subasta.setMontoMinimo(new Long("500"));
			subasta.setDescripcion("gdsgfsfg");
			///////////////////

			// Enviar correo de Notificacion a los Proveedores e Iniciar subasta
			subasta = getSolicitudEjbRemote().iniciarSubasta(solicitud, subasta);
		}

		return Constantes.SUCCESS;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public String getActivarSolicitud() {
		return activarSolicitud;
	}

	public void setActivarSolicitud(String activarSolicitud) {
		this.activarSolicitud = activarSolicitud;
	}

	public String getCodigoSolicitud() {
		return codigoSolicitud;
	}

	public void setCodigoSolicitud(String codigoSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
	}

	public Subasta getSubasta() {
		return subasta;
	}

	public void setSubasta(Subasta subasta) {
		this.subasta = subasta;
	}

}
