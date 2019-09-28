<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<h3>
	<s:text name="title.label.establecer.tipo.fecha" />
</h3>

<div class="form-group">
	<label class="control-label col-sm-3" for="tipoFecha"> 
		<s:text name="control.label.seleccione.tipo.fecha" />:
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="tipoFecha"
			name="solicitud.tipoFecha.id" 
			list="#request.tipoFechas"
			headerKey=""
			headerValue="Seleccione..." 
			listKey="id"
			listValue="descripcion" />
	</div>
</div>

<div id="panelRangoFechas"  >

	<div class="form-group date-container" >
		<label class="control-label col-sm-3" for="fechaServicioDesde">
			<s:text name="control.label.fecha.servicio.desde" />: 
		</label>
		<div class="col-sm-3 campoValidado">
			<input type="text" class="form-control" id="fechaServicioDesde" autocomplete="off"
				name="solicitud.fechaServicioDesde" placeholder="Fecha Servicio Desde">
		</div>
		
		<label class="control-label col-sm-1" for="fechaServicioHasta">
			, <s:text name="common.label.hasta" />: 
		</label>
		<div class="col-sm-3 campoValidado">
			<input type="text" class="form-control" id="fechaServicioHasta" autocomplete="off"
				name="solicitud.fechaServicioHasta" placeholder="Fecha Servicio Hasta">
		</div>
	</div>
	
	<div class="form-group clockpicker-container" >
		<label class="control-label col-sm-3" for="horaServicioDesde">
			<s:text name="control.label.hora.servicio.desde" />: 
		</label>
		<div class="col-sm-2 input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true">
		    <input id="horaServicioDesde" name="solicitud.horarioDesde" type="text" class="form-control" value="08:00">
		    <span class="input-group-addon">
		        <span class="glyphicon glyphicon-time"></span>
		    </span>
		</div>
		
		<label class="control-label col-sm-1" for="horaServicioHasta">
			, <s:text name="common.label.hasta" />: 
		</label>
		<div class="col-sm-2 input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true">
		    <input id="horaServicioHasta" name="solicitud.horarioHasta" type="text" class="form-control" value="18:00">
		    <span class="input-group-addon">
		        <span class="glyphicon glyphicon-time"></span>
		    </span>
		</div>
	</div>
	
</div>

<div id="panelFechaEspecifica" >
	<div class="form-group date-container" >
		<label class="control-label col-sm-3" for="fechaEntregaServicio">
			<s:text name="control.label.fecha.entrega.servicio" />: 
		</label>
		<div class="col-sm-3 campoValidado">
			<input type="text" class="form-control" id="fechaEntregaServicio" autocomplete="off"
				name="solicitud.fechaEntregaServicio" placeholder="Fecha Entrega del Servicio">
		</div>
	</div>
	
	<div class="form-group clockpicker-container" >
		<label class="control-label col-sm-3" for="horaServicioDesde">
			<s:text name="control.label.hora.servicio.desde" />: 
		</label>
		<div class="col-sm-2 input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true">
		    <input id="horaServicioDesde" type="text" class="form-control" value="08:00">
		    <span class="input-group-addon">
		        <span class="glyphicon glyphicon-time"></span>
		    </span>
		</div>
		
		<label class="control-label col-sm-1" for="horaServicioHasta">
			, <s:text name="common.label.hasta" />: 
		</label>
		<div class="col-sm-2 input-group clockpicker" data-placement="left" data-align="top" data-autoclose="true">
		    <input id="horaServicioHasta" type="text" class="form-control" value="18:00">
		    <span class="input-group-addon">
		        <span class="glyphicon glyphicon-time"></span>
		    </span>
		</div>
	</div>
</div>
<br>
<br>

<script type="text/javascript">

	$("#panelRangoFechas").hide();
	$("#panelFechaEspecifica").hide();
	
	$("#tipoFecha").change(function() {
		let tipoFechaValue = $("#tipoFecha").val();

		if (tipoFechaValue == 'RAN') {
			$("#panelRangoFechas").show();
			$("#panelFechaEspecifica").hide();
		} else if (tipoFechaValue == 'ESP') {
			$("#panelRangoFechas").hide();
			$("#panelFechaEspecifica").show();
		} else {
			$("#panelRangoFechas").hide();
			$("#panelFechaEspecifica").hide();
		}
	});
</script>