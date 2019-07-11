<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<jsp:include page="../../../../estructura/header-content.jsp" />

<div class="panel panel-default">
	<div class="panel-body">
		<!--Inicio contenido dinámico-->
		<div class="container">
			<div class="row well">
				<form class="form-horizontal" id="rubroEmpresaData" method="POST" action="">
					<div class="col-xs-12"> 
						<jsp:include page="../../../../pages/formularioPlantilla/informacion/usuario/baseInformacionEmpresa.jsp" />
					</div>
					<br>
					<div class="col-xs-12">
						<div class="form-group">
							<label class="control-label col-sm-2" for="rubro">
								<s:text name="control.label.seleccione.rubro" />: 
							</label>
							<div class="col-sm-4 campoValidado">
								<s:select class="form-control" id="rubro" 
									name="rubro.codigoRubro"
									list="#request.rubros" 
									headerKey="SELECCIONE0001" 
									headerValue="Selecccione..."
									listKey="codigoRubro" 
									listValue="nombre"
									/>
							</div>
						</div>
						
						<div id="resultadoServiciosbyRubro" ></div>
						
						<div class="form-group">
							<input id="btnAsignarRubro"
								type="button" class="btn btn-success"
								value='<s:text name="button.label.asignar.rubro" />' />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<jsp:include page="../../../../estructura/footer-content.jsp" />

<script type="text/javascript">
	$(function() {
		$("#rubro").change(function() {
			var formData = $("#rubroEmpresaData").serialize(); //get all data from form
			$.ajax({
				type : "POST",
				url : "getServiciosByRubro.action",
				data : formData,
				success : function(response) {
					$("#resultadoServiciosbyRubro").html(response);
					$("#resultadoServiciosbyRubro").show();
					
				}
			});
		});
	});

	$(function() {
		$("#btnAsignarRubro").click(function() {
			var formData = $("#rubroEmpresaData").serialize(); //get all data from form

			$.ajax({
				type : "POST",
				url : "asignaRubroServiciosEmpresa.action",
				data : formData,
				success : function(response) {
					
				}
			});
		});
	});
</script>
