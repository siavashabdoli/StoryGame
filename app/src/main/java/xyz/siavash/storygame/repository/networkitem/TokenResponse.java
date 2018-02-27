package xyz.siavash.storygame.repository.networkitem;

/**
 * Created by Siavash on 2/27/18.
 */

public class TokenResponse {
  String token;

  public TokenResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
