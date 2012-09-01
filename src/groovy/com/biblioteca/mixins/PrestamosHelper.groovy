package com.biblioteca.mixins

import com.biblioteca.Prestamo

class PrestamosHelper {
	def conPrestamo(id, callback) {
		def prestamo = Prestamo.get(id)
		
		if (!prestamo) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), id])
			redirect(action: "list")
			return
		}
		
		callback prestamo 
	}
}
