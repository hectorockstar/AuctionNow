package com.auctionnow.filters;

import java.io.Serializable;
import java.util.List;

import com.auctionnow.model.Rubro;

public class FiltroRubro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigoTitular;
	private List<Rubro> rubros;

	public String getCodigoTitular() {
		return codigoTitular;
	}

	public void setCodigoTitular(String codigoTitular) {
		this.codigoTitular = codigoTitular;
	}

	public List<Rubro> getRubros() {
		return rubros;
	}

	public void setRubros(List<Rubro> rubros) {
		this.rubros = rubros;
	}
	
}
