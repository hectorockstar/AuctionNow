package com.auctionnow.controller.usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.auctionnow.common.Ciudad;
import com.auctionnow.common.Comuna;
import com.auctionnow.common.Constantes;
import com.auctionnow.common.Pais;
import com.auctionnow.common.Region;
import com.auctionnow.common.Tupla;
import com.auctionnow.controller.AbstractControllerConfig;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroContacto;
import com.auctionnow.filters.FiltroDireccion;
import com.auctionnow.filters.FiltroDivGeografica;
import com.auctionnow.filters.FiltroServicio;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.Empresa;
import com.auctionnow.model.Servicio;

public class EmpresaActualizarAction extends AbstractControllerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Empresa empresa;

	public String showActualizaEmpresa() {
		FiltroServicio filtroServicio = new FiltroServicio();
		List<Servicio> servicios = getTransaccionEjbRemote().getServicios(filtroServicio);

		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_DIRECCION_TIPO);
		List<Tupla> tipsDirecciones = getCommonEjbRemote().getParameter(filtroCatalogo);

		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_CONTACTO_TIPO);
		List<Tupla> tipsContactos = getCommonEjbRemote().getParameter(filtroCatalogo);

		String codigoTitular = empresa.getCodigoEmpresa();

		FiltroDireccion filtroDireccion = new FiltroDireccion();
		filtroDireccion.setCodigoTitular(codigoTitular);
		List<Direccion> direcciones = getUsuarioEjbRemote().getDirecciones(filtroDireccion);

		FiltroContacto filtroContacto = new FiltroContacto();
		filtroContacto.setCodigoTitular(codigoTitular);
		List<Contacto> contactos = getUsuarioEjbRemote().getContactos(filtroContacto);

		FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
		List<Comuna> comunas = getCommonEjbRemote().getComuna(filtroDivGeografica);
		List<Ciudad> ciudades = getCommonEjbRemote().getCiudad(filtroDivGeografica);
		List<Region> regiones = getCommonEjbRemote().getRegion(filtroDivGeografica);
		List<Pais> paises = getCommonEjbRemote().getPais(filtroDivGeografica);

		getRequest().put("tipsDirecciones", tipsDirecciones);
		getRequest().put("tipsContactos", tipsContactos);
		getRequest().put("direcciones", direcciones);
		getRequest().put("contactos", contactos);
		getRequest().put("servicios", servicios);
		getRequest().put("comunas", comunas);
		getRequest().put("ciudades", ciudades);
		getRequest().put("regiones", regiones);
		getRequest().put("paises", paises);

		return Constantes.SUCCESS;
	}

	public String actualizaEmpresa() {
		
		/// PRUEBA
		empresa = new Empresa();
		empresa.setCodigoEmpresa("1234567");

		empresa.setDescripcion("HOLAHOLAHOLA");
		empresa.setVigente("S");
		empresa.setFechaOperaDesde(new Date());
		empresa.setFechaRegistro(new Date());
		empresa.setNombreEmpresa("FERRETERIA CENTRAL");

		Contacto contacto = new Contacto();
		contacto.setCodigoContacto("34");
		contacto.setEmail("hec@gmail.com");
		contacto.setMovil1("34234324");
		contacto.setMovil2("34234234");
		contacto.setPrioridad(1);
		contacto.setTelefono1("32423432");
		contacto.setTelefono2("34234324");

		Tupla tipoContacto = new Tupla();
		tipoContacto.setId("2");
		// tipoContacto.setDescripcion("OFICINA");
		contacto.setTipoContacto(tipoContacto);

		List<Contacto> contactos = new ArrayList<Contacto>();
		contactos.add(contacto);
		empresa.setContactos(contactos);

		Direccion direccion = new Direccion();
		direccion.setCalle("reco");
		direccion.setCodigoDireccion("34");
		direccion.setCodigoPostal("867568");

		Comuna comuna = new Comuna();
		comuna.setCodigoComuna("636");

		direccion.setComuna(comuna);
		direccion.setDeptoNro("2323");
		// direccion.setGeoLocalizacion(geoLocalizacion);
		direccion.setNumeracion("7676");
		direccion.setObservacion("reco vespu");
		direccion.setPiso(2);
		direccion.setPrioridad(1);

		Tupla tipoDireccion = new Tupla();
		tipoDireccion.setId("1");
		// tipoDireccion.setDescripcion("CASA");
		direccion.setTipoDireccion(tipoDireccion);

		List<Direccion> direcciones = new ArrayList<Direccion>();
		direcciones.add(direccion);
		empresa.setDirecciones(direcciones);
		////////////////////////////
		
		if(empresa.getServicios() != null && empresa.getServicios().size() > 0){
			empresa.setVigente("S");
		}

		Integer updateEmpresa = getUsuarioEjbRemote().actualizaEmpresa(empresa);

		return Constantes.SUCCESS;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
