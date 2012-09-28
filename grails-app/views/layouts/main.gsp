<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css/ui-darkness', file: 'jquery-ui-1.8.23.custom.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'foundation.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'app.css')}" type="text/css">
		
		<!-- IE Fix for HTML5 Tags -->
		<!--[if lt IE 9]>
			<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<r:require module="application" />
		<g:layoutHead/>
		<r:layoutResources />
	</head>
	<body>
		<div class="wrapper">
			<div class="row header">
				<div class="eight columns">
					<h1><a href="${createLink(controller:'index')}">${message(code:'app.titulo')}</a></h1>
				</div>
				<div class="four columns">
					<g:render template="/auth/authPanel" />
				</div>
			</div>
			<ul class="nav-bar">
				<li class="${params.controller == 'index' ? 'active' : ''}"><a href="${createLink(controller:'index')}">Inicio</a></li>
				<li class="${params.controller == 'libro' ? 'active' : ''}"><a href="${createLink(controller:'libro')}">Libros</a></li>
			</ul>
			<g:if test="${flash.message}">
				<div class="message row">
						<div class="alert-box ${flash.error ? 'alert' : ''}" role="status">${flash.message}</div>
				</div>
			</g:if>
			<g:layoutBody/>
			<div class="push"></div>
		</div>
		<div class="row footer">
			<div class="two columns">
				Electiva General<br/>2012
			</div>
			<div class="two columns">
				Julio Olivera<br/>3901-0393
			</div>
		</div>
		<r:layoutResources />
	</body>
</html>