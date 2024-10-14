package site.ugaeng.auth.member.web.dto;

import lombok.Getter;
import lombok.Setter;
import site.ugaeng.auth.member.service.dto.MemberJoinParams;

@Getter
@Setter
public class MemberJoinRequest {
    private String name;
    private String email;
    private String password;

    // Converter method //
    public MemberJoinParams toMemberJoinParams() {
        return new MemberJoinParams(this.name, this.email, this.password);
    }
}
