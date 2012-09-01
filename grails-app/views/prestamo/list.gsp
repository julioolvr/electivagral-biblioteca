
<%@ page import="com.biblioteca.Prestamo" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'prestamo.label', default: 'Prestamo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-prestamo" class="content scaffold-list" role="main">
			<div class="container row">
				<h2><g:message code="default.list.label" args="[entityName]" /></h2>
				<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
				</g:if>
				<table>
					<thead>
						<tr>
						
							<th><g:message code="prestamo.libro.label" default="Libro" /></th>
						
							<th><g:message code="prestamo.socio.label" default="Socio" /></th>
						
							<g:sortableColumn property="fechaPedido" title="${message(code: 'prestamo.fechaPedido.label', default: 'Fecha Pedido')}" />
						
							<g:sortableColumn property="fechaDevolucion" title="${message(code: 'prestamo.fechaDevolucion.label', default: 'Fecha Devolucion')}" />
						
						</tr>
					</thead>
					<tbody>
					<g:each in="${prestamoInstanceList}" status="i" var="prestamoInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td><g:link action="show" id="${prestamoInstance.id}">${fieldValue(bean: prestamoInstance, field: "libro")}</g:link></td>
						
							<td>${fieldValue(bean: prestamoInstance, field: "socio")}</td>
						
							<td><g:formatDate date="${prestamoInstance.fechaPedido}" /></td>
						
							<td><g:formatDate date="${prestamoInstance.fechaDevolucion}" /></td>
						
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<g:paginate total="${prestamoInstanceTotal}" />
				</div>
			</div>
		</div>
	</body>
</html>
