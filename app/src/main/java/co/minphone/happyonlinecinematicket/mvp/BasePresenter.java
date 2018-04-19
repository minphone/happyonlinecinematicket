package co.minphone.happyonlinecinematicket.mvp;

import android.support.annotation.NonNull;
import co.minphone.happyonlinecinematicket.mvp.contract.Presentable;
import co.minphone.happyonlinecinematicket.mvp.contract.Viewable;

public class BasePresenter<T extends Viewable> implements Presentable<T> {

  private T getView;

  @Override public void onStart() {

  }

  @Override public void onResume() {

  }

  @Override public void onPause() {

  }

  @Override public void onStop() {

  }

  @Override public void onCreatedView() {

  }

  @Override public T getView() {
    return getView;
  }

  @Override public void attachView(@NonNull T viewable) {
    this.getView = viewable;
  }
}
