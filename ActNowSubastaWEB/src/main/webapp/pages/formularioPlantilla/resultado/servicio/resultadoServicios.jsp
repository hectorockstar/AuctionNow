<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<form id="serviceData" action="">

	<s:hidden value="%{#request.codigoEmpresa}"
		name="empresa.codigoEmpresa" id="h_codigoEmpresa"></s:hidden>

	<div class="row">
		<label class="col-sm-3" for="servicios"> <s:text
				name="common.label.servicios" />:
		</label>
		<div class="col-sm-9 campoValidado">
			<s:select class="form-control" id="servicios"
				name="servicio.codigoServicio" list="#request.servicios"
				headerKey="" headerValue="Selecccione..." listKey="codigoServicio"
				listValue="nombre" />
		</div>
	</div>

	<div class="row date-container">
		<label class="col-sm-3" for="tf_fechaOpera"> <s:text
				name="common.label.fecha" /> <s:text
				name="common.label.opera.servicio" />, <s:text
				name="common.label.desde" />:
		</label>
		<div class="col-sm-9 campoValidado">
			<input type="text" class="form-control" id="tf_fechaOpera"
				name="servicio.operaServicioDesde"
				value="<s:property value="operaServicioDesde" />">
		</div>
	</div>

	<div class="row">
		<label class="col-sm-3" for="prioridad"> 
			<s:text name="common.label.prioridad" />:
		</label>
		<div class="col-sm-9 campoValidado">
			<input type="text" class="form-control" name="servicio.prioridad"
				id="prioridad" maxlength="1">
		</div>
	</div>

	<div class="row">
		<label class="col-sm-3" for="vigente"> 
			<s:text name="common.label.vigente" />:
		</label>
		<div class="col-sm-9 campoValidado">
			<input type="text" class="form-control" name="servicio.activo"
				id="vigente" maxlength="1">
		</div>
	</div>

	<div class="row">
		<input id="sendService" type="button" class="btn btn-success"
			value='<s:text name="button.label.asignar.servicio" />' />
	</div>

</form>

<script type="text/javascript">
	$(function() {
		$("#sendService").click(function() {
			var formData = $("#serviceData").serialize(); //get all data from form
			$.ajax({
				type : "POST",
				url : "addServicioEmpresa.action",
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
