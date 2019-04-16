package com.auctionnow.business.transaccion;

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
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.filters.FiltroTransaccion;
import com.auctionnow.model.BitacoraTransaccion;
import com.auctionnow.model.Cargo;
import com.auctionnow.model.MedioPago;
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
		
		servicio.setFechaRegistro(new Date());
		
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
		List<Servicio> lstServicios = transaccionDAO.getServicios(filtroServicio);
		return lstServicios;
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

	public List<Cargo> getCargosByServicio(FiltroServicio filtroServicio) {
		return transaccionDAO.getCargosByServicio(filtroServicio);
	}
	
	

}
