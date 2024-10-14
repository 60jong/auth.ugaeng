package site.ugaeng.auth.entity;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class AuthInfo {

  private String email;
  private String password;

  public AuthInfo(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public boolean matchPassword(String password) {
    return this.password.equals(password);
  }
}
