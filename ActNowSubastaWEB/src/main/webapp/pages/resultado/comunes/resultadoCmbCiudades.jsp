<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<div class="form-group">
	<label class="control-label col-sm-3" for="ciudad">
		<s:text name="common.label.ciudad" />: 
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="ciudad" 
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
		$("#ciudad").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize(); //get all data from form
			var keyCiudad = document.getElementById("ciudad").value;
			
			if(keyCiudad != ''){
				$.ajax({
					type : "POST",
					url : "getComunaByCiudad.action",
					data : formData,
					success : function(response) {
						$("#cmbComunas").html(response);
						$("#cmbComunas").show();
					}
				});
			} else{
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