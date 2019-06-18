<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<div class="form-group">
	<label class="control-label col-sm-2" for="pais<s:property value='codigoDireccion' />">
		<s:text name="common.label.pais" />:
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="pais%{codigoDireccion}" 
			name="pais.codigoPais"
			list="#request.paises" 
			headerKey="" 
			headerValue="Selecccione..."
			listKey="codigoPais" 
			listValue="nombre"
			value="comuna.ciudad.region.pais.codigoPais" />
	</div>
	
	<label class="control-label col-sm-2" for="region<s:property value='codigoDireccion' />">
		<s:text name="common.label.region" />:
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="region%{codigoDireccion}" 
			name="region.codigoRegion"
			list="#request.regiones" 
			headerKey="" 
			headerValue="Selecccione..."
			listKey="codigoRegion" 
			listValue="nombre" />
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-2" for="ciudad<s:property value='codigoDireccion' />">
		<s:text name="common.label.ciudad" />: 
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="ciudad%{codigoDireccion}" 
			name="ciudad.codigoCiudad"
			list="#request.ciudades" 
			headerKey="" 
			headerValue="Selecccione..."
			listKey="codigoCiudad" 
			listValue="nombre" />
	</div>
	
	<label class="control-label col-sm-2" for="comuna<s:property value='codigoDireccion' />">
		<s:text name="common.label.comuna" />: 
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="comuna%{codigoDireccion}"
			name="direccion.comuna.codigoComuna" 
			list="#request.comunas"
			headerKey="" 
			headerValue="Selecccione..." 
			listKey="codigoComuna"
			listValue="nombre" />
	</div>
</div>

<!-- JAVASCRIPT -->
<script type="text/javascript" >
	$(function() {
		var flagRegion = 0;
		var flagCiudad = 0;
		var flagComuna = 0;
		
		$("#pais<s:property value='codigoDireccion' />").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize(); // get all data from
														// form
			var keyPais = document.getElementById("pais<s:property value='codigoDireccion' />").value;
			
			if(keyPais != ''){
				$.ajax({
					type : "POST",
					url : "getRegionesByPaisForUpdate.action",
					data : formData,
					success : function(response) {
						$("#region<s:property value='codigoDireccion' />")
					    .find('option')
					    .remove()
					    .end()
					    .append('<option value="">Seleccione...</option>');
						
						var regiones = JSON.parse(response);
						for(var i = 0 ;i < regiones.length; i++){
	                        $("#region<s:property value='codigoDireccion' />").append($('<option>').text(regiones[i].nombre).attr('value', regiones[i].codigoRegion));
	                    }

						if((flagRegion*flagCiudad*flagComuna)==0){
							$("#region<s:property value='codigoDireccion' />").val("<s:property value='comuna.ciudad.region.codigoRegion' />");
							flagRegion = 1;
						} else {
							$("#region<s:property value='codigoDireccion' />").focus();
						}
					}
				});
			} else {
				$("#region<s:property value='codigoDireccion' />")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('')
				;
				
				$("#ciudad<s:property value='codigoDireccion' />")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('')
				;
				
				$("#comuna<s:property value='codigoDireccion' />")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('')
				;
			}
		});
		
		$("#region<s:property value='codigoDireccion' />").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize(); // get all data from
														// form
			var keyRegion = document.getElementById("region<s:property value='codigoDireccion' />").value;
			
			if(keyRegion != ''){
	
				$("#comuna<s:property value='codigoDireccion' />")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('')
				;
				
				$.ajax({
					type : "POST",
					url : "getCiudadesByRegionForUpdate.action",
					data : formData,
					success : function(response) {
						$("#ciudad<s:property value='codigoDireccion' />")
					    .find('option')
					    .remove()
					    .end()
					    .append('<option value="">Seleccione...</option>');
						
						var ciudades = JSON.parse(response);
						for(var i = 0 ;i < ciudades.length; i++){
	                        $("#ciudad<s:property value='codigoDireccion' />").append($('<option>').text(ciudades[i].nombre).attr('value', ciudades[i].codigoCiudad));
	                    }

						if((flagRegion*flagCiudad*flagComuna)==0){
							$("#ciudad<s:property value='codigoDireccion' />").val("<s:property value='comuna.ciudad.codigoCiudad' />");
							flagCiudad = 1;
						} else {
							$("#ciudad<s:property value='codigoDireccion' />").focus();
						}
					}
				});
			} else {
				$("#ciudad<s:property value='codigoDireccion' />")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('')
				;
				
				$("#comuna<s:property value='codigoDireccion' />")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('')
				;
			}
		});
		
		$("#ciudad<s:property value='codigoDireccion' />").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize(); // get all data from
														// form
			var keyCiudad = document.getElementById("ciudad<s:property value='codigoDireccion' />").value;
			
			if(keyCiudad != ''){
				$.ajax({
					type : "POST",
					url : "getComunaByCiudadForUpdate.action",
					data : formData,
					success : function(response) {
						$("#comuna<s:property value='codigoDireccion' />")
					    .find('option')
					    .remove()
					    .end()
					    .append('<option value="">Seleccione...</option>');
					    
						var comunas = JSON.parse(response);
						for(var i = 0 ;i < comunas.length; i++){
	                        $("#comuna<s:property value='codigoDireccion' />").append($('<option>').text(comunas[i].nombre).attr('value', comunas[i].codigoComuna));
	                    }

						if((flagRegion*flagCiudad*flagComuna)==0){
							$("#comuna<s:property value='codigoDireccion' />").val("<s:property value='comuna.codigoComuna' />");
							flagComuna = 1;
						} else {
							$("#comuna<s:property value='codigoDireccion' />").focus();
						}
					}
				});
			} else {
				$("#comuna<s:property value='codigoDireccion' />")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('')
				;
			}
		});

		$("#comuna<s:property value='codigoDireccion' />").change(function() {
			var keyCiudad = document.getElementById("comuna<s:property value='codigoDireccion' />").value;
			
			if(keyCiudad != ''){
				$("#calle<s:property value='codigoDireccion' />").focus();
			} 
		});
	});

	$(function() {
		$("#pais<s:property value='codigoDireccion' />").val("<s:property value='comuna.ciudad.region.pais.codigoPais' />");
		$("#pais<s:property value='codigoDireccion' />").change();
		
		$("#region<s:property value='codigoDireccion' />").append($('<option>').text("<s:property value='comuna.ciudad.region.nombre' />").attr('value', "<s:property value='comuna.ciudad.region.codigoRegion' />"));
		$("#region<s:property value='codigoDireccion' />").val("<s:property value='comuna.ciudad.region.codigoRegion' />");
		$("#region<s:property value='codigoDireccion' />").change();
		
		$("#ciudad<s:property value='codigoDireccion' />").append($('<option>').text("<s:property value='comuna.ciudad.nombre' />").attr('value', "<s:property value='comuna.ciudad.codigoCiudad' />"));
		$("#ciudad<s:property value='codigoDireccion' />").val("<s:property value='comuna.ciudad.codigoCiudad' />");
		$("#ciudad<s:property value='codigoDireccion' />").change();
	});
</script>
