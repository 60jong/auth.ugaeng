package site.ugaeng.auth.auth.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpParams {

    private String name;
    private String email;
    private String password;
}
