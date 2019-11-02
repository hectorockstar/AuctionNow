package com.auctionnow.controller.usuario;

import java.util.List;

import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroNotificacion;
import com.auctionnow.model.Notificacion;
import com.auctionnow.model.UsuarioWeb;

public class NotificacionWebAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected UsuarioWeb usuarioWeb;
	protected Notificacion notificacion;
	
	public String getNotificacionesUsuarioWeb() {
		
		FiltroNotificacion filtroNotificacion = new FiltroNotificacion();
		filtroNotificacion.setCodigoUsuarioWeb(usuarioWeb.getCodigoUsuarioWeb());
		filtroNotificacion.setTipoUsuarioWeb(usuarioWeb.getTipoUsuarioWeb().getId());
		
		List<Notificacion> notificaciones = getUsuarioEjbRemote().getNotificacionesUsuario(filtroNotificacion);
		
		this.jsonFormatResult(notificaciones);
		
		return SUCCESS;
	}
	
	public String updateNotificationStatus() {
		
		FiltroNotificacion filtroNotificacion = new FiltroNotificacion();
		filtroNotificacion.setCodigoUsuarioWeb(notificacion.getUsuarioWeb().getCodigoUsuarioWeb());
		filtroNotificacion.setCodigoNotificacionUsuario(notificacion.getCodigoNotificacionUsuario());
		filtroNotificacion.setLeida(notificacion.getLeida());
		
		Integer updateNotificationResult = getUsuarioEjbRemote().actualizaEstadoNotificacionUsuario(filtroNotificacion);
		
		this.jsonFormatResult(updateNotificationResult);
		
		return SUCCESS;
	}

	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
	}
	
}
