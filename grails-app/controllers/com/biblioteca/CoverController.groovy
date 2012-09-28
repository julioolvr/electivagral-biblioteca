package com.biblioteca

class CoverController {
	
	def coverLibroService
	
	def cover(Long id) {
		def libro = Libro.get(id)
		
	}
}
