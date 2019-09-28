package com.auctionnow.controller.transaccion;

import java.util.ArrayList;
import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCargo;
import com.auctionnow.filters.FiltroDireccion;
import com.auctionnow.filters.FiltroRubro;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.model.Cargo;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.Empresa;
import com.auctionnow.model.Rubro;
import com.auctionnow.model.Servicio;
import com.auctionnow.model.UsuarioWeb;

public class AsignarRubroAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected UsuarioWeb usuarioWeb;
	
	protected Empresa empresa;
	protected Rubro rubro;
	protected Servicio servicio;
	protected Cargo cargo;
	protected FiltroServicio filtroServicio;
	
	protected String[] estadosServicios;

	public String showAddRubroEmpresa() {
		//SOLO USUARIO EMPRESA
		UsuarioWeb usuarioWebSession = ((UsuarioWeb)getSession().get("usuarioWeb"));
		
		Empresa empresa = usuarioWebSession.getEmpresa();
		
		FiltroRubro filtroRubro = new FiltroRubro();
		filtroRubro.setRubros(empresa.getRubros());
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
		} 
		
		rubros.add(rubroAsignado);
		empresa.setRubros(rubros);
		usuarioWebSession.setEmpresa(empresa);
		
		this.getSession().put("usuarioWeb", usuarioWebSession);
		
		return SUCCESS;
	}

	public String getServiciosByEmpresa() {

		filtroServicio = new FiltroServicio();
//		filtroServicio.setCodigoEmpresa(empresa.getCodigoEmpresa());

		List<Servicio> serviciosEmpresa = getTransaccionEjbRemote().getServiciosByEmpresa(filtroServicio);
		this.getRequest().put("serviciosEmpresa", serviciosEmpresa);

		return SUCCESS;
	}
	
	public String getRubrosByEmpresa() {
		FiltroRubro filtroRubro = new FiltroRubro();
		filtroRubro.setCodigoTitular(empresa.getCodigoEmpresa());
		List<Rubro> lstRubrosByEmpresa = getTransaccionEjbRemote().getRubrosByTitular(filtroRubro);
		this.getRequest().put("rubrosEmpresa", lstRubrosByEmpresa);
		
		this.jsonFormatResult(lstRubrosByEmpresa);
		
		return SUCCESS;
	}
	
	public String getServiciosActivosByRubroEmpresa() {
		FiltroServicio filtroServicio = new FiltroServicio();
		filtroServicio.setCodigoRubro(rubro.getCodigoRubro());
		filtroServicio.setCodigoTitular(empresa.getCodigoEmpresa());
		filtroServicio.setCodigoEjerce(rubro.getCodigoEjerce());
		filtroServicio.setActivoEjercer(Constantes.ACTIVA);
		
		List<Servicio> lstServiciosByRubro = getTransaccionEjbRemote().getServiciosByRubroTitular(filtroServicio);
		this.getRequest().put("serviciosActivosRubro", lstServiciosByRubro);
		
		this.jsonFormatResult(lstServiciosByRubro);

		return SUCCESS;
	}
	
	public String getCargosByServicio() {
		FiltroCargo filtroCargo = new FiltroCargo();
		filtroCargo.setCodigoServicio(servicio.getCodigoServicio());
		filtroCargo.setActivo(Constantes.ACTIVO);
		
		List<Cargo> lstCargosByServicio = getTransaccionEjbRemote().getCargosByServicio(filtroCargo);
		this.getRequest().put("cargosServicio", lstCargosByServicio);
		
		this.jsonFormatResult(lstCargosByServicio);

		return SUCCESS;
	}	
	
	public String getServicios() {
		
		FiltroServicio filtroServicio = new FiltroServicio();
		List<Servicio> servicios = getTransaccionEjbRemote().getServicios(filtroServicio);

		if (servicios != null && servicios.size() > 0) {
			this.getRequest().put("servicios", servicios);
//			this.getRequest().put("codigoEmpresa", filtroServicio.getCodigoEmpresa());
			this.addActionMessage("Resultados "+servicios.size());
		} else {
			this.addActionError("No hay Resultados");
		}

		return SUCCESS;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
