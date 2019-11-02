$(document).ready(function() {
	
	setCalendarFunction();
	$('.clockpicker').clockpicker();
	
	verificaNotificaciones();
	
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
					var notificationsNotReadCount = 0;
					
					$("#notificationsView").html('');
					for(var i = 0 ;i < notificaciones.length; i++){
						var notificationRowInfo = '';
						if(notificaciones[i].leida == 'N'){
							notificationsNotReadCount++;
							notificationRowInfo = '<li id='+ notificaciones[i].codigoNotificacionUsuario +'><a href="javascript:getActionByTipoNotificacion(\'' + notificaciones[i].usuarioWeb.codigoUsuarioWeb + '\', \'' + notificaciones[i].tipoNotificacion.id + '\', \'' + notificaciones[i].codigoOrigenNotificacion + '\', \'' + notificaciones[i].codigoNotificacionUsuario + '\')" >'+ notificaciones[i].descripcion +'</a></li>';
							$("#notificationsView").append(notificationRowInfo);
							$("#"+notificaciones[i].codigoNotificacionUsuario).addClass("not-read-notification");
							
						} else {
							notificationRowInfo = '<li id='+ notificaciones[i].codigoNotificacionUsuario +'><a href="javascript:getActionByTipoNotificacion(\'' + notificaciones[i].usuarioWeb.codigoUsuarioWeb + '\', \'' + notificaciones[i].tipoNotificacion.id + '\', \'' + notificaciones[i].codigoOrigenNotificacion + '\', \'' + notificaciones[i].codigoNotificacionUsuario + '\')" >'+ notificaciones[i].descripcion +'</a></li>';
							$("#notificationsView").append(notificationRowInfo);
						}
						
                    }
					
					$("#notificationsCountValue").html('');
					$("#notificationsCountValue").append(notificationsNotReadCount);
					
					if(notificationsNotReadCount > 0) {
						$("#notificationsCount").css("display", "flex");
					} else{
						$("#notificationsCount").css("display", "none");
					}
				}
			});
			
			document.getElementById('usuarioWebNotificacionesForm').remove();
		}
	}
	
	console.log('VERIFICA NOTIFICACIONES');
}

function getActionByTipoNotificacion(codigoUsuarioWeb, tipoNotificacion, codigoOrigenNotificacion, codigoNotificacionUsuario){
	
	updateUserNotificationStatusLeida(codigoUsuarioWeb, codigoNotificacionUsuario);
	
	switch (tipoNotificacion) {
		case 'NEWSUB':
			$.ajax({
				type : "GET",
				url : 'showSubastaDetail.action?notificacion.codigoOrigenNotificacion='+codigoOrigenNotificacion,
				success : function(response) {
						
				}
			});
			break;
		default:
			console.log('Lo lamentamos, por el momento no disponemos de notificaciones para' + tipoNotificacion + '.');
	}
	
	verificaNotificaciones();
	
}

function updateUserNotificationStatus(codigoUsuarioWeb, codigoNotificacionUsuario, estado) {
	
	$.ajax({
		type : "GET",
		url : "updateNotificationStatus.action?notificacion.usuarioWeb.codigoUsuarioWeb=" + codigoUsuarioWeb + "&notificacion.codigoNotificacionUsuario=" + codigoNotificacionUsuario + "&notificacion.leida=" + estado,
		//data : formData,
		success : function(response) {
			
		}
	});
}

function updateUserNotificationStatusLeida(codigoUsuarioWeb, codigoNotificacionUsuario) {
	var estado = 'S';
	updateUserNotificationStatus(codigoUsuarioWeb, codigoNotificacionUsuario, estado);
}

function updateUserNotificationStatusNoLeida(codigoUsuarioWeb, codigoNotificacionUsuario) {
	var estado = 'N';
	updateUserNotificationStatus(codigoUsuarioWeb, codigoNotificacionUsuario, estado);
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