package xyz.siavash.storygame.di;

import xyz.siavash.storygame.domain.DataRepository;
import xyz.siavash.storygame.repository.DataProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Siavash on 12/7/17.
 */

@Module(includes = {NetModule.class})
public class DataRepositoryModule {

    @Provides
    @Singleton
    DataRepository provideRepository(DataProvider dataProvider){
        return dataProvider;
    }
}
