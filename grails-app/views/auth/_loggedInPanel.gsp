<p>Hola ${session.usuario.nombre}</p>
<p>
<%--	TODO: i18n	--%>
	<a href="${createLink(controller:'prestamo', action:'list')}">Mis préstamos</a>
	<a href="${createLink(controller:'auth', action:'logout')}">Salir</a>
</p>