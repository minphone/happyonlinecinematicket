package co.minphone.happyonlinecinematicket.mapper;

import co.minphone.happyonlinecinematicket.model.UserModel;
import co.minphone.happyonlinecinematicket.network.model.UserVO;

public class UserMapper extends BaseMapper<UserVO, UserModel> {

  @Override public UserModel map(UserVO obj) {
    UserModel.Builder userModelBuilder = UserModel.builder();
    if (obj.getUsername() != null) {
      userModelBuilder.username(obj.getUsername());
    }
    if (obj.getEmail() != null) {
      userModelBuilder.email(obj.getEmail());
    }
    if (obj.getProfileUrl() != null) {
      userModelBuilder.profileUrl(obj.getProfileUrl());
    }
    userModelBuilder
        .gender(obj.getGender())
        .region_id(obj.getRegion_id())
        .id(obj.getId());
    return userModelBuilder.build();
  }
}
