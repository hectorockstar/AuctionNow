package com.auctionnow.controller;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.ejb.EJB;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.auctionnow.ejb.ICommonEjbRemote;
import com.auctionnow.ejb.ISolicitudEjbRemote;
import com.auctionnow.ejb.ITransaccionEjbRemote;
import com.auctionnow.ejb.IUsuarioEjbRemote;
import com.auctionnow.utils.AuctionNowGetEJB;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class AbstractControllerConfig extends ActionSupport
		implements ApplicationAware, SessionAware, RequestAware, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String SUCCESS = "SUCCESS";
	public static final String ERROR = "ERROR";
	public static final String NONE = "NONE";
	public static final String REPORTE = "REPORTE";
	
	public static final String INFO_MESSAGE = "Info";
	public static final String WARN_MESSAGE = "Warning";
	public static final String ERROR_MESSAGE = "Error";

	protected Map<String, Object> applicacion;
	protected Map<String, Object> session;
	protected Map<String, Object> request;
	protected String messageType = INFO_MESSAGE;
	
	protected InputStream inputStream;

	@EJB
	private IUsuarioEjbRemote usuarioEjbRemote;

	@EJB
	private ICommonEjbRemote commonEjbRemote;

	@EJB
	private ISolicitudEjbRemote solicitudEjbRemote;

	@EJB
	private ITransaccionEjbRemote transaccionEjbRemote;

	AuctionNowGetEJB ejbInstance = new AuctionNowGetEJB();

	@Override
	public void prepare() throws Exception {
		this.setUsuarioEjbRemote((IUsuarioEjbRemote) ejbInstance
				.getEJB("ActNowUsuarioService/ActNowUsuarioEJB/UsuarioEjb!" + IUsuarioEjbRemote.class.getName()));
		
		this.setCommonEjbRemote((ICommonEjbRemote) ejbInstance
				.getEJB("ActNowCommonService/ActNowCommonEJB/CommonEjb!"    + ICommonEjbRemote.class.getName()));

		this.setTransaccionEjbRemote((ITransaccionEjbRemote) ejbInstance
				.getEJB("ActNowTransaccionService/ActNowTransaccionEJB/TransaccionEjb!" + ITransaccionEjbRemote.class.getName()));
		
		this.setSolicitudEjbRemote((ISolicitudEjbRemote) ejbInstance
				.getEJB("ActNowSolicitudService/ActNowSolicitudEJB/SolicitudEjb!"   + ISolicitudEjbRemote.class.getName()));
		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setApplication(Map<String, Object> applicacion) {
		this.applicacion = applicacion;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public IUsuarioEjbRemote getUsuarioEjbRemote() {
		return usuarioEjbRemote;
	}

	public void setUsuarioEjbRemote(IUsuarioEjbRemote usuarioEjbRemote) {
		this.usuarioEjbRemote = usuarioEjbRemote;
	}

	public ICommonEjbRemote getCommonEjbRemote() {
		return commonEjbRemote;
	}

	public void setCommonEjbRemote(ICommonEjbRemote commonEjbRemote) {
		this.commonEjbRemote = commonEjbRemote;
	}

	public ISolicitudEjbRemote getSolicitudEjbRemote() {
		return solicitudEjbRemote;
	}

	public void setSolicitudEjbRemote(ISolicitudEjbRemote solicitudEjbRemote) {
		this.solicitudEjbRemote = solicitudEjbRemote;
	}

	public ITransaccionEjbRemote getTransaccionEjbRemote() {
		return transaccionEjbRemote;
	}

	public void setTransaccionEjbRemote(ITransaccionEjbRemote transaccionEjbRemote) {
		this.transaccionEjbRemote = transaccionEjbRemote;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public void jsonFormatResult(Object object){
		String json = "";
		if(object instanceof ArrayList) {
			json = new Gson().toJson(object);
		} else if (object instanceof Integer) {
			json = "[{ resultado : " + object + "}]";
		}
		
		inputStream = new StringBufferInputStream(json);
		
	}
	
	public String getFechaFormat(Date fechaAformatear) {
		SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFormat = formatterDate.format(fechaAformatear);
		
		return fechaFormat;
	}

}
