<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<div class="form-group">
	<label class="control-label col-sm-2" for="pais">
		<s:text name="common.label.pais" />:
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="pais" 
			name="pais.codigoPais"
			list="#request.paises" 
			headerKey="" 
			headerValue="Seleccione..."
			listKey="codigoPais" 
			listValue="nombre" />
	</div>
	
	<label class="control-label col-sm-2" for="region">
		<s:text name="common.label.region" />:
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="region" 
			name="region.codigoRegion"
			list="#request.regiones" 
			headerKey="" 
			headerValue="Seleccione..."
			listKey="codigoRegion" 
			listValue="nombre" />
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-2" for="ciudad">
		<s:text name="common.label.ciudad" />: 
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="ciudad" 
			name="ciudad.codigoCiudad"
			list="#request.ciudades" 
			headerKey="" 
			headerValue="Seleccione..."
			listKey="codigoCiudad" 
			listValue="nombre" />
	</div>
	
	<label class="control-label col-sm-2" for="comuna">
		<s:text name="common.label.comuna" />: 
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="comuna"
			name="direccion.comuna.codigoComuna" 
			list="#request.comunas"
			headerKey="" 
			headerValue="Seleccione..." 
			listKey="codigoComuna"
			listValue="nombre" />
	</div>
</div>

<!-- JAVASCRIPT -->
<script type="text/javascript" >
	$(function() {
		$("#pais").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize(); // get all data from
														// form
			var keyPais = document.getElementById("pais").value;
			
			if(keyPais != ''){
				$.ajax({
					type : "POST",
					url : "getRegionesByPais.action",
					data : formData,
					success : function(response) {
						$("#region")
					    .find('option')
					    .remove()
					    .end()
					    .append('<option value="">Seleccione...</option>')
				    	.val('');
						
						var regiones = JSON.parse(response);
						for(var i = 0 ;i < regiones.length; i++){
	                        $("#region").append($('<option>').text(regiones[i].nombre).attr('value', regiones[i].codigoRegion));
	                    }

						$("#region").focus();
					}
				});
			} else {
				$("#region")
				    .find('option')
				    .remove()
				    .end()
			    	.append('<option value="">Seleccione...</option>')
				    .val('');
				
				$("#ciudad")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('');
				
				$("#comuna")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('');
			}
		});
		
		$("#region").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize(); // get all data from
														// form
			var keyRegion = document.getElementById("region").value;
			
			if(keyRegion != ''){
	
				$("#comuna")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('');
				
				$.ajax({
					type : "POST",
					url : "getCiudadesByRegion.action",
					data : formData,
					success : function(response) {
						$("#ciudad")
					    .find('option')
					    .remove()
					    .end()
					    .append('<option value="">Seleccione...</option>')
				    	.val('');
						
						var ciudades = JSON.parse(response);
						for(var i = 0 ;i < ciudades.length; i++){
	                        $("#ciudad").append($('<option>').text(ciudades[i].nombre).attr('value', ciudades[i].codigoCiudad));
	                    }

						$("#ciudad").focus();
					}
				});
			} else {
				$("#ciudad")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('');
				
				$("#comuna")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('');
			}
		});
		
		$("#ciudad").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize(); // get all data from
														// form
			var keyCiudad = document.getElementById("ciudad").value;
			
			if(keyCiudad != ''){
				$.ajax({
					type : "POST",
					url : "getComunaByCiudad.action",
					data : formData,
					success : function(response) {
						$("#comuna")
					    .find('option')
					    .remove()
					    .end()
					    .append('<option value="">Seleccione...</option>')
				    	.val('');
					    
						var comunas = JSON.parse(response);
						for(var i = 0 ;i < comunas.length; i++){
	                        $("#comuna").append($('<option>').text(comunas[i].nombre).attr('value', comunas[i].codigoComuna));
	                    }

						$("#comuna").focus();
					}
				});
			} else {
				$("#comuna")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('');
			}
		});

		$("#comuna").change(function() {
			var keyCiudad = document.getElementById("comuna").value;
			
			if(keyCiudad != ''){
				$("#calle").focus();
			} 
		});
	});

</script>