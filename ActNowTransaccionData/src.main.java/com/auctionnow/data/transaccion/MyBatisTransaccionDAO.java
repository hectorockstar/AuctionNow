package com.auctionnow.data.transaccion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.auctionnow.filters.FiltroCargo;
import com.auctionnow.filters.FiltroRubro;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.filters.FiltroTransaccion;
import com.auctionnow.model.BitacoraTransaccion;
import com.auctionnow.model.Cargo;
import com.auctionnow.model.MedioPago;
import com.auctionnow.model.Negocio;
import com.auctionnow.model.Rubro;
import com.auctionnow.model.Servicio;
import com.auctionnow.model.Tarjeta;
import com.auctionnow.model.Transaccion;

public class MyBatisTransaccionDAO extends SqlSessionDaoSupport implements ITransaccionDAO {

	@Override
	public Integer actualizaMedioPago(MedioPago medioPago) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoMedioPago", medioPago.getCodigoPago());
		parameters.put("fechaPago", medioPago.getFechaPago());
		parameters.put("totalCompra", medioPago.getTotalCompra());
		parameters.put("cuotas", medioPago.getCuotas());
		parameters.put("montoCuota", medioPago.getValorCuota());
		parameters.put("descripcion", medioPago.getDescripcion());
		parameters.put("viaPago", medioPago.getViaPago().getId());
		parameters.put("codigoTarjeta", medioPago.getTarjeta() == null ? "0" : medioPago.getTarjeta().getCodigoRegistro());
		
