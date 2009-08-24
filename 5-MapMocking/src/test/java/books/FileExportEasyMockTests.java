package books;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.io.File;

import junit.framework.TestCase;

public class FileExportEasyMockTests extends TestCase {

	public void testExport() {

		File file = new File("bogus");
		Book book1 = new Book();
		Book book2 = new Book();

		FileExporter exporter = createMock(FileExporter.class);
		exporter.start(file);
		exporter.export(book1);
		exporter.export(book2);
		exporter.flush();
		replay(exporter);
		
		Repository repository = new Repository(exporter);
		repository.save(book1);
		repository.save(book2);
		
		repository.export(file);

		verify(exporter);
	}
	
}
