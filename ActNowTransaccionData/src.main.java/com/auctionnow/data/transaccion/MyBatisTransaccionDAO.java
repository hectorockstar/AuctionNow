package com.auctionnow.data.transaccion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.filters.FiltroTransaccion;
import com.auctionnow.model.BitacoraTransaccion;
import com.auctionnow.model.Cargo;
import com.auctionnow.model.MedioPago;
import com.auctionnow.model.Negocio;
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
		parameters.put("fecRegistro", servicio.getFechaRegistro());
		parameters.put("nombre", servicio.getNombre());
		parameters.put("sigla", servicio.getSigla());
		parameters.put("tipoServicio", servicio.getTipoServicio().getId());
		
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
	public Integer addServicio(Servicio servicio) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoServicio", servicio.getCodigoServicio());
		parameters.put("descripcion", servicio.getDescripcion());
		parameters.put("fecRegistro", servicio.getFechaRegistro());
		parameters.put("nombre", servicio.getNombre());
		parameters.put("sigla", servicio.getSigla());
		parameters.put("tipoServicio", servicio.getTipoServicio().getId());
		
		return (Integer) getSqlSession().insert("addServicio", parameters);
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
	public List<Cargo> getCargos() {
		return (List<Cargo>)getSqlSession().selectList("getCargos");
	}

	@Override
	public List<Cargo> getCargosByServicio(FiltroServicio filtroServicio) {
		return (List<Cargo>)getSqlSession().selectList("getCargosByServicio", filtroServicio);
	}

	

	

}
