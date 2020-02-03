package com.auctionnow.filters;

import java.io.Serializable;
import java.util.List;

public class FiltroSolicitud implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoCliente;
	private String codigoSolicitud;
	private List<String> estadosSolicitud;
	
	public List<String> getEstadosSolicitud() {
		return estadosSolicitud;
	}

	public void setEstadosSolicitud(List<String> estadosSolicitud) {
		this.estadosSolicitud = estadosSolicitud;
	}

	public String getCodigoSolicitud() {
		return codigoSolicitud;
	}

	public void setCodigoSolicitud(String codigoSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

}
