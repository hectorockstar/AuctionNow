package com.auctionnow.controller.usuario;

import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroContacto;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.UsuarioWeb;

public class ContactoRegistrarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Contacto contacto;

	public String showAddContacto() {
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_CONTACTO_TIPO);
		List<Tupla> lstTipContactos = getCommonEjbRemote().getParameter(filtroCatalogo);
		
		getRequest().put("tipsContactos", lstTipContactos);
		
		return Constantes.SUCCESS;
	}

	public String addContacto() {
		// VALIDAR CAMPOS
		
		String codigoTitular = ((UsuarioWeb)getSession().get("usuarioWeb")).getUsuario().getCodigoUsuario();
		Integer resultado = getUsuarioEjbRemote().addContacto(contacto, codigoTitular);
		
		// ACTUALIZAR SESSION CON ULTIMO CONTACTO REGISTRADO
		FiltroContacto filtroContacto = new FiltroContacto();
		filtroContacto.setCodigoTitular(codigoTitular);
		List<Contacto> contactos = getUsuarioEjbRemote().getContactos(filtroContacto);
		
		UsuarioWeb usuWeb = (UsuarioWeb) getSession().get("usuarioWeb");
		usuWeb.getUsuario().setContactos(contactos);
		this.getSession().put("usuarioWeb", usuWeb);
		
		return Constantes.SUCCESS;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

}
