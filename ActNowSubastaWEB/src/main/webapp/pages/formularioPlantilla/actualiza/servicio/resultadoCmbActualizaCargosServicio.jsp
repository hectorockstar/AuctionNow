<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<div class="form-group">
	<label class="control-label col-sm-3" for="cargosServicio"> 
		<s:text name="common.label.cargo" />:
	</label>
	<div class="col-sm-4 campoValidado">
		<s:select class="form-control" id="cargosServicio"
			name="cargo.codigoCargo" list="#request.cargosServicio" headerKey=""
			headerValue="Selecccione..." listKey="codigoCargo"
			listValue="nombre" />
	</div>
</div>