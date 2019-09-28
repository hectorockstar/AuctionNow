<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<s:iterator value="#request.servicios" var="ser">
<div class="col-xs-1 header-row-resultadoServicio">
	<s:checkbox id="activo%{#ser.codigoServicio}" name="" value="false"  />
	<s:hidden id="h_activo%{#ser.codigoServicio}" value="%{#ser.codigoServicio}:false" name="estadosServicios" />
</div>
<div class="col-xs-11 body-row-resultadoServicio">
	<input id="accordionButton<s:property value='#ser.codigoServicio' />" type="button" class="accordion accordionServicios" value="<s:property value='#ser.nombre' />" >
	<div class="panelAccordion">
		<div class="containAddressAccordion">
			
			<div class="form-group col-sm-12">
				<label class="col-sm-3"> 
					<s:text name="common.label.descripcion.servicio" />:
				</label>
				<label class="col-sm-9"> 
					<s:property value='#ser.descripcion' />
				</label>
			</div>
			
			<div class="form-group col-sm-12">
				<label class="col-sm-1"><s:text name="common.label.activo" /></label>
				<label class="col-sm-1"><s:text name="common.label.sigla" /></label>
				<label class="col-sm-3"><s:text name="common.label.nombre" /></label>
				<label class="col-sm-7"><s:text name="common.label.descripcion" /></label>
				
				<s:iterator value="%{#ser.cargos}" var="car">
					<div class="col-sm-1"><s:checkbox id="activo%{#car.codigoCargo}" name="" value="true" disabled="true" /></div>
					<s:hidden id="h_activo%{#car.codigoCargo}" value="%{#car.codigoCargo}:true" name="" />
					<label class="col-sm-1"><s:property value='#car.sigla' /></label>
					<label class="col-sm-3"><s:property value='#car.nombre' /></label>
					<label class="col-sm-7"><s:property value='#car.descripcion' /></label>
				</s:iterator>
				
			</div>
			
		</div>
	</div>
	
	<script type="text/javascript">
		$(function() {
			$("#accordionButton<s:property value='#ser.codigoServicio' />").click(function() {
				var acc = document.getElementsByClassName("accordion");
				var i;

				for (i = 0; i < acc.length; i++) {
					acc[i].addEventListener("click", function() {
						this.classList.toggle("activeAccordion");
						var panel = this.nextElementSibling;
						if (panel.style.maxHeight) {
							panel.style.maxHeight = null;
						} else {
							panel.style.maxHeight = panel.scrollHeight + "px";
						}
					});
				}
			}); 
		});

		$(function() {
			$("#activo<s:property value='#ser.codigoServicio' />").click(function() {
				var chkValue = $("#activo<s:property value='#ser.codigoServicio' />").prop('checked') ? "true" : "false";
				$("#h_activo<s:property value='#ser.codigoServicio' />").val("<s:property value='#ser.codigoServicio' />"+":"+chkValue)
			});
		});
	</script>
</div>	
</s:iterator>

<div class="form-group">
	<input id="btnAsignarRubro"
		type="button" 
		class="btn btn-success btn-asignarRubro"
		value='<s:text name="button.label.asignar.rubro" />' />
</div>

<script type="text/javascript">
	$(function() {
		$("#btnAsignarRubro").click(function() {
			var formData = $("#rubroEmpresaData").serialize(); //get all data from form

			$.ajax({
				type : "POST",
				url : "asignaRubroServiciosEmpresa.action",
				data : formData,
				success : function(response) {
					console.log('SE HA ASIGNADO RUBRO CORRECTAMENTE');
					location.replace(window.location.href);
				}
			});
		});
	});
</script>
