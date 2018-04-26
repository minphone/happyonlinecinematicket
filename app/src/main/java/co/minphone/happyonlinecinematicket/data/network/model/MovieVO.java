package co.minphone.happyonlinecinematicket.data.network.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MovieVO {
  @SerializedName("id") private int id;
  @SerializedName("title") private String title;
  @SerializedName("movie_poster") private ImageVO poster;
  @SerializedName("movie_background_poster") private ImageVO bgPoster;
  @SerializedName("short_desc") private String desc;
  @SerializedName("full_desc") private String fullDesc;
  @SerializedName("isMovie3D") private boolean movie3D;
  @SerializedName("genres") private List<GenreVO> genreVOS;

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public ImageVO getPoster() {
    return poster;
  }

  public ImageVO getBgPoster() {
    return bgPoster;
  }

  public String getDesc() {
    return desc;
  }

  public String getFullDesc() {
    return fullDesc;
  }

  public boolean isMovie3D() {
    return movie3D;
  }

  public List<GenreVO> getGenreVOS() {
    return genreVOS;
  }
}
