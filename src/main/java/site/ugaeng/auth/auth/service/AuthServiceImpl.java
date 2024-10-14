package site.ugaeng.auth.auth.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.ugaeng.auth.auth.service.dto.SignInParams;
import site.ugaeng.auth.auth.service.dto.SignUpParams;
import site.ugaeng.auth.entity.AuthInfo;
import site.ugaeng.auth.entity.Member;
import site.ugaeng.auth.member.service.MemberService;
import site.ugaeng.auth.member.service.dto.MemberJoinParams;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final MemberService memberService;

    @Override
    @Transactional
    public Long signUp(final SignUpParams params) {
        Long memberId = memberService.joinMember(
            new MemberJoinParams(params.getName(), params.getEmail(), params.getPassword()));

        log.info("New member [{}] joined", memberId);
        return memberId;
    }

    @Override
    public Long signIn(final SignInParams params) {
        final String email = params.getEmail();
        final String password = params.getPassword();

        final Member member = memberService.findByEmail(email);
        final AuthInfo authInfo = member.getAuthInfo();

        if (authInfo.matchPassword(password)) {
            return member.getId();
        }
        return null;
    }
}
