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
	protected Direccion direccion;
	protected Contacto contacto;

	public String showActualizaUsuarioProveedor() throws AuctionNowServiceException {

		UsuarioWeb usuWeb = (UsuarioWeb) getSession().get("usuarioWeb");
		setUsuarioWeb(usuWeb);

		List<Direccion> direcciones = getUsuarioEjbRemote().asignarComunaDireccion(getUsuarioWeb().getUsuario().getDirecciones());
		usuarioWeb.getUsuario().setDirecciones(direcciones);
		
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
		List<Region> regiones = getCommonEjbRemote().getRegion(filtroDivGeografica);
		List<Ciudad> ciudades = getCommonEjbRemote().getCiudad(filtroDivGeografica);
		List<Comuna> comunas= getCommonEjbRemote().getComuna(filtroDivGeografica);
		
		FiltroEmpresa filtroEmpresa = new FiltroEmpresa();
		List<Empresa> empresas = getUsuarioEjbRemote().getEmpresas(filtroEmpresa);
		
		getRequest().put("codigoTitular", usuarioWeb.getUsuario().getCodigoUsuario());
		getRequest().put("tipsDirecciones", tipsDirecciones);
		getRequest().put("tipsContactos", tipsContactos);
		getRequest().put("generos", generos);
		getRequest().put("empresas", empresas);
		getRequest().put("comunas", comunas);
		getRequest().put("ciudades", ciudades);
		getRequest().put("regiones", regiones);
		getRequest().put("paises", paises);
		getRequest().put("usuarioWeb", usuarioWeb);

		return "SUCCESS";
	}

	public String actualizaUsuarioWebProveedor() throws AuctionNowServiceException {
		// VALIDAR CAMPOS

		// //////////////PRUEBA
		usuarioWeb = new UsuarioWeb();
		usuarioWeb.setCodigoUsuarioWeb("100");
		usuarioWeb.setContrasena("hrs");
		usuarioWeb.setEstadoCuenta("A");
		usuarioWeb.setFirmaComentario("CHAUUUUU!");
		usuarioWeb.setNombreUsuario("hector123");
		usuarioWeb.setPregunta1("?13454");
		usuarioWeb.setPregunta2("?23453");
		usuarioWeb.setPregunta3("?33454");
		usuarioWeb.setRespuesta1("R134534");
		usuarioWeb.setRespuesta2("R2345345");
		usuarioWeb.setRespuesta3("R3345345");

		Tupla tipoUsuarioWeb = new Tupla();
		tipoUsuarioWeb.setId("P");
		tipoUsuarioWeb.setDescripcion("PROVEEDOR");
		usuarioWeb.setTipoUsuarioWeb(tipoUsuarioWeb);

		Proveedor proveedor = new Proveedor();
		proveedor.setApellidoMaterno("tapi");
		proveedor.setApellidoPaterno("gon");
		proveedor.setCodigoProveedor("3");
		proveedor.setCodigoUsuario("3");
		proveedor.setFechaNacimiento(new Date());
		proveedor.setFechaRegistro(new Date());

		Tupla genero = new Tupla();
		genero.setId("M");
		proveedor.setGenero(genero);
		
		proveedor.setNombre("Hector ");
		proveedor.setOcupacion("Est");
		proveedor.setRut("18092256");
		proveedor.setRutDV("7");
		
		Tupla tipoUsuario = new Tupla();
		tipoUsuario.setId("P");
		tipoUsuario.setDescripcion("PROVEEDOR");
		proveedor.setTipoUsuario(tipoUsuario);

		usuarioWeb.setUsuario(proveedor);
		// //////////////PRUEBA

		Integer resultado = getUsuarioEjbRemote().actualizaCuentaUsuarioProveedor(usuarioWeb);
		if (resultado != null && resultado != 0) {
			getSession().remove("usuarioWeb");
			getSession().put("usuarioWeb", getUsuarioWeb());
		}

		return "SUCCESS";
	}

	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}
}
