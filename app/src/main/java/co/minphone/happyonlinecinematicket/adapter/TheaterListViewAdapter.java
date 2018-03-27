package co.minphone.happyonlinecinematicket.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.core.BaseRecyclerViewAdapter;
import co.minphone.happyonlinecinematicket.model.TheaterModel;
import co.minphone.happyonlinecinematicket.viewholder.TheaterListViewHolder;

/**
 * Created by MinPhone on 3/25/18.
 */

public class TheaterListViewAdapter
    extends BaseRecyclerViewAdapter<TheaterModel, TheaterListViewHolder> {

  @NonNull @Override
  public TheaterListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new TheaterListViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_theater_listview, parent, false));
  }

  @Override public void onBindViewHolder(TheaterListViewHolder holder, int position) {
  }

  @Override public int getItemCount() {
    return 5;
  }
}
