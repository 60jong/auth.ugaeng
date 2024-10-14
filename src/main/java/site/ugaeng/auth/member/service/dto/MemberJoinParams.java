package site.ugaeng.auth.member.service.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberJoinParams {

  private final String name;
  private final String email;
  private final String password;
}
