<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<jsp:include page="../../../../estructura/header-content.jsp" />

<div class="panel panel-default">
	<div class="panel-body">
		<!--Inicio contenido dinámico-->
		<div class="container">
			<div class="row well">
				
					<div class="form-horizontal" id="formulario_asigna_rubro"> 
					
						<div class="col-xs-12"> 
							<jsp:include page="../../../../pages/formularioPlantilla/informacion/usuario/baseInformacionEmpresa.jsp" />
						</div>
						
						<br>
						
						<form  id="rubroEmpresaData" method="POST" action="">
							<div class="col-xs-12">
								<div class="form-group">
									<label class="col-sm-2" for="rubro">
										<s:text name="control.label.seleccione.rubro" />: 
									</label>
									<div class="col-sm-3 campoValidado">
										<s:select class="form-control" id="rubro" 
											name="rubro.codigoRubro"
											list="#request.rubros" 
											headerKey="SELECCIONE000000001" 
											headerValue="Seleccione..."
											listKey="codigoRubro" 
											listValue="nombre"
											/>
									</div>
									<label class="col-sm-2" for="fechaEjerceDesde">
										<s:text name="common.label.fecha.ejerce.desde" />: 
									</label>
									<div class="col-sm-3 campoValidado">
										<input type="text" class="form-control" id="fechaEjerceDesde" 
											name="rubro.fechaEjerceDesde" autocomplete="off" placeholder="Fecha desde que ejerce Rubro" />
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2" for="descripcionEjerce">
										<s:text name="common.label.descripcion.experiencia.rubro" />: 
									</label>
									<div class="col-sm-8">
										<textarea cols="8" rows="5" class="form-control" id="descripcionEjerce"
											name="rubro.descripcionEjerce"
											placeholder="Ingrese una descripcion breve de su experiencia en el rubro seleccionado..."></textarea>
									</div>
								</div>
								
								<div class="form-group">
									<div id="resultadoServiciosbyRubro" ></div>
								</div>
								
							</div>
						</form>
					</div>
				
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
</script>
