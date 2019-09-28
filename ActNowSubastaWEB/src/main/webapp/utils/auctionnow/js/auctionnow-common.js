$(document).ready(function() {
	$('#fechaNacimiento').bind('click', function() {
		setDatePicker('fechaNacimiento');
	});
	$('#fechaNacimiento').click();

	$('#fechaFundacion').bind('click', function() {
		setDatePicker('fechaFundacion');
	});
	$('#fechaFundacion').click();

	$('#fechaEjerceDesde').bind('click', function() {
		setDatePicker('fechaEjerceDesde');
	});
	$('#fechaEjerceDesde').click();

	$('#fechaServicioDesde').bind('click', function() {
		setDatePicker('fechaServicioDesde');
	});
	$('#fechaServicioDesde').click();

	$('#fechaServicioHasta').bind('click', function() {
		setDatePicker('fechaServicioHasta');
	});
	$('#fechaServicioHasta').click();
	
	$('#fechaEntregaServicio').bind('click', function() {
		setDatePicker('fechaEntregaServicio');
	});
	$('#fechaEntregaServicio').click();
	
	$('#fechaVencimientoSubasta').bind('click', function() {
		setDatePicker('fechaVencimientoSubasta');
	});
	$('#fechaVencimientoSubasta').click();
	
	$('#updateFechaNacimiento').bind('click', function() {
		setDatePicker('updateFechaNacimiento');
	});
	$('#updateFechaNacimiento').click();
	
	$('.clockpicker').clockpicker();
});

function setDatePicker(inputId) {
	var date_input = $('#' + inputId); // our date input has the name "date"
	var container = $('.bootstrap-iso form').length > 0 ? $(
			'.bootstrap-iso form').parent() : "body";

	if (inputId.includes('update')) {
		var options = {
			format : 'dd/mm/yyyy',
			container : container,
			// todayHighlight: true,
			autoclose : true,
		};
	} else {
		var options = {
			format : 'dd/mm/yyyy',
			container : container,
			todayHighlight : true,
			autoclose : true,
		};
	}

	date_input.datepicker(options);
}

$(function () {
	 
  $("#rateYo").rateYo({
    rating: 2.5
  });
 
});