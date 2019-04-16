package com.auctionnow.business.usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.xerces.impl.XMLEntityManager.Entity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.auctionnow.common.Comuna;
import com.auctionnow.common.Tupla;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.UsuarioWeb;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/usuario-context-test.xml"})
@Transactional
public class UsuarioBusinessTEST {
	
	@Autowired
	private UsuarioBusiness usuarioBusiness;

	@Test
	@Rollback
	public void addCuentaUsuarioCliente(){
		
		UsuarioWeb usuarioWeb = new UsuarioWeb();
		usuarioWeb = new UsuarioWeb();
		usuarioWeb.setContrasena("hrs");
		usuarioWeb.setEstadoCuenta("A");
		usuarioWeb.setFirmaComentario("Gracias!");
		usuarioWeb.setNombreUsuario("hector123");
		usuarioWeb.setPregunta1("?1");
		usuarioWeb.setPregunta2("?2");
		usuarioWeb.setPregunta3("?3");
		usuarioWeb.setRespuesta1("R1");
		usuarioWeb.setRespuesta2("R2");
		usuarioWeb.setRespuesta3("R3");
		
		Cliente usercliente = new Cliente();
		usercliente.setApellidoMaterno("Tapia");
		usercliente.setApellidoPaterno("Gonzalez");
		usercliente.setFechaNacimiento(new Date());
		usercliente.setFechaRegistro(new Date());
		usercliente.setGenero("M");
		usercliente.setNombre("Hector");
		usercliente.setOcupacion("EST");
		usercliente.setRut("18092255");
		usercliente.setRutDV("5");
		
		Contacto contacto = new Contacto();
		contacto.setCodigoContacto("34");
		contacto.setEmail("hec.gonzalezt@gmail.com");
		contacto.setMovil1("34234324");
		contacto.setMovil2("34234234");
		contacto.setPrioridad(1);
		contacto.setTelefono1("32423432");
		contacto.setTelefono2("34234324");

		Tupla tipoContacto = new Tupla();
		tipoContacto.setId("2");
		contacto.setTipoContacto(tipoContacto);

		Direccion direccion = new Direccion();
		direccion.setCalle("reco");
		direccion.setCodigoDireccion("85");
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
		direccion.setTipoDireccion(tipoDireccion);
		
		List<Contacto> contactos = new ArrayList<Contacto>();
		contactos.add(contacto);
		usercliente.setContactos(contactos);

		List<Direccion> direcciones = new ArrayList<Direccion>();
		direcciones.add(direccion);
		usercliente.setDirecciones(direcciones);
		
		usuarioWeb.setUsuario(usercliente);
		
		Integer resultadoRegistro = usuarioBusiness.addCuentaUsuarioCliente(usuarioWeb);
		
		Assert.state(resultadoRegistro>0, "Exito al Registrar!");
		
	}
	
	
}
