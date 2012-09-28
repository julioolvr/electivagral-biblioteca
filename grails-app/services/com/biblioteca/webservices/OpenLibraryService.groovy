package com.biblioteca.webservices

/**
 * Interfaz para los servicios de OpenLibrary - http://openlibrary.org/
 * 
 * @author julio
 */
class OpenLibraryService {
	
	def disponibilidad = [:]
	
	def urlCover(libro) {
		new URL("http://covers.openlibrary.org/b/isbn/${libro.isbn}-L.jpg?default=false")
	}
	
	def coverDisponible(libro) {
		if (libro.isbn in disponibilidad)
			return disponibilidad[libro.isbn]
		
		def url = urlCover(libro)
		
		try {
			url.getBytes()
		} catch (e) {
			return disponibilidad[libro.isbn] = false
		}
		
		disponibilidad[libro.isbn] = true
	}
	
}
