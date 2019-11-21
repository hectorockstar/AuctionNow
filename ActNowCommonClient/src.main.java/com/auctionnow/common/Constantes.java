package com.auctionnow.common;

public class Constantes {
	// CATALOGOS
	public static final String CATALOGO_USUARIOWEB_TIPO = "C_TIPUSUWEB";
	public static final String CATALOGO_CLIENTE_TIPO = "C_TIPCLI";
	public static final String CATALOGO_USUARIO_TIPO = "C_TIPUSU";
	public static final String CATALOGO_CONTACTO_TIPO = "C_TIPCON";
	public static final String CATALOGO_DIRECCION_TIPO = "C_TIPDIR";
	public static final String CATALOGO_GEOLOC_TIPO = "C_TIPGEO";
	public static final String CATALOGO_SERVICIO_TIPO = "C_TIPSER";
	public static final String CATALOGO_PRIVILEGIO_TIPO = "C_TIPOPRIV";
	public static final String CATALOGO_MONEDA_TIPO = "C_TIPMON";
	public static final String CATALOGO_VIAPAGO_TIPO = "C_VIAPAG";
	public static final String CATALOGO_TARJETA_TIPO = "C_TIPTAR";
	public static final String CATALOGO_GENERO = "C_GENERO";
	public static final String CATALOGO_NIVEL_PRIORIDAD = "C_PRIORIDAD";
	public static final String CATALOGO_TIPO_FECHA = "C_TIPOFECHA";
	public static final String CATALOGO_PROVEEDOR_TIPO = "C_TIPPROV";
	public static final String CATALOGO_VIGENTE = "T_VIGENTE";
	
	public static final String CATALOGO_ENTIDAD_COMERCIAL = "ENTIDAD_COMERCIAL";
	public static final String CATALOGO_VALOR_LOGICO = "VALOR_LOGICO";
	public static final String CATALOGO_SECUENCIA_REGISTRO = "SECUENCIA_REGISTRO";

	// SECUENCIAS
	public static final String SECUENCIA_CLIENTE = "CLI";
	public static final String SECUENCIA_TRANSACCION = "TRA";
	public static final String SECUENCIA_SUBASTA = "SUB";
	public static final String SECUENCIA_OFERTA = "OFE";
	public static final String SECUENCIA_USUARIOWEB = "USUW";
	public static final String SECUENCIA_USUARIO = "USU";
	public static final String SECUENCIA_PROVEEDOR = "PRO";
	public static final String SECUENCIA_FICHAPROVEEDOR = "FIPRO";
	public static final String SECUENCIA_FICHACLIENTE = "FICLI";
	public static final String SECUENCIA_PRIVILEGIO = "PRIV";
	public static final String SECUENCIA_DIRECCION = "DIR";
	public static final String SECUENCIA_CONTACTO = "CON";
	public static final String SECUENCIA_GEOLOC = "GEO";
	public static final String SECUENCIA_EMPRESA = "EMP";
	public static final String SECUENCIA_SERVICIO = "SER";
	public static final String SECUENCIA_BITTRANSACCION = "BITTRA";
	public static final String SECUENCIA_MEDIOPAGO = "MEDPAG";
	public static final String SECUENCIA_TARJETA = "TAR";
	public static final String SECUENCIA_RUBRO = "RUB";
	public static final String SECUENCIA_EJERCE_RUBRO = "EJR";
	public static final String SECUENCIA_SERVICIO_ACTIVO = "SAC";
	public static final String SECUENCIA_SOLICITUD = "SOL";
	public static final String SECUENCIA_NOTIFICACION_USUARIO = "NOTUSU";
	public static final String SECUENCIA_PRIVILEGIO_USUARIO = "PRIVUSU";

	// MAILS
	public static final String MAIL_NOTIFICA_NUEVASOLICITUD = "NUEVA_SOLICITUD";

	// TIPOS DE USUARIO
	public static final String TIPOUSUARIO_SIGLA_ADMINISTRADOR = "A";
	public static final String TIPOUSUARIO_SIGLA_CLIENTE = "C";
	public static final String TIPOUSUARIO_SIGLA_PROVEEDOR = "P";
	public static final String TIPOUSUARIO_SIGLA_EMPRESA = "E";

	public static final String TIPOUSUARIO_ADMINISTRADOR = "ADMINISTRADOR";
	public static final String TIPOUSUARIO_CLIENTE = "CLIENTE";
	public static final String TIPOUSUARIO_PROVEEDOR = "PROVEEDOR";
	public static final String TIPOUSUARIO_EMPRESA = "EMPRESA";

	// TIPOS DE CLIENTE
	public static final String TIPOCLIENTE_SIGLA_PERSONA = "P";
	public static final String TIPOCLIENTE_SIGLA_EMPRESA = "E";
	public static final String TIPOCLIENTE_SIGLA_OTRO = "O";

	public static final String TIPOCLIENTE_PERSONA = "PERSONA";
	public static final String TIPOCLIENTE_EMPRESA = "EMPRESA";
	public static final String TIPOCLIENTE_OTRO = "OTRO";

	// WEB RETURNS CONSTANTS
	public static final String SUCCESS = "SUCCESS";
	public static final String ERROR = "ERROR";

	// ESTADO CUENTA
	public static final String ACTIVA = "A";
	public static final String NO_ACTIVA = "NA";
	
	// ESTADO SERVICIO EJERCE
	public static final String ACTIVO = "A";
	
	// SERVICE RESPONCES
	public static final Integer UPDATE_DONE = 1;
	public static final Integer UPDATE_FAIL = 0;
	public static final Integer REGISTER_DONE = 1;
	public static final Integer REGISTER_FAIL = 0;
	
	// TIPO PROVEEDOR 
	public static final String TIPOPROVEEDOR_INDEPENDIENTE = "IND";
	public static final String TIPOPROVEEDOR_DEPENDIENTE = "DEP";
	
	//VALORES LOGICOS
	public static final String SI = "S";
	public static final String NO = "N";
	
	//ESTADO NOTIFICACION
	public static final String ESTADO_NOTIFICACION_CREADA = "C";
	
	//TIPO NOTIFICACION
	public static final String TIPONOTIFICACION_NUEVA_SUBASTA = "NEWSUB";
	
	//ESTADO SUBASTA
	public static final String ESTADO_SUBASTA_EN_CURSO = "EC";
	
	//NOMBRES DE PROIVILEGIOS
	public static final String PRIVILEGIO_NOMBRE_SUBASTADOR = "SUBASTADOR";
	

	// FLAGS ACTIVACION DE SERVICIOS
	public static final String ACTIVATE_MAIL_NOTIFYS = "MAIL_NOTIFYS";
	
}
