package com.auctionnow.mock;

import java.util.List;

import com.auctionnow.common.Ciudad;
import com.auctionnow.common.Comuna;
import com.auctionnow.common.HorarioSistema;
import com.auctionnow.common.Mail;
import com.auctionnow.common.Pais;
import com.auctionnow.common.Region;
import com.auctionnow.common.Tupla;
import com.auctionnow.ejb.ICommonEjbLocal;
import com.auctionnow.ejb.ICommonEjbRemote;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroDivGeografica;

public class CommonEJBMockito implements ICommonEjbLocal, ICommonEjbRemote{

	@Override
	public List<Pais> getPais(FiltroDivGeografica filtroDivGeografica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Region> getRegion(FiltroDivGeografica filtroDivGeografica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ciudad> getCiudad(FiltroDivGeografica filtroDivGeografica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comuna> getComuna(FiltroDivGeografica filtroDivGeografica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comuna getDivGeo(FiltroDivGeografica filtroDivGeografica) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSecuenciaRegistro(FiltroCatalogo filtroCatalogo) {
		Double random = Math.random();
		
		return String.valueOf(random);
	}

	@Override
	public Integer updateSecuenciaRegistro(FiltroCatalogo filtroCatalogo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mail getMailMessage(String codigoMail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tupla> getParameters(FiltroCatalogo filtroCatalogo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tupla getParameter(FiltroCatalogo filtroCatalogo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HorarioSistema getCurrentDate() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
