<%@ page import="com.biblioteca.Prestamo" %>

<div class="fieldcontain ${hasErrors(bean: prestamo, field: 'libro', 'error')} required">
	<label for="libro">
		<g:message code="prestamo.libro.label" default="Libro" />
		<span class="required-indicator">*</span>
	</label>
	<input type="text" id="libro" value="${prestamo?.libro}"/>
	<input type="hidden" id="libro.id" name="libro.id" value="${prestamo?.libro?.id}" />
</div>

<input type="hidden" id="socio.id" name="socio.id" value="${prestamo?.socio?.id}" />
<%--<div class="fieldcontain ${hasErrors(bean: prestamo, field: 'socio', 'error')} required">--%>
<%--	<label for="socio">--%>
<%--		<g:message code="prestamo.socio.label" default="Socio" />--%>
<%--		<span class="required-indicator">*</span>--%>
<%--	</label>--%>
<%--	${prestamo?.socio}--%>
<%--</div>--%>

<%--<div class="fieldcontain ${hasErrors(bean: prestamo, field: 'fechaPedido', 'error')} required">--%>
<%--	<label for="fechaPedido">--%>
<%--		<g:message code="prestamo.fechaPedido.label" default="Fecha Pedido" />--%>
<%--		<span class="required-indicator">*</span>--%>
<%--	</label>--%>
<%--	<g:datePicker name="fechaPedido" precision="day"  value="${prestamo?.fechaPedido}"  />--%>
<%--</div>--%>
<%----%>
<%--<div class="fieldcontain ${hasErrors(bean: prestamo, field: 'fechaDevolucion', 'error')} required">--%>
<%--	<label for="fechaDevolucion">--%>
<%--		<g:message code="prestamo.fechaDevolucion.label" default="Fecha Devolucion" />--%>
<%--		<span class="required-indicator">*</span>--%>
<%--	</label>--%>
<%--	<g:datePicker name="fechaDevolucion" precision="day"  value="${prestamo?.fechaDevolucion}"  />--%>
<%--</div>--%>

