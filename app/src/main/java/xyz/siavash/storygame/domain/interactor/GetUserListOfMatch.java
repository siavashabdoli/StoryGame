package xyz.siavash.storygame.domain.interactor;

import javax.inject.Inject;

import rx.Observable;
import xyz.siavash.storygame.domain.DataRepository;
import xyz.siavash.storygame.domain.entity.UserEntity;
import xyz.siavash.storygame.domain.executor.BackgroundExecutionThread;
import xyz.siavash.storygame.domain.executor.RepositoryExecutionThread;

/**
 * Created by Siavash on 2/28/18.
 */

public class GetUserListOfMatch extends UseCase<UserEntity, GetUserListOfMatch.Params> {


  private final DataRepository repository;


  @Inject
  public GetUserListOfMatch(DataRepository repository, RepositoryExecutionThread repositoryExecutionThread, BackgroundExecutionThread backgroundExecutionThread) {
    super(repositoryExecutionThread, backgroundExecutionThread);
    this.repository = repository;
  }

  @Override
  Observable<UserEntity> getResultObservable(Params params) {
    return repository.getUserList(params.matchId)
            .observeOn(getBackgroundExecutionThread());
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
