package com.auctionnow.controller.solicitud;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.auctionnow.common.Ciudad;
import com.auctionnow.common.Comuna;
import com.auctionnow.common.Constantes;
import com.auctionnow.common.Pais;
import com.auctionnow.common.Region;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroCliente;
import com.auctionnow.filters.FiltroDireccion;
import com.auctionnow.filters.FiltroDivGeografica;
import com.auctionnow.filters.FiltroRubro;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.filters.FiltroSolicitud;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.Empresa;
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
		
		UsuarioWeb usuarioWebSession = ((UsuarioWeb)getSession().get("usuarioWeb"));
		
		List<Direccion> lstDireccionesUsuarioWeb = null;
		List<Contacto> contactos = null;
		
		if(usuarioWebSession != null && usuarioWebSession.getTipoUsuarioWeb() != null 
				&& Constantes.TIPOUSUARIO_SIGLA_EMPRESA.equals(usuarioWebSession.getTipoUsuarioWeb().getId())) {
			Empresa empresa = usuarioWebSession.getEmpresa();
			contactos = empresa.getContactos();
			lstDireccionesUsuarioWeb = (empresa.getDirecciones() != null ? empresa.getDirecciones() : new ArrayList<Direccion>());
		} else {
			Cliente cliente = (Cliente) usuarioWebSession.getUsuario();
			contactos = cliente.getContactos();
			lstDireccionesUsuarioWeb = (cliente.getDirecciones() != null ? cliente.getDirecciones() : new ArrayList<Direccion>());
		}
		
		List<Direccion> direcciones = getUsuarioEjbRemote().asignarComunaDireccion(lstDireccionesUsuarioWeb);

		FiltroRubro filtroRubro = new FiltroRubro();
		List<Rubro> lstRubros = getTransaccionEjbRemote().getRubros(filtroRubro);
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_TIPO_FECHA);
		List<Tupla> tipoFechas = getCommonEjbRemote().getParameters(filtroCatalogo);
		
		getRequest().put("tipoFechas", tipoFechas);
		getRequest().put("rubros", lstRubros);
		getRequest().put("direcciones", direcciones);
		getRequest().put("contactos", contactos);
		getRequest().put("serviciosActivosByRubro", new ArrayList<Servicio>());
		
		
		//PARA MODAL CONTACTO
		{
			filtroCatalogo = new FiltroCatalogo();
			filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_CONTACTO_TIPO);
			List<Tupla> lstTipContactos = getCommonEjbRemote().getParameters(filtroCatalogo);
			
			getRequest().put("tipsContactos", lstTipContactos);
		}
		
		// PARA MODAL DIRECCION
		{
			filtroCatalogo = new FiltroCatalogo();
			filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_DIRECCION_TIPO);
			List<Tupla> tipsDirecciones = getCommonEjbRemote().getParameters(filtroCatalogo);
			
			FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
			List<Pais> paises = getCommonEjbRemote().getPais(filtroDivGeografica);
			
			getRequest().put("tipsDirecciones", tipsDirecciones);
			getRequest().put("comunas", new ArrayList<Comuna>());
			getRequest().put("ciudades", new ArrayList<Ciudad>());
			getRequest().put("regiones", new ArrayList<Region>());
			getRequest().put("paises", paises);
		}

		return Constantes.SUCCESS;
	}

	public String addSolicitud() {
		// VALIDAR CAMPOS
		UsuarioWeb usuarioWebSolicitud = ((UsuarioWeb) getSession().get("usuarioWeb"));
		Cliente cliente = (Cliente) usuarioWebSolicitud.getUsuario();
		
		solicitud.setUsuarioWeb(usuarioWebSolicitud);
		solicitud.setCliente(cliente);
		solicitud.setServicio(servicio);
		solicitud.setDireccion(direccion);
		solicitud.setContacto(contacto);

		Integer regSolicitud = null;
		Subasta subastaIniciada = null;

		if (Constantes.ACTIVO.equals(solicitud.getActivo())) {
			subastaIniciada = getSolicitudEjbRemote().iniciarSubasta(solicitud);
		} else {
			regSolicitud = getSolicitudEjbRemote().addSolicitud(solicitud);
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
