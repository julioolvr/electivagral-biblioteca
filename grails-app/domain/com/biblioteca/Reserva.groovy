package com.biblioteca

class Reserva {
	
	Libro libro
	Socio socio
	Date fechaReserva
	Date fechaFinReserva
	
	static constraints = {
		libro nullable: false
		socio nullable: false
		fechaReserva()
		fechaFinReserva()
	}
	
	static mapping = {
		table 'Reserva'
		id column: 'idReserva'
		libro column: 'idLibro'
		socio column: 'idSocio'
		fechaReserva column: 'fechaReserva'
		fechaFinReserva column: 'fechaFinReserva'
	}
}
