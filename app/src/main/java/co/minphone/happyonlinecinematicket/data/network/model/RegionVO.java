package co.minphone.happyonlinecinematicket.data.network.model;

import com.google.gson.annotations.SerializedName;

public class RegionVO {
  @SerializedName("id") private int id;
  @SerializedName("region_name") private String regionName;

  public int getId() {
    return id;
  }

  public String getRegionName() {
    return regionName;
  }
}
