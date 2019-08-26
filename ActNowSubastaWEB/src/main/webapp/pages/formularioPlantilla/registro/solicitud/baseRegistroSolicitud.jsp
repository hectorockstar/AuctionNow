<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<form action="addSolicitud" class="form-horizontal" id="formulario_registro_solicitud" method="POST">

	<br>
	<h3>
		<ins><s:text name="title.label.formulario.registro.solicitud" /></ins>
	</h3>
	<br>

	<jsp:include page="../../../../pages/formularioPlantilla/filtro/servicio/baseFiltroServicioPorCategoria1.jsp" />

	<div class="form-group">
		<label class="control-label col-sm-3" for="prioridad"> 
			<s:text name="control.label.seleccione.prioridad" />:
		</label>
		<div class="col-sm-4 campoValidado">
			<s:select class="form-control" 
				id="prioridad"
				name="solicitud.prioridad" 
				list="#request.prioridades" 
				headerKey=""
				headerValue="Seleccione..." 
				listKey="id" 
				listValue="descripcion" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="prioridad"> 
			<s:text name="common.label.direccion" />:
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
	</div>
	
	<div class="form-group date-container">
		<label class="control-label col-sm-3" for="fechaVencimientoSubasta">
			<s:text name="common.label.fecha.vencimiento.subasta" />: 
		</label>
		<div class="col-sm-4 campoValidado">
			<input type="text" class="form-control" id="fechaVencimientoSubasta"
				name="solicitud.fechaVencimiento" placeholder="dd/MM/yyyy">
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="rateYoEscoger">
			<s:text name="common.label.reputacion.desde" />: 
		</label>
		<div class="col-md-8 col-xs-12 campoValidado">
			<div id="rateYoEscoger"></div>
			<div class="counter" id="valoracionValue"></div>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="precioEsperado">
			<s:text name="common.label.precio.esperado.aprox" />: 
		</label>
		<div class="col-sm-9 campoValidado">
			<input type="text" class="form-control" id="precioEsperado"
				name="solicitud.precioEsperado" placeholder="Monto Esperado a Pagar ($)">
		</div>
	</div>
	
	<div class="form-group">		
		<label class="control-label col-md-4" for="estadoSolicitud">
			<s:text name="common.label.estado.solicitud" />: 
		</label><div class="col-md-offset-4">									
		<div class="checkbox col-md-12 col-xs-3">
			<label>
				<input type="checkbox" id="estadoSolicitud"
						name="solicitud.estadoSolicitud">
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
		<div class="col-sm-9 campoValidado">
			<textarea cols="9" rows="5" class="form-control" id="descRequerimiento"
				name="solicitud.descripcion"
				placeholder="Ingrese la descripcion de Requerimiento del Servicio"></textarea>
		</div>
	</div>
	
	<div class="form-group">		
		<label class="control-label col-sm-3" for="seleccioneDias">
			<s:text name="common.label.escoger.dias" />: 
		</label>
		<div class="col-md-offset-1" id="seleccioneDias" >	
			<div class="checkbox col-md-12 col-xs-3" >
				<label class="checkbox-inline">
			      	<input type="checkbox" name="solicitud.diasDisponible" value="L">
					<s:text name="common.label.lunes" />
			    </label>
			    <label class="checkbox-inline">
			      	<input type="checkbox" name="solicitud.diasDisponible" value="M">
					<s:text name="common.label.martes" />
			    </label>
			    <label class="checkbox-inline">
			      	<input type="checkbox" name="solicitud.diasDisponible" value="W">
					<s:text name="common.label.miercoles" />
			    </label>
			    <label class="checkbox-inline">
			      	<input type="checkbox" name="solicitud.diasDisponible" value="J">
					<s:text name="common.label.jueves" />
			    </label>
			    <label class="checkbox-inline">
			      	<input type="checkbox" name="solicitud.diasDisponible" value="V">
					<s:text name="common.label.viernes" />
			    </label>
			    <label class="checkbox-inline">
			      	<input type="checkbox" name="solicitud.diasDisponible" value="S">
					<s:text name="common.label.sabado" />
			    </label>
			    <label class="checkbox-inline">
			      	<input type="checkbox" name="solicitud.diasDisponible" value="D">
					<s:text name="common.label.domingo" />
			    </label>					
		    </div>	
		    <div class="muestra_error"></div>
		</div>	
	</div>
	
	<br>
	
	<div class="form-group">
		<input
			id="btnRegistrarSolicitud"
			type="button" 
			class="btn btn-success"
			value='<s:text name="button.label.registrar.solicitud" />' />
	</div>
	
	<s:hidden id="h_valoracion" name="solicitud.valoracion" />
</form>
<script>
	$(function() {
		$("#btnRegistrarSolicitud").click(function() {
			divValoracion = document.getElementById("valoracionValue");
			document.getElementById("h_valoracion").value = divValoracion.innerHTML;
			
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize();
			
			$.ajax({
	          type: "POST",
	          url: "addSolicitud.action",
	          data: formData,
	          success: function(response) {
							
				  }
		      });
		});   
	});
</script>
