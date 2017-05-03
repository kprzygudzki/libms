package pl.przygudzki.libms.acceptance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.przygudzki.libms.application.BookCatalog;
import pl.przygudzki.libms.application.BookManagementProcess;
import pl.przygudzki.libms.DbCleaner;
import pl.przygudzki.libms.model.CreateBookCommand;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.przygudzki.libms.model.BookStatus.AVAILABLE;
import static pl.przygudzki.libms.model.BookStatus.REMOVED;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookManagementTest {

	@Autowired
	private BookManagementProcess process;

	@Autowired
	private BookCatalog catalog;

	@Autowired
	private DbCleaner cleaner;

	@Before
	public void setUp() throws Exception {
		cleaner.clean();
	}

	@Test
	public void shouldAddBook() {
		int size = catalog.listAll().size();
		CreateBookCommand command = new CreateBookCommand();
		process.add(command);
		assertThat(catalog.listAll().size()).isEqualTo(size + 1);
	}

	@Test
	public void shouldSetStatusToAvailableOnCreation() {
		CreateBookCommand command = new CreateBookCommand();
		process.add(command);
		assertThat(catalog.listAll().get(0).getStatus()).isEqualTo(AVAILABLE);
	}

	@Test
	public void shouldSetStatusToRemovedOnRemoval() {
		CreateBookCommand command = new CreateBookCommand();
		process.add(command);
		process.remove(catalog.listAll().get(0).getId());
		assertThat(catalog.listAll().get(0).getStatus()).isEqualTo(REMOVED);
	}

}
