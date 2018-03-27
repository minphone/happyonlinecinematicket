package co.minphone.happyonlinecinematicket.viewholder;

import android.view.View;
import butterknife.BindView;
import co.minphone.happyonlinecinematicket.R;
import co.minphone.happyonlinecinematicket.core.BaseViewHolder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by MinPhone on 3/25/18.
 */

public class BookedProfileHolder extends BaseViewHolder<String> {

  @BindView(R.id.iv_booked_profile) public CircleImageView ivBookedProfile;

  public BookedProfileHolder(View itemView) {
    super(itemView);
  }

  @Override public void bindData(String data) {

  }
}
