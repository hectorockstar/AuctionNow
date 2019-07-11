package com.auctionnow.filters;

import java.io.Serializable;

import com.auctionnow.common.Tupla;

public class FiltroServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigoServicio;
	private String codigoEmpresa;
	private String codigoRubro;
	
	private Tupla tipoServicio;

	public Tupla getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(Tupla tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
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
	
}
