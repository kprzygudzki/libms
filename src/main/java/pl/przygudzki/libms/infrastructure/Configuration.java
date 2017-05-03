package pl.przygudzki.libms.infrastructure;

import org.springframework.context.annotation.Bean;
import pl.przygudzki.libms.application.BookCatalog;
import pl.przygudzki.libms.application.BookManagementProcess;
import pl.przygudzki.libms.application.standard.StandardBookManagementProcess;
import pl.przygudzki.libms.model.BookRepository;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	BookRepository bookRepository() {
		return new JPABookRepository();
	}

	@Bean
	BookCatalog bookCatalog() {
		return new JPABookCatalog();
	}

	@Bean
	BookManagementProcess bookManagementProcess(BookRepository bookRepository) {
		return new StandardBookManagementProcess(bookRepository);
	}

}
