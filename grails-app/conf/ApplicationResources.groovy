modules = {
	application {
		resource url:'js/jquery.js'
		resource url:'js/jquery-ui-1.8.23.custom.min.js'
		resource url:'js/jquery.placeholder.js'
		resource url:'js/jquery.foundation.forms.js'
		resource url:'js/jquery.foundation.orbit.js'
		resource url:'js/jquery.foundation.navigation.js'
		resource url:'js/app.js'
	}
	
	prestamoCreate {
		dependsOn 'application'
		
		resource url: 'js/prestamo/create.js'
	}
}