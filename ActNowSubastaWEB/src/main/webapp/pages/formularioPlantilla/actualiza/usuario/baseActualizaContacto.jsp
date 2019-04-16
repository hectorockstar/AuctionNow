<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<form action="" class="form-horizontal" id="formulario_update_contacto<s:property value='codigoContacto' />" method="POST">
	
	<s:hidden value="%{prioridad}" name="contacto.prioridad" id="h_prioridad" />
	<s:hidden value="%{codigoContacto}" name="contacto.codigoContacto" id="h_codigoContacto" />
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="correo<s:property value='codigoContacto' />">
			<s:text name="common.label.email"/>:
		</label>
		<div class="col-sm-9 campoValidado">
			<input type="email" class="form-control" id="correo<s:property value='codigoContacto' />"
				name="contacto.email" placeholder="Ingrese su email"
				value='<s:property value="email"/>'>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-3 col-xs-3" for="telefono1<s:property value='codigoContacto' />">
			<s:text name="common.label.telefono.fijo"/> 1:
		</label>
		<div class="col-md-3 col-xs-9 campoValidado">
			<input type="text" class="form-control" id="telefono1<s:property value='codigoContacto' />"
				name="contacto.telefono1" placeholder="Ingrese su teléfono 1"
				value='<s:property value="telefono1"/>'>
		</div>
		<label class="control-label col-md-3 col-xs-3" for="telefono2<s:property value='codigoContacto' />">
			<s:text name="common.label.telefono.fijo"/> 2:
		</label>
		<div class="col-md-3 col-xs-9 campoValidado">
			<input type="text" class="form-control" id="telefono2<s:property value='codigoContacto' />"
				name="contacto.telefono2" placeholder="Ingrese su teléfono 2"
				value='<s:property value="telefono2"/>'>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-3 col-xs-3" for="movil1<s:property value='codigoContacto' />">
			<s:text name="common.label.telefono.movil"/> 1:
	    </label>
		<div class="col-md-3 col-xs-9 campoValidado">
			<input type="text" class="form-control" id="movil1<s:property value='codigoContacto' />"
				name="contacto.movil1" placeholder="Ingrese su móvil 1"
				value='<s:property value="movil1"/>'>
		</div>
		<label class="control-label col-md-3 col-xs-3" for="movil2<s:property value='codigoContacto' />">
			<s:text name="common.label.telefono.movil"/> 2:
	    </label>
		<div class="col-md-3 col-xs-9 campoValidado">
			<input type="text" class="form-control" id="movil2<s:property value='codigoContacto' />"
				name="contacto.movil2" placeholder="Ingrese su móvil 2"
				value='<s:property value="movil2"/>'>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="contacto">
			<s:text name="common.label.tipo.contacto"/>: 
		</label>
		<div class="col-sm-4 campoValidado">
			<s:select class="form-control" id="tipoContacto"
				name="contacto.tipoContacto.id" 
				list="#request.tipsContactos"
				headerKey="" 
				headerValue="Selecccione..." 
				listKey="id"
				listValue="descripcion"
				value="tipoContacto.id" />
		</div>
	</div>
	
	<div class="form-group">
		<input
			id="update_<s:property value='codigoContacto' />"
			type="button" 
			class="btn btn-success"
			value='<s:text name="button.label.modificar" />' />
	</div>
	
</form>

<script type="text/javascript">
	$(function() {
		$("#update_<s:property value='codigoContacto' />").click(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize();

			$.ajax({
	          type: "POST",
	          url: "actualizaContacto.action",
	          data: formData,
	          success: function(response) {
							
				  }
		      });
		});   
	});
</script>