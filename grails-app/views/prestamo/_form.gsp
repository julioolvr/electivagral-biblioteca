<%@ page import="com.biblioteca.Prestamo" %>



<div class="fieldcontain ${hasErrors(bean: prestamoInstance, field: 'libro', 'error')} required">
	<label for="libro">
		<g:message code="prestamo.libro.label" default="Libro" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="libro" name="libro.id" from="${com.biblioteca.Libro.list()}" optionKey="id" required="" value="${prestamoInstance?.libro?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: prestamoInstance, field: 'socio', 'error')} required">
	<label for="socio">
		<g:message code="prestamo.socio.label" default="Socio" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="socio" name="socio.id" from="${com.biblioteca.Socio.list()}" optionKey="id" required="" value="${prestamoInstance?.socio?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: prestamoInstance, field: 'fechaPedido', 'error')} required">
	<label for="fechaPedido">
		<g:message code="prestamo.fechaPedido.label" default="Fecha Pedido" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaPedido" precision="day"  value="${prestamoInstance?.fechaPedido}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: prestamoInstance, field: 'fechaDevolucion', 'error')} required">
	<label for="fechaDevolucion">
		<g:message code="prestamo.fechaDevolucion.label" default="Fecha Devolucion" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaDevolucion" precision="day"  value="${prestamoInstance?.fechaDevolucion}"  />
</div>

