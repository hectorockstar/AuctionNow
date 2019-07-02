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
					<div id="formulario_usuario_empresa">

						<form action="actualizaUsuarioWebEmpresa" class="form-horizontal" id="formulario_actualiza_datos_empresa" method="POST">
							<jsp:include page="../../../../pages/formularioPlantilla/actualiza/usuario/baseActualizaEmpresa.jsp" />
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