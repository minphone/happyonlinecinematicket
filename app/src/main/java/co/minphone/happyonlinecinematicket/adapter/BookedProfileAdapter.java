package co.minphone.happyonlinecinematicket.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.core.BaseRecyclerViewAdapter;
import co.minphone.happyonlinecinematicket.viewholder.BookedProfileHolder;

/**
 * Created by MinPhone on 3/25/18.
 */

public class BookedProfileAdapter extends BaseRecyclerViewAdapter<String, BookedProfileHolder> {
  @NonNull @Override
  public BookedProfileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new BookedProfileHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_booked_profile, parent, false));
  }

  @Override public void onBindViewHolder(BookedProfileHolder holder, int position) {

  }

  @Override public int getItemCount() {
    return 3;
  }
}
