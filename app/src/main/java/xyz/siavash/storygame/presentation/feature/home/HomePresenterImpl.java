package xyz.siavash.storygame.presentation.feature.home;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import javax.inject.Inject;

/**
 * Created by Siavash on 2/28/18.
 */

public class HomePresenterImpl extends MvpBasePresenter<HomeView> implements HomePresenter {

  @Inject
  public HomePresenterImpl() {
  }

  @Override
  public void onCreateGameClicked() {
    ifViewAttached(new ViewAction<HomeView>() {
      @Override
      public void run(@NonNull HomeView view) {
        view.goToCreateGamePage();
      }
    });
  }

  @Override
  public void onJoinGameClicked() {
    ifViewAttached(new ViewAction<HomeView>() {
      @Override
      public void run(@NonNull HomeView view) {
        view.goToMatchesPage();
      }
    });
  }
}
