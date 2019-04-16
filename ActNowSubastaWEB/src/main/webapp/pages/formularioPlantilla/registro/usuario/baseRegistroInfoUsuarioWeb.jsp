<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<br>
<h3>
	<ins><s:text name="title.label.datos.usuario.web"/></ins>
</h3>
<br>

<div class="form-group">
	<label class="control-label col-sm-3" for="username">
		<s:text name="common.label.nombre.usuario"/>: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" id="username"
			name="usuarioWeb.nombreUsuario"
			placeholder="Ingrese su nombre de usuario">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="pwd">
		<s:text name="common.label.contrasena"/>: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="password" class="form-control" id="pwd"
			name="usuarioWeb.contrasena" placeholder="Ingrese su contraseña">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="re_pwd">
		<s:text name="common.label.repetir.contrasena"/>: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="password" class="form-control" id="re_pwd" name="re_pwd"
			placeholder="Repita contraseña">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="pregunta1">
		<s:text name="common.label.pregunta"/> 1: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control preferencia-usuario"
			id="pregunta1" name="usuarioWeb.pregunta1"
			placeholder="Ingrese pregunta 1">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="respuesta1">
		<s:text name="common.label.respuesta"/> 1: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control preferencia-usuario"
			id="respuesta1" name="usuarioWeb.respuesta1"
			placeholder="Ingrese respuesta 1">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="pregunta2">
		<s:text name="common.label.pregunta"/> 2: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control preferencia-usuario"
			id="pregunta2" name="usuarioWeb.pregunta2"
			placeholder="Ingrese pregunta 2">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="respuesta2">
		<s:text name="common.label.respuesta"/> 2: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control preferencia-usuario"
			id="respuesta2" name="usuarioWeb.respuesta2"
			placeholder="Ingrese respuesta 2">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="pregunta3">
		<s:text name="common.label.pregunta"/> 3: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control preferencia-usuario"
			id="pregunta3" name="usuarioWeb.pregunta3"
			placeholder="Ingrese pregunta 3">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="respuesta3">
		<s:text name="common.label.respuesta"/> 3: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control preferencia-usuario"
			id="respuesta3" name="usuarioWeb.respuesta3"
			placeholder="Ingrese respuesta 3">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="firma_comentario">
		<s:text name="common.label.firma.comentario"/>: 
	</label>
	<div class="col-sm-9 campoValidado">
		<textarea cols="9" rows="5" class="form-control" id="firma_comentario"
			name="usuarioWeb.firmaComentario"
			placeholder="Ingrese la firma de su comentario"></textarea>
	</div>
</div>