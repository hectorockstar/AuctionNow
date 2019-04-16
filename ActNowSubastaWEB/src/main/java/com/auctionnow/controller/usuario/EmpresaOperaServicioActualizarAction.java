package com.auctionnow.controller.usuario;

import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroEmpresa;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.model.Empresa;
import com.auctionnow.model.Servicio;

public class EmpresaOperaServicioActualizarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Empresa empresa;
	protected Servicio servicio;
	protected FiltroServicio filtroServicio;

	public String showActualizaServicioEmpresa() {

		FiltroEmpresa filtroEmpresa = new FiltroEmpresa();
		List<Empresa> empresas = getUsuarioEjbRemote().getEmpresas(filtroEmpresa);

		getRequest().put("empresas", empresas);
	
		return Constantes.SUCCESS;
	}

	public String getServiciosEmpresa() {

		List<Servicio> serviciosEmpresa = getTransaccionEjbRemote().getServiciosByEmpresa(filtroServicio);

		if (serviciosEmpresa != null && serviciosEmpresa.size() > 0) {

			this.getRequest().put("countServicios", serviciosEmpresa.size());
			this.getRequest().put("serviciosEmpresa", serviciosEmpresa);
			this.getRequest().put("verResultadosFiltro", 1);
		} else {
			// TODO
			/// Arrojar mensaje que no hay resultados!!
		}

		return NONE;
	}

	public String actualizaServicioEmpresa() {

		empresa.setServicio(servicio);

		Integer resUpdServicioEmpresa = getUsuarioEjbRemote().actualizaOperacionEmpresa(empresa);

		return Constantes.SUCCESS;
	}

	public FiltroServicio getFiltroServicio() {
		return filtroServicio;
	}

	public void setFiltroServicio(FiltroServicio filtroServicio) {
		this.filtroServicio = filtroServicio;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}
