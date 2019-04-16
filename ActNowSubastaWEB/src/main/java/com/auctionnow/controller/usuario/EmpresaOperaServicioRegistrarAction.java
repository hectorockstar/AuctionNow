package com.auctionnow.controller.usuario;

import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroEmpresa;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.model.Cargo;
import com.auctionnow.model.Empresa;
import com.auctionnow.model.Servicio;

public class EmpresaOperaServicioRegistrarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Empresa empresa;
	protected Servicio servicio;
	protected FiltroServicio filtroServicio;

	public String showAddServicioEmpresa() {

		FiltroEmpresa filtroEmpresa = new FiltroEmpresa();
		List<Empresa> empresas = getUsuarioEjbRemote().getEmpresas(filtroEmpresa);

		getRequest().put("empresas", empresas);

		return SUCCESS;
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

		return SUCCESS;
	}
	
	public String getServiciosByEmpresa() {

		filtroServicio = new FiltroServicio();
		filtroServicio.setCodigoEmpresa(empresa.getCodigoEmpresa());

		List<Servicio> serviciosEmpresa = getTransaccionEjbRemote().getServiciosByEmpresa(filtroServicio);
		this.getRequest().put("serviciosEmpresa", serviciosEmpresa);

		return SUCCESS;
	}
	
	public String getCargosByServicio() {

		filtroServicio = new FiltroServicio();
		filtroServicio.setCodigoServicio(servicio.getCodigoServicio());

		List<Cargo> cargosServicio = getTransaccionEjbRemote().getCargosByServicio(filtroServicio);
		this.getRequest().put("cargosServicio", cargosServicio);

		return SUCCESS;
	}
	
	public String getServicios() {
		
		FiltroServicio filtroServicio = new FiltroServicio();
		List<Servicio> servicios = getTransaccionEjbRemote().getServicios(filtroServicio);

		if (servicios != null && servicios.size() > 0) {
			this.getRequest().put("servicios", servicios);
			this.getRequest().put("codigoEmpresa", filtroServicio.getCodigoEmpresa());
			this.addActionMessage("Resultados"+servicios.size());
		} else {
			this.addActionError("No hay Resultados");
		}

		return SUCCESS;
	}

	public void addServicioEmpresa() {

		empresa.setServicio(servicio);
		Integer resRegOperaServicio = getUsuarioEjbRemote().addOperacionEmpresa(empresa);
		
		if(resRegOperaServicio == Constantes.UPDATE_DONE){
			this.addActionMessage("Servicio se agrego con exito");
		} else {
			this.addActionError("No es posible agregar Servicio");
		}
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

	public FiltroServicio getFiltroServicio() {
		return filtroServicio;
	}

	public void setFiltroServicio(FiltroServicio filtroServicio) {
		this.filtroServicio = filtroServicio;
	}

}
