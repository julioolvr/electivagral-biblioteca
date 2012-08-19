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
	
}