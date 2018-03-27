package co.minphone.happyonlinecinematicket.model;

import com.google.auto.value.AutoValue;

/**
 * Created by MinPhone on 3/18/18.
 */

@AutoValue public abstract class GenreModel {
  public abstract long id();

  public abstract String name();

  public static GenreModel create(long id, String name) {
    return builder().id(id).name(name).build();
  }

  public static Builder builder() {
    return new AutoValue_GenreModel.Builder();
  }

  @AutoValue.Builder public abstract static class Builder {
    public abstract Builder id(long id);

    public abstract Builder name(String name);

    public abstract GenreModel build();
  }
}
