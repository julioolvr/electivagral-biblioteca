package com.biblioteca

import org.springframework.dao.DataIntegrityViolationException

class PrestamoController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def grailsApplication

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		if (!session.usuario) {
			/*
			 * Debe estar logueado para realizar un préstamo
			 */
			// TODO: i18n
			// TODO: Mover a un filter
			flash.message = "Debe estar logueado para solicitar un préstamo"
			redirect controller: 'index'
			return
		}
		
		params.max = Math.min(max ?: 10, 100)
		[prestamoInstanceList: Prestamo.findAllBySocio(session.usuario, params), prestamoInstanceTotal: Prestamo.count()]
	}

	def create() {
		if (!session.usuario) {
			/*
			 * Debe estar logueado para realizar un préstamo
			 */
			// TODO: i18n
			// TODO: Mover a un filter
			flash.message = "Debe estar logueado para solicitar un préstamo"
			redirect controller: 'index'
			return
		}
		
		def parametros = [socio:session.usuario]
		
		if (params.idLibro) {
			parametros += [libro:Libro.get(params.idLibro)]
		}
		
		[prestamo: new Prestamo(params + parametros)]
	}

	def save() {
		def parametros = params
		
		parametros += [
			fechaPedido: new Date(),
			fechaDevolucion: new Date() + grailsApplication.config.prestamo.limiteDevolucion
		]
		
		def prestamo = new Prestamo(parametros)
		if (!prestamo.save(flush: true)) {
			render(view: "create", model: [prestamo: prestamo])
			return
		}
		
		// TODO: Mover a un beforeSave o algo así
		prestamo.libro.ejemplaresDisponibles--
		prestamo.libro.save()
		
		flash.message = message(code: 'default.created.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), prestamo.id])
		redirect(action: "show", id: prestamo.id)
	}

	def show(Long id) {
		if (!session.usuario) {
			/*
			 * Debe estar logueado para realizar un préstamo
			 */
			// TODO: i18n
			// TODO: Mover a un filter
			flash.message = "Debe estar logueado para solicitar un préstamo"
			redirect controller: 'index'
			return
		}
		
		def prestamo = Prestamo.get(id)
		if (!prestamo) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), id])
			redirect(action: "list")
			return
		}

		[prestamo: prestamo]
	}

	def edit(Long id) {
		def prestamoInstance = Prestamo.get(id)
		if (!prestamoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), id])
			redirect(action: "list")
			return
		}

		[prestamoInstance: prestamoInstance]
	}

	def update(Long id, Long version) {
		def prestamoInstance = Prestamo.get(id)
		if (!prestamoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), id])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (prestamoInstance.version > version) {
				prestamoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
					[message(code: 'prestamo.label', default: 'Prestamo')] as Object[],
						"Another user has updated this Prestamo while you were editing")
				render(view: "edit", model: [prestamoInstance: prestamoInstance])
				return
			}
		}

		prestamoInstance.properties = params

		if (!prestamoInstance.save(flush: true)) {
			render(view: "edit", model: [prestamoInstance: prestamoInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), prestamoInstance.id])
		redirect(action: "show", id: prestamoInstance.id)
	}

	def delete(Long id) {
		def prestamoInstance = Prestamo.get(id)
		if (!prestamoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), id])
			redirect(action: "list")
			return
		}

		try {
			prestamoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), id])
			redirect(action: "show", id: id)
		}
	}
	
	def renovar(Long id) {
		def prestamo = Prestamo.get(id)
		if (!prestamo) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), id])
			redirect(action: "list")
			return
		}
		
		if (prestamo.libro.tieneReservas()) {
			// TODO: i18n
			flash.message = 'Este libro tiene reservas pendientes, no se puede renovar el préstamo.'
			redirect(action: "list")
			return
		}
		
		[prestamo: prestamo]
	}
	
	def generarRenovacion(Long id) {
		def prestamo = Prestamo.get(id)
		if (!prestamo) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), id])
			redirect(action: "list")
			return
		}
		
		if (prestamo.libro.tieneReservas()) {
			// TODO: i18n
			flash.message = 'Este libro tiene reservas pendientes, no se puede renovar el préstamo.'
			redirect(action: "list")
			return
		}
		
		prestamo.fechaDevolucion = new Date() + grailsApplication.config.prestamo.limiteDevolucion
		prestamo.save()
		
		redirect action: 'show', id: prestamo.id
	}
}