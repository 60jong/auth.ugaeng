package site.ugaeng.auth.auth.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.ugaeng.auth.auth.service.AuthService;
import site.ugaeng.auth.auth.service.dto.SignInParams;
import site.ugaeng.auth.auth.service.dto.SignUpParams;
import site.ugaeng.auth.auth.web.controller.dto.SignInRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody SignUpParams request,
        HttpServletRequest httpRequest) {
        final SignUpParams params = new SignUpParams(request.getName(), request.getEmail(),
            request.getPassword());

        Long memberId = authService.signUp(params);

        // Create session if absent
        HttpSession session = httpRequest.getSession();
        log.info("Session [{}] for member [{}]", session.getId(), memberId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/signin")
    public ResponseEntity<Void> signUp(@RequestBody SignInRequest request,
        HttpServletRequest httpRequest) {
        final SignInParams params = new SignInParams(request.getEmail(), request.getPassword());

        Long memberId = authService.signIn(params);

        // Create session if absent
        HttpSession session = httpRequest.getSession();
        log.info("Session [{}] for member [{}]", session.getId(), memberId);
        return ResponseEntity.ok().build();
    }
}
