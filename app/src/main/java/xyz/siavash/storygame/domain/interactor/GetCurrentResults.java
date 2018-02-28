package xyz.siavash.storygame.domain.interactor;

import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;
import xyz.siavash.storygame.domain.DataRepository;
import xyz.siavash.storygame.domain.entity.Card;
import xyz.siavash.storygame.domain.entity.MatchEntity;
import xyz.siavash.storygame.domain.entity.UserEntity;
import xyz.siavash.storygame.domain.executor.BackgroundExecutionThread;
import xyz.siavash.storygame.domain.executor.RepositoryExecutionThread;

/**
 * Created by Siavash on 2/28/18.
 */

public class GetCurrentResults extends UseCase<List<UserEntity>,Void> {
  private final DataRepository repository;

  public GetCurrentResults(DataRepository repository, RepositoryExecutionThread repositoryExecutionThread, BackgroundExecutionThread backgroundExecutionThread) {
    super(repositoryExecutionThread, backgroundExecutionThread);
    this.repository = repository;
  }

  @Override
  Observable<List<UserEntity>> getResultObservable(Void avoid,Scheduler backgroundScheduler) {
    return repository.getCurrentMatch()
            .flatMap(new Func1<MatchEntity<Card>, Observable<MatchEntity<Card>>>() {
              @Override
              public Observable<MatchEntity<Card>> call(MatchEntity<Card> cardMatchEntity) {
                return repository.getMatchResult(cardMatchEntity.getMatchId());
              }
            }).observeOn(backgroundScheduler)
            .map(new Func1<MatchEntity<Card>, List<UserEntity>>() {
              @Override
              public List<UserEntity> call(MatchEntity<Card> cardMatchEntity) {
                return cardMatchEntity.getUsers();
              }
            });
  }

}
