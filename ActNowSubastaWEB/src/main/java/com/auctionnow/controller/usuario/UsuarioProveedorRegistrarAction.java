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
import com.auctionnow.exception.AuctionNowServiceException;
import com.auctionnow.filters.FiltroCargo;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroDivGeografica;
import com.auctionnow.filters.FiltroEmpresa;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.filters.FiltroUsuarioWeb;
import com.auctionnow.model.Cargo;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.Empresa;
import com.auctionnow.model.Proveedor;
import com.auctionnow.model.Servicio;
import com.auctionnow.model.UsuarioWeb;

public class UsuarioProveedorRegistrarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected UsuarioWeb usuarioWeb;
	protected Proveedor proveedor;
	protected Empresa empresa;
	protected Servicio servicio;
	protected Cargo cargo;
	protected Pais pais;

	public String showRegistrarUsuarioProveedor() throws AuctionNowServiceException {
		
		FiltroServicio filtroServicio = new FiltroServicio();
		List<Servicio> servicios = getTransaccionEjbRemote().getServicios(filtroServicio);
		
		FiltroEmpresa filtroEmpresa = new FiltroEmpresa();
		List<Empresa> empresas = getUsuarioEjbRemote().getEmpresas(filtroEmpresa);
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_DIRECCION_TIPO);
		List<Tupla> tipsDirecciones = getCommonEjbRemote().getParameter(filtroCatalogo);

		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_CONTACTO_TIPO);
		List<Tupla> tipsContactos = getCommonEjbRemote().getParameter(filtroCatalogo);
		
		FiltroCargo filtroCargo = new FiltroCargo();
		List<Cargo> cargos = getUsuarioEjbRemote().getCargos(filtroCargo);
		
		filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_GENERO);
		List<Tupla> generos = getCommonEjbRemote().getParameter(filtroCatalogo);
		
		FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
		List<Pais> paises = getCommonEjbRemote().getPais(filtroDivGeografica);

		getRequest().put("tipsDirecciones", tipsDirecciones);
		getRequest().put("tipsContactos", tipsContactos);
		getRequest().put("generos", generos);
		getRequest().put("servicios", servicios);
		getRequest().put("cargos", cargos);
		getRequest().put("empresas", empresas);
		getRequest().put("comunas", new ArrayList<Comuna>());
		getRequest().put("ciudades", new ArrayList<Ciudad>());
		getRequest().put("regiones", new ArrayList<Region>());
		getRequest().put("paises", paises);

		return SUCCESS;
	}

	public String addUsuarioWebProveedor() throws AuctionNowServiceException {
		// VALIDAR CAMPOS
		proveedor.setPais(pais);
		proveedor.setEmpresa(empresa);
		proveedor.setServicio(servicio);
		proveedor.setCargo(cargo);
		
		usuarioWeb.setUsuario(proveedor);
		usuarioWeb.setEstadoCuenta(Constantes.ACTIVA);
		
		Tupla tipoUsuarioWeb = new Tupla();
		tipoUsuarioWeb.setId(Constantes.TIPOUSUARIO_SIGLA_PROVEEDOR);
		usuarioWeb.setTipoUsuarioWeb(tipoUsuarioWeb);
		
		Integer resultado = getUsuarioEjbRemote().addCuentaUsuarioProveedor(usuarioWeb);

		return SUCCESS;
	}

	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
}
