<%@ page import="com.biblioteca.Prestamo" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'prestamo.label', default: 'Prestamo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="show-prestamo" class="content scaffold-show" role="main">
			<div class="container row">
				<h2>Mis préstamos</h2>
				<ul class="property-list prestamo">
				
					<g:if test="${prestamo?.libro}">
					<li class="fieldcontain">
						<span id="libro-label" class="property-label"><g:message code="prestamo.libro.label" default="Libro" /></span>
						
							<span class="property-value" aria-labelledby="libro-label"><g:link controller="libro" action="show" id="${prestamo?.libro?.id}">${prestamo?.libro?.encodeAsHTML()}</g:link></span>
						
					</li>
					</g:if>
				
					<g:if test="${prestamo?.socio}">
					<li class="fieldcontain">
						<span id="socio-label" class="property-label"><g:message code="prestamo.socio.label" default="Socio" /></span>
						
							<span class="property-value" aria-labelledby="socio-label">${prestamo?.socio?.encodeAsHTML()}</span>
						
					</li>
					</g:if>
				
					<g:if test="${prestamo?.fechaPedido}">
					<li class="fieldcontain">
						<span id="fechaPedido-label" class="property-label"><g:message code="prestamo.fechaPedido.label" default="Fecha Pedido" /></span>
						
							<span class="property-value" aria-labelledby="fechaPedido-label"><g:formatDate date="${prestamo?.fechaPedido}" /></span>
						
					</li>
					</g:if>
				
					<g:if test="${prestamo?.fechaDevolucion}">
					<li class="fieldcontain">
						<span id="fechaDevolucion-label" class="property-label"><g:message code="prestamo.fechaDevolucion.label" default="Fecha Devolucion" /></span>
						
							<span class="property-value" aria-labelledby="fechaDevolucion-label"><g:formatDate date="${prestamo?.fechaDevolucion}" /></span>
						
					</li>
					</g:if>
					
				</ul>
				<g:if test="${!prestamo.devuelto()}">
					<g:form>
						<div class="buttons row">
							<g:hiddenField name="id" value="${prestamo?.id}" />
							<a href="${createLink(action:'renovar', id:prestamo.id)}">Renovar préstamo</a>
							<a href="${createLink(action:'devolver', id:prestamo.id)}">Registrar devolución</a>
						</div>
					</g:form>
				</g:if> 
			</div>
		</div>
	</body>
</html>