		return (Integer) getSqlSession().update("updateMedioPago", parameters);
	}

	@Override
	public Integer actualizaServicio(Servicio servicio) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoServicio", servicio.getCodigoServicio());
		parameters.put("descripcion", servicio.getDescripcion());
		parameters.put("nombre", servicio.getNombre());
		parameters.put("sigla", servicio.getSigla());
		parameters.put("codigoRubro", servicio.getRubro().getCodigoRubro());
		
		return (Integer) getSqlSession().update("updateServicio", parameters);
	}
	
	@Override
	public Integer actualizaTarjeta(Tarjeta tarjeta) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoTarjeta", tarjeta.getCodigoRegistro());
		parameters.put("entidad", tarjeta.getEntidad().getId());
		parameters.put("fechaExpiracion", tarjeta.getFechaExpiracion());
		parameters.put("nroTarjeta", tarjeta.getNumeroTarjeta());
		parameters.put("tipoTarjeta", tarjeta.getTipoTarjeta().getId());
		
		return (Integer) getSqlSession().update("updateTarjeta", parameters);
	}

	@Override
	public Integer actualizaTransaccion(Transaccion transaccion) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoTransaccion", transaccion.getCodigoTransaccion());
		parameters.put("estado", transaccion.getEstadoTransaccion());
		parameters.put("fechaCreacion", transaccion.getFechaCreacion());
		parameters.put("fechaTermino", transaccion.getFechaTermino());
		parameters.put("montoTotal", transaccion.getMontoTotal());
		parameters.put("complejidad", transaccion.getComplejidadServicio());
		parameters.put("descripcion", transaccion.getDescripcion());
		parameters.put("codigoMedioPago", transaccion.getMedioPago().getCodigoPago());
		parameters.put("tipoMoneda", transaccion.getTipoMoneda().getId());
		parameters.put("codigoSubasta", transaccion.getSubasta().getCodigoSubasta());
		
		return (Integer) getSqlSession().update("updateTransaccion", parameters);
	}

	@Override
	public Integer actualizaBitacoraTransaccion(BitacoraTransaccion bitacoraTransaccion) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoBitTransaccion", bitacoraTransaccion.getCodigoBitTransaccion());
		parameters.put("estadoOrigen", bitacoraTransaccion.getEstadoOrigen());
		parameters.put("estadoFinal", bitacoraTransaccion.getEstadoDestino());
		parameters.put("fecMovimiento", bitacoraTransaccion.getFechaMovimiento());
		parameters.put("descripcion", bitacoraTransaccion.getDescripcion());
		parameters.put("codigoTransaccion", bitacoraTransaccion.getCodigoTransaccion());
		
		return (Integer) getSqlSession().update("updateBitTransaccion", parameters);
	}
	
	@Override
	public Integer actualizaRubro(Rubro rubro) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoRubro", rubro.getCodigoRubro());
		parameters.put("nombre", rubro.getNombre());
		parameters.put("descripcion", rubro.getDescripcion());
		parameters.put("activo", rubro.getActivo());

		return (Integer) getSqlSession().update("updateRubro", parameters);
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
	public List<BitacoraTransaccion> getBitacoraTransaccion(FiltroTransaccion filtroTransaccion) {
		return (List<BitacoraTransaccion>)getSqlSession().selectList("getBitTransaccion", filtroTransaccion);
	}

	@Override
	public List<MedioPago> getMedioPago(FiltroTransaccion filtroTransaccion) {
		return (List<MedioPago>)getSqlSession().selectList("getMedioPago", filtroTransaccion);
	}

	@Override
	public Tarjeta getTarjeta(FiltroTransaccion filtroTransaccion) {
		return (Tarjeta)getSqlSession().selectList("getTarjeta", filtroTransaccion);
	}

	@Override
	public Transaccion getTransaccion(FiltroTransaccion filtroTransaccion) {
		return (Transaccion)getSqlSession().selectOne("getTransaccion", filtroTransaccion);
	}
	
	@Override
	public List<Transaccion> getTransacciones(FiltroTransaccion filtroTransaccion) {
		return (List<Transaccion>)getSqlSession().selectList("getTransacciones", filtroTransaccion);
	}
	
	@Override
	public List<Servicio> getServicios(FiltroServicio filtroServicio) {
		return (List<Servicio>)getSqlSession().selectList("getServicios", filtroServicio);
	}
	
	@Override
	public Servicio getServicio(FiltroServicio filtroServicio) {
		return (Servicio)getSqlSession().selectOne("getServicio", filtroServicio);
	}
	
	@Override
	public List<Servicio> getServiciosByEmpresa(FiltroServicio filtroServicio) {
		return (List<Servicio>)getSqlSession().selectList("getServiciosByEmpresa", filtroServicio);
	}

	@Override
	public Integer addBitacoraTransaccion(BitacoraTransaccion bitacoraTransaccion) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoBitTransaccion", bitacoraTransaccion.getCodigoBitTransaccion());
		parameters.put("estadoOrigen", bitacoraTransaccion.getEstadoOrigen());
		parameters.put("estadoFinal", bitacoraTransaccion.getEstadoDestino());
		parameters.put("fecMovimiento", bitacoraTransaccion.getFechaMovimiento());
		parameters.put("descripcion", bitacoraTransaccion.getDescripcion());
		parameters.put("codigoTransaccion", bitacoraTransaccion.getCodigoTransaccion());
		
		return (Integer) getSqlSession().insert("addBitTransaccion", parameters);
	}

	@Override
	public Integer addMedioPago(MedioPago medioPago) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoMedioPago", medioPago.getCodigoPago());
		parameters.put("fechaPago", medioPago.getFechaPago());
		parameters.put("totalCompra", medioPago.getTotalCompra());
		parameters.put("cuotas", medioPago.getCuotas());
		parameters.put("montoCuota", medioPago.getValorCuota());
		parameters.put("descripcion", medioPago.getDescripcion());
		parameters.put("viaPago", medioPago.getViaPago().getId());
		parameters.put("codigoTarjeta", medioPago.getTarjeta() == null ? "0" : medioPago.getTarjeta().getCodigoRegistro());
		
		return (Integer) getSqlSession().insert("addMedioPago", parameters);
	}
	
	@Override
	public Integer addRubro(Rubro rubro) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoRubro", rubro.getCodigoRubro());
		parameters.put("nombre", rubro.getNombre());
		parameters.put("descripcion", rubro.getDescripcion());
		parameters.put("activo", rubro.getActivo());

		return (Integer) getSqlSession().insert("addRubro", parameters);
	}

	@Override
	public Integer addServicio(Servicio servicio) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoServicio", servicio.getCodigoServicio());
		parameters.put("descripcion", servicio.getDescripcion());
		parameters.put("nombre", servicio.getNombre());
		parameters.put("sigla", servicio.getSigla());
		parameters.put("codigoRubro", servicio.getRubro().getCodigoRubro());
		
		return (Integer) getSqlSession().insert("addServicio", parameters);
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
	public Integer addTarjeta(Tarjeta tarjeta) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoTarjeta", tarjeta.getCodigoRegistro());
		parameters.put("entidad", tarjeta.getEntidad().getId());
		parameters.put("fechaExpiracion", tarjeta.getFechaExpiracion());
		parameters.put("nroTarjeta", tarjeta.getNumeroTarjeta());
		parameters.put("tipoTarjeta", tarjeta.getTipoTarjeta().getId());
		
		return (Integer) getSqlSession().insert("addTarjeta", parameters);
	}

	@Override
	public Integer addEjerce(String codigoTitular, Rubro rubro) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoEjerce", rubro.getCodigoEjerce());
		parameters.put("fechaEjerceDesde", rubro.getFechaEjerceDesde());
		parameters.put("fechaRegistro", rubro.getFechaRegistro());
		parameters.put("jerarquia", rubro.getJerarquia());
		parameters.put("descripcionEjerce", rubro.getDescripcionEjerce());
		parameters.put("activoEjercer", rubro.getActivoEjercer());
		parameters.put("codigoRubro", rubro.getCodigoRubro());
		parameters.put("codigotitular", codigoTitular);
		
		return (Integer) getSqlSession().insert("addEjerce", parameters);
	}
	
	@Override
	public Integer addServiciosActivos(String codigoTitular, Servicio servicio) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoServicioActivo", servicio.getCodigoServicioActivo());
		parameters.put("jerarquia", servicio.getJerarquia());
		parameters.put("fechaModificacion", servicio.getFechaModificacion());
		parameters.put("activoTitular", servicio.getActivoTitular());
		parameters.put("codigoServicio", servicio.getCodigoServicio());
		parameters.put("codigoTitular", codigoTitular);
		parameters.put("codigoEjerce", servicio.getRubro().getCodigoEjerce());
		
		return (Integer) getSqlSession().insert("addServiciosActivos", parameters);
	}
	
	@Override
	public Integer addTransaccion(Transaccion transaccion) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoTransaccion", transaccion.getCodigoTransaccion());
		parameters.put("estado", transaccion.getEstadoTransaccion());
		parameters.put("fechaCreacion", transaccion.getFechaCreacion());
		parameters.put("fechaTermino", transaccion.getFechaTermino());
		parameters.put("montoTotal", transaccion.getMontoTotal());
		parameters.put("complejidad", transaccion.getComplejidadServicio());
		parameters.put("descripcion", transaccion.getDescripcion());
		parameters.put("codigoMedioPago", transaccion.getMedioPago() == null ? "" : transaccion.getMedioPago().getCodigoPago());
		parameters.put("tipoMoneda", transaccion.getTipoMoneda() == null ? "" : transaccion.getTipoMoneda().getId());
		parameters.put("codigoSubasta", transaccion.getSubasta().getCodigoSubasta());
		
		return (Integer) getSqlSession().insert("addTransaccion", parameters);
	}
	
	@Override
	public Integer getRubroUltimaJerarquia(String codigoTitular) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoTitular", codigoTitular);
		
		return (Integer) getSqlSession().insert("getRubroUltimaJerarquia", parameters);
	}

	@Override
	public List<Cargo> getCargos() {
		return (List<Cargo>)getSqlSession().selectList("getCargos");
	}

	@Override
	public List<Cargo> getCargosByServicio(FiltroCargo filtroCargo) {
		return (List<Cargo>)getSqlSession().selectList("getCargosByServicio", filtroCargo);
	}
	
	@Override
	public List<Rubro> getRubros(FiltroRubro filtroRubro) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("rubros", filtroRubro.getRubros());
		
		return (List<Rubro>) getSqlSession().selectList("getRubros", parameters);
	}
	
	@Override
	public Rubro getRubro(FiltroRubro filtroRubro) {
		return (Rubro) getSqlSession().selectOne("getRubro", filtroRubro);
	}

	@Override
	public List<Rubro> getRubrosByTitular(FiltroRubro filtroRubro) {
		return (List<Rubro>) getSqlSession().selectList("getRubrosByTitular", filtroRubro);
	}
	
	@Override
	public List<Servicio> getServiciosByTitular(FiltroServicio filtroServicio) {
		return (List<Servicio>) getSqlSession().selectList("getServiciosByTitular", filtroServicio);
	}

}
