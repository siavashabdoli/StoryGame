package xyz.siavash.storygame.domain.interactor;

import rx.Observable;
import rx.Scheduler;
import xyz.siavash.storygame.domain.executor.BackgroundExecutionThread;
import xyz.siavash.storygame.domain.executor.RepositoryExecutionThread;

/**
 * Created by Siavash on 2/27/18.
 */

public abstract class UseCase<Result, Params> {
  private final RepositoryExecutionThread repositoryExecutionThread;
  private final BackgroundExecutionThread backgroundExecutionThread;

  public UseCase(RepositoryExecutionThread repositoryExecutionThread, BackgroundExecutionThread backgroundExecutionThread) {
    this.repositoryExecutionThread = repositoryExecutionThread;
    this.backgroundExecutionThread = backgroundExecutionThread;
  }

  abstract Observable<Result> getResultObservable(Params params, Scheduler backgroundScheduler);

  public Observable<Result> execute(Params params) {
    return getResultObservable(params, backgroundExecutionThread.getScheduler())
            .subscribeOn(repositoryExecutionThread.getScheduler());
  }
}
