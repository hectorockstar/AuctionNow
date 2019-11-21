package com.auctionnow.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.auctionnow.common.Tupla;

public class Cliente extends Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoCliente;
	private FichaServicioCliente fichaCliente;
	private Tupla tipoCliente;

	private List<Solicitud> solicitudes;

	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public FichaServicioCliente getFichaCliente() {
		return fichaCliente;
	}

	public void setFichaCliente(FichaServicioCliente fichaCliente) {
		this.fichaCliente = fichaCliente;
	}

	public Tupla getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Tupla tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
