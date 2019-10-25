$(document).ready(function() {
	
	setCalendarFunction();
	$('.clockpicker').clockpicker();
	
	setInterval(verificaNotificaciones, 10000);
	
});

function verificaNotificaciones(){
	
	var dataUsuarioWebArr = (document.getElementById("usuarioWebCurrentSession").value).split(":");
	
	if(dataUsuarioWebArr.length > 0){
		var codigoUsuarioWeb = dataUsuarioWebArr[0];
		var tipoUsuarioWeb = dataUsuarioWebArr[1];
		
		if(codigoUsuarioWeb != "" && codigoUsuarioWeb != null) {
			
			var newInputFormNotifys = document.createElement("form");
			newInputFormNotifys.setAttribute("id", "usuarioWebNotificacionesForm");
			
			var newInputCodigoUsuarioWeb = document.createElement("input");
			newInputCodigoUsuarioWeb.setAttribute("type", "hidden");
			newInputCodigoUsuarioWeb.setAttribute("id", "codigoUsuarioWebNotify");
			newInputCodigoUsuarioWeb.setAttribute("name", "usuarioWeb.codigoUsuarioWeb");
			newInputCodigoUsuarioWeb.setAttribute("value", codigoUsuarioWeb);
			
			var newInputTipoUsuarioWeb = document.createElement("input");
			newInputTipoUsuarioWeb.setAttribute("type", "hidden");
			newInputTipoUsuarioWeb.setAttribute("id", "tipoUsuarioWebNotify");
			newInputTipoUsuarioWeb.setAttribute("name", "usuarioWeb.tipoUsuarioWeb.id");
			newInputTipoUsuarioWeb.setAttribute("value", tipoUsuarioWeb);
			
			document.getElementsByTagName('body')[0].appendChild(newInputFormNotifys);
			
			$("#usuarioWebNotificacionesForm").append(newInputCodigoUsuarioWeb);
			$("#usuarioWebNotificacionesForm").append(newInputTipoUsuarioWeb);
			
			var formData = $(document.getElementById("usuarioWebNotificacionesForm")).serialize();
			
			$.ajax({
				type : "POST",
				url : "getNotificacionesUsuarioWeb.action",
				data : formData,
				success : function(response) {
					var notificaciones = JSON.parse(response);
					console.log(notificaciones[0].descripcion);
				}
			});
			
			document.getElementById('usuarioWebNotificacionesForm').remove();
		}
	}
	
	console.log('VERIFICA NOTIFICACIONES');
}

function setCalendarFunction() {
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
}

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