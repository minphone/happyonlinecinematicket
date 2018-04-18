package co.minphone.happyonlinecinematicket.core;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife;
import co.minphone.happyonlinecinematicket.utilities.ItemViewOnClickListener;

/**
 * Created by MinPhone on 3/18/18.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder
    implements OnClickListener {

  @Nullable protected ItemViewOnClickListener itemViewOnClickListener;

  public BaseViewHolder(final View itemView,
      @Nullable final ItemViewOnClickListener itemViewOnClickListener) {
    super(itemView);
    ButterKnife.bind(this, itemView);
    this.itemViewOnClickListener = itemViewOnClickListener;
    itemView.setOnClickListener(this);
  }

  @Override public void onClick(View v) {

  }

  public abstract void bindData(T data);
}
