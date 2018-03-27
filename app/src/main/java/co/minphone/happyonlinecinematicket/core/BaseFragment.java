package co.minphone.happyonlinecinematicket.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * Created by MinPhone on 3/16/18.
 */

public abstract class BaseFragment extends Fragment {

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(getLayoutId(), container, false);
    ButterKnife.bind(this,view);
    setUpLayout();
    return view;
  }

  protected abstract void setUpLayout();

  protected abstract int getLayoutId();
}
