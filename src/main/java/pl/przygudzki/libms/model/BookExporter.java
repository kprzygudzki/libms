package pl.przygudzki.libms.model;

import java.time.LocalDate;

public interface BookExporter {

	void exportId(Long id);

	void exportStatus(BookStatus status);

	void exportTitle(String title);

	void exportAuthor(String author);

	void exportPublicationDate(LocalDate publicationDate);

}
