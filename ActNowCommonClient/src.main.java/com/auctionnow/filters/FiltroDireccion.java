package com.auctionnow.filters;

import java.io.Serializable;

public class FiltroDireccion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoTitular;
	private String codigoDireccion;

	public String getCodigoDireccion() {
		return codigoDireccion;
	}

	public void setCodigoDireccion(String codigoDireccion) {
		this.codigoDireccion = codigoDireccion;
	}

	public String getCodigoTitular() {
		return codigoTitular;
	}

	public void setCodigoTitular(String codigoTitular) {
		this.codigoTitular = codigoTitular;
	}

}
