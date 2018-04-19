package co.minphone.happyonlinecinematicket.mvp.contract;

public interface Viewable<T> {

  void injectPresenter(T presenter);

  T getPresenter();

  void showLoading();

  void hideLoading();
}
