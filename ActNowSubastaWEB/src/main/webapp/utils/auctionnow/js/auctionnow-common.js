$(document).ready(function() {
	
	setCalendarFunction();
	$('.clockpicker').clockpicker();
	
	verificaNotificaciones();
	
	setInterval(verificaNotificaciones, 10000);
	
	setAuctionCountdown();
	
});

function verificaNotificaciones(){
	
	var dataUsuarioWebArr = (document.getElementById("usuarioWebCurrentSession").value).split(":");
	
	if(dataUsuarioWebArr.length > 0){
		var codigoUsuarioWeb = dataUsuarioWebArr[0];
		var tipoUsuarioWeb = dataUsuarioWebArr[1];
		
		if(codigoUsuarioWeb != "" && codigoUsuarioWeb != null) {
			
			$.ajax({
				type : "GET",
				url : "getNotificacionesUsuarioWeb.action?usuarioWeb.codigoUsuarioWeb=" + codigoUsuarioWeb + "&usuarioWeb.tipoUsuarioWeb.id=" + tipoUsuarioWeb,
				//data : formData,
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
		}
	}
	
	console.log('VERIFICA NOTIFICACIONES');
}

function getActionByTipoNotificacion(codigoUsuarioWeb, tipoNotificacion, codigoOrigenNotificacion, codigoNotificacionUsuario){
	
	updateUserNotificationStatusLeida(codigoUsuarioWeb, codigoNotificacionUsuario);
	
	switch (tipoNotificacion) {
		case 'NEWSUB':
			
			var newInputFormCodigoOrigenNotificacion = document.createElement("form");
			newInputFormCodigoOrigenNotificacion.setAttribute("id", "codigoOrigenNotificacionForm");
			newInputFormCodigoOrigenNotificacion.setAttribute("action", "showSubastaDetailbyNotification.action");
			newInputFormCodigoOrigenNotificacion.setAttribute("method", "POST");
			
			var newInputCodigoOrigenNotificacion = document.createElement("input");
			newInputCodigoOrigenNotificacion.setAttribute("type", "hidden");
			newInputCodigoOrigenNotificacion.setAttribute("id", "codigoOrigenNotificacion");
			newInputCodigoOrigenNotificacion.setAttribute("name", "notificacion.codigoOrigenNotificacion");
			newInputCodigoOrigenNotificacion.setAttribute("value", codigoOrigenNotificacion);
			
			document.getElementsByTagName('body')[0].appendChild(newInputFormCodigoOrigenNotificacion);
			
			$("#codigoOrigenNotificacionForm").append(newInputCodigoOrigenNotificacion);
			
			var codigoOrigenNotificacionForm = document.getElementById("codigoOrigenNotificacionForm");
			codigoOrigenNotificacionForm.submit();
			
			document.getElementById('codigoOrigenNotificacionForm').remove();
			
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

function setAuctionCountdown() {
	var dateAuctionCountdown = document.getElementById('h_dateAuctionCountdown').value;
	
	$('.countdown').dsCountDown({
		startDate:new Date(),// Date Object of starting time of count down, usualy now (whether client time or given php time)
		endDate:new Date(dateAuctionCountdown),
		elemSelDays:'',// Leave blank to use default value or provide a string selector if the lement already exist, Example: .ds-days
		elemSelHours:'',// Leave blank to use default value or provide a string selector if the lement already exist, Example: .ds-hours
		elemSelMinutes:'',// Leave blank to use default value or provide a string selector if the lement already exist, Example: .ds-minutes
		elemSelSeconds:'',// Leave blank to use default value or provide a string selector if the lement already exist, Example: .ds-seconds
		theme:'white',// Set the theme 'white', 'black', 'red', 'flat', 'custom'
		titleDays:'Days',// Set the title of days
		titleHours:'Hours',// Set the title of hours
		titleMinutes:'Minutes',// Set the title of minutes
		titleSeconds:'Seconds',// Set the title of seconds
		onBevoreStart:null,// callback before the count down starts
		onClocking:null,// callback after the timer just clocked
		onFinish:null// callback if the count down is finish or 0 timer defined
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
	var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";

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