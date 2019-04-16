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

public class DireccionRegistrarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Direccion direccion;

	public String showAddDireccion() {
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_DIRECCION_TIPO);
		List<Tupla> tipsDirecciones = getCommonEjbRemote().getParameter(filtroCatalogo);
		
		FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
		List<Pais> paises = getCommonEjbRemote().getPais(filtroDivGeografica);
		
		getRequest().put("tipsDirecciones", tipsDirecciones);
		getRequest().put("comunas", new ArrayList<Comuna>());
		getRequest().put("ciudades", new ArrayList<Ciudad>());
		getRequest().put("regiones", new ArrayList<Region>());
		getRequest().put("paises", paises);
		
		return Constantes.SUCCESS;
	}

	public String addDireccion() {
		// TODO
		// VALIDAR CAMPOS
		
		String codigoTitular = ((UsuarioWeb)getSession().get("usuarioWeb")).getUsuario().getCodigoUsuario();
		Integer resultado = getUsuarioEjbRemote().addDireccion(direccion, codigoTitular);
		
		// ACTUALIZAR SESSION CON ULTIMA DIRECCION REGISTRADA
		FiltroDireccion filtroDireccion = new FiltroDireccion();
		filtroDireccion.setCodigoTitular(codigoTitular);
		List<Direccion> direcciones = getUsuarioEjbRemote().getDirecciones(filtroDireccion);
		
		UsuarioWeb usuWeb = (UsuarioWeb) getSession().get("usuarioWeb");
		usuWeb.getUsuario().setDirecciones(direcciones);
		this.getSession().put("usuarioWeb", usuWeb);
		
		return Constantes.SUCCESS;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
}
