package com.auctionnow.filters;

import java.io.Serializable;

public class FiltroGeoLoc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoGeoLocalizacion;
	private String codigoComuna;
	
	public String getCodigoComuna() {
		return codigoComuna;
	}

	public void setCodigoComuna(String codigoComuna) {
		this.codigoComuna = codigoComuna;
	}

	public String getCodigoGeoLocalizacion() {
		return codigoGeoLocalizacion;
	}

	public void setCodigoGeoLocalizacion(String codigoGeoLocalizacion) {
		this.codigoGeoLocalizacion = codigoGeoLocalizacion;
	}

}
