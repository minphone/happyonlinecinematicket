package co.minphone.happyonlinecinematicket.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import co.minphone.happyonlinecinematicket.mvp.contract.Presentable;
import co.minphone.happyonlinecinematicket.mvp.contract.Viewable;
import javax.inject.Inject;

/**
 * Created by MinPhone on 3/16/18.
 */

public abstract class BaseFragment<T extends Presentable> extends Fragment implements Viewable<T> {

  private T presenter;

  @Inject @Override public void injectPresenter(T presenter) {
    this.presenter = presenter;
  }

  @Override public void onAttach(Context context) {
    super.onAttach(context);
    getPresenter().attachView(this);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(getLayoutId(), container, false);
    ButterKnife.bind(this, view);
    setUpLayout();
    getPresenter().onCreatedView();
    return view;
  }

  @Override public void onStart() {
    super.onStart();
    getPresenter().onStart();
  }

  @Override public void onResume() {
    super.onResume();
    getPresenter().onResume();
  }

  @Override public void onPause() {
    super.onPause();
    getPresenter().onPause();
  }

  @Override public void onStop() {
    super.onStop();
    getPresenter().onStop();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    presenter = null;
  }

  @Override public T getPresenter() {
    return presenter;
  }

  protected abstract void setUpLayout();

  protected abstract int getLayoutId();
}
