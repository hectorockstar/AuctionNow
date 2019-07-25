package com.auctionnow.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import com.auctionnow.business.common.ICommonBusiness;
import com.auctionnow.common.Ciudad;
import com.auctionnow.common.Comuna;
import com.auctionnow.common.Mail;
import com.auctionnow.common.Pais;
import com.auctionnow.common.Region;
import com.auctionnow.common.Tupla;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroDivGeografica;

@Stateless(name = "CommonEjb")
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class CommonEjb implements ICommonEjbLocal, ICommonEjbRemote{

	@Autowired
	private ICommonBusiness commonBusiness;
	
	public CommonEjb(){
		
	}
	
	public List<Pais> getPais(FiltroDivGeografica filtroDivGeografica) {
		return commonBusiness.getPais(filtroDivGeografica);
	}

	public List<Region> getRegion(FiltroDivGeografica filtroDivGeografica) {
		return commonBusiness.getRegion(filtroDivGeografica);
	}

	public List<Ciudad> getCiudad(FiltroDivGeografica filtroDivGeografica) {
		return commonBusiness.getCiudad(filtroDivGeografica);
	}

	public List<Comuna> getComuna(FiltroDivGeografica filtroDivGeografica) {
		return commonBusiness.getComuna(filtroDivGeografica);
	}

	public List<Tupla> getParameters(FiltroCatalogo filtroCatalogo) {
		return commonBusiness.getParameters(filtroCatalogo);
	}
	
	public Tupla getParameter(FiltroCatalogo filtroCatalogo) {
		return commonBusiness.getParameter(filtroCatalogo);
	}

	public Comuna getDivGeo(FiltroDivGeografica filtroDivGeografica) {
		return commonBusiness.getDivGeo(filtroDivGeografica);
	}

	public Mail getMailMessage(String codigoMail) {
		return commonBusiness.getMailMessage(codigoMail);
	}

	public String getSecuenciaRegistro(FiltroCatalogo filtroCatalogo) {
		return commonBusiness.getSecuenciaRegistro(filtroCatalogo);
	}

	public Integer updateSecuenciaRegistro(FiltroCatalogo filtroCatalogo) {
		return commonBusiness.updateSecuenciaRegistro(filtroCatalogo);
	}

}
