package com.auctionnow.controller.usuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.auctionnow.common.Ciudad;
import com.auctionnow.common.Comuna;
import com.auctionnow.common.Constantes;
import com.auctionnow.common.Pais;
import com.auctionnow.common.Region;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.exception.AuctionNowServiceException;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroDivGeografica;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.model.Empresa;
import com.auctionnow.model.Servicio;
import com.auctionnow.model.UsuarioWeb;

public class EmpresaRegistrarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UsuarioWeb usuarioWeb;
	protected Empresa empresa;
	protected Pais pais;
	
	protected FiltroServicio filtroServicio;

	public String showAddUsuarioWebEmpresa() {

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

		return SUCCESS;
	}

	public String addEmpresa() {
		// TODO
		// VALIDAR CAMPOS
		Integer resultado = getUsuarioEjbRemote().addEmpresa(empresa);

		return SUCCESS;
	}
	
	@Transactional(rollbackFor = AuctionNowServiceException.class)
	public String addUsuarioWebEmpresa() throws AuctionNowServiceException {
		//VALIDAR CAMPOS
		empresa.setPais(pais);
		usuarioWeb.setEmpresa(empresa);
		usuarioWeb.setEstadoCuenta(Constantes.NO_ACTIVA);
		
		Tupla tipoUsuarioWeb = new Tupla();
		tipoUsuarioWeb.setId(Constantes.TIPOUSUARIO_SIGLA_EMPRESA);
		usuarioWeb.setTipoUsuarioWeb(tipoUsuarioWeb);
		
		
		Integer resultado = getUsuarioEjbRemote().addCuentaUsuarioEmpresa(usuarioWeb);

		return SUCCESS;
	}

	public String getServiciosByCategoria(){
		
		List<Servicio> servicios = getTransaccionEjbRemote().getServicios(filtroServicio);
		
		getRequest().put("servicios", servicios);
		return SUCCESS;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	public FiltroServicio getFiltroServicio() {
		return filtroServicio;
	}

	public void setFiltroServicio(FiltroServicio filtroServicio) {
		this.filtroServicio = filtroServicio;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
}
