package com.auctionnow.controller.usuario;

import java.util.ArrayList;
import java.util.List;

import com.auctionnow.common.Ciudad;
import com.auctionnow.common.Comuna;
import com.auctionnow.common.Constantes;
import com.auctionnow.common.Pais;
import com.auctionnow.common.Region;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroDireccion;
import com.auctionnow.filters.FiltroDivGeografica;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.UsuarioWeb;

public class DireccionActualizarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Direccion direccion;

	public String showActualizaDireccion() {
		
		UsuarioWeb usuarioWebSession = ((UsuarioWeb)getSession().get("usuarioWeb"));

		List<Direccion> direcciones = getUsuarioEjbRemote().asignarComunaDireccion(usuarioWebSession.getUsuario().getDirecciones());
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_DIRECCION_TIPO);
		List<Tupla> tipsDirecciones = getCommonEjbRemote().getParameter(filtroCatalogo);

		FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
		List<Pais> paises = getCommonEjbRemote().getPais(filtroDivGeografica);
		
		List<Region> regiones = getCommonEjbRemote().getRegion(filtroDivGeografica);
		List<Ciudad> ciudades = getCommonEjbRemote().getCiudad(filtroDivGeografica);
		List<Comuna> comunas= getCommonEjbRemote().getComuna(filtroDivGeografica);
		
		getRequest().put("direcciones", direcciones);
		getRequest().put("tipsDirecciones", tipsDirecciones);
		getRequest().put("comunas", comunas);
		getRequest().put("ciudades", ciudades);
		getRequest().put("regiones", regiones);
		getRequest().put("paises", paises);

		return SUCCESS;
	}

	public String actualizaDireccion() {
		// TODO
		// VALIDAR CAMPOS

		String codigoTitular = String.valueOf(((UsuarioWeb) getSession().get("usuarioWeb")).getUsuario().getCodigoUsuario());
		Integer resultado = getUsuarioEjbRemote().actualizaDireccion(direccion, codigoTitular);
		
		if (resultado != null && resultado != 0) {
			FiltroDireccion filtroDireccion = new FiltroDireccion();
			filtroDireccion.setCodigoTitular(codigoTitular);
			List<Direccion> direcciones = getUsuarioEjbRemote().getDirecciones(filtroDireccion);

			UsuarioWeb usuarioWebSession = ((UsuarioWeb) getSession().get("usuarioWeb"));
			usuarioWebSession.getUsuario().setDirecciones(direcciones);

			getSession().remove("usuarioWeb");
			getSession().put("usuarioWeb", usuarioWebSession);
		}
		
		return SUCCESS;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

}
