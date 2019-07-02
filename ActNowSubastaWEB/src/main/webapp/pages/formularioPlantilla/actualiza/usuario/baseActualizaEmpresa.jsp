<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<br>
<h3>
	<ins><s:text name="title.label.datos.empresa" /></ins>
</h3>
<br>
<div class="form-group">
	<label class="control-label col-sm-3" for="nombreEmpresa">
		<s:text name="common.label.empresa.nombre" />: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" 
			id="nombreEmpresa"
			name="empresa.nombreEmpresa" 
			placeholder="Ingrese nombre Empresa"
			value='<s:property value="usuarioWeb.empresa.nombreEmpresa"/>'>
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="rut">
		<s:text name="common.label.empresa.rut" />: 
	</label>
	<div class="col-sm-5 campoValidado">
		<input type="text" class="form-control" 
			id="rut" name="empresa.rut"
			placeholder="Ingrese RUT Empresa"
			value='<s:property value="usuarioWeb.empresa.rut"/>'>
	</div>
	<label class="control-label col-sm-2" for="dv">
		<s:text name="common.label.dv" />: 
	</label>
	<div class="col-sm-2 campoValidado">
		<input type="text" class="form-control" 
			id="dv" name="empresa.rutDV"
			placeholder="DV"
			value='<s:property value="usuarioWeb.empresa.rutDV"/>'>
	</div>
</div>

<div class="form-group date-container">
	<label class="control-label col-sm-3" for="fechaFundacion">
		<s:text name="common.label.fecha.fundacion" />: 
	</label>
	<div class="col-sm-4 campoValidado">
		<input type="text" class="form-control" 
			id="fechaFundacion" 
			name="empresa.fechaOperaDesde" 
			autocomplete="off" 
			placeholder="Fecha de Fundacion"
			value='${fechaFundacionFormat}' />
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="desc_servicio">
		<s:text name="common.label.empresa.descripcion" />: 
	</label>
	<div class="col-sm-9 campoValidado">
		<textarea cols="9" rows="5" class="form-control" 
			id="desc_empresa"
			name="empresa.descripcion"
			placeholder="Ingrese la descripcion de la empresa (Mision y Vision)" >
		<s:property value="usuarioWeb.empresa.descripcion"/>
		</textarea>
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="vigente">
		<s:text name="common.label.vigente" />: 
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="vigente" 
			name="empresa.vigente"
			list="#request.vigencias" 
			headerKey="" 
			headerValue="Selecccione..."
			listKey="id" 
			listValue="descripcion"
			value="usuarioWeb.empresa.vigente" />
	</div>
</div>