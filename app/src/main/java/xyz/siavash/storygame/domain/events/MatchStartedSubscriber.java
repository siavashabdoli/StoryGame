package xyz.siavash.storygame.domain.events;

import javax.inject.Inject;

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

public class MatchStartedSubscriber extends BaseSubscriber<MatchEntity<Card>, MatchStartedSubscriber.FilterParams> {
  private final DataRepository repository;

  @Inject
  public MatchStartedSubscriber(DataRepository repository, RepositoryExecutionThread repositoryExecutionThread, BackgroundExecutionThread backgroundExecutionThread) {
    super(repositoryExecutionThread, backgroundExecutionThread);
    this.repository = repository;
  }

  @Override
  protected Observable<MatchEntity<Card>> getObservable(Scheduler repositoryScheduler, Scheduler backgroundScheduler) {
    return repository.subscribeToMatchStart();
  }

  @Override
  protected Observable<MatchEntity<Card>> setFilterParams(Observable<MatchEntity<Card>> observable, final FilterParams filterParams) {
    return observable.filter(new Func1<MatchEntity<Card>, Boolean>() {
      @Override
      public Boolean call(MatchEntity<Card> cardMatchEntity) {
        return filterParams == null || filterParams.matchId == null ||
                cardMatchEntity.getMatchId() == filterParams.matchId;
      }
    });
  }

  public final static class FilterParams {
    private Integer matchId;

    private FilterParams(int matchId) {
      this.matchId = matchId;
    }

    public static FilterParams filterWithMatchId(int matchId) {
      return new FilterParams(matchId);
    }
  }
}
