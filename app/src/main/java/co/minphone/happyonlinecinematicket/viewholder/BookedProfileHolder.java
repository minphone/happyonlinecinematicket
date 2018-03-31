package co.minphone.happyonlinecinematicket.viewholder;

import android.support.annotation.Nullable;
import android.view.View;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.core.BaseViewHolder;
import co.minphone.happyonlinecinematicket.utilities.ItemViewOnClickListener;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by MinPhone on 3/25/18.
 */

public class BookedProfileHolder extends BaseViewHolder<String> {

  @BindView(R.id.iv_booked_profile) public CircleImageView ivBookedProfile;

  public BookedProfileHolder(View itemView, @Nullable
      ItemViewOnClickListener itemViewOnClickListener) {
    super(itemView, itemViewOnClickListener);
  }

  @Override public void bindData(String data) {

  }
}
