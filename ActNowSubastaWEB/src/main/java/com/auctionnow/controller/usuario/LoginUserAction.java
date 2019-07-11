package com.auctionnow.controller.usuario;

import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.exception.AuctionNowServiceException;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroPrivilegio;
import com.auctionnow.filters.FiltroUsuarioWeb;
import com.auctionnow.model.Privilegio;
import com.auctionnow.model.UsuarioWeb;

public class LoginUserAction extends AbstractControllerConfig {

	private static final int VALOR_NUMERICO_0 = 0;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;

	public String loginUser() throws AuctionNowServiceException {

		String tipoUsuarioWeb = getUsuarioEjbRemote().validateUserLogin(userName, password);

		if (tipoUsuarioWeb != null && tipoUsuarioWeb != "") {

			UsuarioWeb usuarioWeb = null;
			List<Privilegio> lstPrivilegios = null;

			FiltroUsuarioWeb filtroUsuarioWeb = new FiltroUsuarioWeb();
			filtroUsuarioWeb.setNombreUsuario(userName);
			filtroUsuarioWeb.setContrasena(password);

			FiltroPrivilegio filtroPrivilegio = new FiltroPrivilegio();
			FiltroCatalogo filtroTipoUsuario = new FiltroCatalogo();

			if (Constantes.TIPOUSUARIO_CLIENTE.equalsIgnoreCase(tipoUsuarioWeb)) {

				usuarioWeb = getUsuarioEjbRemote().getUsuarioWebClienteData(filtroUsuarioWeb);
				filtroTipoUsuario.setValue(Constantes.TIPOUSUARIO_CLIENTE);
				getSession().put("tipoUsuarioWEB", Constantes.TIPOUSUARIO_CLIENTE);

			} else if (Constantes.TIPOUSUARIO_PROVEEDOR.equalsIgnoreCase(tipoUsuarioWeb)) {

				usuarioWeb = getUsuarioEjbRemote().getUsuarioWebProveedorData(filtroUsuarioWeb);
				filtroTipoUsuario.setValue(Constantes.TIPOUSUARIO_PROVEEDOR);
				getSession().put("tipoUsuarioWEB", Constantes.TIPOUSUARIO_PROVEEDOR);

			} else if (Constantes.TIPOUSUARIO_ADMINISTRADOR.equalsIgnoreCase(tipoUsuarioWeb)) {
				
				// TODO
				usuarioWeb = getUsuarioEjbRemote().getUsuarioWebAdministradorData(filtroUsuarioWeb);
				getSession().put("tipoUsuarioWEB", Constantes.TIPOUSUARIO_ADMINISTRADOR);
			} else if (Constantes.TIPOUSUARIO_EMPRESA.equalsIgnoreCase(tipoUsuarioWeb)) {
				
				usuarioWeb = getUsuarioEjbRemote().getUsuarioWebEmpresaData(filtroUsuarioWeb);
				filtroTipoUsuario.setValue(Constantes.TIPOUSUARIO_EMPRESA);
				getSession().put("tipoUsuarioWEB", Constantes.TIPOUSUARIO_EMPRESA);
			}

			filtroTipoUsuario.setTipoCatalogo(Constantes.CATALOGO_USUARIOWEB_TIPO);

			Tupla tupla = getCommonEjbRemote().getParameter(filtroTipoUsuario).get(VALOR_NUMERICO_0);
			filtroPrivilegio.setTipoUsuario(tupla.getId());

			lstPrivilegios = getUsuarioEjbRemote().getPrivilegios(filtroPrivilegio);

			usuarioWeb.setPrivilegios(lstPrivilegios);

			getSession().put("usuarioWeb", usuarioWeb);
			getSession().put("login", true);

			return SUCCESS;
		} else {
			getSession().put("errMsj",true);
			return ERROR;
		}

	}

	public String logoutUser() {
		getSession().clear();
		getSession().put("login", false);

		return SUCCESS;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
