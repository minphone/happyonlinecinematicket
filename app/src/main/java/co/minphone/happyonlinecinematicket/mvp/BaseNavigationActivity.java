package co.minphone.happyonlinecinematicket.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.activity.CinemaActivity;
import co.minphone.happyonlinecinematicket.activity.MoviesActivity;
import co.minphone.happyonlinecinematicket.mvp.contract.Presentable;
import co.minphone.happyonlinecinematicket.mvp.contract.Viewable;
import javax.inject.Inject;

/**
 * Created by MinPhone on 3/25/18.
 */

public abstract class BaseNavigationActivity<T extends Presentable> extends
    AppCompatActivity implements Viewable<T> {

  @BindView(R.id.navigationView) NavigationView navigationView;
  @BindView(R.id.drawerLayout) DrawerLayout drawerLayout;

  protected T presenter;

  @Inject @Override public void injectPresenter(T presenter) {
    this.presenter = presenter;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
    ButterKnife.bind(this);
    getPresenter().attachView(this);
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

  @Override protected void onStart() {
    super.onStart();
    getPresenter().onStart();
  }

  @Override protected void onResume() {
    super.onResume();
    getPresenter().onResume();
  }

  @Override protected void onPause() {
    super.onPause();
    getPresenter().onPause();
  }

  @Override protected void onStop() {
    super.onStop();
    getPresenter().onStop();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter = null;
  }

  @Override public T getPresenter() {
    return presenter;
  }

  protected abstract int getLayoutId();

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
