package co.minphone.happyonlinecinematicket.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.data.network.model.MovieVO;
import co.minphone.happyonlinecinematicket.utilities.ItemViewOnClickListener;
import co.minphone.happyonlinecinematicket.view.BaseRecyclerViewAdapter;
import co.minphone.happyonlinecinematicket.viewholder.MovieHolder;

/**
 * Created by MinPhone on 3/18/18.
 */

public class TodayMovieAdapter extends BaseRecyclerViewAdapter<MovieVO, MovieHolder> {

  private ItemViewOnClickListener itemViewOnClickListener;

  public TodayMovieAdapter(
      ItemViewOnClickListener itemViewOnClickListener) {
    super(itemViewOnClickListener);
    this.itemViewOnClickListener = itemViewOnClickListener;
  }

  @NonNull @Override
  public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new MovieHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false),
        itemViewOnClickListener);
  }
}
