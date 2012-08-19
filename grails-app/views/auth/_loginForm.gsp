<g:form controller='auth' action='login' method='POST' class='loginForm' autocomplete='off'>
	<input type='text' id='login_login' class='text_' name='login' id='login' placeholder="${message(code: 'usuarios.nombre')}" />

	<input type='password' id='login_password' class='text_' name='password' id='password' placeholder="${message(code: 'usuarios.password')}" />

	<div class="row">
		<div class="eight columns asociarse">
			<a href="${createLink(controller:'auth', action:'asociarse')}">Asociarse</a>
		</div>
		<div class="four columns">
			<input type='submit' id="submit" class="small button right" value='${message(code: "usuarios.login")}'/>
		</div>
	</div>

</g:form>