package books;

public class FileExportGroovyTests extends GroovyTestCase {

	public void testExport() {

		def sequence = []
		def exporter = [ 
		    start: { sequence += "start($it)" },            
			export: { sequence += "export($it)" },
			flush: { sequence += "flush()" }
		]
		
		Repository repository = new Repository(exporter as FileExporter)

		def book1, book2
		def books = [ book1 = new Book(), book2 = new Book() ]

        repository.save(book1)
		repository.save(book2)

        def file = new File("bogus")
		repository.export(file)

		assert sequence == ["start($file)", "export($book1)", "export($book2)", "flush()"]
	}
	
}