package com.auctionnow.model;

import java.io.Serializable;
import java.util.Date;

import com.auctionnow.common.Tupla;

public class Notificacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigoNotificacion;
	private Tupla tipoNotificacion;
	private String nombreNotificacion;
	private String descripcion;

	private String codigoNotificacionUsuario;
	private String estadoNotificacion;
	private Date fechaEmision;
	private String horaEmision;
	private String leida;
	private Date fechaLectura;
	private String horaLectura;
	private String mostrar;
	private String codigoOrigenNotificacion;
	private UsuarioWeb usuarioWeb;

	public String getCodigoNotificacion() {
		return codigoNotificacion;
	}

	public void setCodigoNotificacion(String codigoNotificacion) {
		this.codigoNotificacion = codigoNotificacion;
	}

	public Tupla getTipoNotificacion() {
		return tipoNotificacion;
	}

	public void setTipoNotificacion(Tupla tipoNotificacion) {
		this.tipoNotificacion = tipoNotificacion;
	}

	public String getNombreNotificacion() {
		return nombreNotificacion;
	}

	public void setNombreNotificacion(String nombreNotificacion) {
		this.nombreNotificacion = nombreNotificacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigoNotificacionUsuario() {
		return codigoNotificacionUsuario;
	}

	public void setCodigoNotificacionUsuario(String codigoNotificacionUsuario) {
		this.codigoNotificacionUsuario = codigoNotificacionUsuario;
	}

	public String getEstadoNotificacion() {
		return estadoNotificacion;
	}

	public void setEstadoNotificacion(String estadoNotificacion) {
		this.estadoNotificacion = estadoNotificacion;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaLectura() {
		return fechaLectura;
	}

	public void setFechaLectura(Date fechaLectura) {
		this.fechaLectura = fechaLectura;
	}

	public String getHoraLectura() {
		return horaLectura;
	}

	public void setHoraLectura(String horaLectura) {
		this.horaLectura = horaLectura;
	}

	public String getCodigoOrigenNotificacion() {
		return codigoOrigenNotificacion;
	}

	public void setCodigoOrigenNotificacion(String codigoOrigenNotificacion) {
		this.codigoOrigenNotificacion = codigoOrigenNotificacion;
	}

	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	public String getHoraEmision() {
		return horaEmision;
	}

	public void setHoraEmision(String horaEmision) {
		this.horaEmision = horaEmision;
	}

	public String getLeida() {
		return leida;
	}

	public void setLeida(String leida) {
		this.leida = leida;
	}

	public String getMostrar() {
		return mostrar;
	}

	public void setMostrar(String mostrar) {
		this.mostrar = mostrar;
	}
	
}
