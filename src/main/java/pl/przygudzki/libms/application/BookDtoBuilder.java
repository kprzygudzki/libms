package pl.przygudzki.libms.application;

import pl.przygudzki.libms.model.BookExporter;
import pl.przygudzki.libms.model.BookId;
import pl.przygudzki.libms.model.BookStatus;

import java.time.LocalDate;

public class BookDtoBuilder implements BookExporter {

	private BookDto bookDto = new BookDto();

	public BookDto build() {
		BookDto result = bookDto;
		bookDto = new BookDto();
		return result;
	}

	@Override
	public void exportId(BookId id) {
		bookDto.setId(id);
	}

	@Override
	public void exportStatus(BookStatus status) {
		bookDto.setStatus(status);
	}

	@Override
	public void exportTitle(String title) {
		bookDto.setTitle(title);
	}

	@Override
	public void exportAuthor(String author) {
		bookDto.setAuthor(author);
	}

	@Override
	public void exportPublicationDate(LocalDate publicationDate) {
		bookDto.setPublicationDate(publicationDate);
	}

}
