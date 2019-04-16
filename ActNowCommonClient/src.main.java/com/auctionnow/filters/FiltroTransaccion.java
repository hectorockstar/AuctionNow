package com.auctionnow.filters;

import java.io.Serializable;

public class FiltroTransaccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Transaccion
	private String codigoTransaccion;
	private String codigoCliente;

	// Bitacora Transaccion
	private String codigoBitTransaccion;

	// MedioPago
	private String codigoMedioPago;

	// Tarjeta
	private String codigoTarjeta;

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getCodigoTransaccion() {
		return codigoTransaccion;
	}

	public void setCodigoTransaccion(String codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}

	public String getCodigoBitTransaccion() {
		return codigoBitTransaccion;
	}

	public void setCodigoBitTransaccion(String codigoBitTransaccion) {
		this.codigoBitTransaccion = codigoBitTransaccion;
	}

	public String getCodigoMedioPago() {
		return codigoMedioPago;
	}

	public void setCodigoMedioPago(String codigoMedioPago) {
		this.codigoMedioPago = codigoMedioPago;
	}

	public String getCodigoTarjeta() {
		return codigoTarjeta;
	}

	public void setCodigoTarjeta(String codigoTarjeta) {
		this.codigoTarjeta = codigoTarjeta;
	}

}
