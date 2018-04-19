package co.minphone.happyonlinecinematicket.di.subComponent;

import co.minphone.happyonlinecinematicket.activity.LogInActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent public interface LogInSubComponent extends AndroidInjector<LogInActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<LogInActivity> {
  }
}
