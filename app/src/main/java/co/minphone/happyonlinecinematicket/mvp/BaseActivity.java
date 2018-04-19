package co.minphone.happyonlinecinematicket.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import co.minphone.happyonlinecinematicket.mvp.contract.Presentable;
import co.minphone.happyonlinecinematicket.mvp.contract.Viewable;
import javax.inject.Inject;

/**
 * Created by MinPhone on 3/16/18.
 */

public abstract class BaseActivity<T extends Presentable> extends AppCompatActivity implements
    Viewable<T> {

  protected T presenter;

  @Inject @Override public void injectPresenter(T presenter) {
    this.presenter = presenter;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutId());
    ButterKnife.bind(this);
    getPresenter().attachView(this);
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
}
