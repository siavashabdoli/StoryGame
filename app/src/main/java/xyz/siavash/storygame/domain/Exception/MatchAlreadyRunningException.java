package xyz.siavash.storygame.domain.Exception;

/**
 * Created by Siavash on 2/28/18.
 */

public class MatchAlreadyRunningException extends Exception implements ErrorBundle {
  @Override
  public Exception getException() {
    return this;
  }

  @Override
  public String getErrorMessage() {
    return "Game is Already Running";
  }

  @Override
  public Boolean isMessageTranslated() {
    return false;
  }
}
