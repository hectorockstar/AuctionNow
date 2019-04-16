package com.auctionnow.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class TipoUsuarioWeb implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codigoTipoUsuario;
	private String descTipoUsuario;
	private List<Privilegio> privilegios;

	public Integer getCodigoTipoUsuario() {
		return codigoTipoUsuario;
	}

	public void setCodigoTipoUsuario(Integer codigoTipoUsuario) {
		this.codigoTipoUsuario = codigoTipoUsuario;
	}

	public String getDescTipoUsuario() {
		return descTipoUsuario;
	}

	public void setDescTipoUsuario(String descTipoUsuario) {
		this.descTipoUsuario = descTipoUsuario;
	}

	public List<Privilegio> getPrivilegios() {
		return privilegios;
	}

	public void setPrivilegios(List<Privilegio> privilegios) {
		this.privilegios = privilegios;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
