package com.biblioteca

import static org.junit.Assert.*
import grails.test.mixin.TestFor

import org.junit.*


class CoverLibroServiceTests {
	
	def coverLibroService
	def informacionLibroService
	
	@Test
	void testUrlCover() {
		// TODO: Reemplazar por un mock/instancia de libro real
		def libro = [isbn:'0330258648']
		
		assert coverLibroService.urlCover(libro) == informacionLibroService.urlCover(libro)
	}
}
