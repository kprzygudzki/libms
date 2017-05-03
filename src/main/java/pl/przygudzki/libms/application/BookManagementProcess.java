package pl.przygudzki.libms.application;

import pl.przygudzki.libms.model.CreateBookCommand;

import java.util.UUID;

public interface BookManagementProcess {

	void add(CreateBookCommand command);

	void remove(UUID bookId);

}
