package com.auctionnow.controller.solicitud;

import java.util.Date;
import java.util.List;

import com.auctionnow.common.Constantes;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroOferta;
import com.auctionnow.filters.FiltroSolicitud;
import com.auctionnow.filters.FiltroSubasta;
import com.auctionnow.model.BitacoraTransaccion;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.Oferta;
import com.auctionnow.model.Solicitud;
import com.auctionnow.model.Subasta;
import com.auctionnow.model.UsuarioWeb;

public class FinalizaSubastaAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String codigoSolicitud;
	protected Oferta oferta;

	public String showOfertasSubasta() {
		
		////PRUEBA
		setCodigoSolicitud("SOL0002"); // VIENE DESDE LA VISTA
		//////

		UsuarioWeb usuarioWeb = (UsuarioWeb) getSession().get("usuarioWeb");
		Cliente cliente = (Cliente) usuarioWeb.getUsuario();

		FiltroSolicitud filtroSolicitud = new FiltroSolicitud();
		filtroSolicitud.setCodigoSolicitud(codigoSolicitud); // VIENE DESDE LA VISTA
		filtroSolicitud.setCodigoCliente(cliente.getCodigoCliente());
		Solicitud solicitud = getSolicitudEjbRemote().getSolicitud(filtroSolicitud);

		FiltroSubasta filtroSubasta = new FiltroSubasta();
		filtroSubasta.setCodigoSolicitud(codigoSolicitud); // VIENE DESDE LA VISTA
		Subasta subasta = getSolicitudEjbRemote().getSubasta(filtroSubasta);

		FiltroOferta filtroOferta = new FiltroOferta();
		filtroOferta.setCodigoSubasta(subasta.getCodigoSubasta());
		List<Oferta> ofertas = getSolicitudEjbRemote().getOferta(filtroOferta);

		getRequest().put("solicitud", solicitud);
		getRequest().put("subasta", subasta);
		getRequest().put("ofertas", ofertas);

		return Constantes.SUCCESS;
	}

	public String selectedOfertaGanadora() {
		
		/////// PRUEBA
		oferta = new Oferta();
		oferta.setCodigoOferta("OFER001");
		oferta.setMontoOferta(new Long("3000"));
		oferta.setValorAgregado(new Long("30"));
		
		
		
		
		setCodigoSolicitud("SOL0002");
		//////////////
		
		UsuarioWeb usuarioWeb = (UsuarioWeb) getSession().get("usuarioWeb");
		Cliente cliente = (Cliente) usuarioWeb.getUsuario();

		FiltroSolicitud filtroSolicitud = new FiltroSolicitud();
		filtroSolicitud.setCodigoSolicitud(codigoSolicitud); // VIENE DESDE LA VISTA
		filtroSolicitud.setCodigoCliente(cliente.getCodigoCliente());
		Solicitud solicitud = getSolicitudEjbRemote().getSolicitud(filtroSolicitud);

		FiltroSubasta filtroSubasta = new FiltroSubasta();
		filtroSubasta.setCodigoSolicitud(solicitud.getCodigoSolicitud());
		Subasta subasta = getSolicitudEjbRemote().getSubasta(filtroSubasta);
		
		subasta.setEstadoSubasta("F"); // ESTADO FINALIZADA
		subasta.setOfertaGanadora(oferta); // CODIGO OFERTA VIENE DESDE LA VISTA
		subasta.setMontoFinal(oferta.getMontoOferta());
		subasta.setFechaTermino(new Date());
		
		Integer resUpdSubasta = getSolicitudEjbRemote().actualizaSubasta(subasta);
		if(resUpdSubasta != null && resUpdSubasta > 0){
			Integer resRegTrans = getTransaccionEjbRemote().addTransaccion(subasta);
			
			//EMPEZAR MEDIO DE PAGO
		}
		
		return Constantes.SUCCESS;
	}

	public String getCodigoSolicitud() {
		return codigoSolicitud;
	}

	public void setCodigoSolicitud(String codigoSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

}
