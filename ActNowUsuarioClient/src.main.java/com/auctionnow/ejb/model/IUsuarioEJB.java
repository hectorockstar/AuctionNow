package com.auctionnow.ejb.model;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

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

public interface IUsuarioEJB {

	// INSERTS
	Integer addCuentaUsuarioAdministrador(UsuarioWeb usuarioWeb);
	
	Integer addCuentaUsuarioCliente(UsuarioWeb usuarioWeb);

	Integer addCuentaUsuarioProveedor(UsuarioWeb usuarioWeb);
	
	Integer addCuentaUsuarioEmpresa(UsuarioWeb usuarioWeb);

	Integer addEmpresa(Empresa empresa);

	Integer addContacto(Contacto contacto, String codigoTitular);

	Integer addDireccion(Direccion direccion, String codigoTitular);
	
	Integer addNotificacionUsuario(Notificacion notificacion);
	
	Integer addPrivilegioUsuario(Privilegio privilegio);

	// UPDATES
	Integer actualizaCuentaUsuarioAdministrador(UsuarioWeb usuarioWeb);
	
	Integer actualizaCuentaUsuarioCliente(UsuarioWeb usuarioWeb);

	Integer actualizaCuentaUsuarioProveedor(UsuarioWeb usuarioWeb);
	
	Integer actualizaCuentaUsuarioEmpresa(UsuarioWeb usuarioWeb);

	Integer actualizaEmpresa(Empresa empresa);

	Integer actualizaContacto(Contacto contacto, String codigoTitular);

	Integer actualizaDireccion(Direccion direccion, String codigoTitular);
	
	Integer actualizaEstadoNotificacionUsuario(FiltroNotificacion filtroNotificacion);

	// GETS
	UsuarioWeb getUsuarioWebClienteData(FiltroUsuarioWeb filtroUsuarioWeb);

	UsuarioWeb getUsuarioWebProveedorData(FiltroUsuarioWeb filtroUsuarioWeb);
	
	UsuarioWeb getUsuarioWebEmpresaData(FiltroUsuarioWeb filtroUsuarioWeb);
	
	UsuarioWeb getUsuarioWebAdministradorData(FiltroUsuarioWeb filtroUsuarioWeb);

	Empresa getEmpresa(FiltroEmpresa filtroEmpresa);

	Contacto getContacto(FiltroContacto filtroContacto);

	Direccion getDireccion(FiltroDireccion filtroDireccion);

	List<UsuarioWeb> getUsuariosWebCliente(FiltroUsuarioWeb filtroUsuarioWeb);

	List<UsuarioWeb> getUsuariosWebProveedor(FiltroUsuarioWeb filtroUsuarioWeb);

	List<Empresa> getEmpresas(FiltroEmpresa filtroEmpresa);

	List<Contacto> getContactos(FiltroContacto filtroContacto);
	
	List<Contacto> getContactosByServicio(FiltroContacto filtroContacto);

	List<Direccion> getDirecciones(FiltroDireccion filtroDireccion);

	List<Privilegio> getPrivilegios(FiltroPrivilegio filtroPrivilegio);

	Proveedor getProveedor(FiltroProveedor filtroProveedor);

	List<UsuarioWeb> getProveedores(FiltroProveedor filtroProveedor);
	
	List<UsuarioWeb> getUsuarioWebByPrivilegio(FiltroUsuarioWeb filtroUsuarioWeb);

	Cliente getCliente(FiltroCliente filtroCliente);

	FichaServicioCliente getClienteFicha(FiltroCliente filtroCliente);

	FichaServicioProveedor getProveedorFicha(FiltroProveedor filtroProveedor);

	GeoLocalizacion getGeoLocalizacion(FiltroGeoLoc filtroGeoLoc);

	List<UsuarioWebTienePrivilegio> getUsuarioWebPrivilegio(FiltroUsuarioWeb filtroUsuarioWeb);
	
	List<Notificacion> getNotificacionesUsuario(FiltroNotificacion filtroNotificacion);
	
	// SERVICES
	String validateUserLogin(String userName, String password);

	List<Direccion> asignarComunaDireccion(List<Direccion> direcciones);

	void sendMailNotification(String codigoMail, List<String> mailsTO, List<String> mailsCC, List<String> mailsCCO)
			throws AddressException, MessagingException;

	void connectionTest();
}
