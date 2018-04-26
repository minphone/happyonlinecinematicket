package co.minphone.happyonlinecinematicket.Viewable;

import co.minphone.happyonlinecinematicket.data.network.model.MovieVO;
import co.minphone.happyonlinecinematicket.mvp.contract.Presentable;
import co.minphone.happyonlinecinematicket.mvp.contract.Viewable;
import java.util.List;

public interface MoviesView<T extends Presentable> extends Viewable<T> {
  void renderError(String message);

  void renderMovies(List<MovieVO> movieVOS);
}
