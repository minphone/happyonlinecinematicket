package co.minphone.happyonlinecinematicket.di;

import android.content.Context;
import co.minphone.happyonlinecinematicket.App;
import co.minphone.happyonlinecinematicket.data.DataManager;
import co.minphone.happyonlinecinematicket.data.DataManagerImpl;
import co.minphone.happyonlinecinematicket.data.internalStorage.InternalStorageManager;
import co.minphone.happyonlinecinematicket.data.internalStorage.InternalStorageManagerImpl;
import co.minphone.happyonlinecinematicket.di.subComponent.CinemaSubComponent;
import co.minphone.happyonlinecinematicket.di.subComponent.LogInSubComponent;
import co.minphone.happyonlinecinematicket.di.subComponent.ListViewTheaterSubComponent;
import co.minphone.happyonlinecinematicket.di.subComponent.MovieDetailsSubComponent;
import co.minphone.happyonlinecinematicket.di.subComponent.MovieSubComponent;
import co.minphone.happyonlinecinematicket.data.network.NetworkManager;
import co.minphone.happyonlinecinematicket.data.network.NetworkManagerImpl;
import co.minphone.happyonlinecinematicket.data.network.RestAdapter;
import co.minphone.happyonlinecinematicket.di.subComponent.RegisterSubComponent;
import co.minphone.happyonlinecinematicket.di.subComponent.SplashSubComponent;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;

@Module(subcomponents = {
    LogInSubComponent.class, MovieSubComponent.class, SplashSubComponent.class,
    CinemaSubComponent.class, MovieDetailsSubComponent.class, RegisterSubComponent.class,
    ListViewTheaterSubComponent.class
})
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

  @Provides @Singleton InternalStorageManager provideInternalStorageManager(Context context) {
    return new InternalStorageManagerImpl(context);
  }

  @Singleton @Provides DataManager provideDataManager(NetworkManager networkManager,
      InternalStorageManager internalStorageManager) {
    return new DataManagerImpl(networkManager, internalStorageManager);
  }
}
