package pl.przygudzki.libms.infrastructure;

import pl.przygudzki.libms.application.BookCatalog;
import pl.przygudzki.libms.application.BookDto;
import pl.przygudzki.libms.application.BookDtoBuilder;
import pl.przygudzki.libms.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.LinkedList;
import java.util.List;

public class JPABookCatalog implements BookCatalog {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<BookDto> listAll() {
		List<Book> books = queryBooks();
		return getBookDtos(books);
	}

	private List<Book> queryBooks() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Book> query = builder.createQuery(Book.class);
		query.from(Book.class);
		return entityManager.createQuery(query).getResultList();
	}

	private List<BookDto> getBookDtos(List<Book> books) {
		List<BookDto> result = new LinkedList<>();
		BookDtoBuilder bookDtoBuilder = new BookDtoBuilder();
		for (Book book : books)
			result.add(createBookDto(bookDtoBuilder, book));
		return result;
	}

	private BookDto createBookDto(BookDtoBuilder bookDtoBuilder, Book book) {
		book.export(bookDtoBuilder);
		return bookDtoBuilder.build();
	}

}
