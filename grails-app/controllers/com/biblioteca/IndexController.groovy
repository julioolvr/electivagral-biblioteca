package com.biblioteca

class IndexController {
	
	// TODO: Esto va a ir en la clase de dominio
	def coverLibroService
		
	def index() {
		// Mockup de libros
		def ultimosLibros = [
			[titulo: "The hitchhiker's guide to the galaxy", autor: 'Douglas Adams', urlCover: coverLibroService.urlCover([isbn:'0330258648'])],
			[titulo: "1984", autor: 'George Orwell', urlCover: coverLibroService.urlCover([isbn:'0451524934'])],
			[titulo: "The restaurant at the end of the universe", autor: 'Douglas Adams', urlCover: coverLibroService.urlCover([isbn:'0345391810'])]
		]
		
		def masPedidos = [
			[titulo: "The hitchhiker's guide to the galaxy", stockDisponible: false],
			[titulo: "The restaurant at the end of the universe", stockDisponible: true],
			[titulo: "1984", stockDisponible: true],
			[titulo: "Ready player one", stockDisponible: false]
		]
		
		[ultimosLibros: ultimosLibros, masPedidos: masPedidos]
	}
	
}
