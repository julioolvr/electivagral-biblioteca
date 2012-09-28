
<%@ page import="com.biblioteca.Libro" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'libro.label', default: 'Libro')}" />
		<title><g:message code="libro.lista.titulo" /></title>
	</head>
	<body>
		<div id="list-libro" class="content scaffold-list" role="main">
			<div class="container row">
				<h2><g:message code="libros.titulo" /></h2>
				<table>
					<thead>
						<tr>
						
							<g:sortableColumn property="titulo" title="${message(code: 'libro.titulo.label', default: 'Titulo')}" />
						
							<g:sortableColumn property="autor" title="${message(code: 'libro.autor.label', default: 'Autor')}" />
						
							<g:sortableColumn property="isbn" title="${message(code: 'libro.isbn.label', default: 'Isbn')}" />
						
							<g:sortableColumn property="ejemplaresDisponibles" title="${message(code: 'libro.ejemplaresDisponibles.label', default: 'Ejemplares Disponibles')}" />
						
						</tr>
					</thead>
					<tbody>
					<g:each in="${listaLibros}" status="i" var="libroInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td><g:link action="show" id="${libroInstance.id}">${fieldValue(bean: libroInstance, field: "titulo")}</g:link></td>
						
							<td>${fieldValue(bean: libroInstance, field: "autor")}</td>
						
							<td>${fieldValue(bean: libroInstance, field: "isbn")}</td>
						
							<td>${fieldValue(bean: libroInstance, field: "ejemplaresDisponibles")}</td>
						
						</tr>
					</g:each>
					</tbody>
				</table>
				<foundation:pagination lista="${listaLibros}" total="${totalLibros}"/>
<%--				<div class="pagination">--%>
<%--					<g:paginate total="${totalLibros}" />--%>
<%--				</div>--%>
			</div>
		</div>
	</body>
</html>
