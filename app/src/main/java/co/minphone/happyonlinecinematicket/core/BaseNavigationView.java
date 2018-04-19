package co.minphone.happyonlinecinematicket.core;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.activity.CinemaActivity;
import co.minphone.happyonlinecinematicket.activity.MoviesActivity;
import co.minphone.happyonlinecinematicket.mvp.BaseActivity;

/**
 * Created by MinPhone on 3/25/18.
 */

public abstract class BaseNavigationView extends BaseActivity {

  @Nullable @BindView(R.id.navigationView) NavigationView navigationView;
  @Nullable @BindView(R.id.drawerLayout) DrawerLayout drawerLayout;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setUpNavigationView();
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        drawerLayout.openDrawer(GravityCompat.START);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void setUpNavigationView() {
    navigationView.setNavigationItemSelectedListener(
        new NavigationView.OnNavigationItemSelectedListener() {
          @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
              case R.id.nav_movies:
                MoviesActivity.start(navigationView.getContext());
                finish();
                break;
              case R.id.nav_theater:
                CinemaActivity.start(navigationView.getContext());
                finish();
                break;
            }
            drawerLayout.closeDrawers();
            return true;
          }
        });
  }
}
