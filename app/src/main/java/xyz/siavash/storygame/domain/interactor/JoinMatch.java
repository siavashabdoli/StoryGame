package xyz.siavash.storygame.domain.interactor;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;
import xyz.siavash.storygame.domain.DataRepository;
import xyz.siavash.storygame.domain.executor.BackgroundExecutionThread;
import xyz.siavash.storygame.domain.executor.RepositoryExecutionThread;

/**
 * Created by Siavash on 2/28/18.
 */

public class JoinMatch extends UseCase<Boolean,JoinMatch.Params> {

  private final DataRepository repository;

  @Inject
  public JoinMatch(DataRepository repository, RepositoryExecutionThread repositoryExecutionThread, BackgroundExecutionThread backgroundExecutionThread) {
    super(repositoryExecutionThread, backgroundExecutionThread);
    this.repository = repository;
  }

  @Override
  Observable<Boolean> getResultObservable(Params params, Scheduler backgroundScheduler) {
    return repository.joinMatch(params.matchId);
  }

  public static final class Params {

    private final int matchId;

    private Params(int matchId) {
      this.matchId = matchId;
    }

    public static Params withMatchId(int matchId) {
      return new Params(matchId);
    }
  }
}
