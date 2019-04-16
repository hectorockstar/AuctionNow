package com.auctionnow.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class FichaServicioProveedor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer atencion;
	private String codigoFicha;
	private Integer coherencia;
	private Integer contacto;
	private String descripcion;
	private Integer educacionProblema;
	private Integer explicaProblema;
	private Integer puntualidad;
	private Integer tiempoServicio;
	private Integer cantidadEvaluaciones;

	public Integer getCantidadEvaluaciones() {
		return cantidadEvaluaciones;
	}

	public void setCantidadEvaluaciones(Integer cantidadEvaluaciones) {
		this.cantidadEvaluaciones = cantidadEvaluaciones;
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

	public Integer getCoherencia() {
		return coherencia;
	}

	public void setCoherencia(Integer coherencia) {
		this.coherencia = coherencia;
	}

	public Integer getContacto() {
		return contacto;
	}

	public void setContacto(Integer contacto) {
		this.contacto = contacto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEducacionProblema() {
		return educacionProblema;
	}

	public void setEducacionProblema(Integer educacionProblema) {
		this.educacionProblema = educacionProblema;
	}

	public Integer getExplicaProblema() {
		return explicaProblema;
	}

	public void setExplicaProblema(Integer explicaProblema) {
		this.explicaProblema = explicaProblema;
	}

	public Integer getPuntualidad() {
		return puntualidad;
	}

	public void setPuntualidad(Integer puntualidad) {
		this.puntualidad = puntualidad;
	}

	public Integer getTiempoServicio() {
		return tiempoServicio;
	}

	public void setTiempoServicio(Integer tiempoServicio) {
		this.tiempoServicio = tiempoServicio;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
