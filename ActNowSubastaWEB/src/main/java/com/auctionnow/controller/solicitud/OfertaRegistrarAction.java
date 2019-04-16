package com.auctionnow.controller.solicitud;

import java.util.Date;
import com.auctionnow.common.Constantes;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCliente;
import com.auctionnow.filters.FiltroSolicitud;
import com.auctionnow.filters.FiltroSubasta;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.Oferta;
import com.auctionnow.model.Proveedor;
import com.auctionnow.model.Solicitud;
import com.auctionnow.model.Subasta;
import com.auctionnow.model.UsuarioWeb;

public class OfertaRegistrarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Oferta oferta;
	protected String codigoSubasta;

	public String showDetalleSubasta() {
		//PRUEBA3
		setCodigoSubasta("SUB001");
		/////////
		
		FiltroSubasta filtroSubasta = new FiltroSubasta();
		filtroSubasta.setCodigoSubasta(codigoSubasta);
		Subasta subasta = getSolicitudEjbRemote().getSubasta(filtroSubasta);

		FiltroSolicitud filtroSolicitud = new FiltroSolicitud();
		filtroSolicitud.setCodigoSolicitud(subasta.getSolicitud().getCodigoSolicitud());
		Solicitud solicitud = getSolicitudEjbRemote().getSolicitud(filtroSolicitud);

		FiltroCliente filtroCliente = new FiltroCliente();
		filtroCliente.setCodigoCliente(solicitud.getCliente().getCodigoCliente());
		Cliente cliente = getUsuarioEjbRemote().getCliente(filtroCliente);

		getRequest().put("subasta", subasta);
		getRequest().put("solicitud", solicitud);
		getRequest().put("cliente", cliente);

		return Constantes.SUCCESS;
	}

	public String aceptarSubasta() {
		//PRUEBA
		setCodigoSubasta("SUB001");
		/////////
		
		UsuarioWeb usuarioWeb = (UsuarioWeb) getSession().get("usuarioWeb");
		Proveedor proveedor = (Proveedor) usuarioWeb.getUsuario();

		Integer regSubProv = getSolicitudEjbRemote().addSubastaProveedor(codigoSubasta, proveedor.getCodigoProveedor());
		if (regSubProv != null && regSubProv > 0) {
			return Constantes.SUCCESS;
		} else {
			return Constantes.ERROR;
		}
	}

	public String addOferta() {

		/////// PRUEBA
		setCodigoSubasta("SUB001");
		oferta = new Oferta();
		oferta.setMontoOferta(new Long("30000"));
		//////////////

		// GENERAR CODIGO OFERTA
		oferta.setCodigoOferta("OFER001");
		oferta.setFechaOferta(new Date());
		oferta.setValorAgregado(oferta.getMontoOferta()); // MULTIPLICAR POR VALOR DE LA COMISION (SE OBTIENE DE AN_CONFIGURACION)
		oferta.setCodigoSubasta(codigoSubasta); // VIENE DE LA VISTA

		UsuarioWeb usuarioWeb = (UsuarioWeb) getSession().get("usuarioWeb");
		Proveedor proveedor = (Proveedor) usuarioWeb.getUsuario();
		oferta.setProveedor(proveedor);
		
		Integer resRegOferta = getSolicitudEjbRemote().addOferta(oferta);
		if(resRegOferta != null && resRegOferta > 0){
			//TODO
			//Actualizar Subasta
			// 1ero cantidad de Ofertas, si es 0 actualizar monto inicial
			Integer cantidadOfertas = 0; // OBTENER TABLA AN_OFERTAS
			
			// 2do Obtener Monto de la Oferta de "Monto Minimo"
			Long montoMinimoActual = new Long("3000"); // OBTENER TABLA AN_OFERTAS
			
			FiltroSubasta filtroSubasta = new FiltroSubasta();
			filtroSubasta.setCodigoSubasta(codigoSubasta); // VIENE DE LA VISTA
			Subasta subasta = getSolicitudEjbRemote().getSubasta(filtroSubasta);
			
			if(cantidadOfertas == 0){
				subasta.setMontoInicial(oferta.getMontoOferta());
			}
			
			subasta.setMontoMinimo(montoMinimoActual);
			
			getSolicitudEjbRemote().actualizaSubasta(subasta);
		}
		
		return Constantes.SUCCESS;
	}

	public String getCodigoSubasta() {
		return codigoSubasta;
	}

	public void setCodigoSubasta(String codigoSubasta) {
		this.codigoSubasta = codigoSubasta;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

}
