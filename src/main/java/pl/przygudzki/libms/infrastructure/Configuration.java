package pl.przygudzki.libms.infrastructure;

import org.springframework.context.annotation.Bean;
import pl.przygudzki.libms.application.*;
import pl.przygudzki.libms.application.standard.StandardBookManagementProcess;
import pl.przygudzki.libms.application.standard.StandardMemberManagementProcess;
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

	@Bean
	MemberRepository memberRepository() {
		return new JPAMemberRepository();
	}

	@Bean
	MemberCatalog memberCatalog() {
		return new JPAMemberCatalog();
	}

	@Bean
	MemberManagementProcess memberManagementProcess(MemberRepository memberRepository) {
		return new StandardMemberManagementProcess(memberRepository);
	}

}
