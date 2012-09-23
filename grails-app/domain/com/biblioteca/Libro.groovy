package com.biblioteca

class Libro {
	
	String titulo
	String autor
	String isbn
	Integer ejemplaresDisponibles = 0
	
	static hasMany = [prestamos:Prestamo, reservas:Reserva]
	
	static constraints = {
		titulo nullable: false, blank: false, size: 2..50
		autor nullable: false, blank: false, size: 5..50
		isbn nullable: false, blank: false, size: 10..20
		ejemplaresDisponibles()
	}
	
	static mapping = {
		table 'Libro'
		id column: 'idLibro'
		titulo column: 'titulo'
		autor column: 'autor'
		isbn column: 'isbn'
		ejemplaresDisponibles column: 'cantEj'
		prestamos column: 'idPrestamo'
		reservas column: 'idLibro'
	}
	
	String toString() {
		"${titulo} [${autor}]"
	}
	
	/*
	 *  Inyección de servicios
	 */
	def coverLibroService
	
	/**
	 * URL para una imagen del cover del libro.
	 * @return
	 */
	String getUrlCover() {
		coverLibroService.urlCover(this)
	}
	
	/**
	 * Hay stock disponible para realizar un préstamo.
	 * @return
	 */
	Boolean hayStockDisponible(socio) {
		def fechaDisponibilidad = this.getFechaDisponibilidad(socio)
		fechaDisponibilidad && (fechaDisponibilidad <= new Date())
	}
	
	Boolean tieneReservas() {
		// TODO: Cambiar por un count
		def reservas = Reserva.findAllByLibroAndFechaFinReservaIsNull this
		reservas.size > 0
	}
	
	void devolver() {
		ejemplaresDisponibles++
	}
	
	/**
	 * Fecha en la que debería estar disponible el libro para un usuario 
	 * si las devoluciones se efectúan a tiempo
	 * @return
	 */
	Date getFechaDisponibilidad(socio) {
		def reserva = Reserva.findByLibroAndSocioAndFechaFinReservaIsNotNull this, socio
		
		def reservasPendientes
		if (reserva)
			// TODO: Cambiar por un count
			reservasPendientes = Reserva.findAllByLibroAndSocioNotEqualAndFechaReservaLessThanAndFechaFinReservaIsNull this, socio, reserva.fechaReserva
		else
			reservasPendientes = Reserva.findAllByLibroAndSocioNotEqualAndFechaFinReservaIsNull this, socio
		
		def prestamos = Prestamo.findAllByLibroAndFechaRealDevolucionIsNull this, [sort: 'fechaDevolucion', order: 'asc']
		
		if (this.ejemplaresDisponibles > 0){
			/*
			 * Si hay ejemplares disponibles, hay dos alternativas:
			 * * No hay reservas pendientes de otros socios, el libro ya está disponible
			 */
				
			if (!reservasPendientes.size)
				return new Date()
			
			/*
			 * Hay reservas pendientes:
			 * * Si hay más ejemplares disponibles que reservas pendientes, ya está disponible
			 */
			if (ejemplaresDisponibles > reservasPendientes.size)
				return new Date()
			
			/*
			 * Hay la misma cantidad de ejemplares disponibles que de reservas pendientes:
			 */
			if (ejemplaresDisponibles == reservasPendientes.size) {
				/*
				 * Si hay préstamos, estará disponible cuando el primer préstamo se libere
				 */
				if (prestamos)
					return prestamos[0].fechaDevolucion
				else
					/*
					 * Si no, están todos los ejemplares reservados
					 */
					return null
			}
			
			/*
			 * Hay más reservas pendientes que ejemplares disponibles:
			 * Descartando las reservas que ya tienen su ejemplar disponible,
			 * Si hay menos reservas que préstamos, tomo la fecha en que se libera el préstamo correspondiente
			 */
			if (reservasPendientes.size - ejemplaresDisponibles < prestamos.size)
				return prestamos[reservasPendientes.size - ejemplaresDisponibles].fechaDevolucion
			
			/*
			 * Si hay la misma cantidad o más, todas las copias están reservadas
			 */
			return null
		} else {
			/*
			 * Si no hay ejemplares disponibles
			 * * Si hay menos reservas pendientes que préstamos, dar la fecha de devolución del préstamo correspondiente
			 */
			if (reservasPendientes.size < prestamos.size)
				return prestamos[reservasPendientes.size].fechaDevolucion
				
			/*
			 * Si hay la misma cantidad o más, todos los ejemplares están reservados
			 */
			return null
		}
	}
	
	Boolean puedeReservarlo(socio) {
		this.getFechaDisponibilidad() as Boolean
	}
}