package com.auctionnow.controller.usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.auctionnow.common.Ciudad;
import com.auctionnow.common.Comuna;
import com.auctionnow.common.Constantes;
import com.auctionnow.common.Pais;
import com.auctionnow.common.Region;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroDivGeografica;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.Empresa;
import com.auctionnow.model.Servicio;

public class EmpresaRegistrarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Direccion direccion;
	protected Contacto contacto;
	protected Empresa empresa;
	protected Servicio servicio;
	
	protected FiltroServicio filtroServicio;

	public String showAddEmpresa() {

		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_DIRECCION_TIPO);
		List<Tupla> tipsDirecciones = getCommonEjbRemote().getParameter(filtroCatalogo);

		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_CONTACTO_TIPO);
		List<Tupla> tipsContactos = getCommonEjbRemote().getParameter(filtroCatalogo);

		FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
		List<Pais> paises = getCommonEjbRemote().getPais(filtroDivGeografica);
		
		filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SERVICIO_TIPO);
		List<Tupla> tipsServicios = getCommonEjbRemote().getParameter(filtroCatalogo);

		getRequest().put("tipsServicios", tipsServicios);
		getRequest().put("tipsDirecciones", tipsDirecciones);
		getRequest().put("tipsContactos", tipsContactos);
		getRequest().put("comunas", new ArrayList<Comuna>());
		getRequest().put("ciudades", new ArrayList<Ciudad>());
		getRequest().put("regiones", new ArrayList<Region>());
		getRequest().put("paises", paises);

		return Constantes.SUCCESS;
	}

	public String addEmpresa() {
		// TODO
		// VALIDAR CAMPOS
		
		List<Contacto> contactos = new ArrayList<Contacto>();
		contactos.add(contacto);
		empresa.setContactos(contactos);

		List<Direccion> direcciones = new ArrayList<Direccion>();
		direcciones.add(direccion);
		empresa.setDirecciones(direcciones);

		if (empresa.getServicios() != null && empresa.getServicios().size() > 0) {
			empresa.setVigente("S");
		}
		
		empresa.setServicio(servicio);

		Integer resultado = getUsuarioEjbRemote().addEmpresa(empresa);

		return SUCCESS;
	}

	public String getServiciosByCategoria(){
		
		List<Servicio> servicios = getTransaccionEjbRemote().getServicios(filtroServicio);
		
		getRequest().put("servicios", servicios);
		return SUCCESS;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
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
