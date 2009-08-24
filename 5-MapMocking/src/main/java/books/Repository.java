package books;

import java.util.ArrayList;
import java.util.List;

import java.io.File;

public class Repository {
	
	private FileExporter exporter;
	
	public Repository(FileExporter exporter) {
		this.exporter = exporter;
	}

	private List<Book> books = new ArrayList<Book>();
	
	public Book findByTitle(String title) {
		
		if (title == null) {
			throw new NullPointerException("Expected title to be specified.");
		}
		
		for (Book book: books) {
			if (title.equals(book.getTitle())) {
				return book;
			}
		}
		
		return null;
	}
	
	public void save(Book book) {
		
		if (! books.contains(book)) {
			books.add(book);
		}
		
	}
	
	public void export(File file) {
		exporter.start(file);
		for (Book book: books) {
			exporter.export(book);
		}
		exporter.flush();
	}
	
}
