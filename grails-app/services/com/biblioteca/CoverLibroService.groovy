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
		if (informacionLibroService.coverDisponible(libro))
			informacionLibroService.urlCover(libro)
		else
			urlCoverNoDisponible()
	}
	
	def urlCoverNoDisponible() {
		def g = new org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib()
		g.resource(dir:'images', file:'cover-no-disponible.png').toString()
	}
	
}
