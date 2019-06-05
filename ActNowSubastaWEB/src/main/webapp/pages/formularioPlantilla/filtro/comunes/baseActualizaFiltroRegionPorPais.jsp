<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<div class="form-group">
	<label class="control-label col-sm-3" for="pais<s:property value='codigoDireccion' />">
		<s:text name="common.label.pais" />: 
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="pais%{codigoDireccion}" 
			name="pais.codigoPais"
			list="#request.paises" 
			headerKey="" 
			headerValue="Selecccione..."
			listKey="codigoPais" 
			listValue="nombre"
			value="pais.codigoPais" />
	</div>
</div>

<div id="cmbRegiones<s:property value='codigoDireccion' />" ></div>

<div id="cmbCiudades<s:property value='codigoDireccion' />" ></div>

<div id="cmbComunas<s:property value='codigoDireccion' />" ></div>

<!-- JAVASCRIPT -->

<script >
	$(function() {
		$("#pais<s:property value='codigoDireccion' />").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize(); //get all data from form
			var keyPais = document.getElementById("pais<s:property value='codigoDireccion' />").value;
			
			if(keyPais != ''){
				$.ajax({
					type : "POST",
					url : "getRegionesByPaisForUpdate.action",
					data : formData,
					success : function(response) {
						$("#cmbRegiones<s:property value='codigoDireccion' />").html(response);
						$("#cmbRegiones<s:property value='codigoDireccion' />").show();
					}
				});
			} else{
				$("#region<s:property value='codigoDireccion' />")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('Seleccione...')
				;
				$("#cmbRegiones<s:property value='codigoDireccion' />").hide();
				
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