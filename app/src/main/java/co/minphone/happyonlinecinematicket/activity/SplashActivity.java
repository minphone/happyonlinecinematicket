package co.minphone.happyonlinecinematicket.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.Viewable.SplashView;
import co.minphone.happyonlinecinematicket.mvp.BaseActivity;
import co.minphone.happyonlinecinematicket.presenter.SplashPresenter;
import dagger.android.AndroidInjection;

public class SplashActivity extends BaseActivity<SplashPresenter>
    implements SplashView<SplashPresenter> {

  @BindView(R.id.iv_app_icon) ImageView ivAppIcon;
  @BindView(R.id.tv_app_title) TextView tvAppIcon;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    AndroidInjection.inject(this);
    super.onCreate(savedInstanceState);
  }

  @Override protected int getLayoutId() {
    return R.layout.activity_splash;
  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }

  @Override public void renderData(Boolean aBoolean) {
    if (aBoolean) {
      MoviesActivity.start(this);
    } else {
      LogInActivity.start(this);
    }
  }

  @Override public void renderError(String message) {

  }
}
