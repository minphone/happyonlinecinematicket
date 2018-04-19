package co.minphone.happyonlinecinematicket.di.subComponent;

import co.minphone.happyonlinecinematicket.activity.MovieDetailsActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent public interface MovieDetailsSubComponent
    extends AndroidInjector<MovieDetailsActivity> {
  @Subcomponent.Builder abstract class Builder
      extends AndroidInjector.Builder<MovieDetailsActivity> {
  }
}
