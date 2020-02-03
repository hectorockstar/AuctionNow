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
import com.auctionnow.filters.FiltroCliente;
import com.auctionnow.filters.FiltroContacto;
import com.auctionnow.filters.FiltroDireccion;
import com.auctionnow.filters.FiltroEmpresa;
import com.auctionnow.filters.FiltroGeoLoc;
import com.auctionnow.filters.FiltroNotificacion;
import com.auctionnow.filters.FiltroPrivilegio;
import com.auctionnow.filters.FiltroProveedor;
import com.auctionnow.filters.FiltroUsuarioWeb;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.Empresa;
import com.auctionnow.model.FichaServicioCliente;
import com.auctionnow.model.FichaServicioProveedor;
import com.auctionnow.model.GeoLocalizacion;
import com.auctionnow.model.Notificacion;
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
	
	@Override
	public Integer actualizaEstadoNotificacionUsuario(FiltroNotificacion filtroNotificacion) {
		return usuarioBusiness.actualizaEstadoNotificacionUsuario(filtroNotificacion);
	}
	
	public Integer addCuentaUsuarioAdministrador(UsuarioWeb usuarioWeb) {
		return usuarioBusiness.addCuentaUsuarioAdministrador(usuarioWeb);
	}
	
	public Integer addCuentaUsuarioCliente(UsuarioWeb usuarioWeb) {
		return usuarioBusiness.addCuentaUsuarioCliente(usuarioWeb);
	}
	
	public Integer addCuentaUsuarioEmpresa(UsuarioWeb usuarioWeb) {
		return usuarioBusiness.addCuentaUsuarioEmpresa(usuarioWeb);
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
	
	public Integer actualizaCuentaUsuarioAdministrador(UsuarioWeb usuarioWeb) {
		return usuarioBusiness.actualizaCuentaUsuarioAdministrador(usuarioWeb);
	}
	
	public Integer actualizaCuentaUsuarioEmpresa(UsuarioWeb usuarioWeb) {
		return usuarioBusiness.actualizaCuentaUsuarioEmpresa(usuarioWeb);
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
	
	public Integer addNotificacionUsuario(Notificacion notificacion) {
		return usuarioBusiness.addNotificacionUsuario(notificacion);
	}
	
	public Integer addPrivilegioUsuario(Privilegio privilegio) {
		return usuarioBusiness.addPrivilegioUsuario(privilegio);
	}

	public UsuarioWeb getUsuarioWebClienteData(FiltroUsuarioWeb filtroUsuarioWeb) {
		return usuarioBusiness.getUsuarioWebClienteData(filtroUsuarioWeb);
	}

	public UsuarioWeb getUsuarioWebProveedorData(FiltroUsuarioWeb filtroUsuarioWeb) {
		return usuarioBusiness.getUsuarioWebProveedorData(filtroUsuarioWeb);
	}
	
	public UsuarioWeb getUsuarioWebEmpresaData(FiltroUsuarioWeb filtroUsuarioWeb) {
		return usuarioBusiness.getUsuarioWebEmpresaData(filtroUsuarioWeb);
	}
	
	public UsuarioWeb getUsuarioWebAdministradorData(FiltroUsuarioWeb filtroUsuarioWeb) {
		return usuarioBusiness.getUsuarioWebAdministradorData(filtroUsuarioWeb);
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
	
	public List<Contacto> getContactosByServicio(FiltroContacto filtroContacto) {
		return usuarioBusiness.getContactosByServicio(filtroContacto);
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

	@Override
	public List<Notificacion> getNotificacionesUsuario(FiltroNotificacion filtroNotificacion) {
		return usuarioBusiness.getNotificacionesUsuario(filtroNotificacion);
	}

	@Override
	public List<UsuarioWeb> getUsuarioWebByPrivilegio(FiltroUsuarioWeb filtroUsuarioWeb) {
		return usuarioBusiness.getUsuarioWebByPrivilegio(filtroUsuarioWeb);
	}

	@Override
	public void connectionTest() {
		System.out.print("CONNECTION TO SOLICITUD EJB IS DONE");
	}

}
