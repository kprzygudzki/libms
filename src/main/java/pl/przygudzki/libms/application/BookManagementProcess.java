package pl.przygudzki.libms.application;

import pl.przygudzki.libms.model.BookId;
import pl.przygudzki.libms.model.CreateBookCommand;

public interface BookManagementProcess {

	void add(CreateBookCommand command);

	void remove(BookId bookId);

}
