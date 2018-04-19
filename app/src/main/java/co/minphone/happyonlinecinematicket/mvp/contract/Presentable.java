package co.minphone.happyonlinecinematicket.mvp.contract;

import android.support.annotation.NonNull;

public interface Presentable<V extends Viewable> {

  void onStart();

  void onResume();

  void onPause();

  void onStop();

  void onCreatedView();

  V getView();

  void attachView(@NonNull V viewable);
}
