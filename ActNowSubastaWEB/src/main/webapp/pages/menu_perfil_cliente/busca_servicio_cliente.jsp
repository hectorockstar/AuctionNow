<div class="panel panel-default">
  <div class="panel-body">  	
  	
  	  <!--Inicio contenido dinámico-->
		<div class="col-sm-12">
			<form action="" class="form-horizontal" id="formulario_buscar_servicio">
				<div class="form-group">
					<label class="control-label col-sm-3" for="categoriaServicio" >Categoría Servicio: </label>
					<div class="col-sm-6">
						<select class="form-control" id="categoriaServicio" name="cbbCategoriaServicio">
						  <option value="">Seleccione...</option>
					  </select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="tipoServicio" >Tipo Servicio: </label>
					<div class="col-sm-6 ">
						<select class="form-control" id="tipoServicio" name="cbbTipoServicio">
						  <option value="">Seleccione...</option>
					  </select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="regionServicio" >Región: </label>
					<div class="col-sm-6 ">
						<select class="form-control" id="regionServicio" name="cbbRegionServicio">
						  <option value="">Seleccione...</option>
					  </select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="comunaServicio" >Comuna Servicio: </label>
					<div class="col-sm-6 ">
						<select class="form-control" id="comunaServicio" name="cbbComunaServicio">
						  <option value="">Seleccione...</option>
					  </select>
					</div>
				</div>
				<div class="form-group">
				  <label class="control-label col-sm-3" for="">Rango (KMS) para tu busqueda:</label>				  
				  <div class="col-sm-1">
				  	 <label class="control-label" for="desdeRango">Desde:</label>
				  </div>
				  <div class="col-sm-2">
				  	<input type="text" class="form-control" id="desdeRango" name="txtRangoDesde" placeholder="">
				  </div>				  				  
				  <div class="col-sm-1">
				  	 <label class="control-label" for="hastaRango">Hasta:</label>
				  </div>
				  <div class="col-sm-2">
				  	<input type="text" class="form-control" id="hastaRango" name="txtRangoHasta" placeholder="">
				  </div>				  				  				  
				</div>
				
				<br>
				<div class="form-group">
					<div class="col-sm-offset-7">
						<button type="submit" class="btn btn-success">Voy a tener suerte</button>
					</div>						
				</div>							
			</form>
	  	</div>	
		
		<script>
			$(document).ready(function(){	
				$("#formulario_buscar_servicio").on("submit", function(e) {
				    var url = "menu_perfil/resultados_busqueda_servicio.jsp"; // the script where you handle the form input.

				    $.ajax({
				           type: "POST",
				           url: url,
				           data: $("#formulario_buscar_servicio").serialize(), // serializes the form's elements.
				           success: function(data){
				               //alert(data); // show response from the script.
				               $( ".col-sm-12" ).html( data );				      			        
				           }
				         });
				    e.preventDefault(); // avoid to execute the actual submit of the form.
				});			
			});
		</script>
	  	
  </div>
</div>