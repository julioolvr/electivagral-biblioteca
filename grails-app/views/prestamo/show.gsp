
<%@ page import="com.biblioteca.Prestamo" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'prestamo.label', default: 'Prestamo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-prestamo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-prestamo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list prestamo">
			
				<g:if test="${prestamoInstance?.libro}">
				<li class="fieldcontain">
					<span id="libro-label" class="property-label"><g:message code="prestamo.libro.label" default="Libro" /></span>
					
						<span class="property-value" aria-labelledby="libro-label"><g:link controller="libro" action="show" id="${prestamoInstance?.libro?.id}">${prestamoInstance?.libro?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${prestamoInstance?.socio}">
				<li class="fieldcontain">
					<span id="socio-label" class="property-label"><g:message code="prestamo.socio.label" default="Socio" /></span>
					
						<span class="property-value" aria-labelledby="socio-label"><g:link controller="socio" action="show" id="${prestamoInstance?.socio?.id}">${prestamoInstance?.socio?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${prestamoInstance?.fechaPedido}">
				<li class="fieldcontain">
					<span id="fechaPedido-label" class="property-label"><g:message code="prestamo.fechaPedido.label" default="Fecha Pedido" /></span>
					
						<span class="property-value" aria-labelledby="fechaPedido-label"><g:formatDate date="${prestamoInstance?.fechaPedido}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${prestamoInstance?.fechaDevolucion}">
				<li class="fieldcontain">
					<span id="fechaDevolucion-label" class="property-label"><g:message code="prestamo.fechaDevolucion.label" default="Fecha Devolucion" /></span>
					
						<span class="property-value" aria-labelledby="fechaDevolucion-label"><g:formatDate date="${prestamoInstance?.fechaDevolucion}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${prestamoInstance?.id}" />
					<g:link class="edit" action="edit" id="${prestamoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
