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
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<h2>${libro.titulo}</h2>
			
			<div class="eight columns">
				<h4>${libro.autor}</h4>
				
				<p>
					<span id="isbn-label" class="property-label"><g:message code="libro.isbn" /></span>
					<span class="property-value" aria-labelledby="isbn-label"><g:fieldValue bean="${libro}" field="isbn"/></span>
				</p>
				
				<a href="#">Solicitar préstamo</a>
				<a href="${createLink(controller:'libro')}">Volver</a>
<%--				<g:form>--%>
<%--					<fieldset class="buttons">--%>
<%--						<g:hiddenField name="id" value="${libro?.id}" />--%>
<%--						<g:link class="edit" action="edit" id="${libro?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>--%>
<%--						<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />--%>
<%--					</fieldset>--%>
<%--				</g:form>--%>
			</div>
			
			<div class="four columns">
				<img src="${libro.urlCover}" class="cover" />
			</div>
		</div>
	</body>
</html>
