package co.minphone.happyonlinecinematicket.data;

import co.minphone.happyonlinecinematicket.data.internalStorage.InternalStorageManager;
import co.minphone.happyonlinecinematicket.data.network.NetworkManager;
import co.minphone.happyonlinecinematicket.data.network.model.UserVO;
import io.reactivex.Single;
import java.util.concurrent.Callable;
import javax.inject.Inject;

public class DataManagerImpl implements DataManager {

  private final NetworkManager networkManager;
  private final InternalStorageManager internalStorageManager;

  @Inject public DataManagerImpl(NetworkManager networkManager, InternalStorageManager internalStorageManager) {
    this.networkManager = networkManager;
    this.internalStorageManager = internalStorageManager;
  }

  @Override public Single<UserVO> logInUser(final long userId, final String name, final String email, final int gender,
      final String profilePic) {
    return Single.fromCallable(new Callable<UserVO>() {
      @Override public UserVO call() throws Exception {
        return networkManager.logInUser(userId, name, email, gender, profilePic);
      }
    });
  }

  @Override public void updateFirstTime() {
    internalStorageManager.updateFirstTime();
  }
}
