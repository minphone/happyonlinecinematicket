package co.minphone.happyonlinecinematicket;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import co.minphone.happyonlinecinematicket.di.DaggerApplicationComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;
import javax.inject.Inject;

public class App extends Application implements HasActivityInjector, HasSupportFragmentInjector {

  @Inject DispatchingAndroidInjector<Activity> dispatchingActivityInjector;
  @Inject DispatchingAndroidInjector<Fragment> dispatchingFragmentInjector;

  @Override public void onCreate() {
    super.onCreate();

    DaggerApplicationComponent.builder().application(this).build().inject(this);
  }

  @Override public AndroidInjector<Activity> activityInjector() {
    return dispatchingActivityInjector;
  }

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return dispatchingFragmentInjector;
  }
}
