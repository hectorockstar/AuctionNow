package com.auctionnow.common;

import java.io.Serializable;
import java.util.Date;

public class HorarioSistema implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date fechaActual;
	private String horaActual;
	
	public Date getFechaActual() {
		return fechaActual;
	}
	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	public String getHoraActual() {
		return horaActual;
	}
	public void setHoraActual(String horaActual) {
		this.horaActual = horaActual;
	}
	
	
}
