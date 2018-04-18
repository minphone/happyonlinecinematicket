package co.minphone.happyonlinecinematicket.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.core.BaseRecyclerViewAdapter;
import co.minphone.happyonlinecinematicket.viewholder.ShowTimeHolder;

public class ShowTimeAdapter extends BaseRecyclerViewAdapter<String, ShowTimeHolder> {
  @NonNull @Override
  public ShowTimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ShowTimeHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_showtime, parent, false),
        null);
  }

  @Override public void onBindViewHolder(ShowTimeHolder holder, int position) {
  }

  @Override public int getItemCount() {
    return 5;
  }
}
