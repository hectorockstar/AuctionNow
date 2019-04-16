package com.auctionnow.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.auctionnow.common.Tupla;

public class GeoLocalizacion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idGeo;
	private BigDecimal latitud;
	private BigDecimal longitud;
	private Tupla tipoGeoLoc;

	public String getIdGeo() {
		return idGeo;
	}

	public void setIdGeo(String idGeo) {
		this.idGeo = idGeo;
	}

	public BigDecimal getLatitud() {
		return latitud;
	}

	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}

	public BigDecimal getLongitud() {
		return longitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	public Tupla getTipoGeoLoc() {
		return tipoGeoLoc;
	}

	public void setTipoGeoLoc(Tupla tipoGeoLoc) {
		this.tipoGeoLoc = tipoGeoLoc;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
