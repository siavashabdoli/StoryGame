package xyz.siavash.storygame.domain.entity;

/**
 * Created by Siavash on 2/27/18.
 */

public class CardHolderEntity<T extends Card> {
  private int id;
  private T card;

  public CardHolderEntity(int id, T card) {
    this.id = id;
    this.card = card;
  }

  public int getId() {
    return id;
  }

  public T getCard() {
    return card;
  }
}
