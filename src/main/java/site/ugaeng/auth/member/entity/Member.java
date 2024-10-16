package site.ugaeng.auth.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.ugaeng.auth.auth.entity.AuthInfo;

@NoArgsConstructor
@Getter
@Entity
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private AuthInfo authInfo;

  public Member(String name, AuthInfo authInfo) {
    this.name = name;
    this.authInfo = authInfo;
  }
}
