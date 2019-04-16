package com.auctionnow.filters;

import java.io.Serializable;

public class FiltroContacto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigoTitular;
	private String codigoServicio;
	private String codigoContacto;

	public String getCodigoContacto() {
		return codigoContacto;
	}

	public void setCodigoContacto(String codigoContacto) {
		this.codigoContacto = codigoContacto;
	}

	public String getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public String getCodigoTitular() {
		return codigoTitular;
	}

	public void setCodigoTitular(String codigoTitular) {
		this.codigoTitular = codigoTitular;
	}

}
