package site.ugaeng.auth.auth.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInParams {

    private String email;
    private String password;
}
