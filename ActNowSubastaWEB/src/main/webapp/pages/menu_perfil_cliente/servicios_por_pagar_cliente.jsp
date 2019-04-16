<%-- <jsp:include page="../estructura/header-content.jsp" /> --%>

<div class="panel panel-default">
  <div class="panel-body">  	
  	
	<!--Inicio contenido dinámico-->	
  	  <div class="table-responsive">
		<table class="table table-bordered table-striped table-hover">
		    <thead>
		      <tr>
		      	<th></th>
		        <th>Estado Transacción</th>
		        <th>Proveedor</th>
		        <th>Fecha Publicación</th>
		        <th>Monto Oferta</th>
		        <th colspan="2"></th>
		        
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <td><input type="checkbox" name="chkSolicitud" /></td>
		        <td><label>ESTADO TRANSACCION</label></td>
		        <td><label>PROVEEDOR</label></td>
		        <td><label>FECHA PUBLICACION</label></td>
		        <td><label>MONTO OFERTA</label></td>
		        <!-- <td><label><a href="menu_perfil/detalle_registro_solicitud.jsp">Detalle Transacción</a></label></td> -->		        
		        <td><label><a onclick="javascript:verVistasDetalles(0,'../pop-ups/detalle_pago_servicio.jsp');" href="#">Detalle Transacción</a></label></td>
		      </tr>				      
		    </tbody>
		  </table>
		</div>
		<button type="button" class="btn btn-danger">Eliminar de mi historial</button>
  	
  </div>
</div>  

<%-- <jsp:include page="../estructura/footer-content.jsp" /> --%>