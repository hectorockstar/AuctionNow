<jsp:include page="../../../../estructura/header-content.jsp" />
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<div class="panel panel-default">
	<div class="panel-body">

		<!--Inicio contenido dinámico-->
		<div class="container">
			<div class="row well">
				<div class="col-xs-8">
					<h2><s:text name="title.label.servicios.por.empresa" />:</h2>
					<br>
					<div id="formulario_asignar_servicio">

						<form class="form-horizontal" id="empresaData" method="POST"
							action="">
							<div class="form-group">
								<label class="control-label col-sm-3" for="empresas"> 
									<s:text name="control.label.lista.empresas" />:
								</label>
								<div class="col-sm-4 campoValidado">
									<s:select class="form-control" id="empresas"
										name="filtroServicio.codigoEmpresa" list="#request.empresas"
										headerKey="" headerValue='Seleccione...' listKey="codigoEmpresa"
										listValue="nombreEmpresa" />
								</div>
							</div>

							<s:if test="hasActionMessages()">
								<div class="welcome">
									<s:actionmessage />
								</div>
							</s:if>

							<div class="form-group">
								<div class="col-sm-offset-3">
									<input id="btnMostrarServicios" type="button"
										class="btn btn-success" value="Ir a Asignar Servicio" /> <input
										id="btnBuscarServicios" type="button" class="btn btn-success"
										value="Ir a Actualizar Servicios Asociados" />
								</div>
							</div>

							<br>
						</form>
					</div>
					<div id="cmbServiciosDisponibles"></div>

					<div id="resultadoServicioEmpresa"></div>

				</div>
			</div>
		</div>
	</div>
</div>
<br>
<br>

<jsp:include page="../../../../estructura/footer-content.jsp" />

<script type="text/javascript">
	$(function() {
		$("#btnBuscarServicios").click(function() {
			var formData = $("#empresaData").serialize(); //get all data from form
			$.ajax({
				type : "POST",
				url : "showServiciosEmpresa.action",
				data : formData,
				success : function(response) {
					$("#resultadoServicioEmpresa").html(response);
					$("#resultadoServicioEmpresa").show();
					$("#cmbServiciosDisponibles").hide();
				}
			});
		});
	});
</script>

<script type="text/javascript">
	$(function() {
		$("#btnMostrarServicios").click(function() {
			var formData = $("#empresaData").serialize(); //get all data from form
			$.ajax({
				type : "POST",
				url : "showServicios.action",
				data : formData,
				success : function(response) {
					$("#cmbServiciosDisponibles").html(response);
					$("#cmbServiciosDisponibles").show();
					$("#resultadoServicioEmpresa").hide();
				}
			});
		});
	});
</script>
