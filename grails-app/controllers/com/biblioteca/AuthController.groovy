package com.biblioteca

class AuthController {
	
	def login(String login, String password) {
		def socio = Socio.findByLoginAndPassword(login, password)
		
		if (socio) {
			// Mostrar devoluciones pendientes al socio
			flash.prestamosPendientes = socio.prestamosPendientes
			flash.prestamosExpirados = socio.prestamosExpirados
			
			session.usuario = socio
			redirect controller: 'index'
		} else {
			session.usuario = null
			redirect controller: 'index'
		}
	}
	
	def logout() {
		session.usuario = null
		redirect controller: 'index'
	}
	
	def asociarse() {
		/*
		 * Si el usuario está logueado, no permitirle asociarse
		 */
		if (session.usuario) {
			redirect controller: 'index'
		}
	}
	
	def guardar() {
		def socio = new Socio(params)
		
		if (!socio.save(flush: true)) {
			chain(action: 'asociarse', model: [socio: socio])
			return
		}
		
		flash.message = message(code: 'default.created.message', args: [message(code: 'socio.label', default: 'Socio'), socio.id])
		session.usuario = socio
		redirect controller: 'index'
	}
}
