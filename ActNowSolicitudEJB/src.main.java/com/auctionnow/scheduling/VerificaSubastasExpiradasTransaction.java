package com.auctionnow.scheduling;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import com.auctionnow.business.solicitud.ISolicitudBusiness;
import com.auctionnow.common.Constantes;
import com.auctionnow.common.HorarioSistema;
import com.auctionnow.ejb.ICommonEjbRemote;
import com.auctionnow.filters.FiltroSubasta;
import com.auctionnow.model.Subasta;

public class VerificaSubastasExpiradasTransaction implements IAuctionNowJobExecution {

	@EJB
	private ISolicitudBusiness solicitudBusiness;
	
	@EJB
	private ICommonEjbRemote commonEjbRemote;
	
	public VerificaSubastasExpiradasTransaction(ISolicitudBusiness solicitudBusiness, ICommonEjbRemote commonEjbRemote) {
		this.solicitudBusiness = solicitudBusiness;
		this.commonEjbRemote = commonEjbRemote;
	}
	
	@Override
	public Object doInTransaction() {
		
		FiltroSubasta filtroSubasta = new FiltroSubasta();
		List<String> lstSubastaEstados = new ArrayList<String>();
		lstSubastaEstados.add(Constantes.ESTADO_SUBASTA_EN_CURSO);
		
		filtroSubasta.setEstadosSubasta(lstSubastaEstados);
		
		List<Subasta> lstSubastasByStatus = solicitudBusiness.getSubastasByStatus(filtroSubasta);
		
		for (Subasta subasta : lstSubastasByStatus) {
			
			HorarioSistema horarioSistema = getCommonEjbRemote().getCurrentDate();
			
			Double hoursForTheEnd = getCommonEjbRemote().subtractDates(subasta.getSolicitud().getFechaVencimientoSubasta(), subasta.getSolicitud().getHoraVencimientoSubasta(), horarioSistema.getFechaActual(), horarioSistema.getHoraActual());
			if(hoursForTheEnd <= 0 && Constantes.ESTADO_SUBASTA_EN_CURSO.equals(subasta.getEstadoSubasta())) {
				System.out.println("Actualizar estado Subasta a Finalizada");
				//this.getSolicitudBusiness().
			}
		}
		
		return null;
	}

	public ISolicitudBusiness getSolicitudBusiness() {
		return solicitudBusiness;
	}

	public void setSolicitudBusiness(ISolicitudBusiness solicitudBusiness) {
		this.solicitudBusiness = solicitudBusiness;
	}

	public ICommonEjbRemote getCommonEjbRemote() {
		return commonEjbRemote;
	}

	public void setCommonEjbRemote(ICommonEjbRemote commonEjbRemote) {
		this.commonEjbRemote = commonEjbRemote;
	}
	
}
