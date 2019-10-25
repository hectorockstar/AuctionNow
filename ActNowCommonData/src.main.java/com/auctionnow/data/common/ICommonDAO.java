package com.auctionnow.data.common;

import java.util.List;

import com.auctionnow.common.Ciudad;
import com.auctionnow.common.Comuna;
import com.auctionnow.common.HorarioSistema;
import com.auctionnow.common.Mail;
import com.auctionnow.common.Pais;
import com.auctionnow.common.Region;
import com.auctionnow.common.Tupla;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroDivGeografica;

public interface ICommonDAO {

	List<Pais> getPais(FiltroDivGeografica filtroDivGeografica);

	List<Region> getRegion(FiltroDivGeografica filtroDivGeografica);

	List<Ciudad> getCiudad(FiltroDivGeografica filtroDivGeografica);

	List<Comuna> getComuna(FiltroDivGeografica filtroDivGeografica);

	Comuna getDivGeo(FiltroDivGeografica filtroDivGeografica);

	List<Tupla> getParameters(FiltroCatalogo filtroCatalogo);
	
	Tupla getParameter(FiltroCatalogo filtroCatalogo);
	
	Tupla getSecuenciaRegistro(FiltroCatalogo filtroCatalogo);

	Mail getMailMessage (String codigoMail);
	
	Integer updateSecuenciaRegistro(FiltroCatalogo filtroCatalogo);

	HorarioSistema getCurrentDate();

	Tupla getConfiguracion(String codigoConfiguracion);
}
