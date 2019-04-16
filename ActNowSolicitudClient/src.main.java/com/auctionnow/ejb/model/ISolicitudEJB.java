package com.auctionnow.ejb.model;

import java.util.List;

import com.auctionnow.filters.FiltroOferta;
import com.auctionnow.filters.FiltroSolicitud;
import com.auctionnow.filters.FiltroSubasta;
import com.auctionnow.model.Oferta;
import com.auctionnow.model.Solicitud;
import com.auctionnow.model.Subasta;

public interface ISolicitudEJB {
	// INSERTS
	Integer addSolicitud(Solicitud solicitud);

	Integer addSubasta(Subasta subasta);

	Integer addOferta(Oferta oferta);
	
	Integer addSubastaProveedor(String codigoSubasta, String codigoProveedor);

	// UPDATES
	Integer actualizaSolicitud(Solicitud solicitud);

	Integer actualizaSubasta(Subasta subasta);

	Integer actualizaOferta(Oferta oferta);

	// GETS
	Solicitud getSolicitud(FiltroSolicitud filtroSolicitud);

	Subasta getSubasta(FiltroSubasta filtroSubasta);

	List<Oferta> getOferta(FiltroOferta filtroOferta);

	List<Solicitud> getSolicitudes(FiltroSolicitud filtroSolicitud);
	
	// SERVICIOS
	Subasta iniciarSubasta(Solicitud solicitud, Subasta subasta);

}
