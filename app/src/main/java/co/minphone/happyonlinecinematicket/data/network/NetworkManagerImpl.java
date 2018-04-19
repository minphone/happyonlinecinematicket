package co.minphone.happyonlinecinematicket.data.network;

import co.minphone.happyonlinecinematicket.data.network.model.UserVO;
import java.io.IOException;
import javax.inject.Inject;
import retrofit2.Retrofit;

public class NetworkManagerImpl implements NetworkManager {

  private final LogInService logInService;

  @Inject public NetworkManagerImpl(Retrofit retrofit) {
    logInService = retrofit.create(LogInService.class);
  }

  @Override public UserVO logInUser(long facebookId, String userName, String email, int gender,
      String profilePic) throws IOException {
    return logInService.logInUser(facebookId, userName, email, gender, profilePic)
        .execute()
        .body();
  }
}
