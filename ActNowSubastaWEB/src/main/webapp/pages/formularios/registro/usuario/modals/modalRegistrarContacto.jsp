<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<!-- Modal -->
<div class="modal fade" id="modalRegistrarContacto" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><s:text name="title.label.formulario.registro.contacto" /></h4>
			</div>
			<div class="row">
				<div class="col-sm-12 left-col">
					<div class="modal-body">
						<div id="formulario_contacto">
							<form action="" class="form-horizontal" id="formulario_registro_contacto" method="POST">

								<jsp:include page="../../../../../pages/formularioPlantilla/registro/usuario/baseRegistroContacto.jsp" />

							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<input id="btnRegistrarContacto" type="button" class="btn btn-success" value='<s:text name="button.label.registrar.contacto" />' />
				<button type="button" id="cancelModalAddContacto" class="btn btn-danger" data-dismiss="modal" >Cancelar</button>
				<input type="reset" id="resetModalAddContacto" value="RESET" style="display: none;" />
			</div>
		</div>
	</div>
</div>

<script>
	$(function() {
		$("#btnRegistrarContacto").click(function() {
			var formData = $('#formulario_registro_contacto').serialize();

			$.ajax({
				type : "POST",
				url : "addContactoFromModal.action",
				data : formData,
				success : function(response) {
					$("#contacto")
				    .find('option')
				    .remove()
				    .end()
				    .append('<option value="">Seleccione...</option>');
					
					var contactos = JSON.parse(response);
					for(var i = 0 ;i < contactos.length; i++){
                        $("#contacto").append($('<option>').text(contactos[i].tipoContacto.descripcion+' '+contactos[i].telefono1+', '+contactos[i].movil1+' - '+contactos[i].email).attr('value', contactos[i].codigoContacto));
                    }

					$("#resetModalAddContacto").click();
					$("#cancelModalAddContacto").click();
				}
			});
		});
	});

	$(function() {
		$("#resetModalAddContacto").click(function() {
			//$("#pais").val("").change();
		});

		$("#cancelModalAddContacto").click(function() {
			$("#resetModalAddContacto").click();
		});
	});
</script>