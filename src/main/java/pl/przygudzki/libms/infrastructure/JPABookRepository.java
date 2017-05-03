package pl.przygudzki.libms.infrastructure;

import pl.przygudzki.libms.model.Book;
import pl.przygudzki.libms.model.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPABookRepository implements BookRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void add(Book book) {
		entityManager.persist(book);
	}

	@Override
	public Book get(String bookId) {
		Book book = entityManager.find(Book.class, bookId);
		if (book == null)
			throw new IllegalArgumentException(String.format("Book of id %s does not exist", bookId));
		return book;
	}

}
