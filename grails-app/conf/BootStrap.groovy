import com.biblioteca.*

class BootStrap {

	def init = { servletContext ->
		/*
		 * Crear socios de prueba
		 */
		
		def socioTest = new Socio(dni: '12345678', nombre: 'teste teste', login: 'teste', password: 'testpass1234', email: 'teste@test.com').save()
		def socioTesto = new Socio(dni: '12345679', nombre: 'testo testo', login: 'testo', password: 'testpass1234', email: 'testo@test.com').save()
		def socioTesty = new Socio(dni: '12345680', nombre: 'testy testy', login: 'testy', password: 'testpass1234', email: 'testy@test.com').save()
		
		/*
		 * Crear libros de prueba
		 */
		
		def libro1 = new Libro(titulo: "The hitchhiker's guide to the galaxy", autor: 'Douglas Adams', isbn: '0330258648', ejemplaresDisponibles: 10).save()
		def libro2 = new Libro(titulo: '1984', autor: 'George Orwell', isbn: '0451524934', ejemplaresDisponibles: 10).save()
		def libro3 = new Libro(titulo: 'The restaurant at the end of the universe', autor: 'Douglas Adams', isbn: '0345391810', ejemplaresDisponibles: 10).save()
		def libro4 = new Libro(titulo: "The hitchhiker's guide to the galaxy", autor: 'Douglas Adams', isbn: '0230258648', ejemplaresDisponibles: 1).save()
		def libro5 = new Libro(titulo: '1984', autor: 'George Orwell', isbn: '0251524934').save()
		def libro6 = new Libro(titulo: 'The restaurant at the end of the universe', autor: 'Douglas Adams', isbn: '0245391810').save()
		def libro7 = new Libro(titulo: "The hitchhiker's guide to the galaxy", autor: 'Douglas Adams', isbn: '0430258648').save()
		def libro8 = new Libro(titulo: '1984', autor: 'George Orwell', isbn: '0441524934').save()
		def libro9 = new Libro(titulo: 'The restaurant at the end of the universe', autor: 'Douglas Adams', isbn: '0445391810').save()
		def libro10 = new Libro(titulo: "The hitchhiker's guide to the galaxy", autor: 'Douglas Adams', isbn: '0330558648').save()
		def libro11 = new Libro(titulo: '1984', autor: 'George Orwell', isbn: '0451524935').save()
		def libro12 = new Libro(titulo: 'The restaurant at the end of the universe', autor: 'Douglas Adams', isbn: '0345391815').save()
	}
	
	def destroy = {
	}
}
