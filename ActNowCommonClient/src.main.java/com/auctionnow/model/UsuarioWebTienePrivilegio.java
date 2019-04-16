package com.auctionnow.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UsuarioWebTienePrivilegio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String activo;
	private Date fechaAsignacion;
	private String descripcion;
	private List<Privilegio> lstPrivilegios;
	private List<UsuarioWeb> lstUsuarioWeb;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public List<Privilegio> getLstPrivilegios() {
		return lstPrivilegios;
	}

	public void setLstPrivilegios(List<Privilegio> lstPrivilegios) {
		this.lstPrivilegios = lstPrivilegios;
	}

	public List<UsuarioWeb> getLstUsuarioWeb() {
		return lstUsuarioWeb;
	}

	public void setLstUsuarioWeb(List<UsuarioWeb> lstUsuarioWeb) {
		this.lstUsuarioWeb = lstUsuarioWeb;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
