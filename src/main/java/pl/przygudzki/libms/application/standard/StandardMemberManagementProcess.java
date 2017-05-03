package pl.przygudzki.libms.application.standard;

import pl.przygudzki.libms.application.MemberManagementProcess;
import pl.przygudzki.libms.application.MemberRepository;
import pl.przygudzki.libms.model.CreateMemberCommand;
import pl.przygudzki.libms.model.Member;

public class StandardMemberManagementProcess implements MemberManagementProcess {

	private MemberRepository memberRepository;

	public StandardMemberManagementProcess(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void add(CreateMemberCommand command) {
		Member member = new Member(command);
		memberRepository.add(member);
	}

}
