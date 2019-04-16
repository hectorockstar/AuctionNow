<!-- JQUERY -->
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<!-- JQUERY validate -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="../utils/validate/jquery.validate.js"></script>
<script src="../utils/validate/messages/messages_es.js"></script>
<script src="../utils/validar_campos_formularios.js"></script>

<!-- JQUERY rateYo -->
<script src="../utils/rateYo/js/jquery.rateyo.js"></script>
<script src="../utils/ranking_estrellas.js"></script>

<!-- JQUERY Steps -->
<!-- <script src="../utils/jquery-steps/js/jquery.steps.js"></script> -->
<script src="../utils/bootstrap-steps.js"></script>

<!-- JAVASCRIPT -->
<script src="../utils/jquery.min.js"></script>

<!-- BOOTSTRAP -->
<script src="../utils/bootstrap/js/bootstrap.min.js"></script>

<!-- ESTILOS -->
<link rel="stylesheet" href="../utils/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../utils/datepicker/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="../utils/rateYo/css/jquery.rateyo.min.css">
<link rel="stylesheet" href="../utils/timepicker/css/jquery.timepicker.css">
<!-- <link rel="stylesheet" href="../utils/jquery-steps/css/jquery.steps.css">
<link rel="stylesheet" href="../utils/jquery-steps/css/main.css"> -->
<link rel="stylesheet" href="../utils/bootstrap/css/bootstrap-theme-steps.css">
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!-- DATEPICKER -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

<style>
	body {
		padding-top: 70px;
	}
</style>

<!-- DATEPICKER FUNCTION -->
<script>
    $(document).ready(function() {
    	$('#fechaNacimiento').bind('click', function (){
    		setDatePicker('fechaNacimiento');
    	});
    	$('#fechaNacimiento').click();
    	
    	$('#fechaFundacion').bind('click', function (){
    		setDatePicker('fechaFundacion');
    	});
    	$('#fechaFundacion').click();
    	
    	console.log('Init Config');
    });
    
    function setDatePicker(inputId){
        var date_input=$('#'+inputId); //our date input has the name "date"
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
        var options={
          format: 'dd/mm/yyyy',
          container: container,
          todayHighlight: true,
          autoclose: true,
        };
        date_input.datepicker(options);
    }
</script>

<!-- FUNCIONES -->
<script text="type/javascript">
	function verVistasDetalles(trx, pagina) {
		var ancho = 1000;
		var alto = 600;
		var posicion_x;
		var posicion_y;
		posicion_x = (screen.width / 2) - (ancho / 2);
		posicion_y = (screen.height / 2) - (alto / 2);

		window.open(pagina + "?trx=" + trx, "VistasDetalles", "height=" + alto
				+ ",width=" + ancho
				+ ",menubar=no,toolbar=no,tittlebar=no,left=" + posicion_x
				+ ",top=" + posicion_y + "");
	}

	function msgOfertarSubasta() {
		if (confirm('¿Esta seguro que desea realizar la Oferta?')) {
			return true;
		} else {
			return false;
		}

	}

	function msgPagarServicio() {
		if (confirm('¿Esta seguro que desea realizar el pago del servicio?')) {
			return true;
		} else {
			return false;
		}

	}

	
</script>




