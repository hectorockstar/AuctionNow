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
	private String descPrivilegio;
	private Boolean vigente;
	private String observacion;
	private Date fechaRegistro;
	private Tupla tipoPrivilegio;
	private Tupla tipousuarioWeb;

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
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

	public Tupla getTipousuarioWeb() {
		return tipousuarioWeb;
	}

	public void setTipousuarioWeb(Tupla tipousuarioWeb) {
		this.tipousuarioWeb = tipousuarioWeb;
	}

	public String getCodigoPrivilegio() {
		return codigoPrivilegio;
	}

	public void setCodigoPrivilegio(String codigoPrivilegio) {
		this.codigoPrivilegio = codigoPrivilegio;
	}

	public String getDescPrivilegio() {
		return descPrivilegio;
	}

	public void setDescPrivilegio(String descPrivilegio) {
		this.descPrivilegio = descPrivilegio;
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
}
