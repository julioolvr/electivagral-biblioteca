<%@ page import="com.biblioteca.Reserva" %>



<div class="fieldcontain ${hasErrors(bean: reservaInstance, field: 'libro', 'error')} required">
	<label for="libro">
		<g:message code="reserva.libro.label" default="Libro" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="libro" name="libro.id" from="${com.biblioteca.Libro.list()}" optionKey="id" required="" value="${reservaInstance?.libro?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reservaInstance, field: 'socio', 'error')} required">
	<label for="socio">
		<g:message code="reserva.socio.label" default="Socio" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="socio" name="socio.id" from="${com.biblioteca.Socio.list()}" optionKey="id" required="" value="${reservaInstance?.socio?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: reservaInstance, field: 'fechaReserva', 'error')} required">
	<label for="fechaReserva">
		<g:message code="reserva.fechaReserva.label" default="Fecha Reserva" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaReserva" precision="day"  value="${reservaInstance?.fechaReserva}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: reservaInstance, field: 'fechaFinReserva', 'error')} required">
	<label for="fechaFinReserva">
		<g:message code="reserva.fechaFinReserva.label" default="Fecha Fin Reserva" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaFinReserva" precision="day"  value="${reservaInstance?.fechaFinReserva}"  />
</div>

