<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<br>
<h3>
	<ins>
		<s:text name="title.label.filtro.servicio.por.categoria" />
	</ins>
</h3>

<br>
<div class="form-group">
	<label class="control-label col-sm-3" for="tipoServicio"> 
		<s:text name="control.label.seleccione.tipo.servicio" />:
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="tipoServicio"
			name="filtroServicio.tipoServicio.id" list="#request.tipsServicios" headerKey=""
			headerValue="Selecccione..." listKey="id" listValue="descripcion" />
	</div>
</div>

<div id="cmbServiciosByCategoria"></div>

<br>


<script type="text/javascript">
	$(function() {
		$("#tipoServicio").change(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize(); //get all data from form
			var keyServicio = document.getElementById("tipoServicio").value;
			
			if(keyServicio != ''){
				$.ajax({
					type : "POST",
					url : "getServiciosByCategoria.action",
					data : formData,
					success : function(response) {
						$("#cmbServiciosByCategoria").html(response);
						$("#cmbServiciosByCategoria").show();
					}
				});
			} else{
				$('#servicio')
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>')
				    .val('Seleccione...')
				;
				$("#cmbServiciosByCategoria").hide();
			}
		});
	});
</script>