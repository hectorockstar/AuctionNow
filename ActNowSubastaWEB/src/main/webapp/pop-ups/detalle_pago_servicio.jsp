<jsp:include page="/estructura/header-libs.jsp" />

<div class="panel panel-default">
	<div class="panel-body">

		<!--Inicio contenido dinámico:  para los step -> http://bootsnipp.com/snippets/e3MBM-->
		<div class="container">
			<div class="panel panel-primary">
				<div class="panel-heading">Pago por el servicio: SERVICIO</div>
				<div class="panel-body">

					<div class="stepwizard col-md-offset-3">
						<div class="stepwizard-row setup-panel">
							<div class="stepwizard-step">
								<a href="#step-1" type="button"
									class="btn btn-primary btn-circle">1</a>
								<p>Paso 1</p>
							</div>
							<div class="stepwizard-step">
								<a href="#step-2" type="button"
									class="btn btn-default btn-circle" disabled="disabled">2</a>
								<p>Paso 2</p>
							</div>
						</div>
					</div>

					<form role="form" action="" method="post" class="form-horizontal"
						onSubmit="return msgPagarServicio();">
						<div class="row setup-content" id="step-1">
							<div class="col-xs-6 col-md-offset-3">
								<div class="col-md-12">
									<br>
									<!-- <h3> Step 1</h3> -->
									<div class="form-group">
										<label class="control-label col-md-4" for="">Tipo Moneda: </label>
										<div class="col-md-8 col-xs-12 campoValidado">
											<select class="form-control" id="" name="">
												<option value="">Seleccione...</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4" for="">Tipo de Tarjeta: </label>
										<div class="col-md-8 col-xs-12 campoValidado">
											<select class="form-control" id="" name="">
												<option value="">Seleccione...</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4" for="">Entidad Comercial: </label>
										<div class="col-md-8 col-xs-12 campoValidado">
											<select class="form-control" id="" name="">
												<option value="">Seleccione...</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4" for="">Código	Transacción: </label>
										<div class="col-md-2 campoValidado">
											<p class="form-control-static">Transacción</p>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4" for="">Monto a Cancelar: </label>
										<div class="col-md-2 campoValidado">
											<p class="form-control-static">$ Monto</p>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4" for="">Coutas: </label>
										<div class="col-md-8 col-xs-12 campoValidado">
											<select class="form-control" id="" name="">
												<option value="">Seleccione...</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4" for="">Fecha Expiración : </label>
										<div class="col-md-3 campoValidado">
											<input type="text" class="form-control" id="" name="" placeholder="MM">
										</div>
										<label class="control-label col-md-1" for="">/</label>
										<div class="col-md-3 campoValidado">
											<input type="text" class="form-control" id="" name="" placeholder="YYYY">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-md-4" for="">Nro Tarjeta: </label>
										<div class="col-md-8 col-xs-12 campoValidado">
											<input type="text" class="form-control" id="" name="" placeholder="Número Tarjetas">
										</div>
									</div>
									<button class="btn btn-primary nextBtn btn pull-right"
										type="button">Siguiente</button>
								</div>
							</div>
						</div>


						<div class="row setup-content" id="step-2">
							<div class="col-xs-6 col-md-offset-3">
								<div class="col-md-12">
								
									<div class="panel panel-default">
										<div class="panel-body">

											<h4>
												<ins>Detalle Transacción</ins>
											</h4>
											<br>
											<div class="form-group">
												<label class="control-label col-md-4" for="">Tipo Moneda: </label>
												<div class="col-md-8 campoValidado">
													<p class="form-control-static">TIPO MONEDA</p>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-4" for="">Tipo Tarjeta: </label>
												<div class="col-md-8 campoValidado">
													<p class="form-control-static">TIPO TARJETA</p>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-4" for="">Entidad Comercial: </label>
												<div class="col-md-8 campoValidado">
													<p class="form-control-static">ENTIDAD COMERCIAL</p>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-4" for="">Tipo Moneda: </label>
												<div class="col-md-8 campoValidado">
													<p class="form-control-static">TIPO MONEDA</p>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-4" for="">Código Transacción: </label>
												<div class="col-md-8 campoValidado">
													<p class="form-control-static">CODIGO TRANSACCION</p>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-4" for="">Monto Cancelado: </label>
												<div class="col-md-8 campoValidado">
													<p class="form-control-static">MONTO CANCELADO</p>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-4" for="">Nro Cuotas: </label>
												<div class="col-md-8 campoValidado">
													<p class="form-control-static">NRO CUOTAS</p>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-4" for="">Fecha Expiracion: </label>
												<div class="col-md-8 campoValidado">
													<p class="form-control-static">MM / YYYY</p>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-4" for="">Nro Tarjeta: </label>
												<div class="col-md-8 campoValidado">
													<p class="form-control-static">NRO TARJETA</p>
												</div>
											</div>											

										</div>
									</div>
									<button class="btn btn-success btn pull-right" type="submit">Pagar</button>
									
								</div>
							</div>
						</div>
					</form>

				</div>
				<div class="panel-footer"></div>
			</div>
		</div>

	</div>
</div>
