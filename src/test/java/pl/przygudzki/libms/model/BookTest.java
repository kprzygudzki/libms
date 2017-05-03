package pl.przygudzki.libms.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.przygudzki.libms.model.BookStatus.AVAILABLE;
import static pl.przygudzki.libms.model.BookStatus.REMOVED;

public class BookTest {

	@Test
	public void shouldSetStatusToAvailableOnCreation() {
		CreateBookCommand command = new CreateBookCommand();
		Book book = new Book(command);
		assertThat(book.getStatus()).isEqualTo(AVAILABLE);
	}

	@Test
	public void shouldSetStatusToRemovedOnRemoval() {
		CreateBookCommand command = new CreateBookCommand();
		Book book = new Book(command);
		book.remove();
		assertThat(book.getStatus()).isEqualTo(REMOVED);
	}

}