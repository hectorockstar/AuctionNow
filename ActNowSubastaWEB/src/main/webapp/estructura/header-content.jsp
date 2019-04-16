<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="header-libs.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>AuctionNow</title>
</head>
<body>

	<div class="jumbotron">
		<div class="container text-center">
			<h1>Bienvenido a AuctionNow</h1>
			<p>Encuentra el servicio que necesites. O publica tus servicios
				para que el mundo te conozca.</p>
		</div>
	</div>

	<c:if test="${errMsj == true}">
		<div class="alert alert-danger alert-dismissable">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
			<strong>Error</strong> Usuario y/o contraseña inválidos
		</div>
		<c:remove var="errMsj" scope="session" />
	</c:if>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">AuctionNow</a>
		</div>
		<div class="collapse navbar-collapse " id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="../index.jsp">Home</a></li>
				<li><a href="<s:url action="showRegistarUsuarioCliente"/>">Regístrese</a></li>
				<li><a href="ingresar.jsp">Ingrese</a></li>

				<li><a href="Desarrollo.jsp">DESARROLLO</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${usuarioWeb != null}">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"> <span
								class="glyphicon glyphicon-user"></span> <c:out
									value="${usuarioWeb.getNombreUsuario()}" /><span class="caret"></span></a>
							<ul class="nav dropdown-menu">
								<li><a href="../cargaMenuUsuario">Mi Perfil</a></li>
								<li><a href="<s:url action="logoutUser"/>">Salir</a></li>
							</ul>
						</li>
					</c:when>
					<c:otherwise>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="modal" data-target="#loginModal" href="#"><span
								class="glyphicon glyphicon-user"></span> Accede</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
	</nav>