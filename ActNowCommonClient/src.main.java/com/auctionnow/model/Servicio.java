package com.auctionnow.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.auctionnow.common.Tupla;

public class Servicio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoServicio;
	private String descripcion;
	private Date fechaRegistro;
	private String nombre;
	private String sigla;
	private Tupla tipoServicio;

	// Empresa a la que pertenece el Servicio
	private Integer prioridad;
	private String activo;
	private Date operaServicioDesde;
	private Empresa empresa;
	private Date fechaRegistroWeb;

	// Empresas que dictan el Servicio
	private List<Empresa> lstEmpresas;

	// Cantidad de cargos que ofrece el servicio
	private List<Cargo> lstCargos;

	public Date getOperaServicioDesde() {
		return operaServicioDesde;
	}

	public void setOperaServicioDesde(Date operaServicioDesde) {
		this.operaServicioDesde = operaServicioDesde;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public List<Empresa> getLstEmpresas() {
		return lstEmpresas;
	}

	public void setLstEmpresas(List<Empresa> lstEmpresas) {
		this.lstEmpresas = lstEmpresas;
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

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tupla getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(Tupla tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public Date getFechaRegistroWeb() {
		return fechaRegistroWeb;
	}

	public void setFechaRegistroWeb(Date fechaRegistroWeb) {
		this.fechaRegistroWeb = fechaRegistroWeb;
	}

	public List<Cargo> getLstCargos() {
		return lstCargos;
	}

	public void setLstCargos(List<Cargo> lstCargos) {
		this.lstCargos = lstCargos;
	}

}
