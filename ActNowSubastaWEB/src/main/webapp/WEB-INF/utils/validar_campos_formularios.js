$(document).ready(function(){
	//METODOS jquery validate
	 $.validator.addMethod("anyDate",  function(value, element) {
	        return value.match(/^(0?[1-9]|[12][0-9]|3[0-1])[/., -](0?[1-9]|1[0-2])[/., -](19|20)?\d{2}$/);
	    },
	    "Por favor, escribe una fecha v&aacutelida."
	 );
	 
	 $.validator.addMethod("hours",  function(value, element) {
	        if(value.toString != ""){
	        	return value.match(/^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$/);
	        }else{
	        	return value.match();
	        }
	        
	    },
	    "Por favor, escribe formato v&aacutelido de hora."
	 );
	 	 
	 $.validator.addMethod("requireOne", function(value, elem, param) {
		    if($(":checkbox:checked").length > 0){
		       return true;
		   }else {
		       return false;
		   }
		},"Debe escoger al menos 1 d&iacutea en su elecci&oacuten");
	 
	 
	 //CLASES jquery validate
	 	//Campos - preferencias del usuario - formulario: formulario_registro_usuario	
		jQuery.validator.addClassRules("preferencia-usuario", {
		  required: true,
		  maxlength: "70"
		});
		
		//Campos - horario de recepcion - formulario: formulario_registro_solicitud
		jQuery.validator.addClassRules("time", {
			hours: true
		});
	
/**-------------XXX FORMULARIO DEL REGISTRO DE USUARIOS--------------*/
	$("#formulario_registro_usuario").validate({
		rules: {
			
		//Campos - datos del usuario
			txtNombre: {
				required: true,
				maxlength: "20"
			},
			txtApellido_paterno: {
				required: true,
				maxlength: "20"
			},
			txtApellido_materno: {
				required: true,
				maxlength: "20"
			},
			txtRut:{
				required: true,
				maxlength: "8",
				digits: true
			},
			txtDv:{
				required: true,
				maxlength: "1"
			},
			txtOcupacion:{
				required: true,
				maxlength: "30"
			},
			cbbGenero: "required",

			txtFecha_nacimiento: {
				required: true,				
				anyDate: true
			},
			txtCorreo: {
				required: true,
				maxlength: "70",
				email: true
			},
			txtUsername: {
				required: true,
				maxlength: "25"
			},
			txtPwd: {
				required: true,
				minlength: "8",
				maxlength: "15"
			},
			txtRe_pwd:{
				required: true,
				minlength: "8",
				maxlength: "15",
				equalTo: "#pwd"
			},
			txtTelefono1:{
				required: true,
				maxlength: "9",
				digits: true
			},
			txtTelefono2:{
				maxlength: "9",
				digits: true
			},
			txtMovil1:{
				required: true,
				maxlength: "9",
				digits: true
			},
			txtMovil2:{
				maxlength: "9",
				digits: true
			},
			
			//Campos - datos direccion
			cbbPais: "required",
			cbbRegion: "required",
			cbbCiudad: "required",
			cbbComuna: "required",
			txtDireccion: {
				required: true,
				maxlength: "70"
			},
			txtCalle:{
				required: true,
				maxlength: "20"
			},
			txtCodigo_postal: {
				required: true,
				maxlength: "15"
			},
			
			//Campos - preferencias del usuario	
			txtFirma_comentario: {
				maxlength: 200
			},
			chkTerminos_condiciones: "required"
		},		
		messages: {
			chkTerminos_condiciones: "Debe aceptar las pol&iacuteticas de la empresa"
		},
		errorPlacement: function ( error, element ) {
			error.addClass( "help-block" );
			if ( element.prop( "type" ) === "checkbox" ) {
				error.insertAfter( element.parent( "label" ) );
			} else {
				error.insertAfter( element );
			}
		},
		highlight: function ( element, errorClass, validClass ) {
			$( element ).parents( ".campoValidado" ).addClass( "has-error" ).removeClass( "has-success" );
		},
		unhighlight: function (element, errorClass, validClass) {
			$( element ).parents( ".campoValidado" ).addClass( "has-success" ).removeClass( "has-error" );
		}
		
	});	  
	
/**--------------XXX FORMULARIO DE LOGIN USUARIOS------------------ */
	$("#formulario_ingreso_usuarios").validate({
		rules:{
			
			//Campos - login del usuario
			txtEmailLogin: {
				required: true,
				maxlength: "70"
			},
			txtPasswordLogin: {
				required: true,
				maxlength: "15"
			}
		},
		errorPlacement: function ( error, element ) {
			error.addClass( "help-block" );
			if ( element.prop( "type" ) === "checkbox" ) {
				error.insertAfter( element.parent( "label" ) );
			} else {
				error.insertAfter( element );
			}
		},
		highlight: function ( element, errorClass, validClass ) {
			$( element ).parents( ".campoValidado" ).addClass( "has-error" ).removeClass( "has-success" );
		},
		unhighlight: function (element, errorClass, validClass) {
			$( element ).parents( ".campoValidado" ).addClass( "has-success" ).removeClass( "has-error" );
		}
	});
	
	
	/**--------------XXX FORMULARIO DE REGISTRO SOLICITUD------------------ */
	$("#formulario_registro_solicitud").validate({		
		rules:{
			cbbUrgencia: "required",
			txtFechaDuracionSubasta: {
				required: true,
				anyDate: true
			},
			txtHoraInicioSubasta: {
				required: true
			},
			txtPrecioEstimadoPagar: {
				required: true,
				digits: true
			},
			txtDescripcionDelRequerimiento:{
				required: true,
				maxlength: "500"
			},
			chkDiasSemana: {
				requireOne: true
			}
		},
		errorPlacement: function ( error, element ) {
			error.addClass( "help-block" );
			if ( element.prop( "type" ) === "checkbox" ) {
				error.appendTo( ".muestra_error");
			} else {
				error.insertAfter( element );
			}
		},
		highlight: function ( element, errorClass, validClass ) {
			$( element ).parents( ".campoValidado" ).addClass( "has-error" ).removeClass( "has-success" );
			$( ".muestra_error" ).addClass( "has-error" ).removeClass( "has-success" );
		},
		unhighlight: function (element, errorClass, validClass) {
			$( element ).parents( ".campoValidado" ).addClass( "has-success" ).removeClass( "has-error" );
		}
	});	 
	
	/**--------------XXX FORMULARIO REGISTRO PROVEEDOR------------------ */
	$("#formulario_registro_proveedor").validate({
		rules: {
			txtNombreEmpresaProveedor: {
				required: true,
				maxlength: "70"
			},
			txtRutEmpresaProveedor:{
				required: true,
				maxlength: "8",
				digits: true
			},
			txtDvProveedor:{
				required: true,
				maxlength: "1",
				digits: true
			},
			txtFechaFundacionEmpresa:{
				required: true,				
				anyDate: true
			},
			txtCorreoElectronicoEmpresa: {
				required: true,
				maxlength: "70",
				email: true
			},
			txtNombreRepresentante:{
				required: true,
				maxlength: "100"
			},
			txtTituloRepresentanteProveedor:{
				required: true,
				maxlength: "40"
			},
			txtPaginaWebProveedor: {
				url: true
			},
			txtSeviciosEmpresaProveedor:{
				required: true,
				maxlength: "40"
			},
			txtUsernameProveedor:{
				required: true,
				maxlength: "25"
			},
			txtPwdProveedor:{
				required: true,
				minlength: "8",
				maxlength: "15"
			},
			txtRePwdProveedor: {
				required: true,
				minlength: "8",
				maxlength: "15",
				equalTo: "#pwdProveedor"
			},
			cbbPaisProveedor: "required",
			cbbRegionProveedor: "required",
			cbbCiudadProveedor: "required",
			cbbComunaProveedor: "required",
			txtDireccionProveedor:{
				required: true,
				maxlength: "70"
			},
			txtCalleProveedor: {
				required: true,
				maxlength: "20"
			},
			txtCodigoPostalProveedor:{
				required: true,
				maxlength: "15"
			},
			txtTelefono1Proveedor:{
				required: true,
				maxlength: "9",
				digits: true
			},
			txtTelefono2Proveedor:{
				maxlength: "9",
				digits: true
			},
			txtMovil1Proveedor:{
				required: true,
				maxlength: "9",
				digits: true
			},
			txtMovil2Proveedor:{
				maxlength: "9",
				digits: true
			},
			chkTerminosCondiciones: "required"
		},		
		messages: {
			chkTerminosCondiciones: "Por Favor debe aceptar las p&oacuteliticas de la empresa"
		},
		errorPlacement: function ( error, element ) {
			error.addClass( "help-block" );
			if ( element.prop( "type" ) === "checkbox" ) {
				error.insertAfter( element.parent( "label" ) );
			} else {
				error.insertAfter( element );
			}
		},
		highlight: function ( element, errorClass, validClass ) {
			$( element ).parents( ".campoValidado" ).addClass( "has-error" ).removeClass( "has-success" );
		},
		unhighlight: function (element, errorClass, validClass) {
			$( element ).parents( ".campoValidado" ).addClass( "has-success" ).removeClass( "has-error" );
		}
	});
	
});