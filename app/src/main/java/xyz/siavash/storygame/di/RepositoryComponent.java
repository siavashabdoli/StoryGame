package xyz.siavash.storygame.di;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class,
            DataRepositoryModule.class})
public interface RepositoryComponent {
}