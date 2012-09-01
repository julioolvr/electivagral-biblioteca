package com.biblioteca

import org.springframework.dao.DataIntegrityViolationException

class PrestamoController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[prestamoInstanceList: Prestamo.list(params), prestamoInstanceTotal: Prestamo.count()]
	}

	def create() {
		def parametros = [socio:session.usuario]
		
		println 'CREAR PRESTAMO'
		println params
		
		if (params.idLibro) {
			parametros += [libro:Libro.get(params.idLibro)]
		}
		
		[prestamo: new Prestamo(params + parametros)]
	}

	def save() {
		def prestamo = new Prestamo(params)
		if (!prestamo.save(flush: true)) {
			println 'ERROR'
			println prestamo.errors
			render(view: "create", model: [prestamo: prestamo])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), prestamo.id])
		redirect(action: "show", id: prestamo.id)
	}

	def show(Long id) {
		def prestamoInstance = Prestamo.get(id)
		if (!prestamoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), id])
			redirect(action: "list")
			return
		}

		[prestamoInstance: prestamoInstance]
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
}