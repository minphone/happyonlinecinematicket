package co.minphone.happyonlinecinematicket.di.subComponent;

import co.minphone.happyonlinecinematicket.activity.CinemaActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent public interface CinemaSubComponent extends AndroidInjector<CinemaActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<CinemaActivity> {
  }
}
