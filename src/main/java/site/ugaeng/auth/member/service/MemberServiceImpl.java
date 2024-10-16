package site.ugaeng.auth.member.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.ugaeng.auth.auth.entity.AuthInfo;
import site.ugaeng.auth.member.entity.Member;
import site.ugaeng.auth.member.repository.MemberRepository;
import site.ugaeng.auth.member.service.dto.MemberJoinParams;

@RequiredArgsConstructor
@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  @Override
  @Transactional
  public Long joinMember(final MemberJoinParams params) {
    Member member = new Member(params.getName(),
        new AuthInfo(params.getEmail(), params.getPassword()));

    Long memberId = memberRepository.save(member);

    log.info("New member [id : {}] joined", memberId);
    return memberId;
  }

  @Override
  public Member findByEmail(final String email) {
    return memberRepository.findByEmail(email);
  }
}
