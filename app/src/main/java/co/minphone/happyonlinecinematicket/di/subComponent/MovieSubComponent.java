package co.minphone.happyonlinecinematicket.di.subComponent;

import co.minphone.happyonlinecinematicket.activity.MoviesActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent public interface MovieSubComponent extends AndroidInjector<MoviesActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<MoviesActivity> {
  }
}
