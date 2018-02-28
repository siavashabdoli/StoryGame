package xyz.siavash.storygame.domain.interactor;

import java.util.List;

import rx.Observable;
import rx.Scheduler;
import xyz.siavash.storygame.domain.DataRepository;
import xyz.siavash.storygame.domain.entity.UserEntity;
import xyz.siavash.storygame.domain.executor.BackgroundExecutionThread;
import xyz.siavash.storygame.domain.executor.RepositoryExecutionThread;

/**
 * Created by Siavash on 2/28/18.
 */

public class GetUserListOfMatch extends UseCase<UserEntity,GetUserListOfMatch.Params> {


  private final DataRepository repository;

  public GetUserListOfMatch(DataRepository repository, RepositoryExecutionThread repositoryExecutionThread, BackgroundExecutionThread backgroundExecutionThread) {
    super(repositoryExecutionThread, backgroundExecutionThread);
    this.repository = repository;
  }

  @Override
  Observable<UserEntity> getResultObservable(Params params, Scheduler backgroundScheduler) {
    return repository.getUserList(params.matchId)
            .observeOn(backgroundScheduler);
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
