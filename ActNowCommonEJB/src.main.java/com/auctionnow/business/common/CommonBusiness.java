package com.auctionnow.business.common;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.auctionnow.common.Ciudad;
import com.auctionnow.common.Comuna;
import com.auctionnow.common.Mail;
import com.auctionnow.common.Pais;
import com.auctionnow.common.Region;
import com.auctionnow.common.Tupla;
import com.auctionnow.data.common.ICommonDAO;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroDivGeografica;

public class CommonBusiness implements ICommonBusiness {

	private static final int LENGTH_20 = 20;
	
	private ICommonDAO commonDAO;

	public CommonBusiness(ICommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	public List<Pais> getPais(FiltroDivGeografica filtroDivGeografica) {
		return commonDAO.getPais(filtroDivGeografica);
	}

	public List<Region> getRegion(FiltroDivGeografica filtroDivGeografica) {
		return commonDAO.getRegion(filtroDivGeografica);
	}

	public List<Ciudad> getCiudad(FiltroDivGeografica filtroDivGeografica) {
		return commonDAO.getCiudad(filtroDivGeografica);
	}

	public List<Comuna> getComuna(FiltroDivGeografica filtroDivGeografica) {
		return commonDAO.getComuna(filtroDivGeografica);
	}

	public Comuna getDivGeo(FiltroDivGeografica filtroDivGeografica) {
		return commonDAO.getDivGeo(filtroDivGeografica);
	}

	public List<Tupla> getParameters(FiltroCatalogo filtroCatalogo) {
		return commonDAO.getParameters(filtroCatalogo);
	}
	
	public Tupla getParameter(FiltroCatalogo filtroCatalogo) {
		return commonDAO.getParameter(filtroCatalogo);
	}

	public Mail getMailMessage(String codigoMail) {
		return commonDAO.getMailMessage(codigoMail);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public String getSecuenciaRegistro(FiltroCatalogo filtroCatalogo) {
		Tupla secuenciaActual = commonDAO.getSecuenciaRegistro(filtroCatalogo);
		int cantCeros = LENGTH_20 - (secuenciaActual.getId().length());
		
		Integer secNro = Integer.valueOf(secuenciaActual.getDescripcion()) + 1;
		String secuencia = String.format("%0" + cantCeros + "d", secNro);
		
		filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setKey(secuenciaActual.getId());
		filtroCatalogo.setValue(String.valueOf(secNro));
		commonDAO.updateSecuenciaRegistro(filtroCatalogo);

		return secuenciaActual.getId() + secuencia;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer updateSecuenciaRegistro(FiltroCatalogo filtroCatalogo) {
		return commonDAO.updateSecuenciaRegistro(filtroCatalogo);
	}

}
