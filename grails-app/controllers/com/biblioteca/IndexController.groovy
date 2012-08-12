package com.biblioteca

class IndexController {
	
	def index() {
		// Mockup de libros
		def ultimosLibros = [
			[urlImagen: "http://foundation.zurb.com/images/orbit-demo/demo1.jpg"],
			[urlImagen: "http://foundation.zurb.com/images/orbit-demo/demo2.jpg"],
			[urlImagen: "http://foundation.zurb.com/images/orbit-demo/demo3.jpg"]
		]
		
		def masPedidos = [
			[nombre: "The hitchiker's guide to the galaxy", stockDisponible: false],
			[nombre: "The restaurant at the end of the universe", stockDisponible: true],
			[nombre: "1984", stockDisponible: true],
			[nombre: "Ready player one", stockDisponible: false]
		]
		
		[ultimosLibros: ultimosLibros, masPedidos: masPedidos]
	}
	
}
