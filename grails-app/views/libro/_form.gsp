<%@ page import="com.biblioteca.Libro" %>



<div class="fieldcontain ${hasErrors(bean: libroInstance, field: 'titulo', 'error')} required">
	<label for="titulo">
		<g:message code="libro.titulo.label" default="Titulo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titulo" maxlength="50" required="" value="${libroInstance?.titulo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: libroInstance, field: 'autor', 'error')} required">
	<label for="autor">
		<g:message code="libro.autor.label" default="Autor" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="autor" maxlength="50" required="" value="${libroInstance?.autor}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: libroInstance, field: 'isbn', 'error')} required">
	<label for="isbn">
		<g:message code="libro.isbn.label" default="Isbn" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="isbn" maxlength="20" required="" value="${libroInstance?.isbn}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: libroInstance, field: 'ejemplaresDisponibles', 'error')} required">
	<label for="ejemplaresDisponibles">
		<g:message code="libro.ejemplaresDisponibles.label" default="Ejemplares Disponibles" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ejemplaresDisponibles" type="number" value="${libroInstance.ejemplaresDisponibles}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: libroInstance, field: 'prestamos', 'error')} ">
	<label for="prestamos">
		<g:message code="libro.prestamos.label" default="Prestamos" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${libroInstance?.prestamos?}" var="p">
    <li><g:link controller="prestamo" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="prestamo" action="create" params="['libro.id': libroInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'prestamo.label', default: 'Prestamo')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: libroInstance, field: 'reservas', 'error')} ">
	<label for="reservas">
		<g:message code="libro.reservas.label" default="Reservas" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${libroInstance?.reservas?}" var="r">
    <li><g:link controller="reserva" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="reserva" action="create" params="['libro.id': libroInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'reserva.label', default: 'Reserva')])}</g:link>
</li>
</ul>

</div>

