<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<br>
<h3>
	<ins>
		<s:text name="title.label.datos.empresa" />
	</ins>
</h3>
<br>
<div class="form-group">
	<label class="control-label col-sm-5" for="nombreEmpresa"> <s:text
			name="common.label.empresa.nombre" />:
	</label> 
	<label class="control-label col-sm-7"> 
		<s:property value="usuarioWeb.empresa.nombreEmpresa" />
	</label>
	<s:hidden id="h_nombreEmpresa" value="usuarioWeb.empresa.nombreEmpresa" name="empresa.nombreEmpresa" />
</div>

<div class="form-group">
	<label class="control-label col-sm-5" for="rut"> <s:text
			name="common.label.empresa.rut" />:
	</label> 
	<label class="control-label col-sm-7"> 
		<s:property value="usuarioWeb.empresa.rut" />-
		<s:property value="usuarioWeb.empresa.rutDV" />
	</label>
	<s:hidden id="h_rutEmpresa" value="usuarioWeb.empresa.rut" name="empresa.rut" />
	<s:hidden id="h_rutDVEmpresa" value="usuarioWeb.empresa.rutDV" name="empresa.rutDV" />
</div>


<div class="form-group">
	<label class="control-label col-sm-5" for="fechaFundacion"> <s:text
			name="common.label.fecha.fundacion" />:
	</label> 
	<label class="control-label col-sm-7"> 
		${fechaFundacionFormat}
	</label>
	<s:hidden id="h_fechaFundacionEmpresa" value="usuarioWeb.empresa.fechaOperaDesde" name="empresa.fechaOperaDesde" />
</div>


<div class="form-group">
	<label class="control-label col-sm-5" for="desc_servicio"> <s:text
			name="common.label.empresa.descripcion" />:
	</label> 
	<label class="control-label col-sm-7"> 
		<s:property value="usuarioWeb.empresa.descripcion" />
	</label>
	<s:hidden id="h_descripcionEmpresa" value="usuarioWeb.empresa.descripcion" name="empresa.descripcion" />
</div>


<div class="form-group">
	<label class="control-label col-sm-5" for="vigente"> <s:text
			name="common.label.vigente" />:
	</label> 
	<label class="control-label col-sm-7"> 
		<s:property value="usuarioWeb.empresa.vigente" />
	</label>
	<s:hidden id="h_vigenteEmpresa" value="usuarioWeb.empresa.vigente" name="empresa.vigente" />
</div>
