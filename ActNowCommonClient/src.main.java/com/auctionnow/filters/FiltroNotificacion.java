package com.auctionnow.filters;

import java.io.Serializable;

public class FiltroNotificacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigoUsuarioWeb;
	private String leida;
	private String tipoNotificacion;
	
	public String getTipoNotificacion() {
		return tipoNotificacion;
	}

	public void setTipoNotificacion(String tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}

	public String getCodigoUsuarioWeb() {
		return codigoUsuarioWeb;
	}

	public void setCodigoUsuarioWeb(String codigoUsuarioWeb) {
		this.codigoUsuarioWeb = codigoUsuarioWeb;
	}

	public String getLeida() {
		return leida;
	}

	public void setLeida(String leida) {
		this.leida = leida;
	}

}
