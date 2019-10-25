package com.auctionnow.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.auctionnow.common.Tupla;

public class Privilegio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigoPrivilegio;
	private String nombrePrivilegio;
	private String descripcion;
	private String vigente;
	private String observacion;
	private Date fechaRegistro;
	private Tupla tipoPrivilegio;
	private Tupla tipoUsuarioWeb;

	private String codigoPrivilegioUsuario;
	private UsuarioWeb usuarioWeb;
	private String activo;
	private Date fechaAsignacion;

	public String getCodigoPrivilegioUsuario() {
		return codigoPrivilegioUsuario;
	}

	public void setCodigoPrivilegioUsuario(String codigoPrivilegioUsuario) {
		this.codigoPrivilegioUsuario = codigoPrivilegioUsuario;
	}

	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Tupla getTipoPrivilegio() {
		return tipoPrivilegio;
	}

	public void setTipoPrivilegio(Tupla tipoPrivilegio) {
		this.tipoPrivilegio = tipoPrivilegio;
	}

	public Tupla getTipoUsuarioWeb() {
		return tipoUsuarioWeb;
	}

	public void setTipoUsuarioWeb(Tupla tipoUsuarioWeb) {
		this.tipoUsuarioWeb = tipoUsuarioWeb;
	}

	public String getCodigoPrivilegio() {
		return codigoPrivilegio;
	}

	public void setCodigoPrivilegio(String codigoPrivilegio) {
		this.codigoPrivilegio = codigoPrivilegio;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombrePrivilegio() {
		return nombrePrivilegio;
	}

	public void setNombrePrivilegio(String nombrePrivilegio) {
		this.nombrePrivilegio = nombrePrivilegio;
	}

	public String getVigente() {
		return vigente;
	}

	public void setVigente(String vigente) {
		this.vigente = vigente;
	}
	
}
