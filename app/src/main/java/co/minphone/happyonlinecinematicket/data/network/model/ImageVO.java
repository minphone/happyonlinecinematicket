package co.minphone.happyonlinecinematicket.data.network.model;

import com.google.gson.annotations.SerializedName;

public class ImageVO {
  @SerializedName("url") private String url;
  @SerializedName("thumb") private ThumbImageVO thumbImageVO;

  public String getUrl() {
    return url;
  }

  public ThumbImageVO getThumbImageVO() {
    return thumbImageVO;
  }
}
