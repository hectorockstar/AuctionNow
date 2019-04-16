<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<form action="" class="form-horizontal" id="formulario_update_direccion<s:property value='codigoDireccion' />" method="POST">
	
	<s:hidden value="%{prioridad}" name="direccion.prioridad" id="h_prioridad" />
	<s:hidden value="%{geoLocalizacion.idGeo}" name="direccion.geoLocalizacion.idGeo" id="h_geoLocalizacion" />
	<s:hidden value="%{codigoDireccion}" name="direccion.codigoDireccion" id="h_codigoDireccion" />
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="comuna">
			<s:text name="common.label.comuna" />: 
		</label>
		<div class="col-sm-4 campoValidado">
			<s:select class="form-control" id="comuna" 
				name="direccion.comuna.codigoComuna"
				list="#request.comunas" 
				headerKey="" 
				headerValue="Selecccione..."
				listKey="codigoComuna" 
				listValue="nombre"
				value="comuna.codigoComuna" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="calle<s:property value='codigoDireccion' />">
			<s:text name="common.label.calle" />:
		</label>
		<div class="col-sm-9 campoValidado">
			<input type="text" class="form-control" id="calle<s:property value='codigoDireccion' />"
				name="direccion.calle" placeholder="Ingrese su calle"
				value='<s:property value="calle"/>' >
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="numeracion<s:property value='codigoDireccion' />">
			<s:text name="common.label.numeracion" />:
		</label>
		<div class="col-sm-9 campoValidado">
			<input type="text" class="form-control" id="numeracion<s:property value='codigoDireccion' />"
				name="direccion.numeracion" placeholder="Ingrese su Numeración"
				value='<s:property value="numeracion"/>' >
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="deptoNro<s:property value='codigoDireccion' />">
			<s:text name="common.label.nro.depto" />:
		</label>
		<div class="col-sm-9 campoValidado">
			<input type="text" class="form-control" id="deptoNro<s:property value='codigoDireccion' />"
				name="direccion.deptoNro" placeholder="Opcional"
				value='<s:property value="deptoNro"/>' >
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="piso<s:property value='codigoDireccion' />">
			<s:text name="common.label.piso" />:
		</label>
		<div class="col-sm-9 campoValidado">
			<input type="text" class="form-control" id="piso<s:property value='codigoDireccion' />"
				name="direccion.piso" placeholder="Opcional"
				value='<s:property value="piso"/>' >
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="codigoPostal<s:property value='codigoDireccion' />">
			<s:text name="common.label.codigo.postal" />:
		</label>
		<div class="col-sm-9 campoValidado">
			<input type="text" class="form-control" id="codigoPostal<s:property value='codigoDireccion' />"
				name="direccion.codigoPostal" placeholder="Ingrese código postal"
				value='<s:property value="codigoPostal"/>' >
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="observacion">
			<s:text name="common.label.observaciones" />:
		</label>
		<div class="col-sm-9">
			<textarea cols="9" rows="5" class="form-control" id="observacion<s:property value='codigoDireccion' />"
				name="direccion.observacion"
				placeholder="Ingrese una referencia a su direccion">
				<s:property value="observacion"/>
			</textarea>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-sm-3" for="tipoDireccion<s:property value='codigoDireccion' />">
			<s:text name="common.label.tipo.direccion" />: 
		</label>
		<div class="col-sm-4 campoValidado">
			
			<s:select class="form-control"
				id='tipoDireccion%{codigoDireccion}'
				name="direccion.tipoDireccion.id" 
				list="#request.tipsDirecciones"
				headerKey="" 
				headerValue="Selecccione..." 
				listKey="id"
				listValue="descripcion"
				value="tipoDireccion.id"
				/>
		</div>
	</div>
	
	<div class="form-group">
		<input
			id="update_<s:property value='codigoDireccion' />"
			type="button" 
			class="btn btn-success"
			value='<s:text name="button.label.modificar" />' />
	</div>
	
</form>

<script type="text/javascript">
	$(function() {
		$("#update_<s:property value='codigoDireccion' />").click(function() {
			var formName = $(this).closest('form').attr('id');
			var formData = $('#'+formName).serialize();

			$.ajax({
	          type: "POST",
	          url: "actualizaDireccion.action",
	          data: formData,
	          success: function(response) {
							
				  }
		      });
		});   
	});
</script>