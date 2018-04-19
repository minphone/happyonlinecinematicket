package co.minphone.happyonlinecinematicket.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.view.BaseViewHolder;
import co.minphone.happyonlinecinematicket.model.GenreModel;
import co.minphone.happyonlinecinematicket.utilities.ItemViewOnClickListener;

/**
 * Created by MinPhone on 3/18/18.
 */

public class GenreHolder extends BaseViewHolder<GenreModel> {

  @BindView(R.id.tv_genre) TextView tvGenre;

  public GenreHolder(View itemView, @Nullable
      ItemViewOnClickListener itemViewOnClickListener) {
    super(itemView, itemViewOnClickListener);
  }

  @Override public void bindData(GenreModel data) {

  }

  public void removeSeparator() {
    tvGenre.setBackground(null);
  }
}
