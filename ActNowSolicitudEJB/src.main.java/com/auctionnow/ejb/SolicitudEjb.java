package com.auctionnow.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import com.auctionnow.business.solicitud.ISolicitudBusiness;
import com.auctionnow.filters.FiltroOferta;
import com.auctionnow.filters.FiltroSolicitud;
import com.auctionnow.filters.FiltroSubasta;
import com.auctionnow.model.Oferta;
import com.auctionnow.model.Solicitud;
import com.auctionnow.model.Subasta;

@Stateless(name = "SolicitudEjb")
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class SolicitudEjb implements ISolicitudEjbLocal, ISolicitudEjbRemote{

	@Autowired
	private ISolicitudBusiness solicitudBusiness;
	
	public SolicitudEjb(){
		
	}
	
	public Integer addSolicitud(Solicitud solicitud) {
		return solicitudBusiness.addSolicitud(solicitud);
	}

	public Integer actualizaSolicitud(Solicitud solicitud) {
		return solicitudBusiness.actualizaSolicitud(solicitud);
	}

	public Solicitud getSolicitud(FiltroSolicitud filtroSolicitud) {
		return solicitudBusiness.getSolicitud(filtroSolicitud);
	}

	public List<Solicitud> getSolicitudes(FiltroSolicitud filtroSolicitud) {
		return solicitudBusiness.getSolicitudes(filtroSolicitud);
	}

	public Integer addSubasta(Subasta subasta) {
		return solicitudBusiness.addSubasta(subasta);
	}

	public Integer addOferta(Oferta oferta) {
		return solicitudBusiness.addOferta(oferta);
	}

	public Integer actualizaSubasta(Subasta subasta) {
		return solicitudBusiness.actualizaSubasta(subasta);
	}

	public Integer actualizaOferta(Oferta oferta) {
		return solicitudBusiness.actualizaOferta(oferta);
	}

	public Subasta getSubasta(FiltroSubasta filtroSubasta) {
		return solicitudBusiness.getSubasta(filtroSubasta);
	}

	public List<Oferta> getOferta(FiltroOferta filtroOferta) {
		return solicitudBusiness.getOferta(filtroOferta);
	}

	public Subasta iniciarSubasta(Solicitud solicitud, Subasta subasta) {
		return solicitudBusiness.iniciarSubasta(solicitud, subasta);
	}

	public Integer addSubastaProveedor(String codigoSubasta, String codigoProveedor) {
		return solicitudBusiness.addSubastaProveedor(codigoSubasta, codigoProveedor);
	}

}
