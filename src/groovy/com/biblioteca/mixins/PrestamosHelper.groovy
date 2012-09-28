package com.biblioteca.mixins

import com.biblioteca.Libro
import com.biblioteca.Prestamo

class PrestamosHelper {
	def conPrestamo(id, callback) {
		def prestamo = Prestamo.get id
		
		if (!prestamo) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), id])
			flash.error = true
			redirect(action: "list")
			return
		}
		
		callback prestamo 
	}
	
	def conLibroParaPrestamo(socio, id, callback) {
		def libro = Libro.get id
		
		if (!libro) {
			flash.message = 'No se encuentra el libro'
			flash.error = true
			redirect(controller: 'libro', action: 'list')
			return
		}
		
		if (!libro.hayStockDisponible(socio)) {
			flash.message = 'No hay stock disponible. Puede realizar una reserva'
			flash.error = true
			redirect controller: 'libro', action: 'show', id: id
			return
		}
		
		def reserva = libro.reservaPendienteDeSocio socio
		if (reserva) {
			flash.message = 'Ya tiene reservado este libro'
			redirect controller: 'reserva', action: 'show', id: reserva.id
			return
		}
		
		callback libro
	}
}
