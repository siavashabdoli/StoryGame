package xyz.siavash.storygame.domain.Exception;

/**
 * Created by Siavash on 2/27/18.
 */

public class DefaultException extends Exception implements ErrorBundle {

  private final Exception exception;

  public DefaultException(Exception exception) {
    this.exception = exception;
  }

  @Override
  public Exception getException() {
    return exception;
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
