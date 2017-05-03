package pl.przygudzki.libms.model;

public interface BookRepository {

	void add(Book book);

	Book get(BookId bookId);

}
