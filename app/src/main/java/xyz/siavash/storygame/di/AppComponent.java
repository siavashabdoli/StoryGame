package xyz.siavash.storygame.di;

import javax.inject.Singleton;

import dagger.Component;
import xyz.siavash.storygame.presentation.feature.home.HomePresenterInjector;

@Singleton
@Component(modules = {AppModule.class, NetModule.class,
            DataRepositoryModule.class})
public interface AppComponent {
  void inject(HomePresenterInjector homePresenterInjector);
}