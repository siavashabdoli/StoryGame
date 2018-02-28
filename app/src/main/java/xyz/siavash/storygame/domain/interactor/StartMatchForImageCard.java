package xyz.siavash.storygame.domain.interactor;

import android.media.Image;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import xyz.siavash.storygame.domain.DataRepository;
import xyz.siavash.storygame.domain.Exception.MatchAlreadyRunningException;
import xyz.siavash.storygame.domain.entity.Card;
import xyz.siavash.storygame.domain.entity.ImageCard;
import xyz.siavash.storygame.domain.entity.MatchEntity;
import xyz.siavash.storygame.domain.executor.BackgroundExecutionThread;
import xyz.siavash.storygame.domain.executor.RepositoryExecutionThread;

/**
 * Created by Siavash on 2/28/18.
 */

public class StartMatchForImageCard extends UseCase<MatchEntity<ImageCard>,Void> {

  private final DataRepository dataRepository;

  @Inject
  public StartMatchForImageCard(DataRepository dataRepository, RepositoryExecutionThread repositoryExecutionThread, BackgroundExecutionThread backgroundExecutionThread) {
    super(repositoryExecutionThread, backgroundExecutionThread);
    this.dataRepository = dataRepository;
  }

  @Override
  Observable<MatchEntity<ImageCard>> getResultObservable(Void aVoid, Scheduler backgroundScheduler) {
    return dataRepository.isMatchRunning()
    .flatMap(new Func1<Boolean, Observable<MatchEntity<ImageCard>>>() {
      @Override
      public Observable<MatchEntity<ImageCard>> call(Boolean isMatchRunning) {
        if(isMatchRunning){
          throw Exceptions.propagate(new MatchAlreadyRunningException());
        }
        return dataRepository.startMatch();
      }
    });
  }

}
