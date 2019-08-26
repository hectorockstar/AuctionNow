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
			name="proveedor.nombre" placeholder="Ingrese su nombre">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="apellido_paterno">
		<s:text name="common.label.apellido.paterno" />: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" id="apellido_paterno"
			name="proveedor.apellidoPaterno"
			placeholder="Ingrese su apellido paterno">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="apellido_materno">
		<s:text name="common.label.apellido.materno" />:
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" id="apellido_materno"
			name="proveedor.apellidoMaterno"
			placeholder="Ingrese su apellido materno">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="rut">
		<s:text name="common.label.rut" />: 
	</label>
	<div class="col-sm-5 campoValidado">
		<input type="text" class="form-control" id="rut" name="proveedor.rut"
			placeholder="Ingrese su RUT">
	</div>
	<label class="control-label col-sm-2" for="dv">
		<s:text name="common.label.dv" />: 
	</label>
	<div class="col-sm-2 campoValidado">
		<input type="text" class="form-control" id="dv" name="proveedor.rutDV"
			placeholder="DV">
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="genero">
		<s:text name="common.label.genero" />: 
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="genero" 
			name="proveedor.genero.id"
			list="#request.generos" 
			headerKey="" 
			headerValue="Seleccione..."
			listKey="id" 
			listValue="descripcion" />
	</div>
</div>

<div class="form-group date-container">
	<label class="control-label col-sm-3" for="fechaNacimiento">
		<s:text name="common.label.fecha.nacimiento" />: 
	</label>
	<div class="col-sm-4 campoValidado">
		<input type="text" class="form-control" id="fechaNacimiento" autocomplete="off"
			name="proveedor.fechaNacimiento" placeholder="Fecha nacimiento">
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="pais">
		<s:text name="common.label.pais" />: 
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="pais" 
			name="pais.codigoPais"
			list="#request.paises" 
			headerKey="" 
			headerValue="Selecccione..."
			listKey="codigoPais" 
			listValue="nombre" />
	</div>
</div>