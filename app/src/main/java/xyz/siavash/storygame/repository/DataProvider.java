package xyz.siavash.storygame.repository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import xyz.siavash.storygame.domain.DataRepository;
import xyz.siavash.storygame.domain.entity.Card;
import xyz.siavash.storygame.domain.entity.ImageCard;
import xyz.siavash.storygame.domain.entity.MatchEntity;
import xyz.siavash.storygame.domain.entity.RoundEntity;
import xyz.siavash.storygame.domain.entity.UserEntity;
import xyz.siavash.storygame.repository.network.GameApiInterface;

/**
 * Created by Siavash on 2/27/18.
 */

public class DataProvider implements DataRepository {
  private GameApiInterface gameApiInterface;

  @Inject
  public DataProvider(GameApiInterface gameApiInterface) {
    this.gameApiInterface = gameApiInterface;
  }

  @Override
  public Observable<MatchEntity<ImageCard>> startMatch() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Observable<Boolean> isMatchRunning() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Observable<UserEntity> getUserList(int matchId) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Observable<List<MatchEntity<Card>>> getAllMatches() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Observable<Boolean> joinMatch(int matchId) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Observable<MatchEntity<Card>> subscribeToMatchStart() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Observable<RoundEntity<Card>> getCurrentRound(int matchId) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Observable<List<Card>> getMyCards() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Observable<MatchEntity<Card>> getMatchResult(int matchId) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Observable<MatchEntity<Card>> getCurrentMatch() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Observable<Boolean> voteCard(int matchId, int cardId) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Observable<Boolean> playCardByOthers(int matchId, int cardId) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Observable<Boolean> playCardByStoryTeller(int matchId, int cardId) {
    throw new UnsupportedOperationException();
  }
}
