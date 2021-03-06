package co.minphone.happyonlinecinematicket.presenter;

import co.minphone.happyonlinecinematicket.Viewable.LogInView;
import co.minphone.happyonlinecinematicket.data.DataManager;
import co.minphone.happyonlinecinematicket.data.network.model.UserVO;
import co.minphone.happyonlinecinematicket.mapper.UserMapper;
import co.minphone.happyonlinecinematicket.model.UserModel;
import co.minphone.happyonlinecinematicket.mvp.BasePresenter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class LogInPresenter extends BasePresenter<LogInView> {

  private final DataManager dataManager;

  private final String USER_NOT_REGISTER = "UserNotRegister";

  @Inject public LogInPresenter(DataManager dataManager) {
    this.dataManager = dataManager;
  }

  public void logInUser(final String userId, final String name, final String email,
      final String gender,
      final String profilePic, String password) {
    int genderValue;
    if (gender.equals("male")) {
      genderValue = 0;
    } else {
      genderValue = 1;
    }
    dataManager.logInUser(Long.parseLong(userId), name, email, genderValue, profilePic, password, 1)
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
        }).doOnNext(new Consumer<UserModel>() {
      @Override public void accept(UserModel userModel) throws Exception {
        dataManager.updateFirstTime();
      }
    }).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<UserModel>() {
          @Override public void onSubscribe(Disposable d) {

          }

          @Override public void onNext(UserModel userModel) {
            getView().renderHomeScreen();
          }

          @Override public void onError(Throwable e) {
            if (e.getMessage().equals(USER_NOT_REGISTER)) {
              getView().renderRegistrationScreen(userId, name, email, gender, profilePic);
            } else {
              getView().renderError(e.getMessage());
            }
          }

          @Override public void onComplete() {

          }
        });
  }
}
