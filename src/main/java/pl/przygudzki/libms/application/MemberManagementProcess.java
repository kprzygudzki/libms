package pl.przygudzki.libms.application;

import pl.przygudzki.libms.model.CreateMemberCommand;

public interface MemberManagementProcess {

	void add(CreateMemberCommand command);

}
