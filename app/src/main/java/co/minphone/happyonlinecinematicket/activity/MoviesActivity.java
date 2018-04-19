package co.minphone.happyonlinecinematicket.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import butterknife.BindString;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.Viewable.MoviesView;
import co.minphone.happyonlinecinematicket.adapter.ComingMovieAdapter;
import co.minphone.happyonlinecinematicket.adapter.TodayMovieAdapter;
import co.minphone.happyonlinecinematicket.mvp.BaseActivity;
import co.minphone.happyonlinecinematicket.mvp.BaseNavigationActivity;
import co.minphone.happyonlinecinematicket.presenter.MoviesPresenter;
import co.minphone.happyonlinecinematicket.utilities.ItemViewOnClickListener;
import dagger.android.AndroidInjection;

public class MoviesActivity extends BaseNavigationActivity<MoviesPresenter> implements MoviesView<MoviesPresenter> {

  @BindView(R.id.toolBar) Toolbar toolbar;
  @BindView(R.id.rv_today_movie_post) RecyclerView rvTodayMovie;
  @BindView(R.id.rv_coming_movie_post) RecyclerView rvComingMovie;
  @BindView(R.id.layout_today_movie) RelativeLayout layoutToday;
  @BindView(R.id.layout_coming_movie) RelativeLayout layoutComing;
  @BindView(R.id.progressBar) ProgressBar progressBar;

  @BindString(R.string.title_movies) String titleMovies;
  @BindString(R.string.heading_today_movie) String headingTodayMovies;
  @BindString(R.string.heading_coming_movie) String headingComingSoonMovie;
  @BindString(R.string.transition_movie_poster) String transition_movie_poster;
  @BindString(R.string.transition_movie_genre) String transition_movie_genre;
  @BindString(R.string.transition_movie_title) String transition_movie_title;
  @BindString(R.string.transition_movie_kind) String transition_movie_kind;
  @BindString(R.string.transition_movie_language) String transition_movie_Lang;

  private TodayMovieAdapter todayMovieAdapter;
  private ComingMovieAdapter comingMovieAdapter;
  private ActionBar actionBar;

  public static void start(Context context) {
    Intent starter = new Intent(context, MoviesActivity.class);
    context.startActivity(starter);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    AndroidInjection.inject(this);
    super.onCreate(savedInstanceState);
    setUpToolBar();
    setUpTodayMovie();
    setUpComingSoonMovie();
    presenter.test();
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_movies;
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_cinema, menu);
    return true;
  }

  private void setUpToolBar() {
    setSupportActionBar(toolbar);
    actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
      actionBar.setTitle(headingTodayMovies);
    }
  }

  private void setUpComingSoonMovie() {
    comingMovieAdapter = new ComingMovieAdapter(new ItemViewOnClickListener() {
      @Override public void onItemClick(int position, View onClickView) {
        View ivMoviePoster = onClickView.findViewById(R.id.iv_movie_poster);
        View tvMovieTitle = onClickView.findViewById(R.id.tv_movie_title);
        View rvGenre = onClickView.findViewById(R.id.rv_genre);
        View tvType = onClickView.findViewById(R.id.tv_movie_type);
        View tvLang = onClickView.findViewById(R.id.tv_movie_language);

        Pair<View, String> transition_image =
            Pair.create((View) ivMoviePoster, transition_movie_poster);
        Pair<View, String> transition_title =
            Pair.create((View) tvMovieTitle, transition_movie_title);
        Pair<View, String> transition_genre =
            Pair.create((View) rvGenre, transition_movie_genre);
        Pair<View, String> transition_kind =
            Pair.create((View) tvType, transition_movie_kind);
        Pair<View, String> transition_Lang =
            Pair.create((View) tvLang, transition_movie_Lang);
        ActivityOptionsCompat optionsCompat =
            ActivityOptionsCompat.makeSceneTransitionAnimation(MoviesActivity.this,
                transition_image, transition_genre, transition_title, transition_kind,
                transition_Lang);

        MovieDetailsActivity.start(MoviesActivity.this, optionsCompat);
      }
    });
    rvComingMovie.setAdapter(comingMovieAdapter);
    rvComingMovie.setLayoutManager(
        new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
  }

  private void setUpTodayMovie() {
    todayMovieAdapter = new TodayMovieAdapter(new ItemViewOnClickListener() {
      @Override public void onItemClick(int position, View onClickView) {
        View ivMoviePoster = onClickView.findViewById(R.id.iv_movie_poster);
        View tvMovieTitle = onClickView.findViewById(R.id.tv_movie_title);
        View rvGenre = onClickView.findViewById(R.id.rv_genre);
        View tvType = onClickView.findViewById(R.id.tv_movie_type);
        View tvLang = onClickView.findViewById(R.id.tv_movie_language);

        Pair<View, String> transition_image =
            Pair.create((View) ivMoviePoster, transition_movie_poster);
        Pair<View, String> transition_title =
            Pair.create((View) tvMovieTitle, transition_movie_title);
        Pair<View, String> transition_genre =
            Pair.create((View) rvGenre, transition_movie_genre);
        Pair<View, String> transition_kind =
            Pair.create((View) tvType, transition_movie_kind);
        Pair<View, String> transition_Lang =
            Pair.create((View) tvLang, transition_movie_Lang);
        ActivityOptionsCompat optionsCompat =
            ActivityOptionsCompat.makeSceneTransitionAnimation(MoviesActivity.this,
                transition_image, transition_genre, transition_title, transition_kind,
                transition_Lang);

        MovieDetailsActivity.start(MoviesActivity.this, optionsCompat);
      }
    });
    rvTodayMovie.setAdapter(todayMovieAdapter);
    rvTodayMovie.setLayoutManager(
        new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }
}
