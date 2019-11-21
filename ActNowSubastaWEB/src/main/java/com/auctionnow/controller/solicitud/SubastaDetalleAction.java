package com.auctionnow.controller.solicitud;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.common.HorarioSistema;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroSubasta;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.Notificacion;
import com.auctionnow.model.Proveedor;
import com.auctionnow.model.Solicitud;
import com.auctionnow.model.Subasta;
import com.auctionnow.model.UsuarioWeb;

public class SubastaDetalleAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Notificacion notificacion;
	protected Subasta subasta;
	protected Cliente cliente;
	protected Solicitud solicitud;
	protected Direccion direccion;
	protected Contacto contacto;
	
	public String showSubastaDetailbyNotification() {
		
		UsuarioWeb usuarioWebSolicitud = ((UsuarioWeb) getSession().get("usuarioWeb"));
		Proveedor proveedor = (Proveedor) usuarioWebSolicitud.getUsuario();
		
		FiltroSubasta filtroSubasta = new FiltroSubasta();
		filtroSubasta.setCodigoSubasta(notificacion.getCodigoOrigenNotificacion());
		
		Subasta subastaByNotification = getSolicitudEjbRemote().getDetalleSubastaForProveedor(filtroSubasta);
		
		List<Subasta> subastas = new ArrayList<Subasta>();
		subastas.add(subastaByNotification);
		
		this.setSubasta(subastaByNotification);
		this.setSolicitud(subastaByNotification.getSolicitud());
		this.setCliente(subastaByNotification.getSolicitud().getCliente());
		this.setDireccion(subastaByNotification.getSolicitud().getDireccion());
		this.setContacto(subastaByNotification.getSolicitud().getContacto());
		
		getRequest().put("subasta", subastaByNotification);
		
		String countdownDate = this.countdownDateFormat(subastaByNotification.getSolicitud().getFechaVencimientoSubasta(), subastaByNotification.getSolicitud().getHoraVencimientoSubasta());
		getRequest().put("countdownDate", countdownDate);
		
		this.jsonFormatResult(subastas);

		return Constantes.SUCCESS;
	}
	
	private String countdownDateFormat(Date countdownDate, String countdownHour) {
		
		SimpleDateFormat formatDefault = new SimpleDateFormat("MMMMM dd, yyyy");
		String countdownFormat = formatDefault.format(countdownDate) + " " + countdownHour;
		
		return countdownFormat;
	}

	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
	}

	public Subasta getSubasta() {
		return subasta;
	}

	public void setSubasta(Subasta subasta) {
		this.subasta = subasta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
}
