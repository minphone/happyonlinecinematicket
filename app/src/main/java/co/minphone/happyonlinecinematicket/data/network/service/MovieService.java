package co.minphone.happyonlinecinematicket.data.network.service;

import co.minphone.happyonlinecinematicket.data.network.URL;
import co.minphone.happyonlinecinematicket.data.network.model.MovieVO;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {
  @GET(URL.GETMOVIES) Call<List<MovieVO>> getMovies(@Query("page") int page);
}
