package com.auctionnow.filters;

import java.io.Serializable;

public class FiltroPrivilegio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoPrivilegio;
	private String vigente;
	private String tipoPrivilegio;
	private String tipoUsuario;

	public String getVigente() {
		return vigente;
	}

	public void setVigente(String vigente) {
		this.vigente = vigente;
	}

	public String getTipoPrivilegio() {
		return tipoPrivilegio;
	}

	public void setTipoPrivilegio(String tipoPrivilegio) {
		this.tipoPrivilegio = tipoPrivilegio;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getCodigoPrivilegio() {
		return codigoPrivilegio;
	}

	public void setCodigoPrivilegio(String codigoPrivilegio) {
		this.codigoPrivilegio = codigoPrivilegio;
	}

}
