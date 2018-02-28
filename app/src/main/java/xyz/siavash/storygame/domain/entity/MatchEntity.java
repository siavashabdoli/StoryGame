package xyz.siavash.storygame.domain.entity;

import java.util.List;

/**
 * Created by Siavash on 2/27/18.
 */

public class MatchEntity<T extends Card> {
  private int matchId;
  private List<RoundEntity<T>> rounds;
  private List<UserEntity> users;

  public List<RoundEntity<T>> getRounds() {
    return rounds;
  }

  public List<UserEntity> getUsers() {
    return users;
  }

  public int getMatchId() {
    return matchId;
  }
}
