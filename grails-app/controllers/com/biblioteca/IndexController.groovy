package com.biblioteca

class IndexController {
	
	def libroService
		
	def index() {
		def ultimosLibros = libroService.ultimosLibros()
		
		def masPedidos = libroService.masPedidos()
		
		[ultimosLibros: ultimosLibros, masPedidos: masPedidos]
	}
	
}
