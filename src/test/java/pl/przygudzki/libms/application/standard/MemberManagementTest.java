package pl.przygudzki.libms.application.standard;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.przygudzki.libms.DbCleaner;
import pl.przygudzki.libms.application.MemberCatalog;
import pl.przygudzki.libms.application.MemberManagementProcess;
import pl.przygudzki.libms.model.CreateMemberCommand;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberManagementTest {

	@Autowired
	private MemberManagementProcess process;

	@Autowired
	private MemberCatalog catalog;

	@Autowired
	private DbCleaner cleaner;

	@Before
	public void setUp() {
		cleaner.clean();
	}

	@Test
	public void shouldAddMember() {
		CreateMemberCommand command = new CreateMemberCommand();
		process.add(command);
		Assertions.assertThat(catalog.listAll().size()).isEqualTo(1);
	}

}
