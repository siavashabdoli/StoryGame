package xyz.siavash.storygame.domain.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siavash on 2/27/18.
 */

public class RoundEntity<T extends Card> {
  private int id;
  private int state;
  private int RaviId;
  private String theStory;
  private List<CardHolderEntity<T>> cardHolderEntities;
  private int myCardId;
  private List<VoteEntity> votes;

  public int getId() {
    return id;
  }

  public int getState() {
    return state;
  }

  public int getRaviId() {
    return RaviId;
  }

  public String getTheStory() {
    return theStory;
  }

  public List<CardHolderEntity<T>> getCardHolderEntities() {
    return new ArrayList<>(cardHolderEntities);
  }

  public int getMyCardId() {
    return myCardId;
  }

  public List<VoteEntity> getVotes() {
    return votes;
  }
}
