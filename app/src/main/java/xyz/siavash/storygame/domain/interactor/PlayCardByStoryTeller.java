package xyz.siavash.storygame.domain.interactor;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;
import xyz.siavash.storygame.domain.DataRepository;
import xyz.siavash.storygame.domain.entity.Card;
import xyz.siavash.storygame.domain.entity.MatchEntity;
import xyz.siavash.storygame.domain.executor.BackgroundExecutionThread;
import xyz.siavash.storygame.domain.executor.RepositoryExecutionThread;

/**
 * Created by Siavash on 2/28/18.
 */

public class PlayCardByStoryTeller extends UseCase<Boolean,PlayCardByStoryTeller.Params> {

  private final DataRepository repository;

  public PlayCardByStoryTeller(DataRepository repository, RepositoryExecutionThread repositoryExecutionThread, BackgroundExecutionThread backgroundExecutionThread) {
    super(repositoryExecutionThread, backgroundExecutionThread);
    this.repository = repository;
  }

  @Override
  Observable<Boolean> getResultObservable(final Params params, Scheduler backgroundScheduler) {
    return repository.getCurrentMatch()
            .flatMap(new Func1<MatchEntity<Card>, Observable<Boolean>>() {
              @Override
              public Observable<Boolean> call(MatchEntity<Card> cardMatchEntity) {
                return repository.playCardByStoryTeller(cardMatchEntity.getMatchId(), params.cardId);
              }
            });
  }

  public static final class Params {
    private int cardId;

    private Params(int cardId) {
      this.cardId = cardId;
    }

    public static Params createFromCardId(int cardId){
      return new Params(cardId);
    }
  }
}
