<jsp:include page="../estructura/header-content.jsp" />
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<div class="panel panel-default">
	<div class="panel-body">

		<!--Inicio contenido dinámico-->
		<div class="container">
			<div class="row well">
				<div class="col-xs-8">
					<h2>Formulario de Registro Cliente</h2>
					<br>
					<div id="formulario_usuario">

						<br>
						<h3>
							<ins>Datos Usuario</ins>
						</h3>
						<br>
						
						<form action="addUsuarioWebCliente" class="form-horizontal"
							id="formulario_registro_usuario" method="POST">
							<div class="form-group">
								<label class="control-label col-sm-3" for="nombre">Nombre:
								</label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control" id="nombre"
										name="cliente.nombre" placeholder="Ingrese su nombre">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="apellido_paterno">Apellido
									Paterno: </label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control" id="apellido_paterno"
										name="cliente.apellidoPaterno"
										placeholder="Ingrese su apellido paterno">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="apellido_materno">Apellido
									Materno: </label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control" id="apellido_materno"
										name="cliente.apellidoMaterno"
										placeholder="Ingrese su apellido materno">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="rut">RUT: </label>
								<div class="col-sm-5 campoValidado">
									<input type="text" class="form-control" id="rut"
										name="cliente.rut" placeholder="Ingrese su RUT">
								</div>
								<label class="control-label col-sm-2" for="dv">DV: </label>
								<div class="col-sm-2 campoValidado">
									<input type="text" class="form-control" id="dv"
										name="cliente.rutDV" placeholder="DV">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="ocupacion">Ocupación
								</label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control" id="ocupacion"
										name="cliente.ocupacion" placeholder="Ingrese su ocupación">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="genero">Sexo:
								</label>
								<div class="col-sm-4 campoValidado">
									<select class="form-control" id="genero" name="cliente.genero">
										<option value="">Seleccione...</option>
										<option value="M">Masculino</option>
										<option value="F">Femenino</option>
										<option value="O">Otro</option>
									</select>
								</div>
							</div>
							<div class="form-group date-container">
								<label class="control-label col-sm-3" for="fecha_nacimiento">Fecha
									Nacimiento: </label>
								<div class="col-sm-4 campoValidado">
									<input type="text" class="form-control" id="fecha_nacimiento"
										name="cliente.fechaNacimiento" placeholder="Fecha nacimiento">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-3" for="correo">Email:
								</label>
								<div class="col-sm-9 campoValidado">
									<input type="email" class="form-control" id="correo"
										name="contacto.email" placeholder="Ingrese su email">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="username">Nombre
									Usuario: </label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control" id="username"
										name="usuarioWeb.nombreUsuario"
										placeholder="Ingrese su nombre de usuario">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="pwd">Contraseña:
								</label>
								<div class="col-sm-9 campoValidado">
									<input type="password" class="form-control" id="pwd"
										name="usuarioWeb.contrasena"
										placeholder="Ingrese su contraseña">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="re_pwd">Repita
									Contraseña: </label>
								<div class="col-sm-9 campoValidado">
									<input type="password" class="form-control" id="re_pwd"
										name="re_pwd" placeholder="Repita contraseña">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-xs-3" for="telefono1">Teléfono
									1: </label>
								<div class="col-md-3 col-xs-9 campoValidado">
									<input type="text" class="form-control" id="telefono1"
										name="contacto.telefono1" placeholder="Ingrese su teléfono 1">
								</div>
								<label class="control-label col-md-3 col-xs-3" for="telefono2">Teléfono
									2: </label>
								<div class="col-md-3 col-xs-9 campoValidado">
									<input type="text" class="form-control" id="telefono2"
										name="contacto.telefono2" placeholder="Ingrese su teléfono 2">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3 col-xs-3" for="movil1">Móvil
									1: </label>
								<div class="col-md-3 col-xs-9 campoValidado">
									<input type="text" class="form-control" id="movil1"
										name="contacto.movil1" placeholder="Ingrese su móvil 1">
								</div>
								<label class="control-label col-md-3 col-xs-3" for="movil2">Móvil
									2: </label>
								<div class="col-md-3 col-xs-9 campoValidado">
									<input type="text" class="form-control" id="movil2"
										name="contacto.movil2" placeholder="Ingrese su móvil 2">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-3" for="contacto">Tipo
									de Contacto: </label>
								<div class="col-sm-4 campoValidado">
									<s:select class="form-control" id="tipoContacto"
										name="contacto.tipoContacto.id" list="#request.tipsContactos"
										headerKey="" headerValue="Selecccione..." listKey="id"
										listValue="descripcion" />
								</div>
							</div>

							<h3>
								<ins>Datos Dirección</ins>
							</h3>
							<br>
							<div class="form-group">
								<label class="control-label col-sm-3" for="pais">País: </label>
								<div class="col-sm-4 campoValidado">
									<s:select class="form-control" id="pais" name="cbbPais"
										list="#request.paises" headerKey=""
										headerValue="Selecccione..." listKey="codigoPais"
										listValue="nombre" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="region">Región:
								</label>
								<div class="col-sm-4 campoValidado">
									<s:select class="form-control" id="region" name="cbbRegion"
										list="#request.regiones" headerKey=""
										headerValue="Selecccione..." listKey="codigoRegion"
										listValue="nombre" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="ciudad">Ciudad:
								</label>
								<div class="col-sm-4 campoValidado">
									<s:select class="form-control" id="ciudad" name="cbbCiudad"
										list="#request.ciudades" headerKey=""
										headerValue="Selecccione..." listKey="codigoCiudad"
										listValue="nombre" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="comuna">Comuna:
								</label>
								<div class="col-sm-4 campoValidado">
									<s:select class="form-control" id="comuna"
										name="direccion.comuna.codigoComuna" list="#request.comunas"
										headerKey="" headerValue="Selecccione..."
										listKey="codigoComuna" listValue="nombre" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-3" for="calle">Calle:</label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control" id="calle"
										name="direccion.calle" placeholder="Ingrese su calle">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-3" for="dirección">Numeración:</label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control" id="numeracion"
										name="direccion.numeracion"
										placeholder="Ingrese su Numeración">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-3" for="dirección">Nro
									Departamento:</label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control" id="deptoNro"
										name="direccion.deptoNro" placeholder="Opcional">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-3" for="dirección">Piso:</label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control" id="piso"
										name="direccion.piso" placeholder="Opcional">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-3" for="codigo_postal">Código
									Postal:</label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control" id="codigo_postal"
										name="direccion.codigoPostal"
										placeholder="Ingrese código postal">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="dpto_oficina">Observación:</label>
								<div class="col-sm-9">
									<textarea cols="9" rows="5" class="form-control"
										id="observacion" name="direccion.observacion"
										placeholder="Ingrese una referencia a su direccion"></textarea>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-3" for="direccion">Tipo
									de Dirección: </label>
								<div class="col-sm-4 campoValidado">
									<s:select class="form-control" id="tipoDireccion"
										name="direccion.tipoDireccion.id"
										list="#request.tipsDirecciones" headerKey=""
										headerValue="Selecccione..." listKey="id"
										listValue="descripcion" />
								</div>
							</div>

							<h3>
								<ins>Preferencia Usuario</ins>
							</h3>
							<br>
							<div class="form-group">
								<label class="control-label col-sm-3" for="pregunta1">Pregunta
									1: </label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control preferencia-usuario"
										id="pregunta1" name="usuarioWeb.pregunta1"
										placeholder="Ingrese pregunta 1">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="respuesta1">Respuesta
									1: </label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control preferencia-usuario"
										id="respuesta1" name="usuarioWeb.respuesta1"
										placeholder="Ingrese respuesta 1">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="pregunta2">Pregunta
									2: </label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control preferencia-usuario"
										id="pregunta2" name="usuarioWeb.pregunta2"
										placeholder="Ingrese pregunta 2">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="respuesta2">Respuesta
									2: </label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control preferencia-usuario"
										id="respuesta2" name="usuarioWeb.respuesta2"
										placeholder="Ingrese respuesta 2">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="pregunta3">Pregunta
									3: </label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control preferencia-usuario"
										id="pregunta3" name="usuarioWeb.pregunta3"
										placeholder="Ingrese pregunta 3">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="respuesta3">Respuesta
									3: </label>
								<div class="col-sm-9 campoValidado">
									<input type="text" class="form-control preferencia-usuario"
										id="respuesta3" name="usuarioWeb.respuesta3"
										placeholder="Ingrese respuesta 3">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3" for="firma_comentario">Firma
									comentario: </label>
								<div class="col-sm-9 campoValidado">
									<textarea cols="9" rows="5" class="form-control"
										id="firma_comentario" name="usuarioWeb.firmaComentario"
										placeholder="Ingrese la firma de su comentario"></textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-9 col-sm-offset-3">
									<div class="checkbox campoValidado">
										<label> <input type="checkbox"
											name="chkTerminos_condiciones" />He leído y acepto los <a
											href="#" data-toggle="modal"
											data-target="#terminosDelServicioModal">Términos del
												Servicio </a>
										</label>
									</div>
								</div>
							</div>

							<br>
							<div class="clearfix "></div>
							<div class="form-group">
								<div class="col-sm-offset-3">
									<button type="submit" class="btn btn-success">Regístrate</button>
								</div>
							</div>
						</form>
					</div>


				</div>


			</div>
			<div class="col-xs-4">
				<h3>Condiciones</h3>
				<p>Haciendo click en "Regístrate", aceptas los términos del
					servicio y política de privacidad.</p>
			</div>
		</div>
	</div>
</div>
<br>
<br>

<jsp:include page="../estructura/footer-content.jsp" />