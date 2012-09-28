<html>
	<head>
		<meta name="layout" content="main"/>
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'index.css')}" type="text/css">
		<title>${message(code:'app.titulo')}</title>
	</head>
	<body>
		<div class="container row">
			<g:if test="${flash.prestamosExpirados}">
				El préstamos de los siguientes libros ya expiró:
				<ul>
					<g:each in="${flash.prestamosExpirados}">
						<li>${it}</li>
					</g:each>
				</ul>
			</g:if>
			<g:if test="${flash.prestamosPendientes}">
				Tiene los siguientes libros en su poder:
				<ul>
					<g:each in="${flash.prestamosPendientes}">
						<li>${it}</li>
					</g:each>
				</ul>
			</g:if>
			<h2><g:message code="general.ultimosLibros"/></h2>
			<div class="eight columns ultimo-container">
				<div id="ultimos-libros">
					<g:each in="${ultimosLibros}">
						<div class="row coverLibro">
							<div class="four columns">
								<img src="${it.urlCover}"/>
							</div>
							<div class="eight columns info">
								<h3><a href="${createLink(controller: 'libro', action: 'show', id: it.id)}">${it.titulo}</a></h3>
								<h5>${it.autor}</h5>
							</div>
						</div>
					</g:each>
				</div>
			</div>
		</div>
	</body>
</html>
