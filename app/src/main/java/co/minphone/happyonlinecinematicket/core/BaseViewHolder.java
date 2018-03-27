package co.minphone.happyonlinecinematicket.core;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.ButterKnife;

/**
 * Created by MinPhone on 3/18/18.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

  public BaseViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }

  public abstract void bindData(T data);
}
