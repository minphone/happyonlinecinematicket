package co.minphone.happyonlinecinematicket.data.network.model;

import com.google.gson.annotations.SerializedName;

public class GenreVO {
  @SerializedName("id") private int id;
  @SerializedName("genre_name") private String name;
  @SerializedName("genre_description") private String description;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}
