<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<div class="form-group">
	<label class="control-label col-sm-3" for="pais">
		<s:text name="common.label.pais" />: 
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="pais" 
			name="pais.codigoPais"
			list="#request.paises" 
			headerKey="" 
			headerValue="Selecccione..."
			listKey="codigoPais" 
			listValue="nombre" />
	</div>
</div>

<div id="cmbRegiones" ></div>

<div id="cmbCiudades" ></div>

<div id="cmbComunas" ></div>

<!-- JAVASCRIPT -->

<script type="text/javascript">
	$(function() {
		$("#pais").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize(); //get all data from form
			var keyPais = document.getElementById("pais").value;
			
			if(keyPais != ''){
				$.ajax({
					type : "POST",
					url : "getRegionesByPais.action",
					data : formData,
					success : function(response) {
						$("#cmbRegiones").html(response);
						$("#cmbRegiones").show();
					}
				});
			} else{
				$('#region')
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('Seleccione...')
				;
				$("#cmbRegiones").hide();
				
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