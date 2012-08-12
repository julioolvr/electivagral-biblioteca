package com.biblioteca.webservices

import grails.test.mixin.*
import org.junit.*

@TestFor(OpenLibraryService)
class OpenLibraryServiceTests {
	
	void testUrlCover() {
		// TODO: Reemplazar por un mock/instancia de libro real
		def libro = [isbn:'0330258648']
		
		assert service.urlCover(libro) == 'http://covers.openlibrary.org/b/isbn/0330258648-L.jpg'
	}
	
}
