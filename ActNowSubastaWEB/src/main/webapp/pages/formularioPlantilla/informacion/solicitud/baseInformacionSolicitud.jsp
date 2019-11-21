<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>
<br>
<h3>
	<ins>
		<s:text name="title.label.datos.solicitud" />
	</ins>
</h3>
<br>

<c:choose>
   <c:when test = "${subasta.solicitud.tipoFecha.id == 'RAN'}">
      	<div class="form-group">
			<label class="col-sm-4" for="fechaServicioDesde"> 
				<s:text name="common.label.fecha.servicio.desde" />:
			</label> 
			<label class="col-sm-8"> 
				<s:property value="solicitud.fechaServicioDesde" />
			</label>
			
		</div>
		
		<div class="form-group">
			<label class="col-sm-4" for="fechaServicioHasta"> 
				<s:text name="common.label.fecha.servicio.hasta" />:
			</label> 
			<label class="col-sm-8"> 
				<s:property value="solicitud.fechaServicioHasta" />
			</label>
			
		</div>
   </c:when>
	<c:otherwise>
	    <div class="form-group">
			<label class="col-sm-4" for="fechaEntregaServicio"> 
			<s:text name="common.label.fecha.servicio" />:
		</label> 
		<label class="col-sm-8"> 
			<s:property value="solicitud.fechaEntregaServicio" /> 
		</label>
		</div>
	</c:otherwise>
</c:choose>
      




<div class="form-group">
	<label class="col-sm-4" for="rangoHorario"> 
		<s:text name="common.label.rango.horario" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="solicitud.horarioDesde" /> - <s:property value="solicitud.horarioHasta" /> 
	</label>
	
</div>




<div class="form-group">
	<label class="col-sm-4" for="fechaVencimientoSubasta"> 
		<s:text name="common.label.fecha.vencimiento.subasta" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="solicitud.fechaVencimientoSubasta" /> 
	</label>
	
</div>

<div class="form-group">
	<label class="col-sm-4" for="fechaCreacionSolicitud"> 
		<s:text name="common.label.fecha.solicitud" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="solicitud.fechaCreacion" /> 
	</label>
	
</div>

<div class="form-group">
	<label class="col-sm-4" for="precioEsperado"> 
		<s:text name="common.label.precio.esperado" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="solicitud.precioEsperado" /> 
	</label>
	
</div>

<div class="form-group">
	<label class="col-sm-4" for="valoracion"> 
		<s:text name="common.label.valoracion.desde" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="solicitud.valoracion" /> 
	</label>
	
</div>

<div class="form-group">
	<label class="col-sm-4" for="nombreServicio"> 
		<s:text name="common.label.nombre.servicio" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="solicitud.servicio.nombre" />  
	</label>
	
</div>

<div class="form-group">
	<label class="col-sm-4" for="descripcionSolicitud"> 
		<s:text name="common.label.solicitud.descripcion" />:
	</label> 
	<label class="col-sm-8"> 
		<s:property value="solicitud.descripcion" />  
	</label>
	
</div>

<s:hidden id="h_codigoServcio" value="solicitud.servicio.codigoServicio" name="servcio.codigoServicio" />


<!-- FICHA CLIENTE Accordeon -->