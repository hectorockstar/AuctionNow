<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<br>
<h3>
	<ins><s:text name="title.label.datos.contacto"/>:</ins>
</h3>
<br>

<div class="form-group">
	<label class="control-label col-sm-3" for="contacto"> 
		<s:text name="common.label.seleccione.direccion" />:
	</label>
	<div class="col-sm-9 campoValidado">
		<s:select class="form-control" id="tipoContacto"
			name="contacto.direccion.codigoDireccion" list="#request.direcciones"
			headerKey="" headerValue="Seleccione Dirección..." listKey="codigoDireccion"
			listValue="calle+' '+numeracion+', '+comuna.nombre+', '+comuna.ciudad.nombre+', '+comuna.ciudad.region.nombre+' - '+tipoDireccion.descripcion" />
	</div>
</div>

<div class="form-group">
	<label class="control-label col-md-3 col-xs-3" for="telefono1">
		<s:text name="common.label.telefono.fijo"/>:
	</label>
	<div class="col-md-3 col-xs-3 campoValidado">
		<input type="text" class="form-control" id="telefono1"
			name="contacto.telefono1" placeholder="Ingrese su teléfono">
	</div>
	<label class="control-label col-md-3 col-xs-3" for="movil1">
		<s:text name="common.label.telefono.movil"/>:
    </label>
	<div class="col-md-3 col-xs-3 campoValidado">
		<input type="text" class="form-control" id="movil1"
			name="contacto.movil1" placeholder="Ingrese su móvil">
	</div>
	<%-- <label class="control-label col-md-3 col-xs-3" for="telefono2">
		<s:text name="common.label.telefono.fijo"/> 2:
	</label>
	<div class="col-md-3 col-xs-3 campoValidado">
		<input type="text" class="form-control" id="telefono2"
			name="contacto.telefono2" placeholder="Ingrese su teléfono 2">
	</div> --%>
</div>

<%-- <div class="form-group">
	<label class="control-label col-md-3 col-xs-3" for="movil1">
		<s:text name="common.label.telefono.movil"/> 1:
    </label>
	<div class="col-md-3 col-xs-3 campoValidado">
		<input type="text" class="form-control" id="movil1"
			name="contacto.movil1" placeholder="Ingrese su móvil 1">
	</div>
	<label class="control-label col-md-3 col-xs-3" for="movil2">
		<s:text name="common.label.telefono.movil"/> 2:
    </label>
	<div class="col-md-3 col-xs-3 campoValidado">
		<input type="text" class="form-control" id="movil2"
			name="contacto.movil2" placeholder="Ingrese su móvil 2">
	</div>
</div> --%>

<div class="form-group">
	<label class="control-label col-sm-3" for="correo">
		<s:text name="common.label.email"/>:
	</label>
	<div class="col-sm-3 campoValidado">
		<input type="email" class="form-control" id="correo"
			name="contacto.email" placeholder="Ingrese su email">
	</div>
	<label class="control-label col-sm-3" for="contacto">
		<s:text name="common.label.tipo.contacto"/>: 
	</label>
	<div class="col-sm-3 campoValidado">
		<s:select class="form-control" id="tipoContacto"
			name="contacto.tipoContacto.id" list="#request.tipsContactos"
			headerKey="" headerValue="Selecccione..." listKey="id"
			listValue="descripcion" />
	</div>
</div>