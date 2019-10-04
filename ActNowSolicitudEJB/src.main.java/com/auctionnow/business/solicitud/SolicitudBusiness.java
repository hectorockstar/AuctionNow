package com.auctionnow.business.solicitud;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.auctionnow.common.Constantes;
import com.auctionnow.common.HorarioSistema;
import com.auctionnow.data.solicitud.ISolicitudDAO;
import com.auctionnow.ejb.ICommonEjbRemote;
import com.auctionnow.ejb.IUsuarioEjbRemote;
import com.auctionnow.filters.FiltroCatalogo;
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
	
	@EJB
	private ICommonEjbRemote commonEjbRemote;
	
	public SolicitudBusiness (ISolicitudDAO solicitudDAO, IUsuarioEjbRemote usuarioEjbRemote, ICommonEjbRemote commonEjbRemote){
		this.solicitudDAO = solicitudDAO;
		this.usuarioEjbRemote = usuarioEjbRemote;
		this.commonEjbRemote = commonEjbRemote;
	}

	public Integer addSolicitud(Solicitud solicitud) {
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
		filtroCatalogo.setKey(Constantes.SECUENCIA_SOLICITUD);
		
		solicitud.setCodigoSolicitud(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		solicitud.setFechaCreacion(new Date());
		
		if(Constantes.ACTIVA.equals(solicitud.getActivo())) {
			solicitud.setEstadoSolicitud("A");
		} else {
			solicitud.setEstadoSolicitud("NA");
		}
		
		solicitud.setPrioridad(0);
		
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

		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
		filtroCatalogo.setKey(Constantes.SECUENCIA_SUBASTA);
		subasta.setCodigoSubasta(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo)); // GENERAR CODIGO SUBASTA
		
		subasta.setEstadoSubasta("EC");
		subasta.setDescripcion("");
		
		HorarioSistema horarioSistema = getCommonEjbRemote().getCurrentDate();
		subasta.setFechaSubastaDesde(horarioSistema.getFechaActual());
		subasta.setHoraInicioSubasta(horarioSistema.getHoraActual());
		subasta.setFechaSubastaHasta(null);
		subasta.setHoraTerminoSubasta(null);
		
		subasta.setDuracion("");
		subasta.setCantidadExtensiones(new Integer("0"));
		subasta.setMontoMinimo(new Long("0"));
		subasta.setMontoInicial(new Long("0"));
		subasta.setMontoFinal(new Long("0"));
		
		Integer regSubasta = solicitudDAO.addSubasta(subasta);
		
		return regSubasta;
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
	
	public Subasta iniciarSubasta(Solicitud solicitud){
		Subasta subasta = null;
		try {
			
			FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
			filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
			filtroCatalogo.setKey(Constantes.SECUENCIA_SOLICITUD);
			
			solicitud.setCodigoSolicitud(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
			solicitud.setFechaCreacion(new Date());
			
			if(Constantes.ACTIVA.equals(solicitud.getActivo())) {
				solicitud.setEstadoSolicitud("A");
			} else {
				solicitud.setEstadoSolicitud("NA");
			}
			
			solicitud.setPrioridad(0);
			
			Integer addSolicitud = solicitudDAO.addSolicitud(solicitud);
			
			subasta = new Subasta();
			subasta.setSolicitud(solicitud);
			
			Integer addSubastaResultado = this.addSubasta(subasta);
			
			if(addSubastaResultado == null || addSubastaResultado == 0){
				throw new RuntimeException("Error al iniciar la Subasta");
			} 
			
			FiltroContacto filtroContacto = new FiltroContacto();
			filtroContacto.setCodigoServicio(solicitud.getServicio().getCodigoServicio());
			List<Contacto> contactos = getUsuarioEjbRemote().getContactosByServicio(filtroContacto);
			
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
			
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return subasta;
	}

	public Integer addSubastaProveedor(String codigoSubasta, String codigoProveedor) {
		return solicitudDAO.addSubastaProveedor(codigoSubasta, codigoProveedor);
	}

	public ISolicitudDAO getSolicitudDAO() {
		return solicitudDAO;
	}

	public void setSolicitudDAO(ISolicitudDAO solicitudDAO) {
		this.solicitudDAO = solicitudDAO;
	}

	public ICommonEjbRemote getCommonEjbRemote() {
		return commonEjbRemote;
	}

	public void setCommonEjbRemote(ICommonEjbRemote commonEjbRemote) {
		this.commonEjbRemote = commonEjbRemote;
	}
	
}
