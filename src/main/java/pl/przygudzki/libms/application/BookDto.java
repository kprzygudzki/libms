package pl.przygudzki.libms.application;

import java.time.LocalDate;

public class BookDto {

	private String id;
	private String status;
	private String title;
	private String author;
	private LocalDate publicationDate;

	void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
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
