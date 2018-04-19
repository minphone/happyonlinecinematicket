package co.minphone.happyonlinecinematicket.di;

import android.content.Context;
import co.minphone.happyonlinecinematicket.App;
import co.minphone.happyonlinecinematicket.data.DataManager;
import co.minphone.happyonlinecinematicket.data.DataManagerImpl;
import co.minphone.happyonlinecinematicket.di.subComponent.LogInSubComponent;
import co.minphone.happyonlinecinematicket.di.subComponent.MovieSubComponent;
import co.minphone.happyonlinecinematicket.network.NetworkManager;
import co.minphone.happyonlinecinematicket.network.NetworkManagerImpl;
import co.minphone.happyonlinecinematicket.network.RestAdapter;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;

@Module(subcomponents = { LogInSubComponent.class, MovieSubComponent.class })
public class ApplicationModule {

  @Provides Context provideContext(App application) {
    return application.getApplicationContext();
  }

  @Singleton @Provides Retrofit provideRetrofit() {
    return RestAdapter.create();
  }

  @Singleton @Provides NetworkManager provideNetworkManager(Retrofit retrofit) {
    return new NetworkManagerImpl(retrofit);
  }

  @Singleton @Provides DataManager provideDataManager(NetworkManager networkManager) {
    return new DataManagerImpl(networkManager);
  }
}
