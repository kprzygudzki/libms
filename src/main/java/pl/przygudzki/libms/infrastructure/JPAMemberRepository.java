package pl.przygudzki.libms.infrastructure;

import pl.przygudzki.libms.application.MemberRepository;
import pl.przygudzki.libms.model.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class JPAMemberRepository implements MemberRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void add(Member member) {
		entityManager.persist(member);
	}

}
