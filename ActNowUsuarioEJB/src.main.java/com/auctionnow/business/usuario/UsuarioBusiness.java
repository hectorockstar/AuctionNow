package com.auctionnow.business.usuario;

import java.util.Date;
import java.util.List;

import com.auctionnow.common.Comuna;
import com.auctionnow.common.Constantes;
import com.auctionnow.common.Mail;
import com.auctionnow.common.Tupla;
import com.auctionnow.data.usuario.IUsuarioDAO;
import com.auctionnow.ejb.ICommonEjbRemote;
import com.auctionnow.exception.AuctionNowServiceException;
import com.auctionnow.filters.FiltroCargo;
import com.auctionnow.filters.FiltroCatalogo;
import com.auctionnow.filters.FiltroCliente;
import com.auctionnow.filters.FiltroContacto;
import com.auctionnow.filters.FiltroDireccion;
import com.auctionnow.filters.FiltroDivGeografica;
import com.auctionnow.filters.FiltroEmpresa;
import com.auctionnow.filters.FiltroGeoLoc;
import com.auctionnow.filters.FiltroPrivilegio;
import com.auctionnow.filters.FiltroProveedor;
import com.auctionnow.filters.FiltroUsuarioWeb;
import com.auctionnow.model.Cargo;
import com.auctionnow.model.Cliente;
import com.auctionnow.model.Contacto;
import com.auctionnow.model.Direccion;
import com.auctionnow.model.Empresa;
import com.auctionnow.model.FichaServicioCliente;
import com.auctionnow.model.FichaServicioProveedor;
import com.auctionnow.model.GeoLocalizacion;
import com.auctionnow.model.Privilegio;
import com.auctionnow.model.Proveedor;
import com.auctionnow.model.Usuario;
import com.auctionnow.model.UsuarioWeb;
import com.auctionnow.model.UsuarioWebTienePrivilegio;

import java.util.Properties;

