package com.biblioteca

class Prestamo {
	
	Libro libro
	Socio socio
	Date fechaPedido
	Date fechaDevolucion
	Date fechaRealDevolucion
	
	static constraints = {
		libro nullable: false, validator: {
			it.ejemplaresDisponibles > 0
		}
		socio nullable: false
		fechaPedido nullable: false
		fechaDevolucion validator: { val, obj ->
			val > obj.fechaPedido
		}
		fechaRealDevolucion nullable: true, validator: { val, obj ->
			!val || val > obj.fechaPedido
		}
	}
	
	static mapping = {
		table 'Prestamo'
		id column: 'idPrestamo'
		libro column: 'idLibro'
		socio column: 'idSocio'
		fechaPedido column: 'fechaPedido'
		fechaDevolucion column: 'fechaDevolucion'
		fechaRealDevolucion column: 'fechaRealDevolucion'
	}
	
	Prestamo() {
		
	}
}
