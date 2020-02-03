package com.auctionnow.filters;

import java.io.Serializable;
import java.util.List;

public class FiltroSubasta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoSubasta;
	private String codigoSolicitud;
	private List<String> estadosSubasta;
	
	public List<String> getEstadosSubasta() {
		return estadosSubasta;
	}

	public void setEstadosSubasta(List<String> estadosSubasta) {
		this.estadosSubasta = estadosSubasta;
	}

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
