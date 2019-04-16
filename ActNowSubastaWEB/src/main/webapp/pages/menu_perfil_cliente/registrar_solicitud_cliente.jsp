<%-- <jsp:include page="/estructura/header-libs.jsp" /> --%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld" %>
<div class="panel panel-default">
  <div class="panel-body">  	
  	
  	  <!--Inicio contenido dinámico-->
  	  <div class="col-sm-12">
		<form action="addSolicitud" method="post" id="formulario_registro_solicitud" class="form-horizontal">
			<div class="col-md-12 col-xs-12">				
				<div class="form-group">
					<label class="control-label col-md-4" for="tipoServicio" >Tipo Servicio: </label>
					<div class="col-md-8 col-xs-12 campoValidado">
						<select class="form-control" id="tipoServicio" name="solicitud.servicio.codigoServicio">
						  <option value="">Seleccione...</option>
						  <option value="SER002">Cerrajeria</option>
					 	</select>							
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-4" for="urgencia" >Prioridad: </label>
					<div class="col-md-8 col-xs-12 campoValidado">
						<select class="form-control" id="prioridad" name="solicitud.prioridad">
						  <option value="">Seleccione...</option>
						  <option value="1">Baja</option>
						  <option value="2">Media</option>
						  <option value="3">Alta</option>
					 	</select>							
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-4" for="direccionRegistroServicio" >Dirección </label>
					<div class="col-md-8 col-xs-12 campoValidado">
						<select class="form-control" id="direccionRegistroServicio" name="solicitud.direccion.codigoDireccion">
						  <option value="">Seleccione...</option>
						  <option value="34">La Yareta 865, Huechuraba - Santiago</option>
					 	</select>							
					</div>
				</div>
				<div class="form-group">
					<div class="date-container">
						<label class="control-label col-md-4" for="fechaDuracionSubasta" >Fecha Duración Subasta: </label>
						<div class="col-md-4 col-xs-12 campoValidado">
							<input type="text" class="form-control" id="fechaDuracionSubasta" name="solicitud.fechaVencimiento" placeholder="dia/mes/año">							
						</div>
					</div>
					
					
					<!-- <div class="timePicker">
						<label class="control-label col-md-2" for="horaInicioSubasta">Hora Inicio: </label>
						<div class="col-md-2 campoValidado">
							<input type="text" class="form-control time" id="horaInicioSubasta" name="txtHoraInicioSubasta" placeholder="horas">
						</div>	
					</div> -->
				</div>

					<div class="form-group">
						<label class="control-label col-md-4"
							for="tiempoEsperadoResolucion">Duración Subasta	(Hrs:mm): 
						</label>
						<div class="col-md-4 col-xs-12">
							<input type="text" class="form-control" id="tiempoEsperadoResolucion" name="subasta.duracion" placeholder="horas">
						</div>
					</div>

					<div class="form-group">
					<label class="control-label col-md-4" for="rateYoEscoger" >Pretenciones reputación desde: </label>
					<div class="col-md-8 col-xs-12">
						<div id="rateYoEscoger"></div>
						<div class="counter"></div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-4" for="precioEstimadoPagar" >Precio estimado pagar: </label>
					<div class="col-md-4 col-xs-12 campoValidado">
						<input type="text" class="form-control" id="precioEstimadoPagar" name="solicitud.precioEsperado" placeholder="$">					
					</div>
				</div>	
				<div class="form-group">		
					<label class="control-label col-md-4" for="">Estado de la Solicitud: </label>
					<div class="col-md-offset-4">									
						<div class="checkbox col-md-12 col-xs-3 campoValidado">
							<label>
						      <input type="checkbox" name="activarSolicitud">Activa
						    </label>						    				
					    </div>	
					    <div class="muestra_error"></div>
					</div>	
				</div>			
				<div class="form-group">
					<label class="control-label col-md-4" for="descripcionDelRequerimiento" >Descripción del requerimiento: </label>
					<div class="col-md-8 col-xs-12 campoValidado">
						<textarea cols="9" rows="5" class="form-control" id="descripcionDelRequerimiento" name="solicitud.descripcion" placeholder="Ingrese la descripción de lo que necesita"></textarea>
					</div>						
				</div>		
				<div class="form-group">		
					<div class="col-md-offset-1">			
						<label class="control-label">Escoga la disposición de sus días para recibir el servicio: </label><br>
						<div class="checkbox col-md-12 col-xs-3 campoValidado">
							<label class="checkbox-inline">
						      <input type="checkbox" name="chkDiasSemana">Lunes
						    </label>
						    <label class="checkbox-inline">
						      <input type="checkbox" name="chkDiasSemana">Martes
						    </label>
						    <label class="checkbox-inline">
						      <input type="checkbox" name="chkDiasSemana">Miércoles
						    </label>
						    <label class="checkbox-inline">
						      <input type="checkbox" name="chkDiasSemana">Jueves
						    </label>
						    <label class="checkbox-inline">
						      <input type="checkbox" name="chkDiasSemana">Viernes
						    </label>
						    <label class="checkbox-inline">
						      <input type="checkbox" name="chkDiasSemana">Sábado
						    </label>
						    <label class="checkbox-inline">
						      <input type="checkbox" name="chkDiasSemana">Domingo
						    </label>					
					    </div>	
					    <div class="muestra_error"></div>
					</div>	
				</div>	
				<!-- <div class="form-group">
					<div class="col-md-offset-1">
						<label class="control-label">Horario de recepción: </label>						
						<div class="form-group timePicker"><br>
							<label class="control-label col-md-2" for="desdeLasHoras">Desde las: </label>
							<div class="col-md-2 campoValidado">
								<input type="text" class="form-control time" id="desdeLasHoras" name="txtDesdeLasHoras" placeholder="horas">
							</div>	
							<label class="control-label col-md-2" for="hastaLasHoras">Hasta las: </label>
							<div class="col-md-2 campoValidado">
								<input type="text" class="form-control time" id="hastaLasHoras" name="txtHastaLasHoras" placeholder="horas">
							</div>							
						</div>
					</div>
				</div>	-->					       
				<div class="form-group">
					<div class="col-sm-offset-7">
						<button type="submit" class="btn btn-success">Registrar Solicitud</button>
						<button type="button" class="btn btn-danger" id="btnCancelarSolicitud">Cancelar Solicitud</button>						
					</div>
				</div>	
			</div>							
		</form>	
	 </div>	
	<script>
		/* $(document).ready(function(){
			$("#btnCancelarSolicitud").on("click", function(e){
				var url = "menu_perfil/buscar_servicio_usuario.jsp";
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
  </div>
</div>  

