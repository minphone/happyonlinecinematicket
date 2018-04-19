package co.minphone.happyonlinecinematicket.data;

import co.minphone.happyonlinecinematicket.network.model.UserVO;
import io.reactivex.Single;

public interface DataManager {
  Single<UserVO> logInUser(long userId, String name, String email, int gender, String profilePic);
}
