package com.auctionnow.controller.usuario;

 import java.util.List;

import com.auctionnow.common.Ciudad;
import com.auctionnow.common.Comuna;
import com.auctionnow.common.Constantes;
import com.auctionnow.common.Pais;
import com.auctionnow.common.Region;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.exception.AuctionNowServiceException;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroDivGeografica;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.UsuarioWeb;

public class UsuarioClienteActualizarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected UsuarioWeb usuarioWeb;
	protected Cliente cliente;
	protected Direccion direccion;
	protected Contacto contacto;

	public String showActualizaUsuarioCliente() throws AuctionNowServiceException {

		UsuarioWeb usuarioWebSession = (UsuarioWeb) getSession().get("usuarioWeb");
		
		List<Direccion> direcciones = getUsuarioEjbRemote().asignarComunaDireccion(usuarioWebSession.getUsuario().getDirecciones());
		usuarioWebSession.getUsuario().setDirecciones(direcciones);

		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_DIRECCION_TIPO);
		List<Tupla> tipsDirecciones = getCommonEjbRemote().getParameter(filtroCatalogo);

		filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_CONTACTO_TIPO);
		List<Tupla> tipsContactos = getCommonEjbRemote().getParameter(filtroCatalogo);

		filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_GENERO);
		List<Tupla> generos = getCommonEjbRemote().getParameter(filtroCatalogo);

		FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
		List<Pais> paises = getCommonEjbRemote().getPais(filtroDivGeografica);
		List<Region> regiones = getCommonEjbRemote().getRegion(filtroDivGeografica);
		List<Ciudad> ciudades = getCommonEjbRemote().getCiudad(filtroDivGeografica);
		List<Comuna> comunas= getCommonEjbRemote().getComuna(filtroDivGeografica);
		
		//SE SETEA USUARIO WEB PARA DESPLEGAR INFO EN LA PAGINA JSP
		setUsuarioWeb(usuarioWebSession);
		
		getRequest().put("tipsDirecciones", tipsDirecciones);
		getRequest().put("tipsContactos", tipsContactos);
		getRequest().put("generos", generos);
		getRequest().put("comunas", comunas);
		getRequest().put("ciudades", ciudades);
		getRequest().put("regiones", regiones);
		getRequest().put("paises", paises);
		getRequest().put("fechaNacimientoFormat", this.getFechaFormat(usuarioWebSession.getUsuario().getFechaNacimiento()));

		return SUCCESS;
	}

	public String actualizaUsuarioWebCliente() throws AuctionNowServiceException {
		// VALIDAR CAMPOS
		UsuarioWeb updateUsuarioWeb = (UsuarioWeb) getSession().get("usuarioWeb");
		
		updateUsuarioWeb.getUsuario().setNombre(cliente.getNombre().trim());
		updateUsuarioWeb.getUsuario().setApellidoPaterno(cliente.getApellidoPaterno().trim());
		updateUsuarioWeb.getUsuario().setApellidoMaterno(cliente.getApellidoMaterno().trim());
		updateUsuarioWeb.getUsuario().setRut(cliente.getRut().trim());
		updateUsuarioWeb.getUsuario().setRutDV(cliente.getRutDV().trim());
		updateUsuarioWeb.getUsuario().setGenero(cliente.getGenero());
		updateUsuarioWeb.getUsuario().setFechaNacimiento(cliente.getFechaNacimiento());
		
		updateUsuarioWeb.setContrasena(usuarioWeb.getContrasena().trim());
		updateUsuarioWeb.setRespuesta1(usuarioWeb.getRespuesta1().trim());
		updateUsuarioWeb.setRespuesta2(usuarioWeb.getRespuesta2().trim());
		updateUsuarioWeb.setRespuesta3(usuarioWeb.getRespuesta3().trim());
		updateUsuarioWeb.setFirmaComentario(usuarioWeb.getFirmaComentario().trim());

		Integer resultado = getUsuarioEjbRemote().actualizaCuentaUsuarioCliente(updateUsuarioWeb);
		if (resultado != null && resultado != 0) {
			getSession().remove("usuarioWeb");
			getSession().put("usuarioWeb", updateUsuarioWeb);
		}

		return SUCCESS;
	}

	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
}
