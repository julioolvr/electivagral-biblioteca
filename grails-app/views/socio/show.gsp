
<%@ page import="com.biblioteca.Socio" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'socio.label', default: 'Socio')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-socio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-socio" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<ol class="property-list socio">
			
				<g:if test="${socioInstance?.dni}">
				<li class="fieldcontain">
					<span id="dni-label" class="property-label"><g:message code="socio.dni.label" default="Dni" /></span>
					
						<span class="property-value" aria-labelledby="dni-label"><g:fieldValue bean="${socioInstance}" field="dni"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socioInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="socio.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${socioInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socioInstance?.login}">
				<li class="fieldcontain">
					<span id="login-label" class="property-label"><g:message code="socio.login.label" default="Login" /></span>
					
						<span class="property-value" aria-labelledby="login-label"><g:fieldValue bean="${socioInstance}" field="login"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socioInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="socio.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${socioInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socioInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="socio.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${socioInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${socioInstance?.prestamos}">
				<li class="fieldcontain">
					<span id="prestamos-label" class="property-label"><g:message code="socio.prestamos.label" default="Prestamos" /></span>
					
						<g:each in="${socioInstance.prestamos}" var="p">
						<span class="property-value" aria-labelledby="prestamos-label"><g:link controller="prestamo" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${socioInstance?.reservas}">
				<li class="fieldcontain">
					<span id="reservas-label" class="property-label"><g:message code="socio.reservas.label" default="Reservas" /></span>
					
						<g:each in="${socioInstance.reservas}" var="r">
						<span class="property-value" aria-labelledby="reservas-label"><g:link controller="reserva" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${socioInstance?.id}" />
					<g:link class="edit" action="edit" id="${socioInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
