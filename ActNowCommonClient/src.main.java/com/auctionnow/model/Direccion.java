package com.auctionnow.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.auctionnow.common.Comuna;
import com.auctionnow.common.Tupla;

public class Direccion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String calle;
	private String codigoDireccion;
	private String codigoPostal;
	private String deptoNro;
	private GeoLocalizacion geoLocalizacion;
	private String numeracion;
	private String observacion;
	private Integer piso;
	private Integer prioridad;
	private Tupla tipoDireccion;
	private List<Contacto> contactos;
	private Comuna comuna;

	public String getCodigoDireccion() {
		return codigoDireccion;
	}

	public void setCodigoDireccion(String codigoDireccion) {
		this.codigoDireccion = codigoDireccion;
	}

	public Tupla getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(Tupla tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

	public String getDeptoNro() {
		return deptoNro;
	}

	public void setDeptoNro(String deptoNro) {
		this.deptoNro = deptoNro;
	}

	public GeoLocalizacion getGeoLocalizacion() {
		return geoLocalizacion;
	}

	public void setGeoLocalizacion(GeoLocalizacion geoLocalizacion) {
		this.geoLocalizacion = geoLocalizacion;
	}

	public String getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public List<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
