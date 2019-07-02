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

	// Empresas que dictan el Servicio
	private List<Empresa> lstEmpresas;

	// Cantidad de cargos que ofrece el servicio
	private List<Cargo> lstCargos;

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

	public List<Cargo> getLstCargos() {
		return lstCargos;
	}

	public void setLstCargos(List<Cargo> lstCargos) {
		this.lstCargos = lstCargos;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
