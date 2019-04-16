<jsp:include page="../../../../estructura/header-content.jsp" />
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<div class="panel panel-default">
	<div class="panel-body">

		<!--Inicio contenido dinámico-->
		<div class="container">
			<div class="row well">
				<div class="col-xs-8">
					<h2><s:text name="title.label.formulario.registro.servicio"/></h2>
					<br>
					<div id="formulario_servicio">

						<br>
						<h3>
							<ins><s:text name="title.label.datos.servicio" /></ins>
						</h3>
						<br>

						<form action="addServicio" class="form-horizontal"
							id="formulario_registro_servicio" method="POST">

							<jsp:include page="../../../../pages/formularioPlantilla/registro/servicio/baseRegistroServicio.jsp" />

							<br>
							<div class="clearfix "></div>
							<div class="form-group">
								<div class="col-sm-offset-3">
									<button type="submit" class="btn btn-success">
										<s:text name="button.label.registrar.servicio"/>
									</button>
								</div>
							</div>
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