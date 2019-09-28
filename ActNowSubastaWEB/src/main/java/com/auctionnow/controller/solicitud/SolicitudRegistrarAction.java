package com.auctionnow.controller.solicitud;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.auctionnow.common.Constantes;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroCliente;
import com.auctionnow.filters.FiltroDireccion;
import com.auctionnow.filters.FiltroRubro;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.filters.FiltroSolicitud;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.Proveedor;
import com.auctionnow.model.Rubro;
import com.auctionnow.model.Servicio;
import com.auctionnow.model.Solicitud;
import com.auctionnow.model.Subasta;
import com.auctionnow.model.UsuarioWeb;

public class SolicitudRegistrarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Solicitud solicitud;
	protected Servicio servicio;
	protected Direccion direccion;
	protected Contacto contacto;
	
	protected String activarSolicitud;
	protected Subasta subasta;
	protected String codigoSolicitud;

	public String showAddSolicitud() {
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();

		Cliente cliente = (Cliente) ((UsuarioWeb) getSession().get("usuarioWeb")).getUsuario();
		List<Direccion> direcciones = getUsuarioEjbRemote().asignarComunaDireccion(cliente.getDirecciones());
		List<Contacto> contactos = cliente.getContactos();

		FiltroRubro filtroRubro = new FiltroRubro();
		List<Rubro> lstRubros = getTransaccionEjbRemote().getRubros(filtroRubro);

		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_TIPO_FECHA);
		List<Tupla> tipoFechas = getCommonEjbRemote().getParameters(filtroCatalogo);
		
		getRequest().put("tipoFechas", tipoFechas);
		getRequest().put("rubros", lstRubros);
		getRequest().put("direcciones", direcciones);
		getRequest().put("contactos", contactos);
		getRequest().put("serviciosActivosByRubro", new ArrayList<Servicio>());

		return Constantes.SUCCESS;
	}

	public String addSolicitud() {
		// VALIDAR CAMPOS
		Cliente cliente = (Cliente) ((UsuarioWeb) getSession().get("usuarioWeb")).getUsuario();
		
		solicitud.setCliente(cliente);
		solicitud.setServicio(servicio);
		solicitud.setDireccion(direccion);
		solicitud.setContacto(contacto);

		Integer regSolicitud = getSolicitudEjbRemote().addSolicitud(solicitud);

		if (Constantes.ACTIVO.equals(solicitud.getActivo()) && (regSolicitud != null && regSolicitud > 0)) {
			Subasta subasta = new Subasta();
			
			// Enviar correo de Notificacion a los Proveedores e Iniciar subasta
			subasta = getSolicitudEjbRemote().iniciarSubasta(solicitud, subasta);
		}

		return SUCCESS;
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

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
}
