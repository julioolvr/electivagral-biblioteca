package com.biblioteca.mixins

class UsuariosHelper {
	def conUsuarioLogueado(callback) {
		if (!session.usuario) {
			// TODO: i18n
			// TODO: Mover a un filter
			flash.message = "Debe iniciar sesión"
			flash.error = true
			redirect controller: 'index'
			return
		}
		
		callback session.usuario
	}
}
