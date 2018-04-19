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
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.adapter.GenreForMovieAdapter;
import co.minphone.happyonlinecinematicket.adapter.MovieShowTimeAdapter;
import co.minphone.happyonlinecinematicket.mvp.BaseActivity;
import co.minphone.happyonlinecinematicket.utilities.ImageViewPagerAdapter;

public class MovieDetailsActivity extends BaseActivity {

  @BindView(R.id.viewPager) ViewPager vpHero;
  @BindView(R.id.toolBar) Toolbar toolbar;
  @BindView(R.id.iv_movie_poster) ImageView ivMoviePoster;
  @BindView(R.id.rv_genre) RecyclerView rvGenre;
  @BindView(R.id.rv_movie_showTime) RecyclerView rvMovieShowTime;

  private ImageViewPagerAdapter pagerAdapter;
  private GenreForMovieAdapter genreForMovieAdapter;
  private MovieShowTimeAdapter movieShowTimeAdapter;

  public static void start(Context context) {
    start(context, null);
  }

  public static void start(Context context, ActivityOptionsCompat activityOptionsCompat) {
    Intent starter = new Intent(context, MovieDetailsActivity.class);
    if (activityOptionsCompat == null) {
      context.startActivity(starter);
    } else {
      context.startActivity(starter, activityOptionsCompat.toBundle());
    }
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setUpViewPager();
    setUpToolbar();
    setUpGenreList();
    setUpMovieShowTime();
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
    vpHero.setAdapter(pagerAdapter);
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
