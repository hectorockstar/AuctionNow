<jsp:include page="../../../../estructura/header-content.jsp" />
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<div class="panel panel-default">
	<div class="panel-body">

		<!--Inicio contenido din�mico-->
		<div class="container">
			<div class="row well">
				<div class="col-xs-8">
					<h2>
						<s:text name="title.label.formulario.registro.proveedor" />
					</h2>
					<div id="formulario_proveedor">

						<form action="addUsuarioWebProveedor" class="form-horizontal"
							id="formulario_registro_proveedor" method="POST">

							<s:if test="%{request.empresas != null}">
								<jsp:include page="../../../../pages/formularioPlantilla/filtro/servicio/baseFiltroCargoPorServicioEmpresa1.jsp" />
							</s:if>
							
							<jsp:include page="../../../../pages/formularioPlantilla/registro/usuario/baseRegistroInfoPersonalProveedor.jsp" />
							<jsp:include page="../../../../pages/formularioPlantilla/registro/usuario/baseRegistroInfoUsuarioWeb.jsp" />

							<div class="form-group">
								<div class="col-sm-9 col-sm-offset-3">
									<div class="checkbox campoValidado">
										<label> <input type="checkbox"
											name="chkTerminos_condiciones" /> <s:text
												name="descripcion.leido.acepto.terminos1" /> <a href="#"
											data-toggle="modal" data-target="#terminosDelServicioModal">
												<s:text name="descripcion.leido.acepto.terminos2" />
										</a>
										</label>
									</div>
								</div>
							</div>

							<br>
							<div class="clearfix "></div>
							<div class="form-group">
								<div class="col-sm-offset-3">
									<button type="submit" class="btn btn-success">
										<s:text name="button.label.registrar" />
									</button>
								</div>
							</div>

						</form>
					</div>
				</div>
			</div>
			<div class="col-xs-4">
				<h3>Condiciones</h3>
				<p>Haciendo click en "Reg�strate", aceptas los t�rminos del
					servicio y pol�tica de privacidad.</p>
			</div>
		</div>
	</div>
</div>
<br>
<br>

<jsp:include page="../../../../estructura/footer-content.jsp" />
