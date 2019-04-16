<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<div class="form-group">
	<label class="control-label col-sm-3" for="servicio"> 
		<s:text name="control.label.seleccione.servicio" />:
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="servicio"
			name="servicio.codigoServicio" list="#request.servicios" headerKey=""
			headerValue="Selecccione..." listKey="codigoServicio"
			listValue="nombre" />
	</div>
</div>