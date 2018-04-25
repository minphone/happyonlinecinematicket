package co.minphone.happyonlinecinematicket.data;

import co.minphone.happyonlinecinematicket.data.internalStorage.InternalStorageManager;
import co.minphone.happyonlinecinematicket.data.internalStorage.InternalStorageManagerImpl;
import co.minphone.happyonlinecinematicket.data.network.NetworkManager;
import co.minphone.happyonlinecinematicket.data.network.model.RegionVO;
import co.minphone.happyonlinecinematicket.data.network.model.UserVO;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

public class DataManagerImpl implements DataManager {

  private final NetworkManager networkManager;
  private final InternalStorageManager internalStorageManager;

  @Inject public DataManagerImpl(NetworkManager networkManager,
      InternalStorageManager internalStorageManager) {
    this.networkManager = networkManager;
    this.internalStorageManager = internalStorageManager;
  }

  @Override
  public Single<UserVO> logInUser(final long userId, final String name, final String email,
      final int gender,
      final String profilePic, final String password, final int location) {
    return Single.fromCallable(new Callable<UserVO>() {
      @Override public UserVO call() throws Exception {
        return networkManager.logInUser(userId, name, email, gender, profilePic, password, location);
      }
    });
  }

  @Override public void updateFirstTime() {
    internalStorageManager.updateFirstTime();
  }

  @Override public Single<Boolean> getIsFirstTime() {
    return Single.just(internalStorageManager.getIsFirstTime());
  }

  @Override public Single<List<RegionVO>> getRegions() {
    return Single.fromCallable(new Callable<List<RegionVO>>() {
      @Override public List<RegionVO> call() throws Exception {
        return networkManager.getRegions();
      }
    });
  }
}
