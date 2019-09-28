<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<h3>
	<s:text name="title.label.filtro.servicios.por.rubro" />
</h3>

<div id="getServiciosByRubroForm" class="form-group">
	<label class="control-label col-sm-3" for="rubro"> 
		<s:text name="control.label.seleccione.rubro" />:
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="rubro"
			name="servicio.rubro.codigoRubro" 
			list="#request.rubros" 
			headerKey=""
			headerValue="Seleccione..." 
			listKey="codigoRubro"
			listValue="nombre" />
	</div>
	
	<label class="control-label col-sm-2" for="serviciosActivosByRubro"> 
		<s:text name="control.label.seleccione.servicio" />:
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="serviciosActivosByRubro"
			name="servicio.codigoServicio" 
			list="#request.serviciosActivosByRubro" 
			headerKey=""
			headerValue="Seleccione..." 
			listKey="codigoServicio"
			listValue="nombre" />
	</div>
</div>
<br>
<br>


<script type="text/javascript">
$("#rubro").change(function() {
	var nameRubroField = document.getElementById('rubro').name;
	var keyRubro = document.getElementById('rubro').value;
	
    var formData = nameRubroField+'='+keyRubro;
	
	if(keyRubro != ''){

		$.ajax({
			type : "POST",
			url : "getServiciosActivosByRubro.action",
			data : formData,
			success : function(response) {
				$("#serviciosActivosByRubro")
			    .find('option')
			    .remove()
			    .end()
			    .append('<option value="">Seleccione...</option>');
				
				var servicios = JSON.parse(response);
				for(var i = 0 ;i < servicios.length; i++){
                    $("#serviciosActivosByRubro").append($('<option>').text(servicios[i].nombre).attr('value', servicios[i].codigoServicio));
                }

				$("#serviciosActivosByRubro").focus();
			}
		});
	} else {
		$("#serviciosActivosByRubro")
	    .find('option')
	    .remove()
	    .end()
	    .append('<option value="">Seleccione...</option>')
	    .val('')
		;
		
	}
});

</script>