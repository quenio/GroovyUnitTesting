package books;

public class XMLExportGroovyTests extends GroovyTestCase {

	public void testExportingToXML() {
		def book1, book2
		def books = [
		    book1 = new Book(title: "The Power of Now", author: "Eckart Tole", publisher: "New World Library", year: 1999), 
		    book2 = new Book(title: "Spiritual Solution", author: "Wayne Dyer", publisher: "Harper Collins", year: 2001), 
		];
	}
	
}