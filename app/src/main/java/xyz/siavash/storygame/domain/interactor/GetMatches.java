package xyz.siavash.storygame.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import xyz.siavash.storygame.domain.DataRepository;
import xyz.siavash.storygame.domain.entity.Card;
import xyz.siavash.storygame.domain.entity.MatchEntity;
import xyz.siavash.storygame.domain.executor.BackgroundExecutionThread;
import xyz.siavash.storygame.domain.executor.RepositoryExecutionThread;

/**
 * Created by Siavash on 2/28/18.
 */

public class GetMatches extends UseCase<List<MatchEntity<Card>>, Void> {
  private final DataRepository dataRepository;

  @Inject
  public GetMatches(DataRepository dataRepository, RepositoryExecutionThread repositoryExecutionThread, BackgroundExecutionThread backgroundExecutionThread) {
    super(repositoryExecutionThread, backgroundExecutionThread);
    this.dataRepository = dataRepository;
  }

  @Override
  Observable<List<MatchEntity<Card>>> getResultObservable(Void aVoid) {
    return dataRepository.getAllMatches()
            .observeOn(getBackgroundExecutionThread());
  }
}
