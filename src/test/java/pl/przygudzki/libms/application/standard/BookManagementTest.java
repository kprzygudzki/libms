package pl.przygudzki.libms.application.standard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.przygudzki.libms.application.BookCatalog;
import pl.przygudzki.libms.application.BookManagementProcess;
import pl.przygudzki.libms.model.CreateBookCommand;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class BookManagementTest {

	@Autowired
	private BookManagementProcess process;

	@Autowired
	private BookCatalog catalog;

	@Test
	public void shouldAddBook() {
		int size = catalog.listAll().size();
		CreateBookCommand command = new CreateBookCommand();
		process.add(command);
		assertThat(catalog.listAll().size()).isEqualTo(size + 1);
	}

}
