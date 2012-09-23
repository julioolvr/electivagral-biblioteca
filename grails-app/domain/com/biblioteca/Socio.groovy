package com.biblioteca

class Socio {
	
	Integer dni
	String nombre
	String login
	String password
	String email
	
	static hasMany = [prestamos:Prestamo, reservas:Reserva]
	
	static constraints = {
		dni nullable: false, blank: false, unique: true
		nombre nullable: false, blank: false, size: 5..50
		login nullable: false, blank: false, unique: true, size: 5..20
		password nullable: false, blank: false, size: 10..40
		email nullable: false, blank: false, email: true, unique: true, size: 0..50
	}
	
	static mapping = {
		table 'Socio'
		id column: 'idSocio'
		dni column: 'dni'
		nombre column: 'nombre'
		password column: 'password'
		login column: 'nomUsuario'
		prestamos column: 'idSocio'
		reservas column: 'idSocio'
	}
	
	String toString() {
		"${dni} - ${nombre}"
	}
	
	Boolean tieneLibroPrestado(libro) {
		// TODO: Cambiar por un count
		Prestamo.findAllByLibroAndSocioAndFechaRealDevolucionIsNull(libro, this) as Boolean
	}
	
	Boolean puedePedirPrestamo(libro) {
		!tieneLibroPrestado(libro)
	}
	
	Boolean tieneLibroReservado(libro) {
		// TODO: Cambiar por un count
		Reserva.findAllByLibroAndSocioAndFechaFinReservaIsNull(libro, this) as Boolean
	}
	
	List getPrestamosPendientes() {
		Prestamo.findAllBySocioAndFechaDevolucionGreaterThanAndFechaRealDevolucionIsNull this, new Date(), [fetch: [libro: 'join']]
	}
	
	List getPrestamosExpirados() {
		Prestamo.findAllBySocioAndFechaDevolucionLessThanEqualsAndFechaRealDevolucionIsNull this, new Date(), [fetch: [libro: 'join']]
	}
	
	// Sobrecarga de operadores
	boolean equals(socio) {
		this.id == socio.id
	}
}