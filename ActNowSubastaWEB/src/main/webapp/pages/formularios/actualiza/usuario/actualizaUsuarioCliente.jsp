<jsp:include page="../../../../estructura/header-content.jsp" />
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<div class="panel panel-default">
	<div class="panel-body">
		<!--Inicio contenido dinámico-->
		<div class="container"> 
			<div class="row well">
				<div class="col-xs-8">
					<h2><s:text name="title.label.formulario.actualiza.cliente" /></h2>
					<br>
					<div id="formulario_usuario">

						<form action="actualizaUsuarioWebCliente" class="form-horizontal" id="formulario_actualiza_datos_usuario" method="POST">
							<jsp:include page="../../../../pages/formularioPlantilla/actualiza/usuario/baseActualizaInfoPersonalCliente.jsp" />
							<jsp:include page="../../../../pages/formularioPlantilla/actualiza/usuario/baseActualizaInfoUsuarioWeb.jsp" />
							
							<br>
							<div class="clearfix "></div>
							<div class="form-group">
								<div class="col-sm-offset-3">
									<button type="submit" class="btn btn-success">
										<s:text name="button.label.actualizar" />
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