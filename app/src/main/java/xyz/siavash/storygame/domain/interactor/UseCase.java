package xyz.siavash.storygame.domain.interactor;

import rx.Observable;
import rx.Scheduler;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import xyz.siavash.storygame.domain.Exception.DefaultException;
import xyz.siavash.storygame.domain.Exception.ErrorBundle;
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

  abstract Observable<Result> getResultObservable(Params params);

  public Observable<Result> execute(Params params) {
    return getResultObservable(params)
            .subscribeOn(repositoryExecutionThread.getScheduler())
            .doOnError(new Action1<Throwable>() {
              @Override
              public void call(Throwable throwable) {
                throwable.printStackTrace();
                if (throwable instanceof ErrorBundle) {
                  throw Exceptions.propagate(throwable);
                } else {
                  throw Exceptions.propagate(new DefaultException());
                }
              }
            });
  }

  public Scheduler getRepositoryExecutionThread() {
    return repositoryExecutionThread.getScheduler();
  }

  public Scheduler getBackgroundExecutionThread() {
    return backgroundExecutionThread.getScheduler();
  }
}
