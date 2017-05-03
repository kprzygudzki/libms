package pl.przygudzki.libms.model;

import java.time.LocalDate;
import java.util.UUID;

public interface BookExporter {

	void exportId(UUID id);

	void exportStatus(BookStatus status);

	void exportTitle(String title);

	void exportAuthor(String author);

	void exportPublicationDate(LocalDate publicationDate);

}
