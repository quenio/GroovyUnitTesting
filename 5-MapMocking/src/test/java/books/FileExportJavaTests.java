package books;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class FileExportJavaTests extends TestCase {

	private File exportedFile;
	private boolean flushed;

	public void testExport() {

		// File exportedFile;
		// boolean flushed;
		final List<Book> exportedBooks = new ArrayList<Book>();
		FileExporter exporter = new FileExporter() {

			public void start(File file) {
				exportedFile = file;
			}

			public void export(Book book) {
				exportedBooks.add(book);
			}

			public void flush() {
				flushed = true;
			}

		};

		Repository repository = new Repository(exporter);

		Book book1 = new Book();
		Book book2 = new Book();
		List<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);

		repository.save(book1);
		repository.save(book2);
		
		File file = new File("bogus");
		repository.export(file);
		
		assertEquals(file, exportedFile);
		assertEquals(books, exportedBooks);
		assertTrue(flushed);
	}
	
	// What's missing in this test case? Sequence?
	
}
