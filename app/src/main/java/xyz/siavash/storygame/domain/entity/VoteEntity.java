package xyz.siavash.storygame.domain.entity;

/**
 * Created by Siavash on 2/27/18.
 */

public class VoteEntity<T extends Card> {
  private UserEntity user;
  private CardHolderEntity<T> cardHolder;

  public UserEntity getUser() {
    return user;
  }

  public CardHolderEntity<T> getCardHolder() {
    return cardHolder;
  }
}
