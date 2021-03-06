package com.auctionnow.data.transaccion;

import java.util.List;

import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.filters.FiltroTransaccion;
import com.auctionnow.model.BitacoraTransaccion;
import com.auctionnow.model.Cargo;
import com.auctionnow.model.MedioPago;
import com.auctionnow.model.Servicio;
import com.auctionnow.model.Tarjeta;
import com.auctionnow.model.Transaccion;

public interface ITransaccionDAO {
	//UPDATES
	Integer actualizaMedioPago(MedioPago medioPago);

	Integer actualizaServicio(Servicio servicio);

	Integer actualizaTarjeta(Tarjeta tarjeta);

	Integer actualizaTransaccion(Transaccion transaccion);
	
	Integer actualizaBitacoraTransaccion(BitacoraTransaccion bitacoraTransaccion);

	//SELECTS
	List<BitacoraTransaccion> getBitacoraTransaccion(FiltroTransaccion filtroTransaccion);

	List<MedioPago> getMedioPago(FiltroTransaccion filtroTransaccion);

	Tarjeta getTarjeta(FiltroTransaccion filtroTransaccion);
	
	Transaccion getTransaccion(FiltroTransaccion filtroTransaccion);

	List<Transaccion> getTransacciones(FiltroTransaccion filtroTransaccion);

	List<Servicio> getServicios(FiltroServicio filtroServicio);
	
	Servicio getServicio(FiltroServicio filtroServicio);
	
	List<Servicio> getServiciosByEmpresa(FiltroServicio filtroServicio);
	
	List<Cargo> getCargos();
	
	List<Cargo> getCargosByServicio(FiltroServicio filtroServicio);
	
	//INSERTS
	Integer addBitacoraTransaccion(BitacoraTransaccion bitacoraTransaccion);

	Integer addMedioPago(MedioPago medioPago);

	Integer addServicio(Servicio servicio);

	Integer addTarjeta(Tarjeta tarjeta);

	Integer addTransaccion(Transaccion transaccion);

	

	
}
