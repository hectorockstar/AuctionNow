<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<div class="form-group">
	<label class="control-label col-sm-3" for="comuna<s:property value='codigoDireccion' />">
		<s:text name="common.label.comuna" />: 
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="comuna<s:property value='codigoDireccion' />"
			name="direccion.comuna.codigoComuna" 
			list="#request.comunas"
			headerKey="" 
			headerValue="Selecccione..." 
			listKey="codigoComuna"
			listValue="nombre" />
	</div>
</div>