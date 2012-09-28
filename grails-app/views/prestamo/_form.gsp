<%@ page import="com.biblioteca.Prestamo" %>

<p>${prestamo?.libro}</p>
<input type="hidden" id="libro.id" name="libro.id" value="${prestamo?.libro?.id}" />
<input type="hidden" id="socio.id" name="socio.id" value="${prestamo?.socio?.id}" />
