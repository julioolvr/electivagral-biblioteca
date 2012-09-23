package com.biblioteca.mixins

import com.biblioteca.Libro

class ReservasHelper {
	def conLibroParaReserva(idLibro, socio, callback) {
		// Si no se pasó el id para el libro
		if (!idLibro) {
			flash.message = 'No se encuentra el libro.'
			flash.error = true
			redirect controller: 'libro', action: 'list'
			return
		}
		
		def libro = Libro.get(idLibro)
		
		// Si el libro no existe
		if (!libro) {
			flash.message = 'No se encuentra el libro.'
			flash.error = true
			redirect controller: 'libro', action: 'list'
			return
		}
		
		// Si hay stock, hacer un préstamo en vez de una reserva
		if (libro.hayStockDisponible()) {
			flash.message = "Hay stock disponible, solicite un préstamo."
			redirect controller: 'prestamo', action: 'create', idLibro: idLibro
			return
		}
		
		// Si ya tiene el libro prestado, no puede hacer una reserva
		if (socio.tieneLibroPrestado(libro)) {
			flash.message = "Ya tiene ese libro en su poder"
			flash.error = true
			redirect controller: 'prestamo', action: 'list'
			return
		}
		
		// Si ya tiene el libro reservado, no puede hacer otra reserva
		if (socio.tieneLibroReservado(libro)) {
			flash.message = "Ya tiene ese libro reservado"
			flash.error = true
			redirect controller: 'reserva', action: 'list'
			return
		}
		
		if (!libro.puedeReservarlo(socio)) {
			flash.message = "El libro no está disponible para su reserva."
			flash.error = true
			redirect controller: 'libro', action: 'list'
			return
		}
		
		callback libro
	}
}
