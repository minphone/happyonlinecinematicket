package co.minphone.happyonlinecinematicket.viewholder;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.core.BaseViewHolder;
import co.minphone.happyonlinecinematicket.model.GenreModel;

/**
 * Created by MinPhone on 3/18/18.
 */

public class GenreHolder extends BaseViewHolder<GenreModel> {

  @BindView(R.id.tv_genre) TextView tvGenre;

  public GenreHolder(View itemView) {
    super(itemView);
  }

  @Override public void bindData(GenreModel data) {

  }

  public void removeSeparator() {
    tvGenre.setBackground(null);
  }
}
