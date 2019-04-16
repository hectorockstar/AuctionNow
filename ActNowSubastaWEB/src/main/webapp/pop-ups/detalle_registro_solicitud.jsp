<jsp:include page="/estructura/header-libs.jsp" />

  	  <!--Inicio contenido dinámico-->
  	  <div class="container">
  	  	<div class="panel panel-primary">
	        <div class="panel-heading">DETALLE DE LA SOLICITUD</div>
	        <div class="panel-body">
	        	
	        	
	        	<div class="col-sm-12">
					<form action="" method="post" id="" class="form-horizontal">
						<div class="col-md-12 col-xs-12">				
							<div class="form-group">
								<label class="control-label col-md-4" for="tipoServicio" >Tipo Servicio: </label>
								<div class="col-md-8 col-xs-12 campoValidado">
									<p class="form-control-static">TIPO SERVICIO</p>					 	
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4" for="urgencia" >Urgencia: </label>
								<div class="col-md-8 col-xs-12 campoValidado">
									<p class="form-control-static">URGENCIA</p>							
								</div>
							</div>
							<div class="form-group">
								<div class="date-container">
									<label class="control-label col-md-4" for="fechaDuracionSubasta" >Fecha Duración Subasta: </label>
									<div class="col-md-4 col-xs-12 campoValidado">
										<p class="form-control-static">FECHA DURACION SUBASTA</p>							
									</div>
								</div>
								<div class="timePicker">
									<label class="control-label col-md-2" for="horaInicioSubasta">Hora Inicio: </label>
									<div class="col-md-2 campoValidado">
										<p class="form-control-static">HORA INICIO</p>
									</div>	
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4" for="rateYoEscoger" >Pretenciones reputación desde: </label>
								<div class="col-md-8 col-xs-12">
									<div id="ranking-container"></div>
									<div class="counter"></div>
								</div>
								<!-- ALMACENAR LA VALORACION DEL PROVEEDOR -->
								<input type="hidden" id="ranking" name="" value="3"> 
								
								<script type="text/javascript">
									$(document).ready(function(){
										var ranking = $("#ranking").val();
										$("#ranking-container").rateYo({
											starWidth: "20px",
											rating: ranking,
											readOnly: true
										});
									});	
								</script>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4" for="tiempoEsperadoResolucion" >Tiempo esperando resolución: </label>
								<div class="col-md-4 col-xs-12">
									<p class="form-control-static">TIEMPO ESPERANDO RESOLUCION</p>					
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4" for="precioEstimadoPagar" >Precio estimado pagar: </label>
								<div class="col-md-4 col-xs-12 campoValidado">
									<p class="form-control-static">PRECIO ESTIMADO PAGAR</p>					
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-4" for="descripcionDelRequerimiento" >Descripción del requerimiento: </label>								
								<div class="panel panel-default col-md-8 col-xs-12 ">
									<div class="panel-body ">
								    	DESCRIPCION DEL REQUERIMIENTO
								  	</div>					
							  	</div>
							</div>		
							<div class="form-group">		
								<div class="col-md-offset-1">			
									<label class="control-label">Escoga la disposición de sus días para recibir el servicio: </label><br>
									<div class="checkbox col-md-12 col-xs-3 campoValidado">
										<label class="checkbox-inline disabled">
									      <input type="checkbox" name="chkDiasSemana" disabled>Lunes
									    </label>
									    <label class="checkbox-inline disabled">
									      <input type="checkbox" name="chkDiasSemana" disabled>Martes
									    </label>
									    <label class="checkbox-inline disabled">
									      <input type="checkbox" name="chkDiasSemana" disabled>Miércoles
									    </label>
									    <label class="checkbox-inline disabled">
									      <input type="checkbox" name="chkDiasSemana" disabled>Jueves
									    </label>
									    <label class="checkbox-inline disabled">
									      <input type="checkbox" name="chkDiasSemana" disabled>Viernes
									    </label>
									    <label class="checkbox-inline disabled">
									      <input type="checkbox" name="chkDiasSemana" disabled>Sábado
									    </label>
									    <label class="checkbox-inline disabled">
									      <input type="checkbox" name="chkDiasSemana" disabled>Domingo
									    </label>					
								    </div>	
								    <div class="muestra_error"></div>
								</div>	
							</div>	
							<div class="form-group">
								<div class="col-md-offset-1">
									<label class="control-label">Horario de recepción: </label>						
									<div class="form-group timePicker"><br>
										<label class="control-label col-md-2" for="">Desde las: </label>
										<div class="col-md-2 campoValidado">
											<p class="form-control-static">HORAS DESDE</p>
										</div>	
										<label class="control-label col-md-2" for="hastaLasHoras">Hasta las: </label>
										<div class="col-md-2 campoValidado">
											<p class="form-control-static">HORAS HASTA</p>
										</div>							
									</div>
								</div>
							</div>		        
							<div class="form-group">
								<div class="col-sm-offset-5">
									<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ofertarSubasta" >Ofertar</button>
									<button type="button" class="btn btn-danger" onclick="javascript:window.close();">No ofertar</button>						
								</div>
							</div>	
						</div>							
					</form>	
				 </div>
	        	
	        	
	        </div>
	        <div class="panel-footer"></div>
	      </div>
  	  </div>
  	  
  	  	
	<script>
		/* $(document).ready(function(){
			$("#btnCancelarSolicitud").on("click", function(e){
				var url = "menu_perfil/busca_servicio_usuario.jsp";
				$.ajax({
					type: "POST",
					url: url,
					success: function(data){
		               //alert(data); // show response from the php script.
		               $( ".col-sm-12" ).html( data );				      			        
		           	}
				});
				e.preventDefault();
			});							
		}); */
	</script>						 
<jsp:include page="../modals/ofertar_subasta.jsp" />