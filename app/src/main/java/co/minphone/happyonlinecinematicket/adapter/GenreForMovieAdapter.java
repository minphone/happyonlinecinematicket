package co.minphone.happyonlinecinematicket.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.core.BaseRecyclerViewAdapter;
import co.minphone.happyonlinecinematicket.model.GenreModel;
import co.minphone.happyonlinecinematicket.viewholder.GenreHolder;

/**
 * Created by MinPhone on 3/18/18.
 */

public class GenreForMovieAdapter extends BaseRecyclerViewAdapter<GenreModel, GenreHolder> {
  @NonNull @Override
  public GenreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new GenreHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_genre, parent, false),
        itemViewOnClickListener);
  }

  @Override public void onBindViewHolder(GenreHolder holder, int position) {
    if (position == getItemCount() - 1) {
      holder.removeSeparator();
    }
  }

  @Override public int getItemCount() {
    return 3;
  }
}
