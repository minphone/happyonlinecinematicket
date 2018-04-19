package co.minphone.happyonlinecinematicket.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.FrameLayout;
import butterknife.BindString;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.Viewable.CinemaView;
import co.minphone.happyonlinecinematicket.mvp.BaseNavigationActivity;
import co.minphone.happyonlinecinematicket.fragment.ListViewTheaterFragment;
import co.minphone.happyonlinecinematicket.presenter.CinemaPresenter;
import dagger.android.AndroidInjection;

/**
 * Created by MinPhone on 3/25/18.
 */

public class CinemaActivity extends BaseNavigationActivity<CinemaPresenter>
    implements CinemaView<CinemaPresenter> {

  @BindView(R.id.toolBar) Toolbar toolbar;
  @BindView(R.id.layout_theater) FrameLayout layoutTheater;

  @BindString(R.string.heading_movie_theater) String headingMovieTheater;

  private ActionBar actionBar;

  public static void start(Context context) {
    Intent starter = new Intent(context, CinemaActivity.class);
    context.startActivity(starter);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    AndroidInjection.inject(this);
    super.onCreate(savedInstanceState);
    setUpToolBar();
    setUpLayout();
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_cinema;
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_theater, menu);
    return true;
  }

  private void setUpLayout() {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    fragmentTransaction.replace(R.id.layout_theater, ListViewTheaterFragment.getInstance());
    fragmentTransaction.commit();
  }

  private void setUpToolBar() {
    setSupportActionBar(toolbar);
    actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
      actionBar.setTitle(headingMovieTheater);
    }
  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }
}
