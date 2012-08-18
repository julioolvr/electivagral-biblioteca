<%@ page import="com.biblioteca.Socio" %>



<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'dni', 'error')} required">
	<label for="dni">
		<g:message code="socio.dni.label" default="Dni" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="dni" type="number" value="${socioInstance.dni}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="socio.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="50" required="" value="${socioInstance?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'login', 'error')} required">
	<label for="login">
		<g:message code="socio.login.label" default="Login" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="login" maxlength="20" required="" value="${socioInstance?.login}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="socio.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" maxlength="40" required="" value="${socioInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="socio.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" maxlength="50" required="" value="${socioInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'prestamos', 'error')} ">
	<label for="prestamos">
		<g:message code="socio.prestamos.label" default="Prestamos" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${socioInstance?.prestamos?}" var="p">
    <li><g:link controller="prestamo" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="prestamo" action="create" params="['socio.id': socioInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'prestamo.label', default: 'Prestamo')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: socioInstance, field: 'reservas', 'error')} ">
	<label for="reservas">
		<g:message code="socio.reservas.label" default="Reservas" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${socioInstance?.reservas?}" var="r">
    <li><g:link controller="reserva" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="reserva" action="create" params="['socio.id': socioInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'reserva.label', default: 'Reserva')])}</g:link>
</li>
</ul>

</div>

