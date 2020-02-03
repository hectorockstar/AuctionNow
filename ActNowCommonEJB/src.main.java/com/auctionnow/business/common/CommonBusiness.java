package com.auctionnow.business.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.auctionnow.common.Ciudad;
import com.auctionnow.common.Comuna;
import com.auctionnow.common.HorarioSistema;
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
	
	public HorarioSistema getCurrentDate() {
		return commonDAO.getCurrentDate();
	}
	
	public Tupla getConfiguracion(String codigoConfiguracion) {
		return commonDAO.getConfiguracion(codigoConfiguracion);
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
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Double subtractDates(Date mayorDate, String mayorHour, Date minorDate, String minorHour) {
		Double hourDifferences = null;
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String strMayorDateformat = format1.format(mayorDate);
		String strMinorDateformat = format1.format(minorDate);
		
		Date mayorDateFinalFormat = null;
		Date minorDateFinalFormat = null;
		try {
			mayorDateFinalFormat = format2.parse(strMayorDateformat + " " + mayorHour + ":00");
			minorDateFinalFormat = format2.parse(strMinorDateformat + " " + minorHour + ":00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar now = Calendar.getInstance();
        now.setTime(mayorDateFinalFormat);
        System.out.println(format2.format(now.getTime()));		
        
        Calendar now2 = Calendar.getInstance();
        now2.setTime(minorDateFinalFormat);
        System.out.println(format2.format(now2.getTime()));	
        
        String resulDatetDifferences = String.valueOf(((((now2.getTime().getTime()-now.getTime().getTime())/1000)/60)/60));
        hourDifferences = Double.parseDouble(resulDatetDifferences);
		
		return hourDifferences;
	}

	@Override
	public void connectionTest() {
		System.out.print("CONNECTION TO COMMON EJB IS DONE");
	}

}
