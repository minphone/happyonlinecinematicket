package co.minphone.happyonlinecinematicket.viewholder;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import co.minphone.happyonlinecinematicket.BuildConfig;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.adapter.BookedProfileAdapter;
import co.minphone.happyonlinecinematicket.adapter.GenreForMovieAdapter;
import co.minphone.happyonlinecinematicket.data.network.model.MovieVO;
import co.minphone.happyonlinecinematicket.model.MovieModel;
import co.minphone.happyonlinecinematicket.utilities.ItemViewOnClickListener;
import co.minphone.happyonlinecinematicket.view.BaseViewHolder;
import com.bumptech.glide.Glide;

/**
 * Created by MinPhone on 3/18/18.
 */

public class MovieHolder extends BaseViewHolder<MovieVO> {

  @BindView(R.id.rv_genre) RecyclerView rvGenre;
  @BindView(R.id.rv_booked_profile) RecyclerView rvBookedProfile;
  @BindView(R.id.iv_movie_poster) ImageView ivPoster;
  @BindView(R.id.tv_movie_title) TextView tvTitle;
  @BindView(R.id.tv_movie_type) TextView tvMovieType;
  @BindView(R.id.tv_movie_short_desc) TextView tvDesc;

  private GenreForMovieAdapter genreForMovieAdapter;
  private BookedProfileAdapter bookedProfileAdapter;

  public MovieHolder(View itemView, @Nullable
      ItemViewOnClickListener itemViewOnClickListener) {
    super(itemView, itemViewOnClickListener);
    setUpGenreList();
    setUpBookedProfileList();
  }

  @Override public void bindData(MovieVO data) {
    if (data.getPoster() != null) {
      Glide.with(itemView.getContext())
          .load(BuildConfig.BASE_URL + data.getPoster().getThumbImageVO().getUrl())
          .into(ivPoster);
    }
    tvTitle.setText(data.getTitle());
    if (data.isMovie3D()) {
      tvMovieType.setText("3D");
    } else {
      tvMovieType.setText("2D");
    }
    tvDesc.setText(data.getDesc());
    genreForMovieAdapter.setDataList(data.getGenreVOS());
  }

  @OnClick(R.id.cv_movie) public void onCardViewClick() {
    itemViewOnClickListener.onItemClick(getAdapterPosition(), itemView);
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
