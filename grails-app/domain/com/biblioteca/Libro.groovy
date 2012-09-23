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
	Boolean hayStockDisponible() {
		ejemplaresDisponibles > 0
	}
	
	Boolean tieneReservas() {
		ejemplaresDisponibles < 0
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
		/*
		 * Préstamos no devueltos para este libro.
		 */
		def prestamos = Prestamo.findAllByLibroAndFechaRealDevolucionIsNull this, [sort: 'fechaDevolucion', order: 'asc']
		
		/*
		 * Busco si este socio ya tiene reserva para el libro
		 */
		def reserva = Reserva.findByLibroAndSocio this, socio
		
		/*
		 * Reservas para este libro no cumplidas, y de otros socios.
		 * * Si el socio tiene una reserva, solo las anteriores a esa.
		 */
		def reservas
		if (reserva)
			// TODO: Cambiar por un count
			reservas = Reserva.findAllByLibroAndSocioNotEqualAndFechaReservaLessThanAndFechaFinReservaIsNull this, socio, reserva.fechaReserva
		else
			reservas = Reserva.findAllByLibroAndSocioNotEqualAndFechaFinReservaIsNull this, socio

		if (!prestamos && !reservas)
			/*
			 * Si no hay préstamos ni reservas de otros socios,
			 * el libro ya está disponible
			 */
			return new Date()
		
		if (prestamos.size > reservas.size)
			/*
			 * Si hay más préstamos que reservas, estará disponible cuando el primer
			 * préstamo se libere, descontando tantos préstamos como reservas haya.
			 */
			return prestamos[reservas.size].fechaDevolucion
		
		/*
		 * Si hay más reservas que préstamos, no se puede reservar
		 */
		return null
	}
	
	Boolean puedeReservarLibro(socio) {
		this.getFechaDisponibilidad() as Boolean
	}
}