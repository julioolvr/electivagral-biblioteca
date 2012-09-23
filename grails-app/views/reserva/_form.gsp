<%@ page import="com.biblioteca.Reserva" %>

<div>
	<h2>${reserva.libro}</h2>
</div>

<input type="hidden" id="libro.id" name="libro.id" value="${reserva?.libro?.id}" />
<input type="hidden" id="socio.id" name="socio.id" value="${reserva?.socio?.id}" />

<div class="message">
	Disponible el ${reserva?.libro?.getFechaDisponibilidad(reserva.socio)}
</div>