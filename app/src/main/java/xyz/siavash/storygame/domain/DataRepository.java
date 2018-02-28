package xyz.siavash.storygame.domain;

import java.util.List;

import rx.Observable;
import xyz.siavash.storygame.domain.entity.Card;
import xyz.siavash.storygame.domain.entity.ImageCard;
import xyz.siavash.storygame.domain.entity.MatchEntity;
import xyz.siavash.storygame.domain.entity.RoundEntity;
import xyz.siavash.storygame.domain.entity.UserEntity;

/**
 * Created by Siavash on 2/27/18.
 */

public interface DataRepository {

  //start new game
  Observable<MatchEntity<ImageCard>> startMatch();

  //check if user is already playing a game
  Observable<Boolean> isMatchRunning();

  Observable<UserEntity> getUserList(int matchId);

  Observable<List<MatchEntity<Card>>> getAllMatches();

  Observable<Boolean> joinMatch(int matchId);

  Observable<MatchEntity<Card>> subscribeToMatchStart();

  Observable<RoundEntity<Card>> getCurrentRound(int matchId);

  Observable<List<Card>> getMyCards();
}
