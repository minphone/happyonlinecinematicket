package co.minphone.happyonlinecinematicket.di.subComponent;

import co.minphone.happyonlinecinematicket.activity.SplashActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent public interface SplashSubComponent extends AndroidInjector<SplashActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<SplashActivity> {
  }
}
