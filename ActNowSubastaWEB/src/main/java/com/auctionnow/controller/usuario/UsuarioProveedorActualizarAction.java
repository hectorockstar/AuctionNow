package com.auctionnow.controller.usuario;

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
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroDivGeografica;
import com.auctionnow.filters.FiltroEmpresa;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.Empresa;
import com.auctionnow.model.Proveedor;
import com.auctionnow.model.UsuarioWeb;

public class UsuarioProveedorActualizarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected UsuarioWeb usuarioWeb;
	protected Proveedor proveedor;

	public String showActualizaUsuarioProveedor() throws AuctionNowServiceException {

		UsuarioWeb usuWeb = (UsuarioWeb) getSession().get("usuarioWeb");
		setUsuarioWeb(usuWeb);
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_GENERO);
		List<Tupla> generos = getCommonEjbRemote().getParameters(filtroCatalogo);
		
		FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
		List<Pais> paises = getCommonEjbRemote().getPais(filtroDivGeografica);
		
		FiltroEmpresa filtroEmpresa = new FiltroEmpresa();
		List<Empresa> empresas = getUsuarioEjbRemote().getEmpresas(filtroEmpresa);
		
		getRequest().put("codigoTitular", usuarioWeb.getUsuario().getCodigoUsuario());
		getRequest().put("generos", generos);
		getRequest().put("empresas", empresas);
		getRequest().put("paises", paises);
		getRequest().put("usuarioWeb", usuarioWeb);

		return SUCCESS;
	}

	public String actualizaUsuarioWebProveedor() throws AuctionNowServiceException {
		// VALIDAR CAMPOS
		UsuarioWeb updateUsuarioWeb = (UsuarioWeb) getSession().get("usuarioWeb");
		
		updateUsuarioWeb.getUsuario().setNombre(proveedor.getNombre().trim());
		updateUsuarioWeb.getUsuario().setApellidoPaterno(proveedor.getApellidoPaterno().trim());
		updateUsuarioWeb.getUsuario().setApellidoMaterno(proveedor.getApellidoMaterno().trim());
		updateUsuarioWeb.getUsuario().setRut(proveedor.getRut().trim());
		updateUsuarioWeb.getUsuario().setRutDV(proveedor.getRutDV().trim());
		updateUsuarioWeb.getUsuario().setGenero(proveedor.getGenero());
		updateUsuarioWeb.getUsuario().setFechaNacimiento(proveedor.getFechaNacimiento());
		
		updateUsuarioWeb.setContrasena(usuarioWeb.getContrasena().trim());
		updateUsuarioWeb.setRespuesta1(usuarioWeb.getRespuesta1().trim());
		updateUsuarioWeb.setRespuesta2(usuarioWeb.getRespuesta2().trim());
		updateUsuarioWeb.setRespuesta3(usuarioWeb.getRespuesta3().trim());
		updateUsuarioWeb.setFirmaComentario(usuarioWeb.getFirmaComentario().trim());
		updateUsuarioWeb.setEstadoCuenta(Constantes.ACTIVA); //TODO EL ADMIN PUEDE MODIFICAR ESTE ATRIBUTO
		
		Tupla tipoUsuarioWeb = new Tupla();
		tipoUsuarioWeb.setId(Constantes.TIPOUSUARIO_SIGLA_PROVEEDOR);
		updateUsuarioWeb.setTipoUsuarioWeb(tipoUsuarioWeb);

		Integer resultado = getUsuarioEjbRemote().actualizaCuentaUsuarioCliente(updateUsuarioWeb);
		if (resultado != null && resultado != 0) {
			getSession().remove("usuarioWeb");
			getSession().put("usuarioWeb", updateUsuarioWeb);
		}

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
}
