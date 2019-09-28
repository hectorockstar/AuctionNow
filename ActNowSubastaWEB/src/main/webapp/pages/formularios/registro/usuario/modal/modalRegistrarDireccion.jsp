<%@include file="../../../../../estructura/header-libs.jsp"%>

  <!-- Modal -->
  <div class="modal fade" id="modalRegistrarDireccion" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Ingrese a nuestra plataforma</h4>
        </div>
	        <div class="row">
				<div class="col-xs-12">
					<h2><s:text name="title.label.formulario.registro.direccion" /></h2>
					<br>

					<div id="formulario_direccion">
						<form action="addDireccion" class="form-horizontal" id="formulario_registro_direccion" method="POST">

							<jsp:include page="../../../../../pages/formularioPlantilla/registro/usuario/baseRegistroDireccion.jsp" />

							<br>
							<div class="clearfix "></div>
							<div class="form-group">
								<div class="col-sm-offset-3">
									<button type="submit" class="btn btn-success">
										<s:text name="button.label.registrar.direccion" />
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
	        </div>        
	        <div class="modal-footer">
								          	     
	        </div>
      </div>
      
    </div>
  </div>