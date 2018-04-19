package co.minphone.happyonlinecinematicket.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
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

  @Override public void renderData(final Boolean aBoolean) {
    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        if (aBoolean) {
          MoviesActivity.start(SplashActivity.this);
        } else {
          LogInActivity.start(SplashActivity.this);
        }
      }
    }, 3000);

    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        ObjectAnimator iconAni = ObjectAnimator.ofFloat(ivAppIcon, "translationY", 0, -200f);
        iconAni.setDuration(1500);

        ObjectAnimator txtAni = ObjectAnimator.ofFloat(tvAppIcon, "translationY", 0, 200f);
        txtAni.setDuration(1500);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(iconAni, txtAni);
        set.start();
      }
    }, 500);
  }

  @Override public void renderError(String message) {

  }
}
