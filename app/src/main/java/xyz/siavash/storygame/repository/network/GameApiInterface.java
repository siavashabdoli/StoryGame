package xyz.siavash.storygame.repository.network;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;
import xyz.siavash.storygame.domain.entity.ImageCard;
import xyz.siavash.storygame.repository.networkitem.TokenResponse;

/**
 * Created by Siavash on 2/27/18.
 */

public interface GameApiInterface {
  @GET
  Observable<Response<TokenResponse>> getTokenWithURL(@Url String ur);

}
