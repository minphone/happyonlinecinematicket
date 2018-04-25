package co.minphone.happyonlinecinematicket.data.network.model;

import com.google.gson.annotations.SerializedName;

public class UserVO {
  @SerializedName("id") public int id;

  @SerializedName("username") private String username;

  @SerializedName("email") private String email;

  @SerializedName("gender") private int gender;

  @SerializedName("region_id") private int region_id;

  @SerializedName("facebook_id") private long facebook_id;

  @SerializedName("profileUrl") private String profileUrl;

  @SerializedName("error") private String error;

  @SerializedName("is_verified") private boolean verified;

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public int getGender() {
    return gender;
  }

  public int getRegion_id() {
    return region_id;
  }

  public long getFacebook_id() {
    return facebook_id;
  }

  public String getProfileUrl() {
    return profileUrl;
  }

  public String getError() {
    return error;
  }

  public boolean isVerified() {
    return verified;
  }
}
