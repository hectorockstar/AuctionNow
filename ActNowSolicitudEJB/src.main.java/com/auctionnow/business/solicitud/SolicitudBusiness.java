package com.auctionnow.business.solicitud;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.auctionnow.common.Constantes;
import com.auctionnow.common.HorarioSistema;
import com.auctionnow.common.Tupla;
import com.auctionnow.data.solicitud.ISolicitudDAO;
import com.auctionnow.ejb.ICommonEjbRemote;
import com.auctionnow.ejb.IUsuarioEjbRemote;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroContacto;
import com.auctionnow.filters.FiltroOferta;
import com.auctionnow.filters.FiltroSolicitud;
import com.auctionnow.filters.FiltroSubasta;
import com.auctionnow.filters.FiltroUsuarioWeb;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Notificacion;
import com.auctionnow.model.Oferta;
import com.auctionnow.model.Solicitud;
import com.auctionnow.model.Subasta;
import com.auctionnow.model.UsuarioWeb;

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
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer addSolicitud(Solicitud solicitud) {
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
		filtroCatalogo.setKey(Constantes.SECUENCIA_SOLICITUD);
		solicitud.setCodigoSolicitud(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		
		solicitud = this.setDataAddNewSolicitud(solicitud);
		
		Integer addSolicitud = solicitudDAO.addSolicitud(solicitud);
		
		return addSolicitud;
	}
	
	private Solicitud setDataAddNewSolicitud(Solicitud solicitud) {
		
		solicitud.setFechaCreacion(new Date());
		
		if(Constantes.ACTIVA.equals(solicitud.getActivo())) {
			solicitud.setEstadoSolicitud("A");
		} else {
			solicitud.setEstadoSolicitud("NA");
		}
		
		solicitud.setPrioridad(0);
		
		return solicitud;
	}
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer actualizaSolicitud(Solicitud solicitud) {
		Integer actualizaSolicitud = solicitudDAO.actualizaSolicitud(solicitud);
		return actualizaSolicitud;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Solicitud getSolicitud(FiltroSolicitud filtroSolicitud) {
		Solicitud solicitud = solicitudDAO.getSolicitud(filtroSolicitud).get(0);
		return solicitud;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<Solicitud> getSolicitudes(FiltroSolicitud filtroSolicitud) {
		List<Solicitud> solicitudes = solicitudDAO.getSolicitud(filtroSolicitud);
		return solicitudes;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer addSubasta(Subasta subasta) {
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
		filtroCatalogo.setKey(Constantes.SECUENCIA_SUBASTA);
		subasta.setCodigoSubasta(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo)); // GENERAR CODIGO SUBASTA

		subasta = this.setDataAddNewSubasta(subasta);
		
		Integer regSubasta = solicitudDAO.addSubasta(subasta);
		
		return regSubasta;
	}
	
	private Subasta setDataAddNewSubasta(Subasta subasta) {
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
		return subasta;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer addOferta(Oferta oferta) {
		return solicitudDAO.addOferta(oferta);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer actualizaSubasta(Subasta subasta) {
		return solicitudDAO.actualizaSubasta(subasta);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer actualizaOferta(Oferta oferta) {
		return solicitudDAO.actualizaOferta(oferta);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Subasta getSubasta(FiltroSubasta filtroSubasta) {
		return solicitudDAO.getSubasta(filtroSubasta);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<Oferta> getOferta(FiltroOferta filtroOferta) {
		return solicitudDAO.getOferta(filtroOferta);
	}
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Subasta iniciarSubasta(Solicitud solicitud){
		Subasta subasta = null;
		try {
			
			FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
			filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
			filtroCatalogo.setKey(Constantes.SECUENCIA_SOLICITUD);
			solicitud.setCodigoSolicitud(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
			
			solicitud = this.setDataAddNewSolicitud(solicitud);
			
			Integer addSolicitud = solicitudDAO.addSolicitud(solicitud);
			
			if(addSolicitud != null && !addSolicitud.equals(new Integer("0"))) {
				subasta = new Subasta();
				subasta.setSolicitud(solicitud);
				
				filtroCatalogo = new FiltroCatalogo();
				filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
				filtroCatalogo.setKey(Constantes.SECUENCIA_SUBASTA);
				subasta.setCodigoSubasta(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo)); // GENERAR CODIGO SUBASTA

				subasta = setDataAddNewSubasta(subasta);
				
				Integer addSubastaResultado = solicitudDAO.addSubasta(subasta);
				
				if(addSubastaResultado != null && !addSubastaResultado.equals(new Integer("0"))) {
					
					FiltroUsuarioWeb filtroUsuarioWeb = new FiltroUsuarioWeb();
					filtroUsuarioWeb.setNombrePrivilegio(Constantes.PRIVILEGIO_NOMBRE_SUBASTADOR);
					filtroUsuarioWeb.setActivo(Constantes.ACTIVO);
					List<UsuarioWeb> lstUsuariosWebNotificar = getUsuarioEjbRemote().getUsuarioWebByPrivilegio(filtroUsuarioWeb);
					
					List<Contacto> contactosForMailNotification = new ArrayList<Contacto>();			
					for (UsuarioWeb usuarioWebNotificar : lstUsuariosWebNotificar) { 
						Notificacion notificacion = new Notificacion();
						notificacion.setUsuarioWeb(usuarioWebNotificar);
						notificacion.setCodigoOrigenNotificacion(subasta.getCodigoSubasta());
						
						Tupla tipoNotificacion = new Tupla();
						tipoNotificacion.setId(Constantes.TIPONOTIFICACION_NUEVA_SUBASTA);
						notificacion.setTipoNotificacion(tipoNotificacion);
						
						Integer addNotificacion = getUsuarioEjbRemote().addNotificacionUsuario(notificacion);
						
						if(addNotificacion != null && !addNotificacion.equals(new Integer("0"))) {
							contactosForMailNotification.addAll(usuarioWebNotificar.getUsuario().getContactos());
						} else {
							throw new RuntimeException("Error al registrar notificacion para el Usuario: "+  usuarioWebNotificar.getCodigoUsuarioWeb() );
						}
						
					}
					
					Tupla mailNotification = getCommonEjbRemote().getConfiguracion(Constantes.ACTIVATE_MAIL_NOTIFYS);
					
					if(mailNotification != null && Constantes.ACTIVA.equals(mailNotification.getId())) {
						try {
							//NOTIFICACION DE MAILS PARA LOS PROVEEDORES DEL SERVICIO PROVENIENTE EN LA SOLICITUD
							List<String> mailsCCO = new ArrayList<String>();
							for(Contacto contacto : contactosForMailNotification){
								mailsCCO.add(contacto.getEmail());
							}
							getUsuarioEjbRemote().sendMailNotification(Constantes.MAIL_NOTIFICA_NUEVASOLICITUD, new ArrayList<String>(), new ArrayList<String>(), mailsCCO);
							
							//NOTIFICACION DE MAIL PARA EL CLIENTE QUE GENERA LA SOLICITUD
							List<String> mailsTO = new ArrayList<String>();
							for(Contacto contacto : solicitud.getUsuarioWeb().getUsuario().getContactos()){
								mailsCCO.add(contacto.getEmail());
							}
							getUsuarioEjbRemote().sendMailNotification(Constantes.MAIL_NOTIFICA_NUEVASOLICITUD, mailsTO, new ArrayList<String>(), new ArrayList<String>());
						
						} catch (AddressException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (MessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				} else  {
					throw new RuntimeException("Error al iniciar la Subasta");
				}
				
			} else  {
				throw new RuntimeException("Error al registar la solicitud del servicio");
			}
			
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return subasta;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
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
	
	public IUsuarioEjbRemote getUsuarioEjbRemote() {
		return usuarioEjbRemote;
	}

	public void setUsuarioEjbRemote(IUsuarioEjbRemote usuarioEjbRemote) {
		this.usuarioEjbRemote = usuarioEjbRemote;
	}
}
