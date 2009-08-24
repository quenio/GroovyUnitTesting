package books;

public class ExportGroovyTests extends GroovyTestCase {

	public void testExport() {

		def book1, book2
		def books = [ book1 = new Book(), book2 = new Book() ]

		Repository repository = new Repository()
		repository.save(book1)
		repository.save(book2)

		def exportedBooks = []
		def exporter = { exportedBooks += it }
		
		repository.export(exporter as Exporter)

		assert exportedBooks == books
	}
	
}