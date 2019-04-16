package com.auctionnow.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.auctionnow.common.Tupla;

public class Transaccion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<BitacoraTransaccion> bitacoras;
	private String codigoTransaccion;
	private Integer complejidadServicio;
	private String descripcion;
	private String estadoTransaccion;
	private Date fechaCreacion;
	private Date fechaTermino;
	private MedioPago medioPago;
	private Long montoTotal;
	private Tupla tipoMoneda;
	private Subasta subasta;

	public List<BitacoraTransaccion> getBitacoras() {
		return bitacoras;
	}

	public void setBitacoras(List<BitacoraTransaccion> bitacoras) {
		this.bitacoras = bitacoras;
	}

	public String getCodigoTransaccion() {
		return codigoTransaccion;
	}

	public void setCodigoTransaccion(String codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}

	public Integer getComplejidadServicio() {
		return complejidadServicio;
	}

	public void setComplejidadServicio(Integer complejidadServicio) {
		this.complejidadServicio = complejidadServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoTransaccion() {
		return estadoTransaccion;
	}

	public void setEstadoTransaccion(String estadoTransaccion) {
		this.estadoTransaccion = estadoTransaccion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	public Long getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Long montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Tupla getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(Tupla tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public Subasta getSubasta() {
		return subasta;
	}

	public void setSubasta(Subasta subasta) {
		this.subasta = subasta;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
