package books;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class ExportJavaTests extends TestCase {

	public void testExport() {
		
		Book book1 = new Book();
		Book book2 = new Book();
		List<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		
		Repository repository = new Repository();
		repository.save(book1);
		repository.save(book2);
		
		final List<Book> exportedBooks = new ArrayList<Book>();
		Exporter exporter = new Exporter() {

			public void export(Book book) {
				exportedBooks.add(book);
			}
			
		};
		
		repository.export(exporter);
		
		assertEquals(books, exportedBooks);
	}
	
}
