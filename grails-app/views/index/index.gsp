<html>
	<head>
		<meta name="layout" content="main"/>
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'index.css')}" type="text/css">
		<title>${message(code:'app.titulo')}</title>
	</head>
	<body>
		<div class="row">
			<h2><g:message code="general.ultimosLibros"/></h2>
			<div class="eight columns">
				<div id="ultimos-libros">
					<g:each in="${ultimosLibros}">
						<div class="row coverLibro">
							<div class="four columns">
								<img src="${it.urlCover}"/>
							</div>
							<div class="eight columns">
								<h3>${it.titulo}</h3>
								<h5>${it.autor}</h5>
							</div>
						</div>
					</g:each>
				</div>
			</div>
			<div class="four columns">
				<h4><g:message code="general.masPedidos"/></h4>
				<ul>
					<g:each in="${masPedidos}">
						<li>${it.titulo} <g:if test="${!it.stockDisponible}"><span class="radius alert label">Sin stock</span></g:if></li>
					</g:each>
				</ul>
			</div>
		</div>
	</body>
</html>
