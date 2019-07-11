package com.auctionnow.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Servicio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoServicio;
	private String descripcion;
	private String nombre;
	private String sigla;
	private String activo;
	private Rubro rubro;
	
	// ASIGNADO A ALGUN PROVEEDOR o EMPRESA (AN_EJERCE)
	private String codigoServicioActivo;
	private Integer jerarquia;
	private Date fechaModificacion;
	private String activoTitular; 

	// Empresas que dictan el Servicio
	private List<Empresa> empresas;

	// Cantidad de cargos que ofrece el servicio
	private List<Cargo> cargos;
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
	
	public String getCodigoServicioActivo() {
		return codigoServicioActivo;
	}

	public void setCodigoServicioActivo(String codigoServicioActivo) {
		this.codigoServicioActivo = codigoServicioActivo;
	}

	public Integer getJerarquia() {
		return jerarquia;
	}

	public void setJerarquia(Integer jerarquia) {
		this.jerarquia = jerarquia;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getActivoTitular() {
		return activoTitular;
	}

	public void setActivoTitular(String activoTitular) {
		this.activoTitular = activoTitular;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
