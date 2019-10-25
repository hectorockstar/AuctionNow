<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<!-- Modal -->
<div class="modal fade" id="modalRegistrarDireccion" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><s:text name="title.label.formulario.registro.direccion" /></h4>
			</div>
			<div class="row">
				<div class="col-sm-12 left-col">
					<div class="modal-body">
						<div id="formulario_direccion">
							<form action="" class="form-horizontal" id="formulario_registro_direccion" method="POST">

								<jsp:include page="../../../../../pages/formularioPlantilla/registro/usuario/baseRegistroDireccion.jsp" />

							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<input id="btnRegistrarDireccion" type="button" class="btn btn-success" value='<s:text name="button.label.registrar.direccion" />' />
				<button type="button" id="cancelModalAddDireccion" class="btn btn-danger" data-dismiss="modal" >Cancelar</button>
				<input type="reset" id="resetModalAddDireccion" value="RESET" style="display: none;" />
			</div>
		</div>
	</div>
</div>

<script>
	$(function() {
		$("#btnRegistrarDireccion").click(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize();

			$.ajax({
				type : "POST",
				url : "addDireccionFromModal.action",
				data : formData,
				success : function(response) {
					$("#direccion")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>');

					$("#seleccioneDireccion")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione Direccion...</option>');
					
					var direcciones = JSON.parse(response);
					for(var i = 0 ;i < direcciones.length; i++){
                        $("#direccion").append($('<option>').text(direcciones[i].calle+' '+direcciones[i].numeracion+', '+direcciones[i].comuna.nombre+' - '+direcciones[i].comuna.ciudad.nombre).attr('value', direcciones[i].codigoDireccion));
                        $("#seleccioneDireccion").append($('<option>').text(direcciones[i].calle+' '+direcciones[i].numeracion+', '+direcciones[i].comuna.nombre+' - '+direcciones[i].comuna.ciudad.nombre).attr('value', direcciones[i].codigoDireccion));
                    }

					$("#resetModalAddDireccion").click();
					$("#cancelModalAddDireccion").click();
				}
			});
		});
	});

	$(function() {
		$("#resetModalAddDireccion").click(function() {
			$("#pais").val("").change();
		});

		$("#cancelModalAddDireccion").click(function() {
			$("#resetModalAddDireccion").click();
		});
	});
</script>