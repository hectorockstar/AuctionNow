<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<br>
<h3>
	<ins><s:text name="title.label.datos.direccion" /></ins>
</h3>
<br>

<jsp:include page="../../../../pages/formularioPlantilla/filtro/comunes/baseFiltroRegionPorPais.jsp" />

<div class="form-group">
	<label class="control-label col-sm-3" for="calle">
		<s:text name="common.label.calle" />:
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" id="calle"
			name="direccion.calle" placeholder="Ingrese su calle">
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="numeracion">
		<s:text name="common.label.numeracion" />:
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" id="numeracion"
			name="direccion.numeracion" placeholder="Ingrese su Numeración">
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="deptoNro">
		<s:text name="common.label.nro.depto" />:
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" id="deptoNro"
			name="direccion.deptoNro" placeholder="Opcional">
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="piso">
		<s:text name="common.label.piso" />:
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" id="piso"
			name="direccion.piso" placeholder="Opcional">
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="codigoPostal">
		<s:text name="common.label.codigo.postal" />:
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" id="codigoPostal"
			name="direccion.codigoPostal" placeholder="Ingrese código postal">
	</div>
</div>
<div class="form-group">
	<label class="control-label col-sm-3" for="observacion">
		<s:text name="common.label.observaciones" />:
	</label>
	<div class="col-sm-9">
		<textarea cols="9" rows="5" class="form-control" id="observacion"
			name="direccion.observacion"
			placeholder="Ingrese una referencia a su direccion"></textarea>
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="tipoDireccion">
		<s:text name="common.label.tipo.direccion" />: 
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="tipoDireccion"
			name="direccion.tipoDireccion.id" list="#request.tipsDirecciones"
			headerKey="" headerValue="Selecccione..." listKey="id"
			listValue="descripcion" />
	</div>
</div>







