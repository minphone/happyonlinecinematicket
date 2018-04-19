package co.minphone.happyonlinecinematicket.network;

import co.minphone.happyonlinecinematicket.BuildConfig;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAdapter {
  public static Retrofit create(){
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    if (BuildConfig.DEBUG) {
      HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
      httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      httpClient.addInterceptor(httpLoggingInterceptor);
    }

    return new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .build();
  }
}
