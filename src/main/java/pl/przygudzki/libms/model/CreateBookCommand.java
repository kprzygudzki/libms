package pl.przygudzki.libms.model;

import java.time.LocalDate;

public class CreateBookCommand {

	private String title;
	private String author;
	private LocalDate publicationDate;

	String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

}
