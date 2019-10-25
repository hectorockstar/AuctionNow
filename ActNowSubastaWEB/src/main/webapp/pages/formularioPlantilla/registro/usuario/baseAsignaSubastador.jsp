<%@ taglib prefix="s" uri="/WEB-INF/struts-tags.tld"%>

<h3>
	<s:text name="title.label.asigna.privilegio.subastador" />
</h3>

<div class="form-group">
	<label class="control-label col-md-2" for="privilegioSubastador"> <s:text
			name="common.label.asignar.privilegio" />:
	</label>
	<div class="col-md-offset-3">
		<div class="checkbox col-sm-4">
			<label> 
				<s:checkbox id="privilegioSubastador" name="" value="false" /> 
				<s:hidden id="h_privilegioSubastador" value="" name="privilegio.nombrePrivilegio" /> <s:text name="control.label.asigna.privilegio.subastador" />
			</label>
		</div>
		<div class="muestra_error"></div>
	</div>
</div>

<script>
	$(function() {
		$("#privilegioSubastador").click(function() {
			var chkValue = $("#privilegioSubastador").prop('checked') ? "SUBASTADOR" : "";
			$("#h_privilegioSubastador").val(chkValue);
		});
	});
</script>