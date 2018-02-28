package xyz.siavash.storygame.domain.interactor;

import javax.inject.Inject;

import rx.Observable;
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

  @Inject
  public GetRoundData(DataRepository dataRepository, RepositoryExecutionThread repositoryExecutionThread, BackgroundExecutionThread backgroundExecutionThread) {
    super(repositoryExecutionThread, backgroundExecutionThread);
    this.dataRepository = dataRepository;
  }

  @Override
  Observable<RoundEntity<Card>> getResultObservable(Params params) {
    return dataRepository.getCurrentRound(params.matchId)
            .observeOn(getBackgroundExecutionThread());
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
