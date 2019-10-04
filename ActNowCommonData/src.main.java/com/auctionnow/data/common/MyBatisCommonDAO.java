package com.auctionnow.data.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.auctionnow.common.Ciudad;
import com.auctionnow.common.Comuna;
import com.auctionnow.common.HorarioSistema;
import com.auctionnow.common.Mail;
import com.auctionnow.common.Pais;
import com.auctionnow.common.Region;
import com.auctionnow.common.Tupla;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroDivGeografica;
import com.auctionnow.filters.FiltroGeoLoc;

public class MyBatisCommonDAO extends SqlSessionDaoSupport implements ICommonDAO{

	@Override
	public List<Pais> getPais(FiltroDivGeografica filtroDivGeografica) {
		return (List<Pais>)getSqlSession().selectList("getPais", filtroDivGeografica);
	}

	@Override
	public List<Region> getRegion(FiltroDivGeografica filtroDivGeografica) {
		return (List<Region>)getSqlSession().selectList("getRegion", filtroDivGeografica);
	}

	@Override
	public List<Ciudad> getCiudad(FiltroDivGeografica filtroDivGeografica) {
		return (List<Ciudad>)getSqlSession().selectList("getCiudad", filtroDivGeografica);
	}

	@Override
	public List<Comuna> getComuna(FiltroDivGeografica filtroDivGeografica) {
		return (List<Comuna>)getSqlSession().selectList("getComuna", filtroDivGeografica);
	}
	
	@Override
	public Comuna getDivGeo(FiltroDivGeografica filtroDivGeografica) {
		return (Comuna)getSqlSession().selectOne("getDivGeo", filtroDivGeografica);
	}

	@Override
	public List<Tupla> getParameters(FiltroCatalogo filtroCatalogo) {
		 return (List<Tupla>)getSqlSession().selectList("getParameters", filtroCatalogo);
	}
	
	@Override
	public Tupla getParameter(FiltroCatalogo filtroCatalogo) {
		 return (Tupla)getSqlSession().selectOne("getParameter", filtroCatalogo);
	}

	@Override
	public Mail getMailMessage(String codigoMail) {
		return (Mail)getSqlSession().selectOne("getMailMessage", codigoMail);
	}

	@Override
	public Tupla getSecuenciaRegistro(FiltroCatalogo filtroCatalogo) {
		return (Tupla)getSqlSession().selectOne("getParameter", filtroCatalogo);
	}
	
	@Override
	public HorarioSistema getCurrentDate() {
		return (HorarioSistema)getSqlSession().selectOne("getCurrentDate");
	}

	@Override
	public Integer updateSecuenciaRegistro(FiltroCatalogo filtroCatalogo) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("secuencia", filtroCatalogo.getValue());
		parameters.put("key", filtroCatalogo.getKey());
		
		return (Integer)getSqlSession().update("updateSecuenciaRegistro", parameters);
	}

	
}
