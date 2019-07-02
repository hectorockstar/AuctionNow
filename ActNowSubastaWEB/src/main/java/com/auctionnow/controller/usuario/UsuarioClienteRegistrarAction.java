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
import com.auctionnow.filters.FiltroEmpresa;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.Empresa;
import com.auctionnow.model.Servicio;
import com.auctionnow.model.UsuarioWeb;
import com.auctionnow.utils.AuctionNowValidateUtils;

public class UsuarioClienteRegistrarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected UsuarioWeb usuarioWeb;
	protected Cliente cliente;
	protected Pais pais;

	@Transactional(rollbackFor = AuctionNowServiceException.class)
	public String showRegistarUsuarioCliente() {

		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_DIRECCION_TIPO);
		List<Tupla> tipsDirecciones = getCommonEjbRemote().getParameter(filtroCatalogo);
		
		filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_CONTACTO_TIPO);
		List<Tupla> tipsContactos = getCommonEjbRemote().getParameter(filtroCatalogo);

		filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_GENERO);
		List<Tupla> generos = getCommonEjbRemote().getParameter(filtroCatalogo);

		FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
		List<Pais> paises = getCommonEjbRemote().getPais(filtroDivGeografica);
		
		getRequest().put("tipsDirecciones", tipsDirecciones);
		getRequest().put("tipsContactos", tipsContactos);
		getRequest().put("generos", generos);
		getRequest().put("comunas", new ArrayList<Comuna>());
		getRequest().put("ciudades", new ArrayList<Ciudad>());
		getRequest().put("regiones", new ArrayList<Region>());
		getRequest().put("paises", paises);

		return SUCCESS;
	}

	@Transactional(rollbackFor = AuctionNowServiceException.class)
	public String addUsuarioWebCliente() throws AuctionNowServiceException {

		cliente.setPais(pais);
		
		usuarioWeb.setUsuario(cliente);
		usuarioWeb.setEstadoCuenta(Constantes.ACTIVA);

		Tupla tipoUsuarioWeb = new Tupla();
		tipoUsuarioWeb.setId(Constantes.TIPOUSUARIO_SIGLA_CLIENTE);
		usuarioWeb.setTipoUsuarioWeb(tipoUsuarioWeb);

		// VALIDAR CAMPOS
		boolean validador = validateFields(usuarioWeb);

		Integer resultado = getUsuarioEjbRemote().addCuentaUsuarioCliente(usuarioWeb);

		return "SUCCESS";
	}

	private boolean validateFields(UsuarioWeb usuarioWeb) {
		AuctionNowValidateUtils rule = new AuctionNowValidateUtils();

		boolean indicador = false;

		if ((usuarioWeb.getUsuario().getRut() != null && usuarioWeb.getUsuario().getRutDV() != null)
				&& (!("".equals(usuarioWeb.getUsuario().getRut())) && !("".equals(usuarioWeb.getUsuario().getRutDV())))
				&& rule.validarRut(usuarioWeb.getUsuario().getRut() + usuarioWeb.getUsuario().getRutDV())) {
			indicador = true;
		}
		//AGREGAR MAS REGLAS

		return indicador;
	}

	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
