package com.auctionnow.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.auctionnow.common.Tupla;

public class UsuarioWeb implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoUsuarioWeb;
	private String contrasena;
	private String firmaComentario;
	private String nombreUsuario;
	private String pregunta1;
	private String pregunta2;
	private String pregunta3;
	private String respuesta1;
	private String respuesta2;
	private String respuesta3;
	private String estadoCuenta;
	private Tupla tipoUsuarioWeb;
	private Usuario usuario;
	private Empresa empresa;
	private List<Privilegio> privilegios;

	public List<Privilegio> getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(List<Privilegio> privilegios) {
		this.privilegios = privilegios;
	}

	public String getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public String getCodigoUsuarioWeb() {
		return codigoUsuarioWeb;
	}

	public void setCodigoUsuarioWeb(String codigoUsuarioWeb) {
		this.codigoUsuarioWeb = codigoUsuarioWeb;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getFirmaComentario() {
		return firmaComentario;
	}

	public void setFirmaComentario(String firmaComentario) {
		this.firmaComentario = firmaComentario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPregunta1() {
		return pregunta1;
	}

	public void setPregunta1(String pregunta1) {
		this.pregunta1 = pregunta1;
	}

	public String getPregunta2() {
		return pregunta2;
	}

	public void setPregunta2(String pregunta2) {
		this.pregunta2 = pregunta2;
	}

	public String getPregunta3() {
		return pregunta3;
	}

	public void setPregunta3(String pregunta3) {
		this.pregunta3 = pregunta3;
	}

	public String getRespuesta1() {
		return respuesta1;
	}

	public void setRespuesta1(String respuesta1) {
		this.respuesta1 = respuesta1;
	}

	public String getRespuesta2() {
		return respuesta2;
	}

	public void setRespuesta2(String respuesta2) {
		this.respuesta2 = respuesta2;
	}

	public String getRespuesta3() {
		return respuesta3;
	}

	public void setRespuesta3(String respuesta3) {
		this.respuesta3 = respuesta3;
	}

	public Tupla getTipoUsuarioWeb() {
		return tipoUsuarioWeb;
	}

	public void setTipoUsuarioWeb(Tupla tipoUsuarioWeb) {
		this.tipoUsuarioWeb = tipoUsuarioWeb;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
