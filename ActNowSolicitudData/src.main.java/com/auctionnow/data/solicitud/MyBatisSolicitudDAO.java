package com.auctionnow.data.solicitud;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.auctionnow.filters.FiltroOferta;
import com.auctionnow.filters.FiltroSolicitud;
import com.auctionnow.filters.FiltroSubasta;
import com.auctionnow.model.Oferta;
import com.auctionnow.model.Solicitud;
import com.auctionnow.model.Subasta;

public class MyBatisSolicitudDAO extends SqlSessionDaoSupport implements ISolicitudDAO {

	@Override
	public Integer actualizaSolicitud(Solicitud solicitud) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoSolicitud", solicitud.getCodigoSolicitud());
		parameters.put("descripcion", solicitud.getDescripcion());
		parameters.put("estadoSolicitud", solicitud.getEstadoSolicitud());
		parameters.put("fechaCreacionSolicitud", solicitud.getFechaCreacion());
		parameters.put("fechaServicioEspecifica", solicitud.getFechaEntregaServicio());
		parameters.put("fechaServicioDesde", solicitud.getFechaServicioDesde());
		parameters.put("fechaServicioHasta", solicitud.getFechaServicioHasta());
		parameters.put("horaServicioDesde", solicitud.getHorarioDesde());
		parameters.put("horaServicioHasta", solicitud.getHorarioHasta());
		parameters.put("fechaVencimientoSubasta", solicitud.getFechaVencimientoSubasta());
		parameters.put("horaVencimientoSubasta", solicitud.getHoraVencimientoSubasta());
		parameters.put("precioEstimado", solicitud.getPrecioEsperado());
		parameters.put("valoracion", solicitud.getValoracion());
		parameters.put("activo", solicitud.getActivo());
		parameters.put("tipoFecha", solicitud.getTipoFecha().getId());
		parameters.put("codigoCliente", solicitud.getCliente().getCodigoCliente());
		parameters.put("codigoServicio", solicitud.getServicio().getCodigoServicio());
		parameters.put("codigoDireccion", solicitud.getDireccion().getCodigoDireccion());
		parameters.put("codigoContacto", solicitud.getContacto().getCodigoContacto());
		
