package co.minphone.happyonlinecinematicket;

import android.app.Activity;
import android.app.Application;
import co.minphone.happyonlinecinematicket.di.DaggerApplicationComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;

public class App extends Application implements HasActivityInjector{

  @Inject DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

  @Override public void onCreate() {
    super.onCreate();

    DaggerApplicationComponent.builder().build().inject(this);
  }

  @Override public AndroidInjector<Activity> activityInjector() {
    return dispatchingActivityInjector;
  }
}
