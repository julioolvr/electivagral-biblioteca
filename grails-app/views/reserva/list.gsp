
<%@ page import="com.biblioteca.Reserva" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'reserva.label', default: 'Reserva')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-reserva" class="content scaffold-list" role="main">
			<div class="container row">
				<h1><g:message code="default.list.label" args="[entityName]" /></h1>
				<table>
					<thead>
						<tr>
						
							<th><g:message code="reserva.libro.label" default="Libro" /></th>
						
							<g:sortableColumn property="fechaReserva" title="${message(code: 'reserva.fechaReserva.label', default: 'Fecha Reserva')}" />
						
							<g:sortableColumn property="fechaDisponibilidad" title="${message(code: 'reserva.fechaDisponibilidad.label', default: 'Fecha Disponibilidad')}" />
						
							<g:sortableColumn property="fechaFinReserva" title="${message(code: 'reserva.fechaFinReserva.label', default: 'Fecha Fin Reserva')}" />
						
						</tr>
					</thead>
					<tbody>
					<g:each in="${reservaList}" status="i" var="reserva">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td><g:link action="show" id="${reserva.id}">${fieldValue(bean: reserva, field: "libro")}</g:link></td>
						
							<td><g:formatDate date="${reserva.fechaReserva}" /></td>
						
							<td><g:formatDate date="${reserva.fechaDisponibilidad}" /></td>
						
							<td><g:formatDate date="${reserva.fechaFinReserva}" /></td>
						
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<g:paginate total="${reservaTotal}" />
				</div>
			</div>
		</div>
	</body>
</html>
