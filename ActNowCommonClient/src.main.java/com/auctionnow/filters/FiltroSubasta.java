package com.auctionnow.filters;

import java.io.Serializable;

public class FiltroSubasta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoSubasta;
	private String codigoSolicitud;

	public String getCodigoSolicitud() {
		return codigoSolicitud;
	}

	public void setCodigoSolicitud(String codigoSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
	}

	public String getCodigoSubasta() {
		return codigoSubasta;
	}

	public void setCodigoSubasta(String codigoSubasta) {
		this.codigoSubasta = codigoSubasta;
	}

}
