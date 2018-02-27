package xyz.siavash.storygame.domain.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siavash on 2/27/18.
 */

public class UserEntity {
  private String id;
  private String name;
  private List<CardHolderEntity<Card>> userCards;
  private int score;

  public UserEntity(String id, String name) {
    this.id = id;
    this.name = name;
    userCards = new ArrayList<>();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public List<CardHolderEntity<Card>> getUserCards() {
    return userCards;
  }

  public void removeCard(int cardId){
    for(int i = 0; i < userCards.size() ; i++){
      if(userCards.get(i).getId() == cardId){
        userCards.remove(i);
        break;
      }
    }
  }

  public void addCard(CardHolderEntity<Card> cardHolderEntity) {
    userCards.add(cardHolderEntity);
  }
}
