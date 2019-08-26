package com.auctionnow.ejb.model;

import java.util.List;

import com.auctionnow.filters.FiltroCargo;
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

public interface ITransaccionEJB {

	// UPDATES
	Integer actualizaMedioPago(MedioPago medioPago);

	Integer actualizaServicio(Servicio servicio);

	Integer actualizaTarjeta(Tarjeta tarjeta);

	Integer actualizaTransaccion(Transaccion transaccion);

	Integer actualizaBitacoraTransaccion(BitacoraTransaccion bitacoraTransaccion);

	// SELECTS
	List<BitacoraTransaccion> getBitacoraTransaccion(FiltroTransaccion filtroTransaccion);

	List<MedioPago> getMedioPago(FiltroTransaccion filtroTransaccion);

	Tarjeta getTarjeta(FiltroTransaccion filtroTransaccion);

	Transaccion getTransaccion(FiltroTransaccion filtroTransaccion);

	List<Transaccion> getTransacciones(FiltroTransaccion filtroTransaccion);

	List<Servicio> getServicios(FiltroServicio filtroServicio);

	Servicio getServicio(FiltroServicio filtroServicio);

	List<Servicio> getServiciosByEmpresa(FiltroServicio filtroServicio);
	
	List<Servicio> getServiciosByRubroTitular(FiltroServicio filtroServicio);

	List<Cargo> getCargos();

	List<Cargo> getCargosByServicio(FiltroCargo filtroCargo);

	List<Rubro> getRubros(FiltroRubro filtroRubro);

	Rubro getRubro(FiltroRubro filtroRubro);
	
	List<Rubro> getRubrosByTitular(FiltroRubro filtroRubro);

	// INSERTS
	Integer addBitacoraTransaccion(BitacoraTransaccion bitacoraTransaccion);

	Integer addMedioPago(MedioPago medioPago);

	Integer addServicio(Servicio servicio);

	Integer addTarjeta(Tarjeta tarjeta);

	Integer addTransaccion(Subasta subasta);
	
	//FUNCIONALIDADES
	Rubro asignaRubroServiciosEmpresa(String codigoTitular, Rubro rubro, String[] estadosServicios);

}
