package xyz.siavash.storygame.domain.entity;

import java.util.Collection;

/**
 * Created by Siavash on 2/27/18.
 */

public class MatchEntity<T extends Card> {
  private Collection<RoundEntity<T>> rounds;
  private Collection<UserEntity> users;

  public Collection<RoundEntity<T>> getRounds() {
    return rounds;
  }

  public Collection<UserEntity> getUsers() {
    return users;
  }
}
