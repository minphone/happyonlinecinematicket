package co.minphone.happyonlinecinematicket.core;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.ButterKnife;
import co.minphone.happyonlinecinematicket.utilities.ItemViewOnClickListener;

/**
 * Created by MinPhone on 3/18/18.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

  @Nullable protected ItemViewOnClickListener itemViewOnClickListener;

  public BaseViewHolder(View itemView, @Nullable ItemViewOnClickListener itemViewOnClickListener) {
    super(itemView);
    ButterKnife.bind(this, itemView);
    this.itemViewOnClickListener = itemViewOnClickListener;
  }

  public abstract void bindData(T data);
}
