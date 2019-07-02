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
		
		FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
		List<Direccion> lstDireccionesUsuarioWeb = null;
		if(Constantes.TIPOUSUARIO_SIGLA_EMPRESA.equals(usuarioWebSession.getTipoUsuarioWeb().getId())) {
			lstDireccionesUsuarioWeb = usuarioWebSession.getEmpresa().getDirecciones();
			filtroDivGeografica.setCodigoPais(usuarioWebSession.getEmpresa().getPais().getCodigoPais());
		} else {
			lstDireccionesUsuarioWeb = usuarioWebSession.getUsuario().getDirecciones();
			filtroDivGeografica.setCodigoPais(usuarioWebSession.getUsuario().getPais().getCodigoPais());
		}
		
		List<Direccion> direcciones = getUsuarioEjbRemote().asignarComunaDireccion(lstDireccionesUsuarioWeb);
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_DIRECCION_TIPO);
		List<Tupla> tipsDirecciones = getCommonEjbRemote().getParameter(filtroCatalogo);
		
		List<Pais> paises = getCommonEjbRemote().getPais(filtroDivGeografica);
		
		getRequest().put("direcciones", direcciones);
		getRequest().put("tipsDirecciones", tipsDirecciones);
		getRequest().put("comunas", new ArrayList<Comuna>());
		getRequest().put("ciudades", new ArrayList<Ciudad>());
		getRequest().put("regiones", new ArrayList<Region>());
		getRequest().put("paises", paises);

		return SUCCESS;
	}

	public String actualizaDireccion() {
		// TODO
		// VALIDAR CAMPOS
		String codigoTitular = "";
		UsuarioWeb usuarioWebSession = ((UsuarioWeb)getSession().get("usuarioWeb"));
		
		if(Constantes.TIPOUSUARIO_SIGLA_EMPRESA.equals(usuarioWebSession.getTipoUsuarioWeb().getId())) {
			codigoTitular = usuarioWebSession.getEmpresa().getCodigoEmpresa();
		} else {
			codigoTitular = usuarioWebSession.getUsuario().getCodigoUsuario();
		}
		
		Integer resultado = getUsuarioEjbRemote().actualizaDireccion(direccion, codigoTitular);
		
		if (resultado != null && resultado != 0) {
			FiltroDireccion filtroDireccion = new FiltroDireccion();
			filtroDireccion.setCodigoTitular(codigoTitular);
			List<Direccion> direcciones = getUsuarioEjbRemote().getDirecciones(filtroDireccion);

			if(Constantes.TIPOUSUARIO_SIGLA_EMPRESA.equals(usuarioWebSession.getTipoUsuarioWeb().getId())) {
				usuarioWebSession.getEmpresa().setDirecciones(direcciones);
			} else {
				usuarioWebSession.getUsuario().setDirecciones(direcciones);
			}
			
			this.getSession().put("usuarioWeb", usuarioWebSession);
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
