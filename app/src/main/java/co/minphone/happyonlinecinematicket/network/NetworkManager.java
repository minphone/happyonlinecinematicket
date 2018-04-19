package co.minphone.happyonlinecinematicket.network;

import co.minphone.happyonlinecinematicket.network.model.UserVO;
import java.io.IOException;

public interface NetworkManager {

  UserVO logInUser(long facebookId, String userName, String email, int gender, String profilePic)
      throws
      IOException;
}
