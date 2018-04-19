package co.minphone.happyonlinecinematicket.di;

import android.app.Activity;
import android.support.v4.app.Fragment;
import co.minphone.happyonlinecinematicket.activity.CinemaActivity;
import co.minphone.happyonlinecinematicket.activity.LogInActivity;
import co.minphone.happyonlinecinematicket.activity.MovieDetailsActivity;
import co.minphone.happyonlinecinematicket.activity.MoviesActivity;
import co.minphone.happyonlinecinematicket.activity.RegisterActivity;
import co.minphone.happyonlinecinematicket.activity.SplashActivity;
import co.minphone.happyonlinecinematicket.di.subComponent.CinemaSubComponent;
import co.minphone.happyonlinecinematicket.di.subComponent.ListViewTheaterSubComponent;
import co.minphone.happyonlinecinematicket.di.subComponent.LogInSubComponent;
import co.minphone.happyonlinecinematicket.di.subComponent.MovieDetailsSubComponent;
import co.minphone.happyonlinecinematicket.di.subComponent.MovieSubComponent;
import co.minphone.happyonlinecinematicket.di.subComponent.RegisterSubComponent;
import co.minphone.happyonlinecinematicket.di.subComponent.SplashSubComponent;
import co.minphone.happyonlinecinematicket.fragment.ListViewTheaterFragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
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

  @Binds @IntoMap @ActivityKey(CinemaActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindCinemaActivityInjectorFactory(
      CinemaSubComponent.Builder builder);

  @Binds @IntoMap @ActivityKey(MovieDetailsActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindMovieDetailsActivityInjectorFactory(
      MovieDetailsSubComponent.Builder builder);

  @Binds @IntoMap @ActivityKey(RegisterActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindRegisterActivityInjectorFactory(
      RegisterSubComponent.Builder builder);

  @Binds @IntoMap @FragmentKey(ListViewTheaterFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindListViewTheaterFragmentInjectorFactory(
      ListViewTheaterSubComponent.Builder builder);
}
