package xyz.siavash.storygame;

import android.app.Application;

import xyz.siavash.storygame.di.AppComponent;

/**
 * Created by Siavash on 2/27/18.
 */

public class StoryGameApp extends Application {
  AppComponent appComponent;
  @Override
  public void onCreate() {
    super.onCreate();
  }

  public AppComponent getComponent() {
    return appComponent;
  }
}
