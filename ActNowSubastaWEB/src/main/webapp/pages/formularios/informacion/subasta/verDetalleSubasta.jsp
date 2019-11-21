<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<jsp:include page="../../../../estructura/header-content.jsp" />

<div class="panel panel-default">
	<div class="panel-body">

		<!--Inicio contenido dinámico-->
		<div class="container">
			<div class="row well">
				<div class="col-xs-12">
					<h2><s:text name="title.label.formulario.detalle.subasta" /></h2>
					<br>

					<div id="formulario_detalle_subasta"> 
						<jsp:include page="../../../../pages/formularioPlantilla/informacion/usuario/baseInformacionCliente.jsp" />
						<jsp:include page="../../../../pages/formularioPlantilla/informacion/solicitud/baseInformacionSolicitud.jsp" />
						<jsp:include page="../../../../pages/formularioPlantilla/informacion/solicitud/baseInformacionSubasta.jsp" />
						
						<div class="countdown"></div>
						<s:hidden id="h_dateAuctionCountdown" value="%{#request.countdownDate}" />
						
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<br>
<br>

<jsp:include page="../../../../estructura/footer-content.jsp" />