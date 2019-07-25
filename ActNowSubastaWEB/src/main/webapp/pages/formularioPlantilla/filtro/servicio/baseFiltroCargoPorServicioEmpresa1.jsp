<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<h3>
	<s:text name="title.label.filtro.cargo.servicio.empresa" />
</h3>

<div class="form-group">
	<label class="control-label col-sm-3" for="empresa"> <s:text
			name="control.label.seleccione.empresa" />:
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="empresa"
			name="empresa.codigoEmpresa" 
			list="#request.empresas" 
			headerKey=""
			headerValue="Selecccione..." 
			listKey="codigoEmpresa"
			listValue="nombreEmpresa" />
	</div>

	<label class="control-label col-sm-3" for="rubrosEmpresaubro"> 
		<s:text name="control.label.seleccione.rubro" />:
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="rubrosEmpresa"
			name="rubro.codigoRubro" 
			list="#request.rubrosEmpresa" 
			headerKey=""
			headerValue="Selecccione..." 
			listKey="codigoCargo"
			listValue="nombre" />
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="serviciosActivosEmpresa"> 
		<s:text name="control.label.seleccione.servicio" />:
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="serviciosActivosEmpresa"
			name="servicio.codigoServicio" 
			list="#request.serviciosActivosEmpresa" 
			headerKey=""
			headerValue="Selecccione..." 
			listKey="codigoServicio"
			listValue="nombre" />
	</div>

	<label class="control-label col-sm-3" for="cargosServicio"> 
		<s:text name="control.label.seleccione.cargo" />:
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="cargosServicio"
			name="cargo.codigoCargo" 
			list="#request.cargosServicio" 
			headerKey=""
			headerValue="Selecccione..." 
			listKey="codigoCargo"
			listValue="nombre" />
	</div>
</div>

<script type="text/javascript">
$("#empresa").change(function() {
	var formName = $(this).closest('form').attr('id');
	var formData = $('#'+formName).serialize(); // get all data from from
	var keyEmpresa = document.getElementById('empresa').value;
	
	if(keyEmpresa != ''){
		$.ajax({
			type : "POST",
			url : "/ActNowSubastaWEB/pages/Desarrollo.jsp",
			data : formData,
			success : function(response) {

				console.log(response);
				
				$("#rubrosEmpresa")
			    .find('option')
			    .remove()
			    .end()
			    .append('<option value="">Seleccione...</option>');
				
				var rubrosEmpresa = JSON.parse(response);
				for(var i = 0 ;i < regiones.length; i++){
                    $("#rubrosEmpresa").append($('<option>').text(rubrosEmpresa[i].nombre).attr('value', rubrosEmpresa[i].codigoRubro));
                }

				$("#rubrosEmpresa").focus();
			}
		});
	} else {
		$("#rubrosEmpresa")
		    .find('option')
		    .remove()
		    .end()
		    .append('<option value="">Seleccione...</option>')
		    .val('')
		;
		
		$("#serviciosActivosEmpresa")
		    .find('option')
		    .remove()
		    .end()
		    .append('<option value="">Seleccione...</option>')
		    .val('')
		;
		
		$("#cargosServicio")
		    .find('option')
		    .remove()
		    .end()
		    .append('<option value="">Seleccione...</option>')
		    .val('')
		;
	}
});

$("#rubrosEmpresa").change(function() {
	var formName = $(this).closest('form').attr('id');
	var formData = $('#'+formName).serialize(); // get all data from from
	var keyRubro = document.getElementById('rubrosEmpresa').value;
	
	if(keyRubro != ''){

		$("#cargosServicio")
		    .find('option')
		    .remove()
		    .end()
		    .append('<option value="">Seleccione...</option>')
		    .val('')
		;
		
		$.ajax({
			type : "POST",
			url : "getServiciosActivosByRubroEmpresa.action",
			data : formData,
			success : function(response) {
				$("#serviciosActivosEmpresa")
			    .find('option')
			    .remove()
			    .end()
			    .append('<option value="">Seleccione...</option>');
				
				var servicios = JSON.parse(response);
				for(var i = 0 ;i < ciudades.length; i++){
                    $("serviciosActivosEmpresa").append($('<option>').text(servicios[i].nombre).attr('value', servicios[i].codigoServicio));
                }

				$("#serviciosActivosEmpresa").focus();
			}
		});
	} else {
		$("#serviciosActivosEmpresa")
	    .find('option')
	    .remove()
	    .end()
	    .append('<option value="">Seleccione...</option>')
	    .val('')
		;
		
		$("#cargosServicio")
		    .find('option')
		    .remove()
		    .end()
		    .append('<option value="">Seleccione...</option>')
		    .val('')
		;
	}
});

$("#serviciosActivosEmpresa").change(function() {
	var formName = $(this).closest('form').attr('id');
	var formData = $('#'+formName).serialize(); // get all data from
	var keyServicio = document.getElementById("serviciosActivosEmpresa").value;
	
	if(keyServicio != ''){
		$.ajax({
			type : "POST",
			url : "getCargosByServicio.action",
			data : formData,
			success : function(response) {
				$("#cargosServicio")
			    .find('option')
			    .remove()
			    .end()
			    .append('<option value="">Seleccione...</option>');
			    
				var comunas = JSON.parse(response);
				for(var i = 0 ;i < comunas.length; i++){
                    $("#cargosServicio").append($('<option>').text(comunas[i].nombre).attr('value', comunas[i].codigoComuna));
                }

				$("#cargosServicio").focus();
			}
		});
	} else {
		$("#cargosServicio")
		    .find('option')
		    .remove()
		    .end()
		    .append('<option value="">Seleccione...</option>')
		    .val('')
		;
	}
});
</script>