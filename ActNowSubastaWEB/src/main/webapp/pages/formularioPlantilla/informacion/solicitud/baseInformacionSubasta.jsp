<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<br>
<h3>
	<ins>
		<s:text name="title.label.datos.subasta" />
	</ins>
</h3>
<br>
<div class="form-group">
	<label class="col-sm-4" for="estadoSubasta"> 
		<s:text name="common.label.estado.subasta" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="subasta.estadoSubasta" />
	</label>
</div>

<div class="form-group">
	<label class="col-sm-4" for="fechaSubastaDesde"> 
		<s:text name="common.label.fecha.subasta.desde" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="subasta.fechaSubastaDesde" /> <s:property value="subasta.horaInicioSubasta" /> 
	</label>
</div>

<div class="form-group">
	<label class="col-sm-4" for="fechaSubastaHasta"> 
		<s:text name="common.label.fecha.subasta.hasta" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="subasta.fechaSubastaHasta" /> <s:property value="subasta.horaTerminoSubasta" /> 
	</label>
</div>

<div class="form-group">
	<label class="col-sm-4" for="duracionSubasta"> 
		<s:text name="common.label.duracion" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="subasta.duracion" /> 
	</label>
</div>

<div class="form-group">
	<label class="col-sm-4" for="participantesSubasta"> 
		<s:text name="common.label.cantidad.participantes" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="subasta.cantidadExtensiones" /> 
	</label>
</div>

<div class="form-group">
	<label class="col-sm-4" for="montoMinimo"> 
		<s:text name="common.label.monto.minimo" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="subasta.montoMinimo" /> 
	</label>
</div>

<div class="form-group">
	<label class="col-sm-4" for="montoInicial"> 
		<s:text name="common.label.monto.inicial" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="subasta.montoInicial" /> 
	</label>
</div>

<div class="form-group">
	<label class="col-sm-4" for="montoFinal"> 
		<s:text name="common.label.monto.final" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="subasta.montoFinal" /> 
	</label>
</div>

