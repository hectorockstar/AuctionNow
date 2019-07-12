package com.auctionnow.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.auctionnow.common.Tupla;

public class Contacto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigoContacto;
	private String email;
	private Integer prioridad;
	private String telefono1;
	private String telefono2;
	private String movil1;
	private String movil2;
	private Tupla tipoContacto;
	private Direccion direccion;
	
	private String codigoTitular;

	public Tupla getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(Tupla tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public String getCodigoContacto() {
		return codigoContacto;
	}

	public void setCodigoContacto(String codigoContacto) {
		this.codigoContacto = codigoContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getMovil1() {
		return movil1;
	}

	public void setMovil1(String movil1) {
		this.movil1 = movil1;
	}

	public String getMovil2() {
		return movil2;
	}

	public void setMovil2(String movil2) {
		this.movil2 = movil2;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getCodigoTitular() {
		return codigoTitular;
	}

	public void setCodigoTitular(String codigoTitular) {
		this.codigoTitular = codigoTitular;
	}

}
