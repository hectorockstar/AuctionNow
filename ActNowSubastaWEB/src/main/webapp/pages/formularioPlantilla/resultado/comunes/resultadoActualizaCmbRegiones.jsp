<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<div class="form-group">
	<label class="control-label col-sm-3" for="region<s:property value='codigoDireccion' />">
		<s:text name="common.label.region" />:
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="region%{codigoDireccion}" 
			name="region.codigoRegion"
			list="#request.regiones" 
			headerKey="" 
			headerValue="Selecccione..."
			listKey="codigoRegion" 
			listValue="nombre" />
	</div>
</div>

<script type="text/javascript">
	$(function() {
		$("#region<s:property value='codigoDireccion' />").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize(); //get all data from form
			var keyRegion = document.getElementById("region<s:property value='codigoDireccion' />").value;
			
			if(keyRegion != ''){

				$('#comuna<s:property value='codigoDireccion' />')
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('Seleccione...')
				;
				$("#cmbComunas<s:property value='codigoDireccion' />").hide();
				
				$.ajax({
					type : "POST",
					url : "getCiudadesByRegionForUpdate.action",
					data : formData,
					success : function(response) {
						$("#cmbCiudades<s:property value='codigoDireccion' />").html(response);
						$("#cmbCiudades<s:property value='codigoDireccion' />").show();
					}
				});
			} else{
				$("#ciudad<s:property value='codigoDireccion' />")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('Seleccione...')
				;
				$("#cmbCiudades<s:property value='codigoDireccion' />").hide();
				
				$("#comuna<s:property value='codigoDireccion' />")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('Seleccione...')
				;
				$("#cmbComunas<s:property value='codigoDireccion' />").hide();
			}
		});
	});
</script>