package com.auctionnow.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class FichaServicioCliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer areaTrabajo;
	private Integer atencion;
	private String codigoFicha;
	private Integer complejidad;
	private String descripcion;
	private Integer formalidad;
	private Integer hospitalidad;
	private Integer presencia;
	private Integer recepcion;
	private Integer trato;
	private Integer cantidadEvaluaciones;

	public Integer getCantidadEvaluaciones() {
		return cantidadEvaluaciones;
	}

	public void setCantidadEvaluaciones(Integer cantidadEvaluaciones) {
		this.cantidadEvaluaciones = cantidadEvaluaciones;
	}

	public Integer getAreaTrabajo() {
		return areaTrabajo;
	}

	public void setAreaTrabajo(Integer areaTrabajo) {
		this.areaTrabajo = areaTrabajo;
	}

	public Integer getAtencion() {
		return atencion;
	}

	public void setAtencion(Integer atencion) {
		this.atencion = atencion;
	}

	public String getCodigoFicha() {
		return codigoFicha;
	}

	public void setCodigoFicha(String codigoFicha) {
		this.codigoFicha = codigoFicha;
	}

	public Integer getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(Integer complejidad) {
		this.complejidad = complejidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getFormalidad() {
		return formalidad;
	}

	public void setFormalidad(Integer formalidad) {
		this.formalidad = formalidad;
	}

	public Integer getHospitalidad() {
		return hospitalidad;
	}

	public void setHospitalidad(Integer hospitalidad) {
		this.hospitalidad = hospitalidad;
	}

	public Integer getPresencia() {
		return presencia;
	}

	public void setPresencia(Integer presencia) {
		this.presencia = presencia;
	}

	public Integer getRecepcion() {
		return recepcion;
	}

	public void setRecepcion(Integer recepcion) {
		this.recepcion = recepcion;
	}

	public Integer getTrato() {
		return trato;
	}

	public void setTrato(Integer trato) {
		this.trato = trato;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
