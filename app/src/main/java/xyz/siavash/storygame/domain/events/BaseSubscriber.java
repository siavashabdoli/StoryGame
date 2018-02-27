package xyz.siavash.storygame.domain.events;

import rx.Observable;
import rx.Scheduler;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func1;
import xyz.siavash.storygame.domain.Exception.DefaultException;
import xyz.siavash.storygame.domain.Exception.ErrorBundle;
import xyz.siavash.storygame.domain.executor.BackgroundExecutionThread;
import xyz.siavash.storygame.domain.executor.RepositoryExecutionThread;

/**
 * Created by Siavash on 2/28/18.
 */

public abstract class BaseSubscriber<Result, Params> {
  private final RepositoryExecutionThread repositoryExecutionThread;
  private final BackgroundExecutionThread backgroundExecutionThread;

  public BaseSubscriber(RepositoryExecutionThread repositoryExecutionThread, BackgroundExecutionThread backgroundExecutionThread) {
    this.repositoryExecutionThread = repositoryExecutionThread;
    this.backgroundExecutionThread = backgroundExecutionThread;
  }

  abstract Observable<Result> getResultObservable(Params params, Scheduler backgroundScheduler);

  public Observable<Result> execute(Params params) {
    return getResultObservable(params, backgroundExecutionThread.getScheduler())
            .subscribeOn(repositoryExecutionThread.getScheduler())
            .doOnError(new Action1<Throwable>() {
              @Override
              public void call(Throwable throwable) {
                //just ignore error for now because it's a live stream
                // TODO: 2/28/18 propagiate it if it's a known exception
                throwable.printStackTrace();
              }
            });
  }
}