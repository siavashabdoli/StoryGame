package xyz.siavash.storygame.presentation.feature.home;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

/**
 * Created by Siavash on 2/28/18.
 */

public interface HomePresenter extends MvpPresenter<HomeView> {
  void onCreateGameClicked();
  void onJoinGameClicked();
}
