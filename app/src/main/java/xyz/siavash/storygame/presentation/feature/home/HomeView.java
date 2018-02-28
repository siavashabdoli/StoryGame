package xyz.siavash.storygame.presentation.feature.home;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by Siavash on 2/28/18.
 */

public interface HomeView extends MvpView {
  void goToCreateGamePage();
  void goToMatchesPage();
}
