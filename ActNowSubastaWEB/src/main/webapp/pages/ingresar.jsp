<jsp:include page="../estructura/header-content.jsp" />

<div class="panel panel-default">
  <div class="panel-body">  	
  	
  	  <!--Inicio contenido dinámico-->
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<div class="well">
					<h3>Ingresa a la plataforma</h3><br>
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
		         	<div class="col-xs-6 text-left"> 				
						<p>¿No tiene cuenta? <a href="registro_usuario.jsp">Regístrese</a></p> 
					</div>  
				</div>
			</div>
		</div>
	</div>	
  	
  </div>
</div>  

<jsp:include page="../estructura/footer-content.jsp" />