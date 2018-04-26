package co.minphone.happyonlinecinematicket.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.BuildConfig;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.Viewable.MovieDetailsView;
import co.minphone.happyonlinecinematicket.adapter.GenreForMovieAdapter;
import co.minphone.happyonlinecinematicket.adapter.MovieShowTimeAdapter;
import co.minphone.happyonlinecinematicket.data.network.model.MovieVO;
import co.minphone.happyonlinecinematicket.mvp.BaseActivity;
import co.minphone.happyonlinecinematicket.presenter.MovieDetailsPresenter;
import co.minphone.happyonlinecinematicket.utilities.ImageViewPagerAdapter;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dagger.android.AndroidInjection;
import java.util.List;

public class MovieDetailsActivity extends BaseActivity<MovieDetailsPresenter> implements
    MovieDetailsView<MovieDetailsPresenter> {

  //@BindView(R.id.viewPager) ViewPager vpHero;
  @BindView(R.id.toolBar) Toolbar toolbar;
  @BindView(R.id.iv_movie_poster) ImageView ivMoviePoster;
  @BindView(R.id.iv_bg_poster) ImageView ivBgPoster;
  @BindView(R.id.rv_genre) RecyclerView rvGenre;
  @BindView(R.id.rv_movie_showTime) RecyclerView rvMovieShowTime;
  @BindView(R.id.tv_movie_title) TextView tvTitle;
  @BindView(R.id.tv_movie_type) TextView tvType;
  @BindView(R.id.tv_full_desc) TextView tvDesc;

  private ImageViewPagerAdapter pagerAdapter;
  private GenreForMovieAdapter genreForMovieAdapter;
  private MovieShowTimeAdapter movieShowTimeAdapter;

  private static final String DATA = "data";

  public static void start(Context context) {
    start(context, null, null);
  }

  public static void start(Context context, ActivityOptionsCompat activityOptionsCompat,
      String data) {
    Intent starter = new Intent(context, MovieDetailsActivity.class);
    starter.putExtra(DATA, data);
    if (activityOptionsCompat == null) {
      context.startActivity(starter);
    } else {
      context.startActivity(starter, activityOptionsCompat.toBundle());
    }
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    AndroidInjection.inject(this);
    super.onCreate(savedInstanceState);

    //setUpViewPager();
    setUpToolbar();
    setUpGenreList();
    setUpMovieShowTime();

    Bundle bundle = getIntent().getExtras();
    if (bundle != null) {
      MovieVO data =
          new Gson().fromJson(bundle.getString(DATA), new TypeToken<MovieVO>() {
          }.getType());
      bindData(data);
    }
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_movie_detail;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        supportFinishAfterTransition();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void bindData(MovieVO data) {
    Glide.with(ivMoviePoster.getContext())
        .load(BuildConfig.BASE_URL + data.getPoster().getThumbImageVO().getUrl())
        .into(ivMoviePoster);

    Glide.with(ivBgPoster.getContext())
        .load(BuildConfig.BASE_URL + data.getBgPoster().getUrl())
        .into(ivBgPoster);
    tvTitle.setText(data.getTitle());
    genreForMovieAdapter.setDataList(data.getGenreVOS());
    if (data.isMovie3D()) {
      tvType.setText("3D");
    } else {
      tvType.setText("2D");
    }
    tvDesc.setText(data.getFullDesc());
  }

  private void setUpToolbar() {
    setSupportActionBar(toolbar);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
      actionBar.setTitle("");
    }
  }

  private void setUpMovieShowTime() {
    movieShowTimeAdapter = new MovieShowTimeAdapter();
    rvMovieShowTime.setAdapter(movieShowTimeAdapter);
    rvMovieShowTime.setLayoutManager(
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
  }

  private void setUpViewPager() {
    pagerAdapter = new ImageViewPagerAdapter();
    //vpHero.setAdapter(pagerAdapter);
  }

  private void setUpGenreList() {
    genreForMovieAdapter = new GenreForMovieAdapter();
    rvGenre.setAdapter(genreForMovieAdapter);
    rvGenre.setLayoutManager(
        new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }
}
