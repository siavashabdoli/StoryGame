package xyz.siavash.storygame.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import xyz.siavash.storygame.domain.DataRepository;
import xyz.siavash.storygame.domain.entity.Card;
import xyz.siavash.storygame.domain.executor.BackgroundExecutionThread;
import xyz.siavash.storygame.domain.executor.RepositoryExecutionThread;

/**
 * Created by Siavash on 2/28/18.
 */

public class GetMyCard extends UseCase<List<Card>, Void> {

  private final DataRepository repository;

  @Inject
  public GetMyCard(DataRepository repository, RepositoryExecutionThread repositoryExecutionThread, BackgroundExecutionThread backgroundExecutionThread) {
    super(repositoryExecutionThread, backgroundExecutionThread);
    this.repository = repository;
  }

  @Override
  Observable<List<Card>> getResultObservable(Void aVoid) {
    return repository.getMyCards()
            .observeOn(getBackgroundExecutionThread());
  }
}
