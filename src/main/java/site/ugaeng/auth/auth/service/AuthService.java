package site.ugaeng.auth.auth.service;

import site.ugaeng.auth.auth.service.dto.SignInParams;
import site.ugaeng.auth.auth.service.dto.SignUpParams;

public interface AuthService {

    Long signUp(SignUpParams params);
    Long signIn(SignInParams params);
}
