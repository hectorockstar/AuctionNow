<%@ page contentType = "text/html;charset=windows-1252" %>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<br>
<div id="divServicios" class="table-responsive">

	<s:iterator value="#request.serviciosEmpresa">
		<form id="formS<s:property value='codigoServicio' /><s:property value='empresa.codigoEmpresa' />" action=""  > 
			<s:hidden value="%{codigoServicio}" 	   name="servicio.codigoServicio" />
			<s:hidden value="%{empresa.codigoEmpresa}" name="empresa.codigoEmpresa" />
			
			<s:hidden id="h_activo%{codigoServicio}%{empresa.codigoEmpresa}"           name="servicio.activo" />
			<s:hidden id="h_prioridad%{codigoServicio}%{empresa.codigoEmpresa}"        name="servicio.prioridad" />
			<s:hidden id="h_fechaOperaDesde%{codigoServicio}%{empresa.codigoEmpresa}"  name="servicio.operaServicioDesde" />
			
		</form>
	</s:iterator>

<table class="table table-condensed table-bordered table-hover" >
	<thead>
		<tr>
			<td><s:text name="common.label.sigla" /></td>
			<td><s:text name="common.label.nombre.servicio" /></td>
			<td><s:text name="common.label.tipo.servicio" /></td>
			<td><s:text name="common.label.descripcion" /></td>
			<td><s:text name="common.label.se.registro" /></td>
			<td><s:text name="common.label.opera.servicio" />, <s:text name="common.label.desde" /></td>
			<td><s:text name="common.label.prioridad" /></td>
			<td><s:text name="common.label.vigente" /></td>
			<td><s:text name="common.label.eliminar" /></td>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="#request.serviciosEmpresa">
			<tr>
				<td><s:property value="sigla" /></td>
				<td><s:property value="nombre" /></td>
				<td><s:property value="tipoServicio.descripcion" /></td>
				<td><s:property value="descripcion" /></td>
				<td><s:property value="fechaRegistroWeb" /></td>
				<td>
					
						<input type="text" class="form-control" id="tf_fechaOpera<s:property value='codigoServicio' /><s:property value='empresa.codigoEmpresa' />"
							name="servicio.operaServicioDesde"
							value="<s:property value="operaServicioDesde" />">
				
				</td>
				<td><input type="text" class="form-control" value="<s:property value="prioridad" />" id="tf_prioridad<s:property value='codigoServicio' /><s:property value='empresa.codigoEmpresa' />" maxlength="1" > </td>
				<td><input type="text" class="form-control" value="<s:property value='activo' />" id="tf_activo<s:property value='codigoServicio' /><s:property value='empresa.codigoEmpresa' />" maxlength="1" > </td>
				<td><input
					id="buttonS<s:property value='codigoServicio' /><s:property value='empresa.codigoEmpresa' />"
					type="button" 
					class="btn btn-success"
					value='<s:text name="button.label.modificar" />' />
				</td>
			</tr>
			
			<script type="text/javascript">
				$(function() {
					$("#buttonS<s:property value='codigoServicio' /><s:property value='empresa.codigoEmpresa' />").click(function() {
						var activoTF = document.getElementById("tf_activo<s:property value='codigoServicio' /><s:property value='empresa.codigoEmpresa' />").value;
						document.getElementById("h_activo<s:property value='codigoServicio' /><s:property value='empresa.codigoEmpresa' />").value = activoTF;
						
						var prioridadTF = document.getElementById("tf_prioridad<s:property value='codigoServicio' /><s:property value='empresa.codigoEmpresa' />").value;
						document.getElementById("h_prioridad<s:property value='codigoServicio' /><s:property value='empresa.codigoEmpresa' />").value = prioridadTF;
						
						var fechaOperaTF = document.getElementById("tf_fechaOpera<s:property value='codigoServicio' /><s:property value='empresa.codigoEmpresa' />").value;
						document.getElementById("h_fechaOperaDesde<s:property value='codigoServicio' /><s:property value='empresa.codigoEmpresa' />").value = fechaOperaTF;
							
						var formData = $("#formS<s:property value='codigoServicio' /><s:property value='empresa.codigoEmpresa' />").serialize(); //get all data from form
						//var formData = $("#formS").serialize();
						$.ajax({
				          type: "POST",
				          url: "actualizaServicioEmpresa.action",
				          data: formData,
				          success: function(response) {
										alert("Listo");
							  		}
					      });
					});   
				});
			</script>	
		</s:iterator>
	</tbody>
</table>
</div>
<br>
