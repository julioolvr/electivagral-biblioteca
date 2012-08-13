<form action='${resource('file': 'j_spring_security_check')}' method='POST' class='loginForm panel' autocomplete='off'>
	<input type='text' class='text_' name='j_username' id='username' placeholder="${message(code: 'usuarios.nombre')}" />

	<input type='password' class='text_' name='j_password' id='password' placeholder="${message(code: 'usuarios.password')}" />

	<div class="row">
<%--		<div class="four columns">--%>
<%--			<label for='remember_me' class="left inline"><g:message code="usuarios.recordarme"/></label>--%>
<%--		</div>--%>
<%--		<div class="one columns">--%>
<%--			<input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>--%>
<%--		</div>--%>
		
		<div class="twelve columns">
			<input type='submit' id="submit" class="small button right" value='${message(code: "usuarios.login")}'/>
		</div>
	</div>

</form>