		return (Integer)getSqlSession().update("updateSolicitud", parameters);
	}

	@Override
	public Integer actualizaSubasta(Subasta subasta) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoSubasta", subasta.getCodigoSubasta());
		parameters.put("estado", subasta.getEstadoSubasta());
		parameters.put("fecInicio", subasta.getFechaInicio());
		parameters.put("fecTermino", subasta.getFechaTermino());
		parameters.put("duracion", subasta.getDuracion());
		parameters.put("cantidadExtnsions", subasta.getCantidadExtenciones());
		parameters.put("montoMinimo", subasta.getMontoMinimo());
		parameters.put("montoInicial", subasta.getMontoInicial());
		parameters.put("montoFinal", subasta.getMontoFinal());
		parameters.put("extendida", subasta.isExtendida() ? 1 : 0);
		parameters.put("descripcion", subasta.getDescripcion());
		parameters.put("codigoOfertaG", subasta.getOfertaGanadora() != null? subasta.getOfertaGanadora().getCodigoOferta() : "");
		parameters.put("codigoServicio", subasta.getServicio().getCodigoServicio());
		parameters.put("codigoSolicitud", subasta.getSolicitud().getCodigoSolicitud());
		
		return (Integer)getSqlSession().update("updateSubasta", parameters);
	}

	@Override
	public Integer actualizaOferta(Oferta oferta) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoOferta", oferta.getCodigoOferta());
		parameters.put("fechaOferta", oferta.getFechaOferta());
		parameters.put("comision", oferta.getValorAgregado());
		parameters.put("montoOferta", oferta.getMontoOferta());
		parameters.put("codigoProveedor", oferta.getProveedor().getCodigoProveedor());
		parameters.put("codigoSubasta", oferta.getCodigoSubasta());
		
		return (Integer)getSqlSession().update("updateOferta", parameters);
	}

	@Override
	public List<Solicitud> getSolicitud(FiltroSolicitud filtroSolicitud) {
		return (List<Solicitud>)getSqlSession().selectList("getSolicitud", filtroSolicitud);
	}

	@Override
	public Subasta getSubasta(FiltroSubasta filtroSubasta) {
		return (Subasta)getSqlSession().selectOne("getSubasta", filtroSubasta);
	}

	@Override
	public List<Oferta> getOferta(FiltroOferta filtroOferta) {
		return (List<Oferta>)getSqlSession().selectList("getOferta", filtroOferta);
	}

	@Override
	public Integer addSolicitud(Solicitud solicitud) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoSolicitud", solicitud.getCodigoSolicitud());
		parameters.put("descripcion", solicitud.getDescripcion());
		parameters.put("estadoSolicitud", solicitud.getEstadoSolicitud());
		parameters.put("fechaCreacionSolicitud", solicitud.getFechaCreacion());
		parameters.put("fechaServicioEspecifica", solicitud.getFechaEntregaServicio());
		parameters.put("fechaServicioDesde", solicitud.getFechaServicioDesde());
		parameters.put("fechaServicioHasta", solicitud.getFechaServicioHasta());
		parameters.put("horaServicioDesde", solicitud.getHorarioDesde());
		parameters.put("horaServicioHasta", solicitud.getHorarioHasta());
		parameters.put("fechaVencimientoSubasta", solicitud.getFechaVencimientoSubasta());
		parameters.put("horaVencimientoSubasta", solicitud.getHoraVencimientoSubasta());
		parameters.put("precioEstimado", solicitud.getPrecioEsperado());
		parameters.put("valoracion", solicitud.getValoracion());
		parameters.put("activo", solicitud.getActivo());
		parameters.put("tipoFecha", solicitud.getTipoFecha().getId());
		parameters.put("codigoCliente", solicitud.getCliente().getCodigoCliente());
		parameters.put("codigoServicio", solicitud.getServicio().getCodigoServicio());
		parameters.put("codigoDireccion", solicitud.getDireccion().getCodigoDireccion());
		parameters.put("codigoContacto", solicitud.getContacto().getCodigoContacto());
		
		return (Integer)getSqlSession().insert("addSolicitud", parameters);
	}

	@Override
	public Integer addSubasta(Subasta subasta) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoSubasta", subasta.getCodigoSubasta());
		parameters.put("estado", subasta.getEstadoSubasta());
		parameters.put("fecInicio", subasta.getFechaInicio());
		parameters.put("fecTermino", subasta.getFechaTermino());
		parameters.put("duracion", subasta.getDuracion());
		parameters.put("cantidadExtnsions", subasta.getCantidadExtenciones());
		parameters.put("montoMinimo", subasta.getMontoMinimo());
		parameters.put("montoInicial", subasta.getMontoInicial());
		parameters.put("montoFinal", subasta.getMontoFinal());
		parameters.put("extendida", subasta.isExtendida()? 1 : 0);
		parameters.put("descripcion", subasta.getDescripcion());
		parameters.put("codigoServicio", subasta.getSolicitud().getServicio().getCodigoServicio());
		parameters.put("codigoSolicitud", subasta.getSolicitud().getCodigoSolicitud());
		
		return (Integer)getSqlSession().insert("addSubasta", parameters);
	}

	@Override
	public Integer addOferta(Oferta oferta) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoOferta", oferta.getCodigoOferta());
		parameters.put("fechaOferta", oferta.getFechaOferta());
		parameters.put("comision", oferta.getValorAgregado());
		parameters.put("montoOferta", oferta.getMontoOferta());
		parameters.put("codigoProveedor", oferta.getProveedor().getCodigoProveedor());
		parameters.put("codigoSubasta", oferta.getCodigoSubasta());
		
		return (Integer)getSqlSession().insert("addOferta", parameters);
	}

	@Override
	public Integer addSubastaProveedor(String codigoSubasta, String codigoProveedor) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoSubasta", codigoSubasta);
		parameters.put("codigoProveedor", codigoProveedor);
		parameters.put("estado", "A");
		parameters.put("fechaRegistro", new Date());
		return (Integer)getSqlSession().insert("addSubastaProveedor", parameters);
	}

}
