package co.minphone.happyonlinecinematicket.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.core.BaseRecyclerViewAdapter;
import co.minphone.happyonlinecinematicket.model.MovieModel;
import co.minphone.happyonlinecinematicket.viewholder.MovieHolder;

/**
 * Created by MinPhone on 3/18/18.
 */

public class TodayMovieAdapter extends BaseRecyclerViewAdapter<MovieModel, MovieHolder> {

  @NonNull @Override public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new MovieHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false));
  }

  @Override public void onBindViewHolder(MovieHolder holder, int position) {
    holder.bindData(null);
  }

  @Override public int getItemCount() {
    return 5;
  }
}