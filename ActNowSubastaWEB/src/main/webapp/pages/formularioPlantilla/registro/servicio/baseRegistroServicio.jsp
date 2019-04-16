<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<div class="form-group">
	<label class="control-label col-sm-3" for="nombre">
		<s:text name="common.label.nombre.servicio" />: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" id="nombre"
			name="servicio.nombre" placeholder="Ingrese nombre del Servicio">
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="sigla">
		<s:text name="common.label.sigla" />: 
	</label>
	<div class="col-sm-9 campoValidado">
		<input type="text" class="form-control" id="sigla"
			name="servicio.sigla" placeholder="Ingrese Sigla del Servicio">
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="desc_servicio">
		<s:text name="common.label.descripcion" />: 
	</label>
	<div class="col-sm-9 campoValidado">
		<textarea cols="9" rows="5" class="form-control" id="desc_servicio"
			name="servicio.descripcion"
			placeholder="Ingrese la descripcion del Servicio"></textarea>
	</div>
</div>

<div class="form-group">
	<label class="control-label col-sm-3" for="tipoServicio">
		<s:text name="common.label.tipo.servicio" />: 
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="tipoServicio"
			name="servicio.tipoServicio.id" list="#request.tipsServicios"
			headerKey="" headerValue="Selecccione..." listKey="id"
			listValue="descripcion" />
	</div>
</div>