package com.biblioteca

import org.springframework.dao.DataIntegrityViolationException

@Mixin([com.biblioteca.mixins.PrestamosHelper, com.biblioteca.mixins.UsuariosHelper])
class PrestamoController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def grailsApplication

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		conUsuarioLogueado { socio ->
			params.max = Math.min(max ?: 10, 100)
			[prestamoInstanceList: Prestamo.findAllBySocio(socio, params), prestamoInstanceTotal: Prestamo.count()]
		}
	}

	def create() {
		conUsuarioLogueado { socio ->
			def parametros = [socio:socio]
			def libro
			
			if (params.idLibro) {
				libro = Libro.get(params.idLibro)
			}
			
			if (!libro.hayStockDisponible()) {
				flash.message = 'No hay stock disponible. Puede realizar una reserva'
				flash.error = true
				redirect controller: 'libro', action: 'show', id: params.idLibro
				return
			}
					
			if (libro) {
				parametros += [libro:libro]
			}
			
			[prestamo: new Prestamo(params + parametros)]
		}
	}

	def save() {
		conUsuarioLogueado {
			def parametros = params
			
			// TODO: Ver de poner las fechas como default
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
	}

	def show(Long id) {
		conUsuarioLogueado {
			conPrestamo(id) { prestamo ->
				[prestamo: prestamo]
			}
		}
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
		conPrestamo(id) { prestamo ->
			if (!prestamo.puedeRenovarse()) {
				// TODO: i18n
				flash.message = 'Este libro tiene reservas pendientes, no se puede renovar el préstamo.'
				redirect(action: "list")
				return
			}
			
			[prestamo: prestamo]
		}
	}
	
	def generarRenovacion(Long id) {
		conPrestamo(id) { prestamo ->
			if (!prestamo.puedeRenovarse()) {
				// TODO: i18n
				flash.message = 'Este libro tiene reservas pendientes, no se puede renovar el préstamo.'
				redirect(action: "list")
				return
			}
			
			prestamo.fechaDevolucion = new Date() + grailsApplication.config.prestamo.limiteDevolucion
			prestamo.save()
			flash.message = 'Préstamo renovado'
			redirect action: 'show', id: prestamo.id
		}
	}
	
	def devolver(Long id) {
		conUsuarioLogueado {
			conPrestamo(id) { prestamo ->
				if (prestamo.devuelto()) {
					flash.message = 'El préstamo ya fue devuelto'
					flash.error = true
					redirect action: 'show', params: [id: prestamo.id]
					return
				}
				
				prestamo.devolver()
				
				if (!prestamo.save()) {
					flash.message = 'Hubo un error registrando la devolución del libro'
					flash.error = true
					redirect action: 'show', params: [id: prestamo.id]
					return
				}
				
				flash.message = 'Se ha devuelto el libro'
				redirect action: 'list'
			}
		}
	}
}