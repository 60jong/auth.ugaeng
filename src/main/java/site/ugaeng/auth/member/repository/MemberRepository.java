package site.ugaeng.auth.member.repository;

import site.ugaeng.auth.member.entity.Member;

import java.util.List;

public interface MemberRepository {

    Long save(final Member member);

    Member findById(final Long id);

    List<Member> findAll();

    Member findByEmail(final String email);
}
