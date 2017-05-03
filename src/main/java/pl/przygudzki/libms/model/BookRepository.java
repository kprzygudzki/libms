package pl.przygudzki.libms.model;

import java.util.UUID;

public interface BookRepository {

	void add(Book book);

	Book get(UUID bookId);

}
