<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<div class="form-group">
	<label class="control-label col-sm-3" for="region">
		<s:text name="common.label.region" />:
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="region" 
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
		$("#region").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize(); //get all data from form
			var keyRegion = document.getElementById("region").value;
			
			if(keyRegion != ''){
				$.ajax({
					type : "POST",
					url : "getCiudadesByRegion.action",
					data : formData,
					success : function(response) {
						$("#cmbCiudades").html(response);
						$("#cmbCiudades").show();
					}
				});
			} else{
				$('#ciudad')
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('Seleccione...')
				;
				$("#cmbCiudades").hide();	
				
				$('#comuna')
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('Seleccione...')
				;
				$("#cmbComunas").hide();
			}
		});
	});
</script>