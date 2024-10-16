package site.ugaeng.auth.member.service;

import site.ugaeng.auth.member.entity.Member;
import site.ugaeng.auth.member.service.dto.MemberJoinParams;

public interface MemberService {

  Long joinMember(final MemberJoinParams params);

  Member findByEmail(final String email);
}
