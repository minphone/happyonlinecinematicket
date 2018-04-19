package co.minphone.happyonlinecinematicket.di;

import android.app.Activity;
import co.minphone.happyonlinecinematicket.activity.LogInActivity;
import co.minphone.happyonlinecinematicket.activity.MoviesActivity;
import co.minphone.happyonlinecinematicket.activity.SplashActivity;
import co.minphone.happyonlinecinematicket.di.subComponent.LogInSubComponent;
import co.minphone.happyonlinecinematicket.di.subComponent.MovieSubComponent;
import co.minphone.happyonlinecinematicket.di.subComponent.SplashSubComponent;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module public abstract class BuilderModule {

  @Binds @IntoMap @ActivityKey(LogInActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindLogInActivityInjectorFactory(
      LogInSubComponent.Builder builder);

  @Binds @IntoMap @ActivityKey(MoviesActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindMoviesActivtiyInjectorFactory(
      MovieSubComponent.Builder builder);

  @Binds @IntoMap @ActivityKey(SplashActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindSplashActivityInjectorFactory(
      SplashSubComponent.Builder builder);
}
