package com.auctionnow.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import com.auctionnow.business.transaccion.ITransaccionBusiness;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.filters.FiltroTransaccion;
import com.auctionnow.model.BitacoraTransaccion;
import com.auctionnow.model.Cargo;
import com.auctionnow.model.MedioPago;
import com.auctionnow.model.Servicio;
import com.auctionnow.model.Subasta;
import com.auctionnow.model.Tarjeta;
import com.auctionnow.model.Transaccion;

@Stateless(name = "TransaccionEjb")
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class TransaccionEjb implements ITransaccionEjbLocal, ITransaccionEjbRemote {

	@Autowired
	private ITransaccionBusiness transaccionBusiness;

	public TransaccionEjb() {

	}

	public Integer addServicio(Servicio servicio) {
		return transaccionBusiness.addServicio(servicio);
	}

	public Integer actualizaServicio(Servicio servicio) {
		return transaccionBusiness.actualizaServicio(servicio);
	}

	public Servicio getServicio(FiltroServicio filtroServicio) {
		return transaccionBusiness.getServicio(filtroServicio);
	}

	public List<Servicio> getServicios(FiltroServicio filtroServicio) {
		return transaccionBusiness.getServicios(filtroServicio);
	}

	public Integer actualizaMedioPago(MedioPago medioPago) {
		return transaccionBusiness.actualizaMedioPago(medioPago);
	}

	public Integer actualizaTarjeta(Tarjeta tarjeta) {
		return transaccionBusiness.actualizaTarjeta(tarjeta);
	}

	public Integer actualizaTransaccion(Transaccion transaccion) {
		return transaccionBusiness.actualizaTransaccion(transaccion);
	}

	public Integer actualizaBitacoraTransaccion(BitacoraTransaccion bitacoraTransaccion) {
		return transaccionBusiness.actualizaBitacoraTransaccion(bitacoraTransaccion);
	}

	public List<BitacoraTransaccion> getBitacoraTransaccion(FiltroTransaccion filtroTransaccion) {
		return transaccionBusiness.getBitacoraTransaccion(filtroTransaccion);
	}

	public List<MedioPago> getMedioPago(FiltroTransaccion filtroTransaccion) {
		return transaccionBusiness.getMedioPago(filtroTransaccion);
	}

	public Tarjeta getTarjeta(FiltroTransaccion filtroTransaccion) {
		return transaccionBusiness.getTarjeta(filtroTransaccion);
	}

	public Transaccion getTransaccion(FiltroTransaccion filtroTransaccion) {
		return transaccionBusiness.getTransaccion(filtroTransaccion);
	}

	public List<Transaccion> getTransacciones(FiltroTransaccion filtroTransaccion) {
		return transaccionBusiness.getTransacciones(filtroTransaccion);
	}

	public Integer addBitacoraTransaccion(BitacoraTransaccion bitacoraTransaccion) {
		return transaccionBusiness.addBitacoraTransaccion(bitacoraTransaccion);
	}

	public Integer addMedioPago(MedioPago medioPago) {
		return transaccionBusiness.addMedioPago(medioPago);
	}

	public Integer addTarjeta(Tarjeta tarjeta) {
		return transaccionBusiness.addTarjeta(tarjeta);
	}

	public Integer addTransaccion(Subasta subasta) {
		return transaccionBusiness.addTransaccion(subasta);
	}

	
	public List<Servicio> getServiciosByEmpresa(FiltroServicio filtroServicio) {
		return transaccionBusiness.getServiciosByEmpresa(filtroServicio);
	}

	public List<Cargo> getCargos() {
		return transaccionBusiness.getCargos();
	}

	public List<Cargo> getCargosByServicio(FiltroServicio filtroServicio) {
		return transaccionBusiness.getCargosByServicio(filtroServicio);
	}

}
