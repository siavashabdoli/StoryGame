package xyz.siavash.storygame.domain.interactor;

import rx.Observable;
import rx.Scheduler;
import xyz.siavash.storygame.domain.DataRepository;
import xyz.siavash.storygame.domain.entity.Card;
import xyz.siavash.storygame.domain.entity.RoundEntity;
import xyz.siavash.storygame.domain.executor.BackgroundExecutionThread;
import xyz.siavash.storygame.domain.executor.RepositoryExecutionThread;

/**
 * Created by Siavash on 2/28/18.
 */

public class GetRoundData extends UseCase<RoundEntity<Card>, GetRoundData.Params> {

  private final DataRepository dataRepository;

  public GetRoundData(DataRepository dataRepository, RepositoryExecutionThread repositoryExecutionThread, BackgroundExecutionThread backgroundExecutionThread) {
    super(repositoryExecutionThread, backgroundExecutionThread);
    this.dataRepository = dataRepository;
  }

  @Override
  Observable<RoundEntity<Card>> getResultObservable(Params params, Scheduler backgroundScheduler) {
    return dataRepository.getCurrentRound(params.matchId)
            .observeOn(backgroundScheduler);
  }

  public static final class Params {
    private int matchId;

    private Params(int matchId) {
      this.matchId = matchId;
    }

    public static Params getParamsFromMatchId(int matchId) {
      return new Params(matchId);
    }
  }
}
