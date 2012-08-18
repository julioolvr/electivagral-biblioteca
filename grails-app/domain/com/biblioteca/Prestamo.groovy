package com.biblioteca

class Prestamo {
	
	Libro libro
	Socio socio
	Date fechaPedido
	Date fechaDevolucion
	
	static constraints = {
		libro nullable: false
		socio nullable: false
		fechaPedido nullable: false
		fechaDevolucion validator: { val, obj ->
			val > obj.fechaPedido
		}
	}
	
	static mapping = {
		table 'Prestamo'
		id column: 'idPrestamo'
		libro column: 'idLibro'
		socio column: 'idSocio'
		fechaPedido column: 'fechaPedido'
		fechaDevolucion column: 'fechaDevolucion'
	}
	
	Prestamo() {
		
	}
}
