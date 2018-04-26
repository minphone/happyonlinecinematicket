package co.minphone.happyonlinecinematicket.presenter;

import co.minphone.happyonlinecinematicket.Viewable.MoviesView;
import co.minphone.happyonlinecinematicket.data.DataManager;
import co.minphone.happyonlinecinematicket.data.network.model.MovieVO;
import co.minphone.happyonlinecinematicket.mvp.BasePresenter;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

public class MoviesPresenter extends BasePresenter<MoviesView> {

  private final DataManager dataManager;

  @Inject public MoviesPresenter(DataManager dataManager) {
    this.dataManager = dataManager;
  }

  public void getMovies() {
    getView().showLoading();
    dataManager.getMovies(1)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new SingleObserver<List<MovieVO>>() {
          @Override public void onSubscribe(Disposable d) {

          }

          @Override public void onSuccess(List<MovieVO> movieVOS) {
            getView().renderMovies(movieVOS);
          }

          @Override public void onError(Throwable e) {
            getView().renderError(e.getMessage());
          }
        });
  }
}

