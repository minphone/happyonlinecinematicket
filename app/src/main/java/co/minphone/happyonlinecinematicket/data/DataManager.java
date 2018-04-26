package co.minphone.happyonlinecinematicket.data;

import co.minphone.happyonlinecinematicket.data.network.model.MovieVO;
import co.minphone.happyonlinecinematicket.data.network.model.RegionVO;
import co.minphone.happyonlinecinematicket.data.network.model.UserVO;
import io.reactivex.Single;
import java.util.List;

public interface DataManager {
  Single<UserVO> logInUser(long userId, String name, String email, int gender, String profilePic,
      String password, int location);

  void updateFirstTime();

  Single<Boolean> getIsFirstTime();

  Single<List<RegionVO>> getRegions();

  Single<List<MovieVO>> getMovies(int page);
}
