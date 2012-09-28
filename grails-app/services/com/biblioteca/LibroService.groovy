package com.biblioteca

class LibroService {
	
	def ultimosLibros() {
		Libro.list(max: 10)
	}
	
	def masPedidos() {
		Libro.list()
	}
	
}
