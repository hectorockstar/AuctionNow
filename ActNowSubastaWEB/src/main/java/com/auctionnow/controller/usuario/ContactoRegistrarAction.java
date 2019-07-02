package com.auctionnow.controller.usuario;

import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroContacto;
import com.auctionnow.filters.FiltroDivGeografica;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.UsuarioWeb;

public class ContactoRegistrarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Contacto contacto;

	public String showAddContacto() {
		
		//VALIDAR QUE HAYAN DIRECCIONES REGISTRADAS PARA AGREGAR CONTACTOS
		
		UsuarioWeb usuarioWebSession = ((UsuarioWeb)getSession().get("usuarioWeb"));
		
		List<Direccion> lstDireccionesUsuarioWeb = null;
		if(Constantes.TIPOUSUARIO_SIGLA_EMPRESA.equals(usuarioWebSession.getTipoUsuarioWeb().getId())) {
			lstDireccionesUsuarioWeb = usuarioWebSession.getEmpresa().getDirecciones();
		} else {
			lstDireccionesUsuarioWeb = usuarioWebSession.getUsuario().getDirecciones();
		}
		
		List<Direccion> direcciones = getUsuarioEjbRemote().asignarComunaDireccion(lstDireccionesUsuarioWeb);
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_CONTACTO_TIPO);
		List<Tupla> lstTipContactos = getCommonEjbRemote().getParameter(filtroCatalogo);
		
		getRequest().put("direcciones", direcciones);
		getRequest().put("tipsContactos", lstTipContactos);
		
		return SUCCESS;
	}

	public String addContacto() {
		// VALIDAR CAMPOS
		
		String codigoTitular = "";
		UsuarioWeb usuarioWebSession = ((UsuarioWeb)getSession().get("usuarioWeb"));
		
		if(Constantes.TIPOUSUARIO_SIGLA_EMPRESA.equals(usuarioWebSession.getTipoUsuarioWeb().getId())) {
			codigoTitular = usuarioWebSession.getEmpresa().getCodigoEmpresa();
		} else {
			codigoTitular = usuarioWebSession.getUsuario().getCodigoUsuario();
		}
		
		Integer resultado = getUsuarioEjbRemote().addContacto(contacto, codigoTitular);
		
		// ACTUALIZAR SESSION CON ULTIMO CONTACTO REGISTRADO
		FiltroContacto filtroContacto = new FiltroContacto();
		filtroContacto.setCodigoTitular(codigoTitular);
		List<Contacto> contactos = getUsuarioEjbRemote().getContactos(filtroContacto);
		
		if(Constantes.TIPOUSUARIO_SIGLA_EMPRESA.equals(usuarioWebSession.getTipoUsuarioWeb().getId())) {
			usuarioWebSession.getEmpresa().setContactos(contactos);
		} else {
			usuarioWebSession.getUsuario().setContactos(contactos);
		}
		
		this.getSession().put("usuarioWeb", usuarioWebSession);
		
		return SUCCESS;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

}
