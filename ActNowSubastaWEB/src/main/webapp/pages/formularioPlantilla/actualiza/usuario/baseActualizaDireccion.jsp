<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<button class="accordion">
<label class="control-label col-sm-2" >
	<s:property value="calle" /> <s:property value="numeracion" />
</label></button>
<div class="panelAccordion">
	<div class="containAddressAccordion">
		<form action="" class="form-horizontal" id="formulario_update_direccion<s:property value='codigoDireccion' />" method="POST">
			
			<s:hidden value="%{prioridad}" name="direccion.prioridad" id="h_prioridad" />
			<s:hidden value="%{geoLocalizacion.idGeo}" name="direccion.geoLocalizacion.idGeo" id="h_geoLocalizacion" />
			<s:hidden value="%{codigoDireccion}" name="direccion.codigoDireccion" id="h_codigoDireccion" />
			
			<%-- <jsp:include page="../../../../pages/formularioPlantilla/filtro/comunes/baseActualizaFiltroRegionPorPais.jsp" /> --%>
			
			<div class="form-group">
				<label class="control-label col-sm-3" for="comuna<s:property value='codigoDireccion' />">
					<s:text name="common.label.comuna" />: 
				</label>
				<div class="col-sm-4 campoValidado">
					<s:select class="form-control" id="comuna%{codigoDireccion}"
						name="direccion.comuna.codigoComuna" 
						list="#request.comunas"
						headerKey="" 
						headerValue="Selecccione..." 
						listKey="codigoComuna"
						listValue="nombre" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="calle<s:property value='codigoDireccion' />">
					<s:text name="common.label.calle" />:
				</label>
				<div class="col-sm-3 campoValidado">
					<input type="text" class="form-control" id="calle<s:property value='codigoDireccion' />"
						name="direccion.calle" placeholder="Ingrese su calle"
						value='<s:property value="calle"/>' >
				</div>
				<label class="control-label col-sm-2" for="numeracion<s:property value='codigoDireccion' />">
					<s:text name="common.label.numeracion" />:
				</label>
				<div class="col-sm-3 campoValidado">
					<input type="text" class="form-control" id="numeracion<s:property value='codigoDireccion' />"
						name="direccion.numeracion" placeholder="Ingrese su Numeración"
						value='<s:property value="numeracion"/>' >
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="deptoNro<s:property value='codigoDireccion' />">
					<s:text name="common.label.nro.depto" />:
				</label>
				<div class="col-sm-3 campoValidado">
					<input type="text" class="form-control" id="deptoNro<s:property value='codigoDireccion' />"
						name="direccion.deptoNro" placeholder="Opcional"
						value='<s:property value="deptoNro"/>' >
				</div>
				
				<label class="control-label col-sm-2" for="piso<s:property value='codigoDireccion' />">
					<s:text name="common.label.piso" />:
				</label>
				<div class="col-sm-3 campoValidado">
					<input type="text" class="form-control" id="piso<s:property value='codigoDireccion' />"
						name="direccion.piso" placeholder="Opcional"
						value='<s:property value="piso"/>' >
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="codigoPostal<s:property value='codigoDireccion' />">
					<s:text name="common.label.codigo.postal" />:
				</label>
				<div class="col-sm-3 campoValidado">
					<input type="text" class="form-control" id="codigoPostal<s:property value='codigoDireccion' />"
						name="direccion.codigoPostal" placeholder="Ingrese código postal"
						value='<s:property value="codigoPostal"/>' >
				</div>
				
				<label class="control-label col-sm-2" for="tipoDireccion<s:property value='codigoDireccion' />">
					<s:text name="common.label.tipo.direccion" />: 
				</label>
				<div class="col-sm-3 campoValidado">
					
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
				<label class="control-label col-sm-2" for="observacion">
					<s:text name="common.label.observaciones" />:
				</label>
				<div class="col-sm-8">
					<textarea cols="9" rows="6" class="form-control" id="observacion<s:property value='codigoDireccion' />"
						name="direccion.observacion"
						placeholder="Ingrese una referencia a su direccion">
						<s:property value="observacion"/>
					</textarea>
				</div>
			</div>
			
			<div class="form-group col-sm-10" style="margin-left: 10px;">
				<input
					id="update_<s:property value='codigoDireccion' />"
					type="button" 
					class="btn btn-success btn-modificarDireccion" 
					value='<s:text name="button.label.modificar" />' />
			</div>
			
		</form>
	</div>
</div>

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
