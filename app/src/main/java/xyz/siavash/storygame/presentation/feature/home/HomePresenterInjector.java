package xyz.siavash.storygame.presentation.feature.home;

import javax.inject.Inject;

import xyz.siavash.storygame.di.AppComponent;

/**
 * Created by Siavash on 2/28/18.
 */

public class HomePresenterInjector {

  @Inject HomePresenterImpl homePresenter;

  public HomePresenterInjector(AppComponent appComponent) {
    appComponent.inject(this);
  }

  public HomePresenter getPresenter() {
    return homePresenter;
  }
}
