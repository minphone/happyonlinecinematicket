package co.minphone.happyonlinecinematicket.di.subComponent;

import co.minphone.happyonlinecinematicket.activity.RegisterActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent public interface RegisterSubComponent extends AndroidInjector<RegisterActivity> {
  @Subcomponent.Builder abstract class Builder extends AndroidInjector.Builder<RegisterActivity> {
  }
}
