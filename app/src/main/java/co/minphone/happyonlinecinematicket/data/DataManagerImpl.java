package co.minphone.happyonlinecinematicket.data;

import co.minphone.happyonlinecinematicket.network.NetworkManager;
import co.minphone.happyonlinecinematicket.network.model.UserVO;
import io.reactivex.Single;
import java.util.concurrent.Callable;
import javax.inject.Inject;

public class DataManagerImpl implements DataManager {

  private final NetworkManager networkManager;

  @Inject public DataManagerImpl(NetworkManager networkManager) {
    this.networkManager = networkManager;
  }

  @Override public Single<UserVO> logInUser(final long userId, final String name, final String email, final int gender,
      final String profilePic) {
    return Single.fromCallable(new Callable<UserVO>() {
      @Override public UserVO call() throws Exception {
        return networkManager.logInUser(userId, name, email, gender, profilePic);
      }
    });
  }
}
