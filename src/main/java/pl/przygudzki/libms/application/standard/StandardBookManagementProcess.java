package pl.przygudzki.libms.application.standard;

import pl.przygudzki.libms.application.BookManagementProcess;
import pl.przygudzki.libms.model.Book;
import pl.przygudzki.libms.model.BookRepository;
import pl.przygudzki.libms.model.CreateBookCommand;

import javax.transaction.Transactional;

@Transactional
public class StandardBookManagementProcess implements BookManagementProcess {

	private BookRepository bookRepository;

	public StandardBookManagementProcess(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void add(CreateBookCommand command) {
		Book book = new Book(command);
		bookRepository.add(book);
	}

	@Override
	public void remove(String bookId) {
		Book book = bookRepository.get(bookId);
		book.remove();
	}

}
