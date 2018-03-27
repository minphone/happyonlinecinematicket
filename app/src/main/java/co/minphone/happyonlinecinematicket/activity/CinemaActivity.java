package co.minphone.happyonlinecinematicket.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import butterknife.BindString;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.adapter.ComingMovieAdapter;
import co.minphone.happyonlinecinematicket.adapter.TodayMovieAdapter;
import co.minphone.happyonlinecinematicket.core.BaseActivity;
import co.minphone.happyonlinecinematicket.core.BaseNavigationView;

public class CinemaActivity extends BaseNavigationView {

  @BindView(R.id.toolBar) Toolbar toolbar;
  @BindView(R.id.rv_today_movie_post) RecyclerView rvTodayMovie;
  @BindView(R.id.rv_coming_movie_post) RecyclerView rvComingMovie;
  @BindView(R.id.layout_today_movie) RelativeLayout layoutToday;
  @BindView(R.id.layout_coming_movie) RelativeLayout layoutComing;
  @BindView(R.id.progressBar) ProgressBar progressBar;

  @BindString(R.string.title_movies) String titleMovies;
  @BindString(R.string.heading_today_movie) String headingTodayMovies;
  @BindString(R.string.heading_coming_movie) String headingComingSoonMovie;

  private TodayMovieAdapter todayMovieAdapter;
  private ComingMovieAdapter comingMovieAdapter;
  private ActionBar actionBar;

  public static void start(Context context) {
    Intent starter = new Intent(context, CinemaActivity.class);
    context.startActivity(starter);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setUpToolBar();
    setUpTodayMovie();
    setUpComingSoonMovie();
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_cinema;
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
    comingMovieAdapter = new ComingMovieAdapter();
    rvComingMovie.setAdapter(comingMovieAdapter);
    rvComingMovie.setLayoutManager(
        new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
  }

  private void setUpTodayMovie() {
    todayMovieAdapter = new TodayMovieAdapter();
    rvTodayMovie.setAdapter(todayMovieAdapter);
    rvTodayMovie.setLayoutManager(
        new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
  }
}
