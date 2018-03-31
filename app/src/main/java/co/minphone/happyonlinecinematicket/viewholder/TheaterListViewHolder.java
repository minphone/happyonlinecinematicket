package co.minphone.happyonlinecinematicket.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import co.minphone.happyonlinecinematicket.core.BaseViewHolder;
import co.minphone.happyonlinecinematicket.model.TheaterModel;
import co.minphone.happyonlinecinematicket.utilities.ItemViewOnClickListener;

/**
 * Created by MinPhone on 3/25/18.
 */

public class TheaterListViewHolder extends BaseViewHolder<TheaterModel> {

  public TheaterListViewHolder(View itemView, @Nullable
      ItemViewOnClickListener itemViewOnClickListener) {
    super(itemView, itemViewOnClickListener);
  }

  @Override public void bindData(TheaterModel data) {

  }
}
