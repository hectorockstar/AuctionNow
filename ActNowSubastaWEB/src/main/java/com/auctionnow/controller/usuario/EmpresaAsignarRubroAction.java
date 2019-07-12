package com.auctionnow.controller.usuario;

import java.util.ArrayList;
import java.util.List;

import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroRubro;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.model.Empresa;
import com.auctionnow.model.Rubro;
import com.auctionnow.model.Servicio;
import com.auctionnow.model.UsuarioWeb;

public class EmpresaAsignarRubroAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected UsuarioWeb usuarioWeb;
	protected Rubro rubro;
	
	protected Servicio servicio;
	protected FiltroServicio filtroServicio;
	
	protected String[] estadosServicios;

	public String showAddRubroEmpresa() {
		//SOLO USUARIO EMPRESA
		UsuarioWeb usuarioWebSession = ((UsuarioWeb)getSession().get("usuarioWeb"));
		
		FiltroRubro filtroRubro = new FiltroRubro();
		List<Rubro> lstRubros = getTransaccionEjbRemote().getRubros(filtroRubro);
		
		//SE SETEA USUARIO WEB PARA DESPLEGAR INFO EN LA PAGINA JSP
		setUsuarioWeb(usuarioWebSession);
		
		getRequest().put("rubros", lstRubros);
		getRequest().put("fechaFundacionFormat", this.getFechaFormat(usuarioWebSession.getEmpresa().getFechaOperaDesde()));

		return SUCCESS;
	}
	
	public String getServiciosByRubro() {
		
		FiltroServicio filtroServicio = new FiltroServicio();
		filtroServicio.setCodigoRubro(rubro.getCodigoRubro());
		List<Servicio> lstServicio = getTransaccionEjbRemote().getServicios(filtroServicio);
		
		getRequest().put("servicios", lstServicio);
		
		return SUCCESS;
	}
	
	public String asignaRubroServiciosEmpresa() {
		
		UsuarioWeb usuarioWebSession = ((UsuarioWeb)getSession().get("usuarioWeb"));
		
		Empresa empresa = usuarioWebSession.getEmpresa();
		
		Rubro rubroAsignado = getTransaccionEjbRemote().asignaRubroServiciosEmpresa(empresa.getCodigoEmpresa(), rubro, estadosServicios);
		
		List<Rubro> rubros = empresa.getRubros();
		if(rubros == null) {
			rubros = new ArrayList<Rubro>();
			rubros.add(rubroAsignado);
		} 
		rubros.add(rubroAsignado);
		empresa.setRubros(rubros);
		usuarioWebSession.setEmpresa(empresa);
		
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
//		filtroServicio.setCodigoEmpresa(empresa.getCodigoEmpresa());

		List<Servicio> serviciosEmpresa = getTransaccionEjbRemote().getServiciosByEmpresa(filtroServicio);
		this.getRequest().put("serviciosEmpresa", serviciosEmpresa);

		return SUCCESS;
	}
	
	public String getCargosByServicio() {


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

	}
	
	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
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

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

	public String[] getEstadosServicios() {
		return estadosServicios;
	}

	public void setEstadosServicios(String[] estadosServicios) {
		this.estadosServicios = estadosServicios;
	}
}
