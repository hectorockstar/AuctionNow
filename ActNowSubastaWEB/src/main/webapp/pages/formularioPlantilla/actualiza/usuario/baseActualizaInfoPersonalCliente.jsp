<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<br>
<h3>
	<ins><s:text name="title.label.informacion.personal" /></ins>
</h3>
<br>

<div class="form-group">
	<label class="control-label col-sm-3" for="nombre">
		<s:text name="common.label.nombre" />: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" id="nombre"
			name="cliente.nombre" placeholder="Ingrese su nombre"
			value='<s:property value="usuarioWeb.usuario.nombre"/>' >
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="apellido_paterno">
		<s:text name="common.label.apellido.paterno" />: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" id="apellido_paterno"
			name="cliente.apellidoPaterno"
			placeholder="Ingrese su apellido paterno"
			value='<s:property value="usuarioWeb.usuario.apellidoPaterno"/>' >
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="apellido_materno">
		<s:text name="common.label.apellido.materno" />:
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" id="apellido_materno"
			name="cliente.apellidoMaterno"
			placeholder="Ingrese su apellido materno"
			value='<s:property value="usuarioWeb.usuario.apellidoMaterno"/>' >
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="updateFechaNacimiento">
		<s:text name="common.label.fecha.nacimiento" />: 
	</label>
	<div class="col-sm-4 campoValidado">
		<input type="text" class="form-control" id="updateFechaNacimiento" 
			name="cliente.fechaNacimiento" autocomplete="off"
			placeholder="Fecha de Nacimiento" 
			value='${fechaNacimientoFormat}' />
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="rut">
		<s:text name="common.label.rut" />: 
	</label>
	<div class="col-sm-5 campoValidado">
		<input type="text" class="form-control" id="rut" name="cliente.rut"
			placeholder="Ingrese su RUT"
			value='<s:property value="usuarioWeb.usuario.rut"/>' >
	</div>
	<label class="control-label col-sm-2" for="dv">
		<s:text name="common.label.dv" />: 
	</label>
	<div class="col-sm-2 campoValidado">
		<input type="text" class="form-control" id="dv" name="cliente.rutDV"
			placeholder="DV"
			value='<s:property value="usuarioWeb.usuario.rutDV"/>' >
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="genero">
		<s:text name="common.label.genero" />: 
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="genero" 
			name="cliente.genero.id"
			list="#request.generos" 
			headerKey="" 
			headerValue="Selecccione..."
			listKey="id" 
			listValue="descripcion"
			value="usuarioWeb.usuario.genero.id"
			/>
	</div>
</div>

