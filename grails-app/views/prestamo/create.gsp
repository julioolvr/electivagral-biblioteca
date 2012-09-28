<%@ page import="com.biblioteca.Prestamo" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'prestamo.label', default: 'Prestamo')}" />
		<r:require module="prestamoCreate"/>
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="create-prestamo" class="container row" role="main">
			<h1><g:message code="prestamo.crear.titulo" args="[entityName]" /></h1>
			<g:hasErrors bean="${prestamo}">
			<ul class="errors" role="alert">
				<g:eachError bean="${prestamo}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" >
				<g:render template="form"/>
				<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
			</g:form>
		</div>
	</body>
</html>
