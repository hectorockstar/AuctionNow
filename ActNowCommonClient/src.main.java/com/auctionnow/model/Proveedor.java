package com.auctionnow.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.auctionnow.common.Tupla;

public class Proveedor extends Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoProveedor;
	private Tupla tipoProveedor;
	private FichaServicioProveedor fichaProveedor;
	private Cargo cargo;
	
	//proveedor dependiente
	private Empresa empresa;
	
	
	//proveedor independiente

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public FichaServicioProveedor getFichaProveedor() {
		return fichaProveedor;
	}

	public void setFichaProveedor(FichaServicioProveedor fichaProveedor) {
		this.fichaProveedor = fichaProveedor;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public Tupla getTipoProveedor() {
		return tipoProveedor;
	}

	public void setTipoProveedor(Tupla tipoProveedor) {
		this.tipoProveedor = tipoProveedor;
	}
	
}
