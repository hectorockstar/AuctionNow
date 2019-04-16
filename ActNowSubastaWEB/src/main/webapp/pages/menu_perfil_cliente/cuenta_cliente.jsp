

<div class="panel panel-default">
  <div class="panel-body">  	
  	
  	<!--Inicio contenido din�mico-->
	<h3><ins>Datos Usuario</ins></h3><br>				    
	<form action="" class="form-horizontal" id="formulario_registro_usuario">
		<div class="form-group">
			<label class="control-label col-sm-3" for="nombre" >Nombre: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="nombre" name="txtNombre" placeholder="Ingrese su nombre">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="apellido_paterno" >Apellido Paterno: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="apellido_paterno" name="txtApellido_paterno" placeholder="Ingrese su apellido paterno">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="apellido_materno" >Apellido Materno: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="apellido_materno" name="txtApellido_materno" placeholder="Ingrese su apellido materno">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="rut" >RUT: </label>
			<div class="col-sm-5 campoValidado">
				<input type="text" class="form-control" id="rut" name="txtRut" placeholder="Ingrese su RUT">
			</div>
			<label class="control-label col-sm-2" for="dv" >DV: </label>
			<div class="col-sm-2 campoValidado">
				<input type="text" class="form-control" id="dv" name="txtDv" placeholder="DV">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="ocupacion" >Ocupaci�n </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="ocupacion" name="txtOcupacion" placeholder="Ingrese su ocupaci�n">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="genero" >Sexo: </label>
			<div class="col-sm-4 campoValidado">
				<select class="form-control" id="genero" name="cbbGenero">
				  <option value="">Seleccione...</option>
				  <option value="masculino">Masculino</option>
				  <option value="femenino">Femenino</option>
				  <option value="otro">Otro</option>
			  </select>
			</div>
		</div>
		<div class="form-group date-container">
			<label class="control-label col-sm-3" for="fecha_nacimiento">Fecha Nacimiento: </label>
			<div class="col-sm-4 campoValidado">
				<input type="text" class="form-control" id="fecha_nacimiento" name="txtFecha_nacimiento" placeholder="Fecha nacimiento">
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-3" for="correo" >Email: </label>
			<div class="col-sm-9 campoValidado">
				<input type="email" class="form-control" id="correo" name="txtCorreo" placeholder="Ingrese su email">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="username" >Nombre Usuario: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="username" name="txtUsername" placeholder="Ingrese su nombre de usuario">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="pwd" >Contrase�a: </label>
			<div class="col-sm-9 campoValidado">
				<input type="password" class="form-control" id="pwd" name="txtPwd" placeholder="Ingrese su contrase�a">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="re_pwd" >Repita Contrase�a: </label>
			<div class="col-sm-9 campoValidado">
				<input type="password" class="form-control" id="re_pwd" name="txtRe_pwd" placeholder="Repita contrase�a">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3 col-xs-3" for="telefono1" >Tel�fono 1: </label>
			<div class="col-md-3 col-xs-9 campoValidado">
				<input type="text" class="form-control" id="telefono1" name="txtTelefono1" placeholder="Ingrese su tel�fono 1">
			</div>
			<label class="control-label col-md-3 col-xs-3" for="telefono2" >Tel�fono 2: </label>
			<div class="col-md-3 col-xs-9 campoValidado">
				<input type="text" class="form-control" id="telefono2" name="txtTelefono2" placeholder="Ingrese su tel�fono 2">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3 col-xs-3" for="movil1" >M�vil 1: </label>
			<div class="col-md-3 col-xs-9 campoValidado">
				<input type="text" class="form-control" id="movil1" name="txtMovil1" placeholder="Ingrese su m�vil 1">
			</div>
			<label class="control-label col-md-3 col-xs-3" for="movil2" >M�vil 2: </label>
			<div class="col-md-3 col-xs-9 campoValidado">
				<input type="text" class="form-control" id="movil2" name="txtMovil2" placeholder="Ingrese su m�vil 2">
			</div>
		</div>
		
		<h3><ins>Datos Direcci�n</ins></h3><br>
		<div class="form-group">
			<label class="control-label col-sm-3" for="pais" >Pa�s: </label>
			<div class="col-sm-4 campoValidado">
				<select class="form-control" id="pais" name="cbbPais">
				  <option value="">Seleccione...</option>
				  <option value="chile">Chile</option>
			  </select>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="region" >Regi�n: </label>
			<div class="col-sm-4 campoValidado">
				<select class="form-control" id="region" name="cbbRegion">
				  <option value="">Seleccione...</option>
			  </select>
			</div>
		</div>		
		<div class="form-group">
			<label class="control-label col-sm-3" for="ciudad" >Ciudad: </label>
			<div class="col-sm-4 campoValidado">
				<select class="form-control" id="ciudad" name="cbbCiudad">
				  <option value="">Seleccione...</option>
			  </select>
			</div>
		</div>				
		<div class="form-group">
			<label class="control-label col-sm-3" for="comuna" >Comuna: </label>
			<div class="col-sm-4 campoValidado">
				<select class="form-control" id="comuna" name="cbbComuna">
				  <option value="">Seleccione...</option>
			  </select>
			</div>
		</div>																			
		<div class="form-group">
			<label class="control-label col-sm-3" for="direcci�n" >Direcci�n </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="direcci�n" name="txtDireccion" placeholder="Ingrese su direcci�n">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="calle" >Calle</label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="calle" name="txtCalle" placeholder="Ingrese su calle">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="codigo_postal" >C�digo Postal</label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="codigo_postal" name="txtCodigo_postal" placeholder="Ingrese c�digo postal">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="dpto_oficina" >Dpto/Oficina</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="dpto_oficina" placeholder="Opcional">
			</div>
		</div>
		
		<h3><ins>Preferencia Usuario</ins></h3><br>
		<div class="form-group">
			<label class="control-label col-sm-3" for="pregunta1" >Pregunta 1: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control preferencia-usuario" id="pregunta1" name="txtPregunta1" placeholder="Ingrese pregunta 1">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="respuesta1" >Respuesta 1: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control preferencia-usuario" id="respuesta1" name="txtRespuesta1" placeholder="Ingrese respuesta 1">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="pregunta2" >Pregunta 2: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control preferencia-usuario" id="pregunta2" name="txtPregunta2" placeholder="Ingrese pregunta 2">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="respuesta2" >Respuesta 2: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control preferencia-usuario" id="respuesta2" name="txtRespuesta2" placeholder="Ingrese respuesta 2">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="pregunta3" >Pregunta 3: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control preferencia-usuario" id="pregunta3" name="txtPregunta3" placeholder="Ingrese pregunta 3">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="respuesta3" >Respuesta 3: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control preferencia-usuario" id="respuesta3" name="txtRespuesta3" placeholder="Ingrese respuesta 3">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="firma_comentario" >Firma comentario: </label>
			<div class="col-sm-9 campoValidado">
				<textarea cols="9" rows="5" class="form-control" id="firma_comentario" name="txtFirma_comentario" placeholder="Ingrese la firma de su comentario"></textarea>
			</div>
		</div>					
		
		<br>
		<div class="clearfix "></div>
		<div class="form-group">
			<div class="col-sm-offset-3">
				<button type="submit" class="btn btn-warning">Modificar</button>
			</div>						
		</div>
	</form> 
	
	
  </div>
</div>  
