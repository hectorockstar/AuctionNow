package com.auctionnow.controller.solicitud;

import java.util.ArrayList;
import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.model.Notificacion;
import com.auctionnow.model.Proveedor;
import com.auctionnow.model.UsuarioWeb;

public class SubastaDetalleAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Notificacion notificacion;
	
	public String showSubastaDetail() {
		
		UsuarioWeb usuarioWebSolicitud = ((UsuarioWeb) getSession().get("usuarioWeb"));
		Proveedor proveedor = (Proveedor) usuarioWebSolicitud.getUsuario();
		
		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		proveedores.add(proveedor);
		
		this.jsonFormatResult(proveedores);

		return Constantes.SUCCESS;
	}

	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
	}
	
}
