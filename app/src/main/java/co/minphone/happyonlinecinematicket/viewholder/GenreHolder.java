package co.minphone.happyonlinecinematicket.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.data.network.model.GenreVO;
import co.minphone.happyonlinecinematicket.view.BaseViewHolder;
import co.minphone.happyonlinecinematicket.utilities.ItemViewOnClickListener;

/**
 * Created by MinPhone on 3/18/18.
 */

public class GenreHolder extends BaseViewHolder<GenreVO> {

  @BindView(R.id.tv_genre) TextView tvGenre;

  public GenreHolder(View itemView, @Nullable
      ItemViewOnClickListener itemViewOnClickListener) {
    super(itemView, itemViewOnClickListener);
  }

  @Override public void bindData(GenreVO data) {
    tvGenre.setText(data.getName());
  }

  public void removeSeparator() {
    tvGenre.setBackground(null);
  }
}
