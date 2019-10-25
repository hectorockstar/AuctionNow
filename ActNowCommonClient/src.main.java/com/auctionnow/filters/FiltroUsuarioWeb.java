package com.auctionnow.filters;

import java.io.Serializable;

public class FiltroUsuarioWeb implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreUsuario;
	private String contrasena;
	private String estadoCuenta;
	private String tipoUsuarioWeb;
	
	// Filtro para Privilegios del UsuarioWeb
	private String codigoPrivilegio;
	private String nombrePrivilegio;
	private String activo;
	
	public String getNombrePrivilegio() {
		return nombrePrivilegio;
	}

	public void setNombrePrivilegio(String nombrePrivilegio) {
		this.nombrePrivilegio = nombrePrivilegio;
	}

	public String getCodigoPrivilegio() {
		return codigoPrivilegio;
	}

	public void setCodigoPrivilegio(String codigoPrivilegio) {
		this.codigoPrivilegio = codigoPrivilegio;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public String getTipoUsuarioWeb() {
		return tipoUsuarioWeb;
	}

	public void setTipoUsuarioWeb(String tipoUsuarioWeb) {
		this.tipoUsuarioWeb = tipoUsuarioWeb;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
