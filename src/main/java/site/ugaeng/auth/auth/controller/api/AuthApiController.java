package site.ugaeng.auth.auth.controller.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.ugaeng.auth.auth.service.AuthService;
import site.ugaeng.auth.auth.service.dto.SignInParams;
import site.ugaeng.auth.auth.service.dto.SignUpParams;
import site.ugaeng.auth.auth.controller.api.dto.MemberIdResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class AuthApiController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(final @RequestBody SignUpParams params,
        HttpServletRequest httpRequest) {
        Long memberId = authService.signUp(params);

        // Create session if absent
        HttpSession session = httpRequest.getSession();
        session.setAttribute("memberId", memberId);
        log.info("Session [{}] for member [{}]", session.getId(), memberId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/signin")
    public ResponseEntity<Void> signUp(final @RequestBody SignInParams params,
        HttpServletRequest httpRequest) {
        Long memberId = authService.signIn(params);

        // Create session if absent
        HttpSession session = httpRequest.getSession();
        session.setAttribute("memberId", memberId);
        log.info("Session [{}] for member [{}]", session.getId(), memberId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/session/validate")
    public ResponseEntity<MemberIdResponse> validateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Long memberId = (Long) session.getAttribute("memberId");

        return ResponseEntity.ok().body(new MemberIdResponse(memberId));
    }
}
