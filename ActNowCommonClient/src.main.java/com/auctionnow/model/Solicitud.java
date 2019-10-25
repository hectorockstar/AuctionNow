package com.auctionnow.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.auctionnow.common.Tupla;

public class Solicitud implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigoSolicitud;
	private Tupla tipoFecha;
	private Date fechaServicioDesde;
	private Date fechaServicioHasta;
	private String horarioDesde;
	private String horarioHasta;
	private Date fechaEntregaServicio;
	private Date fechaCreacion;
	private Date fechaVencimientoSubasta;
	private String horaVencimientoSubasta;
	private Double precioEsperado;
	private String estadoSolicitud;
	private Double valoracion;
	private String descripcion;
	private Servicio servicio;
	private Direccion direccion;
	private Contacto contacto;
	private Cliente cliente;
	private String activo;
	
	private Integer prioridad;
	private String diasDisponible;
	
	private UsuarioWeb usuarioWeb;
	
	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Date getFechaEntregaServicio() {
		return fechaEntregaServicio;
	}

	public void setFechaEntregaServicio(Date fechaEntregaServicio) {
		this.fechaEntregaServicio = fechaEntregaServicio;
	}

	public String getHorarioDesde() {
		return horarioDesde;
	}

	public void setHorarioDesde(String horarioDesde) {
		this.horarioDesde = horarioDesde;
	}

	public String getHorarioHasta() {
		return horarioHasta;
	}

	public void setHorarioHasta(String horarioHasta) {
		this.horarioHasta = horarioHasta;
	}

	public Date getFechaServicioDesde() {
		return fechaServicioDesde;
	}

	public void setFechaServicioDesde(Date fechaServicioDesde) {
		this.fechaServicioDesde = fechaServicioDesde;
	}

	public Date getFechaServicioHasta() {
		return fechaServicioHasta;
	}

	public void setFechaServicioHasta(Date fechaServicioHasta) {
		this.fechaServicioHasta = fechaServicioHasta;
	}

	public Tupla getTipoFecha() {
		return tipoFecha;
	}

	public void setTipoFecha(Tupla tipoFecha) {
		this.tipoFecha = tipoFecha;
	}

	public String getDiasDisponible() {
		return diasDisponible;
	}

	public void setDiasDisponible(String diasDisponible) {
		this.diasDisponible = diasDisponible;
	}

	public Double getValoracion() {
		return valoracion;
	}

	public void setValoracion(Double valoracion) {
		this.valoracion = valoracion;
	}

	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCodigoSolicitud() {
		return codigoSolicitud;
	}

	public void setCodigoSolicitud(String codigoSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Double getPrecioEsperado() {
		return precioEsperado;
	}

	public void setPrecioEsperado(Double precioEsperado) {
		this.precioEsperado = precioEsperado;
	}

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}
	
	public Date getFechaVencimientoSubasta() {
		return fechaVencimientoSubasta;
	}

	public void setFechaVencimientoSubasta(Date fechaVencimientoSubasta) {
		this.fechaVencimientoSubasta = fechaVencimientoSubasta;
	}

	public String getHoraVencimientoSubasta() {
		return horaVencimientoSubasta;
	}

	public void setHoraVencimientoSubasta(String horaVencimientoSubasta) {
		this.horaVencimientoSubasta = horaVencimientoSubasta;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
