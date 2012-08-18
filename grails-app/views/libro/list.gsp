
<%@ page import="com.biblioteca.Libro" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'libro.label', default: 'Libro')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-libro" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-libro" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
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
				<g:each in="${libroInstanceList}" status="i" var="libroInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${libroInstance.id}">${fieldValue(bean: libroInstance, field: "titulo")}</g:link></td>
					
						<td>${fieldValue(bean: libroInstance, field: "autor")}</td>
					
						<td>${fieldValue(bean: libroInstance, field: "isbn")}</td>
					
						<td>${fieldValue(bean: libroInstance, field: "ejemplaresDisponibles")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${libroInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
