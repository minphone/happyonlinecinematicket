package co.minphone.happyonlinecinematicket.presenter;

import co.minphone.happyonlinecinematicket.Viewable.SplashView;
import co.minphone.happyonlinecinematicket.data.DataManager;
import co.minphone.happyonlinecinematicket.mvp.BasePresenter;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class SplashPresenter extends BasePresenter<SplashView> {

  private final DataManager dataManager;

  @Inject public SplashPresenter(DataManager dataManager) {
    this.dataManager = dataManager;
  }

  @Override public void onStart() {
    super.onStart();
    dataManager.getIsFirstTime()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            new SingleObserver<Boolean>() {
              @Override public void onSubscribe(Disposable d) {

              }

              @Override public void onSuccess(Boolean aBoolean) {
                getView().renderData(aBoolean);
              }

              @Override public void onError(Throwable e) {
                getView().renderError(e.getMessage());
              }
            });
  }
}
