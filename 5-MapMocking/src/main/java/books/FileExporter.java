package books;

import java.io.File;

public interface FileExporter {

	public void start(File file);
	public void export(Book book);
	public void flush();

}
