package com.auctionnow.controller.usuario;

import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.common.Pais;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroDivGeografica;
import com.auctionnow.model.Empresa;
import com.auctionnow.model.UsuarioWeb;

public class EmpresaActualizarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected UsuarioWeb usuarioWeb;
	protected Empresa empresa;

	public String showActualizaUsuarioWebEmpresa() {
		UsuarioWeb usuarioWebSession = ((UsuarioWeb)getSession().get("usuarioWeb"));
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_VIGENTE);
		List<Tupla> vigencias = getCommonEjbRemote().getParameter(filtroCatalogo);

		FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
		List<Pais> paises = getCommonEjbRemote().getPais(filtroDivGeografica);
		
		//SE SETEA USUARIO WEB PARA DESPLEGAR INFO EN LA PAGINA JSP
		setUsuarioWeb(usuarioWebSession);
		
		getRequest().put("vigencias", vigencias);
		getRequest().put("paises", paises);
		getRequest().put("fechaFundacionFormat", this.getFechaFormat(usuarioWebSession.getEmpresa().getFechaOperaDesde()));

		return SUCCESS;
	}

	public String actualizaUsuarioWebEmpresa() {
		
		// VALIDAR CAMPOS
		UsuarioWeb updateUsuarioWeb = (UsuarioWeb) getSession().get("usuarioWeb");
		
		updateUsuarioWeb.getEmpresa().setNombreEmpresa(empresa.getNombreEmpresa());
		updateUsuarioWeb.getEmpresa().setRut(empresa.getRut());
		updateUsuarioWeb.getEmpresa().setRutDV(empresa.getRutDV());
		updateUsuarioWeb.getEmpresa().setDescripcion(empresa.getDescripcion());
		updateUsuarioWeb.getEmpresa().setFechaOperaDesde(empresa.getFechaOperaDesde());
		updateUsuarioWeb.getEmpresa().setVigente(empresa.getVigente());
		
		updateUsuarioWeb.setContrasena(usuarioWeb.getContrasena().trim());
		updateUsuarioWeb.setRespuesta1(usuarioWeb.getRespuesta1().trim());
		updateUsuarioWeb.setRespuesta2(usuarioWeb.getRespuesta2().trim());
		updateUsuarioWeb.setRespuesta3(usuarioWeb.getRespuesta3().trim());
		updateUsuarioWeb.setFirmaComentario(usuarioWeb.getFirmaComentario().trim());
		updateUsuarioWeb.setEstadoCuenta(Constantes.ACTIVA); //TODO EL ADMIN PUEDE MODIFICAR ESTE ATRIBUTO
		
		Tupla tipoUsuarioWeb = new Tupla();
		tipoUsuarioWeb.setId(Constantes.TIPOUSUARIO_SIGLA_EMPRESA);
		updateUsuarioWeb.setTipoUsuarioWeb(tipoUsuarioWeb);

		Integer resultado = getUsuarioEjbRemote().actualizaCuentaUsuarioEmpresa(updateUsuarioWeb);
		if (resultado != null && resultado != 0) {
			getSession().remove("usuarioWeb");
			getSession().put("usuarioWeb", updateUsuarioWeb);
		}

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
	
}
