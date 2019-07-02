package com.auctionnow.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.auctionnow.common.Tupla;

public class Rubro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Empresa empresa;
	private String jerarquia;
	private Date fechaEjerceRubro;
	private Date fechaRegistroRubro;
	private String activo;
	
	private Servicio servicio;
	private List<Empresa> empresas;
	private List<Servicio> servicios;
	
	private List<Proveedor> proveedores;
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getJerarquia() {
		return jerarquia;
	}

	public void setJerarquia(String jerarquia) {
		this.jerarquia = jerarquia;
	}

	public Date getFechaEjerceRubro() {
		return fechaEjerceRubro;
	}

	public void setFechaEjerceRubro(Date fechaEjerceRubro) {
		this.fechaEjerceRubro = fechaEjerceRubro;
	}

	public Date getFechaRegistroRubro() {
		return fechaRegistroRubro;
	}

	public void setFechaRegistroRubro(Date fechaRegistroRubro) {
		this.fechaRegistroRubro = fechaRegistroRubro;
	}
	
}
