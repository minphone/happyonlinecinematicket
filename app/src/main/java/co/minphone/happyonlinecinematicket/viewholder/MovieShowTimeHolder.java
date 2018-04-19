package co.minphone.happyonlinecinematicket.viewholder;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.adapter.ShowTimeAdapter;
import co.minphone.happyonlinecinematicket.view.BaseViewHolder;
import co.minphone.happyonlinecinematicket.utilities.ItemViewOnClickListener;

public class MovieShowTimeHolder extends BaseViewHolder<String> {

  @BindView(R.id.rv_showTime) RecyclerView rvShowTime;

  private ShowTimeAdapter showTimeAdapter;

  public MovieShowTimeHolder(View itemView,
      @Nullable ItemViewOnClickListener itemViewOnClickListener) {
    super(itemView, itemViewOnClickListener);
    setUpShowTime();
  }

  @Override public void bindData(String data) {

  }

  private void setUpShowTime() {
    showTimeAdapter = new ShowTimeAdapter();
    rvShowTime.setAdapter(showTimeAdapter);
    rvShowTime.setLayoutManager(
        new GridLayoutManager(itemView.getContext(), 3, LinearLayoutManager.VERTICAL, false));
  }
}
