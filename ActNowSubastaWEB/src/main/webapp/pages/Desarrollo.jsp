<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<jsp:include page="../estructura/header-content.jsp" />

<div class="panel panel-default">
	<div class="panel-body">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Desarrollos</title>
</head>
<body>


<ul>
<!-- Usuario Cliente -->
<li><a href="<s:url action="showRegistarUsuarioCliente"/>">Registrar Cliente</a></li>
<li><a href="<s:url action="showActualizaUsuarioCliente"/>">Actualizar Cliente</a> (Iniciar Sesion Antes)</li>

<!-- Usuario Proveedor -->
<li><a href="<s:url action="showRegistrarUsuarioProveedor"/>">Registra Proveedor</a></li>
<li><li><a href="<s:url action="showActualizaUsuarioProveedor"/>">Actualiza Proveedor</a> (Iniciar Sesion Antes)</li>

<!-- Direccion -->
<a href="<s:url action="showAddDireccion"/>">Registra Direccion</a> (Iniciar Sesion Antes)</li>
<li><a href="<s:url action="showActualizaDireccion"/>">Actualiza Direccion</a> (Iniciar Sesion Antes)</li>
<li>
<!-- Contacto -->
<a href="<s:url action="showAddContacto"/>">Registra Contacto</a> (Iniciar Sesion Antes)</li>
<li><a href="<s:url action="showActualizaContacto"/>">Actualiza Contacto</a> (Iniciar Sesion Antes)</li>

<!-- Empresa -->
<li><a href="<s:url action="showAddEmpresa"/>">Registra Empresa</a></li>
<li><a href="<s:url action="showActualizaEmpresa"/>">Actualiza Empresa</a></li>

<!-- Servicio Empresa -->
<li><a href="<s:url action="showAddServicioEmpresa"/>">Registra Servicio a Empresa</a></li>
<li><a href="<s:url action="showServiciosEmpresa"/>">Ver Detalle Servicios de Empresa</a></li>
<li><a href="<s:url action="showActualizaServicioEmpresa"/>">Actualiza Servicio a Empresa</a></li>

<!-- Solicitudes -->
<li><a href="<s:url action="showAddSolicitud"/>">Agregar Solicitud</a></li>
<li><a href="<s:url action="showDetalleSolicitud"/>">Ver Detalle Solicitud</a></li>
<li><a href="<s:url action="showActualizaSolicitudes"/>">Actualiza Solicitud</a></li>
<li><a href="<s:url action="showDetalleActualizaSolicitud"/>">Ver Detalle Actualizar Solicitud</a></li>

<!-- Subasta -->
<li><a href="<s:url action="showDetalleSubasta"/>">Ver Detalle Subasta</a></li>
<li><a href="<s:url action="showOfertasSubasta"/>">Ver Ofertas</a></li>

<!-- Servicio -->
<li><a href="<s:url action="showRegistrarServicio"/>">Registrar Servicio</a></li>
<li><a href="<s:url action="showActualizaServicio"/>">Actualiza Servicio</a></li>

<!-- Transaccion -->
<li><a href="<s:url action="showTransaccionesCliente"/>">Ver Transacciones del Cliente</a></li>
<li><a href="<s:url action="showDetalleTransaccion"/>">Ver Detalle Transaccion</a></li>
</ul>

</body>
</html>