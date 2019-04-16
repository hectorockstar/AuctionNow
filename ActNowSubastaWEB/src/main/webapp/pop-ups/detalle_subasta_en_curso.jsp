<jsp:include page="/estructura/header-libs.jsp" />

<!--Inicio contenido dinámico-->
<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">DETALLE SUBASTA EN CURSO</div>
		<div class="panel-body">

			<h3>
				<ins>Detalle Subasta</ins>
			</h3>
			<div class="col-sm-12">
				<div class="form-horizontal">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="col-md-12 col-xs-12">
								<div class="form-group">
									<label class="control-label col-md-4" for="tipoServicio">Tipo
										Servicio: </label>
									<div class="col-md-8 col-xs-12 campoValidado">
										<p class="form-control-static">TIPO SERVICIO</p>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-4" for="urgencia">Urgencia:
									</label>
									<div class="col-md-8 col-xs-12 campoValidado">
										<p class="form-control-static">URGENCIA</p>
									</div>
								</div>
								<div class="form-group">
									<div class="date-container">
										<label class="control-label col-md-4"
											for="fechaDuracionSubasta">Fecha Duración Subasta: </label>
										<div class="col-md-4 col-xs-12 campoValidado">
											<p class="form-control-static">FECHA DURACION SUBASTA</p>
										</div>
									</div>
									<div class="timePicker">
										<label class="control-label col-md-2" for="horaInicioSubasta">Hora
											Inicio: </label>
										<div class="col-md-2 campoValidado">
											<p class="form-control-static">HORA INICIO</p>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-4" for="rateYoEscoger">Pretenciones
										reputación desde: </label>
									<div class="col-md-8 col-xs-12">
										<div id="ranking-container"></div>
										<div class="counter"></div>
									</div>
									<!-- ALMACENAR LA VALORACION DEL PROVEEDOR -->
									<input type="hidden" id="ranking" name="" value="3">

									<script type="text/javascript">
										$(document).ready(function() {
											var ranking = $("#ranking").val();
											$("#ranking-container").rateYo({
												starWidth : "20px",
												rating : ranking,
												readOnly : true
											});
										});
									</script>
								</div>
								<div class="form-group">
									<label class="control-label col-md-4"
										for="tiempoEsperadoResolucion">Tiempo esperando
										resolución: </label>
									<div class="col-md-4 col-xs-12">
										<p class="form-control-static">TIEMPO ESPERANDO RESOLUCION</p>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-4" for="precioEstimadoPagar">Precio
										estimado pagar: </label>
									<div class="col-md-4 col-xs-12 campoValidado">
										<p class="form-control-static">PRECIO ESTIMADO PAGAR</p>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-md-4"
										for="descripcionDelRequerimiento">Descripción del
										requerimiento: </label>
									<div class="panel panel-default col-md-8 col-xs-12 ">
										<div class="panel-body ">DESCRIPCION DEL REQUERIMIENTO</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-1">
										<label class="control-label">Escoga la disposición de
											sus días para recibir el servicio: </label><br>
										<div class="checkbox col-md-12 col-xs-3 campoValidado">
											<label class="checkbox-inline disabled"> <input
												type="checkbox" name="chkDiasSemana" disabled>Lunes
											</label> <label class="checkbox-inline disabled"> <input
												type="checkbox" name="chkDiasSemana" disabled>Martes
											</label> <label class="checkbox-inline disabled"> <input
												type="checkbox" name="chkDiasSemana" disabled>Miércoles
											</label> <label class="checkbox-inline disabled"> <input
												type="checkbox" name="chkDiasSemana" disabled>Jueves
											</label> <label class="checkbox-inline disabled"> <input
												type="checkbox" name="chkDiasSemana" disabled>Viernes
											</label> <label class="checkbox-inline disabled"> <input
												type="checkbox" name="chkDiasSemana" disabled>Sábado
											</label> <label class="checkbox-inline disabled"> <input
												type="checkbox" name="chkDiasSemana" disabled>Domingo
											</label>
										</div>
										<div class="muestra_error"></div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-1">
										<label class="control-label">Horario de recepción: </label>
										<div class="form-group timePicker">
											<br> <label class="control-label col-md-2" for="">Desde
												las: </label>
											<div class="col-md-2 campoValidado">
												<p class="form-control-static">HORAS DESDE</p>
											</div>
											<label class="control-label col-md-2" for="hastaLasHoras">Hasta
												las: </label>
											<div class="col-md-2 campoValidado">
												<p class="form-control-static">HORAS HASTA</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<h3>
						<ins>Ofertas Recibidas</ins>
					</h3>
					<br>
					<form action="" method="POST">
					<!--  AQUI VA EL FOR PARA ITERAR -->
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="col-md-4">
									<div class="media">
										<div class="media-left media-top">
											<img src="../utils/img/perfil/img_avatar1.png"
												class="media-object" style="width: 60px">
										</div>
										<div class="media-body">
											<h4 class="media-heading">
												Usuario <small><i>fecha de la oferta</i></small>
											</h4>
											<div class="rateYo"></div>
											<div class="counter"></div>
											<br>
											<p>EMPRESA PROVEEDOR</p>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="panel panel-default">
										<div class="panel-body">
											<p>
												A ofertado por un monto de <b>$ PRECIO</b>
											</p>
										</div>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<button type="submit" class="btn btn-success">Escoger Proveedor</button>
									</div>
								</div>
							</div>
						</div>
					</form>
					<div class="form-group">
						<div class="col-sm-offset-5">							
							<button type="button" class="btn btn-danger" onclick="javascript:window.close();">Cerrar</button>
						</div>
					</div>
				</div>
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