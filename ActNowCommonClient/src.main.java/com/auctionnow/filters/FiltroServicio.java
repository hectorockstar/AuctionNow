package com.auctionnow.filters;

import java.io.Serializable;

import com.auctionnow.common.Tupla;

public class FiltroServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigoServicio;
	private String codigoRubro;
	private String codigoTitular;
	private String codigoEjerce;
	
	public String getCodigoEjerce() {
		return codigoEjerce;
	}

	public void setCodigoEjerce(String codigoEjerce) {
		this.codigoEjerce = codigoEjerce;
	}

	private Tupla tipoServicio;

	public Tupla getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(Tupla tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public String getCodigoRubro() {
		return codigoRubro;
	}

	public void setCodigoRubro(String codigoRubro) {
		this.codigoRubro = codigoRubro;
	}

	public String getCodigoTitular() {
		return codigoTitular;
	}

	public void setCodigoTitular(String codigoTitular) {
		this.codigoTitular = codigoTitular;
	}
	
}
