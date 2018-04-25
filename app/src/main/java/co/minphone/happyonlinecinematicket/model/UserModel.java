package co.minphone.happyonlinecinematicket.model;

import android.support.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue public abstract class UserModel {
  public abstract int id();

  public abstract String username();

  public abstract String email();

  public abstract int gender();

  public abstract int region_id();

  @Nullable public abstract String profileUrl();

  public static UserModel create(int id, String username, String email, int gender, int region_id,
      String profileUrl) {
    return builder()
        .id(id)
        .username(username)
        .email(email)
        .gender(gender)
        .region_id(region_id)
        .profileUrl(profileUrl)
        .build();
  }

  public static Builder builder() {
    return new AutoValue_UserModel.Builder();
  }

  @AutoValue.Builder public abstract static class Builder {
    public abstract Builder id(int id);

    public abstract Builder username(String username);

    public abstract Builder email(String email);

    public abstract Builder gender(int gender);

    public abstract Builder region_id(int region_id);

    public abstract Builder profileUrl(String profileUrl);

    public abstract UserModel build();
  }
}
