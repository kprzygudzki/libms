package pl.przygudzki.libms.application;

import pl.przygudzki.libms.model.BookExporter;
import pl.przygudzki.libms.model.BookStatus;

import java.time.LocalDate;
import java.util.UUID;

public class BookDtoBuilder implements BookExporter {

	private BookDto bookDto = new BookDto();

	public BookDto build() {
		BookDto result = bookDto;
		bookDto = new BookDto();
		return result;
	}

	@Override
	public void exportId(UUID id) {
		bookDto.setId(id.toString());
	}

	@Override
	public void exportStatus(BookStatus status) {
		bookDto.setStatus(status.toString());
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
