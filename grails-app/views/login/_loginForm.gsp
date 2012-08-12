<form action='${resource('file': 'j_spring_security_check')}' method='POST' class='loginForm panel' autocomplete='off'>
	<input type='text' class='text_' name='j_username' id='username' placeholder="${message(code: 'springSecurity.login.username.label')}" />

	<input type='password' class='text_' name='j_password' id='password' placeholder="${message(code: 'springSecurity.login.password.label')}" />

	<div class="row">
		<div class="four columns">
			<label for='remember_me' class="left inline"><g:message code="springSecurity.login.remember.me.label"/></label>
		</div>
		<div class="one columns">
			<input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
		</div>
		
		<div class="seven columns">
			<input type='submit' id="submit" class="small button right" value='${message(code: "springSecurity.login.button")}'/>
		</div>
	</div>

</form>