package com.auctionnow.controller.transaccion;

import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.model.Servicio;

public class ServicioRegistrarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Servicio servicio;

	public String showRegistrarServicio() {

		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SERVICIO_TIPO);
		List<Tupla> tipsServicios = getCommonEjbRemote().getParameter(filtroCatalogo);

		getRequest().put("tipsServicios", tipsServicios);

		return SUCCESS;
	}

	public String addServicio() {
		// VALIDAR CAMPOS
		// TODO

		Integer resRegServicio = getTransaccionEjbRemote().addServicio(servicio);

		return SUCCESS;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}
