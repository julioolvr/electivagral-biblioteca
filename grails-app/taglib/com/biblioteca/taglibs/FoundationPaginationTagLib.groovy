package com.biblioteca.taglibs

class FoundationPaginationTagLib {
	static namespace = 'foundation'
	
	def pagination = { attrs ->
		// TODO: Mantener params existentes, como sort y order
		def paginaActual = ((params.offset ?: 0) as Integer) / (params.max as Integer) + 1
		def paginasTotales = Math.ceil(attrs.total / params.max) as Integer
		out << render(template:'/taglibs/foundation/pagination', model:[paginasTotales:paginasTotales,paginaActual:paginaActual])
	}
}
