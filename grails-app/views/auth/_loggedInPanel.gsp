<p>Hola ${session.usuario.nombre}</p>
<p>
<%--	TODO: i18n	--%>
	<a href="${createLink(controller:'prestamo')}">Mis préstamos</a>
	<a href="${createLink(controller:'reserva')}">Mis reservas</a>
	<a href="${createLink(controller:'auth', action:'logout')}">Salir</a>
</p>