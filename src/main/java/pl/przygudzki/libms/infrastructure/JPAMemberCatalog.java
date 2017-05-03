package pl.przygudzki.libms.infrastructure;

import pl.przygudzki.libms.application.MemberCatalog;
import pl.przygudzki.libms.application.MemberDto;
import pl.przygudzki.libms.application.MemberDtoBuilder;
import pl.przygudzki.libms.model.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.LinkedList;
import java.util.List;

public class JPAMemberCatalog implements MemberCatalog {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<MemberDto> listAll() {
		List<Member> members = queryMembers();
		return getMemberDtos(members);
	}

	private List<Member> queryMembers() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Member> query = builder.createQuery(Member.class);
		query.from(Member.class);
		return entityManager.createQuery(query).getResultList();
	}

	private List<MemberDto> getMemberDtos(List<Member> members) {
		List<MemberDto> result = new LinkedList<>();
		MemberDtoBuilder builder = new MemberDtoBuilder();
		for (Member member : members)
			result.add(createMemberDto(builder, member));
		return result;
	}

	private MemberDto createMemberDto(MemberDtoBuilder builder, Member member) {
		member.export(builder);
		return builder.build();
	}

}