import javax.ejb.EJB;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioBusiness implements IUsuarioBusiness {
	
	private IUsuarioDAO usuarioDAO;
	
	@EJB
	private ICommonEjbRemote commonEjbRemote;
	
	public UsuarioBusiness(IUsuarioDAO usuarioDAO, ICommonEjbRemote commonEjbRemote) throws AuctionNowServiceException {
		this.usuarioDAO = usuarioDAO;
		this.commonEjbRemote = commonEjbRemote;
	}
	
	public ICommonEjbRemote getCommonEjbRemote() {
		return commonEjbRemote;
	}
	
	public void setCommonEjbRemote(ICommonEjbRemote commonEjbRemote) {
		this.commonEjbRemote = commonEjbRemote;
	}
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer addCuentaUsuarioAdministrador(UsuarioWeb usuarioWeb) {
		Usuario usuarioAdm = usuarioWeb.getUsuario();
		usuarioAdm.setFechaRegistro(new Date());

		Tupla tipoUsuario = new Tupla();
		tipoUsuario.setId(Constantes.TIPOUSUARIO_SIGLA_ADMINISTRADOR);
		usuarioAdm.setTipoUsuario(tipoUsuario);

		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);

		filtroCatalogo.setKey(Constantes.SECUENCIA_USUARIO);
		usuarioAdm.setCodigoUsuario(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		Integer registraUsuario = usuarioDAO.addUsuario(usuarioWeb.getUsuario());

		filtroCatalogo.setKey(Constantes.SECUENCIA_USUARIOWEB);
		usuarioWeb.setCodigoUsuarioWeb(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		Integer registraUsuarioWeb = usuarioDAO.addUsuarioWeb(usuarioWeb);

		return registraUsuario * registraUsuarioWeb;
	}
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer addCuentaUsuarioCliente(UsuarioWeb usuarioWeb) {
		Cliente cliente = (Cliente) usuarioWeb.getUsuario();
		cliente.setFechaRegistro(new Date());

		Tupla tipoCliente = new Tupla();
		tipoCliente.setId(Constantes.TIPOCLIENTE_SIGLA_PERSONA);
		cliente.setTipoCliente(tipoCliente);

		Tupla tipoUsuario = new Tupla();
		tipoUsuario.setId(Constantes.TIPOUSUARIO_SIGLA_CLIENTE);
		cliente.setTipoUsuario(tipoUsuario);

		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);

		filtroCatalogo.setKey(Constantes.SECUENCIA_USUARIO);
		cliente.setCodigoUsuario(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		Integer registraUsuario = usuarioDAO.addUsuario(usuarioWeb.getUsuario());

		filtroCatalogo.setKey(Constantes.SECUENCIA_CLIENTE);
		cliente.setCodigoCliente(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		Integer registraCliente = usuarioDAO.addUsuarioCliente(cliente);

		filtroCatalogo.setKey(Constantes.SECUENCIA_USUARIOWEB);
		usuarioWeb.setCodigoUsuarioWeb(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		Integer registraUsuarioWeb = usuarioDAO.addUsuarioWeb(usuarioWeb);

		return registraUsuario * registraCliente * registraUsuarioWeb;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer addCuentaUsuarioProveedor(UsuarioWeb usuarioWeb) {
		Proveedor proveedor = (Proveedor) usuarioWeb.getUsuario();
		proveedor.setFechaRegistro(new Date());

		Tupla tipoUsuario = new Tupla();
		tipoUsuario.setId(Constantes.TIPOUSUARIO_SIGLA_PROVEEDOR);
		proveedor.setTipoUsuario(tipoUsuario);
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
		filtroCatalogo.setKey(Constantes.SECUENCIA_USUARIO);
		proveedor.setCodigoUsuario(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		Integer registraUsuario = usuarioDAO.addUsuario(usuarioWeb.getUsuario());
		
		filtroCatalogo.setKey(Constantes.SECUENCIA_PROVEEDOR);
		proveedor.setCodigoProveedor(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		Integer registraProveedor = usuarioDAO.addUsuarioProveedor(proveedor);
		
		filtroCatalogo.setKey(Constantes.SECUENCIA_USUARIOWEB);
		usuarioWeb.setCodigoUsuarioWeb(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		Integer registraUsuarioWeb = usuarioDAO.addUsuarioWeb(usuarioWeb);

		return registraUsuario * registraProveedor * registraUsuarioWeb;
	}
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer addCuentaUsuarioEmpresa(UsuarioWeb usuarioWeb) {
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
		
		Empresa empresa = usuarioWeb.getEmpresa();
		empresa.setFechaRegistro(new Date());
		empresa.setVigente("S");
		
		filtroCatalogo.setKey(Constantes.SECUENCIA_USUARIOWEB);
		usuarioWeb.setCodigoUsuarioWeb(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		
		filtroCatalogo.setKey(Constantes.SECUENCIA_EMPRESA);
		empresa.setCodigoEmpresa(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		
		Integer registraUsuarioWeb = usuarioDAO.addUsuarioWeb(usuarioWeb);
		Integer registraEmpresa = usuarioDAO.addEmpresa(empresa);

		return registraUsuarioWeb * registraEmpresa;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer addEmpresa(Empresa empresa) {
		
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
		
		empresa.setFechaRegistro(new Date());
		empresa.setVigente("S");
		
		filtroCatalogo.setKey(Constantes.SECUENCIA_EMPRESA);
		empresa.setCodigoEmpresa(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		Integer registraEmpresa = usuarioDAO.addEmpresa(empresa);

		return registraEmpresa;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer addContacto(Contacto contacto, String codigoTitular) {
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
		filtroCatalogo.setKey(Constantes.SECUENCIA_CONTACTO);
		contacto.setCodigoContacto(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		
		Integer registraContacto = usuarioDAO.addContacto(contacto, codigoTitular);
		
		return registraContacto;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer addDireccion(Direccion direccion, String codigoTitular) {
		FiltroCatalogo filtroCatalogo = new FiltroCatalogo();
		filtroCatalogo.setTipoCatalogo(Constantes.CATALOGO_SECUENCIA_REGISTRO);
		filtroCatalogo.setKey(Constantes.SECUENCIA_DIRECCION);
		direccion.setCodigoDireccion(getCommonEjbRemote().getSecuenciaRegistro(filtroCatalogo));
		
		Integer registraDireccion = usuarioDAO.addDireccion(direccion, codigoTitular);
		
		return registraDireccion;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer actualizaCuentaUsuarioCliente(UsuarioWeb usuarioWeb) {
		Tupla tipoUsuarioWeb = new Tupla();
		tipoUsuarioWeb.setId(Constantes.TIPOUSUARIO_SIGLA_CLIENTE);
		usuarioWeb.setTipoUsuarioWeb(tipoUsuarioWeb);
		
		Cliente cliente = (Cliente) usuarioWeb.getUsuario();
		
		Tupla tipoCliente = new Tupla();
		tipoCliente.setId(Constantes.TIPOCLIENTE_SIGLA_PERSONA);
		cliente.setTipoCliente(tipoCliente);
		
		Tupla tipoUsuario = new Tupla();
		tipoUsuario.setId(Constantes.TIPOUSUARIO_SIGLA_CLIENTE);
		cliente.setTipoUsuario(tipoUsuario);
		
		usuarioWeb.setUsuario(cliente);
		
		Integer actualizaUsuario = usuarioDAO.actualizaUsuario(usuarioWeb.getUsuario());
		Integer actualizaCliente = usuarioDAO.actualizaUsuarioCliente(cliente);
		Integer actualizaUsuarioWeb = usuarioDAO.actualizaUsuarioWeb(usuarioWeb);

		return actualizaUsuario * actualizaCliente * actualizaUsuarioWeb;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer actualizaCuentaUsuarioProveedor(UsuarioWeb usuarioWeb) {
		Proveedor proveedor = (Proveedor) usuarioWeb.getUsuario();

		Integer actualizaUsuario = usuarioDAO.actualizaUsuario(usuarioWeb.getUsuario());
		Integer actualizaProveedor = usuarioDAO.actualizaUsuarioProveedor(proveedor);
		Integer actualizaUsuarioWeb = usuarioDAO.actualizaUsuarioWeb(usuarioWeb);

		return actualizaUsuario * actualizaProveedor * actualizaUsuarioWeb;
	}
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer actualizaCuentaUsuarioAdministrador(UsuarioWeb usuarioWeb) {
		Usuario usuarioAdm = usuarioWeb.getUsuario();
		
		Tupla tipoUsuario = new Tupla();
		tipoUsuario.setId(Constantes.TIPOUSUARIO_SIGLA_ADMINISTRADOR);
		usuarioAdm.setTipoUsuario(tipoUsuario);
		
		usuarioWeb.setUsuario(usuarioAdm);
		
		Integer actualizaUsuario = usuarioDAO.actualizaUsuario(usuarioWeb.getUsuario());
		Integer actualizaUsuarioWeb = usuarioDAO.actualizaUsuarioWeb(usuarioWeb);

		return actualizaUsuario * actualizaUsuarioWeb;
	}
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer actualizaCuentaUsuarioEmpresa(UsuarioWeb usuarioWeb) {
		Usuario usuarioAdm = usuarioWeb.getUsuario();
		
		Tupla tipoUsuario = new Tupla();
		tipoUsuario.setId(Constantes.TIPOUSUARIO_SIGLA_EMPRESA);
		usuarioAdm.setTipoUsuario(tipoUsuario);
		
		usuarioWeb.setUsuario(usuarioAdm);
		
		Integer actualizaEmpresa = usuarioDAO.actualizaEmpresa(usuarioWeb.getEmpresa());
		Integer actualizaUsuarioWeb = usuarioDAO.actualizaUsuarioWeb(usuarioWeb);

		return actualizaEmpresa * actualizaUsuarioWeb;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer actualizaEmpresa(Empresa empresa) {
		Integer actualizaEmpresa = usuarioDAO.actualizaEmpresa(empresa);

		return actualizaEmpresa;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer actualizaContacto(Contacto contacto, String codigoTitular) {
		Integer actualizaContacto = usuarioDAO.actualizaContacto(contacto, codigoTitular);
		return actualizaContacto;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public Integer actualizaDireccion(Direccion direccion, String codigoTitular) {
		Integer actualizaDireccion = usuarioDAO.actualizaDireccion(direccion, codigoTitular);
		return actualizaDireccion;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public UsuarioWeb getUsuarioWebClienteData(FiltroUsuarioWeb filtroUsuarioWeb) {
		UsuarioWeb usuarioWeb = usuarioDAO.getUsuarioWeb(filtroUsuarioWeb);

		FiltroCliente filtroCliente = new FiltroCliente();
		filtroCliente.setCodigoUsuario(usuarioWeb.getUsuario().getCodigoUsuario());

		Cliente cliente = usuarioDAO.getCliente(filtroCliente);
		usuarioWeb.setUsuario(cliente);

		FiltroContacto filtroContacto = new FiltroContacto();
		filtroContacto.setCodigoTitular(cliente.getCodigoUsuario());
		cliente.setContactos(usuarioDAO.getContactos(filtroContacto));

		FiltroDireccion filtroDireccion = new FiltroDireccion();
		filtroDireccion.setCodigoTitular(cliente.getCodigoUsuario());
		cliente.setDirecciones(usuarioDAO.getDirecciones(filtroDireccion));

		return usuarioWeb;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public UsuarioWeb getUsuarioWebProveedorData(FiltroUsuarioWeb filtroUsuarioWeb) {
		UsuarioWeb usuarioWeb = usuarioDAO.getUsuarioWeb(filtroUsuarioWeb);

		FiltroProveedor filtroProveedor = new FiltroProveedor();
		filtroProveedor.setCodigoUsuario(usuarioWeb.getUsuario().getCodigoUsuario());

		Proveedor proveedor = usuarioDAO.getProveedor(filtroProveedor);
		usuarioWeb.setUsuario(proveedor);

		FiltroContacto filtroContacto = new FiltroContacto();
		filtroContacto.setCodigoTitular(proveedor.getCodigoUsuario());
		proveedor.setContactos(usuarioDAO.getContactos(filtroContacto));

		FiltroDireccion filtroDireccion = new FiltroDireccion();
		filtroDireccion.setCodigoTitular(proveedor.getCodigoUsuario());
		proveedor.setDirecciones(usuarioDAO.getDirecciones(filtroDireccion));

		FiltroEmpresa filtroEmpresa = new FiltroEmpresa();
		filtroEmpresa.setCodigoEmpresa(proveedor.getEmpresa().getCodigoEmpresa());
		proveedor.setEmpresa(usuarioDAO.getEmpresa(filtroEmpresa));

		return usuarioWeb;
	}
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public UsuarioWeb getUsuarioWebEmpresaData(FiltroUsuarioWeb filtroUsuarioWeb) {
		UsuarioWeb usuarioWeb = usuarioDAO.getUsuarioWeb(filtroUsuarioWeb);

		FiltroEmpresa filtroEmpresa = new FiltroEmpresa();
		filtroEmpresa.setCodigoEmpresa(usuarioWeb.getUsuario().getCodigoUsuario());

		Empresa empresa = usuarioDAO.getEmpresa(filtroEmpresa);
		usuarioWeb.setEmpresa(empresa);

		FiltroContacto filtroContacto = new FiltroContacto();
		filtroContacto.setCodigoTitular(empresa.getCodigoEmpresa());
		empresa.setContactos(usuarioDAO.getContactos(filtroContacto));

		FiltroDireccion filtroDireccion = new FiltroDireccion();
		filtroDireccion.setCodigoTitular(empresa.getCodigoEmpresa());
		empresa.setDirecciones(usuarioDAO.getDirecciones(filtroDireccion));

		return usuarioWeb;
	}

	public Empresa getEmpresa(FiltroEmpresa filtroEmpresa) {
		Empresa empresa = usuarioDAO.getEmpresa(filtroEmpresa);
		return empresa;
	}

	public List<Empresa> getEmpresas(FiltroEmpresa filtroEmpresa) {
		List<Empresa> lstEmpresas = usuarioDAO.getEmpresas();
		return lstEmpresas;
	}

	public Contacto getContacto(FiltroContacto filtroContacto) {
		return usuarioDAO.getContacto(filtroContacto);
	}

	public Direccion getDireccion(FiltroDireccion filtroDireccion) {
		return usuarioDAO.getDireccion(filtroDireccion);
	}
	
	
	public List<Cargo> getCargos(FiltroCargo filtroCargo) {
		List<Cargo> lstCargos = usuarioDAO.getCargos(filtroCargo);
		return lstCargos;
	}

	public List<UsuarioWeb> getUsuariosWebCliente(FiltroUsuarioWeb filtroUsuarioWeb) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UsuarioWeb> getUsuariosWebProveedor(FiltroUsuarioWeb filtroUsuarioWeb) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contacto> getContactos(FiltroContacto filtroContacto) {
		List<Contacto> lstContantos = usuarioDAO.getContactos(filtroContacto);
		return lstContantos;
	}

	public List<Direccion> getDirecciones(FiltroDireccion filtroDireccion) {
		List<Direccion> lstDirecciones = usuarioDAO.getDirecciones(filtroDireccion);
		return lstDirecciones;
	}

	public String validateUserLogin(String userName, String password) {
		return usuarioDAO.validateUserLogin(userName, password);
	}

	public List<Privilegio> getPrivilegios(FiltroPrivilegio filtroPrivilegio) {
		return usuarioDAO.getPrivilegios(filtroPrivilegio);
	}

	public Proveedor getProveedor(FiltroProveedor filtroProveedor) {
		return usuarioDAO.getProveedor(filtroProveedor);
	}

	public Cliente getCliente(FiltroCliente filtroCliente) {
		return usuarioDAO.getCliente(filtroCliente);
	}

	public FichaServicioCliente getClienteFicha(FiltroCliente filtroCliente) {
		return usuarioDAO.getClienteFicha(filtroCliente);
	}

	public FichaServicioProveedor getProveedorFicha(FiltroProveedor filtroProveedor) {
		return usuarioDAO.getProveedorFicha(filtroProveedor);
	}

	public GeoLocalizacion getGeoLocalizacion(FiltroGeoLoc filtroGeoLoc) {
		return usuarioDAO.getGeoLocalizacion(filtroGeoLoc);
	}

	public List<UsuarioWebTienePrivilegio> getUsuarioWebPrivilegio(FiltroUsuarioWeb filtroUsuarioWeb) {
		return usuarioDAO.getUsuarioWebPrivilegio(filtroUsuarioWeb);
	}

	public List<UsuarioWeb> getProveedores(FiltroProveedor filtroProveedor) {
		return usuarioDAO.getProveedores(filtroProveedor);
	}

	public Integer addOperacionEmpresa(Empresa empresa) {
		return null;
	}

	public Integer actualizaOperacionEmpresa(Empresa empresa) {
		return null;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public List<Direccion> asignarComunaDireccion(List<Direccion> direcciones) {

		for (Direccion dir : direcciones) {
			String codigoComuna = dir.getComuna().getCodigoComuna();

			FiltroDivGeografica filtroDivGeografica = new FiltroDivGeografica();
			filtroDivGeografica.setCodigoComuna(codigoComuna);
			Comuna comuna = getCommonEjbRemote().getDivGeo(filtroDivGeografica);

			dir.setComuna(comuna);
		}

		return direcciones;
	}

	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public void sendMailNotification(String codigoMail, List<String> mailsTO, List<String> mailsCC,
		List<String> mailsCCO) throws AddressException, MessagingException {

		Mail emailContent = getCommonEjbRemote().getMailMessage(codigoMail);

		String[] to = emailContent.getTo().split(";", -1);
		if (to[0].toString().length() > 0) {
			for (int var = 0; var < to.length; var++) {
				mailsTO.add(to[var].toString());
			}
		}

		String[] cc = emailContent.getCc().split(";", -1);
		if (cc[0].toString().length() > 0) {
			for (int var = 0; var < cc.length; var++) {
				mailsCC.add(cc[var].toString());
			}
		}

		String[] cco = emailContent.getCco().split(";", -1);
		int length = cco.length;
		if (cco[0].toString().length() > 0) {
			for (int var = 0; var < length; var++) {
				mailsCCO.add(cco[var].toString());
			}
		}

		Integer idexTo = mailsTO.size();
		Integer idexCc = mailsCC.size();
		Integer idexCco = mailsCCO.size();

		Address[] mailTo = new InternetAddress[idexTo];
		Address[] mailCc = new InternetAddress[idexCc];
		Address[] mailCco = new InternetAddress[idexCco];

		Integer posTo = 0;
		for (String mailTO : mailsTO) {
			mailTo[posTo] = new InternetAddress(mailTO);
			posTo++;
		}

		Integer posCc = 0;
		for (String mailCC : mailsCC) {
			mailCc[posCc] = new InternetAddress(mailCC);
			posCc++;
		}

		Integer posCco = 0;
		for (String mailCCO : mailsCCO) {
			mailCco[posCco] = new InternetAddress(mailCCO);
			posCco++;
		}

		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipients(Message.RecipientType.TO, mailTo);
		generateMailMessage.addRecipients(Message.RecipientType.CC, mailCc);
		generateMailMessage.addRecipients(Message.RecipientType.BCC, mailCco);

		generateMailMessage.setSubject(emailContent.getAsunto());
		generateMailMessage.setContent(emailContent.getTextMessage(), "text/html");
		System.out.println("Mail Session has been created successfully..");

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		String[] dataArr = emailContent.getFrom().split(";");
		String mailFrom = dataArr[0].toString();
		String password = dataArr[1].toString();

		transport.connect("smtp.gmail.com", mailFrom, password);
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

}
