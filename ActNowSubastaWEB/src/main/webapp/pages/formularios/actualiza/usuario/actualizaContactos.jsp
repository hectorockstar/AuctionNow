<jsp:include page="../../../../estructura/header-content.jsp" />
<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<!--Inicio contenido dinámico-->
<div class="container">
	<div class="row well">
		<div class="col-xs-12">
			<br>
			<h2>
				<ins>
					<s:text name="title.label.datos.actualiza.contacto" />
				</ins>
			</h2>
			<br>
			<s:iterator value="#request.contactos" var="con">
				<jsp:include page="../../../../pages/formularioPlantilla/actualiza/usuario/baseActualizaContacto.jsp" />
			</s:iterator>
			<br> <br>
		</div>
	</div>
</div>
</body>

<!-- ACCORDION -->
<script>
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
</script>

<jsp:include page="../../../../estructura/footer-content.jsp" />
