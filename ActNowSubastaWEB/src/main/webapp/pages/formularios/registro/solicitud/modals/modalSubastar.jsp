<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<!-- Modal -->
<div class="modal fade" id="modalSubastar" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><s:text name="title.label.establecer.subasta" /></h4>
			</div>
			<div class="row">
				<div class="col-sm-12 left-col">
					<div class="modal-body">
						<div id="formulario_contacto">
							<form action="" class="form-horizontal" id="formulario_ofertar_subasta" method="POST">


							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<input id="btnSubastar" type="button" class="btn btn-success" value='<s:text name="button.label.subastar" />' />
				<button type="button" id="cancelModalSubastar" class="btn btn-danger" data-dismiss="modal" >Cancelar</button>
				<input type="reset" id="resetModalSubastar" value="RESET" style="display: none;" />
			</div>
		</div>
	</div>
</div>

<script>
	$(function() {
		$("#btnSubastar").click(function() {
			var formData = $('#formulario_ofertar_subasta').serialize();

			$.ajax({
				type : "POST",
				url : "addOfertaSubastaFromModal.action",
				data : formData,
				success : function(response) {

					$("#resetModalSubastar").click();
					$("#cancelModalSubastar").click();
				}
			});
		});
	});

	$(function() {
		$("#resetModalSubastar").click(function() {

		});

		$("#cancelModalSubastar").click(function() {
			$("#resetModalSubastar").click();
		});
	});
</script>