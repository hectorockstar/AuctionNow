package com.auctionnow.controller.transaccion;

import java.util.Date;
import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.model.Servicio;

public class ServicioActualizarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Servicio servicio;

	public String showActualizaServicio() {

		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SERVICIO_TIPO);
		List<Tupla> lstTipServicios = getCommonEjbRemote().getParameter(filtroCatalogo);

		getRequest().put("tiposServicios", lstTipServicios);

		return Constantes.SUCCESS;
	}

	public String actualizaServicio() {

		//// PRUEBA
		servicio = new Servicio();
		servicio.setCodigoServicio("SER006");
		servicio.setDescripcion("Tabiqueria");
		servicio.setFechaRegistro(new Date());
		servicio.setNombre("Tabiqueria");
		servicio.setSigla("TAB");

		Tupla tipoServicio = new Tupla();
		tipoServicio.setId("1");
		tipoServicio.setDescripcion("CONSTRUCCION");
		servicio.setTipoServicio(tipoServicio);
		/////////////

		Integer resRegServicio = getTransaccionEjbRemote().actualizaServicio(servicio);

		return Constantes.SUCCESS;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
}
