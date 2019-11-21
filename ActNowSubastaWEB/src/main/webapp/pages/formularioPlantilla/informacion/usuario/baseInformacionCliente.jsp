<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<br>
<h3>
	<ins>
		<s:text name="title.label.datos.cliente" />
	</ins>
</h3>
<br>
<div class="form-group">
	<label class="col-sm-4" for="nombreCliente"> 
		<s:text name="common.label.cliente.nombre" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="cliente.nombre" /> <s:property value="cliente.apellidoPaterno" /> <s:property value="cliente.apellidoMaterno" />
	</label>
	
</div>

<div class="form-group">
	<label class="col-sm-4" for="numeroDocumento"> 
		<s:text name="common.label.numero.documento" /> (R.U.T) :
	</label> 
	<label class="col-sm-8"> 
		<s:property value="cliente.rut" /> - <s:property value="cliente.rutDV" />
	</label>
</div>

<div class="form-group">
	<label class="col-sm-4" for="genero"> 
		<s:text name="common.label.genero" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="cliente.genero.descripcion" />
	</label>
</div>

<div class="form-group">
	<label class="col-sm-4" for="fechaNacimiento"> 
		<s:text name="common.label.fecha.nacimiento" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="cliente.fechaNacimiento" />
	</label>
</div>

<div class="form-group">
	<label class="col-sm-4" for="registradoDesde"> 
		<s:text name="common.label.registro.desde" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="cliente.fechaRegistro" />
	</label>
</div>

<s:hidden id="h_codigoCliente" value="cliente.codigoCliente" name="cliente.codigoCliente" />
