  <!-- Modal -->
  <div class="modal fade" id="loginModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Ingrese a nuestra plataforma</h4>
        </div>
        <div class="row">
        	<div class="col-sm-9 left-col">
        		<div class="modal-body">
		         	<form action="loginUser" method="post" id="formulario_ingreso_usuarios">
		         		<div class="form-group">
						  <label for="username">Usuario:</label>
						  <div class="campoValidado">
						  	<input type="text" class="form-control" id="userName" name="userName" placeholder="Ingrese su nombre de usuario">
						  </div>	
						</div>
						<div class="form-group">
						  <label for="password">Contraseña:</label>
						  <div class="campoValidado">
						  	<input type="password" class="form-control" id="password" name="password" placeholder="Ingrese una contraseña">
						  </div>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-success">Iniciar Sesión</button>
						</div>							   	          		         				
		         	</form>
        		</div>
        	</div>
        </div>        
        <div class="modal-footer">
			<div class="col-xs-6 text-left"> 				
				<p>¿No tiene cuenta? <a href="registro_usuario.jsp">Regístrese</a></p> 
			</div>          	          		         		
			<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>				          	     
        </div>
      </div>
      
    </div>
  </div>