package co.minphone.happyonlinecinematicket.model;

import com.google.auto.value.AutoValue;
import java.util.List;

/**
 * Created by MinPhone on 3/18/18.
 */

@AutoValue public abstract class MovieModel {
  public abstract long id();

  public abstract String posterUrl();

  public abstract String movieName();

  public abstract double rating();

  public abstract boolean is3D();

  public abstract String language();

  public abstract String shortDesc();

  public abstract String desc();

  public abstract long viewedCount();

  public abstract List<GenreModel> genreModels();

  public static MovieModel create(long id, String posterUrl, String movieName, double rating,
      boolean is3D, String language, String shortDesc, String desc, long viewedCount,
      List<GenreModel> genreModels) {
    return builder().id(id)
        .posterUrl(posterUrl)
        .movieName(movieName)
        .rating(rating)
        .is3D(is3D)
        .language(language)
        .shortDesc(shortDesc)
        .desc(desc)
        .viewedCount(viewedCount)
        .genreModels(genreModels)
        .build();
  }

  public static Builder builder() {
    return new AutoValue_MovieModel.Builder();
  }

  @AutoValue.Builder public abstract static class Builder {
    public abstract Builder id(long id);

    public abstract Builder posterUrl(String posterUrl);

    public abstract Builder movieName(String movieName);

    public abstract Builder rating(double rating);

    public abstract Builder is3D(boolean is3D);

    public abstract Builder language(String language);

    public abstract Builder shortDesc(String shortDesc);

    public abstract Builder desc(String desc);

    public abstract Builder viewedCount(long viewedCount);

    public abstract Builder genreModels(List<GenreModel> genreModels);

    public abstract MovieModel build();
  }
}
