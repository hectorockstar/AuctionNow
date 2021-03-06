package com.auctionnow.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import com.auctionnow.business.usuario.IUsuarioBusiness;
import com.auctionnow.filters.FiltroCargo;
import com.auctionnow.filters.FiltroCliente;
import com.auctionnow.filters.FiltroContacto;
import com.auctionnow.filters.FiltroDireccion;
import com.auctionnow.filters.FiltroEmpresa;
import com.auctionnow.filters.FiltroGeoLoc;
import com.auctionnow.filters.FiltroPrivilegio;
import com.auctionnow.filters.FiltroProveedor;
import com.auctionnow.filters.FiltroUsuarioWeb;
import com.auctionnow.model.Cargo;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.Empresa;
import com.auctionnow.model.FichaServicioCliente;
import com.auctionnow.model.FichaServicioProveedor;
import com.auctionnow.model.GeoLocalizacion;
import com.auctionnow.model.Privilegio;
import com.auctionnow.model.Proveedor;
import com.auctionnow.model.UsuarioWeb;
import com.auctionnow.model.UsuarioWebTienePrivilegio;

@Stateless(name = "UsuarioEjb")
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class UsuarioEjb implements IUsuarioEjbRemote, IUsuarioEjbLocal {

	@Autowired
	private IUsuarioBusiness usuarioBusiness;

	public UsuarioEjb() {

	}

	public Integer addCuentaUsuarioCliente(UsuarioWeb usuarioWeb) {
		System.out.println("EJB CUENTA USUARIO");

		return usuarioBusiness.addCuentaUsuarioCliente(usuarioWeb);
	}

	public Integer addCuentaUsuarioProveedor(UsuarioWeb usuarioWeb) {
		return usuarioBusiness.addCuentaUsuarioProveedor(usuarioWeb);
	}

	public Integer addEmpresa(Empresa empresa) {
		return usuarioBusiness.addEmpresa(empresa);
	}

	public Integer addContacto(Contacto contacto, String codigoTitular) {
		return usuarioBusiness.addContacto(contacto, codigoTitular);
	}

	public Integer addDireccion(Direccion direccion, String codigoTitular) {
		return usuarioBusiness.addDireccion(direccion, codigoTitular);
	}

	public Integer actualizaCuentaUsuarioCliente(UsuarioWeb usuarioWeb) {
		return usuarioBusiness.actualizaCuentaUsuarioCliente(usuarioWeb);
	}

	public Integer actualizaCuentaUsuarioProveedor(UsuarioWeb usuarioWeb) {
		return usuarioBusiness.actualizaCuentaUsuarioProveedor(usuarioWeb);
	}

	public Integer actualizaEmpresa(Empresa empresa) {
		return usuarioBusiness.actualizaEmpresa(empresa);
	}

	public Integer actualizaContacto(Contacto contacto, String codigoTitular) {
		return usuarioBusiness.actualizaContacto(contacto, codigoTitular);
	}

	public Integer actualizaDireccion(Direccion direccion, String codigoTitular) {
		return usuarioBusiness.actualizaDireccion(direccion, codigoTitular);
	}

	public UsuarioWeb getUsuarioWebClienteData(FiltroUsuarioWeb filtroUsuarioWeb) {
		return usuarioBusiness.getUsuarioWebClienteData(filtroUsuarioWeb);
	}

	public UsuarioWeb getUsuarioWebProveedorData(FiltroUsuarioWeb filtroUsuarioWeb) {
		return usuarioBusiness.getUsuarioWebProveedorData(filtroUsuarioWeb);
	}

	public List<Empresa> getEmpresas(FiltroEmpresa filtroEmpresa) {
		return usuarioBusiness.getEmpresas(filtroEmpresa);
	}

	public Contacto getContacto(FiltroContacto filtroContacto) {
		return usuarioBusiness.getContacto(filtroContacto);
	}

	public Direccion getDireccion(FiltroDireccion filtroDireccion) {
		return usuarioBusiness.getDireccion(filtroDireccion);
	}

	public List<UsuarioWeb> getUsuariosWebCliente(FiltroUsuarioWeb filtroUsuarioWeb) {
		return usuarioBusiness.getUsuariosWebCliente(filtroUsuarioWeb);
	}

	public List<UsuarioWeb> getUsuariosWebProveedor(FiltroUsuarioWeb filtroUsuarioWeb) {
		return usuarioBusiness.getUsuariosWebProveedor(filtroUsuarioWeb);
	}

	public Empresa getEmpresa(FiltroEmpresa filtroEmpresa) {
		return usuarioBusiness.getEmpresa(filtroEmpresa);
	}

	public List<Contacto> getContactos(FiltroContacto filtroContacto) {
		return usuarioBusiness.getContactos(filtroContacto);
	}

	public List<Direccion> getDirecciones(FiltroDireccion filtroDireccion) {
		return usuarioBusiness.getDirecciones(filtroDireccion);
	}

	public String validateUserLogin(String userName, String password) {
		return usuarioBusiness.validateUserLogin(userName, password);
	}

	public List<Privilegio> getPrivilegios(FiltroPrivilegio filtroPrivilegio) {
		return usuarioBusiness.getPrivilegios(filtroPrivilegio);
	}

	public Proveedor getProveedor(FiltroProveedor filtroProveedor) {
		return usuarioBusiness.getProveedor(filtroProveedor);
	}

	public Cliente getCliente(FiltroCliente filtroCliente) {
		return usuarioBusiness.getCliente(filtroCliente);
	}

	public FichaServicioCliente getClienteFicha(FiltroCliente filtroCliente) {
		return usuarioBusiness.getClienteFicha(filtroCliente);
	}

	public FichaServicioProveedor getProveedorFicha(FiltroProveedor filtroProveedor) {
		return usuarioBusiness.getProveedorFicha(filtroProveedor);
	}

	public GeoLocalizacion getGeoLocalizacion(FiltroGeoLoc filtroGeoLoc) {
		return usuarioBusiness.getGeoLocalizacion(filtroGeoLoc);
	}

	public List<UsuarioWebTienePrivilegio> getUsuarioWebPrivilegio(FiltroUsuarioWeb filtroUsuarioWeb) {
		return usuarioBusiness.getUsuarioWebPrivilegio(filtroUsuarioWeb);
	}

	public List<UsuarioWeb> getProveedores(FiltroProveedor filtroProveedor) {
		return usuarioBusiness.getProveedores(filtroProveedor);
	}

	public void sendMailNotification(String codigoMail, List<String> mailsTO, List<String> mailsCC,
			List<String> mailsCCO) throws AddressException, MessagingException {
		usuarioBusiness.sendMailNotification(codigoMail, mailsTO, mailsCC, mailsCCO);
	}

	public List<Direccion> asignarComunaDireccion(List<Direccion> direcciones) {
		return usuarioBusiness.asignarComunaDireccion(direcciones);
	}

	public Integer addOperacionEmpresa(Empresa empresa) {
		return usuarioBusiness.addOperacionEmpresa(empresa);
	}

	public Integer actualizaOperacionEmpresa(Empresa empresa) {
		return usuarioBusiness.actualizaOperacionEmpresa(empresa);
	}

	@Override
	public List<Cargo> getCargos(FiltroCargo filtroCargo) {
		return usuarioBusiness.getCargos(filtroCargo);
	}

}
