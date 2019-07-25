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
		
		UsuarioWeb usuarioWebSession = ((UsuarioWeb)getSession().get("usuarioWeb"));
		
		FiltroServicio filtroServicio = new FiltroServicio();
		List<Servicio> servicios = getTransaccionEjbRemote().getServicios(filtroServicio);
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_DIRECCION_TIPO);
		List<Tupla> tipsDirecciones = getCommonEjbRemote().getParameters(filtroCatalogo);

		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_CONTACTO_TIPO);
		List<Tupla> tipsContactos = getCommonEjbRemote().getParameters(filtroCatalogo);
		
		filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_GENERO);
		List<Tupla> generos = getCommonEjbRemote().getParameters(filtroCatalogo);
		
		FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
		List<Pais> paises = getCommonEjbRemote().getPais(filtroDivGeografica);

		List<Empresa> empresas = null;
		if(usuarioWebSession != null && Constantes.TIPOUSUARIO_SIGLA_EMPRESA.equals(usuarioWebSession.getTipoUsuarioWeb().getId())) {
			FiltroEmpresa filtroEmpresa = new FiltroEmpresa();
			filtroEmpresa.setCodigoEmpresa(usuarioWebSession.getEmpresa().getCodigoEmpresa());
			empresas = getUsuarioEjbRemote().getEmpresas(filtroEmpresa);
			
			getRequest().put("rubrosEmpresa", new ArrayList<Comuna>());
			getRequest().put("serviciosActivosEmpresa", new ArrayList<Ciudad>());
			getRequest().put("cargosServicio", new ArrayList<Region>());
		}
		
		getRequest().put("empresas", empresas);
		getRequest().put("tipsDirecciones", tipsDirecciones);
		getRequest().put("tipsContactos", tipsContactos);
		getRequest().put("generos", generos);
		getRequest().put("servicios", servicios);
		getRequest().put("comunas", new ArrayList<Comuna>());
		getRequest().put("ciudades", new ArrayList<Ciudad>());
		getRequest().put("regiones", new ArrayList<Region>());
		getRequest().put("paises", paises);

		return SUCCESS;
	}

	public String addUsuarioWebProveedor() throws AuctionNowServiceException {
		// VALIDAR CAMPOS
		
		Tupla tipoProveedor = new Tupla();
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_PROVEEDOR_TIPO);
		if(empresa != null) {
			proveedor.setEmpresa(empresa);
			proveedor.setCargo(cargo);
			filtroCatalogo.setKey(Constantes.TIPOPROVEEDOR_DEPENDIENTE);
		} else {
			filtroCatalogo.setKey(Constantes.TIPOPROVEEDOR_INDEPENDIENTE);
		}
		
		tipoProveedor = getCommonEjbRemote().getParameter(filtroCatalogo);
		
		proveedor.setTipoProveedor(tipoProveedor);
		proveedor.setPais(pais);
		
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
