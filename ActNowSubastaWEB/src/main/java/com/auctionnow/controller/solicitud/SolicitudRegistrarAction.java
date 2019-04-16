package com.auctionnow.controller.solicitud;

import java.util.Date;
import java.util.List;
import com.auctionnow.common.Constantes;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroCliente;
import com.auctionnow.filters.FiltroDireccion;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.filters.FiltroSolicitud;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.Proveedor;
import com.auctionnow.model.Servicio;
import com.auctionnow.model.Solicitud;
import com.auctionnow.model.Subasta;
import com.auctionnow.model.UsuarioWeb;

public class SolicitudRegistrarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Servicio servicio;
	protected Solicitud solicitud;
	protected Direccion direccion;
	protected String activarSolicitud;
	protected Subasta subasta;
	protected String codigoSolicitud;

	public String showAddSolicitud() {
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();

		Cliente cliente = (Cliente) ((UsuarioWeb) getSession().get("usuarioWeb")).getUsuario();
		List<Direccion> direcciones = getUsuarioEjbRemote().asignarComunaDireccion(cliente.getDirecciones());

		// filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SERVICIO_TIPO);
		List<Tupla> tipsServicios = getCommonEjbRemote().getParameter(filtroCatalogo);

		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_NIVEL_PRIORIDAD);
		List<Tupla> prioridades = getCommonEjbRemote().getParameter(filtroCatalogo);

		getRequest().put("tipsServicios", tipsServicios);
		getRequest().put("prioridades", prioridades);
		getRequest().put("direcciones", direcciones);

		return Constantes.SUCCESS;
	}

	public String addSolicitud() {
		// VALIDAR CAMPOS

		/// PRUEBA
		// setActivarSolicitud("N");

		// solicitud = new Solicitud();
		// solicitud.setDescripcion("Servicio de cerrajeria");
		// solicitud.setFechaVencimiento(new Date());
		// solicitud.setPrecioEsperado(new Long("33000"));
		// solicitud.setPrioridad(1);
		//
		// Servicio servicio = new Servicio();
		// servicio.setCodigoServicio("SER002");
		// solicitud.setServicio(servicio);
		//
		// Direccion direccion = new Direccion();
		// direccion.setCodigoDireccion("34");
		// solicitud.setDireccion(direccion);
		//////////

		solicitud.setFechaCreacion(new Date());

		// CREACION DE CODIGO
		solicitud.setCodigoSolicitud("SOL0002");

		if ("off".equalsIgnoreCase(getActivarSolicitud())) {
			solicitud.setEstadoSolicitud("C");
		} else {
			solicitud.setEstadoSolicitud("A");
		}

		Cliente cliente = (Cliente) ((UsuarioWeb) getSession().get("usuarioWeb")).getUsuario();
		solicitud.setCliente(cliente);

		Integer regSolicitud = getSolicitudEjbRemote().addSolicitud(solicitud);

		if ("on".equalsIgnoreCase(getActivarSolicitud()) && regSolicitud != null && regSolicitud > 0) {

			/////// PRUEBA
			// subasta = new Subasta();
			// subasta.setDuracion("2");

			///////////////////

			subasta.setMontoMinimo(solicitud.getPrecioEsperado());
			subasta.setDescripcion(solicitud.getDescripcion());

			// Enviar correo de Notificacion a los Proveedores e Iniciar subasta
			subasta = getSolicitudEjbRemote().iniciarSubasta(solicitud, subasta);
		}

		return Constantes.SUCCESS;
	}

	public void showDetalleSolicitud() {

		//// PRUEBA
		setCodigoSolicitud("SOL0002");
		/////

		FiltroSolicitud filtroSolicitud = new FiltroSolicitud();
		filtroSolicitud.setCodigoSolicitud(codigoSolicitud);
		Solicitud solicitud = getSolicitudEjbRemote().getSolicitud(filtroSolicitud);

		UsuarioWeb usuarioWeb = (UsuarioWeb) getSession().get("usuarioWeb");
		if (usuarioWeb != null && usuarioWeb.getUsuario() instanceof Proveedor) {
			FiltroCliente filtroCliente = new FiltroCliente();
			filtroCliente.setCodigoCliente(solicitud.getCliente().getCodigoCliente());
			Cliente cliente = getUsuarioEjbRemote().getCliente(filtroCliente);

			solicitud.setCliente(cliente);
		}

		FiltroServicio filtroServicio = new FiltroServicio();
		filtroServicio.setCodigoServicio(solicitud.getServicio().getCodigoServicio());
		Servicio servicio = getTransaccionEjbRemote().getServicio(filtroServicio);

		FiltroDireccion filtroDireccion = new FiltroDireccion();
		filtroDireccion.setCodigoDireccion(solicitud.getDireccion().getCodigoDireccion());
		Direccion direccion = getUsuarioEjbRemote().getDireccion(filtroDireccion);

		solicitud.setDireccion(direccion);
		solicitud.setServicio(servicio);

		getRequest().put("solicitud", solicitud);

		return;
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

	public Subasta getSubasta() {
		return subasta;
	}

	public void setSubasta(Subasta subasta) {
		this.subasta = subasta;
	}

	public String getCodigoSolicitud() {
		return codigoSolicitud;
	}

	public void setCodigoSolicitud(String codigoSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}
