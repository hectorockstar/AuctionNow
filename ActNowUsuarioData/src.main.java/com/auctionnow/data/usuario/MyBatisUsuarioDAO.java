package com.auctionnow.data.usuario;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

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
import com.auctionnow.model.Servicio;
import com.auctionnow.model.TipoUsuarioWeb;
import com.auctionnow.model.Usuario;
import com.auctionnow.model.UsuarioWeb;
import com.auctionnow.model.UsuarioWebTienePrivilegio;

public class MyBatisUsuarioDAO extends SqlSessionDaoSupport implements IUsuarioDAO {

	@Override
	public Integer actualizaClienteFicha(FichaServicioCliente fichaCliente) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoFicha", fichaCliente.getCodigoFicha());
		parameters.put("areaTrabajo", fichaCliente.getAreaTrabajo());
		parameters.put("atencion", fichaCliente.getAtencion());
		parameters.put("complejidad", fichaCliente.getComplejidad());
		parameters.put("formalidad", fichaCliente.getFormalidad());
		parameters.put("hospitalidad", fichaCliente.getHospitalidad());
		parameters.put("presencia", fichaCliente.getPresencia());
		parameters.put("recepcion", fichaCliente.getRecepcion());
		parameters.put("trato", fichaCliente.getTrato());
		parameters.put("descripcion", fichaCliente.getDescripcion());
		parameters.put("cantidadEvaluaciones", fichaCliente.getCantidadEvaluaciones());

