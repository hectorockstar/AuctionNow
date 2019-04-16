<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<div class="form-group">
	<label class="control-label col-sm-3" for="serviciosEmpresa"> 
		<s:text name="control.label.seleccione.servicio" />:
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="serviciosEmpresa"
			name="servicio.codigoServicio" list="#request.serviciosEmpresa" headerKey=""
			headerValue="Selecccione..." listKey="codigoServicio"
			listValue="nombre" />
	</div>
</div>

<script type="text/javascript">
	$(function() {
		$("#serviciosEmpresa").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#' + formName).serialize(); //get all data from form
			var keyServicio = document.getElementById("serviciosEmpresa").value;

			if (keyServicio != '') {
				$.ajax({
					type : "POST",
					url : "getCargosByServicio.action",
					data : formData,
					success : function(response) {
						$("#cmbCargosByServicio").html(
								response);
						$("#cmbCargosByServicio").show();
					}
				});
			} else {
				$('#cargosServicio')
						.find('option')
						.remove()
						.end()
						.append(
								'<option value="">Seleccione...</option>')
						.val('Seleccione...');
				$("#cmbCargosByServicio").hide();
			}
		});
	});
</script>