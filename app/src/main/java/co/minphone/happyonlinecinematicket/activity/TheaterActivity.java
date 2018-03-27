package co.minphone.happyonlinecinematicket.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import co.minphone.happyonlinecinematicket.core.BaseNavigationView;
import co.minphone.happyonlinecinematicket.fragment.ListViewTheaterFragment;

/**
 * Created by MinPhone on 3/25/18.
 */

public class TheaterActivity extends BaseNavigationView {

  @BindView(R.id.toolBar) Toolbar toolbar;
  @BindView(R.id.layout_theater) FrameLayout layoutTheater;

  @BindString(R.string.heading_movie_theater) String headingMovieTheater;

  private ActionBar actionBar;

  public static void start(Context context) {
    Intent starter = new Intent(context, TheaterActivity.class);
    context.startActivity(starter);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setUpToolBar();
    setUpLayout();
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_theater;
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
}