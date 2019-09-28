<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<jsp:include page="../../../../estructura/header-content.jsp" />

<div class="panel panel-default">
	<div class="panel-body">

		<!--Inicio contenido dinámico-->
		<div class="container">
			<div class="row well">
				<div class="col-xs-12">
					<h2><s:text name="title.label.formulario.registro.solicitud" /></h2>
					<br>

					<div id="formulario_solicitud_subasta"> 
						<form action="addSolicitud" class="form-horizontal" id="addSolicitudForm" method="POST">
						
							<jsp:include page="../../../../pages/formularioPlantilla/filtro/servicio/baseFiltroServiciosByRubro.jsp" />
							<jsp:include page="../../../../pages/formularioPlantilla/filtro/comunes/baseSeleccionaFechaHorario.jsp" />
								
							<jsp:include page="../../../../pages/formularioPlantilla/registro/solicitud/baseRegistroSolicitud.jsp" />
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<br>
<br>

<jsp:include page="../../../../estructura/footer-content.jsp" />