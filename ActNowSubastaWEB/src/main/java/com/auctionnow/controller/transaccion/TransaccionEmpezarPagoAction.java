package com.auctionnow.controller.transaccion;

import java.util.Date;
import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroTransaccion;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.MedioPago;
import com.auctionnow.model.Tarjeta;
import com.auctionnow.model.Transaccion;
import com.auctionnow.model.UsuarioWeb;

public class TransaccionEmpezarPagoAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected MedioPago medioPago;
	protected String codigoTransaccion;
	protected String monedaLocal;

	public String showTransaccionesCliente() {
		UsuarioWeb usuarioWeb = (UsuarioWeb) getSession().get("usuarioWeb");
		Cliente cliente = (Cliente) usuarioWeb.getUsuario();

		FiltroTransaccion filtroTransaccion = new FiltroTransaccion();
		filtroTransaccion.setCodigoCliente(cliente.getCodigoCliente());
		List<Transaccion> transacciones = getTransaccionEjbRemote().getTransacciones(filtroTransaccion);

		getRequest().put("transacciones", transacciones);

		return Constantes.SUCCESS;
	}

	public String showDetalleTransaccion() {

		// PRUEBA
		setCodigoTransaccion("TRANS0001");
		////////

		FiltroTransaccion filtroTransaccion = new FiltroTransaccion();
		filtroTransaccion.setCodigoTransaccion(codigoTransaccion); // VIENE
																	// DESDE LA
																	// VISTA
		Transaccion transaccion = getTransaccionEjbRemote().getTransacciones(filtroTransaccion).get(0);

		getRequest().put("transaccion", transaccion);

		return Constantes.SUCCESS;
	}

	public String showEmpezarPago() {

		////// PRUEBA
		setCodigoTransaccion("TRANS0001");
		///////

		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_VIAPAGO_TIPO);
		List<Tupla> tipsViaPago = getCommonEjbRemote().getParameter(filtroCatalogo);

		filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_MONEDA_TIPO);
		List<Tupla> tipsMoneda = getCommonEjbRemote().getParameter(filtroCatalogo);

		filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_TARJETA_TIPO);
		List<Tupla> tipsTarjeta = getCommonEjbRemote().getParameter(filtroCatalogo);

		filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_ENTIDAD_COMERCIAL);
		List<Tupla> tipsEntidad = getCommonEjbRemote().getParameter(filtroCatalogo);

		FiltroTransaccion filtroTransaccion = new FiltroTransaccion();
		filtroTransaccion.setCodigoTransaccion(codigoTransaccion);
		Transaccion transaccion = getTransaccionEjbRemote().getTransaccion(filtroTransaccion);

		getRequest().put("transaccion", transaccion);
		getRequest().put("tipsViaPago", tipsViaPago);
		getRequest().put("tipsMoneda", tipsMoneda);
		getRequest().put("tipsTarjeta", tipsTarjeta);
		getRequest().put("tipsEntidad", tipsEntidad);

		return Constantes.SUCCESS;
	}

	public String addPagoTransaccion() {
		////// PRUEBA
		setCodigoTransaccion("TRANS0001");

		medioPago = new MedioPago();
		medioPago.setCodigoPago("PAG0001");
		medioPago.setCuotas(3);

		Tupla viaPago = new Tupla();
		viaPago.setId("1");
		medioPago.setViaPago(viaPago);

		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setCodigoRegistro("TAR0001");

		Tupla tipoEntidad = new Tupla();
		tipoEntidad.setId("1");
		tarjeta.setEntidad(tipoEntidad);

		tarjeta.setFechaExpiracion("11/12");
		tarjeta.setNumeroTarjeta("876538364567");

		Tupla tipoTarjeta = new Tupla();
		tipoTarjeta.setId("1");
		tarjeta.setTipoTarjeta(tipoTarjeta);
		medioPago.setTarjeta(tarjeta);
		///////

		FiltroTransaccion filtroTransaccion = new FiltroTransaccion();
		filtroTransaccion.setCodigoTransaccion(codigoTransaccion);
		Transaccion transaccion = getTransaccionEjbRemote().getTransaccion(filtroTransaccion);

		Long montoTotal = transaccion.getMontoTotal();
		medioPago.setTotalCompra(montoTotal);
		medioPago.setValorCuota(montoTotal / medioPago.getCuotas());

		medioPago.setDescripcion("");
		medioPago.setFechaPago(new Date());

		Integer regMedPag = getTransaccionEjbRemote().addMedioPago(medioPago);

		if (regMedPag != null && regMedPag > 0) {
			transaccion.setMedioPago(medioPago);

			Tupla tipoMoneda = new Tupla();
			tipoMoneda.setId(monedaLocal);
			transaccion.setTipoMoneda(tipoMoneda);
			transaccion.setEstadoTransaccion("P");
			Integer updTransaccion = getTransaccionEjbRemote().actualizaTransaccion(transaccion);
		}

		return Constantes.SUCCESS;
	}

	public String getCodigoTransaccion() {
		return codigoTransaccion;
	}

	public void setCodigoTransaccion(String codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}

	public MedioPago getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}

	public String getMonedaLocal() {
		return monedaLocal;
	}

	public void setMonedaLocal(String monedaLocal) {
		this.monedaLocal = monedaLocal;
	}

}
