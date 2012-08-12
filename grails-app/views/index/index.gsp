<html>
	<head>
		<meta name="layout" content="main"/>
		<title>${message(code:'app.titulo')}</title>
	</head>
	<body>
		<div class="row">
			<h2><g:message code="general.ultimosLibros"/></h2>
			<div class="eight columns">
				<div id="ultimos-libros">
					<g:each in="${ultimosLibros}">
						<img src="${it.urlImagen}" />
					</g:each>
				</div>
			</div>
			<div class="four columns">
				<h4><g:message code="general.masPedidos"/></h4>
				<ul>
					<g:each in="${masPedidos}">
						<li>${it.nombre} <g:if test="${!it.stockDisponible}"><span class="radius alert label">Sin stock</span></g:if></li>
					</g:each>
				</ul>
			</div>
		</div>
	</body>
</html>
