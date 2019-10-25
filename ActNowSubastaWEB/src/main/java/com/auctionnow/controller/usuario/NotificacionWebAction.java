package com.auctionnow.controller.usuario;

import java.util.ArrayList;
import java.util.List;

import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.model.Notificacion;
import com.auctionnow.model.UsuarioWeb;

public class NotificacionWebAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected UsuarioWeb usuarioWeb;
	
	public String getNotificacionesUsuarioWeb() {
		
		List<Notificacion> notificaciones = new ArrayList<Notificacion>();
		Notificacion notificacion = new Notificacion();
		notificacion.setDescripcion("HOLA");
		notificaciones.add(notificacion);
		
		this.jsonFormatResult(notificaciones);
		
		return SUCCESS;
	}

	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}
	
}
