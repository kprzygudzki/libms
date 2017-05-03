package pl.przygudzki.libms.application;

import pl.przygudzki.libms.model.BookId;
import pl.przygudzki.libms.model.BookStatus;

import java.time.LocalDate;

public class BookDto {

	private BookId id;
	private BookStatus status;
	private String title;
	private String author;
	private LocalDate publicationDate;

	void setId(BookId id) {
		this.id = id;
	}

	public BookId getId() {
		return id;
	}

	void setStatus(BookStatus status) {
		this.status = status;
	}

	public BookStatus getStatus() {
		return status;
	}

	void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

}
