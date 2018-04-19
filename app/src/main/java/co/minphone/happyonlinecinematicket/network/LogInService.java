package co.minphone.happyonlinecinematicket.network;

import co.minphone.happyonlinecinematicket.network.model.UserVO;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LogInService {

  @FormUrlEncoded @POST(URL.FACEBOOKLOGIN) Call<UserVO> logInUser(@Field("fb_id") long facebookId,
      @Field("username") String userName, @Field("email") String email, @Field("gender") int gender,
      @Field("profile_pic") String profilePic);
}
