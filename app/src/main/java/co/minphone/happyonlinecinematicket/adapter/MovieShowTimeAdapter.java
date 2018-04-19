package co.minphone.happyonlinecinematicket.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.view.BaseRecyclerViewAdapter;
import co.minphone.happyonlinecinematicket.viewholder.MovieShowTimeHolder;

public class MovieShowTimeAdapter extends BaseRecyclerViewAdapter<String, MovieShowTimeHolder> {

  @NonNull @Override
  public MovieShowTimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new MovieShowTimeHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_movie_showtime, parent, false), null);
  }

  @Override public void onBindViewHolder(MovieShowTimeHolder holder, int position) {
    // TODO: 4/12/18 Need to change when API Implement
    holder.bindData(null);
  }

  @Override public int getItemCount() {
    return 5;
  }
}
