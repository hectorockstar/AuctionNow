package com.auctionnow.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Subasta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigoSubasta;
	private String estadoSubasta;
	private String descripcion;
	private Date fechaSubastaDesde;
	private String horaInicioSubasta;
	private Date fechaSubastaHasta;
	private String horaTerminoSubasta;
	private String duracion;
	private boolean extendida;
	private Integer cantidadExtensiones;
	private Long montoMinimo;
	private Long montoInicial;
	private Long montoFinal;
	private Solicitud solicitud;
	private Servicio servicio;

	private Oferta ofertaGanadora;
	private List<Oferta> ofertas;

	public Date getFechaSubastaDesde() {
		return fechaSubastaDesde;
	}

	public void setFechaSubastaDesde(Date fechaSubastaDesde) {
		this.fechaSubastaDesde = fechaSubastaDesde;
	}

	public Date getFechaSubastaHasta() {
		return fechaSubastaHasta;
	}

	public void setFechaSubastaHasta(Date fechaSubastaHasta) {
		this.fechaSubastaHasta = fechaSubastaHasta;
	}

	public Integer getCantidadExtensiones() {
		return cantidadExtensiones;
	}

	public void setCantidadExtensiones(Integer cantidadExtensiones) {
		this.cantidadExtensiones = cantidadExtensiones;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public String getHoraInicioSubasta() {
		return horaInicioSubasta;
	}

	public void setHoraInicioSubasta(String horaInicioSubasta) {
		this.horaInicioSubasta = horaInicioSubasta;
	}

	public String getHoraTerminoSubasta() {
		return horaTerminoSubasta;
	}

	public void setHoraTerminoSubasta(String horaTerminoSubasta) {
		this.horaTerminoSubasta = horaTerminoSubasta;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public String getCodigoSubasta() {
		return codigoSubasta;
	}

	public void setCodigoSubasta(String codigoSubasta) {
		this.codigoSubasta = codigoSubasta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public boolean isExtendida() {
		return extendida;
	}

	public void setExtendida(boolean extendida) {
		this.extendida = extendida;
	}

	public Long getMontoFinal() {
		return montoFinal;
	}

	public void setMontoFinal(Long montoFinal) {
		this.montoFinal = montoFinal;
	}

	public Oferta getOfertaGanadora() {
		return ofertaGanadora;
	}

	public void setOfertaGanadora(Oferta ofertaGanadora) {
		this.ofertaGanadora = ofertaGanadora;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public Long getMontoMinimo() {
		return montoMinimo;
	}

	public void setMontoMinimo(Long montoMinimo) {
		this.montoMinimo = montoMinimo;
	}

	public Long getMontoInicial() {
		return montoInicial;
	}

	public void setMontoInicial(Long montoInicial) {
		this.montoInicial = montoInicial;
	}

	public String getEstadoSubasta() {
		return estadoSubasta;
	}

	public void setEstadoSubasta(String estadoSubasta) {
		this.estadoSubasta = estadoSubasta;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
