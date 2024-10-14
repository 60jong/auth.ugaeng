package site.ugaeng.auth.member.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.ugaeng.auth.member.service.MemberService;
import site.ugaeng.auth.member.web.dto.MemberJoinRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody MemberJoinRequest request) {
        memberService.joinMember(request.toMemberJoinParams());

        return ResponseEntity.ok().build();
    }
}
