package com.biblioteca

import org.springframework.dao.DataIntegrityViolationException

@Mixin([com.biblioteca.mixins.UsuariosHelper])
class ReservaController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		conUsuarioLogueado { socio ->
			params.max = Math.min(max ?: 10, 100)
			def reservas = Reserva.findAllBySocio(socio, params)
			[reservaList: reservas, reservaTotal: reservas.size]
		}
	}

	def create() {
		conUsuarioLogueado { socio ->
			def parametros = [socio:socio]
			def libro
			
			if (params.idLibro) {
				libro = Libro.get(params.idLibro)
				parametros += [libro:libro]
			}
			
			// TODO: Si hay stock, mandarlo a hacer un préstamo en vez de una reserva
			// TODO: Un usuario no puede reservar un libro que tiene prestado
			// TODO: Un usuario no puede reservar un libro que tiene reservado
			
			[reserva: new Reserva(params + parametros)]
		}
	}

	def save() {
		conUsuarioLogueado { socio ->
			def parametros = params
			
			parametros += [fechaReserva: new Date()]
			
			def reserva = new Reserva(parametros)
			if (!reserva.save(flush: true)) {
				render(view: "create", model: [reserva: reserva])
				return
			}
			
			reserva.libro.ejemplaresDisponibles--
			reserva.libro.save()
			
			flash.message = message(code: 'default.created.message', args: [message(code: 'reserva.label', default: 'Reserva'), reserva.id])
			redirect(action: "show", id: reserva.id)
		}
	}

	def show(Long id) {
		conUsuarioLogueado { socio ->
			def reserva = Reserva.get(id)
			
			if (!reserva) {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'reserva.label', default: 'Reserva'), id])
				redirect(action: "list")
				return
			}
			
			[reserva: reserva]
		}
	}

	def generarPrestamo(Long id) {
		conUsuarioLogueado { socio ->
			def reserva = Reserva.get(id)
			
			if (!reserva) {
				flash.message = message(code: 'default.not.found.message', args: [message(code: 'reserva.label', default: 'Reserva'), id])
				redirect(action: "list")
				return
			}
			
			if (reserva.socio != socio) {
				flash.message = "La reserva no le pertenece."
				redirect(action: "list")
				return
			}
			
			def prestamo = new Prestamo(libro:reserva.libro,
				socio:socio,
				fechaPedido:new Date(),
				fechaDevolucion:new Date() + grailsApplication.config.prestamo.limiteDevolucion
			)
			
			if (prestamo.save()) {
				// TODO: Mover a un beforeSave o algo así
				prestamo.libro.ejemplaresDisponibles--
				prestamo.libro.save()
				
				flash.message = message(code: 'default.created.message', args: [message(code: 'prestamo.label', default: 'Prestamo'), prestamo.id])
				redirect(action: "show", id: prestamo.id)
				redirect(controller: 'prestamo', action: 'show', id: prestamo.id)
			}
		}
	}

    def edit(Long id) {
        def reserva = Reserva.get(id)
        if (!reserva) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reserva.label', default: 'Reserva'), id])
            redirect(action: "list")
            return
        }

        [reserva: reserva]
    }

    def update(Long id, Long version) {
        def reserva = Reserva.get(id)
        if (!reserva) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reserva.label', default: 'Reserva'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (reserva.version > version) {
                reserva.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'reserva.label', default: 'Reserva')] as Object[],
                          "Another user has updated this Reserva while you were editing")
                render(view: "edit", model: [reserva: reserva])
                return
            }
        }

        reserva.properties = params

        if (!reserva.save(flush: true)) {
            render(view: "edit", model: [reserva: reserva])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'reserva.label', default: 'Reserva'), reserva.id])
        redirect(action: "show", id: reserva.id)
    }

    def delete(Long id) {
        def reserva = Reserva.get(id)
        if (!reserva) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reserva.label', default: 'Reserva'), id])
            redirect(action: "list")
            return
        }

        try {
            reserva.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'reserva.label', default: 'Reserva'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'reserva.label', default: 'Reserva'), id])
            redirect(action: "show", id: id)
        }
    }
}