		return (Integer) getSqlSession().update("updateFichaCliente", parameters);
	}

	@Override
	public Integer actualizaContacto(Contacto contacto, String codigoTitular) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoContacto", contacto.getCodigoContacto());
		parameters.put("email", contacto.getEmail());
		parameters.put("prioridad", contacto.getPrioridad());
		parameters.put("telefonoFijo1", contacto.getTelefono1());
		parameters.put("telefonoFijo2", contacto.getTelefono2());
		parameters.put("telefonoMovil1", contacto.getMovil1());
		parameters.put("telefonoMovil2", contacto.getMovil2());
		parameters.put("tipoContacto", contacto.getTipoContacto().getId());
		parameters.put("codigoTitular", codigoTitular); // codigoUsuario,
														// codigoEmpresa

		return (Integer) getSqlSession().update("updateContacto", parameters);
	}

	@Override
	public Integer actualizaDireccion(Direccion direccion, String codigoTitular) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoDireccion", direccion.getCodigoDireccion());
		parameters.put("calle", direccion.getCalle());
		parameters.put("numeracion", direccion.getNumeracion());
		parameters.put("nroDepto", direccion.getDeptoNro());
		parameters.put("piso", direccion.getPiso());
		parameters.put("observacion", direccion.getObservacion());
		parameters.put("prioridad", direccion.getPrioridad());
		parameters.put("codigoPostal", direccion.getCodigoPostal());
		parameters.put("tipoDireccion", direccion.getTipoDireccion().getId());
		parameters.put("codigoComuna", direccion.getComuna().getCodigoComuna());
		parameters.put("codigoGeoLoc", direccion.getGeoLocalizacion() == null ? 0 : direccion.getGeoLocalizacion().getIdGeo());
		parameters.put("codigoTitular", codigoTitular); // codigoUsuario, // codigoEmpresa
		
		return (Integer) getSqlSession().update("updateDireccion", parameters);
	}

	@Override
	public Integer actualizaEmpresa(Empresa empresa) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoEmpresa", empresa.getCodigoEmpresa());
		parameters.put("descripcion", empresa.getDescripcion());
		parameters.put("fecFundacion", empresa.getFechaOperaDesde());
		parameters.put("fecRegistro", empresa.getFechaRegistro());
		parameters.put("nombre", empresa.getNombreEmpresa());
		parameters.put("vigente", empresa.getVigente());

		return (Integer) getSqlSession().update("updateEmpresa", parameters);
	}

	@Override
	public Integer actualizaGeoLocalizacion(GeoLocalizacion geoLocalizacion) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoGeoLoc", geoLocalizacion.getIdGeo());
		parameters.put("latitud", geoLocalizacion.getLatitud());
		parameters.put("longitud", geoLocalizacion.getLongitud());
		parameters.put("tipoGeoLoc", geoLocalizacion.getTipoGeoLoc().getId());

		return (Integer) getSqlSession().update("updateGeoLocalizacion", parameters);
	}

	@Override
	public Integer actualizaPrivilegio(Privilegio privilegio) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoPrivilegio", privilegio.getCodigoPrivilegio());
		parameters.put("descripcion", privilegio.getDescPrivilegio());
		parameters.put("vigente", privilegio.getVigente());
		parameters.put("observacion", privilegio.getObservacion());
		parameters.put("fechaRegistro", privilegio.getFechaRegistro());
		parameters.put("tipoPrivilegio", privilegio.getTipoPrivilegio().getId());
		parameters.put("tipoUsuarioWeb", privilegio.getTipousuarioWeb().getId());

		return (Integer) getSqlSession().update("updatePrivilegio", parameters);
	}

	@Override
	public Integer actualizaProveedorFicha(FichaServicioProveedor fichaProveedor) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoFicha", fichaProveedor.getCodigoFicha());
		parameters.put("atencion", fichaProveedor.getAtencion());
		parameters.put("coherencia", fichaProveedor.getCoherencia());
		parameters.put("contacto", fichaProveedor.getContacto());
		parameters.put("educacionProblema", fichaProveedor.getEducacionProblema());
		parameters.put("explicaProblema", fichaProveedor.getExplicaProblema());
		parameters.put("puntualidad", fichaProveedor.getPuntualidad());
		parameters.put("tiempoServicio", fichaProveedor.getTiempoServicio());
		parameters.put("descripcion", fichaProveedor.getDescripcion());
		parameters.put("cantidadEvaluaciones", fichaProveedor.getCantidadEvaluaciones());

		return (Integer) getSqlSession().update("updateFichaProveedor", parameters);
	}

	@Override
	public Integer actualizaUsuario(Usuario usuario) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoUsuario", usuario.getCodigoUsuario());
		parameters.put("rut", usuario.getRut());
		parameters.put("rutDV", usuario.getRutDV());
		parameters.put("nombres", usuario.getNombre());
		parameters.put("apePaterno", usuario.getApellidoPaterno());
		parameters.put("apeMaterno", usuario.getApellidoMaterno());
		parameters.put("fecNacimiento", usuario.getFechaNacimiento());
		parameters.put("genero", usuario.getGenero().getId());
		parameters.put("ocupacion", usuario.getOcupacion());
		parameters.put("fecRegistro", usuario.getFechaRegistro());
		parameters.put("tipoUsuario", usuario.getTipoUsuario().getId());

		return (Integer) getSqlSession().update("updateUsuario", parameters);
	}

	@Override
	public Integer actualizaUsuarioCliente(Cliente cliente) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoCliente", cliente.getCodigoCliente());
		parameters.put("codigoFichaCli", cliente.getFichaCliente() == null ? 0 : cliente.getFichaCliente().getCodigoFicha());
		parameters.put("tipoCliente", cliente.getTipoCliente().getId());
		parameters.put("codigoUsuario", cliente.getCodigoUsuario());

		return (Integer) getSqlSession().update("updateCliente", parameters);
	}

	@Override
	public Integer actualizaUsuarioProveedor(Proveedor proveedor) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoProveedor", proveedor.getCodigoProveedor());
		parameters.put("codigoFichaProv",
				proveedor.getFichaProveedor() == null ? 0 : proveedor.getFichaProveedor().getCodigoFicha());
		parameters.put("codigoEmpresa", proveedor.getEmpresa().getCodigoEmpresa());
		parameters.put("codigoUsuario", proveedor.getCodigoUsuario());

		return (Integer) getSqlSession().update("updateProveedor", parameters);
	}

	@Override
	public Integer actualizaUsuarioWeb(UsuarioWeb usuarioWeb) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoUsuWeb", usuarioWeb.getCodigoUsuarioWeb());
		parameters.put("nombreUsuario", usuarioWeb.getNombreUsuario());
		parameters.put("password", usuarioWeb.getContrasena());
		parameters.put("firma", usuarioWeb.getFirmaComentario());
		parameters.put("pregunta1", usuarioWeb.getPregunta1());
		parameters.put("pregunta2", usuarioWeb.getPregunta2());
		parameters.put("pregunta3", usuarioWeb.getPregunta3());
		parameters.put("respuesta1", usuarioWeb.getRespuesta1());
		parameters.put("respuesta2", usuarioWeb.getRespuesta2());
		parameters.put("respuesta3", usuarioWeb.getRespuesta3());
		parameters.put("estadoCuenta", usuarioWeb.getEstadoCuenta());
		parameters.put("tipoUsuWeb", usuarioWeb.getTipoUsuarioWeb().getId());
		parameters.put("codigoUsuario", usuarioWeb.getUsuario().getCodigoUsuario());

		return (Integer) getSqlSession().update("updateUsuarioWeb", parameters);
	}

	@Override
	public Integer actualizaOperacionEmpresa(Empresa empresa) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoEmpresa", empresa.getCodigoEmpresa());
		parameters.put("codigoServicio", empresa.getServicio().getCodigoServicio());
		parameters.put("prioridad", empresa.getServicio().getPrioridad());
		parameters.put("fecDesdeOpera", empresa.getServicio().getOperaServicioDesde());
		parameters.put("activo", empresa.getServicio().getActivo());

		return (Integer) getSqlSession().update("updateEmpresaOpera", parameters);
	}

	@Override
	public Integer actualizaUsuarioWebPrivilegio(Privilegio privilegio, UsuarioWeb usuarioWeb, String descripcion,
			String activo) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoPrivilegio", privilegio.getCodigoPrivilegio());
		parameters.put("codigoUsuarioWeb", usuarioWeb.getCodigoUsuarioWeb());
		parameters.put("activo", activo);
		parameters.put("descripcion", descripcion);

		return (Integer) getSqlSession().update("updateUsuarioPrivilegio", parameters);
	}

	@Override
	public Integer actualizarCargo(Cargo cargo) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoCargo", cargo.getCodigoCargo());
		parameters.put("nombrecargo", cargo.getNombre());
		parameters.put("sigla", cargo.getSigla());
		parameters.put("descripcion", cargo.getDescripcion());

		return (Integer) getSqlSession().insert("updateCargo", parameters);
	}

	@Override
	public Integer addClienteFicha(FichaServicioCliente fichaCliente) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoFicha", fichaCliente.getCodigoFicha());
		parameters.put("areaTrabajo", fichaCliente.getAreaTrabajo());
		parameters.put("atencion", fichaCliente.getAtencion());
		parameters.put("complejidad", fichaCliente.getComplejidad());
		parameters.put("formalidad", fichaCliente.getFormalidad());
		parameters.put("hospitalidad", fichaCliente.getHospitalidad());
		parameters.put("presencia", fichaCliente.getPresencia());
		parameters.put("recepcion", fichaCliente.getRecepcion());
		parameters.put("trato", fichaCliente.getTrato());
		parameters.put("descripcion", fichaCliente.getDescripcion());
		parameters.put("cantidadEvaluaciones", fichaCliente.getCantidadEvaluaciones());

		return (Integer) getSqlSession().insert("addFichaCliente", parameters);
	}

	@Override
	public Integer addUsuario(Usuario usuario) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoUsuario", usuario.getCodigoUsuario());
		parameters.put("rut", usuario.getRut());
		parameters.put("rutDV", usuario.getRutDV());
		parameters.put("nombres", usuario.getNombre());
		parameters.put("apePaterno", usuario.getApellidoPaterno());
		parameters.put("apeMaterno", usuario.getApellidoMaterno());
		parameters.put("fecNacimiento", usuario.getFechaNacimiento());
		parameters.put("genero", usuario.getGenero().getId());
		parameters.put("ocupacion", usuario.getOcupacion());
		parameters.put("fecRegistro", usuario.getFechaRegistro());
		parameters.put("tipoUsuario", usuario.getTipoUsuario().getId());
		parameters.put("pais", usuario.getPais().getCodigoPais());

		return (Integer) getSqlSession().insert("addUsuario", parameters);
	}

	@Override
	public Integer addUsuarioCliente(Cliente cliente) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoCliente", cliente.getCodigoCliente());
		parameters.put("codigoFichaCli",
				cliente.getFichaCliente() == null ? 0 : cliente.getFichaCliente().getCodigoFicha());
		parameters.put("tipoCliente", cliente.getTipoCliente().getId());
		parameters.put("codigoUsuario", cliente.getCodigoUsuario());

		return (Integer) getSqlSession().insert("addCliente", parameters);
	}

	@Override
	public Integer addUsuarioProveedor(Proveedor proveedor) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoProveedor", proveedor.getCodigoProveedor());
		parameters.put("codigoFichaProv",
				proveedor.getFichaProveedor() == null ? 0 : proveedor.getFichaProveedor().getCodigoFicha());
		parameters.put("codigoEmpresa", proveedor.getEmpresa().getCodigoEmpresa());
		parameters.put("codigoServicio", proveedor.getServicio().getCodigoServicio());
		parameters.put("codigoCargo", proveedor.getCargo().getCodigoCargo());
		parameters.put("codigoUsuario", proveedor.getCodigoUsuario());

		return (Integer) getSqlSession().insert("addProveedor", parameters);
	}

	@Override
	public Integer addContacto(Contacto contacto, String codigoTitular) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoContacto", contacto.getCodigoContacto());
		parameters.put("email", contacto.getEmail());
		parameters.put("prioridad", contacto.getPrioridad());
		parameters.put("telefonoFijo1", contacto.getTelefono1());
		parameters.put("telefonoFijo2", contacto.getTelefono2());
		parameters.put("telefonoMovil1", contacto.getMovil1());
		parameters.put("telefonoMovil2", contacto.getMovil2());
		parameters.put("tipoContacto", contacto.getTipoContacto().getId());
		parameters.put("codigoUsuario", codigoTitular);

		return (Integer) getSqlSession().insert("addContacto", parameters);
	}

	@Override
	public Integer addDireccion(Direccion direccion, String codigoTitular) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoDireccion", direccion.getCodigoDireccion());
		parameters.put("calle", direccion.getCalle());
		parameters.put("numeracion", direccion.getNumeracion());
		parameters.put("nroDepto", direccion.getDeptoNro());
		parameters.put("piso", direccion.getPiso());
		parameters.put("observacion", direccion.getObservacion());
		parameters.put("prioridad", direccion.getPrioridad());
		parameters.put("codigoPostal", direccion.getCodigoPostal());
		parameters.put("tipoDireccion", direccion.getTipoDireccion().getId());
		parameters.put("codigoComuna", direccion.getComuna().getCodigoComuna());
		parameters.put("codigoGeoLoc", direccion.getGeoLocalizacion() == null ? 0 : direccion.getGeoLocalizacion().getIdGeo());
		parameters.put("codigoUsuario", codigoTitular);

		return (Integer) getSqlSession().insert("addDireccion", parameters);
	}

	@Override
	public Integer addEmpresa(Empresa empresa) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoEmpresa", empresa.getCodigoEmpresa());
		parameters.put("descripcion", empresa.getDescripcion());
		parameters.put("fecFundacion", empresa.getFechaOperaDesde());
		parameters.put("fecRegistro", empresa.getFechaRegistro());
		parameters.put("nombre", empresa.getNombreEmpresa());
		parameters.put("vigente", empresa.getVigente());
		parameters.put("rut", empresa.getRut());
		parameters.put("rutDV", empresa.getRutDV());

		return (Integer) getSqlSession().insert("addEmpresa", parameters);
	}

	@Override
	public Integer addOperacionEmpresa(Empresa empresa) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoEmpresa", empresa.getCodigoEmpresa());
		parameters.put("codigoServicio", empresa.getServicio().getCodigoServicio());
		parameters.put("prioridad", empresa.getServicio().getPrioridad());
		parameters.put("fecDesdeOpera", empresa.getServicio().getOperaServicioDesde());
		parameters.put("fecRegistro", empresa.getServicio().getFechaRegistroWeb());
		parameters.put("activo", empresa.getServicio().getActivo());

		return (Integer) getSqlSession().insert("addEmpresaOpera", parameters);
	}

	@Override
	public Integer addGeoLocalizacion(GeoLocalizacion geoLocalizacion) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoGeoLoc", geoLocalizacion.getIdGeo());
		parameters.put("latitud", geoLocalizacion.getLatitud());
		parameters.put("longitud", geoLocalizacion.getLongitud());
		parameters.put("tipoGeoLoc", geoLocalizacion.getTipoGeoLoc().getId());

		return (Integer) getSqlSession().insert("addGeoLocalizacion", parameters);
	}

	@Override
	public Integer addPrivilegio(Privilegio privilegio) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoPrivilegio", privilegio.getCodigoPrivilegio());
		parameters.put("descripcion", privilegio.getDescPrivilegio());
		parameters.put("vigente", privilegio.getVigente());
		parameters.put("observacion", privilegio.getObservacion());
		parameters.put("fechaRegistro", privilegio.getFechaRegistro());
		parameters.put("tipoPrivilegio", privilegio.getTipoPrivilegio().getId());
		parameters.put("tipoUsuarioWeb", privilegio.getTipousuarioWeb().getId());

		return (Integer) getSqlSession().insert("addPrivilegio", parameters);
	}

	@Override
	public Integer addProveedorFicha(FichaServicioProveedor fichaProveedor) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoFicha", fichaProveedor.getCodigoFicha());
		parameters.put("atencion", fichaProveedor.getAtencion());
		parameters.put("coherencia", fichaProveedor.getCoherencia());
		parameters.put("contacto", fichaProveedor.getContacto());
		parameters.put("educacionProblema", fichaProveedor.getEducacionProblema());
		parameters.put("explicaProblema", fichaProveedor.getExplicaProblema());
		parameters.put("puntualidad", fichaProveedor.getPuntualidad());
		parameters.put("tiempoServicio", fichaProveedor.getTiempoServicio());
		parameters.put("descripcion", fichaProveedor.getDescripcion());
		parameters.put("cantidadEvaluaciones", fichaProveedor.getCantidadEvaluaciones());

		return (Integer) getSqlSession().insert("addFichaProveedor", parameters);
	}

	@Override
	public Integer addUsuarioWeb(UsuarioWeb usuarioWeb) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoUsuWeb", usuarioWeb.getCodigoUsuarioWeb());
		parameters.put("nombreUsuario", usuarioWeb.getNombreUsuario());
		parameters.put("password", usuarioWeb.getContrasena());
		parameters.put("firma", usuarioWeb.getFirmaComentario());
		parameters.put("pregunta1", usuarioWeb.getPregunta1());
		parameters.put("pregunta2", usuarioWeb.getPregunta2());
		parameters.put("pregunta3", usuarioWeb.getPregunta3());
		parameters.put("respuesta1", usuarioWeb.getRespuesta1());
		parameters.put("respuesta2", usuarioWeb.getRespuesta2());
		parameters.put("respuesta3", usuarioWeb.getRespuesta3());
		parameters.put("estadoCuenta", usuarioWeb.getEstadoCuenta());
		parameters.put("tipoUsuWeb", usuarioWeb.getTipoUsuarioWeb().getId());
		parameters.put("codigoUsuario", usuarioWeb.getUsuario().getCodigoUsuario());

		return (Integer) getSqlSession().insert("addUsuarioWeb", parameters);
	}

	@Override
	public Integer addUsuarioWebPrivilegio(Privilegio privilegio, UsuarioWeb usuarioWeb, String descripcion) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoPrivilegio", privilegio.getCodigoPrivilegio());
		parameters.put("codigoUsuarioWeb", usuarioWeb.getCodigoUsuarioWeb());
		parameters.put("activo", "S");
		parameters.put("fechaAsignacion", new Date());
		parameters.put("descripcion", descripcion);

		return (Integer) getSqlSession().insert("addUsuarioPrivilegio", parameters);
	}

	@Override
	public Integer addCargo(Cargo cargo) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoCargo", cargo.getCodigoCargo());
		parameters.put("nombrecargo", cargo.getNombre());
		parameters.put("sigla", cargo.getSigla());
		parameters.put("descripcion", cargo.getDescripcion());

		return (Integer) getSqlSession().insert("addCargo", parameters);
	}

	@Override
	public UsuarioWeb getUsuarioWeb(FiltroUsuarioWeb filtroUsuarioWeb) {
		return (UsuarioWeb) getSqlSession().selectOne("getUsuarioWeb", filtroUsuarioWeb);
	}

	@Override
	public Proveedor getProveedor(FiltroProveedor filtroProveedor) {
		return (Proveedor) getSqlSession().selectOne("getProveedor", filtroProveedor);
	}

	@Override
	public Cliente getCliente(FiltroCliente filtroCliente) {
		return (Cliente) getSqlSession().selectOne("getCliente", filtroCliente);
	}

	@Override
	public List<UsuarioWeb> getProveedores(FiltroProveedor filtroProveedor) {
		return (List<UsuarioWeb>) getSqlSession().selectList("getProveedores", filtroProveedor);
	}

	@Override
	public List<UsuarioWeb> getClientes(FiltroCliente filtroCliente) {
		return (List<UsuarioWeb>) getSqlSession().selectList("getClientes", filtroCliente);
	}

	@Override
	public Contacto getContacto(FiltroContacto filtroContacto) {
		return (Contacto) getSqlSession().selectOne("getContactos", filtroContacto);
	}

	@Override
	public List<Contacto> getContactos(FiltroContacto filtroContacto) {
		return (List<Contacto>) getSqlSession().selectList("getContactos", filtroContacto);
	}

	@Override
	public Direccion getDireccion(FiltroDireccion filtroDireccion) {
		return (Direccion) getSqlSession().selectOne("getDireccion", filtroDireccion);
	}

	@Override
	public List<Direccion> getDirecciones(FiltroDireccion filtroDireccion) {
		return (List<Direccion>) getSqlSession().selectList("getDireccion", filtroDireccion);
	}

	@Override
	public List<Empresa> getEmpresas() {
		return (List<Empresa>) getSqlSession().selectList("getEmpresas");
	}

	@Override
	public Empresa getEmpresa(FiltroEmpresa filtroEmpresa) {
		return (Empresa) getSqlSession().selectOne("getEmpresa", filtroEmpresa);
	}

	@Override
	public FichaServicioCliente getClienteFicha(FiltroCliente filtroCliente) {
		return (FichaServicioCliente) getSqlSession().selectOne("getFichaCliente", filtroCliente);
	}

	@Override
	public FichaServicioProveedor getProveedorFicha(FiltroProveedor filtroProveedor) {
		return (FichaServicioProveedor) getSqlSession().selectOne("getFichaProveedor", filtroProveedor);
	}

	@Override
	public GeoLocalizacion getGeoLocalizacion(FiltroGeoLoc filtroGeoLoc) {
		return (GeoLocalizacion) getSqlSession().selectOne("getGeoLocalizacion", filtroGeoLoc);
	}

	@Override
	public List<Privilegio> getPrivilegios(FiltroPrivilegio filtroPrivilegio) {
		return (List<Privilegio>) getSqlSession().selectList("getPrivilegios", filtroPrivilegio);
	}

	@Override
	public List<UsuarioWebTienePrivilegio> getUsuarioWebPrivilegio(FiltroUsuarioWeb filtroUsuarioWeb) {
		return (List<UsuarioWebTienePrivilegio>) getSqlSession().selectList("getPrivilegiosUsuario", filtroUsuarioWeb);
	}

	@Override
	public List<Cargo> getCargos(FiltroCargo filtroCargo) {

		return (List<Cargo>) getSqlSession().selectList("getCargos", filtroCargo);
	}

	@Override
	public String validateUserLogin(String userName, String password) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("userName", userName);
		parameters.put("password", password);

		String tipoUsuarioWeb = (String) getSqlSession().selectOne("getValidateLogin", parameters);
		return tipoUsuarioWeb;
	}

}
