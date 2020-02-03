package com.auctionnow.data.solicitud;

import java.util.List;

import com.auctionnow.filters.FiltroOferta;
import com.auctionnow.filters.FiltroSolicitud;
import com.auctionnow.filters.FiltroSubasta;
import com.auctionnow.model.Oferta;
import com.auctionnow.model.Solicitud;
import com.auctionnow.model.Subasta;

public interface ISolicitudDAO {
	Integer actualizaSolicitud(Solicitud solicitud);

	Integer actualizaSubasta(Subasta subasta);

	Integer actualizaOferta(Oferta oferta);

	Solicitud getSolicitud(FiltroSolicitud filtroSolicitud);
	
	List<Solicitud> getSolicitudes(FiltroSolicitud filtroSolicitud);

	Subasta getSubasta(FiltroSubasta filtroSubasta);
	
	List<Oferta> getOferta(FiltroOferta filtroOferta);

	Integer addSolicitud(Solicitud solicitud);

	Integer addSubasta(Subasta subasta);

	Integer addOferta(Oferta oferta);
	
	Integer addSubastaProveedor(String codigoSubasta, String codigoProveedor);

	List<Subasta> getSubastasByStatus(FiltroSubasta filtroSubasta);

}
