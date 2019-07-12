package com.auctionnow.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.auctionnow.common.Pais;

public class Empresa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoEmpresa;
	private String descripcion;
	private Date fechaOperaDesde;
	private Date fechaRegistro;
	private String nombreEmpresa;
	private String rut;
	private String rutDV;
	private String vigente;
	private Pais pais;
	private Map<Integer, Servicio> servicios;
	private List<Contacto> contactos;
	private List<Direccion> direcciones;
	private List<Rubro> rubros;
	
	private Servicio servicio;
	
	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getRutDV() {
		return rutDV;
	}

	public void setRutDV(String rutDV) {
		this.rutDV = rutDV;
	}

	public String getVigente() {
		return vigente;
	}

	public void setVigente(String vigente) {
		this.vigente = vigente;
	}

	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public List<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public Date getFechaOperaDesde() {
		return fechaOperaDesde;
	}

	public void setFechaOperaDesde(Date fechaOperaDesde) {
		this.fechaOperaDesde = fechaOperaDesde;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Map<Integer, Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(Map<Integer, Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Rubro> getRubros() {
		return rubros;
	}

	public void setRubros(List<Rubro> rubros) {
		this.rubros = rubros;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
