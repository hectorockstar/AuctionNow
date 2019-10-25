<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

	<h3>
		<s:text name="title.label.formulario.registro.solicitud" />
	</h3>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="direccion"> 
			<s:text name="control.label.seleccione.direccion" />:
		</label>
		<div class="col-sm-4 campoValidado">
			<s:select class="form-control" 
				id="direccion"
				name="direccion.codigoDireccion" 
				list="#request.direcciones" 
				headerKey=""
				headerValue="Seleccione..." 
				listKey="codigoDireccion" 
				listValue="calle+' '+numeracion+', '+comuna.nombre+' - '+comuna.ciudad.nombre" />
		</div>
		<a data-toggle="modal" data-target="#modalRegistrarDireccion" href="#">Agregar Nueva Direccion</a>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="contacto"> 
			<s:text name="control.label.seleccione.contacto" />:
		</label>
		<div class="col-sm-4 campoValidado">
			<s:select class="form-control" 
				id="contacto"
				name="contacto.codigoContacto" 
				list="#request.contactos" 
				headerKey=""
				headerValue="Seleccione..." 
				listKey="codigoContacto" 
				listValue="tipoContacto.descripcion+' '+telefono1+', '+movil1+' - '+email" />
		</div>
		<a data-toggle="modal" data-target="#modalRegistrarContacto" href="#">Agregar Nuevo Contacto</a>
	</div>
	
	<div class="form-group date-container">
		<label class="control-label col-sm-3" for="fechaVencimientoSubasta">
			<s:text name="common.label.fecha.vencimiento.subasta" />: 
		</label>
		<div class="col-sm-3 campoValidado">
			<input type="text" class="form-control" id="fechaVencimientoSubasta"
				name="solicitud.fechaVencimientoSubasta" placeholder="Fecha Vencimiento Subasta">
		</div>
		
		<label class="control-label col-sm-2" for="horaVencimientoSubasta">
			, <s:text name="common.label.hora.termino" />: 
		</label>
		<div class="col-sm-3 input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true">
		    <input id="horaVencimientoSubasta" name="solicitud.horaVencimientoSubasta" type="text" class="form-control" value="22:00">
		    <span class="input-group-addon">
		        <span class="glyphicon glyphicon-time"></span>
		    </span>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="precioEsperado">
			<s:text name="common.label.precio.esperado.aprox" />: 
		</label>
		<div class="col-sm-4 campoValidado">
			<input type="text" class="form-control" id="precioEsperado"
				name="solicitud.precioEsperado" placeholder="Monto Esperado a Pagar ($)">
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="rateYoEscoger">
			<s:text name="common.label.reputacion.desde" />: 
		</label>
		<div class="col-md-3 col-xs-3 campoValidado">
			<div id="rateYo"></div>
			<div class="counter" id="valoracionValue"></div>
		</div>
	</div>
	
	<div class="form-group">		
		<label class="control-label col-md-3" for="estadoSolicitud">
			<s:text name="common.label.estado.solicitud" />: 
		</label>
		<div class="col-md-offset-3">									
			<div class="checkbox col-sm-4">
				<label>
					<s:checkbox id="estadoSolicitud" name="" value="false"  />
					<s:hidden id="h_estadoSolicitud" value="NA" name="solicitud.activo" />
					<s:text name="common.label.activa" />
				</label>						    				
			</div>	
		    <div class="muestra_error"></div>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="descRequerimiento">
			<s:text name="common.label.requerimiento.descripcion" />: 
		</label>
		<div class="col-sm-8 campoValidado">
			<textarea cols="9" rows="5" class="form-control" id="descRequerimiento"
				name="solicitud.descripcion"
				placeholder="Ingrese la descripcion de Requerimiento del Servicio"></textarea>
		</div>
	</div>
	
	<div class="form-group">
		<input
			id="btnRegistrarSolicitud"
			type="button" 
			class="btn btn-success"
			value='<s:text name="button.label.registrar.solicitud" />' />
	</div>
	
	
	<jsp:include page="../../../../pages/formularios/registro/usuario/modals/modalRegistrarDireccion.jsp" />
	<jsp:include page="../../../../pages/formularios/registro/usuario/modals/modalRegistrarContacto.jsp" />

<script>
	$(function() {
		$("#btnRegistrarSolicitud").click(function() {
			var formName = $(this).closest('form').attr('id');
			var normalFill = $("#rateYo").rateYo("option", "rating");

			var newInput = document.createElement("input");
			newInput.setAttribute("type", "hidden");
			newInput.setAttribute("id", "valoracion");
			newInput.setAttribute("name", "solicitud.valoracion");
			newInput.setAttribute("value", String(normalFill).replace('.', ','));
			$("#" + formName).append(newInput);

			var formData = $('#' + formName).serialize();

			$.ajax({
				type : "POST",
				url : "addSolicitud.action",
				data : formData,
				success : function(response) {

				}
			});
		});
	});

	$(function() {
		$("#estadoSolicitud").click(function() {
			var chkValue = $("#estadoSolicitud").prop('checked') ? "A" : "NA";
			$("#h_estadoSolicitud").val(chkValue);
		});
	});
</script>
