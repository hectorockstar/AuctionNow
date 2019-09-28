package com.auctionnow.controller.transaccion;

import java.util.List;

import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.model.Servicio;

public class AsignarServicioAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Servicio servicio;

	public String getServiciosActivosByRubro() {

		FiltroServicio filtroServicio = new FiltroServicio();
		filtroServicio.setCodigoRubro(servicio.getRubro().getCodigoRubro());

		List<Servicio> serviciosActivosByRubro = getTransaccionEjbRemote().getServicios(filtroServicio);
		this.getRequest().put("serviciosActivosByRubro", serviciosActivosByRubro);

		this.jsonFormatResult(serviciosActivosByRubro);

		return SUCCESS;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}
