package com.auctionnow.controller.common;

import java.util.List;

import com.auctionnow.common.Ciudad;
import com.auctionnow.common.Comuna;
import com.auctionnow.common.Pais;
import com.auctionnow.common.Region;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroDivGeografica;

public class CommonController extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Pais pais;
	protected Region region;
	protected Ciudad ciudad;
	protected Comuna comuna;

	public String getRegionesByPais() {
		FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
		filtroDivGeografica.setCodigoPais(pais.getCodigoPais());

		List<Region> regiones = getCommonEjbRemote().getRegion(filtroDivGeografica);
		this.getRequest().put("regiones", regiones);
		
		return SUCCESS;
		
	}

	public String getCiudadesByRegion() {

		FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
		filtroDivGeografica.setCodigoRegion(region.getCodigoRegion());

		List<Ciudad> ciudades = getCommonEjbRemote().getCiudad(filtroDivGeografica);
		this.getRequest().put("ciudades", ciudades);

		return SUCCESS;

	}

	public String getComunaByCiudad() {

		FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
		filtroDivGeografica.setCodigoCiudad(ciudad.getCodigoCiudad());

		List<Comuna> comunas = getCommonEjbRemote().getComuna(filtroDivGeografica);
		this.getRequest().put("comunas", comunas);

		return SUCCESS;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

}
