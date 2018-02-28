package xyz.siavash.storygame.domain.events;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Action1;
import xyz.siavash.storygame.domain.executor.BackgroundExecutionThread;
import xyz.siavash.storygame.domain.executor.RepositoryExecutionThread;

/**
 * Created by Siavash on 2/28/18.
 */

public abstract class BaseSubscriber<Result, FilterParams> {
  private final Observable<Result> observable;

  public BaseSubscriber(RepositoryExecutionThread repositoryExecutionThread, BackgroundExecutionThread backgroundExecutionThread) {
    observable = getObservable(repositoryExecutionThread.getScheduler(), backgroundExecutionThread.getScheduler());
  }

  protected abstract Observable<Result> getObservable(Scheduler repositoryScheduler, Scheduler backgroundScheduler);

  protected abstract Observable<Result> setFilterParams(Observable<Result> observable, FilterParams filterParams);

  public Observable<Result> subcribe(FilterParams filterParams) {
    return setFilterParams(observable, filterParams)
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