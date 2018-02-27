package xyz.siavash.storygame.domain.Exception;

public interface ErrorBundle {
  Exception getException();

  String getErrorMessage();

  Boolean isMessageTranslated();
}