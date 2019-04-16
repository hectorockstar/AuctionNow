

<div class="panel panel-default">
  <div class="panel-body">  	
  	
	<h3><ins>Detalle de la empresa e Informaci�n general<ins></h3><br>
   	<form action="" class="form-horizontal" id="formulario_registro_proveedor">
		<div class="form-group">
			<label class="control-label col-sm-3" for="nombreEmpresaProveedor" >Nombre Empresa: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="nombreEmpresaProveedor" name="txtNombreEmpresaProveedor" placeholder="Ingrese nombre de la empresa">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="rutEmpresaProveedor" >RUT: </label>
			<div class="col-sm-5 campoValidado">
				<input type="text" class="form-control" id="rutEmpresaProveedor" name="txtRutEmpresaProveedor" placeholder="Ingrese RUT">
			</div>
			<label class="control-label col-sm-2" for="dvProveedor" >DV: </label>
			<div class="col-sm-2 campoValidado">
				<input type="text" class="form-control" id="dvProveedor" name="txtDvProveedor" placeholder="DV">
			</div>
		</div>
		<div class="form-group date-container">
			<label class="control-label col-sm-3" for="fechaFundacionEmpresa">Fecha Creaci�n Empresa: </label>
			<div class="col-sm-4 campoValidado">
				<input type="text" class="form-control" id="fechaFundacionEmpresa" name="txtFechaFundacionEmpresa" placeholder="Ingrese fecha fundaci�n">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="correoElectronicoEmpresa" >Correo Electronico: </label>
			<div class="col-sm-9 campoValidado">
				<input type="email" class="form-control" id="correoElectronicoEmpresa" name="txtCorreoElectronicoEmpresa" placeholder="Ingrese su correo de contaco">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="nombreRepresentante" >Nombre Representante Empresa: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="nombreRepresentante" name="txtNombreRepresentante" placeholder="Ingrese el nombre del representante">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="tituloRepresentanteProveedor" >T�tulo (cargo) del Representante: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="tituloRepresentanteProveedor" name="txtTituloRepresentanteProveedor" placeholder="Ingrese el cargo del representante">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="paginaWebProveedor" >P�gina Web: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="paginaWebProveedor" name="txtPaginaWebProveedor" placeholder="http://www.ejemplo.cl (Opcional)">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="seviciosEmpresaProveedor" >Servicios de: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="seviciosEmpresaProveedor" name="txtSeviciosEmpresaProveedor" placeholder="Ingrese el servicio de su empresa">
			</div>
		</div>
		
		<h3><ins>Datos Login Proveedor</ins></h3><br>
		<div class="form-group">
			<label class="control-label col-sm-3" for="usernameProveedor" >Nombre Usuario: </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="usernameProveedor" name="txtUsernameProveedor" placeholder="Ingrese su nombre de usuario">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="pwd" >Contrase�a: </label>
			<div class="col-sm-9 campoValidado">
				<input type="password" class="form-control" id="pwdProveedor" name="txtPwdProveedor" placeholder="Ingrese su contrase�a">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="rePwdProveedor" >Repita Contrase�a: </label>
			<div class="col-sm-9 campoValidado">
				<input type="password" class="form-control" id="rePwdProveedor" name="txtRePwdProveedor" placeholder="Repita contrase�a">
			</div>
		</div>							
		
		<h3><ins>Datos Direcci�n Empresa</ins></h3><br>
		<div class="form-group">
			<label class="control-label col-sm-3" for="paisProveedor" >Pa�s: </label>
			<div class="col-sm-4 campoValidado">
				<select class="form-control" id="paisProveedor" name="cbbPaisProveedor">
				  <option value="">Seleccione...</option>
				  <option value="chile">Chile</option>
			  </select>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="regionProveedor" >Regi�n: </label>
			<div class="col-sm-4 campoValidado">
				<select class="form-control" id="regionProveedor" name="cbbRegionProveedor">
				  <option value="">Seleccione...</option>
			  </select>
			</div>
		</div>		
		<div class="form-group">
			<label class="control-label col-sm-3" for="ciudadProveedor" >Ciudad: </label>
			<div class="col-sm-4 campoValidado">
				<select class="form-control" id="ciudadProveedor" name="cbbCiudadProveedor">
				  <option value="">Seleccione...</option>
				</select>
			</div>
		</div>				
		<div class="form-group">
			<label class="control-label col-sm-3" for="comunaProveedor" >Comuna: </label>
			<div class="col-sm-4 campoValidado">
				<select class="form-control" id="comunaProveedor" name="cbbComunaProveedor">
				  <option value="">Seleccione...</option>
			  </select>
			</div>
		</div>																			
		<div class="form-group">
			<label class="control-label col-sm-3" for="direcci�nProveedor" >Direcci�n </label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="direcci�nProveedor" name="txtDireccionProveedor" placeholder="Ingrese su direcci�n de la empresa">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="calleProveedor" >Calle</label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="calleProveedor" name="txtCalleProveedor" placeholder="Ingrese su calle">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="codigoPostalProveedor" >C�digo Postal</label>
			<div class="col-sm-9 campoValidado">
				<input type="text" class="form-control" id="codigoPostalProveedor" name="txtCodigoPostalProveedor" placeholder="Ingrese c�digo postal">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="dptoOficina" >Dpto/Oficina</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="dptoOficina" placeholder="Opcional">
			</div>
		</div>
		
		<h3><ins>Fonos de Contacto</ins></h3><br>
		<div class="form-group">
			<label class="control-label col-md-3 col-xs-3" for="telefono1Proveedor" >Tel�fono 1: </label>
			<div class="col-md-3 col-xs-9 campoValidado">
				<input type="text" class="form-control" id="telefono1Proveedor" name="txtTelefono1Proveedor" placeholder="Ingrese su tel�fono 1">
			</div>
			<label class="control-label col-md-3 col-xs-3" for="telefono2Proveedor" >Tel�fono 2: </label>
			<div class="col-md-3 col-xs-9 campoValidado">
				<input type="text" class="form-control" id="telefono2Proveedor" name="txtTelefono2Proveedor" placeholder="Opcional">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-3 col-xs-3" for="movil1Proveedor" >M�vil 1: </label>
			<div class="col-md-3 col-xs-9 campoValidado">
				<input type="text" class="form-control" id="movil1Proveedor" name="txtMovil1Proveedor" placeholder="Ingrese su m�vil 1">
			</div>
			<label class="control-label col-md-3 col-xs-3" for="movil2Proveedor" >M�vil 2: </label>
			<div class="col-md-3 col-xs-9 campoValidado">
				<input type="text" class="form-control" id="movil2Proveedor" name="txtMovil2Proveedor" placeholder="Opcional">
			</div>
		</div>							
		
		<br>
		<div class="clearfix "></div>
		<div class="form-group">
			<div class="col-sm-offset-3">
				<button type="submit" class="btn btn-warning">Modificar</button>
			</div>						
		</div>
	</form>
	
  </div>
</div>  
