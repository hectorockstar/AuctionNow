
<div class="panel panel-default">
  <div class="panel-body">  	
  	
  	  <!--Inicio contenido dinámico-->	
  	  <div class="table-responsive">
		<table class="table table-bordered table-striped table-hover">
		    <thead>
		      <tr>
		        <th>Estado Solicitud</th>
		        <th>Servicio</th>
		        <th>Fecha Creación</th>
		        <th>Prioridad</th>
		        <th colspan="2">Cantidades Participantes</th>
		        
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <td><input type="checkbox" name="chkSolicitud" /></td>
		        <td><label>SERVICIO</label></td>
		        <td><label>FECHA</label></td>
		        <td><label>PRIORIDAD</label></td>
		        <td><label>NRO PARTICIPANTES</label></td>
		        <!-- <td><label><a href="">Detalle Solicitud</a></label></td> -->
		         <td><label><a onclick="javascript:verVistasDetalles(0,'../pop-ups/detalle_solicitud_usuario.jsp');" href="#">Detalle Solicitud</a></label></td>
		      </tr>				      
		    </tbody>
		  </table>
		</div>
		<button type="button" class="btn btn-warning">Anular Solicitud</button>
  </div>
</div>  