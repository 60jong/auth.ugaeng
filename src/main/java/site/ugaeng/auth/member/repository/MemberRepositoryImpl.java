package site.ugaeng.auth.member.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import site.ugaeng.auth.member.entity.Member;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private final EntityManager em;

    @Override
    public Long save(final Member member) {
        em.persist(member);
        return member.getId();
    }

    @Override
    public Member findById(final Long id) {
        return em.find(Member.class, id);
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
            .getResultList();
    }

    @Override
    public Member findByEmail(final String email) {
        return em.createQuery("select m from Member m where m.authInfo.email = :email", Member.class)
            .setParameter("email", email)
            .getSingleResult();
    }
}
