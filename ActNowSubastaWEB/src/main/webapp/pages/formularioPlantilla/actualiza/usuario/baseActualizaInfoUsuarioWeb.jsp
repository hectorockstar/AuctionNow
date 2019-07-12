<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<br>
<h3>
	<ins><s:text name="title.label.datos.usuario.web"/></ins>
</h3>
<br>

<div class="form-group">
	<label class="control-label col-sm-3" for="nombreUsuario">
		<s:text name="common.label.nombre.usuario"/>: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" 
			id="nombreUsuario"
			name="usuarioWeb.nombreUsuario" 
			value='<s:property value="usuarioWeb.nombreUsuario"/>'
			disabled >
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="pwd">
		<s:text name="common.label.nueva.contrasena"/>: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="password" class="form-control" id="pwd"
			name="usuarioWeb.contrasena" placeholder="Ingrese su Nueva contraseña">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="re_pwd">
		<s:text name="common.label.repetir.nueva.contrasena"/>: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="password" class="form-control" id="re_pwd" name="re_pwd"
			placeholder="Repita Nueva Contraseña">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="pregunta1">
		<s:text name="common.label.pregunta"/> 1: 
	</label>
	<label class="control-label">
		<s:property value="usuarioWeb.pregunta1"/>
	</label>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="respuesta1">
		<s:text name="common.label.respuesta"/> 1: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control preferencia-usuario"
			id="respuesta1" name="usuarioWeb.respuesta1"
			placeholder="Ingrese respuesta 1"
			value='<s:property value="usuarioWeb.respuesta1"/>' >
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="pregunta2">
		<s:text name="common.label.pregunta"/> 2: 
	</label>
	<label class="control-label">
		<s:property value="usuarioWeb.pregunta2"/>
	</label>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="respuesta2">
		<s:text name="common.label.respuesta"/> 2: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control preferencia-usuario"
			id="respuesta2" name="usuarioWeb.respuesta2"
			placeholder="Ingrese respuesta 2"
			value='<s:property value="usuarioWeb.respuesta2"/>' >
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="pregunta3">
		<s:text name="common.label.pregunta"/> 3: 
	</label>
	<label class="control-label">
		<s:property value="usuarioWeb.pregunta3"/>
	</label>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="respuesta3">
		<s:text name="common.label.respuesta"/> 3: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control preferencia-usuario"
			id="respuesta3" name="usuarioWeb.respuesta3"
			placeholder="Ingrese respuesta 3"
			value='<s:property value="usuarioWeb.respuesta3"/>' >
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="firma_comentario">
		<s:text name="common.label.firma.comentario"/>: 
	</label>
	<div class="col-sm-9 campoValidado">
		<textarea cols="9" rows="5" class="form-control" id="firma_comentario"
			name="usuarioWeb.firmaComentario"
			placeholder="Ingrese la firma de su comentario">
			<s:property value="usuarioWeb.firmaComentario"/>
		</textarea>
	</div>
</div>