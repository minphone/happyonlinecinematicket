package co.minphone.happyonlinecinematicket.data.network;

import co.minphone.happyonlinecinematicket.data.network.model.RegionVO;
import co.minphone.happyonlinecinematicket.data.network.model.UserVO;
import co.minphone.happyonlinecinematicket.data.network.service.LogInService;
import co.minphone.happyonlinecinematicket.data.network.service.RegionService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Retrofit;

public class NetworkManagerImpl implements NetworkManager {

  private final LogInService logInService;
  private final RegionService regionService;

  @Inject public NetworkManagerImpl(Retrofit retrofit) {
    logInService = retrofit.create(LogInService.class);
    regionService = retrofit.create(RegionService.class);
  }

  @Override public UserVO logInUser(long facebookId, String userName, String email, int gender,
      String profilePic, String password, int location) throws IOException {
    return logInService.logInUser(facebookId, userName, email, gender, profilePic, password, location)
        .execute()
        .body();
  }

  @Override public List<RegionVO> getRegions() throws IOException {
    return regionService.getRegions().execute().body();
  }
}
