package com.auctionnow.controller.usuario;

import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroContacto;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.UsuarioWeb;

public class ContactoActualizarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Contacto contacto;

	public String showActualizaContacto() {
		
		UsuarioWeb usuarioWebSession = ((UsuarioWeb)getSession().get("usuarioWeb"));

		List<Direccion> lstDireccionesUsuarioWeb = null;
		if(Constantes.TIPOUSUARIO_SIGLA_EMPRESA.equals(usuarioWebSession.getTipoUsuarioWeb().getId())) {
			lstDireccionesUsuarioWeb = usuarioWebSession.getEmpresa().getDirecciones();
		} else {
			lstDireccionesUsuarioWeb = usuarioWebSession.getUsuario().getDirecciones();
		}
		
		List<Direccion> direcciones = getUsuarioEjbRemote().asignarComunaDireccion(lstDireccionesUsuarioWeb);
		
		List<Contacto> contactos = (usuarioWebSession.getEmpresa() != null ? usuarioWebSession.getEmpresa().getContactos() : usuarioWebSession.getUsuario().getContactos());

		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_CONTACTO_TIPO);
		List<Tupla> lstTipContactos = getCommonEjbRemote().getParameter(filtroCatalogo);

		getRequest().put("direcciones", direcciones);
		getRequest().put("contactos", contactos);
		getRequest().put("tipsContactos", lstTipContactos);

		return SUCCESS;
	}

	public String actualizaContacto() {
		// TODO
		// VALIDAR CAMPOS

		String codigoTitular = "";
		UsuarioWeb usuarioWebSession = ((UsuarioWeb)getSession().get("usuarioWeb"));
		
		if(Constantes.TIPOUSUARIO_SIGLA_EMPRESA.equals(usuarioWebSession.getTipoUsuarioWeb().getId())) {
			codigoTitular = usuarioWebSession.getEmpresa().getCodigoEmpresa();
		} else {
			codigoTitular = usuarioWebSession.getUsuario().getCodigoUsuario();
		}
		
		Integer resultado = getUsuarioEjbRemote().actualizaContacto(contacto, codigoTitular);

		if (resultado != null && resultado != 0) {
			FiltroContacto filtroContacto = new FiltroContacto();
			filtroContacto.setCodigoTitular(codigoTitular);
			List<Contacto> contactos = getUsuarioEjbRemote().getContactos(filtroContacto);

			if(Constantes.TIPOUSUARIO_SIGLA_EMPRESA.equals(usuarioWebSession.getTipoUsuarioWeb().getId())) {
				usuarioWebSession.getEmpresa().setContactos(contactos);
			} else {
				usuarioWebSession.getUsuario().setContactos(contactos);
			}
			
			this.getSession().put("usuarioWeb", usuarioWebSession);
		}

		return SUCCESS;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
}
