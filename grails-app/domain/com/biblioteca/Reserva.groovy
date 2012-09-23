package com.biblioteca

class Reserva {
	
	Libro libro
	
	// TODO: Cambiar a belongsTo
	Socio socio
	Date fechaReserva
	Date fechaFinReserva
	
	static constraints = {
		libro nullable: false
		socio nullable: false
		fechaReserva()
		fechaFinReserva nullable: true
	}
	
	static mapping = {
		table 'Reserva'
		id column: 'idReserva'
		libro column: 'idLibro'
		socio column: 'idSocio'
		fechaReserva column: 'fechaReserva'
		fechaFinReserva column: 'fechaFinReserva'
	}
	
	Date getFechaDisponibilidad() {
		libro.getFechaDisponibilidad(socio)
	}
	
	Boolean getDisponibleParaPrestamo() {
		// TODO: Ver si se puede optimizar
		libro.getFechaDisponibilidad(socio) <= new Date()
	}
}
