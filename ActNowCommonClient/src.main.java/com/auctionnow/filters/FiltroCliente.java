package com.auctionnow.filters;

import java.io.Serializable;
import java.util.Date;

public class FiltroCliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoUsuario;
	private Date fechaRegistroDesde;
	private Date fechaRegistroHasta;
	private Date fechaNacimientoDesde;
	private Date fechaNacimientoHasta;
	private String tipoUsuario;
	private String tipoCliente;
	private String genero;
	private FiltroUsuarioWeb filtroUsuarioWeb;
	private String codigoCliente;

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	private String codigoFicha;

	public FiltroUsuarioWeb getFiltroUsuarioWeb() {
		return filtroUsuarioWeb;
	}

	public void setFiltroUsuarioWeb(FiltroUsuarioWeb filtroUsuarioWeb) {
		this.filtroUsuarioWeb = filtroUsuarioWeb;
	}

	public String getCodigoFicha() {
		return codigoFicha;
	}

	public void setCodigoFicha(String codigoFicha) {
		this.codigoFicha = codigoFicha;
	}

	public Date getFechaNacimientoDesde() {
		return fechaNacimientoDesde;
	}

	public void setFechaNacimientoDesde(Date fechaNacimientoDesde) {
		this.fechaNacimientoDesde = fechaNacimientoDesde;
	}

	public Date getFechaNacimientoHasta() {
		return fechaNacimientoHasta;
	}

	public void setFechaNacimientoHasta(Date fechaNacimientoHasta) {
		this.fechaNacimientoHasta = fechaNacimientoHasta;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public Date getFechaRegistroDesde() {
		return fechaRegistroDesde;
	}

	public void setFechaRegistroDesde(Date fechaRegistroDesde) {
		this.fechaRegistroDesde = fechaRegistroDesde;
	}

	public Date getFechaRegistroHasta() {
		return fechaRegistroHasta;
	}

	public void setFechaRegistroHasta(Date fechaRegistroHasta) {
		this.fechaRegistroHasta = fechaRegistroHasta;
	}

}
