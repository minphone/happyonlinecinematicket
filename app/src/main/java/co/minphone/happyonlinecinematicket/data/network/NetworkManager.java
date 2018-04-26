package co.minphone.happyonlinecinematicket.data.network;

import co.minphone.happyonlinecinematicket.data.network.model.MovieVO;
import co.minphone.happyonlinecinematicket.data.network.model.RegionVO;
import co.minphone.happyonlinecinematicket.data.network.model.UserVO;
import java.io.IOException;
import java.util.List;

public interface NetworkManager {

  UserVO logInUser(long facebookId, String userName, String email, int gender, String profilePic,
      String password, int location)
      throws
      IOException;

  List<RegionVO> getRegions() throws IOException;

  List<MovieVO> getMovies(int page) throws IOException;
}
