package com.auctionnow.business.solicitud;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.auctionnow.common.Constantes;
import com.auctionnow.data.solicitud.ISolicitudDAO;
import com.auctionnow.ejb.IUsuarioEjbRemote;
import com.auctionnow.filters.FiltroContacto;
import com.auctionnow.filters.FiltroOferta;
import com.auctionnow.filters.FiltroSolicitud;
import com.auctionnow.filters.FiltroSubasta;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Oferta;
import com.auctionnow.model.Solicitud;
import com.auctionnow.model.Subasta;

public class SolicitudBusiness implements ISolicitudBusiness {
	
	private ISolicitudDAO solicitudDAO;
	
	@EJB
	private IUsuarioEjbRemote usuarioEjbRemote;
	
	public SolicitudBusiness (ISolicitudDAO solicitudDAO, IUsuarioEjbRemote usuarioEjbRemote){
		this.solicitudDAO = solicitudDAO;
		this.usuarioEjbRemote = usuarioEjbRemote;
	}

	public Integer addSolicitud(Solicitud solicitud) {
		Integer addSolicitud = solicitudDAO.addSolicitud(solicitud);
		return addSolicitud;
	}
	
	public IUsuarioEjbRemote getUsuarioEjbRemote() {
		return usuarioEjbRemote;
	}

	public void setUsuarioEjbRemote(IUsuarioEjbRemote usuarioEjbRemote) {
		this.usuarioEjbRemote = usuarioEjbRemote;
	}

	public Integer actualizaSolicitud(Solicitud solicitud) {
		Integer actualizaSolicitud = solicitudDAO.actualizaSolicitud(solicitud);
		return actualizaSolicitud;
	}

	public Solicitud getSolicitud(FiltroSolicitud filtroSolicitud) {
		Solicitud solicitud = solicitudDAO.getSolicitud(filtroSolicitud).get(0);
		return solicitud;
	}

	public List<Solicitud> getSolicitudes(FiltroSolicitud filtroSolicitud) {
		List<Solicitud> solicitudes = solicitudDAO.getSolicitud(filtroSolicitud);
		return solicitudes;
	}

	public Integer addSubasta(Subasta subasta) {
		return solicitudDAO.addSubasta(subasta);
	}

	public Integer addOferta(Oferta oferta) {
		return solicitudDAO.addOferta(oferta);
	}

	public Integer actualizaSubasta(Subasta subasta) {
		return solicitudDAO.actualizaSubasta(subasta);
	}

	public Integer actualizaOferta(Oferta oferta) {
		return solicitudDAO.actualizaOferta(oferta);
	}

	public Subasta getSubasta(FiltroSubasta filtroSubasta) {
		return solicitudDAO.getSubasta(filtroSubasta);
	}

	public List<Oferta> getOferta(FiltroOferta filtroOferta) {
		return solicitudDAO.getOferta(filtroOferta);
	}
	
	
	public Subasta iniciarSubasta(Solicitud solicitud, Subasta subasta){
		try {
			FiltroContacto filtroContacto = new FiltroContacto();
			filtroContacto.setCodigoServicio(solicitud.getServicio().getCodigoServicio());
			List<Contacto> contactos = getUsuarioEjbRemote().getContactos(filtroContacto);
			
			List<String> mailsTO = new ArrayList<String>();
			for(Contacto contacto : contactos){
				mailsTO.add(contacto.getEmail());
			}
			
			try {
				getUsuarioEjbRemote().sendMailNotification(Constantes.MAIL_NOTIFICA_NUEVASOLICITUD, mailsTO, new ArrayList<String>(), new ArrayList<String>());
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			subasta.setMontoFinal(new Long("0"));
			subasta.setMontoInicial(new Long("0"));
			subasta.setCodigoSubasta("SUB001"); // GENERAR CODIGO SUBASTA
			subasta.setFechaInicio(new Date());
			
			subasta.setEstadoSubasta("EC");
			subasta.setCantidadExtenciones(0);
			subasta.setExtendida(Boolean.FALSE);
			subasta.setFechaTermino(new Date()); // Fecha actual mas duracion de la subasta
			subasta.setServicio(solicitud.getServicio());
			subasta.setSolicitud(solicitud);
			
			Integer regSubasta = solicitudDAO.addSubasta(subasta);
			if(regSubasta == null || regSubasta == 0){
				throw new RuntimeException("Error al iniciar la Subasta");
			} 
			
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return subasta;
	}

	public Integer addSubastaProveedor(String codigoSubasta, String codigoProveedor) {
		return solicitudDAO.addSubastaProveedor(codigoSubasta, codigoProveedor);
	}
	
	
}
