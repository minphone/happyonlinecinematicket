package co.minphone.happyonlinecinematicket.di;

import co.minphone.happyonlinecinematicket.App;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

@Singleton @Component(modules = {
    AndroidInjectionModule.class, ApplicationModule.class, AndroidSupportInjectionModule.class, BuilderModule.class
})
public interface ApplicationComponent {

  void inject(App application);
}
