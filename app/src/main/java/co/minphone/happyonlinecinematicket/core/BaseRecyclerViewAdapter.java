package co.minphone.happyonlinecinematicket.core;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import co.minphone.happyonlinecinematicket.utilities.ItemViewOnClickListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MinPhone on 3/18/18.
 */

public abstract class BaseRecyclerViewAdapter<W, T extends BaseViewHolder<W>>
    extends RecyclerView.Adapter<T> {

  private List<W> dataList;
  @Nullable protected ItemViewOnClickListener itemViewOnClickListener;

  public BaseRecyclerViewAdapter() {
    dataList = new ArrayList<>();
  }

  public BaseRecyclerViewAdapter(
      ItemViewOnClickListener itemViewOnClickListener) {
    this.itemViewOnClickListener = itemViewOnClickListener;
  }

  @Override public void onBindViewHolder(T holder, int position) {
    holder.bindData(dataList.get(position));
  }

  @Override public int getItemCount() {
    return dataList.size();
  }

  public void setDataList(List<W> dataList) {
    this.dataList = dataList;
    notifyDataSetChanged();
  }

  public void addDataLists(List<W> dataList) {
    this.dataList.addAll(dataList);
    notifyDataSetChanged();
  }

  public void addData(W data) {
    this.dataList.add(data);
    notifyDataSetChanged();
  }
}
