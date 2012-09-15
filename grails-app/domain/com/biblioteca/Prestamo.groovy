package com.biblioteca

class Prestamo {
	
	Libro libro
	Socio socio
	Date fechaPedido
	Date fechaDevolucion
	Date fechaRealDevolucion
	
	static constraints = {
		libro nullable: false, validator: { libro, prestamo, errores ->
			if (!libro.hayStockDisponible())
				errores.reject 'faltaStock', 'No hay stock disponible para un préstamo.'
				
			if (prestamo.socio.tieneLibroPrestado(libro))
				errores.reject 'yaPrestado', 'Ya tiene un préstamo activo para este libro.'
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
	
	String toString() {
		"${libro} - Fecha de devolución ${fechaDevolucion}"
	}
	
	Boolean puedeRenovarse() {
		libro.tieneReservas()
	}
	
	Boolean devuelto() {
		fechaRealDevolucion != null
	}
	
	Boolean devolver() {
		fechaRealDevolucion = new Date()
		libro.devolver()
	}
}