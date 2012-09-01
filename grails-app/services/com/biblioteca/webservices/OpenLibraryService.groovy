package com.biblioteca.webservices

/**
 * Interfaz para los servicios de OpenLibrary - http://openlibrary.org/
 * 
 * @author julio
 */
class OpenLibraryService {
	
	def urlCover(libro) {
		new URL("http://covers.openlibrary.org/b/isbn/${libro.isbn}-L.jpg?default=false")
	}
	
	def coverDisponible(libro) {
		return false
		def url = urlCover(libro)
		
		try {
			url.getBytes()
		} catch (e) {
			return false
		}
		
		return true
	}
	
}
