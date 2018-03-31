package co.minphone.happyonlinecinematicket.viewholder;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.adapter.BookedProfileAdapter;
import co.minphone.happyonlinecinematicket.adapter.GenreForMovieAdapter;
import co.minphone.happyonlinecinematicket.core.BaseViewHolder;
import co.minphone.happyonlinecinematicket.model.MovieModel;
import co.minphone.happyonlinecinematicket.utilities.ItemViewOnClickListener;

/**
 * Created by MinPhone on 3/18/18.
 */

public class MovieHolder extends BaseViewHolder<MovieModel> {

  @BindView(R.id.rv_genre) RecyclerView rvGenre;
  @BindView(R.id.rv_booked_profile) RecyclerView rvBookedProfile;

  private GenreForMovieAdapter genreForMovieAdapter;
  private BookedProfileAdapter bookedProfileAdapter;

  public MovieHolder(View itemView, @Nullable
      ItemViewOnClickListener itemViewOnClickListener) {
    super(itemView, itemViewOnClickListener);
  }

  @Override public void bindData(MovieModel data) {
    setUpGenreList();
    setUpBookedProfileList();
  }

  private void setUpBookedProfileList() {
    bookedProfileAdapter = new BookedProfileAdapter();
    rvBookedProfile.setAdapter(bookedProfileAdapter);
    rvBookedProfile.setLayoutManager(
        new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
  }

  private void setUpGenreList() {
    genreForMovieAdapter = new GenreForMovieAdapter();
    rvGenre.setAdapter(genreForMovieAdapter);
    rvGenre.setLayoutManager(
        new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
  }
}
