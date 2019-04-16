<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<br>
<h3>
	<ins>
		<s:text name="title.label.filtro.cargo.servicio.empresa" />
	</ins>
</h3>

<br>
<div class="form-group">
	<label class="control-label col-sm-3" for="empresaProveedor"> <s:text
			name="control.label.seleccione.empresa" />:
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="empresaProveedor"
			name="empresa.codigoEmpresa" list="#request.empresas" headerKey=""
			headerValue="Selecccione..." listKey="codigoEmpresa"
			listValue="nombreEmpresa" />
	</div>
</div>

<div id="cmbServiciosByEmpresa"></div>

<div id="cmbCargosByServicio"></div>

<br>

<script type="text/javascript">
	$(function() {
		$("#empresaProveedor").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#' + formName).serialize(); //get all data from form
			var keyServicio = document.getElementById("empresaProveedor").value;

			if (keyServicio != '') {
				$.ajax({
					type : "POST",
					url : "getServiciosByEmpresa.action",
					data : formData,
					success : function(response) {
						$("#cmbServiciosByEmpresa").html(
								response);
						$("#cmbServiciosByEmpresa").show();
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
				
				$('#serviciosEmpresa')
						.find('option')
						.remove()
						.end()
						.append(
								'<option value="">Seleccione...</option>')
						.val('Seleccione...');
				$("#cmbServiciosByEmpresa").hide();
			}
		});
	});
</script>