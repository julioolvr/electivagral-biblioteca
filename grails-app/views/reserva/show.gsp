
<%@ page import="com.biblioteca.Reserva" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reserva.label', default: 'Reserva')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-reserva" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-reserva" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list reserva">
			
				<g:if test="${reservaInstance?.libro}">
				<li class="fieldcontain">
					<span id="libro-label" class="property-label"><g:message code="reserva.libro.label" default="Libro" /></span>
					
						<span class="property-value" aria-labelledby="libro-label"><g:link controller="libro" action="show" id="${reservaInstance?.libro?.id}">${reservaInstance?.libro?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reservaInstance?.socio}">
				<li class="fieldcontain">
					<span id="socio-label" class="property-label"><g:message code="reserva.socio.label" default="Socio" /></span>
					
						<span class="property-value" aria-labelledby="socio-label"><g:link controller="socio" action="show" id="${reservaInstance?.socio?.id}">${reservaInstance?.socio?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reservaInstance?.fechaReserva}">
				<li class="fieldcontain">
					<span id="fechaReserva-label" class="property-label"><g:message code="reserva.fechaReserva.label" default="Fecha Reserva" /></span>
					
						<span class="property-value" aria-labelledby="fechaReserva-label"><g:formatDate date="${reservaInstance?.fechaReserva}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${reservaInstance?.fechaFinReserva}">
				<li class="fieldcontain">
					<span id="fechaFinReserva-label" class="property-label"><g:message code="reserva.fechaFinReserva.label" default="Fecha Fin Reserva" /></span>
					
						<span class="property-value" aria-labelledby="fechaFinReserva-label"><g:formatDate date="${reservaInstance?.fechaFinReserva}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${reservaInstance?.id}" />
					<g:link class="edit" action="edit" id="${reservaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
