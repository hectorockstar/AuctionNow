<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<div class="form-group">
	<label class="control-label col-sm-3" for="ciudad<s:property value='codigoDireccion' />">
		<s:text name="common.label.ciudad" />: 
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="ciudad<s:property value='codigoDireccion' />" 
			name="ciudad.codigoCiudad"
			list="#request.ciudades" 
			headerKey="" 
			headerValue="Selecccione..."
			listKey="codigoCiudad" 
			listValue="nombre" />
	</div>
</div>

<script type="text/javascript">
	$(function() {
		$("#ciudad<s:property value='codigoDireccion' />").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize(); //get all data from form
			var keyCiudad = document.getElementById("ciudad<s:property value='codigoDireccion' />").value;
			
			if(keyCiudad != ''){
				$.ajax({
					type : "POST",
					url : "getComunaByCiudadForUpdate.action",
					data : formData,
					success : function(response) {
						$("#cmbComunasActualiza").html(response);
						$("#cmbComunasActualiza").show();
					}
				});
			} else{
				$('#comuna<s:property value='codigoDireccion' />')
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('Seleccione...')
				;
				$("#cmbComunasActualiza").hide();	
			}
		});
	});
</script>