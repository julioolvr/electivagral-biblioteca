package com.biblioteca.webservices

/**
 * Interfaz para los servicios de OpenLibrary - http://openlibrary.org/
 * 
 * @author julio
 */
class OpenLibraryService {
	
	def urlCover(libro) {
		"http://covers.openlibrary.org/b/isbn/${libro.isbn}-L.jpg"
	}
	
}
