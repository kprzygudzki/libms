package pl.przygudzki.libms.model;

import javax.persistence.*;
import java.time.LocalDate;

import static pl.przygudzki.libms.model.BookStatus.AVAILABLE;
import static pl.przygudzki.libms.model.BookStatus.REMOVED;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	private BookStatus status;

	private String title;
	private String author;
	private LocalDate publicationDate;

	public Book(CreateBookCommand command) {
		status = AVAILABLE;
		title = command.getTitle();
		author = command.getAuthor();
		publicationDate = command.getPublicationDate();
	}

	private Book() {
	}

	public void remove() {
		status = REMOVED;
	}

	BookStatus getStatus() {
		return status;
	}

	public void export(BookExporter exporter) {
		exporter.exportId(id);
		exporter.exportStatus(status);
		exporter.exportTitle(title);
		exporter.exportAuthor(author);
		exporter.exportPublicationDate(publicationDate);
	}
}
