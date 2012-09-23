<%@ page import="com.biblioteca.Libro" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'libro.label', default: 'Libro')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="mostrar-libro" class="row">
			<h2>${libro.titulo}</h2>
			
			<div class="eight columns">
				<h4>${libro.autor}</h4>
				
				<p>
					<g:if test="${!libro.hayStockDisponible()}">
						<span class="radius alert label">Sin stock</span>
					</g:if>
				</p>
				
				<p>
					<span id="isbn-label" class="property-label"><g:message code="libro.isbn" /></span>
					<span class="property-value" aria-labelledby="isbn-label"><g:fieldValue bean="${libro}" field="isbn"/></span>
				</p>
				
				<g:if test="${session.usuario}">
					<g:if test="${libro.hayStockDisponible(session.usuario)}">
						<a href="${createLink(controller:'prestamo', action:'create', params:[idLibro:libro.id])}">Solicitar préstamo</a>
					</g:if>
					<g:elseif test="${libro.puedeReservarlo(session.usuario)}">
						<a href="${createLink(controller:'reserva', action:'create', params:[idLibro:libro.id])}">Reservar libro</a>
					</g:elseif>
					<g:else>
						El libro no está disponible.
					</g:else>
				</g:if>
				<g:else>
					Iniciá sesión para solicitar un préstamo
				</g:else>
				<a href="${createLink(controller:'libro')}">Volver</a>
			</div>
			
			<div class="four columns">
				<img src="${libro.urlCover}" class="cover" />
			</div>
		</div>
	</body>
</html>
