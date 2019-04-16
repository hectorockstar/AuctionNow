package com.auctionnow.controller.usuario;

import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroContacto;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.UsuarioWeb;

public class ContactoActualizarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Contacto contacto;

	public String showActualizaContacto() {

		List<Contacto> contactos = ((UsuarioWeb) getSession().get("usuarioWeb")).getUsuario().getContactos();

		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_CONTACTO_TIPO);
		List<Tupla> lstTipContactos = getCommonEjbRemote().getParameter(filtroCatalogo);

		getRequest().put("contactos", contactos);
		getRequest().put("tipsContactos", lstTipContactos);

		return Constantes.SUCCESS;
	}

	public String actualizaContacto() {
		// TODO
		// VALIDAR CAMPOS

		String codigoTitular = ((UsuarioWeb) getSession().get("usuarioWeb")).getUsuario().getCodigoUsuario();
		Integer resultado = getUsuarioEjbRemote().actualizaContacto(contacto, codigoTitular);

		if (resultado != null && resultado != 0) {
			FiltroContacto filtroContacto = new FiltroContacto();
			filtroContacto.setCodigoTitular(codigoTitular);
			List<Contacto> contactos = getUsuarioEjbRemote().getContactos(filtroContacto);

			UsuarioWeb usuarioWebSession = ((UsuarioWeb) getSession().get("usuarioWeb"));
			usuarioWebSession.getUsuario().setContactos(contactos);

			getSession().remove("usuarioWeb");
			getSession().put("usuarioWeb", usuarioWebSession);
		}

		return Constantes.SUCCESS;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
}
