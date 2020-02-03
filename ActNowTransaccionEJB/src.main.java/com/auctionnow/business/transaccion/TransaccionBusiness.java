package com.auctionnow.business.transaccion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.auctionnow.common.Constantes;
import com.auctionnow.common.Tupla;
import com.auctionnow.data.transaccion.ITransaccionDAO;
import com.auctionnow.ejb.ICommonEjbRemote;
import com.auctionnow.filters.FiltroCargo;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroRubro;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.filters.FiltroTransaccion;
import com.auctionnow.model.BitacoraTransaccion;
import com.auctionnow.model.Cargo;
import com.auctionnow.model.MedioPago;
import com.auctionnow.model.Rubro;
import com.auctionnow.model.Servicio;
import com.auctionnow.model.Subasta;
import com.auctionnow.model.Tarjeta;
import com.auctionnow.model.Transaccion;

public class TransaccionBusiness implements ITransaccionBusiness {

	private ITransaccionDAO transaccionDAO;
	
	@EJB
	private ICommonEjbRemote commonEjbRemote;

	public TransaccionBusiness(ITransaccionDAO transaccionDAO, ICommonEjbRemote commonEjbRemote) {
		this.transaccionDAO = transaccionDAO;
		this.commonEjbRemote = commonEjbRemote;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer addServicio(Servicio servicio) {
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
		filtroCatalogo.setKey(Constantes.SECUENCIA_SERVICIO);
		servicio.setCodigoServicio(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		
		Integer registrarServicio = transaccionDAO.addServicio(servicio);
		return registrarServicio;
	}

	public Integer actualizaServicio(Servicio servicio) {
		Integer actualizaServicio = transaccionDAO.actualizaServicio(servicio);
		return actualizaServicio;
	}

	public Servicio getServicio(FiltroServicio filtroServicio) {
		Servicio servicio = transaccionDAO.getServicio(filtroServicio);
		return servicio;
	}

	public List<Servicio> getServicios(FiltroServicio filtroServicio) {
		
		List<Servicio> getDAOServicios = transaccionDAO.getServicios(filtroServicio);
		List<Servicio> lstServicios = new ArrayList<Servicio>();
		
		for (Servicio servicio : getDAOServicios) {
			FiltroCargo filtroCargo = new FiltroCargo();
			filtroCargo.setCodigoServicio(servicio.getCodigoServicio());
			filtroCargo.setActivo(Constantes.ACTIVO);
			List<Cargo> lstCargos = transaccionDAO.getCargosByServicio(filtroCargo);
			
			servicio.setCargos(lstCargos);
			
			lstServicios.add(servicio);
		}
		
		return lstServicios;
	}
	
	public List<Servicio> getServiciosByRubroTitular(FiltroServicio filtroServicio){
		List<Servicio> lstServiciosByRubroTitular = getTransaccionDAO().getServiciosByTitular(filtroServicio);
		
		return lstServiciosByRubroTitular;
	}

	public Integer actualizaMedioPago(MedioPago medioPago) {
		return transaccionDAO.actualizaMedioPago(medioPago);
	}

	public Integer actualizaTarjeta(Tarjeta tarjeta) {
		return transaccionDAO.actualizaTarjeta(tarjeta);
	}

	public Integer actualizaTransaccion(Transaccion transaccion) {
		return transaccionDAO.actualizaTransaccion(transaccion);
	}

	public Integer actualizaBitacoraTransaccion(BitacoraTransaccion bitacoraTransaccion) {
		return transaccionDAO.actualizaBitacoraTransaccion(bitacoraTransaccion);
	}

	public List<BitacoraTransaccion> getBitacoraTransaccion(FiltroTransaccion filtroTransaccion) {
		return transaccionDAO.getBitacoraTransaccion(filtroTransaccion);
	}

	public List<MedioPago> getMedioPago(FiltroTransaccion filtroTransaccion) {
		return transaccionDAO.getMedioPago(filtroTransaccion);
	}

	public Tarjeta getTarjeta(FiltroTransaccion filtroTransaccion) {
		return transaccionDAO.getTarjeta(filtroTransaccion);
	}

	public List<Transaccion> getTransacciones(FiltroTransaccion filtroTransaccion) {
		return transaccionDAO.getTransacciones(filtroTransaccion);
	}

	public Integer addBitacoraTransaccion(BitacoraTransaccion bitacoraTransaccion) {
		return transaccionDAO.addBitacoraTransaccion(bitacoraTransaccion);
	}

	public Integer addMedioPago(MedioPago medioPago) {
		
		Integer regTarjeta = transaccionDAO.addTarjeta(medioPago.getTarjeta());
		
		Integer regMedioPago = transaccionDAO.addMedioPago(medioPago);
		
		return regTarjeta * regMedioPago;
	}

	public Integer addTarjeta(Tarjeta tarjeta) {
		return transaccionDAO.addTarjeta(tarjeta);
	}

	public Integer addTransaccion(Subasta subasta) {

		Transaccion transaccion = new Transaccion();

		/// PRUEBA
		transaccion.setCodigoTransaccion("TRANS0001");
		//////////

		transaccion.setComplejidadServicio(5);
		transaccion.setDescripcion(subasta.getSolicitud().getDescripcion());
		transaccion.setEstadoTransaccion("PP");
		transaccion.setFechaCreacion(new Date());
		transaccion.setFechaTermino(new Date());

		Long montoTotal = subasta.getOfertaGanadora().getMontoOferta() + subasta.getOfertaGanadora().getValorAgregado();
		transaccion.setMontoTotal(montoTotal);

		transaccion.setSubasta(subasta);

		Tupla tipoMoneda = new Tupla();
		tipoMoneda.setId("CLP");
		transaccion.setTipoMoneda(tipoMoneda);
		//transaccion.setMedioPago(medioPago);
		Integer regTransaccion = transaccionDAO.addTransaccion(transaccion);
		
		
		BitacoraTransaccion bitacoraTransaccion = new BitacoraTransaccion();
		bitacoraTransaccion.setCodigoTransaccion(transaccion.getCodigoTransaccion());
		
		// PRUEBA 
		bitacoraTransaccion.setCodigoBitTransaccion("BIT0001");
		/////
		
		bitacoraTransaccion.setDescripcion("Estado Inicial Transaccion");
		bitacoraTransaccion.setEstadoDestino("PP");
		bitacoraTransaccion.setEstadoOrigen("C");
		bitacoraTransaccion.setFechaMovimiento(new Date());
		Integer regBitTransaccion = transaccionDAO.addBitacoraTransaccion(bitacoraTransaccion);
				
		return  regBitTransaccion*regTransaccion;
	}

	public Transaccion getTransaccion(FiltroTransaccion filtroTransaccion) {
		return transaccionDAO.getTransaccion(filtroTransaccion);
	}


	public ITransaccionDAO getTransaccionDAO() {
		return transaccionDAO;
	}


	public void setTransaccionDAO(ITransaccionDAO transaccionDAO) {
		this.transaccionDAO = transaccionDAO;
	}


	public ICommonEjbRemote getCommonEjbRemote() {
		return commonEjbRemote;
	}


	public void setCommonEjbRemote(ICommonEjbRemote commonEjbRemote) {
		this.commonEjbRemote = commonEjbRemote;
	}

	public List<Servicio> getServiciosByEmpresa(FiltroServicio filtroServicio) {
		return transaccionDAO.getServiciosByEmpresa(filtroServicio);
	}

	public List<Cargo> getCargos() {
		return transaccionDAO.getCargos();
	}

	public List<Cargo> getCargosByServicio(FiltroCargo filtroCargo) {
		return transaccionDAO.getCargosByServicio(filtroCargo);
	}
	
	public Rubro getRubro(FiltroRubro filtroRubro){
		return transaccionDAO.getRubro(filtroRubro);
	}
	
	public List<Rubro> getRubros(FiltroRubro filtroRubro){
		return transaccionDAO.getRubros(filtroRubro);
	}
	
	public List<Rubro> getRubrosByTitular(FiltroRubro filtroRubro){
		List<Rubro> lstRubrosDAO = transaccionDAO.getRubrosByTitular(filtroRubro);
		List<Rubro> lstRubros = null;
		if(lstRubrosDAO != null && !lstRubrosDAO.isEmpty()) {
			
			lstRubros = new ArrayList<Rubro>();
			
			FiltroServicio filtroServicio = new FiltroServicio();
			filtroServicio.setCodigoTitular(filtroRubro.getCodigoTitular());
			for (Rubro rubro : lstRubrosDAO) {
				filtroServicio.setCodigoRubro(rubro.getCodigoRubro());
				filtroServicio.setCodigoEjerce(rubro.getCodigoEjerce());
				
				List<Servicio> servicios = transaccionDAO.getServiciosByTitular(filtroServicio);
				rubro.setServicios(servicios);
				lstRubros.add(rubro);
			}
		}
		
		return lstRubros;
	}
	
	public Rubro asignaRubroServiciosEmpresa(String codigoTitular, Rubro rubro, String[] estadosServicios) {
		
//		Date fechaActual = getCommonEjbRemote().getFechaActual();
		Date fechaActual = new Date();
				
		Rubro rubroServicios = rubro;
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
		filtroCatalogo.setKey(Constantes.SECUENCIA_EJERCE_RUBRO);
		
		rubro.setCodigoEjerce(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		rubro.setFechaEjerceDesde(rubro.getFechaEjerceDesde());
		rubro.setFechaRegistro(fechaActual);
		
		Integer jerarquia = transaccionDAO.getRubroUltimaJerarquia(codigoTitular);
		rubro.setJerarquia((jerarquia == null ? new Integer(1): jerarquia) + 1);
		rubro.setActivoEjercer(Constantes.ACTIVA);
		
		Integer resultadoServiciosActivos = 1;
		Integer resultadoEjerce = transaccionDAO.addEjerce(codigoTitular, rubroServicios);
		
		List<Servicio> lstServicio = new ArrayList<Servicio>();
		for (int index = 0; index < estadosServicios.length ;index++) {
			String codigoServicio = String.valueOf(estadosServicios[index].split(":")[0]);
			String estadoServicio = String.valueOf(Boolean.parseBoolean(estadosServicios[index].split(":")[1]) ? "A" : "NA");
			
			Servicio servicio = new Servicio();
			
			filtroCatalogo = new FiltroCatalogo();
			filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
			filtroCatalogo.setKey(Constantes.SECUENCIA_SERVICIO_ACTIVO);
			
			servicio.setCodigoServicioActivo(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
			servicio.setCodigoServicio(codigoServicio);
			servicio.setActivoTitular(estadoServicio);
			servicio.setJerarquia(index + 1);
			servicio.setFechaModificacion(fechaActual);
			servicio.setRubro(rubroServicios);
			
			lstServicio.add(servicio);
			
			resultadoServiciosActivos = transaccionDAO.addServiciosActivos(codigoTitular, servicio);
		}
		rubroServicios.setServicios(lstServicio);
		
		Integer resultado = resultadoEjerce * resultadoServiciosActivos;
		
		if(resultado == 1) {
			System.out.println("RESULTADO EXITOSO");
		}
		
		return rubroServicios;
	}

	@Override
	public void connectionTest() {
		System.out.print("CONNECTION TO TRANSACCION EJB IS DONE");
	}

}
