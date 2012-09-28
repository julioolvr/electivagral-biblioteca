
<%@ page import="com.biblioteca.Reserva" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reserva.label', default: 'Reserva')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="show-reserva" class="content scaffold-show" role="main">
			<div class="container row">
				<h1><g:message code="default.show.label" args="[entityName]" /></h1>
				<ol class="property-list reserva">
				
					<g:if test="${reserva?.libro}">
					<li class="fieldcontain">
						<span id="libro-label" class="property-label"><g:message code="reserva.libro.label" default="Libro" /></span>
						
							<span class="property-value" aria-labelledby="libro-label"><g:link controller="libro" action="show" id="${reserva?.libro?.id}">${reserva?.libro?.encodeAsHTML()}</g:link></span>
						
					</li>
					</g:if>
				
					<g:if test="${reserva?.socio}">
					<li class="fieldcontain">
						<span id="socio-label" class="property-label"><g:message code="reserva.socio.label" default="Socio" /></span>
						
							<span class="property-value" aria-labelledby="socio-label">${reserva?.socio?.encodeAsHTML()}</span>
						
					</li>
					</g:if>
				
					<g:if test="${reserva?.fechaReserva}">
					<li class="fieldcontain">
						<span id="fechaReserva-label" class="property-label"><g:message code="reserva.fechaReserva.label" default="Fecha Reserva" /></span>
						
							<span class="property-value" aria-labelledby="fechaReserva-label"><g:formatDate date="${reserva?.fechaReserva}" /></span>
						
					</li>
					</g:if>
				
					<g:if test="${reserva?.fechaFinReserva}">
					<li class="fieldcontain">
						<span id="fechaFinReserva-label" class="property-label"><g:message code="reserva.fechaFinReserva.label" default="Fecha Fin Reserva" /></span>
						
							<span class="property-value" aria-labelledby="fechaFinReserva-label"><g:formatDate date="${reserva?.fechaFinReserva}" /></span>
						
					</li>
					</g:if>
				
				</ol>
				<g:form>
						<g:hiddenField name="id" value="${reserva?.id}" />
						<g:if test="${reserva.disponibleParaPrestamo}">
							<div>
								<span class="radius success label">
									¡Libro disponible!
								</span>
								<a href="${createLink(action:'generarPrestamo', id:reserva.id)}">
									Generar préstamo
								</a>
							</div>
						</g:if>
<%--						<g:link class="edit" action="edit" id="${reserva?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>--%>
<%--						<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />--%>
				</g:form>
			</div>
		</div>
	</body>
</html>
