package co.minphone.happyonlinecinematicket.presenter;

import android.util.Log;
import co.minphone.happyonlinecinematicket.Viewable.LogInView;
import co.minphone.happyonlinecinematicket.data.DataManager;
import co.minphone.happyonlinecinematicket.mapper.UserMapper;
import co.minphone.happyonlinecinematicket.model.UserModel;
import co.minphone.happyonlinecinematicket.mvp.BasePresenter;
import co.minphone.happyonlinecinematicket.network.model.UserVO;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class LogInPresenter extends BasePresenter<LogInView> {

  private final String USER_NOT_REGISTER = "UserNotRegister";

  private final DataManager dataManager;

  @Inject public LogInPresenter(DataManager dataManager) {
    this.dataManager = dataManager;
  }

  public void logInUser(String userId, String name, String email, String gender,
      String profilePic) {
    int genderValue;
    if (gender.equals("male")) {
      genderValue = 0;
    } else {
      genderValue = 1;
    }
    dataManager.logInUser(Long.parseLong(userId), name, email, genderValue, profilePic)
        .toObservable()
        .flatMap(
            new Function<UserVO, ObservableSource<UserVO>>() {
              @Override public ObservableSource<UserVO> apply(UserVO userVO) throws Exception {
                if (userVO.isVerified()) return Observable.just(userVO);
                return Observable.error(new Exception(USER_NOT_REGISTER));
              }
            })
        .map(new Function<UserVO, UserModel>() {
          @Override public UserModel apply(UserVO userVO) throws Exception {
            UserMapper userMapper = new UserMapper();
            return userMapper.map(userVO);
          }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<UserModel>() {
          @Override public void onSubscribe(Disposable d) {

          }

          @Override public void onNext(UserModel userModel) {
            getView().renderHomeScreen();
          }

          @Override public void onError(Throwable e) {
            if (e.getMessage().equals(USER_NOT_REGISTER)) {
              getRegions();
            } else {
              Log.d("Error", "onError: "+ e);
              //getView().renderError(e.getMessage());
            }
          }

          @Override public void onComplete() {

          }
        });
  }

  private void getRegions() {

  }
}
