  <!-- Modal -->
  <div class="modal fade" id="ofertarSubasta" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Subastar</h4>
        </div>
        <div class="row">
        	<div class="col-sm-12">
        		<div class="modal-body">
        			<form action="" method="post" onSubmit="return msgOfertarSubasta();">
        				<div class="form-group">
							<label class="control-label col-md-4" for="montoOferta" >Monto Oferta: </label>
							<div class="col-md-4">
								<input type="text" class="form-control" id="montoOferta" name="" placeholder="$">					
							</div>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-success">Ofertar</button>
						</div>				
        			</form>
        		</div>        		        		        
        	</div>        	
        </div>        
        <div class="modal-footer">         	          		         		
			<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>				          	     
        </div>
      </div>
      
    </div>
  </div>