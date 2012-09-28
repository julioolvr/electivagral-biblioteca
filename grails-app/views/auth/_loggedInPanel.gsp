<h4>¡Bienvenido ${session.usuario.nombre}!</h4>
<ul class="square">
	<li><a href="${createLink(controller:'prestamo')}">Mis préstamos</a></li>
	<li><a href="${createLink(controller:'reserva')}">Mis reservas</a></li>
	<li><a href="${createLink(controller:'auth', action:'logout')}">Salir</a></li>
</ul>