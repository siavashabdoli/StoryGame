package xyz.siavash.storygame.domain.Exception;

/**
 * Created by Siavash on 2/27/18.
 */

public class DefaultException extends Exception implements ErrorBundle {

  public DefaultException() {
  }

  @Override
  public Exception getException() {
    return this;
  }

  @Override
  public String getErrorMessage() {
    return "";
  }

  @Override
  public Boolean isMessageTranslated() {
    return false;
  }
}
