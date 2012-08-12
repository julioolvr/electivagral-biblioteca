package com.biblioteca

import org.apache.catalina.core.ApplicationContext;

/**
 * Servicio para obtener covers de los libros
 * 
 * @author julio
 */
class CoverLibroService {
	
	def informacionLibroService
	
	def urlCover(libro) {
		informacionLibroService.urlCover(libro)
	}
	
}
