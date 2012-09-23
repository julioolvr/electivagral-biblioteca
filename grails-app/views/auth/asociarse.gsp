<html>
	<head>
		<meta name="layout" content="main"/>
		<title>${message(code:'app.titulo')}</title>
	</head>
	<body>
		<div class="row container">
			<h2><g:message code="usuarios.asociarse.titulo"/></h2>
			
			<g:form id="asociarse-form" class="four columns" controller="auth" action="guardar">
				<label for="dni"><g:message code="socio.atributos.dni" /></label>
				<g:textField name="dni" value="${socio?.dni}" class="${hasErrors(bean: socio, field: 'dni', 'error')}" />
				<small class="${hasErrors(bean: socio, field: 'dni', 'error')}"><g:message error="${socio?.errors?.getFieldError('dni')}" /></small>
				
				<label for="nombre"><g:message code="socio.atributos.nombre" /></label>
				<g:textField name="nombre" maxlength="50" value="${socio?.nombre}" class="${hasErrors(bean: socio, field: 'nombre', 'error')}"/>
				<small class="${hasErrors(bean: socio, field: 'nombre', 'error')}"><g:message error="${socio?.errors?.getFieldError('nombre')}" /></small>
				
				<label for="login"><g:message code="socio.atributos.login" /></label>
				<g:textField name="login" maxlength="20" value="${socio?.login}" class="${hasErrors(bean: socio, field: 'login', 'error')}"/>
				<small class="${hasErrors(bean: socio, field: 'login', 'error')}"><g:message error="${socio?.errors?.getFieldError('login')}" /></small>
				
				<label for="password"><g:message code="socio.atributos.password" /></label>
				<g:passwordField name="password" maxlength="40" value="${socio?.password}" class="${hasErrors(bean: socio, field: 'password', 'error')}"/>
				<small class="${hasErrors(bean: socio, field: 'password', 'error')}"><g:message error="${socio?.errors?.getFieldError('password')}" /></small>
				
				<label for="email"><g:message code="socio.atributos.email" /></label>
				<g:textField name="email" maxlength="50" value="${socio?.email}" class="${hasErrors(bean: socio, field: 'email', 'error')}"/>
				<small class="${hasErrors(bean: socio, field: 'email', 'error')}"><g:message error="${socio?.errors?.getFieldError('email')}" /></small>
				
				<input type='submit' id="submit" class="small button right"
					value='${message(code: "usuarios.asociarse")}'/>
			</g:form>
		</div>
	</body>
</html>