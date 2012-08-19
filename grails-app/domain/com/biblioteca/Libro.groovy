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
	Boolean getHayStockDisponible() {
		ejemplaresDisponibles > 0
	}
}
