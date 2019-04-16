<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld" %>
<div class="panel panel-default">
  <div class="panel-body">  	
  	
  	  <!--Inicio contenido dinámico-->	
  	  <div class="table-responsive">
		<table class="table table-bordered table-striped table-hover">
		    <thead>
		      <tr>
		      	<th></th>
		      	<th>Codigo Solicitud</th>
		        <th>Estado Solicitud</th>
		        <th>Cliente</th>
		        <th>Fecha Publicación</th>
		        <th>Monto Dispuesto a pagar</th>
		        <th colspan="2"></th>
		        
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <td><input type="checkbox" name="chkSolicitud" /></td>
		        <td><label>SOL0002</label></td>
		        <td><label>Colocada</label></td>
		        <td><label>hector alejandro gonzalez tapia</label></td>
		        <td><label>26/11/2016</label></td>
		        <td><label>30000</label></td>
		        <!-- <td><label><a href="menu_perfil/detalle_registro_solicitud.jsp">Detalle Transacción</a></label></td> -->		        
		        <td><label><a onclick="javascript:verVistasDetalles(0,'../pop-ups/detalle_registro_solicitud.jsp');" href="<s:url action="showDetalleSolicitud"/>">Detalle Transacción</a></label></td>
		      </tr>				      
		    </tbody>
		  </table>
		</div>
		<button type="button" class="btn btn-warning">Ignorar Solicitud</button>
  </div>
</div>  