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
	private Integer cantidadExtenciones;
	private String codigoSubasta;
	private String descripcion;
	private String duracion;
	private boolean extendida;
	private Date fechaInicio;
	private String horaInicioSubasta;
	private Date fechaTermino;
	private String horaTerminoSubasta;
	private Long montoFinal;
	private Oferta ofertaGanadora;
	private List<Oferta> ofertas;
	private Long montoMinimo;
	private Long montoInicial;
	private String estadoSubasta;
	private Solicitud solicitud;
	private Servicio servicio;

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

	public Integer getCantidadExtenciones() {
		return cantidadExtenciones;
	}

	public void setCantidadExtenciones(Integer cantidadExtenciones) {
		this.cantidadExtenciones = cantidadExtenciones;
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
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
