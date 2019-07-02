package com.auctionnow.data.usuario;

import java.util.List;

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
import com.auctionnow.model.Rubro;
import com.auctionnow.model.Usuario;
import com.auctionnow.model.UsuarioWeb;
import com.auctionnow.model.UsuarioWebTienePrivilegio;

public interface IUsuarioDAO {

	// INSERTS
	Integer addClienteFicha(FichaServicioCliente fichaCliente);

	Integer addUsuario(Usuario usuario);

	Integer addUsuarioCliente(Cliente cliente);

	Integer addUsuarioProveedor(Proveedor proveedor);

	Integer addContacto(Contacto contacto, String codigoTitular);

	Integer addDireccion(Direccion direccion, String codigoTitular);

	Integer addEmpresa(Empresa empresa);

	Integer addRubro(Rubro rubro);

	Integer addGeoLocalizacion(GeoLocalizacion geoLocalizacion);

	Integer addPrivilegio(Privilegio privilegio);

	Integer addProveedorFicha(FichaServicioProveedor fichaProveedor);

	Integer addUsuarioWeb(UsuarioWeb usuarioWeb);

	Integer addUsuarioWebPrivilegio(Privilegio privilegio, UsuarioWeb usuarioWeb, String descripcion);
	
	Integer addCargo(Cargo cargo);

	// UPDATES
	Integer actualizaClienteFicha(FichaServicioCliente fichaCliente);

	Integer actualizaContacto(Contacto contacto, String codigoTitular);

	Integer actualizaDireccion(Direccion direccion, String codigoTitular);

	Integer actualizaEmpresa(Empresa empresa);

	Integer actualizaGeoLocalizacion(GeoLocalizacion geoLocalizacion);

	Integer actualizaPrivilegio(Privilegio privilegio);

	Integer actualizaProveedorFicha(FichaServicioProveedor proveedor);

	Integer actualizaUsuario(Usuario usuario);

	Integer actualizaUsuarioCliente(Cliente cliente);

	Integer actualizaUsuarioProveedor(Proveedor proveedor);

	Integer actualizaUsuarioWeb(UsuarioWeb usuarioWeb);

	Integer actualizaRubro(Rubro rubro);

	Integer actualizaUsuarioWebPrivilegio(Privilegio privilegio, UsuarioWeb usuarioWeb, String descripcion, String activo);
	
	Integer actualizarCargo(Cargo cargo);

	// GETS
	UsuarioWeb getUsuarioWeb(FiltroUsuarioWeb filtroUsuarioWeb);

	Proveedor getProveedor(FiltroProveedor filtroProveedor);

	Cliente getCliente(FiltroCliente filtroCliente);

	List<UsuarioWeb> getProveedores(FiltroProveedor filtroProveedor);

	List<UsuarioWeb> getClientes(FiltroCliente filtroCliente);
	
	Contacto getContacto(FiltroContacto filtroContacto);

	List<Contacto> getContactos(FiltroContacto filtroContacto);

	Direccion getDireccion(FiltroDireccion filtroDireccion);
	
	List<Direccion> getDirecciones(FiltroDireccion filtroDireccion);

	Empresa getEmpresa(FiltroEmpresa filtroEmpresa);

	List<Empresa> getEmpresas();

	FichaServicioCliente getClienteFicha(FiltroCliente filtroCliente);

	FichaServicioProveedor getProveedorFicha(FiltroProveedor filtroProveedor);

	GeoLocalizacion getGeoLocalizacion(FiltroGeoLoc filtroGeoLoc);

	List<Privilegio> getPrivilegios(FiltroPrivilegio filtroPrivilegio);

	List<UsuarioWebTienePrivilegio> getUsuarioWebPrivilegio(FiltroUsuarioWeb filtroUsuarioWeb);
	
	List<Cargo> getCargos(FiltroCargo filtroCargo);
	
	String validateUserLogin(String userName, String password);

}
