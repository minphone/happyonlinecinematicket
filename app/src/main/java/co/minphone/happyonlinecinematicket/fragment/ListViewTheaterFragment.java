package co.minphone.happyonlinecinematicket.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.adapter.TheaterListViewAdapter;
import co.minphone.happyonlinecinematicket.mvp.BaseFragment;

/**
 * Created by MinPhone on 3/25/18.
 */

public class ListViewTheaterFragment extends BaseFragment {

  @BindView(R.id.rv_theater) RecyclerView rvTheater;

  private TheaterListViewAdapter adapter;

  public static ListViewTheaterFragment getInstance() {
    return new ListViewTheaterFragment();
  }

  @Override protected void setUpLayout() {
    setUpRecyclerView();
  }

  @Override protected int getLayoutId() {
    return R.layout.fragment_theater_listview;
  }

  private void setUpRecyclerView() {
    adapter = new TheaterListViewAdapter();
    rvTheater.setAdapter(adapter);
    rvTheater.setLayoutManager(
        new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
  }

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

  }
}
