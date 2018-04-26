package co.minphone.happyonlinecinematicket.presenter;

import co.minphone.happyonlinecinematicket.Viewable.RegisterView;
import co.minphone.happyonlinecinematicket.data.DataManager;
import co.minphone.happyonlinecinematicket.data.network.model.RegionVO;
import co.minphone.happyonlinecinematicket.data.network.model.UserVO;
import co.minphone.happyonlinecinematicket.mapper.UserMapper;
import co.minphone.happyonlinecinematicket.model.UserModel;
import co.minphone.happyonlinecinematicket.mvp.BasePresenter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

import static io.reactivex.internal.operators.single.SingleInternalHelper.toObservable;

public class RegisterPresenter extends BasePresenter<RegisterView> {

  private final DataManager dataManager;

  private final String USER_NOT_REGISTER = "UserNotRegister";

  @Inject public RegisterPresenter(DataManager dataManager) {
    this.dataManager = dataManager;
  }

  public void getRegions() {
    dataManager.getRegions().subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<RegionVO>>() {
      @Override public void onSubscribe(Disposable d) {

      }

      @Override public void onSuccess(List<RegionVO> regionVO) {
        getView().renderRegion(regionVO);
      }

      @Override public void onError(Throwable e) {
        getView().renderError(e.getMessage());
      }
    });
  }

  public void registerUser(String facebookId, String userName, String email, String gender,
      Integer location, String profilePic) {
    int genderValue;
    if (gender.equals("Male")) {
      genderValue = 0;
    } else {
      genderValue = 1;
    }
    dataManager.logInUser(Long.parseLong(facebookId), userName, email, genderValue, profilePic,
        "P@ssw0rd", location).toObservable()
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
            getView().renderError(e.getMessage());
          }

          @Override public void onComplete() {

          }
        });
  }
}
