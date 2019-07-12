package com.auctionnow.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Rubro implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigoRubro;
	private String nombre;
	private String descripcion;
	private String activo;
	private List<Servicio> servicios;
	
	//ASIGNADO A ALGUN PROVEEDOR o EMPRESA (AN_EJERCE)
	private String codigoEjerce;
	private Date fechaEjerceDesde;
	private Date fechaRegistro;
	private Integer jerarquia;
	private String activoEjercer;
	
	public String getCodigoRubro() {
		return codigoRubro;
	}

	public void setCodigoRubro(String codigoRubro) {
		this.codigoRubro = codigoRubro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public String getCodigoEjerce() {
		return codigoEjerce;
	}

	public void setCodigoEjerce(String codigoEjerce) {
		this.codigoEjerce = codigoEjerce;
	}

	public Date getFechaEjerceDesde() {
		return fechaEjerceDesde;
	}

	public void setFechaEjerceDesde(Date fechaEjerceDesde) {
		this.fechaEjerceDesde = fechaEjerceDesde;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getJerarquia() {
		return jerarquia;
	}

	public void setJerarquia(Integer jerarquia) {
		this.jerarquia = jerarquia;
	}

	public String getActivoEjercer() {
		return activoEjercer;
	}

	public void setActivoEjercer(String activoEjercer) {
		this.activoEjercer = activoEjercer;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
